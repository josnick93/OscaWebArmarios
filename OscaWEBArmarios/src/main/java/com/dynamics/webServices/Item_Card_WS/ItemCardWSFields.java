
package com.dynamics.webServices.Item_Card_WS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Item_Card_WS_Fields.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Item_Card_WS_Fields">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Description"/>
 *     &lt;enumeration value="Description_2"/>
 *     &lt;enumeration value="Blocked"/>
 *     &lt;enumeration value="Type"/>
 *     &lt;enumeration value="Base_Unit_of_Measure"/>
 *     &lt;enumeration value="Last_Date_Modified"/>
 *     &lt;enumeration value="GTIN"/>
 *     &lt;enumeration value="Item_Category_Code"/>
 *     &lt;enumeration value="Product_Group_Code"/>
 *     &lt;enumeration value="Service_Item_Group"/>
 *     &lt;enumeration value="Automatic_Ext_Texts"/>
 *     &lt;enumeration value="Overtolerance_Percentaje"/>
 *     &lt;enumeration value="Prototype"/>
 *     &lt;enumeration value="Has_A_Plane"/>
 *     &lt;enumeration value="No_of_Non_Conformities"/>
 *     &lt;enumeration value="Shelf_No"/>
 *     &lt;enumeration value="Created_From_Nonstock_Item"/>
 *     &lt;enumeration value="Search_Description"/>
 *     &lt;enumeration value="Inventory"/>
 *     &lt;enumeration value="Qty_on_Purch_Order"/>
 *     &lt;enumeration value="Qty_on_Prod_Order"/>
 *     &lt;enumeration value="Qty_on_Component_Lines"/>
 *     &lt;enumeration value="Qty_on_Sales_Order"/>
 *     &lt;enumeration value="Qty_on_Service_Order"/>
 *     &lt;enumeration value="Qty_on_Job_Order"/>
 *     &lt;enumeration value="Qty_on_Assembly_Order"/>
 *     &lt;enumeration value="Qty_on_Asm_Component"/>
 *     &lt;enumeration value="StockoutWarningDefaultYes"/>
 *     &lt;enumeration value="PreventNegInventoryDefaultYes"/>
 *     &lt;enumeration value="Net_Weight"/>
 *     &lt;enumeration value="Gross_Weight"/>
 *     &lt;enumeration value="Unit_Price"/>
 *     &lt;enumeration value="CalcUnitPriceExclVAT"/>
 *     &lt;enumeration value="Price_Includes_VAT"/>
 *     &lt;enumeration value="Price_Profit_Calculation"/>
 *     &lt;enumeration value="SpecialPricesAndDiscountsTxt"/>
 *     &lt;enumeration value="Profit_Percent"/>
 *     &lt;enumeration value="Unit_Cost"/>
 *     &lt;enumeration value="Overhead_Rate"/>
 *     &lt;enumeration value="Allow_Invoice_Disc"/>
 *     &lt;enumeration value="Item_Disc_Group"/>
 *     &lt;enumeration value="Costing_Method"/>
 *     &lt;enumeration value="Indirect_Cost_Percent"/>
 *     &lt;enumeration value="Last_Direct_Cost"/>
 *     &lt;enumeration value="Gen_Prod_Posting_Group"/>
 *     &lt;enumeration value="VAT_Prod_Posting_Group"/>
 *     &lt;enumeration value="Inventory_Posting_Group"/>
 *     &lt;enumeration value="Tariff_No"/>
 *     &lt;enumeration value="Country_Region_of_Origin_Code"/>
 *     &lt;enumeration value="Cost_is_Adjusted"/>
 *     &lt;enumeration value="Cost_is_Posted_to_G_L"/>
 *     &lt;enumeration value="Standard_Cost"/>
 *     &lt;enumeration value="Default_Deferral_Template_Code"/>
 *     &lt;enumeration value="Net_Invoiced_Qty"/>
 *     &lt;enumeration value="Sales_Unit_of_Measure"/>
 *     &lt;enumeration value="Application_Wksh_User_ID"/>
 *     &lt;enumeration value="Replenishment_System"/>
 *     &lt;enumeration value="Lead_Time_Calculation"/>
 *     &lt;enumeration value="Vendor_No"/>
 *     &lt;enumeration value="Vendor_Item_No"/>
 *     &lt;enumeration value="Purch_Unit_of_Measure"/>
 *     &lt;enumeration value="Manufacturing_Policy"/>
 *     &lt;enumeration value="Routing_No"/>
 *     &lt;enumeration value="Production_BOM_No"/>
 *     &lt;enumeration value="Rounding_Precision"/>
 *     &lt;enumeration value="Flushing_Method"/>
 *     &lt;enumeration value="Scrap_Percent"/>
 *     &lt;enumeration value="Lot_Size"/>
 *     &lt;enumeration value="Assembly_Policy"/>
 *     &lt;enumeration value="Assembly_BOM"/>
 *     &lt;enumeration value="Reordering_Policy"/>
 *     &lt;enumeration value="Reserve"/>
 *     &lt;enumeration value="Order_Tracking_Policy"/>
 *     &lt;enumeration value="Stockkeeping_Unit_Exists"/>
 *     &lt;enumeration value="Dampener_Period"/>
 *     &lt;enumeration value="Dampener_Quantity"/>
 *     &lt;enumeration value="Critical"/>
 *     &lt;enumeration value="Safety_Lead_Time"/>
 *     &lt;enumeration value="Safety_Stock_Quantity"/>
 *     &lt;enumeration value="Include_Inventory"/>
 *     &lt;enumeration value="Lot_Accumulation_Period"/>
 *     &lt;enumeration value="Rescheduling_Period"/>
 *     &lt;enumeration value="Reorder_Point"/>
 *     &lt;enumeration value="Reorder_Quantity"/>
 *     &lt;enumeration value="Maximum_Inventory"/>
 *     &lt;enumeration value="Overflow_Level"/>
 *     &lt;enumeration value="Time_Bucket"/>
 *     &lt;enumeration value="Minimum_Order_Quantity"/>
 *     &lt;enumeration value="Maximum_Order_Quantity"/>
 *     &lt;enumeration value="Order_Multiple"/>
 *     &lt;enumeration value="Item_Tracking_Code"/>
 *     &lt;enumeration value="Serial_Nos"/>
 *     &lt;enumeration value="Lot_Nos"/>
 *     &lt;enumeration value="Expiration_Calculation"/>
 *     &lt;enumeration value="Warehouse_Class_Code"/>
 *     &lt;enumeration value="Special_Equipment_Code"/>
 *     &lt;enumeration value="Put_away_Template_Code"/>
 *     &lt;enumeration value="Put_away_Unit_of_Measure_Code"/>
 *     &lt;enumeration value="Phys_Invt_Counting_Period_Code"/>
 *     &lt;enumeration value="Last_Phys_Invt_Date"/>
 *     &lt;enumeration value="Last_Counting_Period_Update"/>
 *     &lt;enumeration value="Next_Counting_Start_Date"/>
 *     &lt;enumeration value="Next_Counting_End_Date"/>
 *     &lt;enumeration value="Identifier_Code"/>
 *     &lt;enumeration value="Use_Cross_Docking"/>
 *     &lt;enumeration value="Diameter"/>
 *     &lt;enumeration value="Thickness"/>
 *     &lt;enumeration value="Lanzaderas"/>
 *     &lt;enumeration value="Total_Length"/>
 *     &lt;enumeration value="Marked"/>
 *     &lt;enumeration value="Machine"/>
 *     &lt;enumeration value="Bends_Number"/>
 *     &lt;enumeration value="Program"/>
 *     &lt;enumeration value="Plane"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Item_Card_WS_Fields")
