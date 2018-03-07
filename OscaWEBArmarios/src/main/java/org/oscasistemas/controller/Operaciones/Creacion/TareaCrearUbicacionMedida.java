package org.oscasistemas.controller.Operaciones.Creacion;

import com.dynamics.webServices.Bin_Content_WS.BinContentWS;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFields;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFilter;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSList;
import com.dynamics.webServices.Item_Card_WS.ItemCardWS;
import com.sun.istack.internal.NotNull;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.DAO.interfaces.ITareasPendientes;
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
import javax.xml.ws.Holder;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 26/12/2017.
 */
@RestController
public class TareaCrearUbicacionMedida {

    @Autowired(required = true)
    private IEntablado entabladoService;

    @Autowired
    private ITareasPendientes tareasPendientesService;

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/TareaCrearUbicacionMedida", method = RequestMethod.GET)
    public @ResponseBody
    String tareaCrearUbicacionMedida(HttpServletRequest request,
                                     @NotNull @RequestParam(value = "entablado", required = true, defaultValue = "PLNZ.00.0000") String entablado,
                                     @NotNull @RequestParam(value = "xPos", required = true, defaultValue = "-1") int fila,
                                     @NotNull @RequestParam(value = "yPos", required = true, defaultValue = "-1") int columna,
                                     @NotNull @RequestParam(value = "articulo", required = true) String articulo,
                                     @NotNull @RequestParam(value = "origen", required = true , defaultValue = "VACIO") String origen,
                                     @NotNull @RequestParam(value = "cantidad", required = true, defaultValue = "-1") int cantidad,
                                     @NotNull @RequestParam(value = "nfilas", required = true, defaultValue = "-1") int nfilas,
                                     @NotNull @RequestParam(value = "ncolumnas", required = true, defaultValue = "-1") int ncolumnas,
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

        ItemCardWS a = null;
        //crear movimiento en NAV
        if(WebMvcConfig.useSerWebNav) {
            a=WebServicesInit.articulosService.read(articulo);
            WebServicesInit.functionsService.createMovement("OSCA", "SERWEB", "", articulo, "",
                    "", BigInteger.valueOf(cantidad), "UDS", origen, entablado);
            actualizarUbicacionFija(entablado,articulo);
        }

        //introducir posicion en la BD
        //else{
        Entablado e = entabladoService.getEstanteria(entablado);
        CajaEntabladoMedida l = new CajaEntabladoMedida();
        l.setColumna(columna);
        l.setFila(fila);
        l.setEntablado(e);
        l.setLanzadera(e.getLanzadera());
        l.setxPos(xCoord);
        l.setyPos(yCoord);
        l.setNfilas(nfilas);
        l.setNcolumnas(ncolumnas);
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
