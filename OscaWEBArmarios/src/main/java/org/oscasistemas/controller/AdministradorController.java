package org.oscasistemas.controller;

import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.*;
import org.oscasistemas.model.Administrador;
import org.oscasistemas.service.interfaces.IArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Portátil1 on 31/07/2017.
 */
@RestController
public class AdministradorController {

    @Autowired(required = true)
    private IEntablado entabladoService;
    @Autowired
    private ICajaEntablado locationService;

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;

    @Autowired
    private IArticuloService articuloService;

    @Autowired
    private IAcessoLazaderas acessoLazaderasService;

    @Autowired(required = true)
    private ITipoCaja tipoCajaService;

    @Autowired
    private ILanzadera lanzaderaService;

    @Autowired
    private IHistorico historicoService;

    @Autowired(required = true)
    private IAdministrador administradorService;


    @RequestMapping(value = "/AdministradorLanzaderas", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView adminLanzaderasPage(@NotNull @RequestParam(value = "ip", required = true) String direcionIp) {
        ModelAndView m = new ModelAndView("AdministradorLanzaderas");
        Administrador ad=null;
        if ((ad=administradorService.getAdministrador(direcionIp)) == null) {
            m.setViewName("Home");
        }else {
            m.getModelMap().addAttribute("administrador",ad);
            m.getModelMap().addAttribute("lanzaderas", lanzaderaService.getLanzaderas());
    }
        return m;
    }

    @RequestMapping(value = "/AdministradorAcesosLanzadera", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView administradorAcesosLanzaderaPage(@NotNull @RequestParam(value = "ip", required = true) String direcionIp) {
        ModelAndView m = new ModelAndView("AdministradorAcesosLanzadera");
        Administrador ad=null;
        if ((ad=administradorService.getAdministrador(direcionIp)) == null) {
            m.setViewName("Home");
        }else {
            m.getModelMap().addAttribute("administrador",ad);
            m.getModelMap().addAttribute("lanzaderas", lanzaderaService.getLanzaderas());
            m.getModelMap().addAttribute("acesos", acessoLazaderasService.getAcesos());
        }
        return m;
    }

}