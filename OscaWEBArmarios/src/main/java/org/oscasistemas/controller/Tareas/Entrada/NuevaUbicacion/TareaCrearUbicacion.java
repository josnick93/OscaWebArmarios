package org.oscasistemas.controller.Tareas.Entrada.NuevaUbicacion;

import com.dynamics.webServices.Item_Card_WS.ItemCardWS;
import com.sun.istack.internal.NotNull;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.DAO.interfaces.ITareasPendientes;
import org.oscasistemas.DAO.interfaces.ITipoCaja;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.CajaEntablado;
import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.Historico;
import org.oscasistemas.model.TipoMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Calendar;

/**
 * Created by José Ángel Caudevílla Casaús on 26/12/2017.
 */
@RestController
public class TareaCrearUbicacion {

    @Autowired(required = true)
    private IEntablado entabladoService;

    @Autowired (required = true)
    private ITipoCaja tipoCajaService;

    @Autowired
    private ITareasPendientes tareasPendientesService;



    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/TareaCrearUbicacion", method = RequestMethod.GET)
    public @ResponseBody
    String tareaCrearUbicacion(HttpServletRequest request,
                               @NotNull @RequestParam(value = "entablado", required = true, defaultValue = "PLNZ.00.0000") String entablado,
                               @NotNull @RequestParam(value = "xPos", required = true, defaultValue = "-1") int fila,
                               @NotNull @RequestParam(value = "yPos", required = true, defaultValue = "-1") int columna,
                               @NotNull @RequestParam(value = "articulo", required = true) String articulo,
                               @NotNull @RequestParam(value = "cantidad", required = true, defaultValue = "-1") int cantidad,
                               @NotNull @RequestParam(value = "caja", required = true, defaultValue = "13") int caja,
                               @NotNull @RequestParam(value = "xCoord", required = true, defaultValue = "13") double xCoord,
                               @NotNull @RequestParam(value = "yCoord", required = true, defaultValue = "13") double yCoord,
                               @NotNull @RequestParam(value = "idTarea", required = true, defaultValue = "-1") int idtarea    ) throws Exception {
        JSONObject outputJsonObj = new JSONObject();
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        //comprobar datos no vacios
        if (fila == -1 || columna == -1 || articulo.equals("") || cantidad == -1.0) {
            System.out.println(" " + entablado + " " + fila + " " + columna + " " + articulo + " " + cantidad);
            outputJsonObj.put("res", "false");
        }

        //introducir posicion en la BD
        //else{
        Entablado e = entabladoService.getEstanteria(entablado);
        ItemCardWS a = WebServicesInit.articulosService.read(articulo);
        CajaEntablado l = new CajaEntablado();
        l.setColumna(columna);
        l.setFila(fila);
        l.setEntablado(e);
        l.setLanzadera(e.getLanzadera());
        l.setxPos(xCoord);
        l.setyPos(yCoord);
        l.setTipoCaja(tipoCajaService.getTipoCaja(caja));
        l.setArticulo(articulo);
        l.setCantidad(cantidad);
        //l.setPeso(l.getPeso() + (Integer.valueOf(a.getNetWeight().toString()) * cantidad));
        l.setPeso(0.0);
        l.setEsVacia((byte) -1);
        l.setFechaCreacion(new Date(Calendar.getInstance().getTimeInMillis()));
        l.setFechaActualizacion(new Date(Calendar.getInstance().getTimeInMillis()));
        l.setTs(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        //e.setPesoActual(e.getPesoActual()+(l.getArticulo().getPeso()*cantidad));
        //e.setHuecosLibres(e.getHuecosLibres()-l.getTipoCaja().getNum_huecos());
        //actualizar entablado
        entabladoService.addOrUpdateCajaEntablado(e);
        crearUbicacion(l);
        //locationService.saveCajaEntablado(l);
        //añadir al historico
        outputJsonObj.put("res", "true");
        Historico h = new Historico();
        h.setId_historico(1);
        h.setLanzadera(e.getLanzadera());
        h.setEntablado(e);
        h.setFila(fila);
        h.setColumna(columna);
        TipoMovimiento tm = new TipoMovimiento();
        tm.setId_tipoMovimiento(1);
        h.setTipoMovimiento(tm);
        h.setArticulo(a.getNo());
        h.setCantidad(cantidad);
        crearHistorio(h);
        //}

        //borrar tarea
        tareasPendientesService.remove(tareasPendientesService.getTareaPendiente(idtarea));

        return outputJsonObj.toString();
    }


    private void crearUbicacion(CajaEntablado ubicacion) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.2.2:3306/osca_localizacion", "osca", "osca");
            // String insertTableSQL = "INSERT INTO cajas_entablado"
            //        + "(Id_lanzadera, codigo, fila, columna,xPos,yPos,Articulo,Id_caja,Cantidad,Peso,esVacia,esReservado,fechaCreacion,fechaActualizacion) VALUES"
            //        + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            String insertTableSQL = "INSERT INTO cajas_entablado"
                    + "(columna,fila,Codigo,Id_lanzadera,xPos,yPos,Id_caja,Articulo,Cantidad,Peso,esVacia,fechaCreacion,fechaActualizacion) VALUES"
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, ubicacion.getColumna());
            preparedStatement.setInt(2, ubicacion.getFila());
            preparedStatement.setString(3, ubicacion.getEntablado().getCodigo());
            preparedStatement.setInt(4, ubicacion.getLanzadera().getId_lanzadera());
            preparedStatement.setDouble(5, ubicacion.getxPos());
            preparedStatement.setDouble(6, ubicacion.getyPos());
            preparedStatement.setInt(7, ubicacion.getTipoCaja().getId_caja());
            preparedStatement.setString(8, ubicacion.getArticulo());
            preparedStatement.setInt(9, ubicacion.getCantidad());
            preparedStatement.setDouble(10, ubicacion.getPeso());
            preparedStatement.setDouble(9, ubicacion.getCantidad());
            preparedStatement.setDouble(10, ubicacion.getPeso());
            preparedStatement.setByte(11, ubicacion.getEsVacia());
            preparedStatement.setDate(12, ubicacion.getFechaCreacion());
            preparedStatement.setDate(13, ubicacion.getFechaActualizacion());
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
