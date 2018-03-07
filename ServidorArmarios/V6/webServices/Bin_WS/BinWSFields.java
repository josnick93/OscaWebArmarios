
package com.dynamics.webServices.Bin_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Bin_WS_Fields.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Bin_WS_Fields">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Location_Code"/>
 *     &lt;enumeration value="Code"/>
 *     &lt;enumeration value="Description"/>
 *     &lt;enumeration value="Zone_Code"/>
 *     &lt;enumeration value="Adjustment_Bin"/>
 *     &lt;enumeration value="Bin_Type_Code"/>
 *     &lt;enumeration value="Warehouse_Class_Code"/>
 *     &lt;enumeration value="Block_Movement"/>
 *     &lt;enumeration value="Special_Equipment_Code"/>
 *     &lt;enumeration value="Bin_Ranking"/>
 *     &lt;enumeration value="Maximum_Cubage"/>
 *     &lt;enumeration value="Maximum_Weight"/>
 *     &lt;enumeration value="Empty"/>
 *     &lt;enumeration value="Item_Filter"/>
 *     &lt;enumeration value="Variant_Filter"/>
 *     &lt;enumeration value="Default"/>
 *     &lt;enumeration value="Cross_Dock_Bin"/>
 *     &lt;enumeration value="Dedicated"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Bin_WS_Fields")
@XmlEnum
public enum BinWSFields {

    @XmlEnumValue("Location_Code")
    LOCATION_CODE("Location_Code"),
    @XmlEnumValue("Code")
    CODE("Code"),
    @XmlEnumValue("Description")
    DESCRIPTION("Description"),
    @XmlEnumValue("Zone_Code")
    ZONE_CODE("Zone_Code"),
    @XmlEnumValue("Adjustment_Bin")
    ADJUSTMENT_BIN("Adjustment_Bin"),
    @XmlEnumValue("Bin_Type_Code")
    BIN_TYPE_CODE("Bin_Type_Code"),
    @XmlEnumValue("Warehouse_Class_Code")
    WAREHOUSE_CLASS_CODE("Warehouse_Class_Code"),
    @XmlEnumValue("Block_Movement")
    BLOCK_MOVEMENT("Block_Movement"),
    @XmlEnumValue("Special_Equipment_Code")
    SPECIAL_EQUIPMENT_CODE("Special_Equipment_Code"),
    @XmlEnumValue("Bin_Ranking")
    BIN_RANKING("Bin_Ranking"),
    @XmlEnumValue("Maximum_Cubage")
    MAXIMUM_CUBAGE("Maximum_Cubage"),
    @XmlEnumValue("Maximum_Weight")
    MAXIMUM_WEIGHT("Maximum_Weight"),
    @XmlEnumValue("Empty")
    EMPTY("Empty"),
    @XmlEnumValue("Item_Filter")
    ITEM_FILTER("Item_Filter"),
    @XmlEnumValue("Variant_Filter")
    VARIANT_FILTER("Variant_Filter"),
    @XmlEnumValue("Default")
    DEFAULT("Default"),
    @XmlEnumValue("Cross_Dock_Bin")
    CROSS_DOCK_BIN("Cross_Dock_Bin"),
    @XmlEnumValue("Dedicated")
    DEDICATED("Dedicated");
    private final String value;

    BinWSFields(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BinWSFields fromValue(String v) {
        for (BinWSFields c: BinWSFields.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
