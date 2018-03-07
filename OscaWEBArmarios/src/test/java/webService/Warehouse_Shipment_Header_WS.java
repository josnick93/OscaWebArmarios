package webService;

import com.dynamics.webServices.Warehouse_Shipment_Header_WS.WarehouseShipmentHeaderWS;
import com.dynamics.webServices.Warehouse_Shipment_Header_WS.WarehouseShipmentHeaderWSPort;
import com.dynamics.webServices.Warehouse_Shipment_Header_WS.WarehouseShipmentHeaderWSService;
import junit.framework.Assert;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by José Ángel Caudevílla Casaús on 20/09/2017.
 */
public class Warehouse_Shipment_Header_WS {


    private WarehouseShipmentHeaderWSService service = null;

    @org.junit.Test
    public void readTest(){

       // Warehouse_Shipment_Header_WS.xml
        try {
            // Creamos el servicio con el WSDL
            URL wsdlLocation =new File("webService/").toURI().toURL();
            String targetNamespace="urn:microsoft-dynamics-schemas/page/warehouse_shipment_header_ws";
            String name="Warehouse_Shipment_Header_WS_Service";
            service = new WarehouseShipmentHeaderWSService( wsdlLocation, new QName(targetNamespace, name));
            WarehouseShipmentHeaderWSPort port = service.getWarehouseShipmentHeaderWSPort();
            // Añadimos capacidades de seguridad a la llamada
            BindingProvider provider = (BindingProvider) port;
            provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
            provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");
            //cast producto
            WarehouseShipmentHeaderWS envio=port.read("EN000001");
            System.out.println(envio.toString());
        } catch (MalformedURLException e ) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }

        Assert.assertTrue(true);



    }
}
