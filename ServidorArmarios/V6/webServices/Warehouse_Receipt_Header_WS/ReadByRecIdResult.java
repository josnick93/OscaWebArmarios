
package com.dynamics.webServices.Warehouse_Receipt_Header_WS;

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
 *         &lt;element name="Warehouse_Receipt_Header_WS" type="{urn:microsoft-dynamics-schemas/page/warehouse_receipt_header_ws}Warehouse_Receipt_Header_WS" minOccurs="0"/>
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
    "warehouseReceiptHeaderWS"
})
@XmlRootElement(name = "ReadByRecId_Result")
public class ReadByRecIdResult {

    @XmlElement(name = "Warehouse_Receipt_Header_WS")
    protected WarehouseReceiptHeaderWS warehouseReceiptHeaderWS;

    /**
     * Obtiene el valor de la propiedad warehouseReceiptHeaderWS.
     * 
     * @return
     *     possible object is
     *     {@link WarehouseReceiptHeaderWS }
     *     
     */
    public WarehouseReceiptHeaderWS getWarehouseReceiptHeaderWS() {
        return warehouseReceiptHeaderWS;
    }

    /**
     * Define el valor de la propiedad warehouseReceiptHeaderWS.
     * 
     * @param value
     *     allowed object is
     *     {@link WarehouseReceiptHeaderWS }
     *     
     */
    public void setWarehouseReceiptHeaderWS(WarehouseReceiptHeaderWS value) {
        this.warehouseReceiptHeaderWS = value;
    }

}
