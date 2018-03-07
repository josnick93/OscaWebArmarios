package org.oscasistemas.XMLParser;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by José Ángel Caudevilla Casaus  on 18/09/2017.
 */
@XmlRootElement
public class Item_Card {


    //atributos
//atributos
    private String Key;
    private String No;
    private String Description ;
    private boolean Blocked;
    private String Type;
    private String Base_Unit_of_Measure ;
    private Date Last_Date_Modified;
    private String GTIN ;
    private String Item_Category_Code ;
    private String Product_Group_Code ;
    private String Service_Item_Group ;
    private String Automatic_Ext_Texts;
    private double Overtolerance_Percentaje;
    private boolean Prototype;
    private boolean Has_A_Plane;
    private String Shelf_No ;
    private boolean Created_From_Nonstock_Item;
    private String Search_Description ;
    private double Inventory;
    private double Qty_on_Purch_Order ;
    private double Qty_on_Prod_Order ;
    private double Qty_on_Component_Lines ;
    private double Qty_on_Sales_Order ;
    private double Qty_on_Service_Order ;
    private double Qty_on_Job_Order ;
    private double  Qty_on_Assembly_Order ;
    private double  Qty_on_Asm_Component ;
    private String  StockoutWarningDefaultYes;
    private String PreventNegInventoryDefaultYes ;
    private double Net_Weight ;
    private double  Gross_Weight ;
    private double  Unit_Price ;
    private double CalcUnitPriceExclVAT ;
    private boolean Price_Includes_VAT;
    private String Price_Profit_Calculation ;
    private String SpecialPricesAndDiscountsTxt ;
    private double  Profit_Percent ;
    private double Unit_Cost ;
    private double Overhead_Rate ;
    private boolean Allow_Invoice_Disc;
    private String Item_Disc_Group ;
    private String Costing_Method ;
    private double Indirect_Cost_Percent ;
    private double  Last_Direct_Cost ;
    private String Gen_Prod_Posting_Group ;
    private String VAT_Prod_Posting_Group ;
    private String Inventory_Posting_Group ;
    private String Tariff_No ;
    private String Country_Region_of_Origin_Code ;
    private String Cost_is_Adjusted ;
    private String Cost_is_Posted_to_G_L ;
    private double Standard_Cost ;
    private String Default_Deferral_Template_Code ;
    private double Net_Invoiced_Qty ;
    private String Sales_Unit_of_Measure ;
    private String  Application_Wksh_User_ID ;
    private String Replenishment_System ;
    private String Lead_Time_Calculation ;
    private String  Vendor_No ;
    private String Vendor_Item_No ;
    private String Purch_Unit_of_Measure ;
    private String Manufacturing_Policy ;
    private String  Routing_No ;
    private String Production_BOM_No ;
    private double Rounding_Precision;
    private String Flushing_Method ;
    private double Scrap_Percent;
    private double Lot_Size;
    private String Assembly_Policy;
    private boolean  Assembly_BOM;
    private String  Reordering_Policy;
    private String  Reserve;
    private String Order_Tracking_Policy;
    private boolean Stockkeeping_Unit_Exists;
    private String  Dampener_Period ;
    private double Dampener_Quantity ;
    private String Critical;
    private String Safety_Lead_Time ;
    private String Safety_Stock_Quantity ;
    private String Include_Inventory;
    private String Lot_Accumulation_Period ;
    private String Rescheduling_Period ;
    private double Reorder_Point ;
    private double Reorder_Quantity ;
    private double Maximum_Inventory ;
    private double Overflow_Level ;
    private String Time_Bucket ;
    private double  Minimum_Order_Quantity ;
    private double Maximum_Order_Quantity ;
    private double Order_Multiple ;
    private String  Item_Tracking_Code ;
    private String Serial_Nos ;
    private String Lot_Nos ;
    private String  Expiration_Calculation ;
    private String  Warehouse_Class_Code ;
    private String Special_Equipment_Code ;
    private String Put_away_Template_Code ;
    private String Put_away_Unit_of_Measure_Code ;
    private String Phys_Invt_Counting_Period_Code ;
    private Date Last_Phys_Invt_Date ;
    private Date Last_Counting_Period_Update ;
    private Date Next_Counting_Start_Date ;
    private Date Next_Counting_End_Date ;
    private String  Identifier_Code ;
    private String Use_Cross_Docking;
    private double  Diameter ;
    private double Thickness ;
    private String Material ;
    private double Edge_Length;
    private String  Marked ;
    private String Machine ;
    private int  Bends_Number;
    private String  Program ;
    private String  Plane ;


    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isBlocked() {
        return Blocked;
    }

