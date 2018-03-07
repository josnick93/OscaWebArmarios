
package com.dynamics.webServices.Bin_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Block_Movement.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Block_Movement">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="_blank_"/>
 *     &lt;enumeration value="Inbound"/>
 *     &lt;enumeration value="Outbound"/>
 *     &lt;enumeration value="All"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Block_Movement")
@XmlEnum
public enum BlockMovement {

    @XmlEnumValue("_blank_")
    BLANK("_blank_"),
    @XmlEnumValue("Inbound")
    INBOUND("Inbound"),
    @XmlEnumValue("Outbound")
    OUTBOUND("Outbound"),
    @XmlEnumValue("All")
    ALL("All");
    private final String value;

    BlockMovement(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BlockMovement fromValue(String v) {
        for (BlockMovement c: BlockMovement.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
