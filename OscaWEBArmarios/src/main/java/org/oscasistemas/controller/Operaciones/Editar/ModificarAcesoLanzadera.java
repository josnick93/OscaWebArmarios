package org.oscasistemas.controller.Operaciones.Editar;

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
public class ModificarAcesoLanzadera {

    @Autowired
    private IAcessoLazaderas acessoLazaderasService;


    @Autowired
    private ILanzadera lanzaderaService;



    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/ModificarAcesoLanzadera", method = RequestMethod.GET)
    public @ResponseBody
    String modificarAcessoLanzadera(HttpServletRequest request,
                                    @NotNull @RequestParam(value = "idLanzaderaActual", required = true, defaultValue = "-1") int idLanzaderaActual,
                                    @NotNull @RequestParam(value = "idLanzadera", required = true, defaultValue = "-1") int idLanzadera,
                                    @NotNull @RequestParam(value = "ipOrdenador", required = true, defaultValue = "") String ipOrdenador,
                                    @NotNull @RequestParam(value = "descripcionOrdenador", required = true, defaultValue = "") String descripcionOrdenador) throws Exception {
        JSONObject outputJsonObj = new JSONObject();
        AcessoLanzadera acesso = acessoLazaderasService.getAcesso(lanzaderaService.getLanzadera(idLanzaderaActual), ipOrdenador);
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        if (idLanzaderaActual != idLanzadera) {
            //actualizar lanzadera
            acesso.setLanzadera(lanzaderaService.getLanzadera(idLanzadera));
        }
        if (!ipOrdenador.equals(acesso.getIpOrdenador())) acesso.setIpOrdenador(ipOrdenador);
        if (!descripcionOrdenador.equals(acesso.getDescripcionOrdenador()))
            acesso.setDescripcionOrdenador(descripcionOrdenador);
        acessoLazaderasService.addOrUpdate(acesso);
        outputJsonObj.put("res", "true");
        return outputJsonObj.toString();
    }
}
