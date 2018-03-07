
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
 *         &lt;element name="Warehouse_Activity_Header_WS_List" type="{urn:microsoft-dynamics-schemas/page/warehouse_activity_header_ws}Warehouse_Activity_Header_WS_List"/>
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
    "warehouseActivityHeaderWSList"
})
@XmlRootElement(name = "CreateMultiple")
public class CreateMultiple {

    @XmlElement(name = "Warehouse_Activity_Header_WS_List", required = true)
    protected WarehouseActivityHeaderWSList warehouseActivityHeaderWSList;

    /**
     * Obtiene el valor de la propiedad warehouseActivityHeaderWSList.
     * 
     * @return
     *     possible object is
     *     {@link WarehouseActivityHeaderWSList }
     *     
     */
    public WarehouseActivityHeaderWSList getWarehouseActivityHeaderWSList() {
        return warehouseActivityHeaderWSList;
    }

    /**
     * Define el valor de la propiedad warehouseActivityHeaderWSList.
     * 
     * @param value
     *     allowed object is
     *     {@link WarehouseActivityHeaderWSList }
     *     
     */
    public void setWarehouseActivityHeaderWSList(WarehouseActivityHeaderWSList value) {
        this.warehouseActivityHeaderWSList = value;
    }

}
