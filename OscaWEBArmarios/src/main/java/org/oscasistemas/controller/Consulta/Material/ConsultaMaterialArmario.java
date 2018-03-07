package org.oscasistemas.controller.Consulta.Material;

import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Portátil1 on 29/12/2017.
 */
@RestController
public class ConsultaMaterialArmario {

    @Autowired
    private ILanzadera lanzaderaService;

    @RequestMapping(value="/ConsultaMaterialArmario")
    public ModelAndView consultaMaterialArmarioPage() {
        ModelAndView m= new ModelAndView("ConsultaMaterialArmario");
        m.getModelMap().addAttribute("lanzaderas",lanzaderaService.getLanzaderas());
        return m;
    }
}
