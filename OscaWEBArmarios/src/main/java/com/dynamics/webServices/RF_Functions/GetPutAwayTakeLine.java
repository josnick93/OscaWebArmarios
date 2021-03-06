
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
 *         &lt;element name="parPutAwayNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parLineNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "parPutAwayNo",
    "parLineNo"
})
@XmlRootElement(name = "GetPutAwayTakeLine")
public class GetPutAwayTakeLine {

    @XmlElement(required = true)
    protected String parPutAwayNo;
    protected int parLineNo;

    /**
     * Obtiene el valor de la propiedad parPutAwayNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParPutAwayNo() {
        return parPutAwayNo;
    }

    /**
     * Define el valor de la propiedad parPutAwayNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParPutAwayNo(String value) {
        this.parPutAwayNo = value;
    }

    /**
     * Obtiene el valor de la propiedad parLineNo.
     * 
     */
    public int getParLineNo() {
        return parLineNo;
    }

    /**
     * Define el valor de la propiedad parLineNo.
     * 
     */
    public void setParLineNo(int value) {
        this.parLineNo = value;
    }

}
