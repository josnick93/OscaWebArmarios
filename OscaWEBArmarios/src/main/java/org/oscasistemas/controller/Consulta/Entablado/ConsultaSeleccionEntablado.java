package org.oscasistemas.controller.Consulta.Entablado;

import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 29/12/2017.
 */
@RestController
public class ConsultaSeleccionEntablado {
    @Autowired
    private ILanzadera lanzaderaService; //lift query service

    /**
     *
     * @param request
     * @param model
     * @param lanzadera
     * @return
     */
    @RequestMapping(value="/ConsultaSeleccionEntablado")
    public ModelAndView consultaSeleccionEntabladoPage(HttpServletRequest request, Model model,
                                                       @NotNull @RequestParam(value = "lanzadera" , required = false
                                                               , defaultValue = "0") int lanzadera)
    throws Exception{

        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        ModelAndView m=new ModelAndView("Consulta/Entablado/ConsultaSeleccionEntablado");
        m.getModelMap().addAttribute("lanzadera",lanzaderaService.getLanzaderaIp(remoteAddr));
        return m;
    }
}
