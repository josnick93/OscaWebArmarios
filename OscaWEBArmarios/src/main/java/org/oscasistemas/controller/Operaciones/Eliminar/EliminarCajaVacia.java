package org.oscasistemas.controller.Operaciones.Eliminar;

import com.sun.istack.internal.NotNull;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.model.CajaEntablado;
import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.Historico;
import org.oscasistemas.model.TipoMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;

/**
 * Created by José Ángel Caudevílla Casaús on 22/12/2017.
 */
@RestController
public class EliminarCajaVacia {
    @Autowired(required = true)
    private IEntablado entabladoService;
    @Autowired
    private ICajaEntablado locationService;



    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/removerCajaVacia", method = RequestMethod.GET)
    public @ResponseBody
    String removerCaja(HttpServletRequest request,
                       @NotNull @RequestParam(value = "entablado", required = true, defaultValue = "-1") String entablado,
                       @NotNull @RequestParam(value = "xPos", required = true, defaultValue = "-1") int fila,
                       @NotNull @RequestParam(value = "yPos", required = true, defaultValue = "-1") int columna) throws Exception {
        //Entablado e=entabladoService.getEstanteria(l,entablado);
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
        //borrarCaja(c);
        borrarCaja(c);
        //locationService.removeCajaEntablado(c);
        //e.setHuecosLibres(e.getHuecosLibres() + c.getTipoCaja().getNum_huecos());
        entabladoService.addOrUpdateCajaEntablado(e);

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
        crearHistorio(h);

        JSONObject outputJsonObj = new JSONObject();
        outputJsonObj.put("res", "true");
        return outputJsonObj.toString();
    }


    /**
     * OPERACIONES SOBRE BD
     *
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
