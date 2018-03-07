
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
 *         &lt;element name="Item_Card_WS" type="{urn:microsoft-dynamics-schemas/page/item_card_ws}Item_Card_WS" minOccurs="0"/>
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
    "itemCardWS"
})
@XmlRootElement(name = "Read_Result")
public class ReadResult {

    @XmlElement(name = "Item_Card_WS")
    protected ItemCardWS itemCardWS;

    /**
     * Obtiene el valor de la propiedad itemCardWS.
     * 
     * @return
     *     possible object is
     *     {@link ItemCardWS }
     *     
     */
    public ItemCardWS getItemCardWS() {
        return itemCardWS;
    }

    /**
     * Define el valor de la propiedad itemCardWS.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemCardWS }
     *     
     */
    public void setItemCardWS(ItemCardWS value) {
        this.itemCardWS = value;
    }

}
