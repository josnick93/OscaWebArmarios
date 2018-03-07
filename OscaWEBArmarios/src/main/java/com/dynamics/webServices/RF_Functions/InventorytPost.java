
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
    "parBatch"
})
@XmlRootElement(name = "InventorytPost")
public class InventorytPost {

    @XmlElement(required = true)
    protected String parTemplate;
    @XmlElement(required = true)
    protected String parBatch;

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

}
