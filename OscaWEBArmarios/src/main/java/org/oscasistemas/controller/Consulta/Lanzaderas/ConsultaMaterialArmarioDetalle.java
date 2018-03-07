package org.oscasistemas.controller.Consulta.Lanzaderas;

import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.*;
import org.oscasistemas.model.Lanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by José Ángel Caudevílla Casaús on 29/12/2017.
 */
@RestController
public class ConsultaMaterialArmarioDetalle {

    @Autowired
    private ICajaEntablado locationService;  //box query service

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService; //custom box query service

    @Autowired
    private ILanzadera lanzaderaService; //lift query service

    /**
     *
     * @param lanzadera
     * @return a page with materials on a lift
     */
    @RequestMapping(value="/ConsultaMaterialArmarioDetalle")
    public ModelAndView consultaMaterialArmarioDetallePage(@NotNull @RequestParam(value="lanzadera", required=false , defaultValue = "-1") int lanzadera) {
        ModelAndView m= new ModelAndView("Consulta/Lanzaderas/ConsultaMaterialLanzaderaDetalle");
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("material",locationService.getCajasLanzadera(l));
        m.getModelMap().addAttribute("materialreserva",cajaEntabladoMedidaService.getCajasLanzadera(l));
        return m;
    }
}
