
package com.dynamics.webServices.Item_Card;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Item_Card_List complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Item_Card_List">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Item_Card" type="{urn:microsoft-dynamics-schemas/page/item_card}Item_Card" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Item_Card_List", propOrder = {
    "itemCard"
})
public class ItemCardList {

    @XmlElement(name = "Item_Card", required = true)
    protected List<ItemCard> itemCard;

    /**
     * Gets the value of the itemCard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemCard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemCard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemCard }
     * 
     * 
     */
    public List<ItemCard> getItemCard() {
        if (itemCard == null) {
            itemCard = new ArrayList<ItemCard>();
        }
        return this.itemCard;
    }

}
