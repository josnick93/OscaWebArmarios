
package com.dynamics.webServices.Warehouse_Shipment_Header_WS;

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
@WebServiceClient(name = "Warehouse_Shipment_Header_WS_Service", targetNamespace = "urn:microsoft-dynamics-schemas/page/warehouse_shipment_header_ws", wsdlLocation = "./wsdl/Warehouse_Shipment_Header_WS.xml")
public class WarehouseShipmentHeaderWSService
    extends Service
{

    private final static URL WAREHOUSESHIPMENTHEADERWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException WAREHOUSESHIPMENTHEADERWSSERVICE_EXCEPTION;
    private final static QName WAREHOUSESHIPMENTHEADERWSSERVICE_QNAME = new QName("urn:microsoft-dynamics-schemas/page/warehouse_shipment_header_ws", "Warehouse_Shipment_Header_WS_Service");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("./wsdl/Warehouse_Shipment_Header_WS.xml");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WAREHOUSESHIPMENTHEADERWSSERVICE_WSDL_LOCATION = url;
        WAREHOUSESHIPMENTHEADERWSSERVICE_EXCEPTION = e;
    }

    public WarehouseShipmentHeaderWSService() {
        super(__getWsdlLocation(), WAREHOUSESHIPMENTHEADERWSSERVICE_QNAME);
    }

    public WarehouseShipmentHeaderWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WAREHOUSESHIPMENTHEADERWSSERVICE_QNAME, features);
    }

    public WarehouseShipmentHeaderWSService(URL wsdlLocation) {
        super(wsdlLocation, WAREHOUSESHIPMENTHEADERWSSERVICE_QNAME);
    }

    public WarehouseShipmentHeaderWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WAREHOUSESHIPMENTHEADERWSSERVICE_QNAME, features);
    }

    public WarehouseShipmentHeaderWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WarehouseShipmentHeaderWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WarehouseShipmentHeaderWSPort
     */
    @WebEndpoint(name = "Warehouse_Shipment_Header_WS_Port")
    public WarehouseShipmentHeaderWSPort getWarehouseShipmentHeaderWSPort() {
        return super.getPort(new QName("urn:microsoft-dynamics-schemas/page/warehouse_shipment_header_ws", "Warehouse_Shipment_Header_WS_Port"), WarehouseShipmentHeaderWSPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WarehouseShipmentHeaderWSPort
     */
    @WebEndpoint(name = "Warehouse_Shipment_Header_WS_Port")
    public WarehouseShipmentHeaderWSPort getWarehouseShipmentHeaderWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("urn:microsoft-dynamics-schemas/page/warehouse_shipment_header_ws", "Warehouse_Shipment_Header_WS_Port"), WarehouseShipmentHeaderWSPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WAREHOUSESHIPMENTHEADERWSSERVICE_EXCEPTION!= null) {
            throw WAREHOUSESHIPMENTHEADERWSSERVICE_EXCEPTION;
        }
        return WAREHOUSESHIPMENTHEADERWSSERVICE_WSDL_LOCATION;
    }

}