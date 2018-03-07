package org.oscasistemas.controller.Entrada.EntradaSeleccionPedido;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Portátil1 on 21/12/2017.
 */
@RestController
public class EntradaSeleccionPedido {

    @RequestMapping(value="/EntradaSeleccionPedido")
    public ModelAndView entradaSeleccionPedidoPage(HttpServletRequest request) {
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        return new ModelAndView("EntradaSeleccionPedido");
    }
}
