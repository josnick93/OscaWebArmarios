package webService;

import com.dynamics.webServices.Warehouse_Receipt_Header_WS.WarehouseReceiptHeaderWS;
import com.dynamics.webServices.Warehouse_Receipt_Header_WS.WarehouseReceiptHeaderWSPort;
import com.dynamics.webServices.Warehouse_Receipt_Header_WS.WarehouseReceiptHeaderWSService;
import junit.framework.Assert;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by José Ángel Caudevílla Casaús on 20/09/2017.
 */
public class Warehouse_Receipt_Header_WS {


    private WarehouseReceiptHeaderWSService service = null;

    @org.junit.Test
    public void readTest(){

       // Warehouse_Shipment_Header_WS
        try {
            // Creamos el servicio con el WSDL
            URL wsdlLocation =new File("./wsdl//wsdl/Warehouse_Receipt_Header_WS.xml").toURI().toURL();
            String targetNamespace="urn:microsoft-dynamics-schemas/page/warehouse_receipt_header_ws";
            String name="Warehouse_Receipt_Header_WS_Service";
            service = new WarehouseReceiptHeaderWSService( wsdlLocation, new QName(targetNamespace, name));
            WarehouseReceiptHeaderWSPort port = service.getWarehouseReceiptHeaderWSPort();
            // Añadimos capacidades de seguridad a la llamada
            BindingProvider provider = (BindingProvider) port;
            provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
            provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");
            //cast producto
            WarehouseReceiptHeaderWS recibo=port.read("RE000002");
        } catch (MalformedURLException e ) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }

        Assert.assertTrue(true);



    }
}