@XmlEnum
public enum ItemCardWSFields {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Description")
    DESCRIPTION("Description"),
    @XmlEnumValue("Description_2")
    DESCRIPTION_2("Description_2"),
    @XmlEnumValue("Blocked")
    BLOCKED("Blocked"),
    @XmlEnumValue("Type")
    TYPE("Type"),
    @XmlEnumValue("Base_Unit_of_Measure")
    BASE_UNIT_OF_MEASURE("Base_Unit_of_Measure"),
    @XmlEnumValue("Last_Date_Modified")
    LAST_DATE_MODIFIED("Last_Date_Modified"),
    GTIN("GTIN"),
    @XmlEnumValue("Item_Category_Code")
    ITEM_CATEGORY_CODE("Item_Category_Code"),
    @XmlEnumValue("Product_Group_Code")
    PRODUCT_GROUP_CODE("Product_Group_Code"),
    @XmlEnumValue("Service_Item_Group")
    SERVICE_ITEM_GROUP("Service_Item_Group"),
    @XmlEnumValue("Automatic_Ext_Texts")
    AUTOMATIC_EXT_TEXTS("Automatic_Ext_Texts"),
    @XmlEnumValue("Overtolerance_Percentaje")
    OVERTOLERANCE_PERCENTAJE("Overtolerance_Percentaje"),
    @XmlEnumValue("Prototype")
    PROTOTYPE("Prototype"),
    @XmlEnumValue("Has_A_Plane")
    HAS_A_PLANE("Has_A_Plane"),
    @XmlEnumValue("No_of_Non_Conformities")
    NO_OF_NON_CONFORMITIES("No_of_Non_Conformities"),
    @XmlEnumValue("Shelf_No")
    SHELF_NO("Shelf_No"),
    @XmlEnumValue("Created_From_Nonstock_Item")
    CREATED_FROM_NONSTOCK_ITEM("Created_From_Nonstock_Item"),
    @XmlEnumValue("Search_Description")
    SEARCH_DESCRIPTION("Search_Description"),
    @XmlEnumValue("Inventory")
    INVENTORY("Inventory"),
    @XmlEnumValue("Qty_on_Purch_Order")
    QTY_ON_PURCH_ORDER("Qty_on_Purch_Order"),
    @XmlEnumValue("Qty_on_Prod_Order")
    QTY_ON_PROD_ORDER("Qty_on_Prod_Order"),
    @XmlEnumValue("Qty_on_Component_Lines")
    QTY_ON_COMPONENT_LINES("Qty_on_Component_Lines"),
    @XmlEnumValue("Qty_on_Sales_Order")
    QTY_ON_SALES_ORDER("Qty_on_Sales_Order"),
    @XmlEnumValue("Qty_on_Service_Order")
    QTY_ON_SERVICE_ORDER("Qty_on_Service_Order"),
    @XmlEnumValue("Qty_on_Job_Order")
    QTY_ON_JOB_ORDER("Qty_on_Job_Order"),
    @XmlEnumValue("Qty_on_Assembly_Order")
    QTY_ON_ASSEMBLY_ORDER("Qty_on_Assembly_Order"),
    @XmlEnumValue("Qty_on_Asm_Component")
    QTY_ON_ASM_COMPONENT("Qty_on_Asm_Component"),
    @XmlEnumValue("StockoutWarningDefaultYes")
    STOCKOUT_WARNING_DEFAULT_YES("StockoutWarningDefaultYes"),
    @XmlEnumValue("PreventNegInventoryDefaultYes")
    PREVENT_NEG_INVENTORY_DEFAULT_YES("PreventNegInventoryDefaultYes"),
    @XmlEnumValue("Net_Weight")
    NET_WEIGHT("Net_Weight"),
    @XmlEnumValue("Gross_Weight")
    GROSS_WEIGHT("Gross_Weight"),
    @XmlEnumValue("Unit_Price")
    UNIT_PRICE("Unit_Price"),
    @XmlEnumValue("CalcUnitPriceExclVAT")
    CALC_UNIT_PRICE_EXCL_VAT("CalcUnitPriceExclVAT"),
    @XmlEnumValue("Price_Includes_VAT")
    PRICE_INCLUDES_VAT("Price_Includes_VAT"),
    @XmlEnumValue("Price_Profit_Calculation")
    PRICE_PROFIT_CALCULATION("Price_Profit_Calculation"),
    @XmlEnumValue("SpecialPricesAndDiscountsTxt")
    SPECIAL_PRICES_AND_DISCOUNTS_TXT("SpecialPricesAndDiscountsTxt"),
    @XmlEnumValue("Profit_Percent")
    PROFIT_PERCENT("Profit_Percent"),
    @XmlEnumValue("Unit_Cost")
    UNIT_COST("Unit_Cost"),
    @XmlEnumValue("Overhead_Rate")
    OVERHEAD_RATE("Overhead_Rate"),
    @XmlEnumValue("Allow_Invoice_Disc")
    ALLOW_INVOICE_DISC("Allow_Invoice_Disc"),
    @XmlEnumValue("Item_Disc_Group")
    ITEM_DISC_GROUP("Item_Disc_Group"),
    @XmlEnumValue("Costing_Method")
    COSTING_METHOD("Costing_Method"),
    @XmlEnumValue("Indirect_Cost_Percent")
    INDIRECT_COST_PERCENT("Indirect_Cost_Percent"),
    @XmlEnumValue("Last_Direct_Cost")
    LAST_DIRECT_COST("Last_Direct_Cost"),
    @XmlEnumValue("Gen_Prod_Posting_Group")
    GEN_PROD_POSTING_GROUP("Gen_Prod_Posting_Group"),
    @XmlEnumValue("VAT_Prod_Posting_Group")
    VAT_PROD_POSTING_GROUP("VAT_Prod_Posting_Group"),
    @XmlEnumValue("Inventory_Posting_Group")
    INVENTORY_POSTING_GROUP("Inventory_Posting_Group"),
    @XmlEnumValue("Tariff_No")
    TARIFF_NO("Tariff_No"),
    @XmlEnumValue("Country_Region_of_Origin_Code")
    COUNTRY_REGION_OF_ORIGIN_CODE("Country_Region_of_Origin_Code"),
    @XmlEnumValue("Cost_is_Adjusted")
    COST_IS_ADJUSTED("Cost_is_Adjusted"),
    @XmlEnumValue("Cost_is_Posted_to_G_L")
    COST_IS_POSTED_TO_G_L("Cost_is_Posted_to_G_L"),
    @XmlEnumValue("Standard_Cost")
    STANDARD_COST("Standard_Cost"),
    @XmlEnumValue("Default_Deferral_Template_Code")
    DEFAULT_DEFERRAL_TEMPLATE_CODE("Default_Deferral_Template_Code"),
    @XmlEnumValue("Net_Invoiced_Qty")
    NET_INVOICED_QTY("Net_Invoiced_Qty"),
    @XmlEnumValue("Sales_Unit_of_Measure")
    SALES_UNIT_OF_MEASURE("Sales_Unit_of_Measure"),
    @XmlEnumValue("Application_Wksh_User_ID")
    APPLICATION_WKSH_USER_ID("Application_Wksh_User_ID"),
    @XmlEnumValue("Replenishment_System")
    REPLENISHMENT_SYSTEM("Replenishment_System"),
    @XmlEnumValue("Lead_Time_Calculation")
    LEAD_TIME_CALCULATION("Lead_Time_Calculation"),
    @XmlEnumValue("Vendor_No")
    VENDOR_NO("Vendor_No"),
    @XmlEnumValue("Vendor_Item_No")
    VENDOR_ITEM_NO("Vendor_Item_No"),
    @XmlEnumValue("Purch_Unit_of_Measure")
    PURCH_UNIT_OF_MEASURE("Purch_Unit_of_Measure"),
    @XmlEnumValue("Manufacturing_Policy")
    MANUFACTURING_POLICY("Manufacturing_Policy"),
    @XmlEnumValue("Routing_No")
    ROUTING_NO("Routing_No"),
    @XmlEnumValue("Production_BOM_No")
    PRODUCTION_BOM_NO("Production_BOM_No"),
    @XmlEnumValue("Rounding_Precision")
    ROUNDING_PRECISION("Rounding_Precision"),
    @XmlEnumValue("Flushing_Method")
    FLUSHING_METHOD("Flushing_Method"),
    @XmlEnumValue("Scrap_Percent")
    SCRAP_PERCENT("Scrap_Percent"),
    @XmlEnumValue("Lot_Size")
    LOT_SIZE("Lot_Size"),
    @XmlEnumValue("Assembly_Policy")
    ASSEMBLY_POLICY("Assembly_Policy"),
    @XmlEnumValue("Assembly_BOM")
    ASSEMBLY_BOM("Assembly_BOM"),
    @XmlEnumValue("Reordering_Policy")
    REORDERING_POLICY("Reordering_Policy"),
    @XmlEnumValue("Reserve")
    RESERVE("Reserve"),
    @XmlEnumValue("Order_Tracking_Policy")
    ORDER_TRACKING_POLICY("Order_Tracking_Policy"),
    @XmlEnumValue("Stockkeeping_Unit_Exists")
    STOCKKEEPING_UNIT_EXISTS("Stockkeeping_Unit_Exists"),
    @XmlEnumValue("Dampener_Period")
    DAMPENER_PERIOD("Dampener_Period"),
    @XmlEnumValue("Dampener_Quantity")
    DAMPENER_QUANTITY("Dampener_Quantity"),
    @XmlEnumValue("Critical")
    CRITICAL("Critical"),
    @XmlEnumValue("Safety_Lead_Time")
    SAFETY_LEAD_TIME("Safety_Lead_Time"),
    @XmlEnumValue("Safety_Stock_Quantity")
    SAFETY_STOCK_QUANTITY("Safety_Stock_Quantity"),
    @XmlEnumValue("Include_Inventory")
    INCLUDE_INVENTORY("Include_Inventory"),
    @XmlEnumValue("Lot_Accumulation_Period")
    LOT_ACCUMULATION_PERIOD("Lot_Accumulation_Period"),
    @XmlEnumValue("Rescheduling_Period")
    RESCHEDULING_PERIOD("Rescheduling_Period"),
    @XmlEnumValue("Reorder_Point")
    REORDER_POINT("Reorder_Point"),
    @XmlEnumValue("Reorder_Quantity")
    REORDER_QUANTITY("Reorder_Quantity"),
    @XmlEnumValue("Maximum_Inventory")
    MAXIMUM_INVENTORY("Maximum_Inventory"),
    @XmlEnumValue("Overflow_Level")
    OVERFLOW_LEVEL("Overflow_Level"),
    @XmlEnumValue("Time_Bucket")
    TIME_BUCKET("Time_Bucket"),
    @XmlEnumValue("Minimum_Order_Quantity")
    MINIMUM_ORDER_QUANTITY("Minimum_Order_Quantity"),
    @XmlEnumValue("Maximum_Order_Quantity")
    MAXIMUM_ORDER_QUANTITY("Maximum_Order_Quantity"),
    @XmlEnumValue("Order_Multiple")
    ORDER_MULTIPLE("Order_Multiple"),
    @XmlEnumValue("Item_Tracking_Code")
    ITEM_TRACKING_CODE("Item_Tracking_Code"),
    @XmlEnumValue("Serial_Nos")
    SERIAL_NOS("Serial_Nos"),
    @XmlEnumValue("Lot_Nos")
    LOT_NOS("Lot_Nos"),
    @XmlEnumValue("Expiration_Calculation")
    EXPIRATION_CALCULATION("Expiration_Calculation"),
    @XmlEnumValue("Warehouse_Class_Code")
    WAREHOUSE_CLASS_CODE("Warehouse_Class_Code"),
    @XmlEnumValue("Special_Equipment_Code")
    SPECIAL_EQUIPMENT_CODE("Special_Equipment_Code"),
    @XmlEnumValue("Put_away_Template_Code")
    PUT_AWAY_TEMPLATE_CODE("Put_away_Template_Code"),
    @XmlEnumValue("Put_away_Unit_of_Measure_Code")
    PUT_AWAY_UNIT_OF_MEASURE_CODE("Put_away_Unit_of_Measure_Code"),
    @XmlEnumValue("Phys_Invt_Counting_Period_Code")
    PHYS_INVT_COUNTING_PERIOD_CODE("Phys_Invt_Counting_Period_Code"),
    @XmlEnumValue("Last_Phys_Invt_Date")
    LAST_PHYS_INVT_DATE("Last_Phys_Invt_Date"),
    @XmlEnumValue("Last_Counting_Period_Update")
    LAST_COUNTING_PERIOD_UPDATE("Last_Counting_Period_Update"),
    @XmlEnumValue("Next_Counting_Start_Date")
    NEXT_COUNTING_START_DATE("Next_Counting_Start_Date"),
    @XmlEnumValue("Next_Counting_End_Date")
    NEXT_COUNTING_END_DATE("Next_Counting_End_Date"),
    @XmlEnumValue("Identifier_Code")
    IDENTIFIER_CODE("Identifier_Code"),
    @XmlEnumValue("Use_Cross_Docking")
    USE_CROSS_DOCKING("Use_Cross_Docking"),
    @XmlEnumValue("Diameter")
    DIAMETER("Diameter"),
    @XmlEnumValue("Thickness")
    THICKNESS("Thickness"),
    @XmlEnumValue("Lanzaderas")
    MATERIAL("Lanzaderas"),
    @XmlEnumValue("Total_Length")
    TOTAL_LENGTH("Total_Length"),
    @XmlEnumValue("Marked")
    MARKED("Marked"),
    @XmlEnumValue("Machine")
    MACHINE("Machine"),
    @XmlEnumValue("Bends_Number")
    BENDS_NUMBER("Bends_Number"),
    @XmlEnumValue("Program")
    PROGRAM("Program"),
    @XmlEnumValue("Plane")
    PLANE("Plane");
    private final String value;

    ItemCardWSFields(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ItemCardWSFields fromValue(String v) {
        for (ItemCardWSFields c: ItemCardWSFields.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
