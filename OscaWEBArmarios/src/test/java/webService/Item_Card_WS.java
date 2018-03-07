package webService;


import com.dynamics.webServices.Item_Card_WS.*;
import junit.framework.Assert;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 20/09/2017.
 */
public class Item_Card_WS {


    private ItemCardWSService service = null;
   //private WarehouseReceiptHeaderWSService service = null;

    @org.junit.Test
    public void readTest(){
        // Warehouse_Shipment_Header_WS
        try {
            // Creamos el servicio con el WSDL
            URL wsdlLocation =new File("C:\\Users\\José Ángel Caudevílla Casaús\\Desktop\\Item_Card_WS.xml").toURI().toURL();
            String targetNamespace="urn:microsoft-dynamics-schemas/page/item_card_ws";
            String name="Item_Card_WS_Service";
            service = new ItemCardWSService( wsdlLocation, new QName(targetNamespace, name));
            ItemCardWSPort port = service.getItemCardWSPort();
            // Añadimos capacidades de seguridad a la llamada
            BindingProvider provider = (BindingProvider) port;
            provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
            provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");
            //cast producto
            List<ItemCardWSFilter> filtros=new ArrayList<ItemCardWSFilter>();
            ItemCardWSFilter f1=new ItemCardWSFilter();
            f1.setField(ItemCardWSFields.DESCRIPTION);
            f1.setCriteria("");
            filtros.add(f1);
            port.readMultiple(filtros,"",10);
        } catch (MalformedURLException e ) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }

        Assert.assertTrue(true);



    }
}
