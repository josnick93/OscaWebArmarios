package org.oscasistemas.controller;

import com.dynamics.webServices.Warehouse_Receipt_Header_WS.*;
import com.dynamics.webServices.Warehouse_Shipment_Header_WS.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.internal.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.*;
import org.oscasistemas.model.*;
import org.oscasistemas.service.interfaces.IArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Portátil1 on 26/07/2017.
 */
@RestController
public class OperacionesServidorController {


    @Autowired(required = true)
    private IEntablado entabladoService;
    @Autowired
    private ICajaEntablado locationService;

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;

    @Autowired
    private IArticuloService articuloService;

    @Autowired
    private IAcessoLazaderas acessoLazaderasService;

    @Autowired (required = true)
    private ITipoCaja tipoCajaService;

    @Autowired
    private ILanzadera lanzaderaService;

    @Autowired
    private IHistorico historicoService;

    @Autowired
    private IAdministrador administradorService;

    @Autowired
    private IAcciones accionesService;

    @Autowired
    private ITareasPendientes tareasPendientesService;

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(value = "Operacion/ListarArticulos",method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE )
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    List<Articulo> listarArticulos(Model model,
                                         HttpServletRequest request,
                                         @NotNull @RequestParam(value = "articulo" , required = false) String artiulo,
                                         @NotNull @RequestParam(value="alias",required = false) String alias, @NotNull @RequestParam(value = "descripcion",required = false) String descripcion){
        return articuloService.getArticulos(artiulo,alias,descripcion);
    }


    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/ListarPedidosEntrada",method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE )
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    List<WarehouseReceiptHeaderWS> listarPedidosEntrada(Model model,
                                         HttpServletRequest request,
                                         @NotNull @RequestParam(value = "pedido" , required = false , defaultValue = "") String pedido,
                                         @NotNull @RequestParam(value="alias",required = false , defaultValue = "") String alias,
                                         @NotNull @RequestParam(value = "descripcion",required = false , defaultValue = "") String descripcion){
        /**
         * Leer Pedidos entrada
         */
        // Warehouse_Receipt_Header_WS
            // Creamos el servicio con el WSDL
            URL wsdlLocation = OperacionesServidorController.class.getResource("res/Warehouse_Receipt_Header_WS.xml");
            String targetNamespace="urn:microsoft-dynamics-schemas/page/warehouse_receipt_header_ws";
            String name="Warehouse_Receipt_Header_WS_Service";
            WarehouseReceiptHeaderWSService  service = new WarehouseReceiptHeaderWSService( wsdlLocation, new QName(targetNamespace, name));
            WarehouseReceiptHeaderWSPort port = service.getWarehouseReceiptHeaderWSPort();
            // Añadimos capacidades de seguridad a la llamada
            BindingProvider provider = (BindingProvider) port;
            provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
            provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");
            //cast producto

            /*
                FILTROS
             */
            List<WarehouseReceiptHeaderWSFilter> filtros=new ArrayList<WarehouseReceiptHeaderWSFilter>();
            if(!pedido.equals("")){
                WarehouseReceiptHeaderWSFilter f1=new WarehouseReceiptHeaderWSFilter();
                f1.setField(WarehouseReceiptHeaderWSFields.NO);
                f1.setCriteria(pedido);
                filtros.add(f1);
            }

            WarehouseReceiptHeaderWSList pedidosEntrada=port.readMultiple(filtros,"",100);
            return pedidosEntrada.getWarehouseReceiptHeaderWS();
    }


    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/ListarPedidosSalida",method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE )
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    List<WarehouseShipmentHeaderWS> listarPedidosSalida(Model model,
                                                        HttpServletRequest request,
                                                        @NotNull @RequestParam(value = "pedido" , required = false , defaultValue = "") String pedido,
                                                        @NotNull @RequestParam(value="localizacion",required = false , defaultValue = "") String localizacion,
                                                        @NotNull @RequestParam(value = "descripcion",required = false , defaultValue = "") String descripcion){
        /**
         * Leer Pedidos entrada
         */
        // Warehouse_Shipment_Header_WS
        // Creamos el servicio con el WSDL
        URL wsdlLocation = OperacionesServidorController.class.getResource("res/Warehouse_Shipment_Header_WS.xml");
        String targetNamespace="urn:microsoft-dynamics-schemas/page/warehouse_shipment_header_ws";
        String name="Warehouse_Shipment_Header_WS_Service";
        WarehouseShipmentHeaderWSService service = new WarehouseShipmentHeaderWSService( wsdlLocation, new QName(targetNamespace, name));
        WarehouseShipmentHeaderWSPort port = service.getWarehouseShipmentHeaderWSPort();
        // Añadimos capacidades de seguridad a la llamada
        BindingProvider provider = (BindingProvider) port;
        provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
        provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");
        /*
         FILTROS
             */
        List<WarehouseShipmentHeaderWSFilter> filtros=new ArrayList<WarehouseShipmentHeaderWSFilter>();
        if(!pedido.equals("")){
            WarehouseShipmentHeaderWSFilter f1=new WarehouseShipmentHeaderWSFilter();
            f1.setField(WarehouseShipmentHeaderWSFields.NO);
            f1.setCriteria(pedido);
            filtros.add(f1);
        }
        WarehouseShipmentHeaderWSList pedidosSalida=port.readMultiple(filtros,"",100);
        return pedidosSalida.getWarehouseShipmentHeaderWS();
    }


