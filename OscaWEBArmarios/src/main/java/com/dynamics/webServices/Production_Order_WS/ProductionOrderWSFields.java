
package com.dynamics.webServices.Production_Order_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Production_Order_WS_Fields.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Production_Order_WS_Fields">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Description"/>
 *     &lt;enumeration value="Due_Date"/>
 *     &lt;enumeration value="Customer_No"/>
 *     &lt;enumeration value="Customer_Name"/>
 *     &lt;enumeration value="Source_Type"/>
 *     &lt;enumeration value="Source_No"/>
 *     &lt;enumeration value="Search_Description"/>
 *     &lt;enumeration value="Status"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Production_Order_WS_Fields")
@XmlEnum
public enum ProductionOrderWSFields {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Description")
    DESCRIPTION("Description"),
    @XmlEnumValue("Due_Date")
    DUE_DATE("Due_Date"),
    @XmlEnumValue("Customer_No")
    CUSTOMER_NO("Customer_No"),
    @XmlEnumValue("Customer_Name")
    CUSTOMER_NAME("Customer_Name"),
    @XmlEnumValue("Source_Type")
    SOURCE_TYPE("Source_Type"),
    @XmlEnumValue("Source_No")
    SOURCE_NO("Source_No"),
    @XmlEnumValue("Search_Description")
    SEARCH_DESCRIPTION("Search_Description"),
    @XmlEnumValue("Status")
    STATUS("Status");
    private final String value;

    ProductionOrderWSFields(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProductionOrderWSFields fromValue(String v) {
        for (ProductionOrderWSFields c: ProductionOrderWSFields.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
