
package com.dynamics.webServices.Item_Card;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Replenishment_System.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Replenishment_System">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Purchase"/>
 *     &lt;enumeration value="Prod_Order"/>
 *     &lt;enumeration value="Assembly"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Replenishment_System")
@XmlEnum
public enum ReplenishmentSystem {

    @XmlEnumValue("Purchase")
    PURCHASE("Purchase"),
    @XmlEnumValue("Prod_Order")
    PROD_ORDER("Prod_Order"),
    @XmlEnumValue("Assembly")
    ASSEMBLY("Assembly");
    private final String value;

    ReplenishmentSystem(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReplenishmentSystem fromValue(String v) {
        for (ReplenishmentSystem c: ReplenishmentSystem.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
