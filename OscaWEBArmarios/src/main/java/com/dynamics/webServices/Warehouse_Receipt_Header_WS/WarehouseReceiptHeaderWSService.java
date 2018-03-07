
package com.dynamics.webServices.Warehouse_Receipt_Header_WS;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Warehouse_Receipt_Header_WS_Service", targetNamespace = "urn:microsoft-dynamics-schemas/page/warehouse_receipt_header_ws", wsdlLocation = "./wsdl//Warehouse_Receipt_Header_WS.xml")
public class WarehouseReceiptHeaderWSService
    extends Service
{

    private final static URL WAREHOUSERECEIPTHEADERWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException WAREHOUSERECEIPTHEADERWSSERVICE_EXCEPTION;
    private final static QName WAREHOUSERECEIPTHEADERWSSERVICE_QNAME = new QName("urn:microsoft-dynamics-schemas/page/warehouse_receipt_header_ws", "Warehouse_Receipt_Header_WS_Service");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("./wsdl//Warehouse_Receipt_Header_WS.xml");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WAREHOUSERECEIPTHEADERWSSERVICE_WSDL_LOCATION = url;
        WAREHOUSERECEIPTHEADERWSSERVICE_EXCEPTION = e;
    }

    public WarehouseReceiptHeaderWSService() {
        super(__getWsdlLocation(), WAREHOUSERECEIPTHEADERWSSERVICE_QNAME);
    }

    public WarehouseReceiptHeaderWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WAREHOUSERECEIPTHEADERWSSERVICE_QNAME, features);
    }

    public WarehouseReceiptHeaderWSService(URL wsdlLocation) {
        super(wsdlLocation, WAREHOUSERECEIPTHEADERWSSERVICE_QNAME);
    }

    public WarehouseReceiptHeaderWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WAREHOUSERECEIPTHEADERWSSERVICE_QNAME, features);
    }

    public WarehouseReceiptHeaderWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WarehouseReceiptHeaderWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WarehouseReceiptHeaderWSPort
     */
    @WebEndpoint(name = "Warehouse_Receipt_Header_WS_Port")
    public WarehouseReceiptHeaderWSPort getWarehouseReceiptHeaderWSPort() {
        return super.getPort(new QName("urn:microsoft-dynamics-schemas/page/warehouse_receipt_header_ws", "Warehouse_Receipt_Header_WS_Port"), WarehouseReceiptHeaderWSPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WarehouseReceiptHeaderWSPort
     */
    @WebEndpoint(name = "Warehouse_Receipt_Header_WS_Port")
    public WarehouseReceiptHeaderWSPort getWarehouseReceiptHeaderWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("urn:microsoft-dynamics-schemas/page/warehouse_receipt_header_ws", "Warehouse_Receipt_Header_WS_Port"), WarehouseReceiptHeaderWSPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WAREHOUSERECEIPTHEADERWSSERVICE_EXCEPTION!= null) {
            throw WAREHOUSERECEIPTHEADERWSSERVICE_EXCEPTION;
        }
        return WAREHOUSERECEIPTHEADERWSSERVICE_WSDL_LOCATION;
    }

}
