
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
 *         &lt;element name="pSourceType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pSourceNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pSourceLineNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pItemNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pVariantCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pLocationCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pLotNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pQuantity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
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
    "pSourceType",
    "pSourceNo",
    "pSourceLineNo",
    "pItemNo",
    "pVariantCode",
    "pLocationCode",
    "pLotNo",
    "pQuantity"
})
@XmlRootElement(name = "CreateTracking")
public class CreateTracking {

    protected int pSourceType;
    @XmlElement(required = true)
    protected String pSourceNo;
    protected int pSourceLineNo;
    @XmlElement(required = true)
    protected String pItemNo;
    @XmlElement(required = true)
    protected String pVariantCode;
    @XmlElement(required = true)
    protected String pLocationCode;
    @XmlElement(required = true)
    protected String pLotNo;
    @XmlElement(required = true)
    protected BigInteger pQuantity;

    /**
     * Obtiene el valor de la propiedad pSourceType.
     * 
     */
    public int getPSourceType() {
        return pSourceType;
    }

    /**
     * Define el valor de la propiedad pSourceType.
     * 
     */
    public void setPSourceType(int value) {
        this.pSourceType = value;
    }

    /**
     * Obtiene el valor de la propiedad pSourceNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPSourceNo() {
        return pSourceNo;
    }

    /**
     * Define el valor de la propiedad pSourceNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPSourceNo(String value) {
        this.pSourceNo = value;
    }

    /**
     * Obtiene el valor de la propiedad pSourceLineNo.
     * 
     */
    public int getPSourceLineNo() {
        return pSourceLineNo;
    }

    /**
     * Define el valor de la propiedad pSourceLineNo.
     * 
     */
    public void setPSourceLineNo(int value) {
        this.pSourceLineNo = value;
    }

    /**
     * Obtiene el valor de la propiedad pItemNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPItemNo() {
        return pItemNo;
    }

    /**
     * Define el valor de la propiedad pItemNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPItemNo(String value) {
        this.pItemNo = value;
    }

    /**
     * Obtiene el valor de la propiedad pVariantCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPVariantCode() {
        return pVariantCode;
    }

    /**
     * Define el valor de la propiedad pVariantCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPVariantCode(String value) {
        this.pVariantCode = value;
    }

    /**
     * Obtiene el valor de la propiedad pLocationCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPLocationCode() {
        return pLocationCode;
    }

    /**
     * Define el valor de la propiedad pLocationCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPLocationCode(String value) {
        this.pLocationCode = value;
    }

    /**
     * Obtiene el valor de la propiedad pLotNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPLotNo() {
        return pLotNo;
    }

    /**
     * Define el valor de la propiedad pLotNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPLotNo(String value) {
        this.pLotNo = value;
    }

    /**
     * Obtiene el valor de la propiedad pQuantity.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPQuantity() {
        return pQuantity;
    }

    /**
     * Define el valor de la propiedad pQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPQuantity(BigInteger value) {
        this.pQuantity = value;
    }

}
