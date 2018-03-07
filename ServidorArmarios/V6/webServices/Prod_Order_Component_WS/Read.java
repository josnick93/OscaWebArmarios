
package com.dynamics.webServices.Prod_Order_Component_WS;

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
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Prod_Order_No" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Prod_Order_Line_No" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "status",
    "prodOrderNo",
    "prodOrderLineNo"
})
@XmlRootElement(name = "Read")
public class Read {

    @XmlElement(name = "Status", required = true)
    protected String status;
    @XmlElement(name = "Prod_Order_No", required = true)
    protected String prodOrderNo;
    @XmlElement(name = "Prod_Order_Line_No")
    protected int prodOrderLineNo;

    /**
     * Obtiene el valor de la propiedad status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Obtiene el valor de la propiedad prodOrderNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProdOrderNo() {
        return prodOrderNo;
    }

    /**
     * Define el valor de la propiedad prodOrderNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProdOrderNo(String value) {
        this.prodOrderNo = value;
    }

    /**
     * Obtiene el valor de la propiedad prodOrderLineNo.
     * 
     */
    public int getProdOrderLineNo() {
        return prodOrderLineNo;
    }

    /**
     * Define el valor de la propiedad prodOrderLineNo.
     * 
     */
    public void setProdOrderLineNo(int value) {
        this.prodOrderLineNo = value;
    }

}