    @RequestMapping(value = "Operacion/ListarEntablados",method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE )
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    List<Entablado> listarEntablado(Model model,
                                    HttpServletRequest request,
                                    @NotNull @RequestParam(value = "lanzadera" , required = false, defaultValue = "-1") int lanzadera,
                                    @NotNull @RequestParam(value="entablado",required = false , defaultValue = "-1") int entablado,
                                    @NotNull @RequestParam(value = "descripcion",required = false , defaultValue = "") String descripcion){
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        return entabladoService.getEstanterias(lanzaderaService.getLanzadera(lanzadera),entablado,descripcion);
    }

    @RequestMapping(value = "Operacion/ListarLanzaderas",method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE )
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    List<AcessoLanzadera> listarLanzaderas(Model model,
                                           HttpServletRequest request,
                                           @NotNull @RequestParam(value = "ip" , required = true, defaultValue = "127.0.0.1") String ipAdress){
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        return acessoLazaderasService.getLanzaderas(ipAdress) ;
    }

    @RequestMapping(value = "Operacion/editarDescripcion",method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String editarDescripcion(Model model,
                             HttpServletRequest request,
                             @NotNull @RequestParam(value = "lanzadera" , required = true, defaultValue = "-1") int idLanzadera,
                             @NotNull @RequestParam(value = "entablado" , required = true, defaultValue = "-1") int entablado,
                             @NotNull @RequestParam(value = "descripcion" , required = true, defaultValue = "") String descripcion) {
        Entablado e = entabladoService.getEstanteria(lanzaderaService.getLanzadera(idLanzadera),entablado);
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        e.setDescripcion(descripcion);
        entabladoService.addOrUpdateCajaEntablado(e);
        return descripcion;
    }

    @RequestMapping(value = "Operacion/EsLanzadera",method = RequestMethod.GET ,produces = "application/json")
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String esLanzadera(Model model,
                       HttpServletRequest request,
                       @NotNull @RequestParam(value = "ip" , required = true, defaultValue = "127.0.0.1") String dirIp) {
        Lanzadera l = lanzaderaService.getLanzaderaIp(dirIp);
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        if(l==null) return null;
        else {
            JSONObject obj=new JSONObject(l);
            return obj.toString();
        }
    }



    @RequestMapping(value = "Operacion/EsAdministrador",method = RequestMethod.GET ,produces = "application/json")
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String esAdministrador(Model model,
                           HttpServletRequest request,
                           @NotNull @RequestParam(value = "ip" , required = true, defaultValue = "127.0.0.1") String dirIp) {
        Administrador a = administradorService.getAdministrador(dirIp);
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        if(a==null) return null;
        else {
            JSONObject obj=new JSONObject(a);
            return obj.toString();
        }
    }



    @RequestMapping(value="Operacion/removerCajaVacia" ,method = RequestMethod.GET )
    public   @ResponseBody
    String removerCaja(HttpServletRequest request,
                       @NotNull @RequestParam(value="lanzadera",required = true ,defaultValue = "-1") int lanzadera,
                       @NotNull @RequestParam(value = "entablado",required = true, defaultValue = "-1") int entablado,
                       @NotNull @RequestParam(value = "xPos",required = true, defaultValue = "-1") int xPos,
                       @NotNull @RequestParam(value = "yPos",required = true,defaultValue = "-1") int yPos) throws Exception {
        Lanzadera l =lanzaderaService.getLanzadera(lanzadera);
        Entablado e=entabladoService.getEstanteria(l,entablado);
        CajaEntablado c=locationService.getCajasEntablado(l,e,xPos,yPos);
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        borrarCaja(c);
        e.setHuecosLibres(e.getHuecosLibres()+c.getTipoCaja().getNum_huecos());
        entabladoService.addOrUpdateCajaEntablado(e);

        //añadir al historico
        Historico h=new Historico();
        h.setId_historico(1);
        h.setLanzadera(l);
        h.setEntablado(e);
        h.setFila(yPos);
        h.setColumna(xPos);
        TipoMovimiento  tm=new TipoMovimiento();
        tm.setId_tipoMovimiento(4);
        h.setTipoMovimiento(tm);
        h.setArticulo(c.getArticulo());
        h.setCantidad(0);
        crearHistorio(h);

        JSONObject outputJsonObj = new JSONObject();
        outputJsonObj.put("res","true");
        return outputJsonObj.toString();
    }

    @RequestMapping(value="Operacion/regularizarCaja" ,method = RequestMethod.GET )
    public   @ResponseBody
    String regularizarMaterial(HttpServletRequest request,
                               @NotNull @RequestParam(value="lanzadera",required = true ,defaultValue = "-1") int lanzadera,
                               @NotNull @RequestParam(value = "entablado",required = true, defaultValue = "-1") int entablado,
                               @NotNull @RequestParam(value = "xPos",required = true, defaultValue = "-1") int xPos,
                               @NotNull @RequestParam(value = "yPos",required = true,defaultValue = "-1") int yPos,
                               @NotNull @RequestParam(value = "cantidad" ,required = true, defaultValue = "-1") int cantidad) throws Exception {
        Lanzadera l =lanzaderaService.getLanzadera(lanzadera);
        Entablado e=entabladoService.getEstanteria(l,entablado);
        CajaEntablado c=locationService.getCajasEntablado(l,e,xPos,yPos);
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        if(c.getCantidad()<cantidad)
            e.setPesoActual(e.getPesoActual()+(c.getArticulo().getPeso()*(cantidad-c.getCantidad())));
        else
            e.setPesoActual(e.getPesoActual()-(c.getArticulo().getPeso()*(c.getCantidad()-cantidad)));
        //actualizar entablado
        entabladoService.addOrUpdateCajaEntablado(e);
        if(c!=null) {
            c.setCantidad(cantidad);
            if (c.getCantidad() == 0)
                c.setEsVacia((byte) 1);
            else if (c.getCantidad() > 0)
                c.setEsVacia((byte) -1);
            actualizarCantidad(c);
            //añadir al historico
            Historico h=new Historico();
            h.setId_historico(1);
            h.setLanzadera(l);
            h.setEntablado(e);
            h.setFila(yPos);
            h.setColumna(xPos);
            TipoMovimiento  tm=new TipoMovimiento();
            tm.setId_tipoMovimiento(3);
            h.setTipoMovimiento(tm);
            h.setArticulo(c.getArticulo());
            h.setCantidad(c.getCantidad());
            crearHistorio(h);
        }
        else{
            CajaEntabladoMedida c1=cajaEntabladoMedidaService.getCajasEntablado(l,e,xPos,yPos);
            c1.setCantidad(cantidad);
            if (c1.getCantidad() == 0.0)
                c1.setEsVacia((byte) 1);
            else if (c.getCantidad() > 0.0)
                c.setEsVacia((byte) -1);
            actualizarCantidad(c);
            //añadir al historico
            Historico h=new Historico();
            h.setId_historico(1);
            h.setLanzadera(l);
            h.setEntablado(e);
            h.setFila(yPos);
            h.setColumna(xPos);
            TipoMovimiento  tm=new TipoMovimiento();
            tm.setId_tipoMovimiento(3);
            h.setTipoMovimiento(tm);
            h.setArticulo(c1.getArticulo());
            h.setCantidad(c1.getCantidad());
            crearHistorio(h);
        }
        JSONObject outputJsonObj = new JSONObject();
        outputJsonObj.put("res","true");
        return outputJsonObj.toString();
    }

    @RequestMapping(value="Operacion/addMaterial" ,method = RequestMethod.GET )
    public   @ResponseBody
    String addMaterial(HttpServletRequest request,
                       @NotNull @RequestParam(value="lanzadera",required = true ,defaultValue = "-1") int lanzadera,
                       @NotNull @RequestParam(value = "entablado",required = true, defaultValue = "-1") int entablado,
                       @NotNull @RequestParam(value = "xPos",required = true, defaultValue = "-1") int xPos,
                       @NotNull @RequestParam(value = "yPos",required = true,defaultValue = "-1") int yPos,
                       @NotNull @RequestParam(value = "articulo" ,required = true) String articulo,
                       @NotNull @RequestParam(value = "cantidad" ,required = true ,defaultValue = "-1") int cantidad) throws Exception {
        Lanzadera l =lanzaderaService.getLanzadera(lanzadera);
        Entablado e=entabladoService.getEstanteria(l,entablado);
        CajaEntablado c=locationService.getCajasEntablado(l,e,xPos,yPos);
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


        if(c!=null) {
            //cantidad
            c.setCantidad(c.getCantidad() + cantidad);
            c.setPeso(c.getPeso()+ (c.getArticulo().getPeso()*cantidad));
            e.setPesoActual(e.getPesoActual() + (cantidad  * c.getArticulo().getPeso()));
            //actualizar entablado
            entabladoService.addOrUpdateCajaEntablado(e);
            //actualizar caja
            actualizarCantidad(c);
            //añadir al historico
            outputJsonObj.put("res","true");
            Historico h=new Historico();
            h.setId_historico(5);
            h.setLanzadera(l);
            h.setEntablado(e);
            h.setFila(yPos);
            h.setColumna(xPos);
            TipoMovimiento  tm=new TipoMovimiento();
            //añadir material
            tm.setId_tipoMovimiento(5);
            h.setTipoMovimiento(tm);
            h.setArticulo(c.getArticulo());
            h.setCantidad(cantidad);
            crearHistorio(h);

        }else{
            CajaEntabladoMedida c1=cajaEntabladoMedidaService.getCajasEntablado(l,e,xPos,yPos);
            c1.setCantidad(c1.getCantidad() + cantidad);
            c1.setPeso(c1.getPeso()+ (c1.getArticulo().getPeso()*cantidad));

            e.setPesoActual(e.getPesoActual() + (c1.getArticulo().getPeso()*cantidad));
            //actualizar entablado
            entabladoService.addOrUpdateCajaEntablado(e);
            actualizarCantidad(c1);

            //añadir al historico
            outputJsonObj.put("res","true");
            Historico h=new Historico();
            h.setId_historico(1);
            h.setLanzadera(l);
            h.setEntablado(e);
            h.setFila(yPos);
            h.setColumna(xPos);
            TipoMovimiento  tm=new TipoMovimiento();
            tm.setId_tipoMovimiento(5);
            h.setTipoMovimiento(tm);
            h.setArticulo(c1.getArticulo());
            h.setCantidad(cantidad);
            crearHistorio(h);
        }
        outputJsonObj.put("res","true");
        return outputJsonObj.toString();
    }


    @RequestMapping(value="Operacion/dropMaterial" ,method = RequestMethod.GET )
    public   @ResponseBody
    String extraerMaterial(HttpServletRequest request,
                           @NotNull @RequestParam(value="lanzadera",required = true ,defaultValue = "-1") int lanzadera,
                           @NotNull @RequestParam(value = "entablado",required = true, defaultValue = "-1") int entablado,
                           @NotNull @RequestParam(value = "xPos",required = true, defaultValue = "-1") int xPos,
                           @NotNull @RequestParam(value = "yPos",required = true,defaultValue = "-1") int yPos,
                           @NotNull @RequestParam(value = "articulo" ,required = true) String articulo,
                           @NotNull @RequestParam(value = "cantidad" ,required = true ,defaultValue = "-1") int cantidad) throws Exception {
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        Lanzadera l =lanzaderaService.getLanzadera(lanzadera);
        Entablado e=entabladoService.getEstanteria(l,entablado);
        CajaEntablado c=locationService.getCajasEntablado(l,e,xPos,yPos);
        //peso entablado
        //huecos entablado

        if(c!=null) {
            e.setPesoActual(e.getPesoActual()-(c.getArticulo().getPeso()*cantidad));
            if (c.getCantidad() - cantidad == 0)
                c.setEsVacia((byte) 1);
            c.setCantidad(c.getCantidad() - cantidad);
            c.setPeso(c.getPeso()- (c.getArticulo().getPeso()*cantidad));
            actualizarCantidad(c);

            //añadir al historico
            Historico h=new Historico();
            h.setId_historico(1);
            h.setLanzadera(l);
            h.setEntablado(e);
            h.setFila(yPos);
            h.setColumna(xPos);
            TipoMovimiento  tm=new TipoMovimiento();
            tm.setId_tipoMovimiento(2);
            h.setTipoMovimiento(tm);
            h.setArticulo(c.getArticulo());
            h.setCantidad(cantidad);
            crearHistorio(h);

        }else{
            CajaEntabladoMedida c1=cajaEntabladoMedidaService.getCajasEntablado(l,e,xPos,yPos);
            e.setPesoActual(e.getPesoActual()-(c1.getArticulo().getPeso()*cantidad));
            if (c1.getCantidad() - cantidad == 0)
                c1.setEsVacia((byte) 1);
            c1.setCantidad(c1.getCantidad() - cantidad);
            c1.setPeso(c1.getPeso()- (c1.getArticulo().getPeso()*cantidad));
            actualizarCantidad(c1);

            //añadir al historico
            Historico h=new Historico();
            h.setId_historico(1);
            h.setLanzadera(l);
            h.setEntablado(e);
            h.setFila(yPos);
            h.setColumna(xPos);
            TipoMovimiento  tm=new TipoMovimiento();
            tm.setId_tipoMovimiento(2);
            h.setTipoMovimiento(tm);
            h.setArticulo(c1.getArticulo());
            h.setCantidad(cantidad);
            crearHistorio(h);


        }
        entabladoService.addOrUpdateCajaEntablado(e);
        JSONObject outputJsonObj = new JSONObject();
        outputJsonObj.put("res","true");
        return outputJsonObj.toString();
    }

    @RequestMapping(value="Operacion/regularizarCajaMedida" ,method = RequestMethod.GET )
    public   @ResponseBody
    String regularizarMaterialMedida(HttpServletRequest request,
                                     @NotNull @RequestParam(value="lanzadera",required = true ,defaultValue = "-1") int lanzadera,
                                     @NotNull @RequestParam(value = "entablado",required = true, defaultValue = "-1") int entablado,
                                     @NotNull @RequestParam(value = "xPos",required = true, defaultValue = "-1") int xPos,
                                     @NotNull @RequestParam(value = "yPos",required = true,defaultValue = "-1") int yPos,
                                     @NotNull @RequestParam(value = "cantidad" ,required = true) int cantidad) throws Exception {
        Lanzadera l =lanzaderaService.getLanzadera(lanzadera);
        Entablado e=entabladoService.getEstanteria(l,entablado);
        CajaEntabladoMedida c=cajaEntabladoMedidaService.getCajasEntablado(l,e,xPos,yPos);
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }


        if(c.getCantidad()<cantidad)
            e.setPesoActual(e.getPesoActual()+(c.getArticulo().getPeso()*(cantidad-c.getCantidad())));
        else
            e.setPesoActual(e.getPesoActual()-(c.getArticulo().getPeso()*(c.getCantidad()-cantidad)));
        //actualizar entablado
        entabladoService.addOrUpdateCajaEntablado(e);
        c.setCantidad(cantidad);
        if(c.getCantidad()==0.0)
            c.setEsVacia((byte)1);
        else if(c.getCantidad()>0.0)
            c.setEsVacia((byte)-1);
        actualizarCantidad(c);


        //añadir al historico
        Historico h=new Historico();
        h.setId_historico(1);
        h.setLanzadera(l);
        h.setEntablado(e);
        h.setFila(yPos);
        h.setColumna(xPos);
        TipoMovimiento  tm=new TipoMovimiento();
        tm.setId_tipoMovimiento(3);
        h.setTipoMovimiento(tm);
        h.setArticulo(c.getArticulo());
        h.setCantidad(c.getCantidad());
        crearHistorio(h);

        JSONObject outputJsonObj = new JSONObject();
        outputJsonObj.put("res","true");
        return outputJsonObj.toString();
    }

