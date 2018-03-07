
package com.dynamics.webServices.Production_Order_WS;

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
 *         &lt;element name="GetRecIdFromKey_Result" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "getRecIdFromKeyResult"
})
@XmlRootElement(name = "GetRecIdFromKey_Result")
public class GetRecIdFromKeyResult {

    @XmlElement(name = "GetRecIdFromKey_Result", required = true)
    protected String getRecIdFromKeyResult;

    /**
     * Obtiene el valor de la propiedad getRecIdFromKeyResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetRecIdFromKeyResult() {
        return getRecIdFromKeyResult;
    }

    /**
     * Define el valor de la propiedad getRecIdFromKeyResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetRecIdFromKeyResult(String value) {
        this.getRecIdFromKeyResult = value;
    }

}
