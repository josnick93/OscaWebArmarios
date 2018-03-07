package webService;

import com.dynamics.webServices.Employee_Login.EmployeeLoginPort;
import com.dynamics.webServices.Employee_Login.EmployeeLogin_Service;
import junit.framework.Assert;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by José Ángel Caudevílla Casaús on 20/09/2017.
 */
public class Employee_Login {
    private EmployeeLogin_Service service = null;

    @org.junit.Test
    public void readTest(){


        try {
            // Creamos el servicio con el WSDL
            URL wsdlLocation =new File("C:\\Users\\José Ángel Caudevílla Casaús\\Desktop\\Warehouse_Activity_Header_WS.xml").toURI().toURL();
            String targetNamespace="urn:microsoft-dynamics-schemas/page/item_card";
            String name="Warehouse_Activity_Header_WS_Service";
            service = new EmployeeLogin_Service( wsdlLocation, new QName(targetNamespace, name));
            EmployeeLoginPort port = service.getEmployeeLoginPort();
            // Añadimos capacidades de seguridad a la llamada
            BindingProvider provider = (BindingProvider) port;
            provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "SERWEB");
            provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Oscasistemas1");
            //cast producto
            boolean sucess=port.employeeLogin("Usuario","Constraseña");
        } catch (MalformedURLException e ) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }

        Assert.assertTrue(true);



    }


}
