package org.oscasistemas.controller.Operaciones.Editar;

import com.sun.istack.internal.NotNull;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.DAO.interfaces.IHistorico;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.sql.*;

/**
 * Created by Portátil1 on 22/12/2017.
 */
@RestController
public class AddMaterial {
    @Autowired(required = true)
    private IEntablado entabladoService;
    @Autowired
    private ICajaEntablado locationService;

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;

    @Autowired
    private IHistorico historicoService;


    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/addMaterial", method = RequestMethod.GET)
    public @ResponseBody
    String addMaterial(HttpServletRequest request,
                       @NotNull @RequestParam(value = "entablado", required = true, defaultValue = "PLNZ.00.0000") String entablado,
                       @NotNull @RequestParam(value = "fila", required = true, defaultValue = "-1") int fila,
                       @NotNull @RequestParam(value = "columna", required = true, defaultValue = "-1") int columna,
                       @NotNull @RequestParam(value = "articulo", required = true) String articulo,
                       @NotNull @RequestParam(value = "cantidad", required = true, defaultValue = "-1") int cantidad,
                       @NotNull @RequestParam(value = "origen", required = true, defaultValue = "-1") String origen) throws Exception {
        //Entablado e=entabladoService.getEstanteria(l,entablado);
        Entablado e = entabladoService.getEstanteria(entablado);
        //crear movimiento en NAV

        WebServicesInit.functionsService.createMovement("OSCA","SERWEB","",articulo,"",
                "", BigInteger.valueOf(cantidad),"UDS",origen,entablado);
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        JSONObject outputJsonObj = new JSONObject();
        //peso entablado
        //huecos entablado
        CajaEntablado c = locationService.getCajasEntablado(e, fila, columna);
        if (c != null) {
            //cantidad
            c.setCantidad(c.getCantidad() + cantidad);
            //c.setPeso(c.getPeso()+ (c.getArticulo().getPeso()*cantidad));
            //e.setPesoActual(e.getPesoActual() + (cantidad  * c.getArticulo().getPeso()));
            //actualizar entablado
            //entabladoService.addOrUpdateCajaEntablado(e);
            //actualizar caja
            //actualizarCantidad(c);
            locationService.addOrUpdateCajaEntablado(c);
            //añadir al historico
            outputJsonObj.put("res", "true");
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
            crearHistorio(h);

        } else {
            CajaEntabladoMedida c1 = cajaEntabladoMedidaService.getCajasEntablado(e, fila, columna);
            c1.setCantidad(c1.getCantidad() + cantidad);
            // c1.setPeso(c1.getPeso()+ (c1.getArticulo().getPeso()*cantidad));

            //e.setPesoActual(e.getPesoActual() + (c1.getArticulo().getPeso()*cantidad));
            //actualizar entablado
            //entabladoService.addOrUpdateCajaEntablado(e);
            //actualizarCantidad(c1);
            cajaEntabladoMedidaService.addOrUpdateCajaEntablado(c1);
            //añadir al historico
            outputJsonObj.put("res", "true");
            Historico h = new Historico();
            h.setArticulo(articulo);
            h.setId_historico(1);
            h.setLanzadera(e.getLanzadera());
            h.setEntablado(e);
            h.setFila(fila);
            h.setColumna(columna);
            TipoMovimiento tm = new TipoMovimiento();
            tm.setId_tipoMovimiento(5);
            h.setTipoMovimiento(tm);
            h.setUsuario("SERWEB");
            //h.setArticulo(c1.getArticulo());
            h.setCantidad(c.getCantidad()+cantidad);
            crearHistorio(h);
        }
        outputJsonObj.put("res", "true");

        return outputJsonObj.toString();
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
