package org.oscasistemas.controller.Operaciones.Eliminar;

import com.sun.istack.internal.NotNull;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.IAcessoLazaderas;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.model.AcessoLanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 26/12/2017.
 */
@RestController
public class BorrarAcessoLanzadera {


    @Autowired
    private IAcessoLazaderas acessoLazaderasService;


    @Autowired
    private ILanzadera lanzaderaService;


    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/BorrarAcessoLanzadera", method = RequestMethod.GET)
    public @ResponseBody
    String borrarAcesoLanzadera(HttpServletRequest request,
                                @NotNull @RequestParam(value = "idLanzadera", required = true, defaultValue = "") int idLanzadera,
                                @NotNull @RequestParam(value = "ipOrdenador", required = true, defaultValue = "") String ipOrdenador) throws Exception {
        JSONObject outputJsonObj = new JSONObject();
        AcessoLanzadera acessoLanzadera = new AcessoLanzadera();
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        acessoLanzadera.setLanzadera(lanzaderaService.getLanzadera(idLanzadera));
        acessoLanzadera.setIpOrdenador(ipOrdenador);
        acessoLazaderasService.remove(acessoLanzadera);
        outputJsonObj.put("res", "true");
        return outputJsonObj.toString();
    }
}
