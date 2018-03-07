package org.oscasistemas.controller.Entrada.EntradaManual;

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
public class EntradaBusquedaArticulo {

    @Autowired
    private ILanzadera lanzaderaService; //lift query service


    /**
     * Search article for entry window
     * @return
     */
    @RequestMapping(value="/EntradaBusquedaArticulo")
    public ModelAndView entradaBusquedaArticuloPage(HttpServletRequest request)
    throws Exception{
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        ModelAndView m=new ModelAndView("Entrada/EntradaManual/EntradaBusquedaArticulo");
        m.getModelMap().addAttribute("lanzadera", lanzaderaService.getLanzaderaIp(remoteAddr));
        return m;

    }
}
