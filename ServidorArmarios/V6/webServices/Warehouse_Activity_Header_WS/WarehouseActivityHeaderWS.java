
package com.dynamics.webServices.Warehouse_Activity_Header_WS;

import com.fasterxml.jackson.annotation.JsonView;
import org.oscasistemas.model.View;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para Warehouse_Activity_Header_WS complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Warehouse_Activity_Header_WS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Type" type="{urn:microsoft-dynamics-schemas/page/warehouse_activity_header_ws}Type" minOccurs="0"/>
 *         &lt;element name="No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Location_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Assigned_User_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Posting_Date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Source_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Source_Document" type="{urn:microsoft-dynamics-schemas/page/warehouse_activity_header_ws}Source_Document" minOccurs="0"/>
 *         &lt;element name="Source_Type" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Source_Subtype" type="{urn:microsoft-dynamics-schemas/page/warehouse_activity_header_ws}Source_Subtype" minOccurs="0"/>
 *         &lt;element name="Destination_Type" type="{urn:microsoft-dynamics-schemas/page/warehouse_activity_header_ws}Destination_Type" minOccurs="0"/>
 *         &lt;element name="Destination_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="External_Document_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Shipment_Date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Expected_Receipt_Date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ls_OrderNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ls_ShipmentNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ls_CustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Warehouse_Activity_Header_WS", propOrder = {
    "key",
    "type",
    "no",
    "locationCode",
    "assignedUserID",
    "comment",
    "postingDate",
    "sourceNo",
    "sourceDocument",
    "sourceType",
    "sourceSubtype",
    "destinationType",
    "destinationNo",
    "externalDocumentNo",
    "shipmentDate",
    "expectedReceiptDate",
    "lsOrderNo",
    "lsShipmentNo",
    "lsCustomerName"
})
public class WarehouseActivityHeaderWS {

    @JsonView(View.Summary.class)
    @XmlElement(name = "Key")
    protected String key;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Type")
    @XmlSchemaType(name = "string")
    protected Type type;
 @JsonView(View.Summary.class)
    @XmlElement(name = "No")
    protected String no;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Location_Code")
    protected String locationCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Assigned_User_ID")
    protected String assignedUserID;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Comment")
    protected Boolean comment;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Posting_Date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar postingDate;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Source_No")
    protected String sourceNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Source_Document")
    @XmlSchemaType(name = "string")
    protected SourceDocument sourceDocument;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Source_Type")
    protected Integer sourceType;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Source_Subtype")
    @XmlSchemaType(name = "string")
    protected SourceSubtype sourceSubtype;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Destination_Type")
    @XmlSchemaType(name = "string")
    protected DestinationType destinationType;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Destination_No")
    protected String destinationNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "External_Document_No")
    protected String externalDocumentNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Shipment_Date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar shipmentDate;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Expected_Receipt_Date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar expectedReceiptDate;
 @JsonView(View.Summary.class)
    @XmlElement(name = "ls_OrderNo")
    protected String lsOrderNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "ls_ShipmentNo")
    protected String lsShipmentNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "ls_CustomerName")
    protected String lsCustomerName;

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
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link Type }
     *     
     */
    public Type getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link Type }
     *     
     */
    public void setType(Type value) {
        this.type = value;
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
     * Obtiene el valor de la propiedad comment.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isComment() {
        return comment;
    }

    /**
     * Define el valor de la propiedad comment.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setComment(Boolean value) {
        this.comment = value;
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
     * Obtiene el valor de la propiedad sourceNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceNo() {
        return sourceNo;
    }

    /**
     * Define el valor de la propiedad sourceNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceNo(String value) {
        this.sourceNo = value;
    }

    /**
     * Obtiene el valor de la propiedad sourceDocument.
     * 
     * @return
     *     possible object is
     *     {@link SourceDocument }
     *     
     */
    public SourceDocument getSourceDocument() {
        return sourceDocument;
    }

    /**
     * Define el valor de la propiedad sourceDocument.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceDocument }
     *     
     */
    public void setSourceDocument(SourceDocument value) {
        this.sourceDocument = value;
    }

    /**
     * Obtiene el valor de la propiedad sourceType.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSourceType() {
        return sourceType;
    }

    /**
     * Define el valor de la propiedad sourceType.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSourceType(Integer value) {
        this.sourceType = value;
    }

    /**
     * Obtiene el valor de la propiedad sourceSubtype.
     * 
     * @return
     *     possible object is
     *     {@link SourceSubtype }
     *     
     */
    public SourceSubtype getSourceSubtype() {
        return sourceSubtype;
    }

    /**
     * Define el valor de la propiedad sourceSubtype.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceSubtype }
     *     
     */
    public void setSourceSubtype(SourceSubtype value) {
        this.sourceSubtype = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationType.
     * 
     * @return
     *     possible object is
     *     {@link DestinationType }
     *     
     */
    public DestinationType getDestinationType() {
        return destinationType;
    }

    /**
     * Define el valor de la propiedad destinationType.
     * 
     * @param value
     *     allowed object is
     *     {@link DestinationType }
     *     
     */
    public void setDestinationType(DestinationType value) {
        this.destinationType = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationNo() {
        return destinationNo;
    }

    /**
     * Define el valor de la propiedad destinationNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationNo(String value) {
        this.destinationNo = value;
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

    /**
     * Obtiene el valor de la propiedad shipmentDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getShipmentDate() {
        return shipmentDate;
    }

    /**
     * Define el valor de la propiedad shipmentDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setShipmentDate(XMLGregorianCalendar value) {
        this.shipmentDate = value;
    }

    /**
     * Obtiene el valor de la propiedad expectedReceiptDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpectedReceiptDate() {
        return expectedReceiptDate;
    }

    /**
     * Define el valor de la propiedad expectedReceiptDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpectedReceiptDate(XMLGregorianCalendar value) {
        this.expectedReceiptDate = value;
    }

    /**
     * Obtiene el valor de la propiedad lsOrderNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLsOrderNo() {
        return lsOrderNo;
    }

    /**
     * Define el valor de la propiedad lsOrderNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLsOrderNo(String value) {
        this.lsOrderNo = value;
    }

    /**
     * Obtiene el valor de la propiedad lsShipmentNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLsShipmentNo() {
        return lsShipmentNo;
    }

    /**
     * Define el valor de la propiedad lsShipmentNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLsShipmentNo(String value) {
        this.lsShipmentNo = value;
    }

    /**
     * Obtiene el valor de la propiedad lsCustomerName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLsCustomerName() {
        return lsCustomerName;
    }

    /**
     * Define el valor de la propiedad lsCustomerName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLsCustomerName(String value) {
        this.lsCustomerName = value;
    }

}
