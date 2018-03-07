
package com.dynamics.webServices.Warehouse_Shipment_Line_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Warehouse_Shipment_Line_WS_Fields.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Warehouse_Shipment_Line_WS_Fields">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Line_No"/>
 *     &lt;enumeration value="Item_No"/>
 *     &lt;enumeration value="Variant_Code"/>
 *     &lt;enumeration value="Quantity"/>
 *     &lt;enumeration value="Qty_to_Ship"/>
 *     &lt;enumeration value="Qty_Shipped"/>
 *     &lt;enumeration value="Unit_of_Measure_Code"/>
 *     &lt;enumeration value="Description"/>
 *     &lt;enumeration value="Qty_to_Ship_Base"/>
 *     &lt;enumeration value="Qty_Shipped_Base"/>
 *     &lt;enumeration value="Source_Type"/>
 *     &lt;enumeration value="Source_Subtype"/>
 *     &lt;enumeration value="Source_No"/>
 *     &lt;enumeration value="Source_Line_No"/>
 *     &lt;enumeration value="Source_Document"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Warehouse_Shipment_Line_WS_Fields")
@XmlEnum
public enum WarehouseShipmentLineWSFields {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Line_No")
    LINE_NO("Line_No"),
    @XmlEnumValue("Item_No")
    ITEM_NO("Item_No"),
    @XmlEnumValue("Variant_Code")
    VARIANT_CODE("Variant_Code"),
    @XmlEnumValue("Quantity")
    QUANTITY("Quantity"),
    @XmlEnumValue("Qty_to_Ship")
    QTY_TO_SHIP("Qty_to_Ship"),
    @XmlEnumValue("Qty_Shipped")
    QTY_SHIPPED("Qty_Shipped"),
    @XmlEnumValue("Unit_of_Measure_Code")
    UNIT_OF_MEASURE_CODE("Unit_of_Measure_Code"),
    @XmlEnumValue("Description")
    DESCRIPTION("Description"),
    @XmlEnumValue("Qty_to_Ship_Base")
    QTY_TO_SHIP_BASE("Qty_to_Ship_Base"),
    @XmlEnumValue("Qty_Shipped_Base")
    QTY_SHIPPED_BASE("Qty_Shipped_Base"),
    @XmlEnumValue("Source_Type")
    SOURCE_TYPE("Source_Type"),
    @XmlEnumValue("Source_Subtype")
    SOURCE_SUBTYPE("Source_Subtype"),
    @XmlEnumValue("Source_No")
    SOURCE_NO("Source_No"),
    @XmlEnumValue("Source_Line_No")
    SOURCE_LINE_NO("Source_Line_No"),
    @XmlEnumValue("Source_Document")
    SOURCE_DOCUMENT("Source_Document");
    private final String value;

    WarehouseShipmentLineWSFields(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WarehouseShipmentLineWSFields fromValue(String v) {
        for (WarehouseShipmentLineWSFields c: WarehouseShipmentLineWSFields.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
