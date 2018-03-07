
package com.dynamics.webServices.RF_Functions;

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
 *         &lt;element name="parItemNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parVariantCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parBinCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "parItemNo",
    "parVariantCode",
    "parBinCode"
})
@XmlRootElement(name = "GetBinUOM")
public class GetBinUOM {

    @XmlElement(required = true)
    protected String parLocation;
    @XmlElement(required = true)
    protected String parItemNo;
    @XmlElement(required = true)
    protected String parVariantCode;
    @XmlElement(required = true)
    protected String parBinCode;

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
     * Obtiene el valor de la propiedad parBinCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParBinCode() {
        return parBinCode;
    }

    /**
     * Define el valor de la propiedad parBinCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParBinCode(String value) {
        this.parBinCode = value;
    }

}
