package org.oscasistemas.controller.Consulta.EliminarUbicacion;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Portátil1 on 29/12/2017.
 */
@RestController
public class ConsultaEliminarUbicacion {
    @RequestMapping(value="/ConsultaEliminarUbicacion")
    public ModelAndView consultaDesvincularUbicacionesPage() {
        return new ModelAndView("ConsultaEliminarUbicacion");
    }
}