    @RequestMapping(value="Operacion/CrearUbicacionMedida" ,method = RequestMethod.GET )
    public   @ResponseBody
    String crearUbicacionMedida(HttpServletRequest request,
                                @NotNull @RequestParam(value="lanzadera",required = true ,defaultValue = "-1") int lanzadera,
                                @NotNull @RequestParam(value = "entablado",required = true, defaultValue = "-1") int entablado,
                                @NotNull @RequestParam(value = "xPos",required = true, defaultValue = "-1") int xPos,
                                @NotNull @RequestParam(value = "yPos",required = true,defaultValue = "-1") int yPos,
                                @NotNull @RequestParam(value = "articulo" ,required = true) String articulo,
                                @NotNull @RequestParam(value = "cantidad" ,required = true ,defaultValue = "-1") int cantidad,
                                @NotNull @RequestParam(value = "xCoord",required = true ,defaultValue = "13") double xCoord ,
                                @NotNull @RequestParam(value = "yCoord",required = true ,defaultValue = "13") double yCoord ,
                                @NotNull @RequestParam(value = "nfilas",required = true ,defaultValue = "0") int nfilas ,
                                @NotNull @RequestParam(value = "ncolumnas",required = true ,defaultValue = "0") int ncolumnas )throws Exception {
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
        if(lanzadera==-1 || entablado==-1 || xPos==-1 || yPos==-1 || articulo.equals("") || cantidad==-1.0) {
            System.out.println(lanzadera+" "+entablado+" "+xPos+" "+yPos+" "+articulo+" "+cantidad);
            outputJsonObj.put("res","false");
        }
        //introducir posicion en la BD
        else{
            Lanzadera lanz=lanzaderaService.getLanzadera(lanzadera);
            Entablado e=entabladoService.getEstanteria(lanz,entablado);
            Articulo a=articuloService.getArticulo(articulo);
            CajaEntabladoMedida l= new CajaEntabladoMedida();
            l.setLanzadera(lanz);
            l.setEntablado(e);
            l.setFila(xPos);
            l.setColumna(yPos);
            l.setxPos(xCoord);
            l.setyPos(yCoord);
            l.setNfilas(nfilas);
            l.setNcolumnas(ncolumnas);
            l.setArticulo(a);
            l.setCantidad(cantidad);
            l.setPeso(0.0);
            l.setEsVacia((byte)-1);
            l.setEsReservado((byte)-1);
            l.setFechaCreacion(new Date(Calendar.getInstance().getTimeInMillis()));
            l.setFechaActualizacion(new Date(Calendar.getInstance().getTimeInMillis()));
            l.setTs(new Timestamp(Calendar.getInstance().getTimeInMillis()));

            e.setPesoActual(e.getPesoActual()+(l.getArticulo().getPeso()*cantidad));
            e.setHuecosLibres(e.getHuecosLibres()+(l.getNfilas()*l.getNcolumnas()));
            //actualizar entablado
            entabladoService.addOrUpdateCajaEntablado(e);
            crearUbicacion(l);

            //añadir al historico
            outputJsonObj.put("res","true");
            Historico h=new Historico();
            h.setId_historico(1);
            h.setLanzadera(lanz);
            h.setEntablado(e);
            h.setFila(yPos);
            h.setColumna(xPos);
            TipoMovimiento  tm=new TipoMovimiento();
            tm.setId_tipoMovimiento(1);
            h.setTipoMovimiento(tm);
            h.setArticulo(a);
            h.setCantidad(cantidad);
            crearHistorio(h);
            outputJsonObj.put("res","true");
        }
        return outputJsonObj.toString();
    }


