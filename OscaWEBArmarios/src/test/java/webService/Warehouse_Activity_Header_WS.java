package webService;

import com.dynamics.webServices.Warehouse_Activity_Header_WS.*;
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
public class Warehouse_Activity_Header_WS {


    private WarehouseActivityHeaderWSService service = null;

    @org.junit.Test
    public void readTest(){


        try {
            // Creamos el servicio con el WSDL
            URL wsdlLocation =new File("C:\\Users\\José Ángel Caudevílla Casaús\\Google Drive\\Osca sistemas\\OscaWEBArmarios\\src\\main\\java\\com\\dynamics\\webServices\\wsdl\\Warehouse_Activity_Header_WS.xml").toURI().toURL();
            String targetNamespace="urn:microsoft-dynamics-schemas/page/warehouse_activity_header_ws";
            String name="Warehouse_Activity_Header_WS_Service";
            service = new WarehouseActivityHeaderWSService( wsdlLocation, new QName(targetNamespace, name));
            WarehouseActivityHeaderWSPort port = service.getWarehouseActivityHeaderWSPort();
            // Añadimos capacidades de seguridad a la llamada
            BindingProvider provider = (BindingProvider) port;
            provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
            provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");
            //cast producto

            List<WarehouseActivityHeaderWSFilter> filtros1=new ArrayList<WarehouseActivityHeaderWSFilter>();
            WarehouseActivityHeaderWSFilter f5=new WarehouseActivityHeaderWSFilter();
            f5.setField(WarehouseActivityHeaderWSFields.TYPE);
            f5.setCriteria("Put_away");
            filtros1.add(f5);
            List<WarehouseActivityHeaderWS> pedidoObj=port.readMultiple(filtros1,"",0).getWarehouseActivityHeaderWS();

            for(WarehouseActivityHeaderWS s:pedidoObj)
                System.out.println(s.toString());

        } catch (MalformedURLException e ) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }

        Assert.assertTrue(true);



    }
}
