
package com.dynamics.webServices.Bin_Content_WS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Bin_Content_WS_List complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Bin_Content_WS_List">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bin_Content_WS" type="{urn:microsoft-dynamics-schemas/page/bin_content_ws}Bin_Content_WS" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bin_Content_WS_List", propOrder = {
    "binContentWS"
})
public class BinContentWSList {

    @XmlElement(name = "Bin_Content_WS", required = true)
    protected List<BinContentWS> binContentWS;

    /**
     * Gets the value of the binContentWS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the binContentWS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBinContentWS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BinContentWS }
     * 
     * 
     */
    public List<BinContentWS> getBinContentWS() {
        if (binContentWS == null) {
            binContentWS = new ArrayList<BinContentWS>();
        }
        return this.binContentWS;
    }

}
