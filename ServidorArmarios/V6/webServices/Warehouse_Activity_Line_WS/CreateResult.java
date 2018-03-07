
package com.dynamics.webServices.Warehouse_Activity_Line_WS;

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
 *         &lt;element name="Warehouse_Activity_Line_WS" type="{urn:microsoft-dynamics-schemas/page/warehouse_activity_line_ws}Warehouse_Activity_Line_WS"/>
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
    "warehouseActivityLineWS"
})
@XmlRootElement(name = "Create_Result")
public class CreateResult {

    @XmlElement(name = "Warehouse_Activity_Line_WS", required = true)
    protected WarehouseActivityLineWS warehouseActivityLineWS;

    /**
     * Obtiene el valor de la propiedad warehouseActivityLineWS.
     * 
     * @return
     *     possible object is
     *     {@link WarehouseActivityLineWS }
     *     
     */
    public WarehouseActivityLineWS getWarehouseActivityLineWS() {
        return warehouseActivityLineWS;
    }

    /**
     * Define el valor de la propiedad warehouseActivityLineWS.
     * 
     * @param value
     *     allowed object is
     *     {@link WarehouseActivityLineWS }
     *     
     */
    public void setWarehouseActivityLineWS(WarehouseActivityLineWS value) {
        this.warehouseActivityLineWS = value;
    }

}
