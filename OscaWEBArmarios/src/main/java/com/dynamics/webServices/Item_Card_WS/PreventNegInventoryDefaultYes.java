
package com.dynamics.webServices.Item_Card_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PreventNegInventoryDefaultYes.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="PreventNegInventoryDefaultYes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Default"/>
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Yes"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PreventNegInventoryDefaultYes")
@XmlEnum
public enum PreventNegInventoryDefaultYes {

    @XmlEnumValue("Default")
    DEFAULT("Default"),
    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Yes")
    YES("Yes");
    private final String value;

    PreventNegInventoryDefaultYes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PreventNegInventoryDefaultYes fromValue(String v) {
        for (PreventNegInventoryDefaultYes c: PreventNegInventoryDefaultYes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
