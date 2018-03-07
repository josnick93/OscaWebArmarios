package org.oscasistemas.controller;

import com.sun.istack.internal.NotNull;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Portátil1 on 26/07/2017.
 */
@RestController
public class OperacionesEntabladoController {


    @RequestMapping(value="OperacionEntablado/AbrirVentana" ,method = RequestMethod.GET )
    public   @ResponseBody
    String modificarAcessoLanzadera(HttpServletRequest request,
                                    @NotNull @RequestParam(value = "ip",required = true ,defaultValue = "0.0.0.0")  String ip,
                                    @NotNull @RequestParam(value = "url",required = true ,defaultValue = "http://192.168.2.161:8080/OscaArmarios")String url) throws Exception {
        JSONObject outputJsonObj = new JSONObject();
        String line;
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        Process proc = Runtime.getRuntime().exec("java -jar C:\\WEBOpener.jar "+ip+" '"+url+"&cerrar=1'");
        outputJsonObj.put("res","true");
        return outputJsonObj.toString();
    }
}
