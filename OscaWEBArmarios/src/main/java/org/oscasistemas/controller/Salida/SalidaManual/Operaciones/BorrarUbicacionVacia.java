package org.oscasistemas.controller.Salida.SalidaManual.Operaciones;

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
import javax.xml.ws.soap.SOAPFaultException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Portátil1 on 15/02/2018.
 */
@RestController
public class BorrarUbicacionVacia {

    @Autowired(required = true)
    private IEntablado entabladoService; //shelf service
    @Autowired
    private ICajaEntablado locationService; //box service


    /**
     *
     * @param request
     * @param entablado
     * @param fila
     * @param columna
     * @return
     * @throws Exception
     */
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/BorrarUbicacionVacia", method = RequestMethod.GET)
    public @ResponseBody
    String BorrarUbicacionVacia(HttpServletRequest request,
                       @NotNull @RequestParam(value = "entablado", required = true, defaultValue = "-1") String entablado,
                       @NotNull @RequestParam(value = "xPos", required = true, defaultValue = "-1") int fila,
                       @NotNull @RequestParam(value = "yPos", required = true, defaultValue = "-1") int columna){
        Entablado e = entabladoService.getEstanteria(entablado);
        CajaEntablado c = locationService.getCajasEntablado(e, fila, columna);
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
            //desmarcar posicion fija en nav
        BinContentWS contenidoNav = getContenidoUbi(c.getEntablado().getCodigo()
                    , c.getArticulo());
        contenidoNav.setFixed(false);

        try {
            WebServicesInit.contenidoUbicacionService.delete(contenidoNav.getKey());
        }catch(SOAPFaultException ex){
            ex.printStackTrace();
            return "error:"+ex.getMessage();
        }

        try {
            //delete box
            borrarCaja(c);
        } catch (SQLException e1) {
            e1.printStackTrace();
            return "error:"+e1.getMessage();
        }
        //locationService.removeCajaEntablado(c);
        //e.setHuecosLibres(e.getHuecosLibres() + c.getTipoCaja().getNum_huecos());
       // entabladoService.addOrUpdateCajaEntablado(e);

        //añadir al historico
        Historico h = new Historico();
        h.setId_historico(1);
        h.setLanzadera(e.getLanzadera());
        h.setEntablado(e);
        h.setFila(fila);
        h.setColumna(columna);
        TipoMovimiento tm = new TipoMovimiento();
        tm.setId_tipoMovimiento(4);
        h.setTipoMovimiento(tm);
        // h.setArticulo(c.getArticulo());
        h.setCantidad(0);
        try {
            crearHistorio(h);
        } catch (SQLException e1) {
            e1.printStackTrace();
            return "error:"+e1.getMessage();
        }

        return new Gson().toJson("OK");
    }


    /**
     * return the bin content info
     * @param codigo
     * @param articulo
     * @return
     */
    private BinContentWS getContenidoUbi(String codigo,String articulo){
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
        if(resultado==null )return  null;
        else if(resultado.getBinContentWS().isEmpty()) return null;
        else return resultado.getBinContentWS().get(0);
    }

    /**
     * Delete box
     * @param ubicacion
     * @throws SQLException
     */
    private void borrarCaja(CajaEntablado ubicacion) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.2.2:3306/osca_localizacion", "osca", "osca");
            String insertTableSQL = "DELETE  FROM cajas_entablado WHERE Codigo=? AND fila=? AND columna=?;";
            preparedStatement = conn.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, ubicacion.getEntablado().getCodigo());
            preparedStatement.setInt(2, ubicacion.getFila());
            preparedStatement.setInt(3, ubicacion.getColumna());
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

    /**
     * Create historic regist
     * @param h
     * @throws SQLException
     */
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
