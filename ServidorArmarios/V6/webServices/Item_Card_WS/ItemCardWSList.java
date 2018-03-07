
package com.dynamics.webServices.Item_Card_WS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Item_Card_WS_List complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Item_Card_WS_List">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Item_Card_WS" type="{urn:microsoft-dynamics-schemas/page/item_card_ws}Item_Card_WS" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Item_Card_WS_List", propOrder = {
    "itemCardWS"
})
public class ItemCardWSList {

    @XmlElement(name = "Item_Card_WS", required = true)
    protected List<ItemCardWS> itemCardWS;

    /**
     * Gets the value of the itemCardWS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemCardWS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemCardWS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemCardWS }
     * 
     * 
     */
    public List<ItemCardWS> getItemCardWS() {
        if (itemCardWS == null) {
            itemCardWS = new ArrayList<ItemCardWS>();
        }
        return this.itemCardWS;
    }

}
