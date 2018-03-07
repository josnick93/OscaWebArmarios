
package com.dynamics.webServices.WS_Whse_Worksheet_Line;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para WS_Whse_Worksheet_Line_List complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="WS_Whse_Worksheet_Line_List">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WS_Whse_Worksheet_Line" type="{urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line}WS_Whse_Worksheet_Line" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WS_Whse_Worksheet_Line_List", propOrder = {
    "wsWhseWorksheetLine"
})
public class WSWhseWorksheetLineList {

    @XmlElement(name = "WS_Whse_Worksheet_Line", required = true)
    protected List<WSWhseWorksheetLine> wsWhseWorksheetLine;

    /**
     * Gets the value of the wsWhseWorksheetLine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wsWhseWorksheetLine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWSWhseWorksheetLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WSWhseWorksheetLine }
     * 
     * 
     */
    public List<WSWhseWorksheetLine> getWSWhseWorksheetLine() {
        if (wsWhseWorksheetLine == null) {
            wsWhseWorksheetLine = new ArrayList<WSWhseWorksheetLine>();
        }
        return this.wsWhseWorksheetLine;
    }

}
