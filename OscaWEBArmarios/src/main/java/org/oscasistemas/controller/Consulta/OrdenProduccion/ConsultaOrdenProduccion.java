package org.oscasistemas.controller.Consulta.OrdenProduccion;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Portátil1 on 29/12/2017.
 */
@RestController
public class ConsultaOrdenProduccion {

    @RequestMapping(value="/ConsultaOrdenProduccion")
    public ModelAndView consultaOrdenProdPage() {
        return new ModelAndView("ConsultaOrdenProduccion");
    }
}
