
package com.dynamics.webServices.Bin_WS;

import com.fasterxml.jackson.annotation.JsonView;
import org.oscasistemas.model.View;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Clase Java para Bin_WS complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Bin_WS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Location_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zone_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Adjustment_Bin" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Bin_Type_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Warehouse_Class_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Block_Movement" type="{urn:microsoft-dynamics-schemas/page/bin_ws}Block_Movement" minOccurs="0"/>
 *         &lt;element name="Special_Equipment_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bin_Ranking" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Maximum_Cubage" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Maximum_Weight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Empty" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Item_Filter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Variant_Filter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Default" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Cross_Dock_Bin" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Dedicated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bin_WS", propOrder = {
    "key",
    "locationCode",
    "code",
    "description",
    "zoneCode",
    "adjustmentBin",
    "binTypeCode",
    "warehouseClassCode",
    "blockMovement",
    "specialEquipmentCode",
    "binRanking",
    "maximumCubage",
    "maximumWeight",
    "empty",
    "itemFilter",
    "variantFilter",
    "_default",
    "crossDockBin",
    "dedicated"
})
public class BinWS {
    @JsonView(View.Summary.class)
    @XmlElement(name = "Key")
    protected String key;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Location_Code")
    protected String locationCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Code")
    protected String code;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Description")
    protected String description;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Zone_Code")
    protected String zoneCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Adjustment_Bin")
    protected Boolean adjustmentBin;
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
    @XmlElement(name = "Special_Equipment_Code")
    protected String specialEquipmentCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Bin_Ranking")
    protected Integer binRanking;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Maximum_Cubage")
    protected BigInteger maximumCubage;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Maximum_Weight")
    protected BigInteger maximumWeight;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Empty")
    protected Boolean empty;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Item_Filter")
    protected String itemFilter;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Variant_Filter")
    protected String variantFilter;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Default")
    protected Boolean _default;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Cross_Dock_Bin")
    protected Boolean crossDockBin;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Dedicated")
    protected Boolean dedicated;

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
     * Obtiene el valor de la propiedad code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Define el valor de la propiedad code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
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
     * Obtiene el valor de la propiedad adjustmentBin.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAdjustmentBin() {
        return adjustmentBin;
    }

    /**
     * Define el valor de la propiedad adjustmentBin.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAdjustmentBin(Boolean value) {
        this.adjustmentBin = value;
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
     * Obtiene el valor de la propiedad maximumCubage.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaximumCubage() {
        return maximumCubage;
    }

    /**
     * Define el valor de la propiedad maximumCubage.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaximumCubage(BigInteger value) {
        this.maximumCubage = value;
    }

    /**
     * Obtiene el valor de la propiedad maximumWeight.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaximumWeight() {
        return maximumWeight;
    }

    /**
     * Define el valor de la propiedad maximumWeight.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaximumWeight(BigInteger value) {
        this.maximumWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad empty.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEmpty() {
        return empty;
    }

    /**
     * Define el valor de la propiedad empty.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEmpty(Boolean value) {
        this.empty = value;
    }

    /**
     * Obtiene el valor de la propiedad itemFilter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemFilter() {
        return itemFilter;
    }

    /**
     * Define el valor de la propiedad itemFilter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemFilter(String value) {
        this.itemFilter = value;
    }

    /**
     * Obtiene el valor de la propiedad variantFilter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVariantFilter() {
        return variantFilter;
    }

    /**
     * Define el valor de la propiedad variantFilter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVariantFilter(String value) {
        this.variantFilter = value;
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

}