    @RequestMapping(value="Operacion/CrearLanzadera" ,method = RequestMethod.GET )
    public   @ResponseBody
    String crearLanzadera(HttpServletRequest request,
                          @NotNull @RequestParam(value="alias",required = true ,defaultValue = "") String alias,
                          @NotNull @RequestParam(value = "descripcion",required = true, defaultValue = "") String descripcion,
                          @NotNull @RequestParam(value = "direccionIp",required = true, defaultValue = "") String direccionIp,
                          @NotNull @RequestParam(value = "pesoMax",required = true,defaultValue = "250000.0") double pesoMax,
                          @NotNull @RequestParam(value = "pAcesso",required = true,defaultValue = "000") String pAcesso,
                          @NotNull @RequestParam(value = "nMaxEntablado" ,required = true , defaultValue = "50") int nMaxEntablados )throws Exception {
        JSONObject outputJsonObj = new JSONObject();
        Lanzadera l=new Lanzadera();
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        l.setAlias_lanzadera(alias);
        l.setDescripcion(descripcion);
        l.setDireccion_ip(direccionIp);
        l.setPunto_acesso(pAcesso);
        l.setPeso_max(pesoMax);
        l.setNum_entablados(nMaxEntablados);
        l.setNum_filas(8);
        l.setNum_columnas(16);
        lanzaderaService.addOrUpdateLanzadera(l);
        l=lanzaderaService.getLanzaderaIp(direccionIp);
        //añadir Entablados

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        for(int i=1;i<=nMaxEntablados;i++){
            Entablado entablado=new Entablado();
            entablado.setLanzadera(l);
            entablado.setId_entablado(i);
            entablado.setDescripcion("Entablado "+i);
            entablado.setPesoMaximo(400.000);
            entablado.setPesoActual(0.000);
            entablado.setHuecosLibres(512);
            session.save(entablado);
            if ( i % 20 == 0 ) { //20, same as the JDBC batch size
                //flush a batch of inserts and release memory:
                session.flush();
                session.clear();
            }

        }
        tx.commit();
        session.close();
        outputJsonObj.put("res","true");

        return outputJsonObj.toString();
    }


