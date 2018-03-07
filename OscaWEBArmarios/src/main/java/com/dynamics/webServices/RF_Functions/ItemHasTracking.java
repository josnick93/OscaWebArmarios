
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
 *         &lt;element name="parItem" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "parItem"
})
@XmlRootElement(name = "ItemHasTracking")
public class ItemHasTracking {

    @XmlElement(required = true)
    protected String parItem;

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

}
