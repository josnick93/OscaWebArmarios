package org.oscasistemas.controller.Consulta.Articulo;

import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 29/12/2017.
 */
@RestController
public class ConsultaBusquedaArticulo {

    @Autowired
    private ILanzadera lanzaderaService; //lift database query


    /**
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/ConsultaBusquedaArticulo")
    public ModelAndView consultaBusquedaArticuloPage(HttpServletRequest request)
    throws Exception{
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        ModelAndView m=new ModelAndView("Consulta/Articulo/ConsultaBusquedaArticulo");
        m.getModelMap().addAttribute("lanzadera", lanzaderaService.getLanzaderaIp(remoteAddr));
        return m;
    }
}
