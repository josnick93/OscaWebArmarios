
package com.dynamics.webServices.Warehouse_Shipment_Line_WS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Warehouse_Shipment_Line_WS_List complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Warehouse_Shipment_Line_WS_List">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Warehouse_Shipment_Line_WS" type="{urn:microsoft-dynamics-schemas/page/warehouse_shipment_line_ws}Warehouse_Shipment_Line_WS" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Warehouse_Shipment_Line_WS_List", propOrder = {
    "warehouseShipmentLineWS"
})
public class WarehouseShipmentLineWSList {

    @XmlElement(name = "Warehouse_Shipment_Line_WS", required = true)
    protected List<WarehouseShipmentLineWS> warehouseShipmentLineWS;

    /**
     * Gets the value of the warehouseShipmentLineWS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the warehouseShipmentLineWS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWarehouseShipmentLineWS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WarehouseShipmentLineWS }
     * 
     * 
     */
    public List<WarehouseShipmentLineWS> getWarehouseShipmentLineWS() {
        if (warehouseShipmentLineWS == null) {
            warehouseShipmentLineWS = new ArrayList<WarehouseShipmentLineWS>();
        }
        return this.warehouseShipmentLineWS;
    }

}