    @RequestMapping(value="Operacion/ModificarLanzadera" ,method = RequestMethod.GET )
    public   @ResponseBody
    String crearLanzadera(HttpServletRequest request,
                          @NotNull @RequestParam(value = "idLanzadera",required = true ,defaultValue = "-1") int id_lanzadera,
                          @NotNull @RequestParam(value = "alias",required = true ,defaultValue = "") String alias,
                          @NotNull @RequestParam(value = "descripcion",required = true, defaultValue = "") String descripcion,
                          @NotNull @RequestParam(value = "direccionIp",required = true, defaultValue = "") String direccionIp,
                          @NotNull @RequestParam(value = "pesoMax",required = true,defaultValue = "0.0") double pesoMax,
                          @NotNull @RequestParam(value = "pAcesso",required = true,defaultValue = "000") String pAcesso,
                          @NotNull @RequestParam(value = "nMaxEntablado" ,required = true , defaultValue = "-1") int nMaxEntablados )throws Exception {
        JSONObject outputJsonObj = new JSONObject();
        Lanzadera l=lanzaderaService.getLanzadera(id_lanzadera);
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        if(!alias.equals("")) l.setAlias_lanzadera(alias);
        if(!descripcion.equals("")) l.setDescripcion(descripcion);
        if(!direccionIp.equals("")) l.setDireccion_ip(direccionIp);
        if(pesoMax!=0.0) l.setPeso_max(pesoMax);
        if(!pAcesso.equals("000")) l.setPunto_acesso(pAcesso);
        //crear o remover entablados
        if(nMaxEntablados!=-1) {
            if (l.getNum_entablados() > nMaxEntablados) {
                //borrar entablados
                Session session = sessionFactory.openSession();
                Transaction tx = session.beginTransaction();
                for(int i=nMaxEntablados;i<=l.getNum_entablados();i++){
                    session.delete(entabladoService.getEstanteria(l,i));
                    if ( i % 10 == 0 ) { //20, same as the JDBC batch size
                        //flush a batch of inserts and release memory:
                        session.flush();
                        session.clear();
                    }
                }
                session.flush();
                tx.commit();
                l.setNum_entablados(nMaxEntablados);
            }
            else if (l.getNum_entablados() < nMaxEntablados) {
                //añadir entablados
                Session session = sessionFactory.openSession();
                Transaction tx = session.beginTransaction();
                for(int i=l.getNum_entablados();i<=nMaxEntablados;i++){
                    Entablado e=new Entablado();
                    e.setLanzadera(l);
                    e.setId_entablado(i);
                    e.setDescripcion("Entablado "+i);
                    e.setPesoMaximo(400.00);
                    e.setPesoActual(0.00);
                    e.setHuecosLibres(512);
                    session.save(e);
                    if ( i % 10 == 0 ) { //20, same as the JDBC batch size
                        //flush a batch of inserts and release memory:
                        session.flush();
                        session.clear();
                    }
                }
                session.flush();
                tx.commit();
                l.setNum_entablados(nMaxEntablados);
            }
        }
        lanzaderaService.addOrUpdateLanzadera(l);
        outputJsonObj.put("res","true");
        return outputJsonObj.toString();
    }


