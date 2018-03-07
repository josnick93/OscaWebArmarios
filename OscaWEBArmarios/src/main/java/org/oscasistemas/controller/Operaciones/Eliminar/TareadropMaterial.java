package org.oscasistemas.controller.Operaciones.Eliminar;

import com.dynamics.webServices.Bin_Content_WS.BinContentWS;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFields;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFilter;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSList;
import com.sun.istack.internal.NotNull;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.DAO.interfaces.ITareasPendientes;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Holder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 26/12/2017.
 */
@RestController
public class TareadropMaterial {

    @Autowired(required = true)
    private IEntablado entabladoService;
    @Autowired
    private ICajaEntablado locationService;

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;


    @Autowired
    private ITareasPendientes tareasPendientesService;

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/TareadropMaterial", method = RequestMethod.GET)
    public @ResponseBody
    String tareaExtraerMaterial(HttpServletRequest request,
                                @NotNull @RequestParam(value = "entablado", required = true, defaultValue = "00.000.0090") String entablado,
                                @NotNull @RequestParam(value = "fila", required = true, defaultValue = "-1") int fila,
                                @NotNull @RequestParam(value = "columna", required = true, defaultValue = "-1") int columna,
                                @NotNull @RequestParam(value = "cantidad", required = true, defaultValue = "-1") int cantidad,
                                @NotNull @RequestParam(value = "idTarea", required = true, defaultValue = "-1") int tarea) throws Exception {
        /*
         * Dir ip peticion
         */
        Entablado e = entabladoService.getEstanteria(entablado);
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

       // WebServicesInit.functionsService.createMovement("OSCA","SERWEB","",articulo,"",
        //        "", BigInteger.valueOf(cantidad),"UDS",entablado,destino);
        // Entablado e=entabladoService.getEstanteria(l,entablado);

        CajaEntablado c = locationService.getCajasEntablado(e, fila, columna);
        //peso entablado
        //huecos entablado

        if (c != null) {
            //e.setPesoActual(e.getPesoActual()-(c.getArticulo().getPeso()*cantidad));
            if (c.getCantidad() - cantidad == 0)
                c.setEsVacia((byte) 1);
            c.setCantidad(c.getCantidad() - cantidad);
            //c.setPeso(c.getPeso()- (c.getArticulo().getPeso()*cantidad));
            //actualizarCantidad(c);
            locationService.addOrUpdateCajaEntablado(c);
            //añadir al historico
            Historico h = new Historico();
            h.setId_historico(1);
            h.setLanzadera(e.getLanzadera());
            h.setEntablado(e);
            h.setFila(columna);
            h.setColumna(fila);
            TipoMovimiento tm = new TipoMovimiento();
            tm.setId_tipoMovimiento(2);
            h.setTipoMovimiento(tm);
            h.setArticulo(c.getArticulo());
            h.setCantidad(cantidad);
            crearHistorio(h);

        } else {
            CajaEntabladoMedida c1 = cajaEntabladoMedidaService.getCajasEntablado(e, fila, columna);
            //e.setPesoActual(e.getPesoActual()-(c1.getArticulo().getPeso()*cantidad));
            if (c1.getCantidad() - cantidad == 0)
                c1.setEsVacia((byte) -1);
            c1.setCantidad(c1.getCantidad() - cantidad);
            //c1.setPeso(c1.getPeso()- (c1.getArticulo().getPeso()*cantidad));
            //actualizarCantidad(c1);
            cajaEntabladoMedidaService.addOrUpdateCajaEntablado(c1);
            //añadir al historico
            Historico h = new Historico();
            h.setId_historico(1);
            h.setLanzadera(e.getLanzadera());
            h.setEntablado(e);
            h.setFila(columna);
            h.setColumna(fila);
            TipoMovimiento tm = new TipoMovimiento();
            tm.setId_tipoMovimiento(2);
            h.setTipoMovimiento(tm);
            h.setArticulo(c1.getArticulo());
            h.setCantidad(cantidad);
            crearHistorio(h);


        }

        tareasPendientesService.remove(tareasPendientesService.getTareaPendiente(tarea));
        entabladoService.addOrUpdateCajaEntablado(e);
        JSONObject outputJsonObj = new JSONObject();
        outputJsonObj.put("res", "true");
        return outputJsonObj.toString();
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

}
