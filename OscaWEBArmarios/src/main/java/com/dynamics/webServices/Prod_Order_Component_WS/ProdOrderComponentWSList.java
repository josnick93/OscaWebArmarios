
package com.dynamics.webServices.Prod_Order_Component_WS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Prod_Order_Component_WS_List complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Prod_Order_Component_WS_List">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Prod_Order_Component_WS" type="{urn:microsoft-dynamics-schemas/page/prod_order_component_ws}Prod_Order_Component_WS" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Prod_Order_Component_WS_List", propOrder = {
    "prodOrderComponentWS"
})
public class ProdOrderComponentWSList {

    @XmlElement(name = "Prod_Order_Component_WS", required = true)
    protected List<ProdOrderComponentWS> prodOrderComponentWS;

    /**
     * Gets the value of the prodOrderComponentWS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prodOrderComponentWS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProdOrderComponentWS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProdOrderComponentWS }
     * 
     * 
     */
    public List<ProdOrderComponentWS> getProdOrderComponentWS() {
        if (prodOrderComponentWS == null) {
            prodOrderComponentWS = new ArrayList<ProdOrderComponentWS>();
        }
        return this.prodOrderComponentWS;
    }

}
