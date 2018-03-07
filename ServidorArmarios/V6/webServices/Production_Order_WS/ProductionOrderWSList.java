
package com.dynamics.webServices.Production_Order_WS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Production_Order_WS_List complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Production_Order_WS_List">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Production_Order_WS" type="{urn:microsoft-dynamics-schemas/page/production_order_ws}Production_Order_WS" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Production_Order_WS_List", propOrder = {
    "productionOrderWS"
})
public class ProductionOrderWSList {

    @XmlElement(name = "Production_Order_WS", required = true)
    protected List<ProductionOrderWS> productionOrderWS;

    /**
     * Gets the value of the productionOrderWS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productionOrderWS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductionOrderWS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductionOrderWS }
     * 
     * 
     */
    public List<ProductionOrderWS> getProductionOrderWS() {
        if (productionOrderWS == null) {
            productionOrderWS = new ArrayList<ProductionOrderWS>();
        }
        return this.productionOrderWS;
    }

}
