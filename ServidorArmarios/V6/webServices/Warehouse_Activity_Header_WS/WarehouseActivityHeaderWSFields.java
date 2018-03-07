
package com.dynamics.webServices.Warehouse_Activity_Header_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Warehouse_Activity_Header_WS_Fields.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Warehouse_Activity_Header_WS_Fields">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Type"/>
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Location_Code"/>
 *     &lt;enumeration value="Assigned_User_ID"/>
 *     &lt;enumeration value="Comment"/>
 *     &lt;enumeration value="Posting_Date"/>
 *     &lt;enumeration value="Source_No"/>
 *     &lt;enumeration value="Source_Document"/>
 *     &lt;enumeration value="Source_Type"/>
 *     &lt;enumeration value="Source_Subtype"/>
 *     &lt;enumeration value="Destination_Type"/>
 *     &lt;enumeration value="Destination_No"/>
 *     &lt;enumeration value="External_Document_No"/>
 *     &lt;enumeration value="Shipment_Date"/>
 *     &lt;enumeration value="Expected_Receipt_Date"/>
 *     &lt;enumeration value="ls_OrderNo"/>
 *     &lt;enumeration value="ls_ShipmentNo"/>
 *     &lt;enumeration value="ls_CustomerName"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Warehouse_Activity_Header_WS_Fields")
@XmlEnum
public enum WarehouseActivityHeaderWSFields {

    @XmlEnumValue("Type")
    TYPE("Type"),
    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Location_Code")
    LOCATION_CODE("Location_Code"),
    @XmlEnumValue("Assigned_User_ID")
    ASSIGNED_USER_ID("Assigned_User_ID"),
    @XmlEnumValue("Comment")
    COMMENT("Comment"),
    @XmlEnumValue("Posting_Date")
    POSTING_DATE("Posting_Date"),
    @XmlEnumValue("Source_No")
    SOURCE_NO("Source_No"),
    @XmlEnumValue("Source_Document")
    SOURCE_DOCUMENT("Source_Document"),
    @XmlEnumValue("Source_Type")
    SOURCE_TYPE("Source_Type"),
    @XmlEnumValue("Source_Subtype")
    SOURCE_SUBTYPE("Source_Subtype"),
    @XmlEnumValue("Destination_Type")
    DESTINATION_TYPE("Destination_Type"),
    @XmlEnumValue("Destination_No")
    DESTINATION_NO("Destination_No"),
    @XmlEnumValue("External_Document_No")
    EXTERNAL_DOCUMENT_NO("External_Document_No"),
    @XmlEnumValue("Shipment_Date")
    SHIPMENT_DATE("Shipment_Date"),
    @XmlEnumValue("Expected_Receipt_Date")
    EXPECTED_RECEIPT_DATE("Expected_Receipt_Date"),
    @XmlEnumValue("ls_OrderNo")
    LS_ORDER_NO("ls_OrderNo"),
    @XmlEnumValue("ls_ShipmentNo")
    LS_SHIPMENT_NO("ls_ShipmentNo"),
    @XmlEnumValue("ls_CustomerName")
    LS_CUSTOMER_NAME("ls_CustomerName");
    private final String value;

    WarehouseActivityHeaderWSFields(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WarehouseActivityHeaderWSFields fromValue(String v) {
        for (WarehouseActivityHeaderWSFields c: WarehouseActivityHeaderWSFields.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
