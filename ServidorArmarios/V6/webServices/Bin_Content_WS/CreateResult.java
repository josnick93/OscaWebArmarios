
package com.dynamics.webServices.Bin_Content_WS;

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
 *         &lt;element name="Bin_Content_WS" type="{urn:microsoft-dynamics-schemas/page/bin_content_ws}Bin_Content_WS"/>
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
    "binContentWS"
})
@XmlRootElement(name = "Create_Result")
public class CreateResult {

    @XmlElement(name = "Bin_Content_WS", required = true)
    protected BinContentWS binContentWS;

    /**
     * Obtiene el valor de la propiedad binContentWS.
     * 
     * @return
     *     possible object is
     *     {@link BinContentWS }
     *     
     */
    public BinContentWS getBinContentWS() {
        return binContentWS;
    }

    /**
     * Define el valor de la propiedad binContentWS.
     * 
     * @param value
     *     allowed object is
     *     {@link BinContentWS }
     *     
     */
    public void setBinContentWS(BinContentWS value) {
        this.binContentWS = value;
    }

}
