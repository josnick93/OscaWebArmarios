package org.oscasistemas.controller.Entrada.EntradaMaterial;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 21/12/2017.
 */
@RestController
public class EntradaSeleccionPedido {

    /**
     *
     * @param request
     * @return a ubication search page
     */
    @RequestMapping(value="/EntradaSeleccionPedido")
    public ModelAndView entradaSeleccionPedidoPage(HttpServletRequest request)
    throws Exception{
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        return new ModelAndView("Entrada/EntradaMaterial/EntradaSeleccionPedido");
    }
}
