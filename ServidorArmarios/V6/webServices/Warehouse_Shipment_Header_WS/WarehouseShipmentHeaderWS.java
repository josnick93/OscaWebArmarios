
package com.dynamics.webServices.Warehouse_Shipment_Header_WS;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import org.oscasistemas.model.View;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para Warehouse_Shipment_Header_WS complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Warehouse_Shipment_Header_WS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Location_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Assigned_User_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Assignment_Date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Posting_Date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Shipping_Agent_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Shipping_Agent_Service_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="External_Document_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Warehouse_Shipment_Header_WS", propOrder = {
    "key",
    "no",
    "locationCode",
    "assignedUserID",
    "assignmentDate",
    "postingDate",
    "shippingAgentCode",
    "shippingAgentServiceCode",
    "externalDocumentNo"
})
@JsonInclude(JsonInclude.Include.ALWAYS)
public class WarehouseShipmentHeaderWS {

    @XmlElement(name = "Key")
    @JsonView(View.Summary.class)
    protected String key;
    @XmlElement(name = "No")
    @JsonView(View.Summary.class)
    protected String no;
    @XmlElement(name = "Location_Code")
    @JsonView(View.Summary.class)
    protected String locationCode;
    @XmlElement(name = "Assigned_User_ID")
    @JsonView(View.Summary.class)
    protected String assignedUserID;
    @XmlElement(name = "Assignment_Date")
    @JsonView(View.Summary.class)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar assignmentDate;
    @XmlElement(name = "Posting_Date")
    @XmlSchemaType(name = "date")
    @JsonView(View.Summary.class)
    protected XMLGregorianCalendar postingDate;
    @XmlElement(name = "Shipping_Agent_Code")
    @JsonView(View.Summary.class)
    protected String shippingAgentCode;
    @XmlElement(name = "Shipping_Agent_Service_Code")
    @JsonView(View.Summary.class)
    protected String shippingAgentServiceCode;
    @XmlElement(name = "External_Document_No")
    @JsonView(View.Summary.class)
    protected String externalDocumentNo;

    /**
     * Obtiene el valor de la propiedad key.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Define el valor de la propiedad key.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Obtiene el valor de la propiedad no.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNo() {
        return no;
    }

    /**
     * Define el valor de la propiedad no.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNo(String value) {
        this.no = value;
    }

    /**
     * Obtiene el valor de la propiedad locationCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationCode() {
        return locationCode;
    }

    /**
     * Define el valor de la propiedad locationCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationCode(String value) {
        this.locationCode = value;
    }

    /**
     * Obtiene el valor de la propiedad assignedUserID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssignedUserID() {
        return assignedUserID;
    }

    /**
     * Define el valor de la propiedad assignedUserID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssignedUserID(String value) {
        this.assignedUserID = value;
    }

    /**
     * Obtiene el valor de la propiedad assignmentDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAssignmentDate() {
        return assignmentDate;
    }

    /**
     * Define el valor de la propiedad assignmentDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAssignmentDate(XMLGregorianCalendar value) {
        this.assignmentDate = value;
    }

    /**
     * Obtiene el valor de la propiedad postingDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPostingDate() {
        return postingDate;
    }

    /**
     * Define el valor de la propiedad postingDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPostingDate(XMLGregorianCalendar value) {
        this.postingDate = value;
    }

    /**
     * Obtiene el valor de la propiedad shippingAgentCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShippingAgentCode() {
        return shippingAgentCode;
    }

    /**
     * Define el valor de la propiedad shippingAgentCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShippingAgentCode(String value) {
        this.shippingAgentCode = value;
    }

    /**
     * Obtiene el valor de la propiedad shippingAgentServiceCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShippingAgentServiceCode() {
        return shippingAgentServiceCode;
    }

    /**
     * Define el valor de la propiedad shippingAgentServiceCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShippingAgentServiceCode(String value) {
        this.shippingAgentServiceCode = value;
    }

    /**
     * Obtiene el valor de la propiedad externalDocumentNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalDocumentNo() {
        return externalDocumentNo;
    }

    /**
     * Define el valor de la propiedad externalDocumentNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalDocumentNo(String value) {
        this.externalDocumentNo = value;
    }


    @Override
    public String toString() {
        return "WarehouseShipmentHeaderWS{" +
                "key='" + key + '\'' +
                ", no='" + no + '\'' +
                ", locationCode='" + locationCode + '\'' +
                ", assignedUserID='" + assignedUserID + '\'' +
                ", assignmentDate=" + assignmentDate +
                ", postingDate=" + postingDate +
                ", shippingAgentCode='" + shippingAgentCode + '\'' +
                ", shippingAgentServiceCode='" + shippingAgentServiceCode + '\'' +
                ", externalDocumentNo='" + externalDocumentNo + '\'' +
                '}';
    }
}
