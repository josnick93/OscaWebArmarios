package org.oscasistemas.controller.Operaciones.Eliminar;

import com.sun.istack.internal.NotNull;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 26/12/2017.
 */
@RestController
public class BorrarLanzadera {


    @Autowired
    private ILanzadera lanzaderaService;


    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/BorrarLanzadera", method = RequestMethod.GET)
    public @ResponseBody
    String borrarLanzadera(HttpServletRequest request,
                           @NotNull @RequestParam(value = "idLanzadera", required = true, defaultValue = "") int id_lanzadera) throws Exception {
        JSONObject outputJsonObj = new JSONObject();
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        lanzaderaService.deleteLanzadera(lanzaderaService.getLanzadera(id_lanzadera));
        return outputJsonObj.toString();
    }
}
