
package com.dynamics.webServices.WS_Whse_Worksheet_Line;

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
@WebService(name = "WS_Whse_Worksheet_Line_Port", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSWhseWorksheetLinePort {


    /**
     * 
     * @param lineNo
     * @param name
     * @param locationCode
     * @param worksheetTemplateName
     * @return
     *     returns com.dynamics.webServices.WS_Whse_Worksheet_Line.WSWhseWorksheetLine
     */
    @WebMethod(operationName = "Read", action = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line:Read")
    @WebResult(name = "WS_Whse_Worksheet_Line", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line")
    @RequestWrapper(localName = "Read", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.Read")
    @ResponseWrapper(localName = "Read_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.ReadResult")
    public WSWhseWorksheetLine read(
        @WebParam(name = "Worksheet_Template_Name", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line")
        String worksheetTemplateName,
        @WebParam(name = "Name", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line")
        String name,
        @WebParam(name = "Location_Code", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line")
        String locationCode,
        @WebParam(name = "Line_No", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line")
        int lineNo);

    /**
     * 
     * @param recId
     * @return
     *     returns com.dynamics.webServices.WS_Whse_Worksheet_Line.WSWhseWorksheetLine
     */
    @WebMethod(operationName = "ReadByRecId", action = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line:ReadByRecId")
    @WebResult(name = "WS_Whse_Worksheet_Line", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line")
    @RequestWrapper(localName = "ReadByRecId", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.ReadByRecId")
    @ResponseWrapper(localName = "ReadByRecId_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.ReadByRecIdResult")
    public WSWhseWorksheetLine readByRecId(
        @WebParam(name = "recId", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line")
        String recId);

    /**
     * 
     * @param filter
     * @param setSize
     * @param bookmarkKey
     * @return
     *     returns com.dynamics.webServices.WS_Whse_Worksheet_Line.WSWhseWorksheetLineList
     */
    @WebMethod(operationName = "ReadMultiple", action = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line:ReadMultiple")
    @WebResult(name = "ReadMultiple_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line")
    @RequestWrapper(localName = "ReadMultiple", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.ReadMultiple")
    @ResponseWrapper(localName = "ReadMultiple_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.ReadMultipleResult")
    public WSWhseWorksheetLineList readMultiple(
        @WebParam(name = "filter", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line")
        List<WSWhseWorksheetLineFilter> filter,
        @WebParam(name = "bookmarkKey", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line")
        String bookmarkKey,
        @WebParam(name = "setSize", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line")
        int setSize);

    /**
     * 
     * @param key
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "IsUpdated", action = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line:IsUpdated")
    @WebResult(name = "IsUpdated_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line")
    @RequestWrapper(localName = "IsUpdated", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.IsUpdated")
    @ResponseWrapper(localName = "IsUpdated_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.IsUpdatedResult")
    public boolean isUpdated(
        @WebParam(name = "Key", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line")
        String key);

    /**
     * 
     * @param key
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetRecIdFromKey", action = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line:GetRecIdFromKey")
    @WebResult(name = "GetRecIdFromKey_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line")
    @RequestWrapper(localName = "GetRecIdFromKey", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.GetRecIdFromKey")
    @ResponseWrapper(localName = "GetRecIdFromKey_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.GetRecIdFromKeyResult")
    public String getRecIdFromKey(
        @WebParam(name = "Key", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line")
        String key);

    /**
     * 
     * @param wsWhseWorksheetLine
     */
    @WebMethod(operationName = "Create", action = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line:Create")
    @RequestWrapper(localName = "Create", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.Create")
    @ResponseWrapper(localName = "Create_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.CreateResult")
    public void create(
        @WebParam(name = "WS_Whse_Worksheet_Line", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", mode = WebParam.Mode.INOUT)
        Holder<WSWhseWorksheetLine> wsWhseWorksheetLine);

    /**
     * 
     * @param wsWhseWorksheetLineList
     */
    @WebMethod(operationName = "CreateMultiple", action = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line:CreateMultiple")
    @RequestWrapper(localName = "CreateMultiple", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.CreateMultiple")
    @ResponseWrapper(localName = "CreateMultiple_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.CreateMultipleResult")
    public void createMultiple(
        @WebParam(name = "WS_Whse_Worksheet_Line_List", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", mode = WebParam.Mode.INOUT)
        Holder<WSWhseWorksheetLineList> wsWhseWorksheetLineList);

    /**
     * 
     * @param wsWhseWorksheetLine
     */
    @WebMethod(operationName = "Update", action = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line:Update")
    @RequestWrapper(localName = "Update", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.Update")
    @ResponseWrapper(localName = "Update_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.UpdateResult")
    public void update(
        @WebParam(name = "WS_Whse_Worksheet_Line", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", mode = WebParam.Mode.INOUT)
        Holder<WSWhseWorksheetLine> wsWhseWorksheetLine);

    /**
     * 
     * @param wsWhseWorksheetLineList
     */
    @WebMethod(operationName = "UpdateMultiple", action = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line:UpdateMultiple")
    @RequestWrapper(localName = "UpdateMultiple", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.UpdateMultiple")
    @ResponseWrapper(localName = "UpdateMultiple_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.UpdateMultipleResult")
    public void updateMultiple(
        @WebParam(name = "WS_Whse_Worksheet_Line_List", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", mode = WebParam.Mode.INOUT)
        Holder<WSWhseWorksheetLineList> wsWhseWorksheetLineList);

    /**
     * 
     * @param key
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "Delete", action = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line:Delete")
    @WebResult(name = "Delete_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line")
    @RequestWrapper(localName = "Delete", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.Delete")
    @ResponseWrapper(localName = "Delete_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line", className = "com.dynamics.webServices.WS_Whse_Worksheet_Line.DeleteResult")
    public boolean delete(
        @WebParam(name = "Key", targetNamespace = "urn:microsoft-dynamics-schemas/page/ws_whse_worksheet_line")
        String key);

}
