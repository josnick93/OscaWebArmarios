
package com.dynamics.webServices.Warehouse_Shipment_Line_WS;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Clase Java para Warehouse_Shipment_Line_WS complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Warehouse_Shipment_Line_WS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Line_No" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Item_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Variant_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_to_Ship" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_Shipped" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Unit_of_Measure_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Qty_to_Ship_Base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_Shipped_Base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Source_Type" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Source_Subtype" type="{urn:microsoft-dynamics-schemas/page/warehouse_shipment_line_ws}Source_Subtype" minOccurs="0"/>
 *         &lt;element name="Source_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Source_Line_No" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Source_Document" type="{urn:microsoft-dynamics-schemas/page/warehouse_shipment_line_ws}Source_Document" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Warehouse_Shipment_Line_WS", propOrder = {
    "key",
    "no",
    "lineNo",
    "itemNo",
    "variantCode",
    "quantity",
    "qtyToShip",
    "qtyShipped",
    "unitOfMeasureCode",
    "description",
    "qtyToShipBase",
    "qtyShippedBase",
    "sourceType",
    "sourceSubtype",
    "sourceNo",
    "sourceLineNo",
    "sourceDocument"
})
public class WarehouseShipmentLineWS {

    @XmlElement(name = "Key")
    protected String key;
    @XmlElement(name = "No")
    protected String no;
    @XmlElement(name = "Line_No")
    protected Integer lineNo;
    @XmlElement(name = "Item_No")
    protected String itemNo;
    @XmlElement(name = "Variant_Code")
    protected String variantCode;
    @XmlElement(name = "Quantity")
    protected BigInteger quantity;
    @XmlElement(name = "Qty_to_Ship")
    protected BigInteger qtyToShip;
    @XmlElement(name = "Qty_Shipped")
    protected BigInteger qtyShipped;
    @XmlElement(name = "Unit_of_Measure_Code")
    protected String unitOfMeasureCode;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Qty_to_Ship_Base")
    protected BigInteger qtyToShipBase;
    @XmlElement(name = "Qty_Shipped_Base")
    protected BigInteger qtyShippedBase;
    @XmlElement(name = "Source_Type")
    protected Integer sourceType;
    @XmlElement(name = "Source_Subtype")
    @XmlSchemaType(name = "string")
    protected SourceSubtype sourceSubtype;
    @XmlElement(name = "Source_No")
    protected String sourceNo;
    @XmlElement(name = "Source_Line_No")
    protected Integer sourceLineNo;
    @XmlElement(name = "Source_Document")
    @XmlSchemaType(name = "string")
    protected SourceDocument sourceDocument;

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
     * Obtiene el valor de la propiedad qtyToShip.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyToShip() {
        return qtyToShip;
    }

    /**
     * Define el valor de la propiedad qtyToShip.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyToShip(BigInteger value) {
        this.qtyToShip = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyShipped.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyShipped() {
        return qtyShipped;
    }

    /**
     * Define el valor de la propiedad qtyShipped.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyShipped(BigInteger value) {
        this.qtyShipped = value;
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
     * Obtiene el valor de la propiedad qtyToShipBase.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyToShipBase() {
        return qtyToShipBase;
    }

    /**
     * Define el valor de la propiedad qtyToShipBase.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyToShipBase(BigInteger value) {
        this.qtyToShipBase = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyShippedBase.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyShippedBase() {
        return qtyShippedBase;
    }

    /**
     * Define el valor de la propiedad qtyShippedBase.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyShippedBase(BigInteger value) {
        this.qtyShippedBase = value;
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
     * Obtiene el valor de la propiedad sourceDocument.
     * 
     * @return
     *     possible object is
     *     {@link SourceDocument }
     *     
     */
    public SourceDocument getSourceDocument() {
        return sourceDocument;
    }

    /**
     * Define el valor de la propiedad sourceDocument.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceDocument }
     *     
     */
    public void setSourceDocument(SourceDocument value) {
        this.sourceDocument = value;
    }

}
