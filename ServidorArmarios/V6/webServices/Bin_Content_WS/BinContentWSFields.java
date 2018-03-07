
package com.dynamics.webServices.Bin_Content_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Bin_Content_WS_Fields.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Bin_Content_WS_Fields">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Location_Code"/>
 *     &lt;enumeration value="Zone_Code"/>
 *     &lt;enumeration value="Bin_Code"/>
 *     &lt;enumeration value="Item_No"/>
 *     &lt;enumeration value="Bin_Type_Code"/>
 *     &lt;enumeration value="Warehouse_Class_Code"/>
 *     &lt;enumeration value="Block_Movement"/>
 *     &lt;enumeration value="Min_Qty"/>
 *     &lt;enumeration value="Max_Qty"/>
 *     &lt;enumeration value="Bin_Ranking"/>
 *     &lt;enumeration value="Quantity"/>
 *     &lt;enumeration value="Pick_Qty"/>
 *     &lt;enumeration value="Neg_Adjmt_Qty"/>
 *     &lt;enumeration value="Put_away_Qty"/>
 *     &lt;enumeration value="Pos_Adjmt_Qty"/>
 *     &lt;enumeration value="Fixed"/>
 *     &lt;enumeration value="Cross_Dock_Bin"/>
 *     &lt;enumeration value="Default"/>
 *     &lt;enumeration value="Quantity_Base"/>
 *     &lt;enumeration value="Pick_Quantity_Base"/>
 *     &lt;enumeration value="Negative_Adjmt_Qty_Base"/>
 *     &lt;enumeration value="Put_away_Quantity_Base"/>
 *     &lt;enumeration value="Positive_Adjmt_Qty_Base"/>
 *     &lt;enumeration value="ATO_Components_Pick_Qty"/>
 *     &lt;enumeration value="ATO_Components_Pick_Qty_Base"/>
 *     &lt;enumeration value="Variant_Code"/>
 *     &lt;enumeration value="Qty_per_Unit_of_Measure"/>
 *     &lt;enumeration value="Unit_of_Measure_Code"/>
 *     &lt;enumeration value="Lot_No_Filter"/>
 *     &lt;enumeration value="Serial_No_Filter"/>
 *     &lt;enumeration value="Dedicated"/>
 *     &lt;enumeration value="Unit_of_Measure_Filter"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Bin_Content_WS_Fields")
@XmlEnum
public enum BinContentWSFields {

    @XmlEnumValue("Location_Code")
    LOCATION_CODE("Location_Code"),
    @XmlEnumValue("Zone_Code")
    ZONE_CODE("Zone_Code"),
    @XmlEnumValue("Bin_Code")
    BIN_CODE("Bin_Code"),
    @XmlEnumValue("Item_No")
    ITEM_NO("Item_No"),
    @XmlEnumValue("Bin_Type_Code")
    BIN_TYPE_CODE("Bin_Type_Code"),
    @XmlEnumValue("Warehouse_Class_Code")
    WAREHOUSE_CLASS_CODE("Warehouse_Class_Code"),
    @XmlEnumValue("Block_Movement")
    BLOCK_MOVEMENT("Block_Movement"),
    @XmlEnumValue("Min_Qty")
    MIN_QTY("Min_Qty"),
    @XmlEnumValue("Max_Qty")
    MAX_QTY("Max_Qty"),
    @XmlEnumValue("Bin_Ranking")
    BIN_RANKING("Bin_Ranking"),
    @XmlEnumValue("Quantity")
    QUANTITY("Quantity"),
    @XmlEnumValue("Pick_Qty")
    PICK_QTY("Pick_Qty"),
    @XmlEnumValue("Neg_Adjmt_Qty")
    NEG_ADJMT_QTY("Neg_Adjmt_Qty"),
    @XmlEnumValue("Put_away_Qty")
    PUT_AWAY_QTY("Put_away_Qty"),
    @XmlEnumValue("Pos_Adjmt_Qty")
    POS_ADJMT_QTY("Pos_Adjmt_Qty"),
    @XmlEnumValue("Fixed")
    FIXED("Fixed"),
    @XmlEnumValue("Cross_Dock_Bin")
    CROSS_DOCK_BIN("Cross_Dock_Bin"),
    @XmlEnumValue("Default")
    DEFAULT("Default"),
    @XmlEnumValue("Quantity_Base")
    QUANTITY_BASE("Quantity_Base"),
    @XmlEnumValue("Pick_Quantity_Base")
    PICK_QUANTITY_BASE("Pick_Quantity_Base"),
    @XmlEnumValue("Negative_Adjmt_Qty_Base")
    NEGATIVE_ADJMT_QTY_BASE("Negative_Adjmt_Qty_Base"),
    @XmlEnumValue("Put_away_Quantity_Base")
    PUT_AWAY_QUANTITY_BASE("Put_away_Quantity_Base"),
    @XmlEnumValue("Positive_Adjmt_Qty_Base")
    POSITIVE_ADJMT_QTY_BASE("Positive_Adjmt_Qty_Base"),
    @XmlEnumValue("ATO_Components_Pick_Qty")
    ATO_COMPONENTS_PICK_QTY("ATO_Components_Pick_Qty"),
    @XmlEnumValue("ATO_Components_Pick_Qty_Base")
    ATO_COMPONENTS_PICK_QTY_BASE("ATO_Components_Pick_Qty_Base"),
    @XmlEnumValue("Variant_Code")
    VARIANT_CODE("Variant_Code"),
    @XmlEnumValue("Qty_per_Unit_of_Measure")
    QTY_PER_UNIT_OF_MEASURE("Qty_per_Unit_of_Measure"),
    @XmlEnumValue("Unit_of_Measure_Code")
    UNIT_OF_MEASURE_CODE("Unit_of_Measure_Code"),
    @XmlEnumValue("Lot_No_Filter")
    LOT_NO_FILTER("Lot_No_Filter"),
    @XmlEnumValue("Serial_No_Filter")
    SERIAL_NO_FILTER("Serial_No_Filter"),
    @XmlEnumValue("Dedicated")
    DEDICATED("Dedicated"),
    @XmlEnumValue("Unit_of_Measure_Filter")
    UNIT_OF_MEASURE_FILTER("Unit_of_Measure_Filter");
    private final String value;

    BinContentWSFields(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BinContentWSFields fromValue(String v) {
        for (BinContentWSFields c: BinContentWSFields.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
