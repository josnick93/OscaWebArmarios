
package com.dynamics.webServices.Warehouse_Receipt_Line_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Warehouse_Receipt_Line_WS_Fields.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Warehouse_Receipt_Line_WS_Fields">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Line_No"/>
 *     &lt;enumeration value="Source_Type"/>
 *     &lt;enumeration value="Source_Subtype"/>
 *     &lt;enumeration value="Source_No"/>
 *     &lt;enumeration value="Source_Line_No"/>
 *     &lt;enumeration value="Item_No"/>
 *     &lt;enumeration value="Variant_Code"/>
 *     &lt;enumeration value="Description"/>
 *     &lt;enumeration value="Quantity"/>
 *     &lt;enumeration value="Qty_to_Receive"/>
 *     &lt;enumeration value="Qty_Received"/>
 *     &lt;enumeration value="Qty_Base"/>
 *     &lt;enumeration value="Qty_to_Receive_Base"/>
 *     &lt;enumeration value="Qty_Received_Base"/>
 *     &lt;enumeration value="Qty_Outstanding_Base"/>
 *     &lt;enumeration value="Unit_of_Measure_Code"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Warehouse_Receipt_Line_WS_Fields")
@XmlEnum
public enum WarehouseReceiptLineWSFields {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Line_No")
    LINE_NO("Line_No"),
    @XmlEnumValue("Source_Type")
    SOURCE_TYPE("Source_Type"),
    @XmlEnumValue("Source_Subtype")
    SOURCE_SUBTYPE("Source_Subtype"),
    @XmlEnumValue("Source_No")
    SOURCE_NO("Source_No"),
    @XmlEnumValue("Source_Line_No")
    SOURCE_LINE_NO("Source_Line_No"),
    @XmlEnumValue("Item_No")
    ITEM_NO("Item_No"),
    @XmlEnumValue("Variant_Code")
    VARIANT_CODE("Variant_Code"),
    @XmlEnumValue("Description")
    DESCRIPTION("Description"),
    @XmlEnumValue("Quantity")
    QUANTITY("Quantity"),
    @XmlEnumValue("Qty_to_Receive")
    QTY_TO_RECEIVE("Qty_to_Receive"),
    @XmlEnumValue("Qty_Received")
    QTY_RECEIVED("Qty_Received"),
    @XmlEnumValue("Qty_Base")
    QTY_BASE("Qty_Base"),
    @XmlEnumValue("Qty_to_Receive_Base")
    QTY_TO_RECEIVE_BASE("Qty_to_Receive_Base"),
    @XmlEnumValue("Qty_Received_Base")
    QTY_RECEIVED_BASE("Qty_Received_Base"),
    @XmlEnumValue("Qty_Outstanding_Base")
    QTY_OUTSTANDING_BASE("Qty_Outstanding_Base"),
    @XmlEnumValue("Unit_of_Measure_Code")
    UNIT_OF_MEASURE_CODE("Unit_of_Measure_Code");
    private final String value;

    WarehouseReceiptLineWSFields(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WarehouseReceiptLineWSFields fromValue(String v) {
        for (WarehouseReceiptLineWSFields c: WarehouseReceiptLineWSFields.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
