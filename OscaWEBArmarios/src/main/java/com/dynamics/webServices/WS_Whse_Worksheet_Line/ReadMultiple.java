
package com.dynamics.webServices.WS_Whse_Worksheet_Line;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="filter" type="{urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line}WS_Whse_Worksheet_Line_Filter" maxOccurs="unbounded"/>
 *         &lt;element name="bookmarkKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="setSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "filter",
    "bookmarkKey",
    "setSize"
})
@XmlRootElement(name = "ReadMultiple")
public class ReadMultiple {

    @XmlElement(required = true)
    protected List<WSWhseWorksheetLineFilter> filter;
    protected String bookmarkKey;
    protected int setSize;

    /**
     * Gets the value of the filter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WSWhseWorksheetLineFilter }
     * 
     * 
     */
    public List<WSWhseWorksheetLineFilter> getFilter() {
        if (filter == null) {
            filter = new ArrayList<WSWhseWorksheetLineFilter>();
        }
        return this.filter;
    }

    /**
     * Obtiene el valor de la propiedad bookmarkKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookmarkKey() {
        return bookmarkKey;
    }

    /**
     * Define el valor de la propiedad bookmarkKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookmarkKey(String value) {
        this.bookmarkKey = value;
    }

    /**
     * Obtiene el valor de la propiedad setSize.
     * 
     */
    public int getSetSize() {
        return setSize;
    }

    /**
     * Define el valor de la propiedad setSize.
     * 
     */
    public void setSetSize(int value) {
        this.setSize = value;
    }

}
