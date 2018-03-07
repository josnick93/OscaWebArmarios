package org.oscasistemas.controller.WebService;

import com.dynamics.webServices.Bin_Content_WS.BinContentWSPort;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSService;
import com.dynamics.webServices.Bin_WS.BinWSPort;
import com.dynamics.webServices.Bin_WS.BinWSService;
import com.dynamics.webServices.Item_Card_WS.ItemCardWSPort;
import com.dynamics.webServices.Item_Card_WS.ItemCardWSService;
import com.dynamics.webServices.Production_Order_WS.ProductionOrderWSPort;
import com.dynamics.webServices.Production_Order_WS.ProductionOrderWSService;
import com.dynamics.webServices.RF_Functions.RFFunctions;
import com.dynamics.webServices.RF_Functions.RFFunctionsPort;
import com.dynamics.webServices.Warehouse_Activity_Header_WS.WarehouseActivityHeaderWSPort;
import com.dynamics.webServices.Warehouse_Activity_Header_WS.WarehouseActivityHeaderWSService;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSPort;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.net.URL;

/**
 * Created by Jose Angel Caudevilla
 * Web Services Objects Factory
 */
@Component
public class WebServicesInit{

    //atributos
    @Autowired
    public static BinWSPort ubicacionesService; //bin Service

    @Autowired
    public static BinContentWSPort contenidoUbicacionService; // bin content service

    @Autowired
    public static  WarehouseActivityHeaderWSPort PedidoService;

    @Autowired
    public static WarehouseActivityLineWSPort articulosPedidoService;

    @Autowired
    public static ProductionOrderWSPort ordenesProduccionService;

    @Autowired
    public static ItemCardWSPort articulosService;

    @Autowired
    public static RFFunctionsPort functionsService;


    /**
     * Method called before start server,create all web services service instances
     */
    @PostConstruct
    public final void initWebServices(){
        /**
         * Ubicaciones service
         */
        URL wsdlLocation = WebServicesInit.class.getResource("./wsdl//Bin_WS.xml");
        String targetNamespace="urn:microsoft-dynamics-schemas/page/bin_ws";
        String name="Bin_WS_Service";
        BinWSService service = new BinWSService( wsdlLocation, new QName(targetNamespace, name));
        ubicacionesService = service.getBinWSPort();
        // Añadimos capacidades de seguridad a la llamada
        BindingProvider provider = (BindingProvider) ubicacionesService;
        provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
        provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");

        /**
         * Contenido Ubicaciones service
         */
        wsdlLocation = WebServicesInit.class.getResource("./wsdl//Bin_Content_WS.xml");
        targetNamespace="urn:microsoft-dynamics-schemas/page/bin_content_ws";
        name="Bin_Content_WS_Service";
        BinContentWSService service6 = new BinContentWSService( wsdlLocation, new QName(targetNamespace, name));
        contenidoUbicacionService = service6.getBinContentWSPort();
        // Añadimos capacidades de seguridad a la llamada
        BindingProvider provider6 = (BindingProvider) contenidoUbicacionService;
        provider6.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
        provider6.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");
        /**
         * Warehouse Activity Header
         */
        wsdlLocation = WebServicesInit.class.getResource("./wsdl//Warehouse_Activity_Header_WS.xml");
        targetNamespace="urn:microsoft-dynamics-schemas/page/warehouse_activity_header_ws";
        name="Warehouse_Activity_Header_WS_Service";
        WarehouseActivityHeaderWSService service1 = new WarehouseActivityHeaderWSService( wsdlLocation, new QName(targetNamespace, name));
        PedidoService = service1.getWarehouseActivityHeaderWSPort();
        // Añadimos capacidades de seguridad a la llamada
        BindingProvider provider1 = (BindingProvider) PedidoService;
        provider1.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
        provider1.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");

        /**
         * Warehouse Activity Line
         */
        wsdlLocation = WebServicesInit.class.getResource("./wsdl//wsdl/Warehouse_Activity_Line_WS.xml");
        targetNamespace="urn:microsoft-dynamics-schemas/page/warehouse_activity_line_ws";
        name="Warehouse_Activity_Line_WS_Service";
        com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSService service2 = new WarehouseActivityLineWSService( wsdlLocation, new QName(targetNamespace, name));
        articulosPedidoService = service2.getWarehouseActivityLineWSPort();
        // Añadimos capacidades de seguridad a la llamada
        BindingProvider provider2 = (BindingProvider) articulosPedidoService;
        provider2.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
        provider2.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");

        /**
         * Production order WS
         */
        wsdlLocation = WebServicesInit.class.getResource("./wsdl//Production_Order_WS.xml");
        targetNamespace="urn:microsoft-dynamics-schemas/page/production_order_ws";
        name="Production_Order_WS_Service";
        ProductionOrderWSService service3 = new ProductionOrderWSService( wsdlLocation, new QName(targetNamespace, name));
        ordenesProduccionService = service3.getProductionOrderWSPort();
        // Añadimos capacidades de seguridad a la llamada
        BindingProvider provider3 = (BindingProvider) ordenesProduccionService;
        provider3.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
        provider3.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");
        /**
         * Item Card Ws
         */
        wsdlLocation = WebServicesInit.class.getResource("./wsdl//Item_Card_WS.xml");
        targetNamespace="urn:microsoft-dynamics-schemas/page/item_card_ws";
        name="Item_Card_WS_Service";
        ItemCardWSService service4 = new ItemCardWSService( wsdlLocation, new QName(targetNamespace, name));
        articulosService = service4.getItemCardWSPort();
        // Añadimos capacidades de seguridad a la llamada
        BindingProvider provider4 = (BindingProvider) articulosService;
        provider4.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
        provider4.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");


        /**
         * RF_functions
         */
        wsdlLocation = WebServicesInit.class.getResource("./wsdl//RF_Functions.xml");
        targetNamespace="urn:microsoft-dynamics-schemas/codeunit/RF_Functions";
        name="RF_Functions";
        RFFunctions service5=new RFFunctions(wsdlLocation, new QName(targetNamespace, name));
        functionsService = service5.getRFFunctionsPort();
        // Añadimos capacidades de seguridad a la llamada
        BindingProvider provider5 = (BindingProvider) functionsService;
        provider5.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
        provider5.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");

    }
}
