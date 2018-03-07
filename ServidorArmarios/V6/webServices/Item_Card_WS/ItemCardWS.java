
package com.dynamics.webServices.Item_Card_WS;

import com.fasterxml.jackson.annotation.JsonView;
import org.oscasistemas.model.View;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;


/**
 * <p>Clase Java para Item_Card_WS complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Item_Card_WS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description_2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Blocked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Type" type="{urn:microsoft-dynamics-schemas/page/item_card_ws}Type" minOccurs="0"/>
 *         &lt;element name="Base_Unit_of_Measure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Last_Date_Modified" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="GTIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Item_Category_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Product_Group_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Service_Item_Group" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Automatic_Ext_Texts" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Overtolerance_Percentaje" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Prototype" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Has_A_Plane" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="No_of_Non_Conformities" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Shelf_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Created_From_Nonstock_Item" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Search_Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Inventory" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_on_Purch_Order" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_on_Prod_Order" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_on_Component_Lines" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_on_Sales_Order" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_on_Service_Order" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_on_Job_Order" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_on_Assembly_Order" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_on_Asm_Component" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="StockoutWarningDefaultYes" type="{urn:microsoft-dynamics-schemas/page/item_card_ws}StockoutWarningDefaultYes" minOccurs="0"/>
 *         &lt;element name="PreventNegInventoryDefaultYes" type="{urn:microsoft-dynamics-schemas/page/item_card_ws}PreventNegInventoryDefaultYes" minOccurs="0"/>
 *         &lt;element name="Net_Weight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Gross_Weight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Unit_Price" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CalcUnitPriceExclVAT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Price_Includes_VAT" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Price_Profit_Calculation" type="{urn:microsoft-dynamics-schemas/page/item_card_ws}Price_Profit_Calculation" minOccurs="0"/>
 *         &lt;element name="SpecialPricesAndDiscountsTxt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Profit_Percent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Unit_Cost" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Overhead_Rate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Allow_Invoice_Disc" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Item_Disc_Group" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Costing_Method" type="{urn:microsoft-dynamics-schemas/page/item_card_ws}Costing_Method" minOccurs="0"/>
 *         &lt;element name="Indirect_Cost_Percent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Last_Direct_Cost" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Gen_Prod_Posting_Group" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VAT_Prod_Posting_Group" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Inventory_Posting_Group" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tariff_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country_Region_of_Origin_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cost_is_Adjusted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Cost_is_Posted_to_G_L" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Standard_Cost" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Default_Deferral_Template_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Net_Invoiced_Qty" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Sales_Unit_of_Measure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Application_Wksh_User_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Replenishment_System" type="{urn:microsoft-dynamics-schemas/page/item_card_ws}Replenishment_System" minOccurs="0"/>
 *         &lt;element name="Lead_Time_Calculation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Vendor_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Vendor_Item_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Purch_Unit_of_Measure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Manufacturing_Policy" type="{urn:microsoft-dynamics-schemas/page/item_card_ws}Manufacturing_Policy" minOccurs="0"/>
 *         &lt;element name="Routing_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Production_BOM_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Rounding_Precision" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Flushing_Method" type="{urn:microsoft-dynamics-schemas/page/item_card_ws}Flushing_Method" minOccurs="0"/>
 *         &lt;element name="Scrap_Percent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Lot_Size" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Assembly_Policy" type="{urn:microsoft-dynamics-schemas/page/item_card_ws}Assembly_Policy" minOccurs="0"/>
 *         &lt;element name="Assembly_BOM" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Reordering_Policy" type="{urn:microsoft-dynamics-schemas/page/item_card_ws}Reordering_Policy" minOccurs="0"/>
 *         &lt;element name="Reserve" type="{urn:microsoft-dynamics-schemas/page/item_card_ws}Reserve" minOccurs="0"/>
 *         &lt;element name="Order_Tracking_Policy" type="{urn:microsoft-dynamics-schemas/page/item_card_ws}Order_Tracking_Policy" minOccurs="0"/>
 *         &lt;element name="Stockkeeping_Unit_Exists" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Dampener_Period" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Dampener_Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Critical" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Safety_Lead_Time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Safety_Stock_Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Include_Inventory" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Lot_Accumulation_Period" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Rescheduling_Period" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Reorder_Point" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Reorder_Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Maximum_Inventory" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Overflow_Level" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Time_Bucket" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Minimum_Order_Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Maximum_Order_Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Order_Multiple" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Item_Tracking_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Serial_Nos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Lot_Nos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Expiration_Calculation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Warehouse_Class_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Special_Equipment_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Put_away_Template_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Put_away_Unit_of_Measure_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Phys_Invt_Counting_Period_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Last_Phys_Invt_Date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Last_Counting_Period_Update" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Next_Counting_Start_Date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Next_Counting_End_Date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Identifier_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Use_Cross_Docking" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Diameter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Thickness" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Material" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Total_Length" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Marked" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Machine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bends_Number" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Program" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Plane" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Item_Card_WS", propOrder = {
    "key",
    "no",
    "description",
    "description2",
    "blocked",
    "type",
    "baseUnitOfMeasure",
    "lastDateModified",
    "gtin",
    "itemCategoryCode",
    "productGroupCode",
    "serviceItemGroup",
    "automaticExtTexts",
    "overtolerancePercentaje",
    "prototype",
    "hasAPlane",
    "noOfNonConformities",
    "shelfNo",
    "createdFromNonstockItem",
    "searchDescription",
    "inventory",
    "qtyOnPurchOrder",
    "qtyOnProdOrder",
    "qtyOnComponentLines",
    "qtyOnSalesOrder",
    "qtyOnServiceOrder",
    "qtyOnJobOrder",
    "qtyOnAssemblyOrder",
    "qtyOnAsmComponent",
    "stockoutWarningDefaultYes",
    "preventNegInventoryDefaultYes",
    "netWeight",
    "grossWeight",
    "unitPrice",
    "calcUnitPriceExclVAT",
    "priceIncludesVAT",
    "priceProfitCalculation",
    "specialPricesAndDiscountsTxt",
    "profitPercent",
    "unitCost",
    "overheadRate",
    "allowInvoiceDisc",
    "itemDiscGroup",
    "costingMethod",
    "indirectCostPercent",
    "lastDirectCost",
    "genProdPostingGroup",
    "vatProdPostingGroup",
    "inventoryPostingGroup",
    "tariffNo",
    "countryRegionOfOriginCode",
    "costIsAdjusted",
    "costIsPostedToGL",
    "standardCost",
    "defaultDeferralTemplateCode",
    "netInvoicedQty",
    "salesUnitOfMeasure",
    "applicationWkshUserID",
    "replenishmentSystem",
    "leadTimeCalculation",
    "vendorNo",
    "vendorItemNo",
    "purchUnitOfMeasure",
    "manufacturingPolicy",
    "routingNo",
    "productionBOMNo",
    "roundingPrecision",
    "flushingMethod",
    "scrapPercent",
    "lotSize",
    "assemblyPolicy",
    "assemblyBOM",
    "reorderingPolicy",
    "reserve",
    "orderTrackingPolicy",
    "stockkeepingUnitExists",
    "dampenerPeriod",
    "dampenerQuantity",
    "critical",
    "safetyLeadTime",
    "safetyStockQuantity",
    "includeInventory",
    "lotAccumulationPeriod",
    "reschedulingPeriod",
    "reorderPoint",
    "reorderQuantity",
    "maximumInventory",
    "overflowLevel",
    "timeBucket",
    "minimumOrderQuantity",
    "maximumOrderQuantity",
    "orderMultiple",
    "itemTrackingCode",
    "serialNos",
    "lotNos",
    "expirationCalculation",
    "warehouseClassCode",
    "specialEquipmentCode",
    "putAwayTemplateCode",
    "putAwayUnitOfMeasureCode",
    "physInvtCountingPeriodCode",
    "lastPhysInvtDate",
    "lastCountingPeriodUpdate",
    "nextCountingStartDate",
    "nextCountingEndDate",
    "identifierCode",
    "useCrossDocking",
    "diameter",
    "thickness",
    "material",
    "totalLength",
    "marked",
    "machine",
    "bendsNumber",
    "program",
    "plane"
})
public class ItemCardWS {

    @JsonView(View.Summary.class)
    @XmlElement(name = "Key")
    protected String key;
 @JsonView(View.Summary.class)
    @XmlElement(name = "No")
    protected String no;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Description")
    protected String description;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Description_2")
    protected String description2;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Blocked")
    protected Boolean blocked;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Type")
    @XmlSchemaType(name = "string")
    protected Type type;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Base_Unit_of_Measure")
    protected String baseUnitOfMeasure;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Last_Date_Modified")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar lastDateModified;
 @JsonView(View.Summary.class)
    @XmlElement(name = "GTIN")
    protected String gtin;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Item_Category_Code")
    protected String itemCategoryCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Product_Group_Code")
    protected String productGroupCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Service_Item_Group")
    protected String serviceItemGroup;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Automatic_Ext_Texts")
    protected Boolean automaticExtTexts;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Overtolerance_Percentaje")
    protected BigInteger overtolerancePercentaje;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Prototype")
    protected Boolean prototype;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Has_A_Plane")
    protected Boolean hasAPlane;
 @JsonView(View.Summary.class)
    @XmlElement(name = "No_of_Non_Conformities")
    protected Integer noOfNonConformities;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Shelf_No")
    protected String shelfNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Created_From_Nonstock_Item")
    protected Boolean createdFromNonstockItem;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Search_Description")
    protected String searchDescription;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Inventory")
    protected BigInteger inventory;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Qty_on_Purch_Order")
    protected BigInteger qtyOnPurchOrder;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Qty_on_Prod_Order")
    protected BigInteger qtyOnProdOrder;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Qty_on_Component_Lines")
    protected BigInteger qtyOnComponentLines;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Qty_on_Sales_Order")
    protected BigInteger qtyOnSalesOrder;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Qty_on_Service_Order")
    protected BigInteger qtyOnServiceOrder;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Qty_on_Job_Order")
    protected BigInteger qtyOnJobOrder;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Qty_on_Assembly_Order")
    protected BigInteger qtyOnAssemblyOrder;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Qty_on_Asm_Component")
    protected BigInteger qtyOnAsmComponent;
 @JsonView(View.Summary.class)
    @XmlElement(name = "StockoutWarningDefaultYes")
    @XmlSchemaType(name = "string")
    protected StockoutWarningDefaultYes stockoutWarningDefaultYes;
 @JsonView(View.Summary.class)
    @XmlElement(name = "PreventNegInventoryDefaultYes")
    @XmlSchemaType(name = "string")
    protected PreventNegInventoryDefaultYes preventNegInventoryDefaultYes;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Net_Weight")
    protected BigInteger netWeight;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Gross_Weight")
    protected BigInteger grossWeight;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Unit_Price")
    protected BigInteger unitPrice;
 @JsonView(View.Summary.class)
    @XmlElement(name = "CalcUnitPriceExclVAT")
    protected BigInteger calcUnitPriceExclVAT;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Price_Includes_VAT")
    protected Boolean priceIncludesVAT;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Price_Profit_Calculation")
    @XmlSchemaType(name = "string")
    protected PriceProfitCalculation priceProfitCalculation;
 @JsonView(View.Summary.class)
    @XmlElement(name = "SpecialPricesAndDiscountsTxt")
    protected String specialPricesAndDiscountsTxt;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Profit_Percent")
    protected BigInteger profitPercent;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Unit_Cost")
    protected BigInteger unitCost;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Overhead_Rate")
    protected BigInteger overheadRate;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Allow_Invoice_Disc")
    protected Boolean allowInvoiceDisc;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Item_Disc_Group")
    protected String itemDiscGroup;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Costing_Method")
    @XmlSchemaType(name = "string")
    protected CostingMethod costingMethod;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Indirect_Cost_Percent")
    protected BigInteger indirectCostPercent;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Last_Direct_Cost")
    protected BigInteger lastDirectCost;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Gen_Prod_Posting_Group")
    protected String genProdPostingGroup;
 @JsonView(View.Summary.class)
    @XmlElement(name = "VAT_Prod_Posting_Group")
    protected String vatProdPostingGroup;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Inventory_Posting_Group")
    protected String inventoryPostingGroup;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Tariff_No")
    protected String tariffNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Country_Region_of_Origin_Code")
    protected String countryRegionOfOriginCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Cost_is_Adjusted")
    protected Boolean costIsAdjusted;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Cost_is_Posted_to_G_L")
    protected Boolean costIsPostedToGL;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Standard_Cost")
    protected BigInteger standardCost;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Default_Deferral_Template_Code")
    protected String defaultDeferralTemplateCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Net_Invoiced_Qty")
    protected BigInteger netInvoicedQty;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Sales_Unit_of_Measure")
    protected String salesUnitOfMeasure;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Application_Wksh_User_ID")
    protected String applicationWkshUserID;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Replenishment_System")
    @XmlSchemaType(name = "string")
    protected ReplenishmentSystem replenishmentSystem;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Lead_Time_Calculation")
    protected String leadTimeCalculation;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Vendor_No")
    protected String vendorNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Vendor_Item_No")
    protected String vendorItemNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Purch_Unit_of_Measure")
    protected String purchUnitOfMeasure;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Manufacturing_Policy")
    @XmlSchemaType(name = "string")
    protected ManufacturingPolicy manufacturingPolicy;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Routing_No")
    protected String routingNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Production_BOM_No")
    protected String productionBOMNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Rounding_Precision")
    protected BigInteger roundingPrecision;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Flushing_Method")
    @XmlSchemaType(name = "string")
    protected FlushingMethod flushingMethod;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Scrap_Percent")
    protected BigInteger scrapPercent;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Lot_Size")
    protected BigInteger lotSize;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Assembly_Policy")
    @XmlSchemaType(name = "string")
    protected AssemblyPolicy assemblyPolicy;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Assembly_BOM")
    protected Boolean assemblyBOM;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Reordering_Policy")
    @XmlSchemaType(name = "string")
    protected ReorderingPolicy reorderingPolicy;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Reserve")
    @XmlSchemaType(name = "string")
    protected Reserve reserve;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Order_Tracking_Policy")
    @XmlSchemaType(name = "string")
    protected OrderTrackingPolicy orderTrackingPolicy;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Stockkeeping_Unit_Exists")
    protected Boolean stockkeepingUnitExists;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Dampener_Period")
    protected String dampenerPeriod;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Dampener_Quantity")
    protected BigInteger dampenerQuantity;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Critical")
    protected Boolean critical;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Safety_Lead_Time")
    protected String safetyLeadTime;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Safety_Stock_Quantity")
    protected BigInteger safetyStockQuantity;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Include_Inventory")
    protected Boolean includeInventory;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Lot_Accumulation_Period")
    protected String lotAccumulationPeriod;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Rescheduling_Period")
    protected String reschedulingPeriod;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Reorder_Point")
    protected BigInteger reorderPoint;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Reorder_Quantity")
    protected BigInteger reorderQuantity;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Maximum_Inventory")
    protected BigInteger maximumInventory;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Overflow_Level")
    protected BigInteger overflowLevel;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Time_Bucket")
    protected String timeBucket;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Minimum_Order_Quantity")
    protected BigInteger minimumOrderQuantity;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Maximum_Order_Quantity")
    protected BigInteger maximumOrderQuantity;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Order_Multiple")
    protected BigInteger orderMultiple;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Item_Tracking_Code")
    protected String itemTrackingCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Serial_Nos")
    protected String serialNos;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Lot_Nos")
    protected String lotNos;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Expiration_Calculation")
    protected String expirationCalculation;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Warehouse_Class_Code")
    protected String warehouseClassCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Special_Equipment_Code")
    protected String specialEquipmentCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Put_away_Template_Code")
    protected String putAwayTemplateCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Put_away_Unit_of_Measure_Code")
    protected String putAwayUnitOfMeasureCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Phys_Invt_Counting_Period_Code")
    protected String physInvtCountingPeriodCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Last_Phys_Invt_Date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar lastPhysInvtDate;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Last_Counting_Period_Update")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar lastCountingPeriodUpdate;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Next_Counting_Start_Date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar nextCountingStartDate;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Next_Counting_End_Date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar nextCountingEndDate;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Identifier_Code")
    protected String identifierCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Use_Cross_Docking")
    protected Boolean useCrossDocking;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Diameter")
    protected String diameter;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Thickness")
    protected String thickness;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Material")
    protected String material;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Total_Length")
    protected BigInteger totalLength;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Marked")
    protected String marked;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Machine")
    protected String machine;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Bends_Number")
    protected Integer bendsNumber;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Program")
    protected String program;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Plane")
    protected String plane;

    /**
     * Obtiene el valor de la propiedad key.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Define el valor de la propiedad key.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Obtiene el valor de la propiedad no.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNo() {
        return no;
    }

    /**
     * Define el valor de la propiedad no.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNo(String value) {
        this.no = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad description2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription2() {
        return description2;
    }

    /**
     * Define el valor de la propiedad description2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription2(String value) {
        this.description2 = value;
    }

    /**
     * Obtiene el valor de la propiedad blocked.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBlocked() {
        return blocked;
    }

    /**
     * Define el valor de la propiedad blocked.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBlocked(Boolean value) {
        this.blocked = value;
    }

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link Type }
     *     
     */
    public Type getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link Type }
     *     
     */
    public void setType(Type value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad baseUnitOfMeasure.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseUnitOfMeasure() {
        return baseUnitOfMeasure;
    }

    /**
     * Define el valor de la propiedad baseUnitOfMeasure.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseUnitOfMeasure(String value) {
        this.baseUnitOfMeasure = value;
    }

    /**
     * Obtiene el valor de la propiedad lastDateModified.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastDateModified() {
        return lastDateModified;
    }

    /**
     * Define el valor de la propiedad lastDateModified.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastDateModified(XMLGregorianCalendar value) {
        this.lastDateModified = value;
    }

    /**
     * Obtiene el valor de la propiedad gtin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGTIN() {
        return gtin;
    }

    /**
     * Define el valor de la propiedad gtin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGTIN(String value) {
        this.gtin = value;
    }

    /**
     * Obtiene el valor de la propiedad itemCategoryCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemCategoryCode() {
        return itemCategoryCode;
    }

    /**
     * Define el valor de la propiedad itemCategoryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemCategoryCode(String value) {
        this.itemCategoryCode = value;
    }

    /**
     * Obtiene el valor de la propiedad productGroupCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductGroupCode() {
        return productGroupCode;
    }

    /**
     * Define el valor de la propiedad productGroupCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductGroupCode(String value) {
        this.productGroupCode = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceItemGroup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceItemGroup() {
        return serviceItemGroup;
    }

    /**
     * Define el valor de la propiedad serviceItemGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceItemGroup(String value) {
        this.serviceItemGroup = value;
    }

    /**
     * Obtiene el valor de la propiedad automaticExtTexts.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutomaticExtTexts() {
        return automaticExtTexts;
    }

    /**
     * Define el valor de la propiedad automaticExtTexts.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutomaticExtTexts(Boolean value) {
        this.automaticExtTexts = value;
    }

    /**
     * Obtiene el valor de la propiedad overtolerancePercentaje.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOvertolerancePercentaje() {
        return overtolerancePercentaje;
    }

    /**
     * Define el valor de la propiedad overtolerancePercentaje.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOvertolerancePercentaje(BigInteger value) {
        this.overtolerancePercentaje = value;
    }

    /**
     * Obtiene el valor de la propiedad prototype.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPrototype() {
        return prototype;
    }

    /**
     * Define el valor de la propiedad prototype.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPrototype(Boolean value) {
        this.prototype = value;
    }

    /**
     * Obtiene el valor de la propiedad hasAPlane.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasAPlane() {
        return hasAPlane;
    }

    /**
     * Define el valor de la propiedad hasAPlane.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasAPlane(Boolean value) {
        this.hasAPlane = value;
    }

    /**
     * Obtiene el valor de la propiedad noOfNonConformities.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNoOfNonConformities() {
        return noOfNonConformities;
    }

    /**
     * Define el valor de la propiedad noOfNonConformities.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNoOfNonConformities(Integer value) {
        this.noOfNonConformities = value;
    }

    /**
     * Obtiene el valor de la propiedad shelfNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShelfNo() {
        return shelfNo;
    }

    /**
     * Define el valor de la propiedad shelfNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShelfNo(String value) {
        this.shelfNo = value;
    }

    /**
     * Obtiene el valor de la propiedad createdFromNonstockItem.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCreatedFromNonstockItem() {
        return createdFromNonstockItem;
    }

    /**
     * Define el valor de la propiedad createdFromNonstockItem.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCreatedFromNonstockItem(Boolean value) {
        this.createdFromNonstockItem = value;
    }

    /**
     * Obtiene el valor de la propiedad searchDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchDescription() {
        return searchDescription;
    }

    /**
     * Define el valor de la propiedad searchDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchDescription(String value) {
        this.searchDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad inventory.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getInventory() {
        return inventory;
    }

    /**
     * Define el valor de la propiedad inventory.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setInventory(BigInteger value) {
        this.inventory = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyOnPurchOrder.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyOnPurchOrder() {
        return qtyOnPurchOrder;
    }

    /**
     * Define el valor de la propiedad qtyOnPurchOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyOnPurchOrder(BigInteger value) {
        this.qtyOnPurchOrder = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyOnProdOrder.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyOnProdOrder() {
        return qtyOnProdOrder;
    }

    /**
     * Define el valor de la propiedad qtyOnProdOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyOnProdOrder(BigInteger value) {
        this.qtyOnProdOrder = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyOnComponentLines.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyOnComponentLines() {
        return qtyOnComponentLines;
    }

    /**
     * Define el valor de la propiedad qtyOnComponentLines.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyOnComponentLines(BigInteger value) {
        this.qtyOnComponentLines = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyOnSalesOrder.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyOnSalesOrder() {
        return qtyOnSalesOrder;
    }

    /**
     * Define el valor de la propiedad qtyOnSalesOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyOnSalesOrder(BigInteger value) {
        this.qtyOnSalesOrder = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyOnServiceOrder.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyOnServiceOrder() {
        return qtyOnServiceOrder;
    }

    /**
     * Define el valor de la propiedad qtyOnServiceOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyOnServiceOrder(BigInteger value) {
        this.qtyOnServiceOrder = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyOnJobOrder.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyOnJobOrder() {
        return qtyOnJobOrder;
    }

    /**
     * Define el valor de la propiedad qtyOnJobOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyOnJobOrder(BigInteger value) {
        this.qtyOnJobOrder = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyOnAssemblyOrder.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyOnAssemblyOrder() {
        return qtyOnAssemblyOrder;
    }

    /**
     * Define el valor de la propiedad qtyOnAssemblyOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyOnAssemblyOrder(BigInteger value) {
        this.qtyOnAssemblyOrder = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyOnAsmComponent.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyOnAsmComponent() {
        return qtyOnAsmComponent;
    }

    /**
     * Define el valor de la propiedad qtyOnAsmComponent.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyOnAsmComponent(BigInteger value) {
        this.qtyOnAsmComponent = value;
    }

    /**
     * Obtiene el valor de la propiedad stockoutWarningDefaultYes.
     * 
     * @return
     *     possible object is
     *     {@link StockoutWarningDefaultYes }
     *     
     */
    public StockoutWarningDefaultYes getStockoutWarningDefaultYes() {
        return stockoutWarningDefaultYes;
    }

    /**
     * Define el valor de la propiedad stockoutWarningDefaultYes.
     * 
     * @param value
     *     allowed object is
     *     {@link StockoutWarningDefaultYes }
     *     
     */
    public void setStockoutWarningDefaultYes(StockoutWarningDefaultYes value) {
        this.stockoutWarningDefaultYes = value;
    }

    /**
     * Obtiene el valor de la propiedad preventNegInventoryDefaultYes.
     * 
     * @return
     *     possible object is
     *     {@link PreventNegInventoryDefaultYes }
     *     
     */
    public PreventNegInventoryDefaultYes getPreventNegInventoryDefaultYes() {
        return preventNegInventoryDefaultYes;
    }

    /**
     * Define el valor de la propiedad preventNegInventoryDefaultYes.
     * 
     * @param value
     *     allowed object is
     *     {@link PreventNegInventoryDefaultYes }
     *     
     */
    public void setPreventNegInventoryDefaultYes(PreventNegInventoryDefaultYes value) {
        this.preventNegInventoryDefaultYes = value;
    }

    /**
     * Obtiene el valor de la propiedad netWeight.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNetWeight() {
        return netWeight;
    }

    /**
     * Define el valor de la propiedad netWeight.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNetWeight(BigInteger value) {
        this.netWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad grossWeight.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGrossWeight() {
        return grossWeight;
    }

    /**
     * Define el valor de la propiedad grossWeight.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGrossWeight(BigInteger value) {
        this.grossWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad unitPrice.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUnitPrice() {
        return unitPrice;
    }

    /**
     * Define el valor de la propiedad unitPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUnitPrice(BigInteger value) {
        this.unitPrice = value;
    }

    /**
     * Obtiene el valor de la propiedad calcUnitPriceExclVAT.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCalcUnitPriceExclVAT() {
        return calcUnitPriceExclVAT;
    }

    /**
     * Define el valor de la propiedad calcUnitPriceExclVAT.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCalcUnitPriceExclVAT(BigInteger value) {
        this.calcUnitPriceExclVAT = value;
    }

    /**
     * Obtiene el valor de la propiedad priceIncludesVAT.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPriceIncludesVAT() {
        return priceIncludesVAT;
    }

    /**
     * Define el valor de la propiedad priceIncludesVAT.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPriceIncludesVAT(Boolean value) {
        this.priceIncludesVAT = value;
    }

    /**
     * Obtiene el valor de la propiedad priceProfitCalculation.
     * 
     * @return
     *     possible object is
     *     {@link PriceProfitCalculation }
     *     
     */
    public PriceProfitCalculation getPriceProfitCalculation() {
        return priceProfitCalculation;
    }

    /**
     * Define el valor de la propiedad priceProfitCalculation.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceProfitCalculation }
     *     
     */
    public void setPriceProfitCalculation(PriceProfitCalculation value) {
        this.priceProfitCalculation = value;
    }

    /**
     * Obtiene el valor de la propiedad specialPricesAndDiscountsTxt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialPricesAndDiscountsTxt() {
        return specialPricesAndDiscountsTxt;
    }

    /**
     * Define el valor de la propiedad specialPricesAndDiscountsTxt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialPricesAndDiscountsTxt(String value) {
        this.specialPricesAndDiscountsTxt = value;
    }

    /**
     * Obtiene el valor de la propiedad profitPercent.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getProfitPercent() {
        return profitPercent;
    }

    /**
     * Define el valor de la propiedad profitPercent.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setProfitPercent(BigInteger value) {
        this.profitPercent = value;
    }

    /**
     * Obtiene el valor de la propiedad unitCost.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUnitCost() {
        return unitCost;
    }

    /**
     * Define el valor de la propiedad unitCost.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUnitCost(BigInteger value) {
        this.unitCost = value;
    }

    /**
     * Obtiene el valor de la propiedad overheadRate.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOverheadRate() {
        return overheadRate;
    }

    /**
     * Define el valor de la propiedad overheadRate.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOverheadRate(BigInteger value) {
        this.overheadRate = value;
    }

    /**
     * Obtiene el valor de la propiedad allowInvoiceDisc.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowInvoiceDisc() {
        return allowInvoiceDisc;
    }

    /**
     * Define el valor de la propiedad allowInvoiceDisc.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowInvoiceDisc(Boolean value) {
        this.allowInvoiceDisc = value;
    }

    /**
     * Obtiene el valor de la propiedad itemDiscGroup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemDiscGroup() {
        return itemDiscGroup;
    }

    /**
     * Define el valor de la propiedad itemDiscGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemDiscGroup(String value) {
        this.itemDiscGroup = value;
    }

    /**
     * Obtiene el valor de la propiedad costingMethod.
     * 
     * @return
     *     possible object is
     *     {@link CostingMethod }
     *     
     */
    public CostingMethod getCostingMethod() {
        return costingMethod;
    }

    /**
     * Define el valor de la propiedad costingMethod.
     * 
     * @param value
     *     allowed object is
     *     {@link CostingMethod }
     *     
     */
    public void setCostingMethod(CostingMethod value) {
        this.costingMethod = value;
    }

    /**
     * Obtiene el valor de la propiedad indirectCostPercent.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIndirectCostPercent() {
        return indirectCostPercent;
    }

    /**
     * Define el valor de la propiedad indirectCostPercent.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIndirectCostPercent(BigInteger value) {
        this.indirectCostPercent = value;
    }

    /**
     * Obtiene el valor de la propiedad lastDirectCost.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLastDirectCost() {
        return lastDirectCost;
    }

    /**
     * Define el valor de la propiedad lastDirectCost.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLastDirectCost(BigInteger value) {
        this.lastDirectCost = value;
    }

    /**
     * Obtiene el valor de la propiedad genProdPostingGroup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenProdPostingGroup() {
        return genProdPostingGroup;
    }

    /**
     * Define el valor de la propiedad genProdPostingGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenProdPostingGroup(String value) {
        this.genProdPostingGroup = value;
    }

    /**
     * Obtiene el valor de la propiedad vatProdPostingGroup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVATProdPostingGroup() {
        return vatProdPostingGroup;
    }

    /**
     * Define el valor de la propiedad vatProdPostingGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVATProdPostingGroup(String value) {
        this.vatProdPostingGroup = value;
    }

    /**
     * Obtiene el valor de la propiedad inventoryPostingGroup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInventoryPostingGroup() {
        return inventoryPostingGroup;
    }

    /**
     * Define el valor de la propiedad inventoryPostingGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInventoryPostingGroup(String value) {
        this.inventoryPostingGroup = value;
    }

    /**
     * Obtiene el valor de la propiedad tariffNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTariffNo() {
        return tariffNo;
    }

    /**
     * Define el valor de la propiedad tariffNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTariffNo(String value) {
        this.tariffNo = value;
    }

    /**
     * Obtiene el valor de la propiedad countryRegionOfOriginCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryRegionOfOriginCode() {
        return countryRegionOfOriginCode;
    }

    /**
     * Define el valor de la propiedad countryRegionOfOriginCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryRegionOfOriginCode(String value) {
        this.countryRegionOfOriginCode = value;
    }

    /**
     * Obtiene el valor de la propiedad costIsAdjusted.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCostIsAdjusted() {
        return costIsAdjusted;
    }

    /**
     * Define el valor de la propiedad costIsAdjusted.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCostIsAdjusted(Boolean value) {
        this.costIsAdjusted = value;
    }

    /**
     * Obtiene el valor de la propiedad costIsPostedToGL.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCostIsPostedToGL() {
        return costIsPostedToGL;
    }

    /**
     * Define el valor de la propiedad costIsPostedToGL.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCostIsPostedToGL(Boolean value) {
        this.costIsPostedToGL = value;
    }

    /**
     * Obtiene el valor de la propiedad standardCost.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStandardCost() {
        return standardCost;
    }

    /**
     * Define el valor de la propiedad standardCost.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStandardCost(BigInteger value) {
        this.standardCost = value;
    }

    /**
     * Obtiene el valor de la propiedad defaultDeferralTemplateCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultDeferralTemplateCode() {
        return defaultDeferralTemplateCode;
    }

    /**
     * Define el valor de la propiedad defaultDeferralTemplateCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultDeferralTemplateCode(String value) {
        this.defaultDeferralTemplateCode = value;
    }

    /**
     * Obtiene el valor de la propiedad netInvoicedQty.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNetInvoicedQty() {
        return netInvoicedQty;
    }

    /**
     * Define el valor de la propiedad netInvoicedQty.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNetInvoicedQty(BigInteger value) {
        this.netInvoicedQty = value;
    }

    /**
     * Obtiene el valor de la propiedad salesUnitOfMeasure.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalesUnitOfMeasure() {
        return salesUnitOfMeasure;
    }

    /**
     * Define el valor de la propiedad salesUnitOfMeasure.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalesUnitOfMeasure(String value) {
        this.salesUnitOfMeasure = value;
    }

    /**
     * Obtiene el valor de la propiedad applicationWkshUserID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationWkshUserID() {
        return applicationWkshUserID;
    }

    /**
     * Define el valor de la propiedad applicationWkshUserID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationWkshUserID(String value) {
        this.applicationWkshUserID = value;
    }

    /**
     * Obtiene el valor de la propiedad replenishmentSystem.
     * 
     * @return
     *     possible object is
     *     {@link ReplenishmentSystem }
     *     
     */
    public ReplenishmentSystem getReplenishmentSystem() {
        return replenishmentSystem;
    }

    /**
     * Define el valor de la propiedad replenishmentSystem.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplenishmentSystem }
     *     
     */
    public void setReplenishmentSystem(ReplenishmentSystem value) {
        this.replenishmentSystem = value;
    }

    /**
     * Obtiene el valor de la propiedad leadTimeCalculation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeadTimeCalculation() {
        return leadTimeCalculation;
    }

    /**
     * Define el valor de la propiedad leadTimeCalculation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeadTimeCalculation(String value) {
        this.leadTimeCalculation = value;
    }

    /**
     * Obtiene el valor de la propiedad vendorNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendorNo() {
        return vendorNo;
    }

    /**
     * Define el valor de la propiedad vendorNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendorNo(String value) {
        this.vendorNo = value;
    }

    /**
     * Obtiene el valor de la propiedad vendorItemNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendorItemNo() {
        return vendorItemNo;
    }

    /**
     * Define el valor de la propiedad vendorItemNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendorItemNo(String value) {
        this.vendorItemNo = value;
    }

    /**
     * Obtiene el valor de la propiedad purchUnitOfMeasure.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchUnitOfMeasure() {
        return purchUnitOfMeasure;
    }

    /**
     * Define el valor de la propiedad purchUnitOfMeasure.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchUnitOfMeasure(String value) {
        this.purchUnitOfMeasure = value;
    }

    /**
     * Obtiene el valor de la propiedad manufacturingPolicy.
     * 
     * @return
     *     possible object is
     *     {@link ManufacturingPolicy }
     *     
     */
    public ManufacturingPolicy getManufacturingPolicy() {
        return manufacturingPolicy;
    }

    /**
     * Define el valor de la propiedad manufacturingPolicy.
     * 
     * @param value
     *     allowed object is
     *     {@link ManufacturingPolicy }
     *     
     */
    public void setManufacturingPolicy(ManufacturingPolicy value) {
        this.manufacturingPolicy = value;
    }

    /**
     * Obtiene el valor de la propiedad routingNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoutingNo() {
        return routingNo;
    }

    /**
     * Define el valor de la propiedad routingNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoutingNo(String value) {
        this.routingNo = value;
    }

    /**
     * Obtiene el valor de la propiedad productionBOMNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductionBOMNo() {
        return productionBOMNo;
    }

    /**
     * Define el valor de la propiedad productionBOMNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductionBOMNo(String value) {
        this.productionBOMNo = value;
    }

    /**
     * Obtiene el valor de la propiedad roundingPrecision.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRoundingPrecision() {
        return roundingPrecision;
    }

    /**
     * Define el valor de la propiedad roundingPrecision.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRoundingPrecision(BigInteger value) {
        this.roundingPrecision = value;
    }

    /**
     * Obtiene el valor de la propiedad flushingMethod.
     * 
     * @return
     *     possible object is
     *     {@link FlushingMethod }
     *     
     */
    public FlushingMethod getFlushingMethod() {
        return flushingMethod;
    }

    /**
     * Define el valor de la propiedad flushingMethod.
     * 
     * @param value
     *     allowed object is
     *     {@link FlushingMethod }
     *     
     */
    public void setFlushingMethod(FlushingMethod value) {
        this.flushingMethod = value;
    }

    /**
     * Obtiene el valor de la propiedad scrapPercent.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getScrapPercent() {
        return scrapPercent;
    }

    /**
     * Define el valor de la propiedad scrapPercent.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setScrapPercent(BigInteger value) {
        this.scrapPercent = value;
    }

    /**
     * Obtiene el valor de la propiedad lotSize.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLotSize() {
        return lotSize;
    }

    /**
     * Define el valor de la propiedad lotSize.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLotSize(BigInteger value) {
        this.lotSize = value;
    }

    /**
     * Obtiene el valor de la propiedad assemblyPolicy.
     * 
     * @return
     *     possible object is
     *     {@link AssemblyPolicy }
     *     
     */
    public AssemblyPolicy getAssemblyPolicy() {
        return assemblyPolicy;
    }

    /**
     * Define el valor de la propiedad assemblyPolicy.
     * 
     * @param value
     *     allowed object is
     *     {@link AssemblyPolicy }
     *     
     */
    public void setAssemblyPolicy(AssemblyPolicy value) {
        this.assemblyPolicy = value;
    }

    /**
     * Obtiene el valor de la propiedad assemblyBOM.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAssemblyBOM() {
        return assemblyBOM;
    }

    /**
     * Define el valor de la propiedad assemblyBOM.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAssemblyBOM(Boolean value) {
        this.assemblyBOM = value;
    }

    /**
     * Obtiene el valor de la propiedad reorderingPolicy.
     * 
     * @return
     *     possible object is
     *     {@link ReorderingPolicy }
     *     
     */
    public ReorderingPolicy getReorderingPolicy() {
        return reorderingPolicy;
    }

    /**
     * Define el valor de la propiedad reorderingPolicy.
     * 
     * @param value
     *     allowed object is
     *     {@link ReorderingPolicy }
     *     
     */
    public void setReorderingPolicy(ReorderingPolicy value) {
        this.reorderingPolicy = value;
    }

    /**
     * Obtiene el valor de la propiedad reserve.
     * 
     * @return
     *     possible object is
     *     {@link Reserve }
     *     
     */
    public Reserve getReserve() {
        return reserve;
    }

    /**
     * Define el valor de la propiedad reserve.
     * 
     * @param value
     *     allowed object is
     *     {@link Reserve }
     *     
     */
    public void setReserve(Reserve value) {
        this.reserve = value;
    }

    /**
     * Obtiene el valor de la propiedad orderTrackingPolicy.
     * 
     * @return
     *     possible object is
     *     {@link OrderTrackingPolicy }
     *     
     */
    public OrderTrackingPolicy getOrderTrackingPolicy() {
        return orderTrackingPolicy;
    }

    /**
     * Define el valor de la propiedad orderTrackingPolicy.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderTrackingPolicy }
     *     
     */
    public void setOrderTrackingPolicy(OrderTrackingPolicy value) {
        this.orderTrackingPolicy = value;
    }

    /**
     * Obtiene el valor de la propiedad stockkeepingUnitExists.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStockkeepingUnitExists() {
        return stockkeepingUnitExists;
    }

    /**
     * Define el valor de la propiedad stockkeepingUnitExists.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStockkeepingUnitExists(Boolean value) {
        this.stockkeepingUnitExists = value;
    }

    /**
     * Obtiene el valor de la propiedad dampenerPeriod.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDampenerPeriod() {
        return dampenerPeriod;
    }

    /**
     * Define el valor de la propiedad dampenerPeriod.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDampenerPeriod(String value) {
        this.dampenerPeriod = value;
    }

    /**
     * Obtiene el valor de la propiedad dampenerQuantity.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDampenerQuantity() {
        return dampenerQuantity;
    }

    /**
     * Define el valor de la propiedad dampenerQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDampenerQuantity(BigInteger value) {
        this.dampenerQuantity = value;
    }

    /**
     * Obtiene el valor de la propiedad critical.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCritical() {
        return critical;
    }

    /**
     * Define el valor de la propiedad critical.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCritical(Boolean value) {
        this.critical = value;
    }

    /**
     * Obtiene el valor de la propiedad safetyLeadTime.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSafetyLeadTime() {
        return safetyLeadTime;
    }

    /**
     * Define el valor de la propiedad safetyLeadTime.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSafetyLeadTime(String value) {
        this.safetyLeadTime = value;
    }

    /**
     * Obtiene el valor de la propiedad safetyStockQuantity.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSafetyStockQuantity() {
        return safetyStockQuantity;
    }

    /**
     * Define el valor de la propiedad safetyStockQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSafetyStockQuantity(BigInteger value) {
        this.safetyStockQuantity = value;
    }

    /**
     * Obtiene el valor de la propiedad includeInventory.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeInventory() {
        return includeInventory;
    }

    /**
     * Define el valor de la propiedad includeInventory.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeInventory(Boolean value) {
        this.includeInventory = value;
    }

    /**
     * Obtiene el valor de la propiedad lotAccumulationPeriod.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLotAccumulationPeriod() {
        return lotAccumulationPeriod;
    }

    /**
     * Define el valor de la propiedad lotAccumulationPeriod.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLotAccumulationPeriod(String value) {
        this.lotAccumulationPeriod = value;
    }

    /**
     * Obtiene el valor de la propiedad reschedulingPeriod.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReschedulingPeriod() {
        return reschedulingPeriod;
    }

    /**
     * Define el valor de la propiedad reschedulingPeriod.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReschedulingPeriod(String value) {
        this.reschedulingPeriod = value;
    }

    /**
     * Obtiene el valor de la propiedad reorderPoint.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getReorderPoint() {
        return reorderPoint;
    }

    /**
     * Define el valor de la propiedad reorderPoint.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setReorderPoint(BigInteger value) {
        this.reorderPoint = value;
    }

    /**
     * Obtiene el valor de la propiedad reorderQuantity.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getReorderQuantity() {
        return reorderQuantity;
    }

    /**
     * Define el valor de la propiedad reorderQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setReorderQuantity(BigInteger value) {
        this.reorderQuantity = value;
    }

    /**
     * Obtiene el valor de la propiedad maximumInventory.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaximumInventory() {
        return maximumInventory;
    }

    /**
     * Define el valor de la propiedad maximumInventory.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaximumInventory(BigInteger value) {
        this.maximumInventory = value;
    }

    /**
     * Obtiene el valor de la propiedad overflowLevel.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOverflowLevel() {
        return overflowLevel;
    }

    /**
     * Define el valor de la propiedad overflowLevel.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOverflowLevel(BigInteger value) {
        this.overflowLevel = value;
    }

    /**
     * Obtiene el valor de la propiedad timeBucket.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeBucket() {
        return timeBucket;
    }

    /**
     * Define el valor de la propiedad timeBucket.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeBucket(String value) {
        this.timeBucket = value;
    }

    /**
     * Obtiene el valor de la propiedad minimumOrderQuantity.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinimumOrderQuantity() {
        return minimumOrderQuantity;
    }

    /**
     * Define el valor de la propiedad minimumOrderQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMinimumOrderQuantity(BigInteger value) {
        this.minimumOrderQuantity = value;
    }

    /**
     * Obtiene el valor de la propiedad maximumOrderQuantity.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaximumOrderQuantity() {
        return maximumOrderQuantity;
    }

    /**
     * Define el valor de la propiedad maximumOrderQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaximumOrderQuantity(BigInteger value) {
        this.maximumOrderQuantity = value;
    }

    /**
     * Obtiene el valor de la propiedad orderMultiple.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrderMultiple() {
        return orderMultiple;
    }

    /**
     * Define el valor de la propiedad orderMultiple.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOrderMultiple(BigInteger value) {
        this.orderMultiple = value;
    }

    /**
     * Obtiene el valor de la propiedad itemTrackingCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemTrackingCode() {
        return itemTrackingCode;
    }

    /**
     * Define el valor de la propiedad itemTrackingCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemTrackingCode(String value) {
        this.itemTrackingCode = value;
    }

    /**
     * Obtiene el valor de la propiedad serialNos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialNos() {
        return serialNos;
    }

    /**
     * Define el valor de la propiedad serialNos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialNos(String value) {
        this.serialNos = value;
    }

    /**
     * Obtiene el valor de la propiedad lotNos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLotNos() {
        return lotNos;
    }

    /**
     * Define el valor de la propiedad lotNos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLotNos(String value) {
        this.lotNos = value;
    }

    /**
     * Obtiene el valor de la propiedad expirationCalculation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpirationCalculation() {
        return expirationCalculation;
    }

    /**
     * Define el valor de la propiedad expirationCalculation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpirationCalculation(String value) {
        this.expirationCalculation = value;
    }

    /**
     * Obtiene el valor de la propiedad warehouseClassCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWarehouseClassCode() {
        return warehouseClassCode;
    }

    /**
     * Define el valor de la propiedad warehouseClassCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWarehouseClassCode(String value) {
        this.warehouseClassCode = value;
    }

    /**
     * Obtiene el valor de la propiedad specialEquipmentCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialEquipmentCode() {
        return specialEquipmentCode;
    }

    /**
     * Define el valor de la propiedad specialEquipmentCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialEquipmentCode(String value) {
        this.specialEquipmentCode = value;
    }

    /**
     * Obtiene el valor de la propiedad putAwayTemplateCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPutAwayTemplateCode() {
        return putAwayTemplateCode;
    }

    /**
     * Define el valor de la propiedad putAwayTemplateCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPutAwayTemplateCode(String value) {
        this.putAwayTemplateCode = value;
    }

    /**
     * Obtiene el valor de la propiedad putAwayUnitOfMeasureCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPutAwayUnitOfMeasureCode() {
        return putAwayUnitOfMeasureCode;
    }

    /**
     * Define el valor de la propiedad putAwayUnitOfMeasureCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPutAwayUnitOfMeasureCode(String value) {
        this.putAwayUnitOfMeasureCode = value;
    }

    /**
     * Obtiene el valor de la propiedad physInvtCountingPeriodCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhysInvtCountingPeriodCode() {
        return physInvtCountingPeriodCode;
    }

    /**
     * Define el valor de la propiedad physInvtCountingPeriodCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhysInvtCountingPeriodCode(String value) {
        this.physInvtCountingPeriodCode = value;
    }

    /**
     * Obtiene el valor de la propiedad lastPhysInvtDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastPhysInvtDate() {
        return lastPhysInvtDate;
    }

    /**
     * Define el valor de la propiedad lastPhysInvtDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastPhysInvtDate(XMLGregorianCalendar value) {
        this.lastPhysInvtDate = value;
    }

    /**
     * Obtiene el valor de la propiedad lastCountingPeriodUpdate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastCountingPeriodUpdate() {
        return lastCountingPeriodUpdate;
    }

    /**
     * Define el valor de la propiedad lastCountingPeriodUpdate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastCountingPeriodUpdate(XMLGregorianCalendar value) {
        this.lastCountingPeriodUpdate = value;
    }

    /**
     * Obtiene el valor de la propiedad nextCountingStartDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNextCountingStartDate() {
        return nextCountingStartDate;
    }

    /**
     * Define el valor de la propiedad nextCountingStartDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNextCountingStartDate(XMLGregorianCalendar value) {
        this.nextCountingStartDate = value;
    }

    /**
     * Obtiene el valor de la propiedad nextCountingEndDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNextCountingEndDate() {
        return nextCountingEndDate;
    }

    /**
     * Define el valor de la propiedad nextCountingEndDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNextCountingEndDate(XMLGregorianCalendar value) {
        this.nextCountingEndDate = value;
    }

    /**
     * Obtiene el valor de la propiedad identifierCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifierCode() {
        return identifierCode;
    }

    /**
     * Define el valor de la propiedad identifierCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifierCode(String value) {
        this.identifierCode = value;
    }

    /**
     * Obtiene el valor de la propiedad useCrossDocking.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseCrossDocking() {
        return useCrossDocking;
    }

    /**
     * Define el valor de la propiedad useCrossDocking.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseCrossDocking(Boolean value) {
        this.useCrossDocking = value;
    }

    /**
     * Obtiene el valor de la propiedad diameter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiameter() {
        return diameter;
    }

    /**
     * Define el valor de la propiedad diameter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiameter(String value) {
        this.diameter = value;
    }

    /**
     * Obtiene el valor de la propiedad thickness.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThickness() {
        return thickness;
    }

    /**
     * Define el valor de la propiedad thickness.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThickness(String value) {
        this.thickness = value;
    }

    /**
     * Obtiene el valor de la propiedad material.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Define el valor de la propiedad material.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterial(String value) {
        this.material = value;
    }

    /**
     * Obtiene el valor de la propiedad totalLength.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalLength() {
        return totalLength;
    }

    /**
     * Define el valor de la propiedad totalLength.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalLength(BigInteger value) {
        this.totalLength = value;
    }

    /**
     * Obtiene el valor de la propiedad marked.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarked() {
        return marked;
    }

    /**
     * Define el valor de la propiedad marked.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarked(String value) {
        this.marked = value;
    }

    /**
     * Obtiene el valor de la propiedad machine.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMachine() {
        return machine;
    }

    /**
     * Define el valor de la propiedad machine.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMachine(String value) {
        this.machine = value;
    }

    /**
     * Obtiene el valor de la propiedad bendsNumber.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBendsNumber() {
        return bendsNumber;
    }

    /**
     * Define el valor de la propiedad bendsNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBendsNumber(Integer value) {
        this.bendsNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad program.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgram() {
        return program;
    }

    /**
     * Define el valor de la propiedad program.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgram(String value) {
        this.program = value;
    }

    /**
     * Obtiene el valor de la propiedad plane.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlane() {
        return plane;
    }

    /**
     * Define el valor de la propiedad plane.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlane(String value) {
        this.plane = value;
    }

}
