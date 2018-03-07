package org.oscasistemas.controller.Consulta.Material;

import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.*;
import org.oscasistemas.model.Lanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Portátil1 on 29/12/2017.
 */
@RestController
public class ConsultaMaterialArmarioDetalle {

    @Autowired
    private ICajaEntablado locationService;

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;

    @Autowired
    private ILanzadera lanzaderaService;


    @RequestMapping(value="/ConsultaMaterialArmarioDetalle")
    public ModelAndView consultaMaterialArmarioDetallePage(@NotNull @RequestParam(value="lanzadera", required=false , defaultValue = "-1") int lanzadera) {
        ModelAndView m= new ModelAndView("ConsultaMaterialArmarioDetalle");
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("material",locationService.getCajasLanzadera(l));
        m.getModelMap().addAttribute("materialreserva",cajaEntabladoMedidaService.getCajasLanzadera(l));
        return m;
    }
}
