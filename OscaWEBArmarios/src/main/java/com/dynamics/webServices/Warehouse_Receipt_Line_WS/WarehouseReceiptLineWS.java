
package com.dynamics.webServices.Warehouse_Receipt_Line_WS;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Clase Java para Warehouse_Receipt_Line_WS complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Warehouse_Receipt_Line_WS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Line_No" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Source_Type" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Source_Subtype" type="{urn:microsoft-dynamics-schemas/page/warehouse_receipt_line_ws}Source_Subtype" minOccurs="0"/>
 *         &lt;element name="Source_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Source_Line_No" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Item_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Variant_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_to_Receive" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_Received" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_Base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_to_Receive_Base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_Received_Base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_Outstanding_Base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Unit_of_Measure_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Warehouse_Receipt_Line_WS", propOrder = {
    "key",
    "no",
    "lineNo",
    "sourceType",
    "sourceSubtype",
    "sourceNo",
    "sourceLineNo",
    "itemNo",
    "variantCode",
    "description",
    "quantity",
    "qtyToReceive",
    "qtyReceived",
    "qtyBase",
    "qtyToReceiveBase",
    "qtyReceivedBase",
    "qtyOutstandingBase",
    "unitOfMeasureCode"
})
public class WarehouseReceiptLineWS {

    @XmlElement(name = "Key")
    protected String key;
    @XmlElement(name = "No")
    protected String no;
    @XmlElement(name = "Line_No")
    protected Integer lineNo;
    @XmlElement(name = "Source_Type")
    protected Integer sourceType;
    @XmlElement(name = "Source_Subtype")
    @XmlSchemaType(name = "string")
    protected SourceSubtype sourceSubtype;
    @XmlElement(name = "Source_No")
    protected String sourceNo;
    @XmlElement(name = "Source_Line_No")
    protected Integer sourceLineNo;
    @XmlElement(name = "Item_No")
    protected String itemNo;
    @XmlElement(name = "Variant_Code")
    protected String variantCode;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Quantity")
    protected BigInteger quantity;
    @XmlElement(name = "Qty_to_Receive")
    protected BigInteger qtyToReceive;
    @XmlElement(name = "Qty_Received")
    protected BigInteger qtyReceived;
    @XmlElement(name = "Qty_Base")
    protected BigInteger qtyBase;
    @XmlElement(name = "Qty_to_Receive_Base")
    protected BigInteger qtyToReceiveBase;
    @XmlElement(name = "Qty_Received_Base")
    protected BigInteger qtyReceivedBase;
    @XmlElement(name = "Qty_Outstanding_Base")
    protected BigInteger qtyOutstandingBase;
    @XmlElement(name = "Unit_of_Measure_Code")
    protected String unitOfMeasureCode;

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
     * Obtiene el valor de la propiedad sourceType.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSourceType() {
        return sourceType;
    }

    /**
     * Define el valor de la propiedad sourceType.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSourceType(Integer value) {
        this.sourceType = value;
    }

    /**
     * Obtiene el valor de la propiedad sourceSubtype.
     * 
     * @return
     *     possible object is
     *     {@link SourceSubtype }
     *     
     */
    public SourceSubtype getSourceSubtype() {
        return sourceSubtype;
    }

    /**
     * Define el valor de la propiedad sourceSubtype.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceSubtype }
     *     
     */
    public void setSourceSubtype(SourceSubtype value) {
        this.sourceSubtype = value;
    }

    /**
     * Obtiene el valor de la propiedad sourceNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceNo() {
        return sourceNo;
    }

    /**
     * Define el valor de la propiedad sourceNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceNo(String value) {
        this.sourceNo = value;
    }

    /**
     * Obtiene el valor de la propiedad sourceLineNo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSourceLineNo() {
        return sourceLineNo;
    }

    /**
     * Define el valor de la propiedad sourceLineNo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSourceLineNo(Integer value) {
        this.sourceLineNo = value;
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
     * Obtiene el valor de la propiedad qtyToReceive.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyToReceive() {
        return qtyToReceive;
    }

    /**
     * Define el valor de la propiedad qtyToReceive.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyToReceive(BigInteger value) {
        this.qtyToReceive = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyReceived.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyReceived() {
        return qtyReceived;
    }

    /**
     * Define el valor de la propiedad qtyReceived.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyReceived(BigInteger value) {
        this.qtyReceived = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyBase.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyBase() {
        return qtyBase;
    }

    /**
     * Define el valor de la propiedad qtyBase.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyBase(BigInteger value) {
        this.qtyBase = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyToReceiveBase.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyToReceiveBase() {
        return qtyToReceiveBase;
    }

    /**
     * Define el valor de la propiedad qtyToReceiveBase.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyToReceiveBase(BigInteger value) {
        this.qtyToReceiveBase = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyReceivedBase.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyReceivedBase() {
        return qtyReceivedBase;
    }

    /**
     * Define el valor de la propiedad qtyReceivedBase.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyReceivedBase(BigInteger value) {
        this.qtyReceivedBase = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyOutstandingBase.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyOutstandingBase() {
        return qtyOutstandingBase;
    }

    /**
     * Define el valor de la propiedad qtyOutstandingBase.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyOutstandingBase(BigInteger value) {
        this.qtyOutstandingBase = value;
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

}
