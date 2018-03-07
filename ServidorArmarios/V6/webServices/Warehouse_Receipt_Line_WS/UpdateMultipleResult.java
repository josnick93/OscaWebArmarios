
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
 *         &lt;element name="Warehouse_Receipt_Line_WS_List" type="{urn:microsoft-dynamics-schemas/page/warehouse_receipt_line_ws}Warehouse_Receipt_Line_WS_List"/>
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
    "warehouseReceiptLineWSList"
})
@XmlRootElement(name = "UpdateMultiple_Result")
public class UpdateMultipleResult {

    @XmlElement(name = "Warehouse_Receipt_Line_WS_List", required = true)
    protected WarehouseReceiptLineWSList warehouseReceiptLineWSList;

    /**
     * Obtiene el valor de la propiedad warehouseReceiptLineWSList.
     * 
     * @return
     *     possible object is
     *     {@link WarehouseReceiptLineWSList }
     *     
     */
    public WarehouseReceiptLineWSList getWarehouseReceiptLineWSList() {
        return warehouseReceiptLineWSList;
    }

    /**
     * Define el valor de la propiedad warehouseReceiptLineWSList.
     * 
     * @param value
     *     allowed object is
     *     {@link WarehouseReceiptLineWSList }
     *     
     */
    public void setWarehouseReceiptLineWSList(WarehouseReceiptLineWSList value) {
        this.warehouseReceiptLineWSList = value;
    }

}
