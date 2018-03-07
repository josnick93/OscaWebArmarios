package org.oscasistemas.controller.Operaciones.Consulta;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.internal.NotNull;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.IAdministrador;
import org.oscasistemas.model.Administrador;
import org.oscasistemas.model.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Portátil1 on 22/12/2017.
 */
public class EsAdministrador {


    @Autowired
    private IAdministrador administradorService;


    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/EsAdministrador", method = RequestMethod.GET, produces = "application/json")
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String esAdministrador(Model model,
                           HttpServletRequest request,
                           @NotNull @RequestParam(value = "ip", required = true, defaultValue = "127.0.0.1") String dirIp) {
        Administrador a = administradorService.getAdministrador(dirIp);
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        if (a == null) return null;
        else {
            JSONObject obj = new JSONObject(a);
            return obj.toString();
        }
    }
}
