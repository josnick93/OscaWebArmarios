
package com.dynamics.webServices.Warehouse_Activity_Header_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Source_Document.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Source_Document">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="_blank_"/>
 *     &lt;enumeration value="Sales_Order"/>
 *     &lt;enumeration value="Sales_Return_Order"/>
 *     &lt;enumeration value="Purchase_Order"/>
 *     &lt;enumeration value="Purchase_Return_Order"/>
 *     &lt;enumeration value="Inbound_Transfer"/>
 *     &lt;enumeration value="Outbound_Transfer"/>
 *     &lt;enumeration value="Prod_Consumption"/>
 *     &lt;enumeration value="Prod_Output"/>
 *     &lt;enumeration value="Assembly_Consumption"/>
 *     &lt;enumeration value="Assembly_Order"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Source_Document")
@XmlEnum
public enum SourceDocument {

    @XmlEnumValue("_blank_")
    BLANK("_blank_"),
    @XmlEnumValue("Sales_Order")
    SALES_ORDER("Sales_Order"),
    @XmlEnumValue("Sales_Return_Order")
    SALES_RETURN_ORDER("Sales_Return_Order"),
    @XmlEnumValue("Purchase_Order")
    PURCHASE_ORDER("Purchase_Order"),
    @XmlEnumValue("Purchase_Return_Order")
    PURCHASE_RETURN_ORDER("Purchase_Return_Order"),
    @XmlEnumValue("Inbound_Transfer")
    INBOUND_TRANSFER("Inbound_Transfer"),
    @XmlEnumValue("Outbound_Transfer")
    OUTBOUND_TRANSFER("Outbound_Transfer"),
    @XmlEnumValue("Prod_Consumption")
    PROD_CONSUMPTION("Prod_Consumption"),
    @XmlEnumValue("Prod_Output")
    PROD_OUTPUT("Prod_Output"),
    @XmlEnumValue("Assembly_Consumption")
    ASSEMBLY_CONSUMPTION("Assembly_Consumption"),
    @XmlEnumValue("Assembly_Order")
    ASSEMBLY_ORDER("Assembly_Order");
    private final String value;

    SourceDocument(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SourceDocument fromValue(String v) {
        for (SourceDocument c: SourceDocument.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
