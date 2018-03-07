
package com.dynamics.webServices.Warehouse_Activity_Line_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Warehouse_Activity_Line_WS_Fields.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Warehouse_Activity_Line_WS_Fields">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Activity_Type"/>
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Line_No"/>
 *     &lt;enumeration value="Item_No"/>
 *     &lt;enumeration value="Variant_Code"/>
 *     &lt;enumeration value="Description"/>
 *     &lt;enumeration value="Unit_of_Measure_Code"/>
 *     &lt;enumeration value="Quantity"/>
 *     &lt;enumeration value="Bin_Code"/>
 *     &lt;enumeration value="Action_Type"/>
 *     &lt;enumeration value="Lot_No"/>
 *     &lt;enumeration value="Serial_No"/>
 *     &lt;enumeration value="Qty_to_Handle"/>
 *     &lt;enumeration value="Qty_Handled"/>
 *     &lt;enumeration value="Qty_Outstanding"/>
 *     &lt;enumeration value="Source_Document"/>
 *     &lt;enumeration value="Source_No"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Warehouse_Activity_Line_WS_Fields")
@XmlEnum
public enum WarehouseActivityLineWSFields {

    @XmlEnumValue("Activity_Type")
    ACTIVITY_TYPE("Activity_Type"),
    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Line_No")
    LINE_NO("Line_No"),
    @XmlEnumValue("Item_No")
    ITEM_NO("Item_No"),
    @XmlEnumValue("Variant_Code")
    VARIANT_CODE("Variant_Code"),
    @XmlEnumValue("Description")
    DESCRIPTION("Description"),
    @XmlEnumValue("Unit_of_Measure_Code")
    UNIT_OF_MEASURE_CODE("Unit_of_Measure_Code"),
    @XmlEnumValue("Quantity")
    QUANTITY("Quantity"),
    @XmlEnumValue("Bin_Code")
    BIN_CODE("Bin_Code"),
    @XmlEnumValue("Action_Type")
    ACTION_TYPE("Action_Type"),
    @XmlEnumValue("Lot_No")
    LOT_NO("Lot_No"),
    @XmlEnumValue("Serial_No")
    SERIAL_NO("Serial_No"),
    @XmlEnumValue("Qty_to_Handle")
    QTY_TO_HANDLE("Qty_to_Handle"),
    @XmlEnumValue("Qty_Handled")
    QTY_HANDLED("Qty_Handled"),
    @XmlEnumValue("Qty_Outstanding")
    QTY_OUTSTANDING("Qty_Outstanding"),
    @XmlEnumValue("Source_Document")
    SOURCE_DOCUMENT("Source_Document"),
    @XmlEnumValue("Source_No")
    SOURCE_NO("Source_No");
    private final String value;

    WarehouseActivityLineWSFields(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WarehouseActivityLineWSFields fromValue(String v) {
        for (WarehouseActivityLineWSFields c: WarehouseActivityLineWSFields.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
