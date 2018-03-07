package webService;

import com.dynamics.webServices.WS_Whse_Worksheet_Line.WSWhseWorksheetLine;
import com.dynamics.webServices.WS_Whse_Worksheet_Line.WSWhseWorksheetLinePort;
import com.dynamics.webServices.WS_Whse_Worksheet_Line.WSWhseWorksheetLineService;
import org.junit.Assert;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import java.io.File;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by José Ángel Caudevílla Casaús on 13/11/2017.
 */
public class WS_Whse_Worksheet_Line {

    private WSWhseWorksheetLineService service = null;

    @org.junit.Test
    public void readTest(){

        // Warehouse_Shipment_Header_WS.xml
        try {
            // Creamos el servicio con el WSDL
            URL wsdlLocation =new File("C:\\Users\\José Ángel Caudevílla Casaús\\Google Drive\\Osca sistemas\\OscaWEBArmarios\\src\\main\\java\\com\\dynamics\\webServices\\wsdl\\WS_Whse_Worksheet_Line.xml").toURI().toURL();
            String targetNamespace="urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line";
            String name="WS_Whse_Worksheet_Line_Service";
            service = new WSWhseWorksheetLineService( wsdlLocation, new QName(targetNamespace, name));
            WSWhseWorksheetLinePort port = service.getWSWhseWorksheetLinePort();
            // Añadimos capacidades de seguridad a la llamada
            BindingProvider provider = (BindingProvider) port;
            provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
            provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");
            //crear
            WSWhseWorksheetLine myWsWhseWorksheetLine=new WSWhseWorksheetLine();
            myWsWhseWorksheetLine.setItemNo("060020036");
            myWsWhseWorksheetLine.setWorksheetTemplateName("ARMARIOS");
            myWsWhseWorksheetLine.setName("PRUEBA");
            myWsWhseWorksheetLine.setLocationCode("OSCA");
            myWsWhseWorksheetLine.setLineNo(1000);
            myWsWhseWorksheetLine.setDescription("RACOR");
            myWsWhseWorksheetLine.setFromBinCode("PLNZ.08.0005");
            myWsWhseWorksheetLine.setToBinCode("PLNZ.08.0007");
            myWsWhseWorksheetLine.setQuantity(BigInteger.valueOf(100));
            myWsWhseWorksheetLine.setQtyToHandle(BigInteger.valueOf(10));
            //cast producto
            port.create(new Holder<WSWhseWorksheetLine>(myWsWhseWorksheetLine));
        } catch (MalformedURLException e ) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }

        Assert.assertTrue(true);



    }
}
