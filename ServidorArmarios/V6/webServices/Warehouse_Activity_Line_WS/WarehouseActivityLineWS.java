
package com.dynamics.webServices.Warehouse_Activity_Line_WS;

import com.fasterxml.jackson.annotation.JsonView;
import org.oscasistemas.model.View;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Clase Java para Warehouse_Activity_Line_WS complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Warehouse_Activity_Line_WS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Activity_Type" type="{urn:microsoft-dynamics-schemas/page/warehouse_activity_line_ws}Activity_Type" minOccurs="0"/>
 *         &lt;element name="No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Line_No" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Item_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Variant_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Unit_of_Measure_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Bin_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Action_Type" type="{urn:microsoft-dynamics-schemas/page/warehouse_activity_line_ws}Action_Type" minOccurs="0"/>
 *         &lt;element name="Lot_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Serial_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Qty_to_Handle" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_Handled" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Qty_Outstanding" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Source_Document" type="{urn:microsoft-dynamics-schemas/page/warehouse_activity_line_ws}Source_Document" minOccurs="0"/>
 *         &lt;element name="Source_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Warehouse_Activity_Line_WS", propOrder = {
    "key",
    "activityType",
    "no",
    "lineNo",
    "itemNo",
    "variantCode",
    "description",
    "unitOfMeasureCode",
    "quantity",
    "binCode",
    "actionType",
    "lotNo",
    "serialNo",
    "qtyToHandle",
    "qtyHandled",
    "qtyOutstanding",
    "sourceDocument",
    "sourceNo"
})
public class WarehouseActivityLineWS {
    @JsonView(View.Summary.class)
    @XmlElement(name = "Key")
    protected String key;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Activity_Type")
    @XmlSchemaType(name = "string")
    protected ActivityType activityType;
 @JsonView(View.Summary.class)
    @XmlElement(name = "No")
    protected String no;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Line_No")
    protected Integer lineNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Item_No")
    protected String itemNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Variant_Code")
    protected String variantCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Description")
    protected String description;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Unit_of_Measure_Code")
    protected String unitOfMeasureCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Quantity")
    protected BigInteger quantity;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Bin_Code")
    protected String binCode;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Action_Type")
    @XmlSchemaType(name = "string")
    protected ActionType actionType;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Lot_No")
    protected String lotNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Serial_No")
    protected String serialNo;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Qty_to_Handle")
    protected BigInteger qtyToHandle;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Qty_Handled")
    protected BigInteger qtyHandled;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Qty_Outstanding")
    protected BigInteger qtyOutstanding;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Source_Document")
    @XmlSchemaType(name = "string")
    protected SourceDocument sourceDocument;
 @JsonView(View.Summary.class)
    @XmlElement(name = "Source_No")
    protected String sourceNo;

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
     * Obtiene el valor de la propiedad activityType.
     * 
     * @return
     *     possible object is
     *     {@link ActivityType }
     *     
     */
    public ActivityType getActivityType() {
        return activityType;
    }

    /**
     * Define el valor de la propiedad activityType.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityType }
     *     
     */
    public void setActivityType(ActivityType value) {
        this.activityType = value;
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
     * Obtiene el valor de la propiedad lineNo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLineNo() {
        return lineNo;
    }

    /**
     * Define el valor de la propiedad lineNo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLineNo(Integer value) {
        this.lineNo = value;
    }

    /**
     * Obtiene el valor de la propiedad itemNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemNo() {
        return itemNo;
    }

    /**
     * Define el valor de la propiedad itemNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemNo(String value) {
        this.itemNo = value;
    }

    /**
     * Obtiene el valor de la propiedad variantCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVariantCode() {
        return variantCode;
    }

    /**
     * Define el valor de la propiedad variantCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVariantCode(String value) {
        this.variantCode = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad unitOfMeasureCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitOfMeasureCode() {
        return unitOfMeasureCode;
    }

    /**
     * Define el valor de la propiedad unitOfMeasureCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitOfMeasureCode(String value) {
        this.unitOfMeasureCode = value;
    }

    /**
     * Obtiene el valor de la propiedad quantity.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQuantity() {
        return quantity;
    }

    /**
     * Define el valor de la propiedad quantity.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQuantity(BigInteger value) {
        this.quantity = value;
    }

    /**
     * Obtiene el valor de la propiedad binCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBinCode() {
        return binCode;
    }

    /**
     * Define el valor de la propiedad binCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBinCode(String value) {
        this.binCode = value;
    }

    /**
     * Obtiene el valor de la propiedad actionType.
     * 
     * @return
     *     possible object is
     *     {@link ActionType }
     *     
     */
    public ActionType getActionType() {
        return actionType;
    }

    /**
     * Define el valor de la propiedad actionType.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionType }
     *     
     */
    public void setActionType(ActionType value) {
        this.actionType = value;
    }

    /**
     * Obtiene el valor de la propiedad lotNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLotNo() {
        return lotNo;
    }

    /**
     * Define el valor de la propiedad lotNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLotNo(String value) {
        this.lotNo = value;
    }

    /**
     * Obtiene el valor de la propiedad serialNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * Define el valor de la propiedad serialNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialNo(String value) {
        this.serialNo = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyToHandle.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyToHandle() {
        return qtyToHandle;
    }

    /**
     * Define el valor de la propiedad qtyToHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyToHandle(BigInteger value) {
        this.qtyToHandle = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyHandled.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyHandled() {
        return qtyHandled;
    }

    /**
     * Define el valor de la propiedad qtyHandled.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyHandled(BigInteger value) {
        this.qtyHandled = value;
    }

    /**
     * Obtiene el valor de la propiedad qtyOutstanding.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtyOutstanding() {
        return qtyOutstanding;
    }

    /**
     * Define el valor de la propiedad qtyOutstanding.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtyOutstanding(BigInteger value) {
        this.qtyOutstanding = value;
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

    @Override
    public String toString() {
        return "WarehouseActivityLineWS{" +
                "key='" + key + '\'' +
                ", activityType=" + activityType +
                ", no='" + no + '\'' +
                ", lineNo=" + lineNo +
                ", itemNo='" + itemNo + '\'' +
                ", variantCode='" + variantCode + '\'' +
                ", description='" + description + '\'' +
                ", unitOfMeasureCode='" + unitOfMeasureCode + '\'' +
                ", quantity=" + quantity +
                ", binCode='" + binCode + '\'' +
                ", actionType=" + actionType +
                ", lotNo='" + lotNo + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", qtyToHandle=" + qtyToHandle +
                ", qtyHandled=" + qtyHandled +
                ", qtyOutstanding=" + qtyOutstanding +
                ", sourceDocument=" + sourceDocument +
                ", sourceNo='" + sourceNo + '\'' +
                '}';
    }

}