    @RequestMapping(value="Operacion/CrearAcessoLanzadera" ,method = RequestMethod.GET )
    public   @ResponseBody
    String crearAcesoLanzadera(HttpServletRequest request,
                               @NotNull @RequestParam(value="ipOrdenador",required = true ,defaultValue = "") String ipOrdenador,
                               @NotNull @RequestParam(value = "descripcion",required = true, defaultValue = "") String descripcion,
                               @NotNull @RequestParam(value = "idLanzadera",required = true, defaultValue = "-1") int idLanzadera)throws Exception {
        JSONObject outputJsonObj = new JSONObject();
        AcessoLanzadera acessoLanzadera=new AcessoLanzadera();
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        acessoLanzadera.setLanzadera(lanzaderaService.getLanzadera(idLanzadera));
        acessoLanzadera.setIpOrdenador(ipOrdenador);
        acessoLanzadera.setDescripcionOrdenador(descripcion);
        acessoLazaderasService.addOrUpdate(acessoLanzadera);
        outputJsonObj.put("res","true");

        return outputJsonObj.toString();
    }

    @RequestMapping(value="Operacion/BorrarAcessoLanzadera" ,method = RequestMethod.GET )
    public   @ResponseBody
    String borrarAcesoLanzadera(HttpServletRequest request,
                                @NotNull @RequestParam(value="idLanzadera",required = true ,defaultValue = "") int idLanzadera,
                                @NotNull @RequestParam(value = "ipOrdenador",required = true, defaultValue = "") String ipOrdenador)throws Exception {
        JSONObject outputJsonObj = new JSONObject();
        AcessoLanzadera acessoLanzadera=new AcessoLanzadera();
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        acessoLanzadera.setLanzadera(lanzaderaService.getLanzadera(idLanzadera));
        acessoLanzadera.setIpOrdenador(ipOrdenador);
        acessoLazaderasService.remove(acessoLanzadera);
        outputJsonObj.put("res","true");
        return outputJsonObj.toString();
    }




    @RequestMapping(value="Operacion/ModificarAcesoLanzadera" ,method = RequestMethod.GET )
    public   @ResponseBody
    String modificarAcessoLanzadera(HttpServletRequest request,
                                    @NotNull @RequestParam(value = "idLanzaderaActual",required = true ,defaultValue = "-1") int idLanzaderaActual,
                                    @NotNull @RequestParam(value = "idLanzadera",required = true ,defaultValue = "-1") int idLanzadera,
                                    @NotNull @RequestParam(value = "ipOrdenador",required = true, defaultValue = "") String ipOrdenador,
                                    @NotNull @RequestParam(value = "descripcionOrdenador",required = true, defaultValue = "") String descripcionOrdenador)throws Exception {
        JSONObject outputJsonObj = new JSONObject();
        AcessoLanzadera acesso=acessoLazaderasService.getAcesso(lanzaderaService.getLanzadera(idLanzaderaActual),ipOrdenador);
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        if(idLanzaderaActual!=idLanzadera){
            //actualizar lanzadera
            acesso.setLanzadera(lanzaderaService.getLanzadera(idLanzadera));
        }
        if(!ipOrdenador.equals(acesso.getIpOrdenador())) acesso.setIpOrdenador(ipOrdenador);
        if(!descripcionOrdenador.equals(acesso.getDescripcionOrdenador())) acesso.setDescripcionOrdenador(descripcionOrdenador);
        acessoLazaderasService.addOrUpdate(acesso);
        outputJsonObj.put("res","true");
        return outputJsonObj.toString();
    }

    @RequestMapping(value="Operacion/BorrarLanzadera" ,method = RequestMethod.GET )
    public   @ResponseBody
    String borrarLanzadera(HttpServletRequest request,
                           @NotNull @RequestParam(value="idLanzadera",required = true ,defaultValue = "") int id_lanzadera)throws Exception {
        JSONObject outputJsonObj = new JSONObject();
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        lanzaderaService.deleteLanzadera(lanzaderaService.getLanzadera(id_lanzadera));
        return outputJsonObj.toString();
    }



