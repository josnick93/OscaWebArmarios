
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
 *         &lt;element name="Bin_WS" type="{urn:microsoft-dynamics-schemas/page/bin_ws}Bin_WS" minOccurs="0"/>
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
    "binWS"
})
@XmlRootElement(name = "Read_Result")
public class ReadResult {

    @XmlElement(name = "Bin_WS")
    protected BinWS binWS;

    /**
     * Obtiene el valor de la propiedad binWS.
     * 
     * @return
     *     possible object is
     *     {@link BinWS }
     *     
     */
    public BinWS getBinWS() {
        return binWS;
    }

    /**
     * Define el valor de la propiedad binWS.
     * 
     * @param value
     *     allowed object is
     *     {@link BinWS }
     *     
     */
    public void setBinWS(BinWS value) {
        this.binWS = value;
    }

}
