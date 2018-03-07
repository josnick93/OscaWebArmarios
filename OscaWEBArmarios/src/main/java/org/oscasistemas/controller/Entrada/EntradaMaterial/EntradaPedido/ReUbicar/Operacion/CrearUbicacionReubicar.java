package org.oscasistemas.controller.Entrada.EntradaMaterial.EntradaPedido.ReUbicar.Operacion;

import com.dynamics.webServices.Bin_Content_WS.BinContentWS;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFields;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFilter;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSList;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSList;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by José Ángel Caudevilla Casaus on 29/01/2018.
 */
@RestController
public class CrearUbicacionReubicar {

    @Autowired(required = true)
    private IEntablado entabladoService;
    @Autowired
    private ICajaEntablado locationService;


    @Autowired (required = true)
    private ITipoCaja tipoCajaService;

    @Autowired
    private ITareasPendientes tareasPendientesService;


    /**
     *
     * @param request
     * @param No
     * @param Line_No
     * @param columnaOrigen
     * @param filaOrigen
     * @param fila
     * @param columna
     * @param caja
     * @param Bin_Code
     * @param cantidad
     * @param xCoord
     * @param yCoord
     * @param origen
     * @param articulo
     * @return
     * @throws Exception
     */
    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/CrearUbicacionReubicar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String CrearUbicacionReubicar(HttpServletRequest request,
                             @NotNull @RequestParam(value = "pedido", required = true, defaultValue = "-1") String No,
                             @NotNull @RequestParam(value = "linea", required = true, defaultValue = "-1") int Line_No,
                             @NotNull @RequestParam(value = "columnaOrigen", required = true, defaultValue = "-1") int columnaOrigen,
                             @NotNull @RequestParam(value = "filaOrigen", required = true, defaultValue = "-1") int filaOrigen,
                             @NotNull @RequestParam(value = "xPos", required = true, defaultValue = "-1") int fila,
                             @NotNull @RequestParam(value = "yPos", required = true, defaultValue = "-1") int columna,
                             @NotNull @RequestParam(value = "caja", required = true, defaultValue = "13") int caja,
                             @NotNull @RequestParam(value = "entablado", required = true, defaultValue="-1") String Bin_Code,
                             @NotNull @RequestParam(value = "cantidad", required = true, defaultValue = "-1") int cantidad,
                             @NotNull @RequestParam(value = "xCoord", required = true, defaultValue = "13") double xCoord,
                             @NotNull @RequestParam(value = "yCoord", required = true, defaultValue = "13") double yCoord,
                             @NotNull @RequestParam(value = "origen", required = true, defaultValue = "13") String origen,
                             @NotNull @RequestParam(value = "articulo", required = true, defaultValue = "000000000") String articulo){
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        //get origin box
        CajaEntablado anteriorUbi=locationService.getCajasEntablado(entabladoService.getEstanteria(origen),filaOrigen,columnaOrigen);


        try {
            //change bin code line ubication
            EntradaPedidoUtils.entradaCambiarUbicacion(Bin_Code, No, Line_No);
        }catch (SOAPFaultException soap){
            soap.printStackTrace();
            return "error:"+soap.getMessage();
        }

        try {
            //update ubication lines
            EntradaPedidoUtils.entradaActualizarCantidadAManipular(No, Line_No);
            EntradaPedidoUtils.entradaActualizarCantidadAManipular(No, Line_No-10000);
        } catch(SOAPFaultException soap){
            soap.printStackTrace();
            return "error:"+soap.getMessage();
        }

        boolean loop=true;

        //not clear way to continue with exception
        do {
            try {
                //register ubication to allow article movement
                WebServicesInit.functionsService.putAwayPost(No);
                loop=false;
            } catch (SOAPFaultException soapExc) {
                soapExc.printStackTrace();
                loop=false;
                continue;
            }
        }while(loop);

        BinContentWS contenidoAntiguo=null;
        try{
            contenidoAntiguo=getContenidoUbi(origen,articulo);
        }catch(SOAPFaultException ex){
            ex.printStackTrace();
            return "error:"+ex.getMessage();
        }

        try {
            //Make old box to new box movement
            WebServicesInit.functionsService.createMovement("OSCA", "SERWEB", "", articulo, "",
                    "", contenidoAntiguo.getQuantity().subtract(contenidoAntiguo.getPickQty()), "UDS", origen, Bin_Code);
        }catch(SOAPFaultException ex){
            ex.printStackTrace();
            return "error:"+ex.toString();
        }
        try {
            borrarCajaAntiguaPosicion(origen, articulo);
        }catch(SOAPFaultException ex){
            ex.printStackTrace();
            return "error:"+ex.getMessage();
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
        miCajaEntablado.setCantidad(cantidad+anteriorUbi.getCantidad());
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

        //borrar caja ubicacion anterior
        try {
            borrarCaja(anteriorUbi);
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

        WarehouseActivityLineWSList lineasSinMarcar=null;
        try {
            lineasSinMarcar = EntradaPedidoUtils.estanLineasEntradaRegistradas(No, Bin_Code);
        }catch(SOAPFaultException ex){
            ex.printStackTrace();
            return "error:"+ex.getMessage();
        }


        if(lineasSinMarcar==null || lineasSinMarcar.getWarehouseActivityLineWS().isEmpty()) {
            WarehouseActivityLineWSList lineasPedidoSinMarcarT = null;
            try{
                lineasPedidoSinMarcarT= EntradaPedidoUtils.estanLineasEntradaRegistradas(No);
            }catch (SOAPFaultException ex){
                ex.printStackTrace();
                return "error:"+ex.getMessage();
            }
            //fin pedido???
            if (lineasPedidoSinMarcarT == null) {
                if (tareasPendientesService.exiteTarea("/OscaArmarios/EntradaInfoPedido.html?pedido=" + No)) {
                    List<TareasPendientes> pendientes = tareasPendientesService
                            .getTareasPendientes("/OscaArmarios/EntradaInfoPedido.html?pedido=" + No);
                    for (TareasPendientes t : pendientes)
                        tareasPendientesService.remove(t);
                }
                return new Gson().toJson("END");

            }else{
               return new Gson().toJson("ENDLIFT");
            }
        }
        return new Gson().toJson("OK");
    }

    /**
     *
     * @param codigo
     * @param articulo
     * @return
     * @throws SOAPFaultException
     */
    private BinContentWS getContenidoUbi(String codigo,String articulo)
            throws SOAPFaultException{
        List<BinContentWSFilter> filtros = new ArrayList<BinContentWSFilter>();
        BinContentWSFilter f1 = new BinContentWSFilter();
        f1.setField(BinContentWSFields.BIN_CODE);
        f1.setCriteria(codigo);
        filtros.add(f1);
        BinContentWSFilter f2 = new BinContentWSFilter();
        f2.setField(BinContentWSFields.ITEM_NO);
        f2.setCriteria(articulo);
        filtros.add(f2);
        return WebServicesInit.contenidoUbicacionService.readMultiple(filtros, "", 1).getBinContentWS().get(0);
    }

    /**
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

    /**
     *
     * @param Bin_Code
     * @param articulo
     * @throws SOAPFaultException
     */
    private void borrarCajaAntiguaPosicion(String Bin_Code,String articulo) throws SOAPFaultException{

        List<BinContentWSFilter> filtros1 = new ArrayList<BinContentWSFilter>();
        BinContentWSFilter f1 = new BinContentWSFilter();
        f1.setField(BinContentWSFields.ITEM_NO);
        f1.setCriteria(articulo);
        filtros1.add(f1);
        BinContentWSFilter f2 = new BinContentWSFilter();
        f2.setField(BinContentWSFields.BIN_CODE);
        f2.setCriteria(Bin_Code);
        filtros1.add(f2);
        BinContentWSFilter f3 = new BinContentWSFilter();
        f3.setField(BinContentWSFields.QUANTITY);
        f3.setCriteria("=0");
        filtros1.add(f3);
        BinContentWSList ubicacion = WebServicesInit.contenidoUbicacionService.readMultiple(filtros1, "", 1);
        //eliminar ubicacion del articulo
        WebServicesInit.contenidoUbicacionService.delete(ubicacion.getBinContentWS().get(0).getKey());
    }


    /**
     *
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

    /**
     *
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
