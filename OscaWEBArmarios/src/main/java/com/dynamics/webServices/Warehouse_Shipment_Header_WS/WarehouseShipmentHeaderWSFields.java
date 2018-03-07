
package com.dynamics.webServices.Warehouse_Shipment_Header_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Warehouse_Shipment_Header_WS_Fields.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Warehouse_Shipment_Header_WS_Fields">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Location_Code"/>
 *     &lt;enumeration value="Assigned_User_ID"/>
 *     &lt;enumeration value="Assignment_Date"/>
 *     &lt;enumeration value="Posting_Date"/>
 *     &lt;enumeration value="Shipping_Agent_Code"/>
 *     &lt;enumeration value="Shipping_Agent_Service_Code"/>
 *     &lt;enumeration value="External_Document_No"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Warehouse_Shipment_Header_WS_Fields")
@XmlEnum
public enum WarehouseShipmentHeaderWSFields {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Location_Code")
    LOCATION_CODE("Location_Code"),
    @XmlEnumValue("Assigned_User_ID")
    ASSIGNED_USER_ID("Assigned_User_ID"),
    @XmlEnumValue("Assignment_Date")
    ASSIGNMENT_DATE("Assignment_Date"),
    @XmlEnumValue("Posting_Date")
    POSTING_DATE("Posting_Date"),
    @XmlEnumValue("Shipping_Agent_Code")
    SHIPPING_AGENT_CODE("Shipping_Agent_Code"),
    @XmlEnumValue("Shipping_Agent_Service_Code")
    SHIPPING_AGENT_SERVICE_CODE("Shipping_Agent_Service_Code"),
    @XmlEnumValue("External_Document_No")
    EXTERNAL_DOCUMENT_NO("External_Document_No");
    private final String value;

    WarehouseShipmentHeaderWSFields(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WarehouseShipmentHeaderWSFields fromValue(String v) {
        for (WarehouseShipmentHeaderWSFields c: WarehouseShipmentHeaderWSFields.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
