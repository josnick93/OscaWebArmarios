
package com.dynamics.webServices.Warehouse_Activity_Header_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="_blank_"/>
 *     &lt;enumeration value="Put_away"/>
 *     &lt;enumeration value="Pick"/>
 *     &lt;enumeration value="Movement"/>
 *     &lt;enumeration value="Invt_Put_away"/>
 *     &lt;enumeration value="Invt_Pick"/>
 *     &lt;enumeration value="Invt_Movement"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Type")
@XmlEnum
public enum Type {

    @XmlEnumValue("_blank_")
    BLANK("_blank_"),
    @XmlEnumValue("Put_away")
    PUT_AWAY("Put_away"),
    @XmlEnumValue("Pick")
    PICK("Pick"),
    @XmlEnumValue("Movement")
    MOVEMENT("Movement"),
    @XmlEnumValue("Invt_Put_away")
    INVT_PUT_AWAY("Invt_Put_away"),
    @XmlEnumValue("Invt_Pick")
    INVT_PICK("Invt_Pick"),
    @XmlEnumValue("Invt_Movement")
    INVT_MOVEMENT("Invt_Movement");
    private final String value;

    Type(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Type fromValue(String v) {
        for (Type c: Type.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
