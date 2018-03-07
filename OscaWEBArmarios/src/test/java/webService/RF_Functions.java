package webService;

import com.dynamics.webServices.RF_Functions.GetItemDescription;
import com.dynamics.webServices.RF_Functions.RFFunctions;
import com.dynamics.webServices.RF_Functions.RFFunctionsPort;
import junit.framework.Assert;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by José Ángel Caudevílla Casaús on 19/10/2017.
 */
public class RF_Functions {

    private RFFunctions service = null;
    @org.junit.Test
    public void readTest(){
        try {
            // Warehouse_Shipment_Header_WS
            GetItemDescription getItemDescription=new GetItemDescription();
            URL wsdlLocation =new File("C:\\Users\\José Ángel Caudevílla Casaús\\Desktop\\RF_Functions.xml").toURI().toURL();
            String targetNamespace="urn:microsoft-dynamics-schemas/codeunit/RF_Functions";
            String name="RF_Functions";
            service=new RFFunctions(wsdlLocation, new QName(targetNamespace, name));
            RFFunctionsPort port = service.getRFFunctionsPort();
            // Añadimos capacidades de seguridad a la llamada
            BindingProvider provider = (BindingProvider) port;
            provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
            provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");

            port.putAwayPost("UA000001");
            //port.createMovement();
        } catch (MalformedURLException e ) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }

        Assert.assertTrue(true);


    }
}
