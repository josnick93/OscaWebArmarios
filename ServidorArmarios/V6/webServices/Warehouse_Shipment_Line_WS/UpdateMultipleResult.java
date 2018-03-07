
package com.dynamics.webServices.Warehouse_Shipment_Line_WS;

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
 *         &lt;element name="Warehouse_Shipment_Line_WS_List" type="{urn:microsoft-dynamics-schemas/page/warehouse_shipment_line_ws}Warehouse_Shipment_Line_WS_List"/>
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
    "warehouseShipmentLineWSList"
})
@XmlRootElement(name = "UpdateMultiple_Result")
public class UpdateMultipleResult {

    @XmlElement(name = "Warehouse_Shipment_Line_WS_List", required = true)
    protected WarehouseShipmentLineWSList warehouseShipmentLineWSList;

    /**
     * Obtiene el valor de la propiedad warehouseShipmentLineWSList.
     * 
     * @return
     *     possible object is
     *     {@link WarehouseShipmentLineWSList }
     *     
     */
    public WarehouseShipmentLineWSList getWarehouseShipmentLineWSList() {
        return warehouseShipmentLineWSList;
    }

    /**
     * Define el valor de la propiedad warehouseShipmentLineWSList.
     * 
     * @param value
     *     allowed object is
     *     {@link WarehouseShipmentLineWSList }
     *     
     */
    public void setWarehouseShipmentLineWSList(WarehouseShipmentLineWSList value) {
        this.warehouseShipmentLineWSList = value;
    }

}
