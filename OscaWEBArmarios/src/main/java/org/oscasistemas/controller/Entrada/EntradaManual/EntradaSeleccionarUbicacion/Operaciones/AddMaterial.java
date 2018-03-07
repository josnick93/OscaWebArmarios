package org.oscasistemas.controller.Entrada.EntradaManual.EntradaSeleccionarUbicacion.Operaciones;

import com.dynamics.webServices.Bin_Content_WS.BinContentWS;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFields;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFilter;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSList;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.CajaEntablado;
import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.Historico;
import org.oscasistemas.model.TipoMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Holder;
import javax.xml.ws.soap.SOAPFaultException;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 22/12/2017.
 */
@RestController
public class AddMaterial {

    @Autowired(required = true)
    private IEntablado entabladoService; //shelf query service
    @Autowired
    private ICajaEntablado locationService; //box query service


    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/addMaterial", method = RequestMethod.GET)
    public @ResponseBody
    String addMaterial(HttpServletRequest request,
                       @NotNull @RequestParam(value = "entablado", required = true, defaultValue = "PLNZ.00.0000") String entablado,
                       @NotNull @RequestParam(value = "fila", required = true, defaultValue = "-1") int fila,
                       @NotNull @RequestParam(value = "columna", required = true, defaultValue = "-1") int columna,
                       @NotNull @RequestParam(value = "articulo", required = true) String articulo,
                       @NotNull @RequestParam(value = "cantidad", required = true, defaultValue = "-1") int cantidad,
                       @NotNull @RequestParam(value = "origen", required = true, defaultValue = "-1") String origen){

        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        Entablado e = entabladoService.getEstanteria(entablado);


        try {
            //NAV WEB SERVICE MOVEMENT FROM SHELF TO OUTSIDE
            WebServicesInit.functionsService.createMovement("OSCA", "SERWEB", "", articulo, "",
                    "", BigInteger.valueOf(cantidad), "UDS", origen, entablado);
            //Poner ubicacion fija
            actualizarUbicacionFija(entablado,articulo);

        }catch(SOAPFaultException soapException){
            return "error:"+soapException.getMessage();
        }
        //peso entablado
        //huecos entablado
        CajaEntablado c = locationService.getCajasEntablado(e, fila, columna);
        //cantidad
        c.setCantidad(c.getCantidad() + cantidad);
        //c.setPeso(c.getPeso()+ (c.getArticulo().getPeso()*cantidad));
        //e.setPesoActual(e.getPesoActual() + (cantidad  * c.getArticulo().getPeso()));
        //actualizar caja
        //actualizarCantidad(c);
        locationService.addOrUpdateCajaEntablado(c);
        //añadir al historico
        Historico h = new Historico();
        h.setId_historico(5);
        h.setLanzadera(e.getLanzadera());
        h.setEntablado(e);
        h.setFila(fila);
        h.setColumna(columna);
        TipoMovimiento tm = new TipoMovimiento();
        //añadir material
        tm.setId_tipoMovimiento(5);
        h.setTipoMovimiento(tm);
        h.setArticulo(articulo);
        h.setCantidad(cantidad);
        try {
            crearHistorio(h);
        } catch (SQLException e1) {
            return "error:"+e1.getMessage();
        }
        //response json
        return new Gson().toJson("OK");
    }




    private void crearHistorio(Historico h) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.2.2:3306/osca_localizacion", "osca", "osca");
            String insertTableSQL = "INSERT INTO historico"
                    + "(Id_lanzadera, Codigo,Id_tipoMovimiento,usuario, fila, columna,Articulo,Cantidad,fecha) VALUES"
                    + "(?,?,?,?,?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, h.getLanzadera().getId_lanzadera());
            preparedStatement.setString(2, h.getEntablado().getCodigo());
            preparedStatement.setInt(3, h.getTipoMovimiento().getId_tipoMovimiento());
            preparedStatement.setString(4, h.getUsuario());
            preparedStatement.setInt(5, h.getFila());
            preparedStatement.setInt(6, h.getColumna());
            preparedStatement.setString(7, h.getArticulo());
            preparedStatement.setDouble(8, h.getCantidad());
            preparedStatement.setTimestamp(9, h.getFecha());
            preparedStatement.execute("SET foreign_key_checks = 0;");
            preparedStatement.executeUpdate();
            preparedStatement.execute("SET foreign_key_checks = 1;");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    private boolean actualizarUbicacionFija(String codigo, String articulo){
        List<BinContentWSFilter> filtros = new ArrayList<BinContentWSFilter>();
        BinContentWSFilter f1 = new BinContentWSFilter();
        f1.setField(BinContentWSFields.BIN_CODE);
        f1.setCriteria(codigo);
        filtros.add(f1);
        BinContentWSFilter f2 = new BinContentWSFilter();
        f2.setField(BinContentWSFields.ITEM_NO);
        f2.setCriteria(articulo);
        filtros.add(f2);
        BinContentWSList resultado= WebServicesInit.contenidoUbicacionService.readMultiple(filtros, "", 1);
        if(resultado==null )return  false;
        else if(resultado.getBinContentWS().isEmpty()) return false;
        else{
            BinContentWS contenido=resultado.getBinContentWS().get(0);
            contenido.setFixed(true);
            WebServicesInit.contenidoUbicacionService.update(new Holder<BinContentWS>(contenido));
            return true;
        }
    }

}
