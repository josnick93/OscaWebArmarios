
package com.dynamics.webServices.Item_Card;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para StockoutWarningDefaultYes.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="StockoutWarningDefaultYes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Default"/>
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Yes"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StockoutWarningDefaultYes")
@XmlEnum
public enum StockoutWarningDefaultYes {

    @XmlEnumValue("Default")
    DEFAULT("Default"),
    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Yes")
    YES("Yes");
    private final String value;

    StockoutWarningDefaultYes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StockoutWarningDefaultYes fromValue(String v) {
        for (StockoutWarningDefaultYes c: StockoutWarningDefaultYes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
