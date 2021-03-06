
package com.dynamics.webServices.Item_Card;

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
 *         &lt;element name="Item_Card" type="{urn:microsoft-dynamics-schemas/page/item_card}Item_Card" minOccurs="0"/>
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
    "itemCard"
})
@XmlRootElement(name = "Read_Result")
public class ReadResult {

    @XmlElement(name = "Item_Card")
    protected ItemCard itemCard;

    /**
     * Obtiene el valor de la propiedad itemCard.
     * 
     * @return
     *     possible object is
     *     {@link ItemCard }
     *     
     */
    public ItemCard getItemCard() {
        return itemCard;
    }

    /**
     * Define el valor de la propiedad itemCard.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemCard }
     *     
     */
    public void setItemCard(ItemCard value) {
        this.itemCard = value;
    }

}
