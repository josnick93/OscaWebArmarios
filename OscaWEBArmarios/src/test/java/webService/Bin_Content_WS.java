package webService;


import com.dynamics.webServices.Bin_Content_WS.*;
import junit.framework.Assert;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import java.io.File;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 20/09/2017.
 */
public class Bin_Content_WS {


    private BinContentWSService service = null;
   //private WarehouseReceiptHeaderWSService service = null;

    @org.junit.Test
    public void readTest(){
        // Warehouse_Shipment_Header_WS
        try {
            // Creamos el servicio con el WSDL
            URL wsdlLocation =new File("C:\\Users\\Portátil1\\Desktop\\WSFinal\\Bin_Content_WS.xml").toURI().toURL();
            String targetNamespace="urn:microsoft-dynamics-schemas/page/bin_content_ws";
            String name="Bin_Content_WS_Service";
            service = new BinContentWSService( wsdlLocation, new QName(targetNamespace, name));
            BinContentWSPort port = service.getBinContentWSPort();
            // Añadimos capacidades de seguridad a la llamada
            BindingProvider provider = (BindingProvider) port;
            provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
            provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");
            //cast producto
            List<BinContentWSFilter> filtros=new ArrayList<BinContentWSFilter>();
                BinContentWSFilter f1=new BinContentWSFilter();
                f1.setField(BinContentWSFields.BIN_CODE);
                f1.setCriteria("PREC.01.0001");
                filtros.add(f1);
                BinContentWSFilter f2=new BinContentWSFilter();
                f2.setField(BinContentWSFields.ITEM_NO);
                f2.setCriteria("020070023");
                filtros.add(f2);
            BinContentWSList res=port.readMultiple(filtros,"",0);
            BinContentWS aux=res.getBinContentWS().get(0);
            aux.setQuantity(BigInteger.valueOf(0));
            //port.delete(res.getKey());

            //res.setQuantity(BigInteger.valueOf(18));
            //port.update(new Holder<BinContentWS>(res));
            port.update(new Holder<BinContentWS>(aux));
            port.delete(aux.getKey());

            for(BinContentWS r: res.getBinContentWS())
                System.out.println(r.toString());
        } catch (MalformedURLException e ) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }

        Assert.assertTrue(true);



    }
}
