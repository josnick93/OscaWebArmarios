
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
 *         &lt;element name="Item_Card_List" type="{urn:microsoft-dynamics-schemas/page/item_card}Item_Card_List"/>
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
    "itemCardList"
})
@XmlRootElement(name = "CreateMultiple")
public class CreateMultiple {

    @XmlElement(name = "Item_Card_List", required = true)
    protected ItemCardList itemCardList;

    /**
     * Obtiene el valor de la propiedad itemCardList.
     * 
     * @return
     *     possible object is
     *     {@link ItemCardList }
     *     
     */
    public ItemCardList getItemCardList() {
        return itemCardList;
    }

    /**
     * Define el valor de la propiedad itemCardList.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemCardList }
     *     
     */
    public void setItemCardList(ItemCardList value) {
        this.itemCardList = value;
    }

}
