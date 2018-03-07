package org.oscasistemas.controller.Consulta;

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
public class ConsultaMaterialHome {

    @Autowired
    private ILanzadera lanzaderaService;

    @RequestMapping(value="/ConsultaMaterialHome")
    public ModelAndView consultaMateriaHomePage(HttpServletRequest request) {
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        ModelAndView m=new ModelAndView("Consulta/ConsultaMaterialHome");
        m.getModelMap().addAttribute("lanzadera", lanzaderaService.getLanzaderaIp(remoteAddr));
        return m;
    }
}
