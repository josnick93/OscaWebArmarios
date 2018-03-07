
package com.dynamics.webServices.Item_Card_WS;

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
 *         &lt;element name="Item_Card_WS_List" type="{urn:microsoft-dynamics-schemas/page/item_card_ws}Item_Card_WS_List"/>
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
    "itemCardWSList"
})
@XmlRootElement(name = "UpdateMultiple_Result")
public class UpdateMultipleResult {

    @XmlElement(name = "Item_Card_WS_List", required = true)
    protected ItemCardWSList itemCardWSList;

    /**
     * Obtiene el valor de la propiedad itemCardWSList.
     * 
     * @return
     *     possible object is
     *     {@link ItemCardWSList }
     *     
     */
    public ItemCardWSList getItemCardWSList() {
        return itemCardWSList;
    }

    /**
     * Define el valor de la propiedad itemCardWSList.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemCardWSList }
     *     
     */
    public void setItemCardWSList(ItemCardWSList value) {
        this.itemCardWSList = value;
    }

}
