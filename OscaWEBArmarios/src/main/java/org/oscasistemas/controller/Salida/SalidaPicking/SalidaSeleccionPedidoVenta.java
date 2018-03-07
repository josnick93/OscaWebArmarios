package org.oscasistemas.controller.Salida.SalidaPicking;

import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 21/12/2017.
 */
@RestController
public class SalidaSeleccionPedidoVenta {

    @Autowired
    private ILanzadera lanzaderaService;
    /**
     * Return a picking search page
     * @return
     */
    @RequestMapping(value="/SalidaSeleccionPedidoVenta")
    public ModelAndView salidaSeleccionPedidoPage(HttpServletRequest request) {
        ModelAndView m=  new ModelAndView("Salida/SalidaPicking/SalidaSeleccionPicking");
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        m.getModelMap().addAttribute("lanzadera", lanzaderaService.getLanzaderaIp(remoteAddr));
        return m;
    }
}
