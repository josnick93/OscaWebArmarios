
package com.dynamics.webServices.Bin_Content_WS;

import com.fasterxml.jackson.annotation.JsonView;
import org.oscasistemas.model.View;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Clase Java para Bin_Content_WS complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Bin_Content_WS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Location_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zone_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bin_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Item_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bin_Type_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Warehouse_Class_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Block_Movement" type="{urn:microsoft-dynamics-schemas/page/bin_content_ws}Block_Movement" minOccurs="0"/>
 *         &lt;element name="Min_Qty" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Max_Qty" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Bin_Ranking" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Pick_Qty" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Neg_Adjmt_Qty" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Put_away_Qty" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Pos_Adjmt_Qty" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Fixed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Cross_Dock_Bin" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Default" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Quantity_Base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Pick_Quantity_Base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Negative_Adjmt_Qty_Base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Put_away_Quantity_Base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Positive_Adjmt_Qty_Base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ATO_Components_Pick_Qty" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ATO_Components_Pick_Qty_Base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Variant_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Qty_per_Unit_of_Measure" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Unit_of_Measure_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Lot_No_Filter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Serial_No_Filter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Dedicated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Unit_of_Measure_Filter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bin_Content_WS", propOrder = {
    "key",
    "locationCode",
    "zoneCode",
    "binCode",
    "itemNo",
    "binTypeCode",
    "warehouseClassCode",
    "blockMovement",
    "minQty",
    "maxQty",
    "binRanking",
    "quantity",
    "pickQty",
    "negAdjmtQty",
    "putAwayQty",
    "posAdjmtQty",
    "fixed",
    "crossDockBin",
    "_default",
    "quantityBase",
    "pickQuantityBase",
    "negativeAdjmtQtyBase",
    "putAwayQuantityBase",
    "positiveAdjmtQtyBase",
    "atoComponentsPickQty",
    "atoComponentsPickQtyBase",
    "variantCode",
    "qtyPerUnitOfMeasure",
    "unitOfMeasureCode",
    "lotNoFilter",
    "serialNoFilter",
    "dedicated",
    "unitOfMeasureFilter"
})
public class BinContentWS {

    @JsonView(View.Summary.class)
    @XmlElement(name = "Key")
    protected String key;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Location_Code")
    protected String locationCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Zone_Code")
    protected String zoneCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Bin_Code")
    protected String binCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Item_No")
    protected String itemNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Bin_Type_Code")
    protected String binTypeCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Warehouse_Class_Code")
    protected String warehouseClassCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Block_Movement")
    @XmlSchemaType(name = "string")
    protected BlockMovement blockMovement;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Min_Qty")
    protected BigInteger minQty;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Max_Qty")
    protected BigInteger maxQty;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Bin_Ranking")
    protected Integer binRanking;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Quantity")
    protected BigInteger quantity;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Pick_Qty")
    protected BigInteger pickQty;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Neg_Adjmt_Qty")
    protected BigInteger negAdjmtQty;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Put_away_Qty")
    protected BigInteger putAwayQty;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Pos_Adjmt_Qty")
    protected BigInteger posAdjmtQty;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Fixed")
    protected Boolean fixed;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Cross_Dock_Bin")
    protected Boolean crossDockBin;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Default")
    protected Boolean _default;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Quantity_Base")
    protected BigInteger quantityBase;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Pick_Quantity_Base")
    protected BigInteger pickQuantityBase;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Negative_Adjmt_Qty_Base")
    protected BigInteger negativeAdjmtQtyBase;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Put_away_Quantity_Base")
    protected BigInteger putAwayQuantityBase;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Positive_Adjmt_Qty_Base")
    protected BigInteger positiveAdjmtQtyBase;
 @JsonView(View.Summary.class)
    @XmlElement(name = "ATO_Components_Pick_Qty")
    protected BigInteger atoComponentsPickQty;
 @JsonView(View.Summary.class)
    @XmlElement(name = "ATO_Components_Pick_Qty_Base")
    protected BigInteger atoComponentsPickQtyBase;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Variant_Code")
    protected String variantCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Qty_per_Unit_of_Measure")
    protected BigInteger qtyPerUnitOfMeasure;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Unit_of_Measure_Code")
    protected String unitOfMeasureCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Lot_No_Filter")
    protected String lotNoFilter;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Serial_No_Filter")
    protected String serialNoFilter;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Dedicated")
    protected Boolean dedicated;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Unit_of_Measure_Filter")
    protected String unitOfMeasureFilter;

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
     * Obtiene el valor de la propiedad locationCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationCode() {
        return locationCode;
    }

