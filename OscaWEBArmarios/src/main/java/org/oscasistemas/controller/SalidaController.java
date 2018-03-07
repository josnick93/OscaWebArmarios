package org.oscasistemas.controller;

import com.dynamics.webServices.Warehouse_Shipment_Header_WS.*;
import com.sun.istack.internal.NotNull;
import org.jboss.logging.Logger;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.*;
import org.oscasistemas.model.*;
import org.oscasistemas.service.interfaces.IArticuloService;
import org.oscasistemas.util.ConexionArmario;
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
public class SalidaController {


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


    private static final Logger logger = Logger.getLogger(SalidaController.class);


    @RequestMapping(value="/SalidaEntablado")
    @ResponseBody
    public ModelAndView salidaEntabladoPage(@NotNull @RequestParam(value="articulo", required=false) String articulo,
                                            @NotNull @RequestParam(value="lanzadera", required=false) String lanzadera,
                                            @NotNull @RequestParam(value="entablado", required=false) String entablado,
                                            @NotNull @RequestParam(value="fila", required=false) String fila,
                                            @NotNull @RequestParam(value="columna", required=false) String columna) {
        ModelAndView m=new ModelAndView("SalidaEntablado");
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        List<CajaEntablado> aux=locationService.getCajasLanzadera(l);
        return m;
    }

