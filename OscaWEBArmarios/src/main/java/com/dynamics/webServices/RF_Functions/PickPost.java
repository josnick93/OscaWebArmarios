
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
 *         &lt;element name="parPickNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "parPickNo"
})
@XmlRootElement(name = "PickPost")
public class PickPost {

    @XmlElement(required = true)
    protected String parPickNo;

    /**
     * Obtiene el valor de la propiedad parPickNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParPickNo() {
        return parPickNo;
    }

    /**
     * Define el valor de la propiedad parPickNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParPickNo(String value) {
        this.parPickNo = value;
    }

}
