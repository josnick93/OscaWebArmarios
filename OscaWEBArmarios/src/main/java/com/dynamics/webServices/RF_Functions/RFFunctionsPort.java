
package com.dynamics.webServices.RF_Functions;

import java.math.BigInteger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "RF_Functions_Port", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RFFunctionsPort {


    /**
     * 
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "get_IsSingleInstance", action = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions:get_IsSingleInstance")
    @WebResult(name = "return_value", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
    @RequestWrapper(localName = "get_IsSingleInstance", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.GetIsSingleInstance")
    @ResponseWrapper(localName = "get_IsSingleInstance_Result", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.GetIsSingleInstanceResult")
    public boolean getIsSingleInstance();

    /**
     * 
     * @param parPickNo
     * @param parLineNo
     */
    @WebMethod(operationName = "PickSplitLine", action = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions:PickSplitLine")
    @RequestWrapper(localName = "PickSplitLine", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.PickSplitLine")
    @ResponseWrapper(localName = "PickSplitLine_Result", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.PickSplitLineResult")
    public void pickSplitLine(
        @WebParam(name = "parPickNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parPickNo,
        @WebParam(name = "parLineNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        int parLineNo);

    /**
     * 
     * @param parLineNo
     * @param parPutAwayNo
     */
    @WebMethod(operationName = "PutAwaySplitLine", action = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions:PutAwaySplitLine")
    @RequestWrapper(localName = "PutAwaySplitLine", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.PutAwaySplitLine")
    @ResponseWrapper(localName = "PutAwaySplitLine_Result", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.PutAwaySplitLineResult")
    public void putAwaySplitLine(
        @WebParam(name = "parPutAwayNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parPutAwayNo,
        @WebParam(name = "parLineNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        int parLineNo);

    /**
     * 
     * @param parPickNo
     */
    @WebMethod(operationName = "PickPost", action = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions:PickPost")
    @RequestWrapper(localName = "PickPost", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.PickPost")
    @ResponseWrapper(localName = "PickPost_Result", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.PickPostResult")
    public void pickPost(
        @WebParam(name = "parPickNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parPickNo);

    /**
     * 
     * @param parItem
     * @return
     *     returns int
     */
    @WebMethod(operationName = "ItemHasTracking", action = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions:ItemHasTracking")
    @WebResult(name = "return_value", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
    @RequestWrapper(localName = "ItemHasTracking", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.ItemHasTracking")
    @ResponseWrapper(localName = "ItemHasTracking_Result", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.ItemHasTrackingResult")
    public int itemHasTracking(
        @WebParam(name = "parItem", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parItem);

    /**
     * 
     * @param parPutAwayNo
     */
    @WebMethod(operationName = "PutAwayPost", action = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions:PutAwayPost")
    @RequestWrapper(localName = "PutAwayPost", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.PutAwayPost")
    @ResponseWrapper(localName = "PutAwayPost_Result", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.PutAwayPostResult")
    public void putAwayPost(
        @WebParam(name = "parPutAwayNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parPutAwayNo);

    /**
     * 
     * @param parLineNo
     * @param parPutAwayNo
     * @return
     *     returns int
     */
    @WebMethod(operationName = "GetPutAwayTakeLine", action = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions:GetPutAwayTakeLine")
    @WebResult(name = "return_value", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
    @RequestWrapper(localName = "GetPutAwayTakeLine", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.GetPutAwayTakeLine")
    @ResponseWrapper(localName = "GetPutAwayTakeLine_Result", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.GetPutAwayTakeLineResult")
    public int getPutAwayTakeLine(
        @WebParam(name = "parPutAwayNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parPutAwayNo,
        @WebParam(name = "parLineNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        int parLineNo);

    /**
     * 
     * @param parLocation
     * @param parBinCode
     * @param parItemNo
     * @param parVariantCode
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetBinUOM", action = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions:GetBinUOM")
    @WebResult(name = "return_value", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
    @RequestWrapper(localName = "GetBinUOM", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.GetBinUOM")
    @ResponseWrapper(localName = "GetBinUOM_Result", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.GetBinUOMResult")
    public String getBinUOM(
        @WebParam(name = "parLocation", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parLocation,
        @WebParam(name = "parItemNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parItemNo,
        @WebParam(name = "parVariantCode", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parVariantCode,
        @WebParam(name = "parBinCode", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parBinCode);

    /**
     * 
     * @param parUser
     * @param parDocNo
     * @param parLocation
     * @param parBinDest
     * @param parBinSource
     * @param parUOM
     * @param parItemNo
     * @param parLotNo
     * @param parVariantCode
     * @param parQty
     */
    @WebMethod(operationName = "CreateMovement", action = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions:CreateMovement")
    @RequestWrapper(localName = "CreateMovement", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.CreateMovement")
    @ResponseWrapper(localName = "CreateMovement_Result", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.CreateMovementResult")
    public void createMovement(
        @WebParam(name = "parLocation", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parLocation,
        @WebParam(name = "parUser", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parUser,
        @WebParam(name = "parDocNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parDocNo,
        @WebParam(name = "parItemNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parItemNo,
        @WebParam(name = "parVariantCode", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parVariantCode,
        @WebParam(name = "parLotNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parLotNo,
        @WebParam(name = "parQty", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        BigInteger parQty,
        @WebParam(name = "parUOM", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parUOM,
        @WebParam(name = "parBinSource", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parBinSource,
        @WebParam(name = "parBinDest", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parBinDest);

    /**
     * 
     * @param parShipmentNo
     */
    @WebMethod(operationName = "ShipmentPost", action = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions:ShipmentPost")
    @RequestWrapper(localName = "ShipmentPost", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.ShipmentPost")
    @ResponseWrapper(localName = "ShipmentPost_Result", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.ShipmentPostResult")
    public void shipmentPost(
        @WebParam(name = "parShipmentNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parShipmentNo);

    /**
     * 
     * @param parLineNo
     * @param parShipmentNo
     * @param parNewVariant
     */
    @WebMethod(operationName = "ShipmentLineChangeVariant", action = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions:ShipmentLineChangeVariant")
    @RequestWrapper(localName = "ShipmentLineChangeVariant", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.ShipmentLineChangeVariant")
    @ResponseWrapper(localName = "ShipmentLineChangeVariant_Result", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.ShipmentLineChangeVariantResult")
    public void shipmentLineChangeVariant(
        @WebParam(name = "parShipmentNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parShipmentNo,
        @WebParam(name = "parLineNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        int parLineNo,
        @WebParam(name = "parNewVariant", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parNewVariant);

    /**
     * 
     * @param parReceiptNo
     */
    @WebMethod(operationName = "ReceiptPost", action = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions:ReceiptPost")
    @RequestWrapper(localName = "ReceiptPost", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.ReceiptPost")
    @ResponseWrapper(localName = "ReceiptPost_Result", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.ReceiptPostResult")
    public void receiptPost(
        @WebParam(name = "parReceiptNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parReceiptNo);

    /**
     * 
     * @param parBatch
     * @param parTemplate
     */
    @WebMethod(operationName = "InventorytPost", action = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions:InventorytPost")
    @RequestWrapper(localName = "InventorytPost", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.InventorytPost")
    @ResponseWrapper(localName = "InventorytPost_Result", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.InventorytPostResult")
    public void inventorytPost(
        @WebParam(name = "parTemplate", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parTemplate,
        @WebParam(name = "parBatch", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parBatch);

    /**
     * 
     * @param parBatch
     * @param parLocation
     * @param parLot
     * @param parTemplate
     * @param parBin
     * @param parItem
     * @param parVariant
     * @return
     *     returns int
     */
    @WebMethod(operationName = "CreateInventoryLine", action = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions:CreateInventoryLine")
    @WebResult(name = "return_value", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
    @RequestWrapper(localName = "CreateInventoryLine", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.CreateInventoryLine")
    @ResponseWrapper(localName = "CreateInventoryLine_Result", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.CreateInventoryLineResult")
    public int createInventoryLine(
        @WebParam(name = "parTemplate", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parTemplate,
        @WebParam(name = "parBatch", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parBatch,
        @WebParam(name = "parLocation", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parLocation,
        @WebParam(name = "parItem", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parItem,
        @WebParam(name = "parVariant", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parVariant,
        @WebParam(name = "parLot", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parLot,
        @WebParam(name = "parBin", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parBin);

    /**
     * 
     * @param pLotNo
     * @param pSourceLineNo
     * @param pSourceType
     * @param pQuantity
     * @param pItemNo
     * @param pVariantCode
     * @param pSourceNo
     * @param pLocationCode
     */
    @WebMethod(operationName = "CreateTracking", action = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions:CreateTracking")
    @RequestWrapper(localName = "CreateTracking", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.CreateTracking")
    @ResponseWrapper(localName = "CreateTracking_Result", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.CreateTrackingResult")
    public void createTracking(
        @WebParam(name = "pSourceType", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        int pSourceType,
        @WebParam(name = "pSourceNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String pSourceNo,
        @WebParam(name = "pSourceLineNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        int pSourceLineNo,
        @WebParam(name = "pItemNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String pItemNo,
        @WebParam(name = "pVariantCode", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String pVariantCode,
        @WebParam(name = "pLocationCode", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String pLocationCode,
        @WebParam(name = "pLotNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String pLotNo,
        @WebParam(name = "pQuantity", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        BigInteger pQuantity);

    /**
     * 
     * @param parItemNo
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetItemDescription", action = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions:GetItemDescription")
    @WebResult(name = "return_value", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
    @RequestWrapper(localName = "GetItemDescription", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.GetItemDescription")
    @ResponseWrapper(localName = "GetItemDescription_Result", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.GetItemDescriptionResult")
    public String getItemDescription(
        @WebParam(name = "parItemNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String parItemNo);

    /**
     * 
     * @param psNo
     * @param psOrderNo
     * @param pnQuantity
     * @param psBinCode
     */
    @WebMethod(operationName = "CreateFrontDeskLine", action = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions:CreateFrontDeskLine")
    @RequestWrapper(localName = "CreateFrontDeskLine", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.CreateFrontDeskLine")
    @ResponseWrapper(localName = "CreateFrontDeskLine_Result", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions", className = "com.dynamics.webServices.RF_Functions.CreateFrontDeskLineResult")
    public void createFrontDeskLine(
        @WebParam(name = "ps_OrderNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String psOrderNo,
        @WebParam(name = "ps_No", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String psNo,
        @WebParam(name = "ps_BinCode", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        String psBinCode,
        @WebParam(name = "pn_Quantity", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/RF_Functions")
        BigInteger pnQuantity);

}
