
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
 *         &lt;element name="Bin_Content_WS_List" type="{urn:microsoft-dynamics-schemas/page/bin_content_ws}Bin_Content_WS_List"/>
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
    "binContentWSList"
})
@XmlRootElement(name = "CreateMultiple_Result")
public class CreateMultipleResult {

    @XmlElement(name = "Bin_Content_WS_List", required = true)
    protected BinContentWSList binContentWSList;

    /**
     * Obtiene el valor de la propiedad binContentWSList.
     * 
     * @return
     *     possible object is
     *     {@link BinContentWSList }
     *     
     */
    public BinContentWSList getBinContentWSList() {
        return binContentWSList;
    }

    /**
     * Define el valor de la propiedad binContentWSList.
     * 
     * @param value
     *     allowed object is
     *     {@link BinContentWSList }
     *     
     */
    public void setBinContentWSList(BinContentWSList value) {
        this.binContentWSList = value;
    }

}
