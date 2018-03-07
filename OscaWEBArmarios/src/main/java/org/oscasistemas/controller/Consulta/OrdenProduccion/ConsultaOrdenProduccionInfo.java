package org.oscasistemas.controller.Consulta.OrdenProduccion;

import com.dynamics.webServices.Prod_Order_Component_WS.ProdOrderComponentWSFields;
import com.dynamics.webServices.Prod_Order_Component_WS.ProdOrderComponentWSFilter;
import com.dynamics.webServices.Prod_Order_Component_WS.ProdOrderComponentWSPort;
import com.dynamics.webServices.Prod_Order_Component_WS.ProdOrderComponentWSService;
import com.dynamics.webServices.Production_Order_WS.ProductionOrderWSFields;
import com.dynamics.webServices.Production_Order_WS.ProductionOrderWSFilter;
import com.dynamics.webServices.Production_Order_WS.ProductionOrderWSPort;
import com.dynamics.webServices.Production_Order_WS.ProductionOrderWSService;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.controller.ConsultaController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Portátil1 on 29/12/2017.
 */
@RestController
public class ConsultaOrdenProduccionInfo {
    //carga  home desde login
    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value="/ConsultaOrdenProduccionInfo")
    public ModelAndView consultaInfoOrdenPage(HttpServletRequest request, @NotNull @RequestParam(value = "orden" , required = true) String orden) {
        ModelAndView m=new ModelAndView("ConsultaOrdenProduccionInfo");

        /*
         * Obtener Orden de produccion
         */
        // Creamos el servicio con el WSDL
        URL wsdlLocation = ConsultaController.class.getResource("./wsdl/Production_Order_WS.xml");
        String targetNamespace="urn:microsoft-dynamics-schemas/page/production_order_ws";
        String name="Production_Order_WS_Service";
        ProductionOrderWSService service = new ProductionOrderWSService( wsdlLocation, new QName(targetNamespace, name));
        ProductionOrderWSPort port = service.getProductionOrderWSPort();
        // Añadimos capacidades de seguridad a la llamada
        BindingProvider provider = (BindingProvider) port;
        provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
        provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");
        //cast producto
        List<ProductionOrderWSFilter> filtros=new ArrayList<ProductionOrderWSFilter>();
        ProductionOrderWSFilter f1=new ProductionOrderWSFilter();
        f1.setField(ProductionOrderWSFields.DESCRIPTION);
        f1.setCriteria("");
        filtros.add(f1);
        //m.getModelMap().addAttribute("Orden", port.read(orden));
        /*
         * Obtener info orden de produccion
         */
        // Creamos el servicio con el WSDL
        wsdlLocation = ConsultaController.class.getResource("./wsdl/Prod_Order_Line_WS.xml");
        targetNamespace="urn:microsoft-dynamics-schemas/page/prod_order_component_ws";
        name="Prod_Order_Component_WS_Service";
        ProdOrderComponentWSService service1 = new ProdOrderComponentWSService( wsdlLocation, new QName(targetNamespace, name));
        ProdOrderComponentWSPort port1 = service1.getProdOrderComponentWSPort();
        // Añadimos capacidades de seguridad a la llamada
        provider = (BindingProvider) port1;
        provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
        provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");
        //cast producto
        List<ProdOrderComponentWSFilter> filtros1=new ArrayList<ProdOrderComponentWSFilter>();
        ProdOrderComponentWSFilter f11=new ProdOrderComponentWSFilter();
        f11.setField(ProdOrderComponentWSFields.PROD_ORDER_NO);
        f11.setCriteria(orden);
        filtros1.add(f11);
        m.getModelMap().addAttribute("Componentes", port1.readMultiple(filtros1,"",0).getProdOrderComponentWS());

        return m;
    }


}

