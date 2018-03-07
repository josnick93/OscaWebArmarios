
package com.dynamics.webServices.Prod_Order_Line_WS;

import com.fasterxml.jackson.annotation.JsonView;
import org.oscasistemas.model.View;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;


/**
 * <p>Clase Java para Prod_Order_Line_WS complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Prod_Order_Line_WS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Prod_Order_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Line_No" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Item_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Search_Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Location_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bin_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Quantity_Base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Finished_Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Finished_Qty_Base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Remaining_Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Remaining_Qty_Base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Due_Date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Hose_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{urn:microsoft-dynamics-schemas/page/prod_order_line_ws}Status" minOccurs="0"/>
 *         &lt;element name="Crane" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Part" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Crane_Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Part_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Prod_Order_Line_WS", propOrder = {
    "key",
    "prodOrderNo",
    "lineNo",
    "itemNo",
    "description",
    "searchDescription",
    "locationCode",
    "binCode",
    "quantity",
    "quantityBase",
    "finishedQuantity",
    "finishedQtyBase",
    "remainingQuantity",
    "remainingQtyBase",
    "dueDate",
    "hoseId",
    "status",
    "crane",
    "part",
    "craneId",
    "partId"
})
public class ProdOrderLineWS {

    @JsonView(View.Summary.class)
    @XmlElement(name = "Key")
    protected String key;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Prod_Order_No")
    protected String prodOrderNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Line_No")
    protected Integer lineNo;
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
    @XmlElement(name = "Location_Code")
    protected String locationCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Bin_Code")
    protected String binCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Quantity")
    protected BigInteger quantity;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Quantity_Base")
    protected BigInteger quantityBase;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Finished_Quantity")
    protected BigInteger finishedQuantity;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Finished_Qty_Base")
    protected BigInteger finishedQtyBase;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Remaining_Quantity")
    protected BigInteger remainingQuantity;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Remaining_Qty_Base")
    protected BigInteger remainingQtyBase;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Due_Date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dueDate;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Hose_Id")
    protected String hoseId;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Status")
    @XmlSchemaType(name = "string")
    protected Status status;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Crane")
    protected String crane;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Part")
    protected String part;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Crane_Id")
    protected Integer craneId;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Part_Id")
    protected String partId;

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
     * Obtiene el valor de la propiedad lineNo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLineNo() {
        return lineNo;
    }

    /**
     * Define el valor de la propiedad lineNo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLineNo(Integer value) {
        this.lineNo = value;
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
     * Obtiene el valor de la propiedad finishedQuantity.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFinishedQuantity() {
        return finishedQuantity;
    }

    /**
     * Define el valor de la propiedad finishedQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFinishedQuantity(BigInteger value) {
        this.finishedQuantity = value;
    }

    /**
     * Obtiene el valor de la propiedad finishedQtyBase.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFinishedQtyBase() {
        return finishedQtyBase;
    }

    /**
     * Define el valor de la propiedad finishedQtyBase.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFinishedQtyBase(BigInteger value) {
        this.finishedQtyBase = value;
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
     * Obtiene el valor de la propiedad dueDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDueDate() {
        return dueDate;
    }

    /**
     * Define el valor de la propiedad dueDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDueDate(XMLGregorianCalendar value) {
        this.dueDate = value;
    }

    /**
     * Obtiene el valor de la propiedad hoseId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoseId() {
        return hoseId;
    }

    /**
     * Define el valor de la propiedad hoseId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoseId(String value) {
        this.hoseId = value;
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
     * Obtiene el valor de la propiedad crane.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrane() {
        return crane;
    }

    /**
     * Define el valor de la propiedad crane.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrane(String value) {
        this.crane = value;
    }

    /**
     * Obtiene el valor de la propiedad part.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPart() {
        return part;
    }

    /**
     * Define el valor de la propiedad part.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPart(String value) {
        this.part = value;
    }

    /**
     * Obtiene el valor de la propiedad craneId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCraneId() {
        return craneId;
    }

    /**
     * Define el valor de la propiedad craneId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCraneId(Integer value) {
        this.craneId = value;
    }

    /**
     * Obtiene el valor de la propiedad partId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartId() {
        return partId;
    }

    /**
     * Define el valor de la propiedad partId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartId(String value) {
        this.partId = value;
    }

}