    /**
     * Define el valor de la propiedad locationCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationCode(String value) {
        this.locationCode = value;
    }

    /**
     * Obtiene el valor de la propiedad zoneCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZoneCode() {
        return zoneCode;
    }

    /**
     * Define el valor de la propiedad zoneCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZoneCode(String value) {
        this.zoneCode = value;
    }

    /**
     * Obtiene el valor de la propiedad binCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBinCode() {
        return binCode;
    }

    /**
     * Define el valor de la propiedad binCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBinCode(String value) {
        this.binCode = value;
    }

    /**
     * Obtiene el valor de la propiedad itemNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemNo() {
        return itemNo;
    }

    /**
     * Define el valor de la propiedad itemNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemNo(String value) {
        this.itemNo = value;
    }

    /**
     * Obtiene el valor de la propiedad binTypeCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBinTypeCode() {
        return binTypeCode;
    }

    /**
     * Define el valor de la propiedad binTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBinTypeCode(String value) {
        this.binTypeCode = value;
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
     * Obtiene el valor de la propiedad blockMovement.
     * 
     * @return
     *     possible object is
     *     {@link BlockMovement }
     *     
     */
    public BlockMovement getBlockMovement() {
        return blockMovement;
    }

    /**
     * Define el valor de la propiedad blockMovement.
     * 
     * @param value
     *     allowed object is
     *     {@link BlockMovement }
     *     
     */
    public void setBlockMovement(BlockMovement value) {
        this.blockMovement = value;
    }