    public void setBlocked(boolean blocked) {
        Blocked = blocked;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getBase_Unit_of_Measure() {
        return Base_Unit_of_Measure;
    }

    public void setBase_Unit_of_Measure(String base_Unit_of_Measure) {
        Base_Unit_of_Measure = base_Unit_of_Measure;
    }

    public Date getLast_Date_Modified() {
        return Last_Date_Modified;
    }

    public void setLast_Date_Modified(Date last_Date_Modified) {
        Last_Date_Modified = last_Date_Modified;
    }

    public String getGTIN() {
        return GTIN;
    }

    public void setGTIN(String GTIN) {
        this.GTIN = GTIN;
    }

    public String getItem_Category_Code() {
        return Item_Category_Code;
    }

    public void setItem_Category_Code(String item_Category_Code) {
        Item_Category_Code = item_Category_Code;
    }

    public String getProduct_Group_Code() {
        return Product_Group_Code;
    }


    public void setProduct_Group_Code(String product_Group_Code) {
        Product_Group_Code = product_Group_Code;
    }

    public String getService_Item_Group() {
        return Service_Item_Group;
    }

    public void setService_Item_Group(String service_Item_Group) {
        Service_Item_Group = service_Item_Group;
    }

    public String getAutomatic_Ext_Texts() {
        return Automatic_Ext_Texts;
    }

    public void setAutomatic_Ext_Texts(String automatic_Ext_Texts) {
        Automatic_Ext_Texts = automatic_Ext_Texts;
    }

    public double getOvertolerance_Percentaje() {
        return Overtolerance_Percentaje;
    }

    public void setOvertolerance_Percentaje(double overtolerance_Percentaje) {
        Overtolerance_Percentaje = overtolerance_Percentaje;
    }

    public boolean isPrototype() {
        return Prototype;
    }

    public void setPrototype(boolean prototype) {
        Prototype = prototype;
    }

    public boolean isHas_A_Plane() {
        return Has_A_Plane;
    }

    public void setHas_A_Plane(boolean has_A_Plane) {
        Has_A_Plane = has_A_Plane;
    }

    public String getShelf_No() {
        return Shelf_No;
    }

    public void setShelf_No(String shelf_No) {
        Shelf_No = shelf_No;
    }

    public boolean isCreated_From_Nonstock_Item() {
        return Created_From_Nonstock_Item;
    }

    public void setCreated_From_Nonstock_Item(boolean created_From_Nonstock_Item) {
        Created_From_Nonstock_Item = created_From_Nonstock_Item;
    }

    public String getSearch_Description() {
        return Search_Description;
    }

    public void setSearch_Description(String search_Description) {
        Search_Description = search_Description;
    }

    public double getInventory() {
        return Inventory;
    }

    public void setInventory(double inventory) {
        Inventory = inventory;
    }

    public double getQty_on_Purch_Order() {
        return Qty_on_Purch_Order;
    }

    public void setQty_on_Purch_Order(double qty_on_Purch_Order) {
        Qty_on_Purch_Order = qty_on_Purch_Order;
    }

    public double getQty_on_Prod_Order() {
        return Qty_on_Prod_Order;
    }

    public void setQty_on_Prod_Order(double qty_on_Prod_Order) {
        Qty_on_Prod_Order = qty_on_Prod_Order;
    }

    public double getQty_on_Component_Lines() {
        return Qty_on_Component_Lines;
    }

    public void setQty_on_Component_Lines(double qty_on_Component_Lines) {
        Qty_on_Component_Lines = qty_on_Component_Lines;
    }

    public double getQty_on_Sales_Order() {
        return Qty_on_Sales_Order;
    }

    public void setQty_on_Sales_Order(double qty_on_Sales_Order) {
        Qty_on_Sales_Order = qty_on_Sales_Order;
    }

    public double getQty_on_Service_Order() {
        return Qty_on_Service_Order;
    }

    public void setQty_on_Service_Order(double qty_on_Service_Order) {
        Qty_on_Service_Order = qty_on_Service_Order;
    }

    public double getQty_on_Job_Order() {
        return Qty_on_Job_Order;
    }

    public void setQty_on_Job_Order(double qty_on_Job_Order) {
        Qty_on_Job_Order = qty_on_Job_Order;
    }

    public double getQty_on_Assembly_Order() {
        return Qty_on_Assembly_Order;
    }

    public void setQty_on_Assembly_Order(double qty_on_Assembly_Order) {
        Qty_on_Assembly_Order = qty_on_Assembly_Order;
    }

    public double getQty_on_Asm_Component() {
        return Qty_on_Asm_Component;
    }

    public void setQty_on_Asm_Component(double qty_on_Asm_Component) {
        Qty_on_Asm_Component = qty_on_Asm_Component;
    }

    public String getStockoutWarningDefaultYes() {
        return StockoutWarningDefaultYes;
    }

    public void setStockoutWarningDefaultYes(String stockoutWarningDefaultYes) {
        StockoutWarningDefaultYes = stockoutWarningDefaultYes;
    }

    public String getPreventNegInventoryDefaultYes() {
        return PreventNegInventoryDefaultYes;
    }

    public void setPreventNegInventoryDefaultYes(String preventNegInventoryDefaultYes) {
        PreventNegInventoryDefaultYes = preventNegInventoryDefaultYes;
    }

    public double getNet_Weight() {
        return Net_Weight;
    }

    public void setNet_Weight(double net_Weight) {
        Net_Weight = net_Weight;
    }

    public double getGross_Weight() {
        return Gross_Weight;
    }

    public void setGross_Weight(double gross_Weight) {
        Gross_Weight = gross_Weight;
    }

    public double getUnit_Price() {
        return Unit_Price;
    }

    public void setUnit_Price(double unit_Price) {
        Unit_Price = unit_Price;
    }

    public double getCalcUnitPriceExclVAT() {
        return CalcUnitPriceExclVAT;
    }

    public void setCalcUnitPriceExclVAT(double calcUnitPriceExclVAT) {
        CalcUnitPriceExclVAT = calcUnitPriceExclVAT;
    }

    public boolean isPrice_Includes_VAT() {
        return Price_Includes_VAT;
    }

    public void setPrice_Includes_VAT(boolean price_Includes_VAT) {
        Price_Includes_VAT = price_Includes_VAT;
    }

    public String getPrice_Profit_Calculation() {
        return Price_Profit_Calculation;
    }

    public void setPrice_Profit_Calculation(String price_Profit_Calculation) {
        Price_Profit_Calculation = price_Profit_Calculation;
    }

    public String getSpecialPricesAndDiscountsTxt() {
        return SpecialPricesAndDiscountsTxt;
    }

    public void setSpecialPricesAndDiscountsTxt(String specialPricesAndDiscountsTxt) {
        SpecialPricesAndDiscountsTxt = specialPricesAndDiscountsTxt;
    }

    public double getProfit_Percent() {
        return Profit_Percent;
    }

    public void setProfit_Percent(double profit_Percent) {
        Profit_Percent = profit_Percent;
    }

    public double getUnit_Cost() {
        return Unit_Cost;
    }

    public void setUnit_Cost(double unit_Cost) {
        Unit_Cost = unit_Cost;
    }

    public double getOverhead_Rate() {
        return Overhead_Rate;
    }

    public void setOverhead_Rate(double overhead_Rate) {
        Overhead_Rate = overhead_Rate;
    }

    public boolean isAllow_Invoice_Disc() {
        return Allow_Invoice_Disc;
    }

    public void setAllow_Invoice_Disc(boolean allow_Invoice_Disc) {
        Allow_Invoice_Disc = allow_Invoice_Disc;
    }

    public String getItem_Disc_Group() {
        return Item_Disc_Group;
    }

    public void setItem_Disc_Group(String item_Disc_Group) {
        Item_Disc_Group = item_Disc_Group;
    }

    public String getCosting_Method() {
        return Costing_Method;
    }

    public void setCosting_Method(String costing_Method) {
        Costing_Method = costing_Method;
    }

    public double getIndirect_Cost_Percent() {
        return Indirect_Cost_Percent;
    }

    public void setIndirect_Cost_Percent(double indirect_Cost_Percent) {
        Indirect_Cost_Percent = indirect_Cost_Percent;
    }

    public double getLast_Direct_Cost() {
        return Last_Direct_Cost;
    }

    public void setLast_Direct_Cost(double last_Direct_Cost) {
        Last_Direct_Cost = last_Direct_Cost;
    }

    public String getGen_Prod_Posting_Group() {
        return Gen_Prod_Posting_Group;
    }

    public void setGen_Prod_Posting_Group(String gen_Prod_Posting_Group) {
        Gen_Prod_Posting_Group = gen_Prod_Posting_Group;
    }

    public String getVAT_Prod_Posting_Group() {
        return VAT_Prod_Posting_Group;
    }

    public void setVAT_Prod_Posting_Group(String VAT_Prod_Posting_Group) {
        this.VAT_Prod_Posting_Group = VAT_Prod_Posting_Group;
    }

    public String getInventory_Posting_Group() {
        return Inventory_Posting_Group;
    }

    public void setInventory_Posting_Group(String inventory_Posting_Group) {
        Inventory_Posting_Group = inventory_Posting_Group;
    }

    public String getTariff_No() {
        return Tariff_No;
    }

    public void setTariff_No(String tariff_No) {
        Tariff_No = tariff_No;
    }

    public String getCountry_Region_of_Origin_Code() {
        return Country_Region_of_Origin_Code;
    }

    public void setCountry_Region_of_Origin_Code(String country_Region_of_Origin_Code) {
        Country_Region_of_Origin_Code = country_Region_of_Origin_Code;
    }

    public String getCost_is_Adjusted() {
        return Cost_is_Adjusted;
    }

    public void setCost_is_Adjusted(String cost_is_Adjusted) {
        Cost_is_Adjusted = cost_is_Adjusted;
    }

    public String getCost_is_Posted_to_G_L() {
        return Cost_is_Posted_to_G_L;
    }

    public void setCost_is_Posted_to_G_L(String cost_is_Posted_to_G_L) {
        Cost_is_Posted_to_G_L = cost_is_Posted_to_G_L;
    }

    public double getStandard_Cost() {
        return Standard_Cost;
    }

    public void setStandard_Cost(double standard_Cost) {
        Standard_Cost = standard_Cost;
    }

    public String getDefault_Deferral_Template_Code() {
        return Default_Deferral_Template_Code;
    }

    public void setDefault_Deferral_Template_Code(String default_Deferral_Template_Code) {
        Default_Deferral_Template_Code = default_Deferral_Template_Code;
    }

    public double getNet_Invoiced_Qty() {
        return Net_Invoiced_Qty;
    }

    public void setNet_Invoiced_Qty(double net_Invoiced_Qty) {
        Net_Invoiced_Qty = net_Invoiced_Qty;
    }

    public String getSales_Unit_of_Measure() {
        return Sales_Unit_of_Measure;
    }

    public void setSales_Unit_of_Measure(String sales_Unit_of_Measure) {
        Sales_Unit_of_Measure = sales_Unit_of_Measure;
    }

    public String getApplication_Wksh_User_ID() {
        return Application_Wksh_User_ID;
    }

    public void setApplication_Wksh_User_ID(String application_Wksh_User_ID) {
        Application_Wksh_User_ID = application_Wksh_User_ID;
    }

    public String getReplenishment_System() {
        return Replenishment_System;
    }

    public void setReplenishment_System(String replenishment_System) {
        Replenishment_System = replenishment_System;
    }

    public String getLead_Time_Calculation() {
        return Lead_Time_Calculation;
    }

    public void setLead_Time_Calculation(String lead_Time_Calculation) {
        Lead_Time_Calculation = lead_Time_Calculation;
    }

    public String getVendor_No() {
        return Vendor_No;
    }

    public void setVendor_No(String vendor_No) {
        Vendor_No = vendor_No;
    }

    public String getVendor_Item_No() {
        return Vendor_Item_No;
    }

    public void setVendor_Item_No(String vendor_Item_No) {
        Vendor_Item_No = vendor_Item_No;
    }

    public String getPurch_Unit_of_Measure() {
        return Purch_Unit_of_Measure;
    }

    public void setPurch_Unit_of_Measure(String purch_Unit_of_Measure) {
        Purch_Unit_of_Measure = purch_Unit_of_Measure;
    }

    public String getManufacturing_Policy() {
        return Manufacturing_Policy;
    }

    public void setManufacturing_Policy(String manufacturing_Policy) {
        Manufacturing_Policy = manufacturing_Policy;
    }

    public String getRouting_No() {
        return Routing_No;
    }

    public void setRouting_No(String routing_No) {
        Routing_No = routing_No;
    }

    public String getProduction_BOM_No() {
        return Production_BOM_No;
    }

    public void setProduction_BOM_No(String production_BOM_No) {
        Production_BOM_No = production_BOM_No;
    }

    public double getRounding_Precision() {
        return Rounding_Precision;
    }

    public void setRounding_Precision(double rounding_Precision) {
        Rounding_Precision = rounding_Precision;
    }

    public String getFlushing_Method() {
        return Flushing_Method;
    }

    public void setFlushing_Method(String flushing_Method) {
        Flushing_Method = flushing_Method;
    }

    public double getScrap_Percent() {
        return Scrap_Percent;
    }

    public void setScrap_Percent(double scrap_Percent) {
        Scrap_Percent = scrap_Percent;
    }

    public double getLot_Size() {
        return Lot_Size;
    }

    public void setLot_Size(double lot_Size) {
        Lot_Size = lot_Size;
    }

    public String getAssembly_Policy() {
        return Assembly_Policy;
    }

    public void setAssembly_Policy(String assembly_Policy) {
        Assembly_Policy = assembly_Policy;
    }

    public boolean isAssembly_BOM() {
        return Assembly_BOM;
    }

    public void setAssembly_BOM(boolean assembly_BOM) {
        Assembly_BOM = assembly_BOM;
    }

    public String getReordering_Policy() {
        return Reordering_Policy;
    }

    public void setReordering_Policy(String reordering_Policy) {
        Reordering_Policy = reordering_Policy;
    }

    public String getReserve() {
        return Reserve;
    }

    public void setReserve(String reserve) {
        Reserve = reserve;
    }

    public String getOrder_Tracking_Policy() {
        return Order_Tracking_Policy;
    }

    public void setOrder_Tracking_Policy(String order_Tracking_Policy) {
        Order_Tracking_Policy = order_Tracking_Policy;
    }

    public boolean isStockkeeping_Unit_Exists() {
        return Stockkeeping_Unit_Exists;
    }

    public void setStockkeeping_Unit_Exists(boolean stockkeeping_Unit_Exists) {
        Stockkeeping_Unit_Exists = stockkeeping_Unit_Exists;
    }

    public String getDampener_Period() {
        return Dampener_Period;
    }

    public void setDampener_Period(String dampener_Period) {
        Dampener_Period = dampener_Period;
    }

    public double getDampener_Quantity() {
        return Dampener_Quantity;
    }

    public void setDampener_Quantity(double dampener_Quantity) {
        Dampener_Quantity = dampener_Quantity;
    }

    public String getCritical() {
        return Critical;
    }

    public void setCritical(String critical) {
        Critical = critical;
    }

    public String getSafety_Lead_Time() {
        return Safety_Lead_Time;
    }

    public void setSafety_Lead_Time(String safety_Lead_Time) {
        Safety_Lead_Time = safety_Lead_Time;
    }

    public String getSafety_Stock_Quantity() {
        return Safety_Stock_Quantity;
    }

    public void setSafety_Stock_Quantity(String safety_Stock_Quantity) {
        Safety_Stock_Quantity = safety_Stock_Quantity;
    }

    public String getInclude_Inventory() {
        return Include_Inventory;
    }

    public void setInclude_Inventory(String include_Inventory) {
        Include_Inventory = include_Inventory;
    }

    public String getLot_Accumulation_Period() {
        return Lot_Accumulation_Period;
    }

    public void setLot_Accumulation_Period(String lot_Accumulation_Period) {
        Lot_Accumulation_Period = lot_Accumulation_Period;
    }

    public String getRescheduling_Period() {
        return Rescheduling_Period;
    }

    public void setRescheduling_Period(String rescheduling_Period) {
        Rescheduling_Period = rescheduling_Period;
    }

    public double getReorder_Point() {
        return Reorder_Point;
    }

    public void setReorder_Point(double reorder_Point) {
        Reorder_Point = reorder_Point;
    }

    public double getReorder_Quantity() {
        return Reorder_Quantity;
    }

    public void setReorder_Quantity(double reorder_Quantity) {
        Reorder_Quantity = reorder_Quantity;
    }

    public double getMaximum_Inventory() {
        return Maximum_Inventory;
    }

    public void setMaximum_Inventory(double maximum_Inventory) {
        Maximum_Inventory = maximum_Inventory;
    }

    public double getOverflow_Level() {
        return Overflow_Level;
    }

    public void setOverflow_Level(double overflow_Level) {
        Overflow_Level = overflow_Level;
    }

    public String getTime_Bucket() {
        return Time_Bucket;
    }

    public void setTime_Bucket(String time_Bucket) {
        Time_Bucket = time_Bucket;
    }

    public double getMinimum_Order_Quantity() {
        return Minimum_Order_Quantity;
    }

    public void setMinimum_Order_Quantity(double minimum_Order_Quantity) {
        Minimum_Order_Quantity = minimum_Order_Quantity;
    }

    public double getMaximum_Order_Quantity() {
        return Maximum_Order_Quantity;
    }

    public void setMaximum_Order_Quantity(double maximum_Order_Quantity) {
        Maximum_Order_Quantity = maximum_Order_Quantity;
    }

    public double getOrder_Multiple() {
        return Order_Multiple;
    }

    public void setOrder_Multiple(double order_Multiple) {
        Order_Multiple = order_Multiple;
    }

    public String getItem_Tracking_Code() {
        return Item_Tracking_Code;
    }

    public void setItem_Tracking_Code(String item_Tracking_Code) {
        Item_Tracking_Code = item_Tracking_Code;
    }

    public String getSerial_Nos() {
        return Serial_Nos;
    }

    public void setSerial_Nos(String serial_Nos) {
        Serial_Nos = serial_Nos;
    }

    public String getLot_Nos() {
        return Lot_Nos;
    }

    public void setLot_Nos(String lot_Nos) {
        Lot_Nos = lot_Nos;
    }

    public String getExpiration_Calculation() {
        return Expiration_Calculation;
    }

    public void setExpiration_Calculation(String expiration_Calculation) {
        Expiration_Calculation = expiration_Calculation;
    }

    public String getWarehouse_Class_Code() {
        return Warehouse_Class_Code;
    }

    public void setWarehouse_Class_Code(String warehouse_Class_Code) {
        Warehouse_Class_Code = warehouse_Class_Code;
    }

    public String getSpecial_Equipment_Code() {
        return Special_Equipment_Code;
    }

    public void setSpecial_Equipment_Code(String special_Equipment_Code) {
        Special_Equipment_Code = special_Equipment_Code;
    }

    public String getPut_away_Template_Code() {
        return Put_away_Template_Code;
    }

    public void setPut_away_Template_Code(String put_away_Template_Code) {
        Put_away_Template_Code = put_away_Template_Code;
    }

    public String getPut_away_Unit_of_Measure_Code() {
        return Put_away_Unit_of_Measure_Code;
    }

    public void setPut_away_Unit_of_Measure_Code(String put_away_Unit_of_Measure_Code) {
        Put_away_Unit_of_Measure_Code = put_away_Unit_of_Measure_Code;
    }

    public String getPhys_Invt_Counting_Period_Code() {
        return Phys_Invt_Counting_Period_Code;
    }

    public void setPhys_Invt_Counting_Period_Code(String phys_Invt_Counting_Period_Code) {
        Phys_Invt_Counting_Period_Code = phys_Invt_Counting_Period_Code;
    }

    public Date getLast_Phys_Invt_Date() {
        return Last_Phys_Invt_Date;
    }

    public void setLast_Phys_Invt_Date(Date last_Phys_Invt_Date) {
        Last_Phys_Invt_Date = last_Phys_Invt_Date;
    }

    public Date getLast_Counting_Period_Update() {
        return Last_Counting_Period_Update;
    }

    public void setLast_Counting_Period_Update(Date last_Counting_Period_Update) {
        Last_Counting_Period_Update = last_Counting_Period_Update;
    }

    public Date getNext_Counting_Start_Date() {
        return Next_Counting_Start_Date;
    }

    public void setNext_Counting_Start_Date(Date next_Counting_Start_Date) {
        Next_Counting_Start_Date = next_Counting_Start_Date;
    }

    public Date getNext_Counting_End_Date() {
        return Next_Counting_End_Date;
    }

    public void setNext_Counting_End_Date(Date next_Counting_End_Date) {
        Next_Counting_End_Date = next_Counting_End_Date;
    }

    public String getIdentifier_Code() {
        return Identifier_Code;
    }

    public void setIdentifier_Code(String identifier_Code) {
        Identifier_Code = identifier_Code;
    }

    public String getUse_Cross_Docking() {
        return Use_Cross_Docking;
    }

    public void setUse_Cross_Docking(String use_Cross_Docking) {
        Use_Cross_Docking = use_Cross_Docking;
    }

    public double getDiameter() {
        return Diameter;
    }

    public void setDiameter(double diameter) {
        Diameter = diameter;
    }

    public double getThickness() {
        return Thickness;
    }

    public void setThickness(double thickness) {
        Thickness = thickness;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public double getEdge_Length() {
        return Edge_Length;
    }

    public void setEdge_Length(double edge_Length) {
        Edge_Length = edge_Length;
    }

    public String getMarked() {
        return Marked;
    }

    public void setMarked(String marked) {
        Marked = marked;
    }

    public String getMachine() {
        return Machine;
    }

    public void setMachine(String machine) {
        Machine = machine;
    }

    public int getBends_Number() {
        return Bends_Number;
    }

    public void setBends_Number(int bends_Number) {
        Bends_Number = bends_Number;
    }

    public String getProgram() {
        return Program;
    }

    public void setProgram(String program) {
        Program = program;
    }

    public String getPlane() {
        return Plane;
    }

    public void setPlane(String plane) {
        Plane = plane;
    }

    public static void main(String[] args){
        //peticion de lectura
        String readRequest="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:item=\"urn:microsoft-dynamics-schemas/page/item_card\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <item:Read>\n" +
                "         <item:No>?</item:No>\n" +
                "      </item:Read>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        System.out.println(readRequest);

    }
}
