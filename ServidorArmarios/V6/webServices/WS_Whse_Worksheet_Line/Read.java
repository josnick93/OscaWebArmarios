
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
 *         &lt;element name="Worksheet_Template_Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Location_Code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Line_No" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "worksheetTemplateName",
    "name",
    "locationCode",
    "lineNo"
})
@XmlRootElement(name = "Read")
public class Read {

    @XmlElement(name = "Worksheet_Template_Name", required = true)
    protected String worksheetTemplateName;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Location_Code", required = true)
    protected String locationCode;
    @XmlElement(name = "Line_No")
    protected int lineNo;

    /**
     * Obtiene el valor de la propiedad worksheetTemplateName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorksheetTemplateName() {
        return worksheetTemplateName;
    }

    /**
     * Define el valor de la propiedad worksheetTemplateName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorksheetTemplateName(String value) {
        this.worksheetTemplateName = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad locationCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationCode() {
        return locationCode;
    }

    /**
     * Define el valor de la propiedad locationCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationCode(String value) {
        this.locationCode = value;
    }

    /**
     * Obtiene el valor de la propiedad lineNo.
     * 
     */
    public int getLineNo() {
        return lineNo;
    }

    /**
     * Define el valor de la propiedad lineNo.
     * 
     */
    public void setLineNo(int value) {
        this.lineNo = value;
    }

}
