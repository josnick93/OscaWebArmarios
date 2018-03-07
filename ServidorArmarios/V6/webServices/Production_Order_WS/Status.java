
package com.dynamics.webServices.Production_Order_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Status.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Status">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Simulated"/>
 *     &lt;enumeration value="Planned"/>
 *     &lt;enumeration value="Firm_Planned"/>
 *     &lt;enumeration value="Released"/>
 *     &lt;enumeration value="Finished"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Status")
@XmlEnum
public enum Status {

    @XmlEnumValue("Simulated")
    SIMULATED("Simulated"),
    @XmlEnumValue("Planned")
    PLANNED("Planned"),
    @XmlEnumValue("Firm_Planned")
    FIRM_PLANNED("Firm_Planned"),
    @XmlEnumValue("Released")
    RELEASED("Released"),
    @XmlEnumValue("Finished")
    FINISHED("Finished");
    private final String value;

    Status(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Status fromValue(String v) {
        for (Status c: Status.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
