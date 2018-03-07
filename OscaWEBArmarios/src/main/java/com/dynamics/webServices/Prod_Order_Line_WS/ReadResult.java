
package com.dynamics.webServices.Prod_Order_Line_WS;

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
 *         &lt;element name="Prod_Order_Line_WS" type="{urn:microsoft-dynamics-schemas/page/prod_order_line_ws}Prod_Order_Line_WS" minOccurs="0"/>
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
    "prodOrderLineWS"
})
@XmlRootElement(name = "Read_Result")
public class ReadResult {

    @XmlElement(name = "Prod_Order_Line_WS")
    protected ProdOrderLineWS prodOrderLineWS;

    /**
     * Obtiene el valor de la propiedad prodOrderLineWS.
     * 
     * @return
     *     possible object is
     *     {@link ProdOrderLineWS }
     *     
     */
    public ProdOrderLineWS getProdOrderLineWS() {
        return prodOrderLineWS;
    }

    /**
     * Define el valor de la propiedad prodOrderLineWS.
     * 
     * @param value
     *     allowed object is
     *     {@link ProdOrderLineWS }
     *     
     */
    public void setProdOrderLineWS(ProdOrderLineWS value) {
        this.prodOrderLineWS = value;
    }

}
