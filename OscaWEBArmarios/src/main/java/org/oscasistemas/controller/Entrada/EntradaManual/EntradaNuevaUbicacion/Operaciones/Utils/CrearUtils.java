package org.oscasistemas.controller.Entrada.EntradaManual.EntradaNuevaUbicacion.Operaciones.Utils;

import com.dynamics.webServices.Bin_Content_WS.BinContentWS;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFields;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFilter;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSList;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.CajaEntablado;
import org.oscasistemas.model.CajaEntabladoMedida;
import org.oscasistemas.model.Historico;

import javax.xml.ws.Holder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Portátil1 on 06/03/2018.
 */
public class CrearUtils {

    public static boolean actualizarUbicacionFija(String codigo, String articulo){
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


    public static void crearUbicacion(CajaEntablado ubicacion) throws SQLException {
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

    public static void crearUbicacion(CajaEntabladoMedida ubicacion) throws SQLException {
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




    public static void crearHistorio(Historico h) throws SQLException {
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
