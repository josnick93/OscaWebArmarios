
package com.dynamics.webServices.Prod_Order_Line_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Prod_Order_Line_WS_Fields.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Prod_Order_Line_WS_Fields">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Prod_Order_No"/>
 *     &lt;enumeration value="Line_No"/>
 *     &lt;enumeration value="Item_No"/>
 *     &lt;enumeration value="Description"/>
 *     &lt;enumeration value="Search_Description"/>
 *     &lt;enumeration value="Location_Code"/>
 *     &lt;enumeration value="Bin_Code"/>
 *     &lt;enumeration value="Quantity"/>
 *     &lt;enumeration value="Quantity_Base"/>
 *     &lt;enumeration value="Finished_Quantity"/>
 *     &lt;enumeration value="Finished_Qty_Base"/>
 *     &lt;enumeration value="Remaining_Quantity"/>
 *     &lt;enumeration value="Remaining_Qty_Base"/>
 *     &lt;enumeration value="Due_Date"/>
 *     &lt;enumeration value="Hose_Id"/>
 *     &lt;enumeration value="Status"/>
 *     &lt;enumeration value="Crane"/>
 *     &lt;enumeration value="Part"/>
 *     &lt;enumeration value="Crane_Id"/>
 *     &lt;enumeration value="Part_Id"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Prod_Order_Line_WS_Fields")
@XmlEnum
public enum ProdOrderLineWSFields {

    @XmlEnumValue("Prod_Order_No")
    PROD_ORDER_NO("Prod_Order_No"),
    @XmlEnumValue("Line_No")
    LINE_NO("Line_No"),
    @XmlEnumValue("Item_No")
    ITEM_NO("Item_No"),
    @XmlEnumValue("Description")
    DESCRIPTION("Description"),
    @XmlEnumValue("Search_Description")
    SEARCH_DESCRIPTION("Search_Description"),
    @XmlEnumValue("Location_Code")
    LOCATION_CODE("Location_Code"),
    @XmlEnumValue("Bin_Code")
    BIN_CODE("Bin_Code"),
    @XmlEnumValue("Quantity")
    QUANTITY("Quantity"),
    @XmlEnumValue("Quantity_Base")
    QUANTITY_BASE("Quantity_Base"),
    @XmlEnumValue("Finished_Quantity")
    FINISHED_QUANTITY("Finished_Quantity"),
    @XmlEnumValue("Finished_Qty_Base")
    FINISHED_QTY_BASE("Finished_Qty_Base"),
    @XmlEnumValue("Remaining_Quantity")
    REMAINING_QUANTITY("Remaining_Quantity"),
    @XmlEnumValue("Remaining_Qty_Base")
    REMAINING_QTY_BASE("Remaining_Qty_Base"),
    @XmlEnumValue("Due_Date")
    DUE_DATE("Due_Date"),
    @XmlEnumValue("Hose_Id")
    HOSE_ID("Hose_Id"),
    @XmlEnumValue("Status")
    STATUS("Status"),
    @XmlEnumValue("Crane")
    CRANE("Crane"),
    @XmlEnumValue("Part")
    PART("Part"),
    @XmlEnumValue("Crane_Id")
    CRANE_ID("Crane_Id"),
    @XmlEnumValue("Part_Id")
    PART_ID("Part_Id");
    private final String value;

    ProdOrderLineWSFields(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProdOrderLineWSFields fromValue(String v) {
        for (ProdOrderLineWSFields c: ProdOrderLineWSFields.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
