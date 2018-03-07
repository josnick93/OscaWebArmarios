package org.oscasistemas.controller.Entrada.EntradaMaterial.EntradaPedido.CrearUbicacion.Operacion;

import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSList;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.DAO.interfaces.ITareasPendientes;
import org.oscasistemas.DAO.interfaces.ITipoCaja;
import org.oscasistemas.controller.Entrada.EntradaMaterial.Utils.EntradaPedidoUtils;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.SOAPFaultException;
import java.sql.*;
import java.util.Calendar;
import java.util.List;

/**
 * Created by José Ángel Caudevilla Casaus on 19/01/2018.
 */
@RestController
public class CrearUbicacionArticuloPedido {

    @Autowired(required = true)
    private IEntablado entabladoService;

    @Autowired (required = true)
    private ITipoCaja tipoCajaService;

    @Autowired
    private ITareasPendientes tareasPendientesService; //task query service

    /**
     * Creates a new box from a ubication
     * @param request
     * @param No
     * @param Line_No
     * @param fila
     * @param columna
     * @param caja
     * @param Bin_Code
     * @param cantidad
     * @param xCoord
     * @param yCoord
     * @param articulo
     * @return
     * @throws Exception
     */
    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/CrearUbicacionArticuloPedido", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String CrearUbicacionArticuloPedido(HttpServletRequest request,
                             @NotNull @RequestParam(value = "pedido", required = true, defaultValue = "-1") String No,
                             @NotNull @RequestParam(value = "linea", required = true, defaultValue = "-1") int Line_No,
                             @NotNull @RequestParam(value = "xPos", required = true, defaultValue = "-1") int fila,
                             @NotNull @RequestParam(value = "yPos", required = true, defaultValue = "-1") int columna,
                             @NotNull @RequestParam(value = "caja", required = true, defaultValue = "13") int caja,
                             @NotNull @RequestParam(value = "entablado", required = true, defaultValue="-1") String Bin_Code,
                             @NotNull @RequestParam(value = "cantidad", required = true, defaultValue = "-1") int cantidad,
                             @NotNull @RequestParam(value = "xCoord", required = true, defaultValue = "13") double xCoord,
                             @NotNull @RequestParam(value = "yCoord", required = true, defaultValue = "13") double yCoord,
                             @NotNull @RequestParam(value = "articulo", required = true, defaultValue = "000000000") String articulo)
    {
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

        try {
            //modifiy Bin code
            EntradaPedidoUtils.entradaCambiarUbicacion(Bin_Code, No, Line_No);
        }catch(SOAPFaultException soapExc){
            soapExc.printStackTrace();
            return "error:"+soapExc.toString();
        }
        try {
            //update quantityToHandle
            EntradaPedidoUtils.entradaActualizarCantidadAManipular(No, Line_No);
            EntradaPedidoUtils.entradaActualizarCantidadAManipular(No, Line_No-10000);
        }catch(SOAPFaultException soapExc){
            soapExc.printStackTrace();
            return "error:"+soapExc.getMessage();
        }

        //ItemCardWS a=WebServicesInit.articulosService.read(articulo);
        //NuevaUbicacion
        Entablado e = entabladoService.getEstanteria(Bin_Code);
        CajaEntablado miCajaEntablado = new CajaEntablado();
        miCajaEntablado.setColumna(columna);
        miCajaEntablado.setFila(fila);
        miCajaEntablado.setEntablado(e);
        miCajaEntablado.setLanzadera(e.getLanzadera());
        miCajaEntablado.setxPos(xCoord);
        miCajaEntablado.setyPos(yCoord);
        miCajaEntablado.setTipoCaja(tipoCajaService.getTipoCaja(caja));
        miCajaEntablado.setArticulo(articulo);
        miCajaEntablado.setCantidad(cantidad);
        //l.setPeso(l.getPeso() + (Integer.valueOf(a.getNetWeight().toString()) * cantidad));
        miCajaEntablado.setPeso(0.0);
        miCajaEntablado.setEsVacia((byte) -1);
        miCajaEntablado.setFechaCreacion(new Date(Calendar.getInstance().getTimeInMillis()));
        miCajaEntablado.setFechaActualizacion(new Date(Calendar.getInstance().getTimeInMillis()));
        miCajaEntablado.setTs(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        //e.setPesoActual(e.getPesoActual()+(l.getArticulo().getPeso()*cantidad));
        //e.setHuecosLibres(e.getHuecosLibres()-l.getTipoCaja().getNum_huecos());
        //actualizar entablado
        entabladoService.addOrUpdateCajaEntablado(e);
        try {
            crearUbicacion(miCajaEntablado);
        } catch (SQLException e1) {
            e1.printStackTrace();
            return "error:"+e1.getMessage();
        }

        /**
         * Actualizar historico
         */
        Historico h = new Historico();
        h.setId_historico(1);
        h.setLanzadera(e.getLanzadera());
        h.setEntablado(e);
        h.setFila(fila);
        h.setColumna(columna);
        TipoMovimiento tm = new TipoMovimiento();
        tm.setId_tipoMovimiento(1);
        h.setTipoMovimiento(tm);
        h.setArticulo(articulo);
        h.setCantidad(cantidad);
        try {
            crearHistorio(h);
        } catch (SQLException e1) {
            e1.printStackTrace();
            return "error:"+e1.getMessage();
        }


        //no register lines in request lift
        WarehouseActivityLineWSList lineasSinMarcar=null;
        try{
            lineasSinMarcar=EntradaPedidoUtils.estanLineasEntradaRegistradas(No, Bin_Code);
        }catch(SOAPFaultException soapException){
            return "error:"+soapException.getMessage();
        }

        //if no more lines in this ubication for request lift
        if(lineasSinMarcar==null || lineasSinMarcar.getWarehouseActivityLineWS().isEmpty()) {
            //register ubication
            try {
                WebServicesInit.functionsService.putAwayPost(No);
            }catch(SOAPFaultException ex){
                ex.printStackTrace();
                return "error:"+ex.getMessage();
            }
            WarehouseActivityLineWSList lineasPedidoSinMarcarT =  null;

            try{
                lineasPedidoSinMarcarT=EntradaPedidoUtils.estanLineasEntradaRegistradas(No);
            }catch(SOAPFaultException soapExp){
                soapExp.printStackTrace();
                return "error:"+soapExp.getMessage();
            }
            //en ubication??
            if (lineasPedidoSinMarcarT == null) {
                //NOT USED
                if (tareasPendientesService.exiteTarea("/OscaArmarios/EntradaInfoPedido.html?pedido=" + No)) {
                    List<TareasPendientes> pendientes = tareasPendientesService
                            .getTareasPendientes("/OscaArmarios/EntradaInfoPedido.html?pedido=" + No);
                    for (TareasPendientes t : pendientes)
                        tareasPendientesService.remove(t);
                }

            }else{
                return new Gson().toJson("END");
            }
        }
        else {
            return new Gson().toJson("ENDLIFT");
        }
        return new Gson().toJson("OK");
    }




    /**
     * Create storic regist on the DB
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

    /**
     * Creates ubication on Database
     * @param ubicacion
     * @throws SQLException
     */
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
}
