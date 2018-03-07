
package com.dynamics.webServices.Warehouse_Receipt_Line_WS;

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
 *         &lt;element name="Warehouse_Receipt_Line_WS" type="{urn:microsoft-dynamics-schemas/page/warehouse_receipt_line_ws}Warehouse_Receipt_Line_WS"/>
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
    "warehouseReceiptLineWS"
})
@XmlRootElement(name = "Create")
public class Create {

    @XmlElement(name = "Warehouse_Receipt_Line_WS", required = true)
    protected WarehouseReceiptLineWS warehouseReceiptLineWS;

    /**
     * Obtiene el valor de la propiedad warehouseReceiptLineWS.
     * 
     * @return
     *     possible object is
     *     {@link WarehouseReceiptLineWS }
     *     
     */
    public WarehouseReceiptLineWS getWarehouseReceiptLineWS() {
        return warehouseReceiptLineWS;
    }

    /**
     * Define el valor de la propiedad warehouseReceiptLineWS.
     * 
     * @param value
     *     allowed object is
     *     {@link WarehouseReceiptLineWS }
     *     
     */
    public void setWarehouseReceiptLineWS(WarehouseReceiptLineWS value) {
        this.warehouseReceiptLineWS = value;
    }

}
