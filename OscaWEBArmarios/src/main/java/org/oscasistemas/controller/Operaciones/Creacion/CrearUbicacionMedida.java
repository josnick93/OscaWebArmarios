package org.oscasistemas.controller.Operaciones.Creacion;

import com.dynamics.webServices.Item_Card_WS.ItemCardWS;
import com.sun.istack.internal.NotNull;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.init.WebMvcConfig;
import org.oscasistemas.model.CajaEntabladoMedida;
import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.Historico;
import org.oscasistemas.model.TipoMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.sql.*;
import java.util.Calendar;

/**
 * Created by Portátil1 on 26/12/2017.
 */
@RestController
public class CrearUbicacionMedida {

    @Autowired(required = true)
    private IEntablado entabladoService;

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/CrearUbicacionMedida", method = RequestMethod.GET)
    public @ResponseBody
    String crearUbicacionMedida(HttpServletRequest request,
                                @NotNull @RequestParam(value = "entablado", required = true, defaultValue = "PLNZ.00.0000") String entablado,
                                @NotNull @RequestParam(value = "xPos", required = true, defaultValue = "-1") int xPos,
                                @NotNull @RequestParam(value = "yPos", required = true, defaultValue = "-1") int yPos,
                                @NotNull @RequestParam(value = "articulo", required = true) String articulo,
                                @NotNull @RequestParam(value = "cantidad", required = true, defaultValue = "-1") int cantidad,
                                @NotNull @RequestParam(value = "origen", required = true) String origen,
                                @NotNull @RequestParam(value = "xCoord", required = true, defaultValue = "13") double xCoord,
                                @NotNull @RequestParam(value = "yCoord", required = true, defaultValue = "13") double yCoord,
                                @NotNull @RequestParam(value = "nfilas", required = true, defaultValue = "0") int nfilas,
                                @NotNull @RequestParam(value = "ncolumnas", required = true, defaultValue = "0") int ncolumnas) throws Exception {
        JSONObject outputJsonObj = new JSONObject();
        //crear movimiento en NAV
        ItemCardWS a = null;
        if(WebMvcConfig.useSerWebNav) {
            a=WebServicesInit.articulosService.read(articulo);
            WebServicesInit.functionsService.createMovement("OSCA", "SERWEB", "", articulo, "",
                    "", BigInteger.valueOf(cantidad), "UDS", origen, entablado);
        }
        String remoteAddr = "";
        Entablado e=entabladoService.getEstanteria(entablado);
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        //comprobar datos no vacios
        if ( xPos == -1 || yPos == -1 || articulo.equals("") || cantidad == -1.0) {
            System.out.println(entablado + " " + xPos + " " + yPos + " " + articulo + " " + cantidad);
            outputJsonObj.put("res", "false");
        }
        //introducir posicion en la BD
        else {
            CajaEntabladoMedida l= new CajaEntabladoMedida();
            l.setEntablado(e);
            l.setLanzadera(e.getLanzadera());
            l.setFila(xPos);
            l.setColumna(yPos);
            l.setxPos(xCoord);
            l.setyPos(yCoord);
            l.setNfilas(nfilas);
            l.setNcolumnas(ncolumnas);
            l.setArticulo(a.getNo());
            l.setCantidad(cantidad);
            l.setPeso(0.0);
            l.setEsVacia((byte)-1);
            l.setFechaCreacion(new Date(Calendar.getInstance().getTimeInMillis()));
            l.setFechaActualizacion(new Date(Calendar.getInstance().getTimeInMillis()));
            l.setTs(new Timestamp(Calendar.getInstance().getTimeInMillis()));
            //e.setPesoActual(e.getPesoActual()+(l.getArticulo().getPeso()*cantidad));
            e.setHuecosLibres(e.getHuecosLibres()+(l.getNfilas()*l.getNcolumnas()));
            //actualizar entablado
            entabladoService.addOrUpdateCajaEntablado(e);
            crearUbicacion(l);

            //añadir al historico
            outputJsonObj.put("res","true");
            Historico h=new Historico();
            h.setId_historico(1);
            h.setLanzadera(e.getLanzadera());
            h.setEntablado(e);
            h.setFila(yPos);
            h.setColumna(xPos);
            TipoMovimiento tm=new TipoMovimiento();
            tm.setId_tipoMovimiento(1);
            h.setTipoMovimiento(tm);
            h.setArticulo(articulo);
            h.setCantidad(cantidad);
            crearHistorio(h);
            outputJsonObj.put("res","true");



        }
        return outputJsonObj.toString();
    }


    private void crearUbicacion(CajaEntabladoMedida ubicacion) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.2.2:3306/osca_localizacion","osca","osca");
            String insertTableSQL = "INSERT INTO cajas_entablado_medida"
                    + "(Codigo,fila,columna,Id_lanzadera,xPos,yPos,nfilas,ncolumnas,Articulo,Cantidad,Peso,esVacia,fechaCreacion,fechaActualizacion) VALUES"
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement= conn.prepareStatement(insertTableSQL);
            preparedStatement.setString(1,ubicacion.getEntablado().getCodigo());
            preparedStatement.setInt(2,ubicacion.getFila());
            preparedStatement.setInt(3,ubicacion.getColumna());
            preparedStatement.setInt(4,ubicacion.getLanzadera().getId_lanzadera());
            preparedStatement.setDouble(5,ubicacion.getxPos());
            preparedStatement.setDouble(6,ubicacion.getyPos());
            preparedStatement.setInt(7,ubicacion.getNfilas());
            preparedStatement.setInt(8,ubicacion.getNcolumnas());
            preparedStatement.setString(9,ubicacion.getArticulo());
            preparedStatement.setDouble(10,ubicacion.getCantidad());
            preparedStatement.setDouble(11,ubicacion.getPeso());
            preparedStatement.setByte(12,ubicacion.getEsVacia());
            preparedStatement.setDate(13,ubicacion.getFechaCreacion());
            preparedStatement.setDate(14,ubicacion.getFechaActualizacion());
            preparedStatement.execute("SET foreign_key_checks = 0;");
            preparedStatement .executeUpdate();
            preparedStatement.execute("SET foreign_key_checks = 1;");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
