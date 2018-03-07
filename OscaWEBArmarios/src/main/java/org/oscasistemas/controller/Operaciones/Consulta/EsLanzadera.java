package org.oscasistemas.controller.Operaciones.Consulta;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.internal.NotNull;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.model.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Portátil1 on 22/12/2017.
 */
@RestController
public class EsLanzadera {


    @Autowired
    private ILanzadera lanzaderaService;

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/EsLanzadera", method = RequestMethod.GET, produces = "application/json")
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String esLanzadera(Model model,
                       HttpServletRequest request,
                       @NotNull @RequestParam(value = "ip", required = true, defaultValue = "127.0.0.1") String dirIp) {
        Lanzadera l = lanzaderaService.getLanzaderaIp(dirIp);
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        if (l == null) return null;
        else {
            JSONObject obj = new JSONObject(l);
            return obj.toString();
        }
    }
}
