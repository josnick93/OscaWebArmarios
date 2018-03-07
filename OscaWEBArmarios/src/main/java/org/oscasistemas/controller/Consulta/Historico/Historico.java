package org.oscasistemas.controller.Consulta.Historico;

import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.DAO.interfaces.IHistorico;
import org.oscasistemas.model.Entablado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by José Ángel Caudevílla Casaús on 29/12/2017.
 */
@RestController
public class Historico {



    @Autowired(required = true)
    private IEntablado entabladoService; //shelf query service

    @Autowired
    private IHistorico historicoService; //historic query service

    /**
     *
     * @param entablado
     * @param modoBusqueda
     * @return a page with a storic register about a shelf
     */
    @RequestMapping(value="/ConsultaHistoricoEntablado" )
    public ModelAndView consultaHistoricoEntabladoPage(@NotNull @RequestParam(value= "entablado",required = true, defaultValue = "-1") String entablado,
                                                       @NotNull @RequestParam(value= "modo",required = true, defaultValue = "1") int modoBusqueda)
    {
        ModelAndView m=new ModelAndView("Consulta/Entablado/ConsultaHistoricoEntablado");
        //Entablado e=entabladoService.getEstanteria(l,entablado);
        Entablado e=entabladoService.getEstanteria(entablado);
        //obtener historico
        m.getModelMap().addAttribute("entablado",e);
        if(modoBusqueda==1)
            m.getModelMap().addAttribute("historico",historicoService.getHistoricoUltimoMes(e));
        else if(modoBusqueda==2)
            m.getModelMap().addAttribute("historico",historicoService.getHistoricoUltimos3Meses(e));
        else if(modoBusqueda==3)
            m.getModelMap().addAttribute("historico",historicoService.getHistoricoUltimoAno(e));
        else if(modoBusqueda==4)
            m.getModelMap().addAttribute("historico",historicoService.getHistorio(e));
        return m;
    }

}
