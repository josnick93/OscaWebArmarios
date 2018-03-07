
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
 *         &lt;element name="Warehouse_Shipment_Line_WS" type="{urn:microsoft-dynamics-schemas/page/warehouse_shipment_line_ws}Warehouse_Shipment_Line_WS" minOccurs="0"/>
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
    "warehouseShipmentLineWS"
})
@XmlRootElement(name = "Read_Result")
public class ReadResult {

    @XmlElement(name = "Warehouse_Shipment_Line_WS")
    protected WarehouseShipmentLineWS warehouseShipmentLineWS;

    /**
     * Obtiene el valor de la propiedad warehouseShipmentLineWS.
     * 
     * @return
     *     possible object is
     *     {@link WarehouseShipmentLineWS }
     *     
     */
    public WarehouseShipmentLineWS getWarehouseShipmentLineWS() {
        return warehouseShipmentLineWS;
    }

    /**
     * Define el valor de la propiedad warehouseShipmentLineWS.
     * 
     * @param value
     *     allowed object is
     *     {@link WarehouseShipmentLineWS }
     *     
     */
    public void setWarehouseShipmentLineWS(WarehouseShipmentLineWS value) {
        this.warehouseShipmentLineWS = value;
    }

}
