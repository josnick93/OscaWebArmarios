
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
 *         &lt;element name="parTemplate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parBatch" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parLocation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parItem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parVariant" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parLot" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parBin" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "parTemplate",
    "parBatch",
    "parLocation",
    "parItem",
    "parVariant",
    "parLot",
    "parBin"
})
@XmlRootElement(name = "CreateInventoryLine")
public class CreateInventoryLine {

    @XmlElement(required = true)
    protected String parTemplate;
    @XmlElement(required = true)
    protected String parBatch;
    @XmlElement(required = true)
    protected String parLocation;
    @XmlElement(required = true)
    protected String parItem;
    @XmlElement(required = true)
    protected String parVariant;
    @XmlElement(required = true)
    protected String parLot;
    @XmlElement(required = true)
    protected String parBin;

    /**
     * Obtiene el valor de la propiedad parTemplate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParTemplate() {
        return parTemplate;
    }

    /**
     * Define el valor de la propiedad parTemplate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParTemplate(String value) {
        this.parTemplate = value;
    }

    /**
     * Obtiene el valor de la propiedad parBatch.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParBatch() {
        return parBatch;
    }

    /**
     * Define el valor de la propiedad parBatch.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParBatch(String value) {
        this.parBatch = value;
    }

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
     * Obtiene el valor de la propiedad parItem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParItem() {
        return parItem;
    }

    /**
     * Define el valor de la propiedad parItem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParItem(String value) {
        this.parItem = value;
    }

    /**
     * Obtiene el valor de la propiedad parVariant.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParVariant() {
        return parVariant;
    }

    /**
     * Define el valor de la propiedad parVariant.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParVariant(String value) {
        this.parVariant = value;
    }

    /**
     * Obtiene el valor de la propiedad parLot.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParLot() {
        return parLot;
    }

    /**
     * Define el valor de la propiedad parLot.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParLot(String value) {
        this.parLot = value;
    }

    /**
     * Obtiene el valor de la propiedad parBin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParBin() {
        return parBin;
    }

    /**
     * Define el valor de la propiedad parBin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParBin(String value) {
        this.parBin = value;
    }

}
