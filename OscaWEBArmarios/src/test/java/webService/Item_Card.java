package webService;


import com.dynamics.webServices.Item_Card.*;
import junit.framework.Assert;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Portátil1 on 20/09/2017.
 */
public class Item_Card {


    private  ItemCardService service = null;

    @org.junit.Test
    public void readTest(){


        try {
            // Creamos el servicio con el WSDL
            URL wsdlLocation =new File("C:\\Users\\Portátil1\\Desktop\\Item_Card.xml").toURI().toURL();
            String targetNamespace="urn:microsoft-dynamics-schemas/page/item_card";
            String name="Item_Card_Service";
            service = new ItemCardService( wsdlLocation, new QName(targetNamespace, name));
            ItemCardPort port = service.getItemCardPort();
            // Añadimos capacidades de seguridad a la llamada
            BindingProvider provider = (BindingProvider) port;
            provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
            provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");
            //cast producto
            List<ItemCardFilter> filtros=new ArrayList<ItemCardFilter>();
            ItemCardFilter f1=new ItemCardFilter();
            f1.setField(ItemCardFields.DESCRIPTION);
            f1.setCriteria("LIKE 'RACOR'");
            ItemCardList items=port.readMultiple(filtros,"",100);
        } catch (MalformedURLException e ) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }

        Assert.assertTrue(true);



    }
}
