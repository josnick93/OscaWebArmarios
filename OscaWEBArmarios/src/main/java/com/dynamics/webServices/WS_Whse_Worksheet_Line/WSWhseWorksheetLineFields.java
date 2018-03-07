
package com.dynamics.webServices.WS_Whse_Worksheet_Line;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para WS_Whse_Worksheet_Line_Fields.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="WS_Whse_Worksheet_Line_Fields">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Worksheet_Template_Name"/>
 *     &lt;enumeration value="Name"/>
 *     &lt;enumeration value="Location_Code"/>
 *     &lt;enumeration value="Line_No"/>
 *     &lt;enumeration value="Item_No"/>
 *     &lt;enumeration value="Description"/>
 *     &lt;enumeration value="From_Bin_Code"/>
 *     &lt;enumeration value="To_Bin_Code"/>
 *     &lt;enumeration value="Quantity"/>
 *     &lt;enumeration value="Qty_to_Handle"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WS_Whse_Worksheet_Line_Fields")
@XmlEnum
public enum WSWhseWorksheetLineFields {

    @XmlEnumValue("Worksheet_Template_Name")
    WORKSHEET_TEMPLATE_NAME("Worksheet_Template_Name"),
    @XmlEnumValue("Name")
    NAME("Name"),
    @XmlEnumValue("Location_Code")
    LOCATION_CODE("Location_Code"),
    @XmlEnumValue("Line_No")
    LINE_NO("Line_No"),
    @XmlEnumValue("Item_No")
    ITEM_NO("Item_No"),
    @XmlEnumValue("Description")
    DESCRIPTION("Description"),
    @XmlEnumValue("From_Bin_Code")
    FROM_BIN_CODE("From_Bin_Code"),
    @XmlEnumValue("To_Bin_Code")
    TO_BIN_CODE("To_Bin_Code"),
    @XmlEnumValue("Quantity")
    QUANTITY("Quantity"),
    @XmlEnumValue("Qty_to_Handle")
    QTY_TO_HANDLE("Qty_to_Handle");
    private final String value;

    WSWhseWorksheetLineFields(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WSWhseWorksheetLineFields fromValue(String v) {
        for (WSWhseWorksheetLineFields c: WSWhseWorksheetLineFields.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
