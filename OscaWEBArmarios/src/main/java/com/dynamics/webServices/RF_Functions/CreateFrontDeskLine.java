
package com.dynamics.webServices.RF_Functions;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


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
 *         &lt;element name="ps_OrderNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ps_No" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ps_BinCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pn_Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
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
    "psOrderNo",
    "psNo",
    "psBinCode",
    "pnQuantity"
})
@XmlRootElement(name = "CreateFrontDeskLine")
public class CreateFrontDeskLine {

    @XmlElement(name = "ps_OrderNo", required = true)
    protected String psOrderNo;
    @XmlElement(name = "ps_No", required = true)
    protected String psNo;
    @XmlElement(name = "ps_BinCode", required = true)
    protected String psBinCode;
    @XmlElement(name = "pn_Quantity", required = true)
    protected BigInteger pnQuantity;

    /**
     * Obtiene el valor de la propiedad psOrderNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsOrderNo() {
        return psOrderNo;
    }

    /**
     * Define el valor de la propiedad psOrderNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsOrderNo(String value) {
        this.psOrderNo = value;
    }

    /**
     * Obtiene el valor de la propiedad psNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsNo() {
        return psNo;
    }

    /**
     * Define el valor de la propiedad psNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsNo(String value) {
        this.psNo = value;
    }

    /**
     * Obtiene el valor de la propiedad psBinCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsBinCode() {
        return psBinCode;
    }

    /**
     * Define el valor de la propiedad psBinCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsBinCode(String value) {
        this.psBinCode = value;
    }

    /**
     * Obtiene el valor de la propiedad pnQuantity.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPnQuantity() {
        return pnQuantity;
    }

    /**
     * Define el valor de la propiedad pnQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPnQuantity(BigInteger value) {
        this.pnQuantity = value;
    }

}