    @RequestMapping(value="Operacion/TareaNuevaUbicacion" ,method = RequestMethod.GET )
    public   @ResponseBody
    String tareaNuevaUbicacion(HttpServletRequest request,
                               @NotNull @RequestParam(value="lanzadera",required = true ,defaultValue = "-1") int id_lanzadera,
                               @NotNull @RequestParam(value="url",required = true ,defaultValue = "") String url,
                               @NotNull @RequestParam(value="articulo",required = true ,defaultValue = "000000000") String articulo,
                               @NotNull @RequestParam(value="cantidad",required = true ,defaultValue = "-1") double cantidad,
                               @NotNull @RequestParam(value="accion",required = true ,defaultValue = "-1") int accion)throws Exception {
        JSONObject outputJsonObj = new JSONObject();
        TareasPendientes tareasPendientes=new TareasPendientes();
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        tareasPendientes.setLanzadera(lanzaderaService.getLanzadera(id_lanzadera));
        tareasPendientes.setAccion(accionesService.getAccion(accion));
        tareasPendientes.setArticulo(articuloService.getArticulo(articulo));
        tareasPendientes.setCantidad(cantidad);
        tareasPendientes.setURL(url);
        tareasPendientesService.addOrUpdate(tareasPendientes);
        return outputJsonObj.toString();
    }



    @RequestMapping(value="Operacion/CrearUbicacion" ,method = RequestMethod.GET )
    public   @ResponseBody
    String crearUbicacion(HttpServletRequest request,
                          @NotNull @RequestParam(value="lanzadera",required = true ,defaultValue = "-1") int lanzadera,
                          @NotNull @RequestParam(value = "entablado",required = true, defaultValue = "-1") int entablado,
                          @NotNull @RequestParam(value = "xPos",required = true, defaultValue = "-1") int xPos,
                          @NotNull @RequestParam(value = "yPos",required = true,defaultValue = "-1") int yPos,
                          @NotNull @RequestParam(value = "articulo" ,required = true) String articulo,
                          @NotNull @RequestParam(value = "cantidad" ,required = true ,defaultValue = "-1") int cantidad,
                          @NotNull @RequestParam(value = "caja",required = true ,defaultValue = "13") int caja,
                          @NotNull @RequestParam(value = "xCoord",required = true ,defaultValue = "13") double xCoord ,
                          @NotNull @RequestParam(value = "yCoord",required = true ,defaultValue = "13") double yCoord ) throws Exception {
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
        if(lanzadera==-1 || entablado==-1 || xPos==-1 || yPos==-1 || articulo.equals("") || cantidad==-1.0) {
            System.out.println(lanzadera+" "+entablado+" "+xPos+" "+yPos+" "+articulo+" "+cantidad);
            outputJsonObj.put("res","false");
        }
        //introducir posicion en la BD
        else{
            Lanzadera lanz=lanzaderaService.getLanzadera(lanzadera);
            Entablado e=entabladoService.getEstanteria(lanz,entablado);
            System.out.println(articulo);
            Articulo a=articuloService.getArticulo(articulo);
            CajaEntablado l= new CajaEntablado();
            l.setLanzadera(lanz);
            l.setEntablado(e);
            l.setFila(xPos);
            l.setColumna(yPos);
            l.setxPos(xCoord);
            l.setyPos(yCoord);
            l.setArticulo(a);
            l.setTipoCaja(tipoCajaService.getTipoCaja(caja));
            l.setCantidad(cantidad);
            l.setPeso(l.getPeso()+(a.getPeso()*cantidad));
            l.setEsVacia((byte)-1);
            l.setEsReservado((byte)-1);
            l.setFechaCreacion(new Date(Calendar.getInstance().getTimeInMillis()));
            l.setFechaActualizacion(new Date(Calendar.getInstance().getTimeInMillis()));
            l.setTs(new Timestamp(Calendar.getInstance().getTimeInMillis()));
            e.setPesoActual(e.getPesoActual()+(l.getArticulo().getPeso()*cantidad));
            e.setHuecosLibres(e.getHuecosLibres()-l.getTipoCaja().getNum_huecos());
            //actualizar entablado
            entabladoService.addOrUpdateCajaEntablado(e);
            crearUbicacion(l);
            //añadir al historico
            outputJsonObj.put("res","true");
            Historico h=new Historico();
            h.setId_historico(1);
            h.setLanzadera(lanz);
            h.setEntablado(e);
            h.setFila(yPos);
            h.setColumna(xPos);
            TipoMovimiento  tm=new TipoMovimiento();
            tm.setId_tipoMovimiento(1);
            h.setTipoMovimiento(tm);
            h.setArticulo(a);
            h.setCantidad(cantidad);
            crearHistorio(h);
        }
        return outputJsonObj.toString();
    }


    /**
     * OPERACIONES SOBRE BD
     * @param ubicacion
     * @throws SQLException
     */

