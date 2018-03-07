
package com.dynamics.webServices.Prod_Order_Component_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Prod_Order_Component_WS_Fields.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Prod_Order_Component_WS_Fields">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Status"/>
 *     &lt;enumeration value="Prod_Order_No"/>
 *     &lt;enumeration value="Prod_Order_Line_No"/>
 *     &lt;enumeration value="Item_No"/>
 *     &lt;enumeration value="Description"/>
 *     &lt;enumeration value="Search_Description"/>
 *     &lt;enumeration value="Unit_of_Measure_Code"/>
 *     &lt;enumeration value="Quantity"/>
 *     &lt;enumeration value="Quantity_Base"/>
 *     &lt;enumeration value="Quantity_per"/>
 *     &lt;enumeration value="Qty_per_Unit_of_Measure"/>
 *     &lt;enumeration value="Expected_Quantity"/>
 *     &lt;enumeration value="Expected_Qty_Base"/>
 *     &lt;enumeration value="Remaining_Quantity"/>
 *     &lt;enumeration value="Remaining_Qty_Base"/>
 *     &lt;enumeration value="Act_Consumption_Qty"/>
 *     &lt;enumeration value="Routing_Link_Code"/>
 *     &lt;enumeration value="Flushing_Method"/>
 *     &lt;enumeration value="Location_Code"/>
 *     &lt;enumeration value="Bin_Code"/>
 *     &lt;enumeration value="Category"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Prod_Order_Component_WS_Fields")
@XmlEnum
public enum ProdOrderComponentWSFields {

    @XmlEnumValue("Status")
    STATUS("Status"),
    @XmlEnumValue("Prod_Order_No")
    PROD_ORDER_NO("Prod_Order_No"),
    @XmlEnumValue("Prod_Order_Line_No")
    PROD_ORDER_LINE_NO("Prod_Order_Line_No"),
    @XmlEnumValue("Item_No")
    ITEM_NO("Item_No"),
    @XmlEnumValue("Description")
    DESCRIPTION("Description"),
    @XmlEnumValue("Search_Description")
    SEARCH_DESCRIPTION("Search_Description"),
    @XmlEnumValue("Unit_of_Measure_Code")
    UNIT_OF_MEASURE_CODE("Unit_of_Measure_Code"),
    @XmlEnumValue("Quantity")
    QUANTITY("Quantity"),
    @XmlEnumValue("Quantity_Base")
    QUANTITY_BASE("Quantity_Base"),
    @XmlEnumValue("Quantity_per")
    QUANTITY_PER("Quantity_per"),
    @XmlEnumValue("Qty_per_Unit_of_Measure")
    QTY_PER_UNIT_OF_MEASURE("Qty_per_Unit_of_Measure"),
    @XmlEnumValue("Expected_Quantity")
    EXPECTED_QUANTITY("Expected_Quantity"),
    @XmlEnumValue("Expected_Qty_Base")
    EXPECTED_QTY_BASE("Expected_Qty_Base"),
    @XmlEnumValue("Remaining_Quantity")
    REMAINING_QUANTITY("Remaining_Quantity"),
    @XmlEnumValue("Remaining_Qty_Base")
    REMAINING_QTY_BASE("Remaining_Qty_Base"),
    @XmlEnumValue("Act_Consumption_Qty")
    ACT_CONSUMPTION_QTY("Act_Consumption_Qty"),
    @XmlEnumValue("Routing_Link_Code")
    ROUTING_LINK_CODE("Routing_Link_Code"),
    @XmlEnumValue("Flushing_Method")
    FLUSHING_METHOD("Flushing_Method"),
    @XmlEnumValue("Location_Code")
    LOCATION_CODE("Location_Code"),
    @XmlEnumValue("Bin_Code")
    BIN_CODE("Bin_Code"),
    @XmlEnumValue("Category")
    CATEGORY("Category");
    private final String value;

    ProdOrderComponentWSFields(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProdOrderComponentWSFields fromValue(String v) {
        for (ProdOrderComponentWSFields c: ProdOrderComponentWSFields.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
