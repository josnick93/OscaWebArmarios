
package com.dynamics.webServices.Warehouse_Receipt_Header_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Warehouse_Receipt_Header_WS_Fields.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Warehouse_Receipt_Header_WS_Fields">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Location_Code"/>
 *     &lt;enumeration value="Assigned_User_ID"/>
 *     &lt;enumeration value="Posting_Date"/>
 *     &lt;enumeration value="Vendor_Shipment_No"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Warehouse_Receipt_Header_WS_Fields")
@XmlEnum
public enum WarehouseReceiptHeaderWSFields {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Location_Code")
    LOCATION_CODE("Location_Code"),
    @XmlEnumValue("Assigned_User_ID")
    ASSIGNED_USER_ID("Assigned_User_ID"),
    @XmlEnumValue("Posting_Date")
    POSTING_DATE("Posting_Date"),
    @XmlEnumValue("Vendor_Shipment_No")
    VENDOR_SHIPMENT_NO("Vendor_Shipment_No");
    private final String value;

    WarehouseReceiptHeaderWSFields(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WarehouseReceiptHeaderWSFields fromValue(String v) {
        for (WarehouseReceiptHeaderWSFields c: WarehouseReceiptHeaderWSFields.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
