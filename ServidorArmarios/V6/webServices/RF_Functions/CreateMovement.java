
package com.dynamics.webServices.RF_Functions;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parLocation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parUser" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parDocNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parItemNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parVariantCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parLotNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parQty" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="parUOM" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parBinSource" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parBinDest" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "parLocation",
    "parUser",
    "parDocNo",
    "parItemNo",
    "parVariantCode",
    "parLotNo",
    "parQty",
    "parUOM",
    "parBinSource",
    "parBinDest"
})
@XmlRootElement(name = "CreateMovement")
public class CreateMovement {

    @XmlElement(required = true)
    protected String parLocation;
    @XmlElement(required = true)
    protected String parUser;
    @XmlElement(required = true)
    protected String parDocNo;
    @XmlElement(required = true)
    protected String parItemNo;
    @XmlElement(required = true)
    protected String parVariantCode;
    @XmlElement(required = true)
    protected String parLotNo;
    @XmlElement(required = true)
    protected BigInteger parQty;
    @XmlElement(required = true)
    protected String parUOM;
    @XmlElement(required = true)
    protected String parBinSource;
    @XmlElement(required = true)
    protected String parBinDest;

    /**
     * Obtiene el valor de la propiedad parLocation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParLocation() {
        return parLocation;
    }

    /**
     * Define el valor de la propiedad parLocation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParLocation(String value) {
        this.parLocation = value;
    }

    /**
     * Obtiene el valor de la propiedad parUser.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParUser() {
        return parUser;
    }

    /**
     * Define el valor de la propiedad parUser.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParUser(String value) {
        this.parUser = value;
    }

    /**
     * Obtiene el valor de la propiedad parDocNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParDocNo() {
        return parDocNo;
    }

    /**
     * Define el valor de la propiedad parDocNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParDocNo(String value) {
        this.parDocNo = value;
    }

    /**
     * Obtiene el valor de la propiedad parItemNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParItemNo() {
        return parItemNo;
    }

    /**
     * Define el valor de la propiedad parItemNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParItemNo(String value) {
        this.parItemNo = value;
    }

    /**
     * Obtiene el valor de la propiedad parVariantCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParVariantCode() {
        return parVariantCode;
    }

    /**
     * Define el valor de la propiedad parVariantCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParVariantCode(String value) {
        this.parVariantCode = value;
    }

    /**
     * Obtiene el valor de la propiedad parLotNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParLotNo() {
        return parLotNo;
    }

    /**
     * Define el valor de la propiedad parLotNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParLotNo(String value) {
        this.parLotNo = value;
    }

    /**
     * Obtiene el valor de la propiedad parQty.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getParQty() {
        return parQty;
    }

    /**
     * Define el valor de la propiedad parQty.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setParQty(BigInteger value) {
        this.parQty = value;
    }

    /**
     * Obtiene el valor de la propiedad parUOM.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParUOM() {
        return parUOM;
    }

    /**
     * Define el valor de la propiedad parUOM.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParUOM(String value) {
        this.parUOM = value;
    }

    /**
     * Obtiene el valor de la propiedad parBinSource.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParBinSource() {
        return parBinSource;
    }

    /**
     * Define el valor de la propiedad parBinSource.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParBinSource(String value) {
        this.parBinSource = value;
    }

    /**
     * Obtiene el valor de la propiedad parBinDest.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParBinDest() {
        return parBinDest;
    }

    /**
     * Define el valor de la propiedad parBinDest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParBinDest(String value) {
        this.parBinDest = value;
    }

}
