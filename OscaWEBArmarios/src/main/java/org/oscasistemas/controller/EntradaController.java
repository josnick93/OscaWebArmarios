package org.oscasistemas.controller;

import com.dynamics.webServices.Warehouse_Receipt_Line_WS.WarehouseReceiptLineWSFilter;
import com.dynamics.webServices.Warehouse_Receipt_Line_WS.WarehouseReceiptLineWSList;
import com.dynamics.webServices.Warehouse_Receipt_Line_WS.WarehouseReceiptLineWSPort;
import com.dynamics.webServices.Warehouse_Receipt_Line_WS.WarehouseReceiptLineWSService;
import com.dynamics.webServices.Warehouse_Shipment_Header_WS.WarehouseShipmentHeaderWSFields;
import com.dynamics.webServices.Warehouse_Shipment_Header_WS.WarehouseShipmentHeaderWSFilter;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import org.jboss.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.*;
import org.oscasistemas.model.*;
import org.oscasistemas.service.interfaces.IArticuloService;
import org.oscasistemas.util.ConexionArmario;
import org.oscasistemas.util.Posiciones;
import org.oscasistemas.util.SugerirUbicaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Portátil1 on 26/07/2017.
 */
@RestController
public class EntradaController {

    @Autowired (required = true)
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


    private static final Logger logger = Logger.getLogger(EntradaController.class);

    public EntradaController() {
        System.out.println("EntradaManualController()");
    }



    //EntradaSeleccionArticulo
    @RequestMapping(value="/EntradaSeleccionArticulo")
    public ModelAndView entradaSeleccionArticuloPage() {
        return new ModelAndView("EntradaSeleccionArticulo");
    }




    @RequestMapping(value="/EntradaSugerirUbicacionFinalMedida")
    public ModelAndView entradaSugerirUbicacionFinalMedidaPage(HttpServletRequest request,
                                                               @NotNull @RequestParam(value="articulo", required=false) String articulo,
                                                               @NotNull @RequestParam(value="lanzadera", required=false , defaultValue = "-1") int lanzadera,
                                                               @NotNull @RequestParam(value="cantidad", required=false  , defaultValue = "-1") int cantidad,
                                                               @NotNull @RequestParam(value="cajafila", required = false , defaultValue = "-1") int cajafila,
                                                               @NotNull @RequestParam(value="cajacolumna", required = false , defaultValue = "-1") int cajacolumna,
                                                               @NotNull @RequestParam(value="nsugerencia", required = false , defaultValue = "0") int nsugerencia,
                                                               @NotNull @RequestParam(value="cerrar", required=false  , defaultValue = "-1") int cerrar) {
        ModelAndView m=new ModelAndView("EntradaSugerirUbicacionFinalMedida");
        Articulo a=articuloService.getArticulo(articulo);
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }


