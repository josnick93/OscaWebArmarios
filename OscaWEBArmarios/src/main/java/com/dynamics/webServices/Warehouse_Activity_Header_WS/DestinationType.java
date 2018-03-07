
package com.dynamics.webServices.Warehouse_Activity_Header_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Destination_Type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Destination_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="_blank_"/>
 *     &lt;enumeration value="Customer"/>
 *     &lt;enumeration value="Vendor"/>
 *     &lt;enumeration value="Location"/>
 *     &lt;enumeration value="Item"/>
 *     &lt;enumeration value="Family"/>
 *     &lt;enumeration value="Sales_Order"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Destination_Type")
@XmlEnum
public enum DestinationType {

    @XmlEnumValue("_blank_")
    BLANK("_blank_"),
    @XmlEnumValue("Customer")
    CUSTOMER("Customer"),
    @XmlEnumValue("Vendor")
    VENDOR("Vendor"),
    @XmlEnumValue("Location")
    LOCATION("Location"),
    @XmlEnumValue("Item")
    ITEM("Item"),
    @XmlEnumValue("Family")
    FAMILY("Family"),
    @XmlEnumValue("Sales_Order")
    SALES_ORDER("Sales_Order");
    private final String value;

    DestinationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DestinationType fromValue(String v) {
        for (DestinationType c: DestinationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
