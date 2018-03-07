
package com.dynamics.webServices.RF_Functions;

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
 *         &lt;element name="parShipmentNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parLineNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="parNewVariant" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "parShipmentNo",
    "parLineNo",
    "parNewVariant"
})
@XmlRootElement(name = "ShipmentLineChangeVariant")
public class ShipmentLineChangeVariant {

    @XmlElement(required = true)
    protected String parShipmentNo;
    protected int parLineNo;
    @XmlElement(required = true)
    protected String parNewVariant;

    /**
     * Obtiene el valor de la propiedad parShipmentNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParShipmentNo() {
        return parShipmentNo;
    }

    /**
     * Define el valor de la propiedad parShipmentNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParShipmentNo(String value) {
        this.parShipmentNo = value;
    }

    /**
     * Obtiene el valor de la propiedad parLineNo.
     * 
     */
    public int getParLineNo() {
        return parLineNo;
    }

    /**
     * Define el valor de la propiedad parLineNo.
     * 
     */
    public void setParLineNo(int value) {
        this.parLineNo = value;
    }

    /**
     * Obtiene el valor de la propiedad parNewVariant.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParNewVariant() {
        return parNewVariant;
    }

    /**
     * Define el valor de la propiedad parNewVariant.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParNewVariant(String value) {
        this.parNewVariant = value;
    }

}
