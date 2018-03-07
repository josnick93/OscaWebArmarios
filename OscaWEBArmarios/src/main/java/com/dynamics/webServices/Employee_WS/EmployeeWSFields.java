
package com.dynamics.webServices.Employee_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Employee_WS_Fields.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Employee_WS_Fields">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Name"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Employee_WS_Fields")
@XmlEnum
public enum EmployeeWSFields {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Name")
    NAME("Name");
    private final String value;

    EmployeeWSFields(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EmployeeWSFields fromValue(String v) {
        for (EmployeeWSFields c: EmployeeWSFields.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
