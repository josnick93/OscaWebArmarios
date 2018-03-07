
package com.dynamics.webServices.Employee_WS;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Employee_WS_Service", targetNamespace = "urn:microsoft-dynamics-schemas/page/employee_ws", wsdlLocation = "./wsdl//Employee_WS.xml")
public class EmployeeWSService
    extends Service
{

    private final static URL EMPLOYEEWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException EMPLOYEEWSSERVICE_EXCEPTION;
    private final static QName EMPLOYEEWSSERVICE_QNAME = new QName("urn:microsoft-dynamics-schemas/page/employee_ws", "Employee_WS_Service");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("./wsdl//Employee_WS.xml");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        EMPLOYEEWSSERVICE_WSDL_LOCATION = url;
        EMPLOYEEWSSERVICE_EXCEPTION = e;
    }

    public EmployeeWSService() {
        super(__getWsdlLocation(), EMPLOYEEWSSERVICE_QNAME);
    }

    public EmployeeWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), EMPLOYEEWSSERVICE_QNAME, features);
    }

    public EmployeeWSService(URL wsdlLocation) {
        super(wsdlLocation, EMPLOYEEWSSERVICE_QNAME);
    }

    public EmployeeWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, EMPLOYEEWSSERVICE_QNAME, features);
    }

    public EmployeeWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EmployeeWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns EmployeeWSPort
     */
    @WebEndpoint(name = "Employee_WS_Port")
    public EmployeeWSPort getEmployeeWSPort() {
        return super.getPort(new QName("urn:microsoft-dynamics-schemas/page/employee_ws", "Employee_WS_Port"), EmployeeWSPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EmployeeWSPort
     */
    @WebEndpoint(name = "Employee_WS_Port")
    public EmployeeWSPort getEmployeeWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("urn:microsoft-dynamics-schemas/page/employee_ws", "Employee_WS_Port"), EmployeeWSPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (EMPLOYEEWSSERVICE_EXCEPTION!= null) {
            throw EMPLOYEEWSSERVICE_EXCEPTION;
        }
        return EMPLOYEEWSSERVICE_WSDL_LOCATION;
    }

}
