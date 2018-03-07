
package com.dynamics.webServices.Warehouse_Activity_Header_WS;

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
 *         &lt;element name="recId" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "recId"
})
@XmlRootElement(name = "ReadByRecId")
public class ReadByRecId {

    @XmlElement(required = true)
    protected String recId;

    /**
     * Obtiene el valor de la propiedad recId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecId() {
        return recId;
    }

    /**
     * Define el valor de la propiedad recId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecId(String value) {
        this.recId = value;
    }

}
