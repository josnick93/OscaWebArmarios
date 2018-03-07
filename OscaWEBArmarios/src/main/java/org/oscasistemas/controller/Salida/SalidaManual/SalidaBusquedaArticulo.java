package org.oscasistemas.controller.Salida.SalidaManual;

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
public class SalidaBusquedaArticulo {

    @Autowired
    private ILanzadera lanzaderaService;//lift query service

    /**
     *
     * @param request
     * @param id_lanzadera
     * @return a page that allows search article
     */
    @RequestMapping(value="/SalidaBusquedaArticulo")
    public ModelAndView salidaBusquedaArticuloPage(HttpServletRequest request,@NotNull @RequestParam(required = false , value = "lanzadera", defaultValue =  "-1") int  id_lanzadera)
    throws Exception{
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        ModelAndView m=new ModelAndView("Salida/SalidaManual/SalidaBusquedaArticulo");
        m.getModelMap().addAttribute("lanzadera", lanzaderaService.getLanzaderaIp(remoteAddr));
        return m;
    }
}
