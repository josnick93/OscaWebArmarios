
package com.dynamics.webServices.WS_Whse_Worksheet_Line;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para WS_Whse_Worksheet_Line complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="WS_Whse_Worksheet_Line">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Worksheet_Template_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Location_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Line_No" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Item_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="From_Bin_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="To_Bin_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_to_Handle" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WS_Whse_Worksheet_Line", propOrder = {
    "key",
    "worksheetTemplateName",
    "name",
    "locationCode",
    "lineNo",
    "itemNo",
    "description",
    "fromBinCode",
    "toBinCode",
    "quantity",
    "qtyToHandle"
})
public class WSWhseWorksheetLine {

    @XmlElement(name = "Key")
    protected String key;
    @XmlElement(name = "Worksheet_Template_Name")
    protected String worksheetTemplateName;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Location_Code")
    protected String locationCode;
    @XmlElement(name = "Line_No")
    protected Integer lineNo;
    @XmlElement(name = "Item_No")
    protected String itemNo;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "From_Bin_Code")
    protected String fromBinCode;
    @XmlElement(name = "To_Bin_Code")
    protected String toBinCode;
    @XmlElement(name = "Quantity")
    protected BigInteger quantity;
    @XmlElement(name = "Qty_to_Handle")
    protected BigInteger qtyToHandle;

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
     * Obtiene el valor de la propiedad worksheetTemplateName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorksheetTemplateName() {
        return worksheetTemplateName;
    }

    /**
     * Define el valor de la propiedad worksheetTemplateName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorksheetTemplateName(String value) {
        this.worksheetTemplateName = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     * Obtiene el valor de la propiedad fromBinCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromBinCode() {
        return fromBinCode;
    }

    /**
     * Define el valor de la propiedad fromBinCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromBinCode(String value) {
        this.fromBinCode = value;
    }

    /**
     * Obtiene el valor de la propiedad toBinCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToBinCode() {
        return toBinCode;
    }

    /**
     * Define el valor de la propiedad toBinCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToBinCode(String value) {
        this.toBinCode = value;
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
     * Obtiene el valor de la propiedad qtyToHandle.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyToHandle() {
        return qtyToHandle;
    }

    /**
     * Define el valor de la propiedad qtyToHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyToHandle(BigInteger value) {
        this.qtyToHandle = value;
    }

}