        //listar entablados que no superen el peso y no esten vacios
        List<Entablado> posiblesEntablados=entabladoService.getEstanteriasNoSuperanPesoMedida(l,a.getPeso()*cantidad,cajafila,cajacolumna);
        List<CajaEntablado> ubicaciones=locationService.getCajasEntablado(l,posiblesEntablados.get(nsugerencia));
        List<CajaEntabladoMedida> reservas=cajaEntabladoMedidaService.getCajasEntablado(l,posiblesEntablados.get(nsugerencia));
        //buscarPosiciones
        List<Posiciones> posiciones=null;
        List<Posiciones> posicionesSubdivision=new ArrayList<Posiciones>();
        while((posiciones= SugerirUbicaciones.obtenerPosicionesMedida(ubicaciones,reservas,cajafila,cajacolumna)).isEmpty()){
            nsugerencia++;
            ubicaciones=locationService.getCajasEntablado(l,posiblesEntablados.get(nsugerencia));
            reservas=cajaEntabladoMedidaService.getCajasEntablado(l,posiblesEntablados.get(nsugerencia));
        }


        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("entablado",posiblesEntablados.get(nsugerencia));
        m.getModelMap().addAttribute("articulo",a);
        m.getModelMap().addAttribute("nsugerencia",nsugerencia);
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("ubicaciones", ubicaciones);
        m.getModelMap().addAttribute("reservas", reservas);
        m.getModelMap().addAttribute("nFilasCaja", cajafila);
        m.getModelMap().addAttribute("nColumnasCaja", cajacolumna);
        m.getModelMap().addAttribute("posiblesPosiciones", new Gson().toJson(posiciones) );
        m.getModelMap().addAttribute("posiblesPosicionesSubdivision", new Gson().toJson(posicionesSubdivision) );
        m.getModelMap().addAttribute("v", new Gson().toJson(posicionesSubdivision) );
        m.getModelMap().addAttribute("cerrar", cerrar );
        return m;
    }

    /**
     *
     * @param articulo
     * @param lanzadera
     * @param cantidad
     * @return
     */
    //EntradaSugerirUbicacionfinal
    @RequestMapping(value="/EntradaSugerirUbicacionFinal")
    public ModelAndView entradaSugerirUbicacionFinalPage(HttpServletRequest request,
                                                         @NotNull @RequestParam(value="articulo", required=false) String articulo,
                                                         @NotNull @RequestParam(value="lanzadera", required=false , defaultValue = "-1") int lanzadera,
                                                         @NotNull @RequestParam(value="cantidad", required=false  , defaultValue = "-1") int cantidad,
                                                         @NotNull @RequestParam(value="caja", required = false , defaultValue = "-1") int caja,
                                                         @NotNull @RequestParam(value="nsugerencia", required = false , defaultValue = "0") int nsugerencia,
                                                         @NotNull @RequestParam(value="cerrar", required=false  , defaultValue = "-1") int cerrar) {
        ModelAndView m=new ModelAndView("EntradaSugerirUbicacionFinal");
        Articulo a=articuloService.getArticulo(articulo);
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        TipoCaja c=tipoCajaService.getTipoCaja(caja);
          /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

        //listar entablados que no superen el peso y no esten vacios
        List<Entablado> posiblesEntablados=entabladoService.getEstanteriasNoSuperanPeso(l,a.getPeso()*cantidad,c);
        List<CajaEntablado> ubicaciones=locationService.getCajasEntablado(l,posiblesEntablados.get(nsugerencia));
        List<CajaEntabladoMedida> reservas=cajaEntabladoMedidaService.getCajasEntablado(l,posiblesEntablados.get(nsugerencia));
        SugerirUbicaciones.obtenerPosicionesSubdivision2x1(ubicaciones,c);
        //buscarPosiciones
        List<Posiciones> posiciones=null;
        List<Posiciones> posicionesSubdivision=new ArrayList<Posiciones>();
        posiciones=SugerirUbicaciones.obtenerPosiciones(ubicaciones,reservas,c);
        if(c.getId_caja()==10){
            posicionesSubdivision=SugerirUbicaciones.obtenerPosicionesSubdivision2x1(ubicaciones,c);
        }else if(c.getId_caja()==11){
            posicionesSubdivision=SugerirUbicaciones.obtenerPosicionesSubdivision1x1(ubicaciones,c);
        }
        while((posiciones=SugerirUbicaciones.obtenerPosiciones(ubicaciones,reservas,c)).isEmpty()){
            nsugerencia++;
            ubicaciones=locationService.getCajasEntablado(l,posiblesEntablados.get(nsugerencia));
            reservas=cajaEntabladoMedidaService.getCajasEntablado(l,posiblesEntablados.get(nsugerencia));
            if(c.getId_caja()==10){
                posicionesSubdivision=SugerirUbicaciones.obtenerPosicionesSubdivision2x1(ubicaciones,c);
            }else if(c.getId_caja()==11){
                posicionesSubdivision=SugerirUbicaciones.obtenerPosicionesSubdivision1x1(ubicaciones,c);
            }
        }

        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("entablado",posiblesEntablados.get(nsugerencia));
        m.getModelMap().addAttribute("articulo",a);
        m.getModelMap().addAttribute("nsugerencia",nsugerencia);
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("ubicaciones", ubicaciones);
        m.getModelMap().addAttribute("reservas", reservas);
        m.getModelMap().addAttribute("TipoCaja", c);
        m.getModelMap().addAttribute("posiblesPosiciones", new Gson().toJson(posiciones) );
        m.getModelMap().addAttribute("posiblesPosicionesSubdivision", new Gson().toJson(posicionesSubdivision) );
        m.getModelMap().addAttribute("cerrar", cerrar);
        return m;
    }


    //EntradaSeleccionUbicacionfinal
    @RequestMapping(value="/EntradaSeleccionUbicacionFinal")
    public ModelAndView entradaSeleccionUbicacionFinalPage(HttpServletRequest request,
                                                           @NotNull @RequestParam(value="articulo", required=false) String articulo,
                                                           @NotNull @RequestParam(value="lanzadera", required=false , defaultValue = "-1") int lanzadera,
                                                           @NotNull @RequestParam(value="entablado", required=false , defaultValue = "-1") int entablado,
                                                           @NotNull @RequestParam(value="fila", required=false  , defaultValue = "-1") int fila,
                                                           @NotNull @RequestParam(value="columna", required=false  , defaultValue = "-1") int columna,
                                                           @NotNull @RequestParam(value="cantidad", required=false  , defaultValue = "-1") int cantidad,
                                                           @NotNull @RequestParam(value="cerrar", required=false  , defaultValue = "-1") int cerrar) {
        ModelAndView m=new ModelAndView("EntradaSeleccionUbicacionFinal");
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        Entablado e=entabladoService.getEstanteria(l,entablado);
          /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("localizacionArticulo", locationService.getCajasEntablado(l,e,fila,columna));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(l,entabladoService.getEstanteria(l,entablado)));
        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(l,entabladoService.getEstanteria(l,entablado)));
        m.getModelMap().addAttribute("cerrar", cerrar);
        return m;
    }


    @RequestMapping(value="/EntradaSeleccionTipoCajaNuevaUbi" ,method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView entradaSeleccionTipoCajaNuevaUbi(HttpServletRequest request,
                                                         @NotNull @RequestParam(value = "articulo" ,required = true) String articulo,
                                                         @NotNull @RequestParam(value = "cantidad" ,required = true) String cantidad,
                                                         @NotNull @RequestParam(value = "lanzadera" ,required = true) int id_lanzadera,
                                                         @NotNull @RequestParam(value="cerrar", required=false  , defaultValue = "-1") int cerrar) {
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        ModelAndView m=new ModelAndView("EntradaSeleccionTipoCajaNuevaUbi");
        m.getModelMap().addAttribute("articulo", articuloService.getArticulo(articulo));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("lanzadera", lanzaderaService.getLanzadera(id_lanzadera));
        m.getModelMap().addAttribute("cajas", tipoCajaService.getCajas());
        m.getModelMap().addAttribute("cerrar", cerrar);
        return m;
    }





    @RequestMapping(value="/EntradaSeleccionTipoCajaSugerirUbi" ,method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView entradaSeleccionTipoCajaSugerirUbi(HttpServletRequest request,
                                                           @NotNull @RequestParam(value = "articulo" ,required = true) String articulo,
                                                           @NotNull @RequestParam(value = "cantidad" ,required = true) String cantidad,
                                                           @NotNull @RequestParam(value = "lanzadera" ,required = true , defaultValue = "-1" ) int id_lanzadera,
                                                           @NotNull @RequestParam(value="cerrar", required=false  , defaultValue = "-1") int cerrar) {
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        ModelAndView m=new ModelAndView("EntradaSeleccionTipoCajaSugerirUbi");
        m.getModelMap().addAttribute("articulo", articuloService.getArticulo(articulo));
        m.getModelMap().addAttribute("lanzadera", lanzaderaService.getLanzadera(id_lanzadera));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("cajas", tipoCajaService.getCajas());
        m.getModelMap().addAttribute("cerrar", cerrar);
        return m;
    }

    //EntradaSeleccionUbicacion
    @RequestMapping(value="/EntradaSeleccionUbicacion")
    public ModelAndView entradaSeleccionUbicacionPage(HttpServletRequest request,
                                                      @NotNull @RequestParam(value = "articulo" ,required = true) String articulo,
                                                      @NotNull @RequestParam(value = "cantidad" ,required = true) String cantidad) {
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        ModelAndView m= new ModelAndView("EntradaSeleccionUbicacion");
        Articulo a=articuloService.getArticulo(articulo);
        m.getModelMap().addAttribute("articulo",a);
        m.getModelMap().addAttribute("cantidad",cantidad);
        //ubicaciones
        m.getModelMap().addAttribute("ubicaciones",locationService.getUbicacionesArticulo(a));
        return m;
    }

    //carga  home desde login
    @RequestMapping(value="/EntradaMaterialHome")
    @ResponseBody
    public ModelAndView entradaMateriaHomePage(HttpServletRequest request,
                                               @NotNull @RequestParam(required = false , value = "lanzadera",defaultValue =  "-1") int  id_lanzadera) {
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        ModelAndView m=new ModelAndView("EntradaMaterialHome");
        m.getModelMap().addAttribute("lanzadera", lanzaderaService.getLanzadera(id_lanzadera));
        return m;
    }


    //carga  home desde login
    @RequestMapping(value="/EntradaSeleccionPedido")
    public ModelAndView entradaSeleccionPedidoPage(HttpServletRequest request) {
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        return new ModelAndView("EntradaSeleccionPedido");
    }

    @RequestMapping(value="/EntradaBusquedaArticulo")
    public ModelAndView entradaBusquedaArticuloPage(HttpServletRequest request,
                                                    @NotNull @RequestParam(required = false , value = "lanzadera",defaultValue =  "-1") int  id_lanzadera) {
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        ModelAndView m=new ModelAndView("EntradaBusquedaArticulo");
        m.getModelMap().addAttribute("lanzadera", lanzaderaService.getLanzadera(id_lanzadera));
        return m;

    }


    //EntradaSeleccionCantidadArticulo
    @RequestMapping(value="/EntradaSeleccionCantidadArticulo",method = RequestMethod.GET)
    public ModelAndView entradaSeleccionCantidadArticuloPage(HttpServletRequest request, @NotNull @RequestParam(value = "articulo" ,defaultValue = "articulo", required = false) String articulo,
                                                             @NotNull @RequestParam(value = "lanzadera" , required = false , defaultValue = "-1") int id_lanzadera) {
        ModelAndView m= new ModelAndView("EntradaSeleccionCantidadArticulo");
        Articulo a=articuloService.getArticulo(articulo);
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        m.getModelMap().addAttribute("articulo",a);
        //ubicaciones en lanzadera
        if(id_lanzadera!=-1){
            Lanzadera l=lanzaderaService.getLanzadera(id_lanzadera);
            m.getModelMap().addAttribute("ubicaciones",locationService.getUbicacionesArticulo(a,l));
            m.getModelMap().addAttribute("reservas",cajaEntabladoMedidaService.getUbicacionesArticulo(a,l));
            m.getModelMap().addAttribute("lanzadera",l);
        }
        //ubicaciones disponibles en lanzadera
        else{
            List<AcessoLanzadera> acessos=acessoLazaderasService.getLanzaderas(remoteAddr);
            List<CajaEntablado> ubicaciones=new ArrayList<CajaEntablado>();
            List<CajaEntabladoMedida> reservas=new ArrayList<CajaEntabladoMedida>();
            for(AcessoLanzadera aceso:acessos){
                ubicaciones.addAll(locationService.getUbicacionesArticulo(a,aceso.getLanzadera()));
                reservas.addAll(cajaEntabladoMedidaService.getUbicacionesArticulo(a,aceso.getLanzadera()));
            }
            m.getModelMap().addAttribute("ubicaciones",ubicaciones);
            m.getModelMap().addAttribute("reservas",reservas);
            m.getModelMap().addAttribute("lanzadera",null);
        }
        return m;
    }



    //EntradaSeleccionArticuloPedido
    @RequestMapping(value="/EntradaSeleccionArticuloPedido",method = RequestMethod.GET)
    public ModelAndView entradaSeleccionArticuloPedidoPage(HttpServletRequest request, @NotNull @RequestParam(value = "pedido" , required = true) String pedido) {
        ModelAndView m= new ModelAndView("EntradaSeleccionArticuloPedido");
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

            /*
                Listar Articulos del pedido
             */

            URL wsdlLocation = OperacionesServidorController.class.getResource("res/Warehouse_Receipt_Line_WS.xml");
            String targetNamespace="urn:microsoft-dynamics-schemas/page/warehouse_receipt_line_ws";
            String name="Warehouse_Receipt_Line_WS_Service";
            WarehouseReceiptLineWSService service = new WarehouseReceiptLineWSService( wsdlLocation, new QName(targetNamespace, name));
            WarehouseReceiptLineWSPort port = service.getWarehouseReceiptLineWSPort();
            // Añadimos capacidades de seguridad a la llamada
            BindingProvider provider = (BindingProvider) port;
            provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
            provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");
            List<WarehouseReceiptLineWSFilter> filtros=new ArrayList<WarehouseReceiptLineWSFilter>();
            WarehouseShipmentHeaderWSFilter f1=new WarehouseShipmentHeaderWSFilter();
            f1.setField(WarehouseShipmentHeaderWSFields.NO);
            f1.setCriteria(pedido);
            WarehouseReceiptLineWSList artPedEntrada=port.readMultiple(filtros,"",100);

            m.getModelMap().addAttribute("articulos_pedido",artPedEntrada.getWarehouseReceiptLineWS());
            m.getModelMap().addAttribute("pedido",pedido);


        return m;
    }





    @RequestMapping(value="/EntradaEntablado" ,method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView entradaEntablado(HttpServletRequest request,
                                         @NotNull @RequestParam("articulo") String articulo,
                                         @NotNull @RequestParam("cantidad") String cantidad,
                                         @NotNull @RequestParam("caja") String caja,
                                         @NotNull @RequestParam("modo") String modo) {
        ModelAndView m=new ModelAndView("EntradaSeleccionEntablado");
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        m.getModelMap().addAttribute("articulo", articuloService.getArticulo(articulo));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("caja", caja);
        m.getModelMap().addAttribute("modo", modo);
        return m;
    }

    @RequestMapping(value = "EntradaSeleccionNuevaUbicacionFinal/TraerEntablado",method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String traerEntabladoNuevaUicacion(HttpServletRequest request,
                                       Model model,
                                       @NotNull @RequestParam(value = "lanzadera" , required = true , defaultValue = "-1") int lanzadera,
                                       @NotNull @RequestParam(value="entalado",required = true,defaultValue = "-1") int entablado){
        String res = ConexionArmario.moverArmario(Integer.valueOf(lanzadera),Integer.valueOf(entablado));
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        JSONObject outputJsonObj = new JSONObject();
        try {
            outputJsonObj.put("res", res);
        }catch(Exception e){
            e.printStackTrace();
        }
        return outputJsonObj.toString();
    }


    @RequestMapping(value="/EntradaSeleccionNuevaUbicacionFinal" ,method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView entradaSeleccionNuevaUbicacionFinal(HttpServletRequest request,
                                                            @NotNull @RequestParam(value = "articulo" , required = true) String articulo,
                                                            @NotNull @RequestParam(value = "cantidad", required = true) String cantidad,
                                                            @NotNull @RequestParam(value = "lanzadera", required = true ,defaultValue = "-1") int lanzadera,
                                                            @NotNull @RequestParam(value = "entablado" , required = true ,defaultValue = "-1") int entablado,
                                                            @NotNull @RequestParam(value = "caja" ,required = true) String caja,
                                                            @NotNull @RequestParam(value = "cerrar" , required = false ,defaultValue = "-1") int cerrar) throws JSONException {
        ModelAndView m=new ModelAndView("EntradaSeleccionNuevaUbicacionFinal");
        TipoCaja c=tipoCajaService.getTipoCaja(Integer.valueOf(caja));
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("entablado",entabladoService.getEstanteria(l,entablado));
        articulo= articulo.length()==9 ? articulo : String.format("%0" + (9 - articulo.length()) + "d%s", 0, articulo);
        m.getModelMap().addAttribute("articulo", articuloService.getArticulo(articulo));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(l,entabladoService.getEstanteria(l,entablado)));
        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(l,entabladoService.getEstanteria(l,entablado)));
        m.getModelMap().addAttribute("caja", c);
        m.getModelMap().addAttribute("cerrar", cerrar);
        return m;
    }

    @RequestMapping(value="/EntradaSeleccionNuevaUbicacionFinalMedida" ,method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView entradaSeleccionNuevaUbicacionFinalMedida(HttpServletRequest request,
                                                                  @NotNull @RequestParam(value="articulo", required=false) String articulo,
                                                                  @NotNull @RequestParam(value="lanzadera", required=false , defaultValue = "-1") int lanzadera,
                                                                  @NotNull @RequestParam(value="entablado", required=false , defaultValue = "-1") int entablado,
                                                                  @NotNull @RequestParam(value="cajafila", required=false  , defaultValue = "-1") int fila,
                                                                  @NotNull @RequestParam(value="cajacolumna", required=false  , defaultValue = "-1") int columna,
                                                                  @NotNull @RequestParam(value="cantidad", required=false  , defaultValue = "-1") int cantidad,
                                                                  @NotNull @RequestParam(value="cerrar", required=false  , defaultValue = "-1") int cerrar
    ) throws JSONException {
        ModelAndView m=new ModelAndView("EntradaSeleccionNuevaUbicacionFinalMedida");
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        Entablado e=entabladoService.getEstanteria(l,entablado);
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("articulo", articuloService.getArticulo(articulo));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(l,e));
        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(l,e));
        m.getModelMap().addAttribute("filascaja", fila);
        m.getModelMap().addAttribute("columnascaja", columna);
        m.getModelMap().addAttribute("cerrar", cerrar);
        return m;
    }

    @RequestMapping(value="/EntradaSeleccionUbicacionFinalMedida" ,method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView entradaSeleccionNuevaUbicacionFinal(HttpServletRequest request,
                                                            @NotNull @RequestParam(value="articulo", required=false) String articulo,
                                                            @NotNull @RequestParam(value="lanzadera", required=false , defaultValue = "-1") int lanzadera,
                                                            @NotNull @RequestParam(value="entablado", required=false , defaultValue = "-1") int entablado,
                                                            @NotNull @RequestParam(value="fila", required=false  , defaultValue = "-1") int fila,
                                                            @NotNull @RequestParam(value="columna", required=false  , defaultValue = "-1") int columna,
                                                            @NotNull @RequestParam(value="cantidad", required=false  , defaultValue = "-1") int cantidad,
                                                            @NotNull @RequestParam(value="cerrar", required=false  , defaultValue = "-1") int cerrar
    ) throws JSONException {
        ModelAndView m=new ModelAndView("EntradaSeleccionUbicacionFinalMedida");
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        Entablado e=entabladoService.getEstanteria(l,entablado);
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("localizacionArticulo", cajaEntabladoMedidaService.getCajasEntablado(l,e,fila,columna));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(l,entabladoService.getEstanteria(l,entablado)));
        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(l,entabladoService.getEstanteria(l,entablado)));
        return m;
    }
}
