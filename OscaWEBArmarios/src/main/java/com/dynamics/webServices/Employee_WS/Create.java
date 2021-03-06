
package com.dynamics.webServices.Employee_WS;

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
 *         &lt;element name="Employee_WS" type="{urn:microsoft-dynamics-schemas/page/employee_ws}Employee_WS"/>
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
    "employeeWS"
})
@XmlRootElement(name = "Create")
public class Create {

    @XmlElement(name = "Employee_WS", required = true)
    protected EmployeeWS employeeWS;

    /**
     * Obtiene el valor de la propiedad employeeWS.
     * 
     * @return
     *     possible object is
     *     {@link EmployeeWS }
     *     
     */
    public EmployeeWS getEmployeeWS() {
        return employeeWS;
    }

    /**
     * Define el valor de la propiedad employeeWS.
     * 
     * @param value
     *     allowed object is
     *     {@link EmployeeWS }
     *     
     */
    public void setEmployeeWS(EmployeeWS value) {
        this.employeeWS = value;
    }

}
