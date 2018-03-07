
package com.dynamics.webServices.Warehouse_Activity_Header_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Source_Subtype.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Source_Subtype">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="_x0030_"/>
 *     &lt;enumeration value="_x0031_"/>
 *     &lt;enumeration value="_x0032_"/>
 *     &lt;enumeration value="_x0033_"/>
 *     &lt;enumeration value="_x0034_"/>
 *     &lt;enumeration value="_x0035_"/>
 *     &lt;enumeration value="_x0036_"/>
 *     &lt;enumeration value="_x0037_"/>
 *     &lt;enumeration value="_x0038_"/>
 *     &lt;enumeration value="_x0039_"/>
 *     &lt;enumeration value="_x0031_0"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Source_Subtype")
@XmlEnum
public enum SourceSubtype {

    @XmlEnumValue("_x0030_")
    X_0030("_x0030_"),
    @XmlEnumValue("_x0031_")
    X_0031("_x0031_"),
    @XmlEnumValue("_x0032_")
    X_0032("_x0032_"),
    @XmlEnumValue("_x0033_")
    X_0033("_x0033_"),
    @XmlEnumValue("_x0034_")
    X_0034("_x0034_"),
    @XmlEnumValue("_x0035_")
    X_0035("_x0035_"),
    @XmlEnumValue("_x0036_")
    X_0036("_x0036_"),
    @XmlEnumValue("_x0037_")
    X_0037("_x0037_"),
    @XmlEnumValue("_x0038_")
    X_0038("_x0038_"),
    @XmlEnumValue("_x0039_")
    X_0039("_x0039_"),
    @XmlEnumValue("_x0031_0")
    X_0031_0("_x0031_0");
    private final String value;

    SourceSubtype(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SourceSubtype fromValue(String v) {
        for (SourceSubtype c: SourceSubtype.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
