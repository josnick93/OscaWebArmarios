
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
 *         &lt;element name="ReadMultiple_Result" type="{urn:microsoft-dynamics-schemas/page/prod_order_component_ws}Prod_Order_Component_WS_List" minOccurs="0"/>
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
    "readMultipleResult"
})
@XmlRootElement(name = "ReadMultiple_Result")
public class ReadMultipleResult {

    @XmlElement(name = "ReadMultiple_Result")
    protected ProdOrderComponentWSList readMultipleResult;

    /**
     * Obtiene el valor de la propiedad readMultipleResult.
     * 
     * @return
     *     possible object is
     *     {@link ProdOrderComponentWSList }
     *     
     */
    public ProdOrderComponentWSList getReadMultipleResult() {
        return readMultipleResult;
    }

    /**
     * Define el valor de la propiedad readMultipleResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ProdOrderComponentWSList }
     *     
     */
    public void setReadMultipleResult(ProdOrderComponentWSList value) {
        this.readMultipleResult = value;
    }

}
