package webService;

import com.dynamics.webServices.Warehouse_Activity_Line_WS.*;
import junit.framework.Assert;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 20/09/2017.
 */
public class Warehouse_Activity_Line_WS implements Comparator<WarehouseActivityLineWS> {


    private WarehouseActivityLineWSService service = null;

    @org.junit.Test
    public void readTest(){


        try {
            // Creamos el servicio con el WSDL
            URL wsdlLocation =new File("C:\\Users\\Portátil1\\Desktop\\WSFinal\\Warehouse_Activity_Line_WS.xml").toURI().toURL();
            String targetNamespace="urn:microsoft-dynamics-schemas/page/warehouse_activity_line_ws";
            String name="Warehouse_Activity_Line_WS_Service";
            service = new WarehouseActivityLineWSService( wsdlLocation, new QName(targetNamespace, name));
            WarehouseActivityLineWSPort port = service.getWarehouseActivityLineWSPort();
            // Añadimos capacidades de seguridad a la llamada
            BindingProvider provider = (BindingProvider) port;
            provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
            provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");
            //cast producto
            List<WarehouseActivityLineWSFilter> filtros=new ArrayList<WarehouseActivityLineWSFilter>();
                WarehouseActivityLineWSFilter f1=new WarehouseActivityLineWSFilter();
                f1.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
                f1.setCriteria("Pick");
                filtros.add(f1);
                WarehouseActivityLineWSFilter f2=new WarehouseActivityLineWSFilter();
                f2.setField(WarehouseActivityLineWSFields.NO);
                f2.setCriteria("PI002820");
                filtros.add(f2);
                WarehouseActivityLineWSFilter f3=new WarehouseActivityLineWSFilter();
                f3.setField(WarehouseActivityLineWSFields.ACTION_TYPE);
                f3.setCriteria("Take");
                filtros.add(f3);
                WarehouseActivityLineWSFilter f4=new WarehouseActivityLineWSFilter();
                f4.setField(WarehouseActivityLineWSFields.BIN_CODE);
                f4.setCriteria("PLNZ*");
                filtros.add(f4);
            List<WarehouseActivityLineWS> articuloPedido= port.readMultiple(filtros,"",0).getWarehouseActivityLineWS();


            for(WarehouseActivityLineWS a:articuloPedido){
                System.out.println(a.getBinCode()+"----"+a.getItemNo());
            }
            System.out.println("-------------------------------------");
            Collections.sort(articuloPedido,this);
            for(WarehouseActivityLineWS a:articuloPedido){
                System.out.println(a.getBinCode()+"----"+a.getItemNo());
            }

            //enviar a lanzaderas


        } catch (MalformedURLException e ) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }

        Assert.assertTrue(true);
    }

    @Override
    public int compare(WarehouseActivityLineWS o1, WarehouseActivityLineWS o2) {
        int entablado1=Integer.valueOf(o1.getBinCode().substring(8,o1.getBinCode().length()));
        int entablado2=Integer.valueOf(o2.getBinCode().substring(8,o2.getBinCode().length()));
        if(entablado1 == entablado2){

           return Integer.valueOf(o1.getItemNo()) < Integer.valueOf(o2.getItemNo()) ? 1 : -1;
        }
        else return entablado1 < entablado2 ? -1 : 1;

    }
}