    private void borrarCaja(CajaEntablado ubicacion) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.2.2:3306/osca_localizacion","osca","osca");
            String insertTableSQL = "DELETE  FROM cajas_entablado WHERE Id_Lanzadera=? AND Id_entablado=? AND fila=? AND columna=?;";
            preparedStatement= conn.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1,ubicacion.getLanzadera().getId_lanzadera());
            preparedStatement.setInt(2,ubicacion.getEntablado().getId_entablado());
            preparedStatement.setInt(3,ubicacion.getFila());
            preparedStatement.setInt(4,ubicacion.getColumna());
            preparedStatement .executeUpdate();
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
        PreparedStatement preparedStatement=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.2.2:3306/osca_localizacion","osca","osca");
            String insertTableSQL = "INSERT INTO historico"
                    + "(Id_lanzadera, Id_entablado,Id_tipoMovimiento,usuario, fila, columna,Articulo,Cantidad,fecha) VALUES"
                    + "(?,?,?,?,?,?,?,?,?)";
            preparedStatement= conn.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1,h.getLanzadera().getId_lanzadera());
            preparedStatement.setInt(2,h.getEntablado().getId_entablado());
            preparedStatement.setInt(3,h.getTipoMovimiento().getId_tipoMovimiento());
            preparedStatement.setString(4,h.getUsuario());
            preparedStatement.setInt(5,h.getFila());
            preparedStatement.setInt(6,h.getColumna());
            preparedStatement.setString(7,h.getArticulo().getArticulo());
            preparedStatement.setDouble(8,h.getCantidad());
            preparedStatement.setTimestamp(9,h.getFecha());
            preparedStatement .executeUpdate();
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


    private void actualizarCantidad(CajaEntablado ubicacion) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.2.2:3306/osca_localizacion","osca","osca");
            String insertTableSQL = "UPDATE cajas_entablado SET Cantidad=? , esVacia=? WHERE Id_Lanzadera=? AND Id_entablado=? AND fila=? AND columna=?";
            preparedStatement= conn.prepareStatement(insertTableSQL);
            preparedStatement.setDouble(1,ubicacion.getCantidad());
            preparedStatement.setDouble(2,ubicacion.getEsVacia());
            preparedStatement.setInt(3,ubicacion.getLanzadera().getId_lanzadera());
            preparedStatement.setInt(4,ubicacion.getEntablado().getId_entablado());
            preparedStatement.setInt(5,ubicacion.getFila());
            preparedStatement.setDouble(6,ubicacion.getColumna());
            preparedStatement .executeUpdate();
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




    private void actualizarCantidad(CajaEntabladoMedida ubicacion) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.2.2:3306/osca_localizacion","osca","osca");
            String insertTableSQL = "UPDATE cajas_entablado_medida SET Cantidad=? , esVacia=? WHERE Id_Lanzadera=? AND Id_entablado=? AND fila=? AND columna=?";
            preparedStatement= conn.prepareStatement(insertTableSQL);
            preparedStatement.setDouble(1,ubicacion.getCantidad());
            preparedStatement.setDouble(2,ubicacion.getEsVacia());
            preparedStatement.setInt(3,ubicacion.getLanzadera().getId_lanzadera());
            preparedStatement.setInt(4,ubicacion.getEntablado().getId_entablado());
            preparedStatement.setInt(5,ubicacion.getFila());
            preparedStatement.setDouble(6,ubicacion.getColumna());
            preparedStatement .executeUpdate();
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


    private void crearUbicacion(CajaEntablado ubicacion) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.2.2:3306/osca_localizacion","osca","osca");
            String insertTableSQL = "INSERT INTO cajas_entablado"
                    + "(Id_lanzadera, Id_entablado, fila, columna,xPos,yPos,Articulo,Id_caja,Cantidad,Peso,esVacia,esReservado,fechaCreacion,fechaActualizacion) VALUES"
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement= conn.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1,ubicacion.getLanzadera().getId_lanzadera());
            preparedStatement.setInt(2,ubicacion.getEntablado().getId_entablado());
            preparedStatement.setInt(3,ubicacion.getFila());
            preparedStatement.setInt(4,ubicacion.getColumna());
            preparedStatement.setDouble(5,ubicacion.getxPos());
            preparedStatement.setDouble(6,ubicacion.getyPos());
            preparedStatement.setString(7,ubicacion.getArticulo().getArticulo());
            preparedStatement.setInt(8,ubicacion.getTipoCaja().getId_caja());
            preparedStatement.setDouble(9,ubicacion.getCantidad());
            preparedStatement.setDouble(10,ubicacion.getPeso());
            preparedStatement.setByte(11,ubicacion.getEsVacia());
            preparedStatement.setByte(12,ubicacion.getEsReservado());
            preparedStatement.setDate(13,ubicacion.getFechaCreacion());
            preparedStatement.setDate(14,ubicacion.getFechaActualizacion());
            preparedStatement .executeUpdate();
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

    private void crearUbicacion(CajaEntabladoMedida ubicacion) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.2.2:3306/osca_localizacion","osca","osca");
            String insertTableSQL = "INSERT INTO cajas_entablado_medida"
                    + "(Id_lanzadera, Id_entablado, fila, columna,xPos,yPos,nfilas,ncolumnas,Articulo,Cantidad,Peso,esVacia,esReservado,fechaCreacion,fechaActualizacion) VALUES"
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement= conn.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1,ubicacion.getLanzadera().getId_lanzadera());
            preparedStatement.setInt(2,ubicacion.getEntablado().getId_entablado());
            preparedStatement.setInt(3,ubicacion.getFila());
            preparedStatement.setInt(4,ubicacion.getColumna());
            preparedStatement.setDouble(5,ubicacion.getxPos());
            preparedStatement.setDouble(6,ubicacion.getyPos());
            preparedStatement.setInt(7,ubicacion.getNfilas());
            preparedStatement.setInt(8,ubicacion.getNcolumnas());
            preparedStatement.setString(9,ubicacion.getArticulo().getArticulo());
            preparedStatement.setDouble(10,ubicacion.getCantidad());
            preparedStatement.setDouble(11,ubicacion.getPeso());
            preparedStatement.setByte(12,ubicacion.getEsVacia());
            preparedStatement.setByte(13,ubicacion.getEsReservado());
            preparedStatement.setDate(14,ubicacion.getFechaCreacion());
            preparedStatement.setDate(15,ubicacion.getFechaActualizacion());
            preparedStatement .executeUpdate();
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
}
