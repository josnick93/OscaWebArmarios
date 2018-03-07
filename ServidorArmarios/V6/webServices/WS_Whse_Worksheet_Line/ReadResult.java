
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
 *         &lt;element name="WS_Whse_Worksheet_Line" type="{urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line}WS_Whse_Worksheet_Line" minOccurs="0"/>
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
    "wsWhseWorksheetLine"
})
@XmlRootElement(name = "Read_Result")
public class ReadResult {

    @XmlElement(name = "WS_Whse_Worksheet_Line")
    protected WSWhseWorksheetLine wsWhseWorksheetLine;

    /**
     * Obtiene el valor de la propiedad wsWhseWorksheetLine.
     * 
     * @return
     *     possible object is
     *     {@link WSWhseWorksheetLine }
     *     
     */
    public WSWhseWorksheetLine getWSWhseWorksheetLine() {
        return wsWhseWorksheetLine;
    }

    /**
     * Define el valor de la propiedad wsWhseWorksheetLine.
     * 
     * @param value
     *     allowed object is
     *     {@link WSWhseWorksheetLine }
     *     
     */
    public void setWSWhseWorksheetLine(WSWhseWorksheetLine value) {
        this.wsWhseWorksheetLine = value;
    }

}
