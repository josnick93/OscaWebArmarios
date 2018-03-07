
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
 *         &lt;element name="Prod_Order_Component_WS" type="{urn:microsoft-dynamics-schemas/page/prod_order_component_ws}Prod_Order_Component_WS" minOccurs="0"/>
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
    "prodOrderComponentWS"
})
@XmlRootElement(name = "ReadByRecId_Result")
public class ReadByRecIdResult {

    @XmlElement(name = "Prod_Order_Component_WS")
    protected ProdOrderComponentWS prodOrderComponentWS;

    /**
     * Obtiene el valor de la propiedad prodOrderComponentWS.
     * 
     * @return
     *     possible object is
     *     {@link ProdOrderComponentWS }
     *     
     */
    public ProdOrderComponentWS getProdOrderComponentWS() {
        return prodOrderComponentWS;
    }

    /**
     * Define el valor de la propiedad prodOrderComponentWS.
     * 
     * @param value
     *     allowed object is
     *     {@link ProdOrderComponentWS }
     *     
     */
    public void setProdOrderComponentWS(ProdOrderComponentWS value) {
        this.prodOrderComponentWS = value;
    }

}
