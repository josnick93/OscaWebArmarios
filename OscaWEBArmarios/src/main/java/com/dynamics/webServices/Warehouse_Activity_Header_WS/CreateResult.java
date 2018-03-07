
package com.dynamics.webServices.Warehouse_Activity_Header_WS;

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
 *         &lt;element name="Warehouse_Activity_Header_WS" type="{urn:microsoft-dynamics-schemas/page/warehouse_activity_header_ws}Warehouse_Activity_Header_WS"/>
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
    "warehouseActivityHeaderWS"
})
@XmlRootElement(name = "Create_Result")
public class CreateResult {

    @XmlElement(name = "Warehouse_Activity_Header_WS", required = true)
    protected WarehouseActivityHeaderWS warehouseActivityHeaderWS;

    /**
     * Obtiene el valor de la propiedad warehouseActivityHeaderWS.
     * 
     * @return
     *     possible object is
     *     {@link WarehouseActivityHeaderWS }
     *     
     */
    public WarehouseActivityHeaderWS getWarehouseActivityHeaderWS() {
        return warehouseActivityHeaderWS;
    }

    /**
     * Define el valor de la propiedad warehouseActivityHeaderWS.
     * 
     * @param value
     *     allowed object is
     *     {@link WarehouseActivityHeaderWS }
     *     
     */
    public void setWarehouseActivityHeaderWS(WarehouseActivityHeaderWS value) {
        this.warehouseActivityHeaderWS = value;
    }

}
