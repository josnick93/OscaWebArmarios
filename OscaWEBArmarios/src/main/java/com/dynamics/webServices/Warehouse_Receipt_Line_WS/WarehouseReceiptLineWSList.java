
package com.dynamics.webServices.Warehouse_Receipt_Line_WS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Warehouse_Receipt_Line_WS_List complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Warehouse_Receipt_Line_WS_List">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Warehouse_Receipt_Line_WS" type="{urn:microsoft-dynamics-schemas/page/warehouse_receipt_line_ws}Warehouse_Receipt_Line_WS" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Warehouse_Receipt_Line_WS_List", propOrder = {
    "warehouseReceiptLineWS"
})
public class WarehouseReceiptLineWSList {

    @XmlElement(name = "Warehouse_Receipt_Line_WS", required = true)
    protected List<WarehouseReceiptLineWS> warehouseReceiptLineWS;

    /**
     * Gets the value of the warehouseReceiptLineWS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the warehouseReceiptLineWS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWarehouseReceiptLineWS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WarehouseReceiptLineWS }
     * 
     * 
     */
    public List<WarehouseReceiptLineWS> getWarehouseReceiptLineWS() {
        if (warehouseReceiptLineWS == null) {
            warehouseReceiptLineWS = new ArrayList<WarehouseReceiptLineWS>();
        }
        return this.warehouseReceiptLineWS;
    }

}
