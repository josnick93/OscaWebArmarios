
package com.dynamics.webServices.Warehouse_Shipment_Header_WS;

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
 *         &lt;element name="Warehouse_Shipment_Header_WS_List" type="{urn:microsoft-dynamics-schemas/page/warehouse_shipment_header_ws}Warehouse_Shipment_Header_WS_List"/>
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
    "warehouseShipmentHeaderWSList"
})
@XmlRootElement(name = "CreateMultiple_Result")
public class CreateMultipleResult {

    @XmlElement(name = "Warehouse_Shipment_Header_WS_List", required = true)
    protected WarehouseShipmentHeaderWSList warehouseShipmentHeaderWSList;

    /**
     * Obtiene el valor de la propiedad warehouseShipmentHeaderWSList.
     * 
     * @return
     *     possible object is
     *     {@link WarehouseShipmentHeaderWSList }
     *     
     */
    public WarehouseShipmentHeaderWSList getWarehouseShipmentHeaderWSList() {
        return warehouseShipmentHeaderWSList;
    }

    /**
     * Define el valor de la propiedad warehouseShipmentHeaderWSList.
     * 
     * @param value
     *     allowed object is
     *     {@link WarehouseShipmentHeaderWSList }
     *     
     */
    public void setWarehouseShipmentHeaderWSList(WarehouseShipmentHeaderWSList value) {
        this.warehouseShipmentHeaderWSList = value;
    }

}
