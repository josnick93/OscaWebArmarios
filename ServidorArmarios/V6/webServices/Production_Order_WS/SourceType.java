
package com.dynamics.webServices.Production_Order_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Source_Type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Source_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Item"/>
 *     &lt;enumeration value="Family"/>
 *     &lt;enumeration value="Sales_Header"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Source_Type")
@XmlEnum
public enum SourceType {

    @XmlEnumValue("Item")
    ITEM("Item"),
    @XmlEnumValue("Family")
    FAMILY("Family"),
    @XmlEnumValue("Sales_Header")
    SALES_HEADER("Sales_Header");
    private final String value;

    SourceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SourceType fromValue(String v) {
        for (SourceType c: SourceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
