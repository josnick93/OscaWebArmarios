
package com.dynamics.webServices.Item_Card_WS;

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
@WebService(name = "Item_Card_WS_Port", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ItemCardWSPort {


    /**
     * 
     * @param no
     * @return
     *     returns com.dynamics.webServices.Item_Card_WS.ItemCardWS
     */
    @WebMethod(operationName = "Read", action = "urn:microsoft-dynamics-schemas/page/item_card_ws:Read")
    @WebResult(name = "Item_Card_WS", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws")
    @RequestWrapper(localName = "Read", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.Read")
    @ResponseWrapper(localName = "Read_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.ReadResult")
    public ItemCardWS read(
        @WebParam(name = "No", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws")
        String no);

    /**
     * 
     * @param recId
     * @return
     *     returns com.dynamics.webServices.Item_Card_WS.ItemCardWS
     */
    @WebMethod(operationName = "ReadByRecId", action = "urn:microsoft-dynamics-schemas/page/item_card_ws:ReadByRecId")
    @WebResult(name = "Item_Card_WS", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws")
    @RequestWrapper(localName = "ReadByRecId", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.ReadByRecId")
    @ResponseWrapper(localName = "ReadByRecId_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.ReadByRecIdResult")
    public ItemCardWS readByRecId(
        @WebParam(name = "recId", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws")
        String recId);

    /**
     * 
     * @param filter
     * @param setSize
     * @param bookmarkKey
     * @return
     *     returns com.dynamics.webServices.Item_Card_WS.ItemCardWSList
     */
    @WebMethod(operationName = "ReadMultiple", action = "urn:microsoft-dynamics-schemas/page/item_card_ws:ReadMultiple")
    @WebResult(name = "ReadMultiple_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws")
    @RequestWrapper(localName = "ReadMultiple", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.ReadMultiple")
    @ResponseWrapper(localName = "ReadMultiple_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.ReadMultipleResult")
    public ItemCardWSList readMultiple(
        @WebParam(name = "filter", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws")
        List<ItemCardWSFilter> filter,
        @WebParam(name = "bookmarkKey", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws")
        String bookmarkKey,
        @WebParam(name = "setSize", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws")
        int setSize);

    /**
     * 
     * @param key
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "IsUpdated", action = "urn:microsoft-dynamics-schemas/page/item_card_ws:IsUpdated")
    @WebResult(name = "IsUpdated_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws")
    @RequestWrapper(localName = "IsUpdated", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.IsUpdated")
    @ResponseWrapper(localName = "IsUpdated_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.IsUpdatedResult")
    public boolean isUpdated(
        @WebParam(name = "Key", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws")
        String key);

    /**
     * 
     * @param key
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetRecIdFromKey", action = "urn:microsoft-dynamics-schemas/page/item_card_ws:GetRecIdFromKey")
    @WebResult(name = "GetRecIdFromKey_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws")
    @RequestWrapper(localName = "GetRecIdFromKey", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.GetRecIdFromKey")
    @ResponseWrapper(localName = "GetRecIdFromKey_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.GetRecIdFromKeyResult")
    public String getRecIdFromKey(
        @WebParam(name = "Key", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws")
        String key);

    /**
     * 
     * @param itemCardWS
     */
    @WebMethod(operationName = "Create", action = "urn:microsoft-dynamics-schemas/page/item_card_ws:Create")
    @RequestWrapper(localName = "Create", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.Create")
    @ResponseWrapper(localName = "Create_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.CreateResult")
    public void create(
        @WebParam(name = "Item_Card_WS", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", mode = WebParam.Mode.INOUT)
        Holder<ItemCardWS> itemCardWS);

    /**
     * 
     * @param itemCardWSList
     */
    @WebMethod(operationName = "CreateMultiple", action = "urn:microsoft-dynamics-schemas/page/item_card_ws:CreateMultiple")
    @RequestWrapper(localName = "CreateMultiple", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.CreateMultiple")
    @ResponseWrapper(localName = "CreateMultiple_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.CreateMultipleResult")
    public void createMultiple(
        @WebParam(name = "Item_Card_WS_List", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", mode = WebParam.Mode.INOUT)
        Holder<ItemCardWSList> itemCardWSList);

    /**
     * 
     * @param itemCardWS
     */
    @WebMethod(operationName = "Update", action = "urn:microsoft-dynamics-schemas/page/item_card_ws:Update")
    @RequestWrapper(localName = "Update", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.Update")
    @ResponseWrapper(localName = "Update_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.UpdateResult")
    public void update(
        @WebParam(name = "Item_Card_WS", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", mode = WebParam.Mode.INOUT)
        Holder<ItemCardWS> itemCardWS);

    /**
     * 
     * @param itemCardWSList
     */
    @WebMethod(operationName = "UpdateMultiple", action = "urn:microsoft-dynamics-schemas/page/item_card_ws:UpdateMultiple")
    @RequestWrapper(localName = "UpdateMultiple", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.UpdateMultiple")
    @ResponseWrapper(localName = "UpdateMultiple_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.UpdateMultipleResult")
    public void updateMultiple(
        @WebParam(name = "Item_Card_WS_List", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", mode = WebParam.Mode.INOUT)
        Holder<ItemCardWSList> itemCardWSList);

    /**
     * 
     * @param key
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "Delete", action = "urn:microsoft-dynamics-schemas/page/item_card_ws:Delete")
    @WebResult(name = "Delete_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws")
    @RequestWrapper(localName = "Delete", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.Delete")
    @ResponseWrapper(localName = "Delete_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws", className = "com.dynamics.webServices.Item_Card_WS.DeleteResult")
    public boolean delete(
        @WebParam(name = "Key", targetNamespace = "urn:microsoft-dynamics-schemas/page/item_card_ws")
        String key);

}