package org.oscasistemas.controller.Salida;

import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 21/12/2017.
 */
@RestController
public class SalidaMaterialHome {

    @Autowired
    private ILanzadera lanzaderaService;

    /**
     *
     * @param request
     * @param id_lanzadera
     * @return output main page
     */
    @RequestMapping(value="/SalidaMaterialHome")
    public ModelAndView salidaMateriaHomePage(HttpServletRequest request, @NotNull @RequestParam(required = false , value = "lanzadera",defaultValue =  "-1") int  id_lanzadera) {
        ModelAndView m=new ModelAndView("Salida/SalidaMaterialHome");
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        m.getModelMap().addAttribute("lanzadera", lanzaderaService.getLanzaderaIp(remoteAddr));
        return  m;
    }
}
