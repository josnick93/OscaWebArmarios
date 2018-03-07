package org.oscasistemas.controller.Consulta.Lanzaderas;

import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by José Ángel Caudevílla Casaús on 29/12/2017.
 */
@RestController
public class ConsultaMaterialArmario {

    @Autowired
    private ILanzadera lanzaderaService; //lift query service

    /**
     *
     * @return a page with lifts material
     */
    @RequestMapping(value="/ConsultaMaterialArmario")
    public ModelAndView consultaMaterialArmarioPage() {
        ModelAndView m= new ModelAndView("Consulta/Lanzaderas/ConsultaMaterialLanzadera");
        m.getModelMap().addAttribute("lanzaderas",lanzaderaService.getLanzaderas());
        return m;
    }
}
