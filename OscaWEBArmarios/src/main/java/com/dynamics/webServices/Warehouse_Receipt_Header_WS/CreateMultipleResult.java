
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
 *         &lt;element name="Warehouse_Receipt_Header_WS_List" type="{urn:microsoft-dynamics-schemas/page/warehouse_receipt_header_ws}Warehouse_Receipt_Header_WS_List"/>
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
    "warehouseReceiptHeaderWSList"
})
@XmlRootElement(name = "CreateMultiple_Result")
public class CreateMultipleResult {

    @XmlElement(name = "Warehouse_Receipt_Header_WS_List", required = true)
    protected WarehouseReceiptHeaderWSList warehouseReceiptHeaderWSList;

    /**
     * Obtiene el valor de la propiedad warehouseReceiptHeaderWSList.
     * 
     * @return
     *     possible object is
     *     {@link WarehouseReceiptHeaderWSList }
     *     
     */
    public WarehouseReceiptHeaderWSList getWarehouseReceiptHeaderWSList() {
        return warehouseReceiptHeaderWSList;
    }

    /**
     * Define el valor de la propiedad warehouseReceiptHeaderWSList.
     * 
     * @param value
     *     allowed object is
     *     {@link WarehouseReceiptHeaderWSList }
     *     
     */
    public void setWarehouseReceiptHeaderWSList(WarehouseReceiptHeaderWSList value) {
        this.warehouseReceiptHeaderWSList = value;
    }

}
