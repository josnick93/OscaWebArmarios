
package com.dynamics.webServices.Prod_Order_Component_WS;

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
 *         &lt;element name="IsUpdated_Result" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "isUpdatedResult"
})
@XmlRootElement(name = "IsUpdated_Result")
public class IsUpdatedResult {

    @XmlElement(name = "IsUpdated_Result")
    protected boolean isUpdatedResult;

    /**
     * Obtiene el valor de la propiedad isUpdatedResult.
     * 
     */
    public boolean isIsUpdatedResult() {
        return isUpdatedResult;
    }

    /**
     * Define el valor de la propiedad isUpdatedResult.
     * 
     */
    public void setIsUpdatedResult(boolean value) {
        this.isUpdatedResult = value;
    }

}
