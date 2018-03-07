
package com.dynamics.webServices.Prod_Order_Component_WS;

import com.fasterxml.jackson.annotation.JsonView;
import org.oscasistemas.model.View;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Clase Java para Prod_Order_Component_WS complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Prod_Order_Component_WS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{urn:microsoft-dynamics-schemas/page/prod_order_component_ws}Status" minOccurs="0"/>
 *         &lt;element name="Prod_Order_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Prod_Order_Line_No" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Item_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Search_Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Unit_of_Measure_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Quantity_Base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Quantity_per" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_per_Unit_of_Measure" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Expected_Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Expected_Qty_Base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Remaining_Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Remaining_Qty_Base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Act_Consumption_Qty" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Routing_Link_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Flushing_Method" type="{urn:microsoft-dynamics-schemas/page/prod_order_component_ws}Flushing_Method" minOccurs="0"/>
 *         &lt;element name="Location_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bin_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Prod_Order_Component_WS", propOrder = {
    "key",
    "status",
    "prodOrderNo",
    "prodOrderLineNo",
    "itemNo",
    "description",
    "searchDescription",
    "unitOfMeasureCode",
    "quantity",
    "quantityBase",
    "quantityPer",
    "qtyPerUnitOfMeasure",
    "expectedQuantity",
    "expectedQtyBase",
    "remainingQuantity",
    "remainingQtyBase",
    "actConsumptionQty",
    "routingLinkCode",
    "flushingMethod",
    "locationCode",
    "binCode",
    "category"
})
public class ProdOrderComponentWS {

    @JsonView(View.Summary.class)
    @XmlElement(name = "Key")
    protected String key;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Status")
    @XmlSchemaType(name = "string")
    protected Status status;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Prod_Order_No")
    protected String prodOrderNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Prod_Order_Line_No")
    protected Integer prodOrderLineNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Item_No")
    protected String itemNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Description")
    protected String description;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Search_Description")
    protected String searchDescription;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Unit_of_Measure_Code")
    protected String unitOfMeasureCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Quantity")
    protected BigInteger quantity;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Quantity_Base")
    protected BigInteger quantityBase;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Quantity_per")
    protected BigInteger quantityPer;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Qty_per_Unit_of_Measure")
    protected BigInteger qtyPerUnitOfMeasure;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Expected_Quantity")
    protected BigInteger expectedQuantity;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Expected_Qty_Base")
    protected BigInteger expectedQtyBase;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Remaining_Quantity")
    protected BigInteger remainingQuantity;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Remaining_Qty_Base")
    protected BigInteger remainingQtyBase;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Act_Consumption_Qty")
    protected BigInteger actConsumptionQty;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Routing_Link_Code")
    protected String routingLinkCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Flushing_Method")
    @XmlSchemaType(name = "string")
    protected FlushingMethod flushingMethod;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Location_Code")
    protected String locationCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Bin_Code")
    protected String binCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Category")
    protected String category;

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
     * Obtiene el valor de la propiedad status.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Obtiene el valor de la propiedad prodOrderNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProdOrderNo() {
        return prodOrderNo;
    }

    /**
     * Define el valor de la propiedad prodOrderNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProdOrderNo(String value) {
        this.prodOrderNo = value;
    }

    /**
     * Obtiene el valor de la propiedad prodOrderLineNo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProdOrderLineNo() {
        return prodOrderLineNo;
    }

    /**
     * Define el valor de la propiedad prodOrderLineNo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProdOrderLineNo(Integer value) {
        this.prodOrderLineNo = value;
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
     * Obtiene el valor de la propiedad quantityPer.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQuantityPer() {
        return quantityPer;
    }

    /**
     * Define el valor de la propiedad quantityPer.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQuantityPer(BigInteger value) {
        this.quantityPer = value;
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
     * Obtiene el valor de la propiedad expectedQuantity.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getExpectedQuantity() {
        return expectedQuantity;
    }

    /**
     * Define el valor de la propiedad expectedQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setExpectedQuantity(BigInteger value) {
        this.expectedQuantity = value;
    }

    /**
     * Obtiene el valor de la propiedad expectedQtyBase.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getExpectedQtyBase() {
        return expectedQtyBase;
    }

    /**
     * Define el valor de la propiedad expectedQtyBase.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setExpectedQtyBase(BigInteger value) {
        this.expectedQtyBase = value;
    }

    /**
     * Obtiene el valor de la propiedad remainingQuantity.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRemainingQuantity() {
        return remainingQuantity;
    }

    /**
     * Define el valor de la propiedad remainingQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRemainingQuantity(BigInteger value) {
        this.remainingQuantity = value;
    }

    /**
     * Obtiene el valor de la propiedad remainingQtyBase.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRemainingQtyBase() {
        return remainingQtyBase;
    }

    /**
     * Define el valor de la propiedad remainingQtyBase.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRemainingQtyBase(BigInteger value) {
        this.remainingQtyBase = value;
    }

    /**
     * Obtiene el valor de la propiedad actConsumptionQty.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getActConsumptionQty() {
        return actConsumptionQty;
    }

    /**
     * Define el valor de la propiedad actConsumptionQty.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setActConsumptionQty(BigInteger value) {
        this.actConsumptionQty = value;
    }

    /**
     * Obtiene el valor de la propiedad routingLinkCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoutingLinkCode() {
        return routingLinkCode;
    }

    /**
     * Define el valor de la propiedad routingLinkCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoutingLinkCode(String value) {
        this.routingLinkCode = value;
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
     * Obtiene el valor de la propiedad category.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Define el valor de la propiedad category.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

}