    @RequestMapping(value="/SalidaSeleccionUbicacionFinal")
    public ModelAndView salidaSeleccionUbicacionFinalPage(@NotNull @RequestParam(value="articulo", required=false) String articulo,
                                                          @NotNull @RequestParam(value="lanzadera", required=false , defaultValue = "-1") int lanzadera,
                                                          @NotNull @RequestParam(value="entablado", required=false , defaultValue = "-1") int entablado,
                                                          @NotNull @RequestParam(value="fila", required=false  , defaultValue = "-1") int fila,
                                                          @NotNull @RequestParam(value="columna", required=false  , defaultValue = "-1") int columna,
                                                          @NotNull @RequestParam(value="cantidad", required=false  , defaultValue = "-1") int cantidad,
                                                          @NotNull @RequestParam(value="cerrar", required=false  , defaultValue = "-1") int cerrar) {
        ModelAndView m=new ModelAndView("SalidaSeleccionUbicacionFinal");
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        Entablado e=entabladoService.getEstanteria(l,entablado);
        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("localizacionArticulo", locationService.getCajasEntablado(l,e,fila,columna));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(l,entabladoService.getEstanteria(l,entablado)));
        m.getModelMap().addAttribute("cerrar", cerrar);
        return m;
    }


    //EntradaSeleccionArticuloPedido
    @RequestMapping(value="/SalidaSeleccionArticuloPedido",method = RequestMethod.GET)
    public ModelAndView entradaSeleccionArticuloPedidoPage(HttpServletRequest request, @NotNull @RequestParam(value = "pedido" , required = true) String pedido) {
        ModelAndView m= new ModelAndView("SalidaSeleccionArticuloPedido");
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

        URL wsdlLocation = OperacionesServidorController.class.getResource("res/Warehouse_Shipment_Line_WS.xml");
        String targetNamespace="urn:microsoft-dynamics-schemas/page/warehouse_shipment_line_wS";
        String name="Warehouse_Shipment_Line_WS_Service";
        WarehouseShipmentHeaderWSService service = new WarehouseShipmentHeaderWSService( wsdlLocation, new QName(targetNamespace, name));
        WarehouseShipmentHeaderWSPort port = service.getWarehouseShipmentHeaderWSPort();
        // Añadimos capacidades de seguridad a la llamada
        BindingProvider provider = (BindingProvider) port;
        provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
        provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");
        List<WarehouseShipmentHeaderWSFilter> filtros=new ArrayList<WarehouseShipmentHeaderWSFilter>();
        WarehouseShipmentHeaderWSFilter f1=new WarehouseShipmentHeaderWSFilter();
        f1.setField(WarehouseShipmentHeaderWSFields.NO);
        f1.setCriteria(pedido);
        WarehouseShipmentHeaderWSList artPedEntrada=port.readMultiple(filtros,"",100);

        m.getModelMap().addAttribute("articulos_pedido",artPedEntrada.getWarehouseShipmentHeaderWS());
        m.getModelMap().addAttribute("pedido",pedido);


        return m;
    }
    //salidaSeleccionUbicacionfinal
    @RequestMapping(value="/SalidaSeleccionUbicacionFinalMedida")
    public ModelAndView salidaSeleccionUbicacionFinalMedidaPage(@NotNull @RequestParam(value="articulo", required=false) String articulo,
                                                                @NotNull @RequestParam(value="lanzadera", required=false , defaultValue = "-1") int lanzadera,
                                                                @NotNull @RequestParam(value="entablado", required=false , defaultValue = "-1") int entablado,
                                                                @NotNull @RequestParam(value="fila", required=false  , defaultValue = "-1") int fila,
                                                                @NotNull @RequestParam(value="columna", required=false  , defaultValue = "-1") int columna,
                                                                @NotNull @RequestParam(value="cantidad", required=false  , defaultValue = "-1") int cantidad) {
        ModelAndView m=new ModelAndView("SalidaSeleccionUbicacionFinalMedida");
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        Entablado e=entabladoService.getEstanteria(l,entablado);
        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("localizacionArticulo", cajaEntabladoMedidaService.getCajasEntablado(l,e,fila,columna));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(l,e));
        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(l,e));
        return m;
    }

    @RequestMapping(value = "SalidaEntalado/TraerEntablado",method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String traerEntabladoSalida(Model model, @NotNull @RequestParam(value = "lanzadera" , required = true , defaultValue = "-1") int lanzadera,
                                @NotNull @RequestParam(value="entalado",required = true,defaultValue = "-1") int entablado){
        String res = ConexionArmario.moverArmario(Integer.valueOf(lanzadera),Integer.valueOf(entablado));
        JSONObject outputJsonObj = new JSONObject();
        try {
            outputJsonObj.put("res", res);
        }catch(Exception e){
            e.printStackTrace();
        }
        return outputJsonObj.toString();
    }

    @RequestMapping(value="/SalidaSeleccionUbicacion" ,method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView salidaSeleccionUbicacionPage(HttpServletRequest request, @NotNull @RequestParam(value = "articulo")String articulo,
                                                     @NotNull @RequestParam(value="lanzadera" ,required = false, defaultValue = "-1") int lanzadera) {
        ModelAndView m= new ModelAndView("SalidaSeleccionUbicacion");
        Articulo a=articuloService.getArticulo(articulo);
        m.getModelMap().addAttribute("articulo",a);
        m.getModelMap().addAttribute("lanzadera",lanzaderaService.getLanzadera(lanzadera));

        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

        //lanzadera actual
        if(lanzadera!=-1) {
            Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
            m.getModelMap().addAttribute("ubicaciones", locationService.getUbicacionesArticulo(a,l));
            m.getModelMap().addAttribute("reservas",cajaEntabladoMedidaService.getUbicacionesArticulo(a,l));
            //buscar permisos lanzadera
        }else {
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


    //salida material
    @RequestMapping(value="/SalidaMaterialHome")
    public ModelAndView salidaMateriaHomePage(@NotNull @RequestParam(required = false , value = "lanzadera",defaultValue =  "-1") int  id_lanzadera) {
        ModelAndView m=new ModelAndView("SalidaMaterialHome");
        m.getModelMap().addAttribute("lanzadera", lanzaderaService.getLanzadera(id_lanzadera));
        return  m;
    }

    @RequestMapping(value="/SalidaBusquedaArticulo")
    public ModelAndView salidaBusquedaArticuloPage(@NotNull @RequestParam(required = false , value = "lanzadera",defaultValue =  "-1") int  id_lanzadera) {
        ModelAndView m=new ModelAndView("SalidaBusquedaArticulo");
        m.getModelMap().addAttribute("lanzadera", lanzaderaService.getLanzadera(id_lanzadera));
        return m;
    }

    @RequestMapping(value="/SalidaSeleccionFormaSalida")
    public ModelAndView salidaSeleccionFormaSalidaPage() {
        return new ModelAndView("SalidaSeleccionFormaSalida");
    }


    @RequestMapping(value="/SalidaSeleccionPedidoVenta")
    public ModelAndView salidaSeleccionPedidoPage() {
        return new ModelAndView("SalidaSeleccionPedidoVenta");
    }



    @RequestMapping(value="/SalidaSelecionLineasPedidoVenta")
    public ModelAndView salidaSelecionLineasPedidoVentaPage() {
        return new ModelAndView("SalidaSelecionLineasPedidoVenta");    }
}