    /**
     * Obtiene el valor de la propiedad minQty.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinQty() {
        return minQty;
    }

    /**
     * Define el valor de la propiedad minQty.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMinQty(BigInteger value) {
        this.minQty = value;
    }

    /**
     * Obtiene el valor de la propiedad maxQty.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxQty() {
        return maxQty;
    }

    /**
     * Define el valor de la propiedad maxQty.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxQty(BigInteger value) {
        this.maxQty = value;
    }

    /**
     * Obtiene el valor de la propiedad binRanking.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBinRanking() {
        return binRanking;
    }

    /**
     * Define el valor de la propiedad binRanking.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBinRanking(Integer value) {
        this.binRanking = value;
    }

    /**
     * Obtiene el valor de la propiedad quantity.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQuantity() {
        return quantity;
    }

    /**
     * Define el valor de la propiedad quantity.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQuantity(BigInteger value) {
        this.quantity = value;
    }

    /**
     * Obtiene el valor de la propiedad pickQty.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPickQty() {
        return pickQty;
    }

    /**
     * Define el valor de la propiedad pickQty.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPickQty(BigInteger value) {
        this.pickQty = value;
    }

    /**
     * Obtiene el valor de la propiedad negAdjmtQty.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNegAdjmtQty() {
        return negAdjmtQty;
    }

    /**
     * Define el valor de la propiedad negAdjmtQty.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNegAdjmtQty(BigInteger value) {
        this.negAdjmtQty = value;
    }

    /**
     * Obtiene el valor de la propiedad putAwayQty.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPutAwayQty() {
        return putAwayQty;
    }

    /**
     * Define el valor de la propiedad putAwayQty.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPutAwayQty(BigInteger value) {
        this.putAwayQty = value;
    }

    /**
     * Obtiene el valor de la propiedad posAdjmtQty.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPosAdjmtQty() {
        return posAdjmtQty;
    }

    /**
     * Define el valor de la propiedad posAdjmtQty.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPosAdjmtQty(BigInteger value) {
        this.posAdjmtQty = value;
    }

    /**
     * Obtiene el valor de la propiedad fixed.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFixed() {
        return fixed;
    }

    /**
     * Define el valor de la propiedad fixed.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFixed(Boolean value) {
        this.fixed = value;
    }

    /**
     * Obtiene el valor de la propiedad crossDockBin.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCrossDockBin() {
        return crossDockBin;
    }

    /**
     * Define el valor de la propiedad crossDockBin.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCrossDockBin(Boolean value) {
        this.crossDockBin = value;
    }

    /**
     * Obtiene el valor de la propiedad default.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDefault() {
        return _default;
    }

    /**
     * Define el valor de la propiedad default.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDefault(Boolean value) {
        this._default = value;
    }

    /**
     * Obtiene el valor de la propiedad quantityBase.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQuantityBase() {
        return quantityBase;
    }

    /**
     * Define el valor de la propiedad quantityBase.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQuantityBase(BigInteger value) {
        this.quantityBase = value;
    }

    /**
     * Obtiene el valor de la propiedad pickQuantityBase.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPickQuantityBase() {
        return pickQuantityBase;
    }

    /**
     * Define el valor de la propiedad pickQuantityBase.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPickQuantityBase(BigInteger value) {
        this.pickQuantityBase = value;
    }

    /**
     * Obtiene el valor de la propiedad negativeAdjmtQtyBase.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNegativeAdjmtQtyBase() {
        return negativeAdjmtQtyBase;
    }

    /**
     * Define el valor de la propiedad negativeAdjmtQtyBase.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNegativeAdjmtQtyBase(BigInteger value) {
        this.negativeAdjmtQtyBase = value;
    }

    /**
     * Obtiene el valor de la propiedad putAwayQuantityBase.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPutAwayQuantityBase() {
        return putAwayQuantityBase;
    }

    /**
     * Define el valor de la propiedad putAwayQuantityBase.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPutAwayQuantityBase(BigInteger value) {
        this.putAwayQuantityBase = value;
    }

    /**
     * Obtiene el valor de la propiedad positiveAdjmtQtyBase.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPositiveAdjmtQtyBase() {
        return positiveAdjmtQtyBase;
    }

    /**
     * Define el valor de la propiedad positiveAdjmtQtyBase.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPositiveAdjmtQtyBase(BigInteger value) {
        this.positiveAdjmtQtyBase = value;
    }

    /**
     * Obtiene el valor de la propiedad atoComponentsPickQty.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getATOComponentsPickQty() {
        return atoComponentsPickQty;
    }

    /**
     * Define el valor de la propiedad atoComponentsPickQty.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setATOComponentsPickQty(BigInteger value) {
        this.atoComponentsPickQty = value;
    }

    /**
     * Obtiene el valor de la propiedad atoComponentsPickQtyBase.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getATOComponentsPickQtyBase() {
        return atoComponentsPickQtyBase;
    }

    /**
     * Define el valor de la propiedad atoComponentsPickQtyBase.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setATOComponentsPickQtyBase(BigInteger value) {
        this.atoComponentsPickQtyBase = value;
    }

    /**
     * Obtiene el valor de la propiedad variantCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVariantCode() {
        return variantCode;
    }

    /**
     * Define el valor de la propiedad variantCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVariantCode(String value) {
        this.variantCode = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyPerUnitOfMeasure.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyPerUnitOfMeasure() {
        return qtyPerUnitOfMeasure;
    }

    /**
     * Define el valor de la propiedad qtyPerUnitOfMeasure.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyPerUnitOfMeasure(BigInteger value) {
        this.qtyPerUnitOfMeasure = value;
    }

    /**
     * Obtiene el valor de la propiedad unitOfMeasureCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitOfMeasureCode() {
        return unitOfMeasureCode;
    }

    /**
     * Define el valor de la propiedad unitOfMeasureCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitOfMeasureCode(String value) {
        this.unitOfMeasureCode = value;
    }

    /**
     * Obtiene el valor de la propiedad lotNoFilter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLotNoFilter() {
        return lotNoFilter;
    }

    /**
     * Define el valor de la propiedad lotNoFilter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLotNoFilter(String value) {
        this.lotNoFilter = value;
    }

    /**
     * Obtiene el valor de la propiedad serialNoFilter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialNoFilter() {
        return serialNoFilter;
    }

    /**
     * Define el valor de la propiedad serialNoFilter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialNoFilter(String value) {
        this.serialNoFilter = value;
    }

    /**
     * Obtiene el valor de la propiedad dedicated.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDedicated() {
        return dedicated;
    }

    /**
     * Define el valor de la propiedad dedicated.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDedicated(Boolean value) {
        this.dedicated = value;
    }

    /**
     * Obtiene el valor de la propiedad unitOfMeasureFilter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitOfMeasureFilter() {
        return unitOfMeasureFilter;
    }

    /**
     * Define el valor de la propiedad unitOfMeasureFilter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitOfMeasureFilter(String value) {
        this.unitOfMeasureFilter = value;
    }

    @Override
    public String toString() {
        return "BinContentWS{" +
                "key='" + key + '\'' +
                ", locationCode='" + locationCode + '\'' +
                ", zoneCode='" + zoneCode + '\'' +
                ", binCode='" + binCode + '\'' +
                ", itemNo='" + itemNo + '\'' +
                ", binTypeCode='" + binTypeCode + '\'' +
                ", warehouseClassCode='" + warehouseClassCode + '\'' +
                ", blockMovement=" + blockMovement +
                ", minQty=" + minQty +
                ", maxQty=" + maxQty +
                ", binRanking=" + binRanking +
                ", quantity=" + quantity +
                ", pickQty=" + pickQty +
                ", negAdjmtQty=" + negAdjmtQty +
                ", putAwayQty=" + putAwayQty +
                ", posAdjmtQty=" + posAdjmtQty +
                ", fixed=" + fixed +
                ", crossDockBin=" + crossDockBin +
                ", _default=" + _default +
                ", quantityBase=" + quantityBase +
                ", pickQuantityBase=" + pickQuantityBase +
                ", negativeAdjmtQtyBase=" + negativeAdjmtQtyBase +
                ", putAwayQuantityBase=" + putAwayQuantityBase +
                ", positiveAdjmtQtyBase=" + positiveAdjmtQtyBase +
                ", atoComponentsPickQty=" + atoComponentsPickQty +
                ", atoComponentsPickQtyBase=" + atoComponentsPickQtyBase +
                ", variantCode='" + variantCode + '\'' +
                ", qtyPerUnitOfMeasure=" + qtyPerUnitOfMeasure +
                ", unitOfMeasureCode='" + unitOfMeasureCode + '\'' +
                ", lotNoFilter='" + lotNoFilter + '\'' +
                ", serialNoFilter='" + serialNoFilter + '\'' +
                ", dedicated=" + dedicated +
                ", unitOfMeasureFilter='" + unitOfMeasureFilter + '\'' +
                '}';
    }
}
