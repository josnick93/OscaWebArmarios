
package com.dynamics.webServices.WS_Whse_Worksheet_Line;

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
 *         &lt;element name="WS_Whse_Worksheet_Line_List" type="{urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line}WS_Whse_Worksheet_Line_List"/>
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
    "wsWhseWorksheetLineList"
})
@XmlRootElement(name = "CreateMultiple")
public class CreateMultiple {

    @XmlElement(name = "WS_Whse_Worksheet_Line_List", required = true)
    protected WSWhseWorksheetLineList wsWhseWorksheetLineList;

    /**
     * Obtiene el valor de la propiedad wsWhseWorksheetLineList.
     * 
     * @return
     *     possible object is
     *     {@link WSWhseWorksheetLineList }
     *     
     */
    public WSWhseWorksheetLineList getWSWhseWorksheetLineList() {
        return wsWhseWorksheetLineList;
    }

    /**
     * Define el valor de la propiedad wsWhseWorksheetLineList.
     * 
     * @param value
     *     allowed object is
     *     {@link WSWhseWorksheetLineList }
     *     
     */
    public void setWSWhseWorksheetLineList(WSWhseWorksheetLineList value) {
        this.wsWhseWorksheetLineList = value;
    }

}
