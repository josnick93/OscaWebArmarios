
package com.dynamics.webServices.Warehouse_Shipment_Header_WS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Warehouse_Shipment_Header_WS_List complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Warehouse_Shipment_Header_WS_List">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Warehouse_Shipment_Header_WS" type="{urn:microsoft-dynamics-schemas/page/warehouse_shipment_header_ws}Warehouse_Shipment_Header_WS" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Warehouse_Shipment_Header_WS_List", propOrder = {
    "warehouseShipmentHeaderWS"
})
public class WarehouseShipmentHeaderWSList {

    @XmlElement(name = "Warehouse_Shipment_Header_WS", required = true)
    protected List<WarehouseShipmentHeaderWS> warehouseShipmentHeaderWS;

    /**
     * Gets the value of the warehouseShipmentHeaderWS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the warehouseShipmentHeaderWS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWarehouseShipmentHeaderWS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WarehouseShipmentHeaderWS }
     * 
     * 
     */
    public List<WarehouseShipmentHeaderWS> getWarehouseShipmentHeaderWS() {
        if (warehouseShipmentHeaderWS == null) {
            warehouseShipmentHeaderWS = new ArrayList<WarehouseShipmentHeaderWS>();
        }
        return this.warehouseShipmentHeaderWS;
    }

}
