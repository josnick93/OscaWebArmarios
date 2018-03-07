
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
 *         &lt;element name="Production_Order_WS" type="{urn:microsoft-dynamics-schemas/page/production_order_ws}Production_Order_WS" minOccurs="0"/>
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
    "productionOrderWS"
})
@XmlRootElement(name = "ReadByRecId_Result")
public class ReadByRecIdResult {

    @XmlElement(name = "Production_Order_WS")
    protected ProductionOrderWS productionOrderWS;

    /**
     * Obtiene el valor de la propiedad productionOrderWS.
     * 
     * @return
     *     possible object is
     *     {@link ProductionOrderWS }
     *     
     */
    public ProductionOrderWS getProductionOrderWS() {
        return productionOrderWS;
    }

    /**
     * Define el valor de la propiedad productionOrderWS.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductionOrderWS }
     *     
     */
    public void setProductionOrderWS(ProductionOrderWS value) {
        this.productionOrderWS = value;
    }

}