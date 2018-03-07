
package com.dynamics.webServices.Employee_Login;

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
@WebService(name = "Employee_Login_Port", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/Employee_Login")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EmployeeLoginPort {


    /**
     * 
     * @param passWord
     * @param employeeNo
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "EmployeeLogin", action = "urn:microsoft-dynamics-schemas/codeunit/Employee_Login:EmployeeLogin")
    @WebResult(name = "return_value", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/Employee_Login")
    @RequestWrapper(localName = "EmployeeLogin", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/Employee_Login", className = "com.dynamics.webServices.Employee_Login.EmployeeLogin")
    @ResponseWrapper(localName = "EmployeeLogin_Result", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/Employee_Login", className = "com.dynamics.webServices.Employee_Login.EmployeeLoginResult")
    public boolean employeeLogin(
        @WebParam(name = "employeeNo", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/Employee_Login")
        String employeeNo,
        @WebParam(name = "passWord", targetNamespace = "urn:microsoft-dynamics-schemas/codeunit/Employee_Login")
        String passWord);

}