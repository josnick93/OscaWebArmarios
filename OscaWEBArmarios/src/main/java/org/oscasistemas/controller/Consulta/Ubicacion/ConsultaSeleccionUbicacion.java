package org.oscasistemas.controller.Consulta.Ubicacion;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Portátil1 on 29/12/2017.
 */
@RestController
public class ConsultaSeleccionUbicacion {


    //ConsultaSeleccionUbicacion
    @RequestMapping(value="/ConsultaSeleccionUbicacion")
    public ModelAndView consultaSeleccionUbicacionPage() {
        return new ModelAndView("ConsultaSeleccionUbicacion");
    }

}
