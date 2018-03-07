
package com.dynamics.webServices.Item_Card_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Assembly_Policy.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Assembly_Policy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Assemble_to_Stock"/>
 *     &lt;enumeration value="Assemble_to_Order"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Assembly_Policy")
@XmlEnum
public enum AssemblyPolicy {

    @XmlEnumValue("Assemble_to_Stock")
    ASSEMBLE_TO_STOCK("Assemble_to_Stock"),
    @XmlEnumValue("Assemble_to_Order")
    ASSEMBLE_TO_ORDER("Assemble_to_Order");
    private final String value;

    AssemblyPolicy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AssemblyPolicy fromValue(String v) {
        for (AssemblyPolicy c: AssemblyPolicy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
