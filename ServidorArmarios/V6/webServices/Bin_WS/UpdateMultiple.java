
package com.dynamics.webServices.Bin_WS;

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
 *         &lt;element name="Bin_WS_List" type="{urn:microsoft-dynamics-schemas/page/bin_ws}Bin_WS_List"/>
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
    "binWSList"
})
@XmlRootElement(name = "UpdateMultiple")
public class UpdateMultiple {

    @XmlElement(name = "Bin_WS_List", required = true)
    protected BinWSList binWSList;

    /**
     * Obtiene el valor de la propiedad binWSList.
     * 
     * @return
     *     possible object is
     *     {@link BinWSList }
     *     
     */
    public BinWSList getBinWSList() {
        return binWSList;
    }

    /**
     * Define el valor de la propiedad binWSList.
     * 
     * @param value
     *     allowed object is
     *     {@link BinWSList }
     *     
     */
    public void setBinWSList(BinWSList value) {
        this.binWSList = value;
    }

}
