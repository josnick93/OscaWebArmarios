
package com.dynamics.webServices.Bin_Content_WS;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Bin_Content_WS_Port", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BinContentWSPort {


    /**
     * 
     * @param variantCode
     * @param binCode
     * @param itemNo
     * @param locationCode
     * @param unitOfMeasureCode
     * @return
     *     returns com.dynamics.webServices.Bin_Content_WS.BinContentWS
     */
    @WebMethod(operationName = "Read", action = "urn:microsoft-dynamics-schemas/page/bin_content_ws:Read")
    @WebResult(name = "Bin_Content_WS", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
    @RequestWrapper(localName = "Read", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.Read")
    @ResponseWrapper(localName = "Read_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.ReadResult")
    public BinContentWS read(
        @WebParam(name = "Location_Code", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
        String locationCode,
        @WebParam(name = "Bin_Code", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
        String binCode,
        @WebParam(name = "Item_No", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
        String itemNo,
        @WebParam(name = "Variant_Code", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
        String variantCode,
        @WebParam(name = "Unit_of_Measure_Code", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
        String unitOfMeasureCode);

    /**
     * 
     * @param recId
     * @return
     *     returns com.dynamics.webServices.Bin_Content_WS.BinContentWS
     */
    @WebMethod(operationName = "ReadByRecId", action = "urn:microsoft-dynamics-schemas/page/bin_content_ws:ReadByRecId")
    @WebResult(name = "Bin_Content_WS", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
    @RequestWrapper(localName = "ReadByRecId", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.ReadByRecId")
    @ResponseWrapper(localName = "ReadByRecId_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.ReadByRecIdResult")
    public BinContentWS readByRecId(
        @WebParam(name = "recId", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
        String recId);

    /**
     * 
     * @param filter
     * @param setSize
     * @param bookmarkKey
     * @return
     *     returns com.dynamics.webServices.Bin_Content_WS.BinContentWSList
     */
    @WebMethod(operationName = "ReadMultiple", action = "urn:microsoft-dynamics-schemas/page/bin_content_ws:ReadMultiple")
    @WebResult(name = "ReadMultiple_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
    @RequestWrapper(localName = "ReadMultiple", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.ReadMultiple")
    @ResponseWrapper(localName = "ReadMultiple_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.ReadMultipleResult")
    public BinContentWSList readMultiple(
        @WebParam(name = "filter", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
        List<BinContentWSFilter> filter,
        @WebParam(name = "bookmarkKey", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
        String bookmarkKey,
        @WebParam(name = "setSize", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
        int setSize);

    /**
     * 
     * @param key
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "IsUpdated", action = "urn:microsoft-dynamics-schemas/page/bin_content_ws:IsUpdated")
    @WebResult(name = "IsUpdated_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
    @RequestWrapper(localName = "IsUpdated", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.IsUpdated")
    @ResponseWrapper(localName = "IsUpdated_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.IsUpdatedResult")
    public boolean isUpdated(
        @WebParam(name = "Key", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
        String key);

    /**
     * 
     * @param key
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetRecIdFromKey", action = "urn:microsoft-dynamics-schemas/page/bin_content_ws:GetRecIdFromKey")
    @WebResult(name = "GetRecIdFromKey_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
    @RequestWrapper(localName = "GetRecIdFromKey", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.GetRecIdFromKey")
    @ResponseWrapper(localName = "GetRecIdFromKey_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.GetRecIdFromKeyResult")
    public String getRecIdFromKey(
        @WebParam(name = "Key", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
        String key);

    /**
     * 
     * @param binContentWS
     */
    @WebMethod(operationName = "Create", action = "urn:microsoft-dynamics-schemas/page/bin_content_ws:Create")
    @RequestWrapper(localName = "Create", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.Create")
    @ResponseWrapper(localName = "Create_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.CreateResult")
    public void create(
        @WebParam(name = "Bin_Content_WS", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", mode = WebParam.Mode.INOUT)
        Holder<BinContentWS> binContentWS);

    /**
     * 
     * @param binContentWSList
     */
    @WebMethod(operationName = "CreateMultiple", action = "urn:microsoft-dynamics-schemas/page/bin_content_ws:CreateMultiple")
    @RequestWrapper(localName = "CreateMultiple", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.CreateMultiple")
    @ResponseWrapper(localName = "CreateMultiple_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.CreateMultipleResult")
    public void createMultiple(
        @WebParam(name = "Bin_Content_WS_List", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", mode = WebParam.Mode.INOUT)
        Holder<BinContentWSList> binContentWSList);

    /**
     * 
     * @param binContentWS
     */
    @WebMethod(operationName = "Update", action = "urn:microsoft-dynamics-schemas/page/bin_content_ws:Update")
    @RequestWrapper(localName = "Update", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.Update")
    @ResponseWrapper(localName = "Update_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.UpdateResult")
    public void update(
        @WebParam(name = "Bin_Content_WS", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", mode = WebParam.Mode.INOUT)
        Holder<BinContentWS> binContentWS);

    /**
     * 
     * @param binContentWSList
     */
    @WebMethod(operationName = "UpdateMultiple", action = "urn:microsoft-dynamics-schemas/page/bin_content_ws:UpdateMultiple")
    @RequestWrapper(localName = "UpdateMultiple", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.UpdateMultiple")
    @ResponseWrapper(localName = "UpdateMultiple_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.UpdateMultipleResult")
    public void updateMultiple(
        @WebParam(name = "Bin_Content_WS_List", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", mode = WebParam.Mode.INOUT)
        Holder<BinContentWSList> binContentWSList);

    /**
     * 
     * @param key
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "Delete", action = "urn:microsoft-dynamics-schemas/page/bin_content_ws:Delete")
    @WebResult(name = "Delete_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
    @RequestWrapper(localName = "Delete", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.Delete")
    @ResponseWrapper(localName = "Delete_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws", className = "com.dynamics.webServices.Bin_Content_WS.DeleteResult")
    public boolean delete(
        @WebParam(name = "Key", targetNamespace = "urn:microsoft-dynamics-schemas/page/bin_content_ws")
        String key);

}