package org.oscasistemas.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.internal.NotNull;
import org.jboss.logging.Logger;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.*;
import org.oscasistemas.model.*;
import org.oscasistemas.service.interfaces.IArticuloService;
import org.oscasistemas.util.ConexionArmario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.*;
import java.util.List;

/**
 * Created by Portátil1 on 26/07/2017.
 */
@RestController
public class ConsultaController {


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

    @Autowired (required = true)
    private ITipoCaja tipoCajaService;

    @Autowired
    private ILanzadera lanzaderaService;

    @Autowired
    private IHistorico historicoService;


    private static final Logger logger = Logger.getLogger(ConsultaController.class);

    public ConsultaController() {
        System.out.println("EntradaManualController()");
    }



    //carga  home desde login
    @RequestMapping(value="/ConsultaMaterialHome")
    public ModelAndView consultaMateriaHomePage() {
        return new ModelAndView("ConsultaMaterialHome");
    }

    @RequestMapping(value="/ConsultaBusquedaArticulo")
    public ModelAndView consultaBusquedaArticuloPage() {
        return new ModelAndView("ConsultaBusquedaArticulo");
    }



    //ConsultaSeleccionUbicacion
    @RequestMapping(value="/ConsultaSeleccionUbicacion")
    public ModelAndView consultaSeleccionUbicacionPage() {
        return new ModelAndView("ConsultaSeleccionUbicacion");
    }


    @RequestMapping(value="/ConsultaEliminarUbicacion")
    public ModelAndView consultaDesvincularUbicacionesPage() {
        return new ModelAndView("ConsultaEliminarUbicacion");
    }

    @RequestMapping(value="/ConsultaOrdenProduccion")
    public ModelAndView consultaOrdenProdPage() {
        return new ModelAndView("ConsultaOrdenProduccion");
    }



    @RequestMapping(value="/ConsultaRegularizacionUbicacion")
    public ModelAndView consultaRegularizacionUbicacionPage() {
        return new ModelAndView("ConsultaRegularizacionUbicacion");
    }

    @RequestMapping(value = "/ConsultaEliminarCajasVacias" , method = RequestMethod.GET )
    @ResponseBody
    public ModelAndView listCajasVacias(Model model){
        ModelAndView m=new ModelAndView("ConsultaEliminarCajasVacias");
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasVacias());
        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasVacias());
        return m;
    }

    @ResponseBody
    @RequestMapping(value = "/CajasVacias/Traer")
    public String traerCajaVacias(@RequestParam(value="idLift", required=false) String liftInfo){
        //llamar a la lanzadera para mover
        String[] split=liftInfo.split("//");
        ConexionArmario.moverArmario(Integer.valueOf(split[0]),Integer.valueOf(split[1]));
        return "sucess";
    }

    //ConsultaHistoricoEntablado
    @RequestMapping(value="/ConsultaOrdenUbicacion")
    public ModelAndView consultOrdenUbicacionPage() {
        return new ModelAndView("ConsultaOrdenUbicacion");
    }






    @RequestMapping(value="/ConsultaSeleccionEntablado")
    public ModelAndView consultaSeleccionEntabladoPage(Model model,
                                                       @NotNull @RequestParam(value = "lanzadera" , required = false, defaultValue = "0") int lanzadera) {
        ModelAndView m=new ModelAndView("ConsultaSeleccionEntablado");
        m.getModelMap().addAttribute("lanzadera",lanzaderaService.getLanzadera(lanzadera));
        return m;
    }







    @RequestMapping(value="/ConsultaEntablado" ,method = RequestMethod.GET )
    public ModelAndView consultaEntabladoPage(@NotNull @RequestParam(value="lanzadera",required = true ,defaultValue = "-1") int lanzadera,
                                              @NotNull @RequestParam(value = "entablado",required = true ,defaultValue = "-1") int entablado ) {
        ModelAndView m =new ModelAndView("ConsultaEntablado");
        Lanzadera l = lanzaderaService.getLanzadera(lanzadera);
        Entablado e = entabladoService.getEstanteria(l,entablado);
        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("ubicaciones",locationService.getCajasEntablado(l,e));
        m.getModelMap().addAttribute("reservas",cajaEntabladoMedidaService.getCajasEntablado(l,e));

        return m;
    }


    //ConsultaHistoricoEntablado
    @RequestMapping(value="/ConsultaHistoricoEntablado" )
    public ModelAndView consultaHistoricoEntabladoPage(@NotNull @RequestParam(value = "lanzadera", required = true, defaultValue = "-1") int lanzadera,
                                                       @NotNull @RequestParam(value= "entablado",required = true, defaultValue = "-1") int entablado,
                                                       @NotNull @RequestParam(value= "modo",required = true, defaultValue = "1") int modoBusqueda)
    {
        ModelAndView m=new ModelAndView("ConsultaHistoricoEntablado");
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        Entablado e=entabladoService.getEstanteria(l,entablado);
        //obtener historico
        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("entablado",e);
        if(modoBusqueda==1)
            m.getModelMap().addAttribute("historico",historicoService.getHistoricoUltimoMes(l,e));
        else if(modoBusqueda==2)
            m.getModelMap().addAttribute("historico",historicoService.getHistoricoUltimos3Meses(l,e));
        else if(modoBusqueda==3)
            m.getModelMap().addAttribute("historico",historicoService.getHistoricoUltimoAno(l,e));
        else if(modoBusqueda==4)
            m.getModelMap().addAttribute("historico",historicoService.getHistorio(l,e));
        return m;
    }

    @RequestMapping(value="/ConsultaMaterialArmario")
    public ModelAndView consultaMaterialArmarioPage() {
        ModelAndView m= new ModelAndView("ConsultaMaterialArmario");
        m.getModelMap().addAttribute("lanzaderas",lanzaderaService.getLanzaderas());
        return m;
    }
    @RequestMapping(value="/ConsultaMaterialArmarioDetalle")
    public ModelAndView consultaMaterialArmarioDetallePage( @NotNull @RequestParam(value="lanzadera", required=false , defaultValue = "-1") int lanzadera) {
        ModelAndView m= new ModelAndView("ConsultaMaterialArmarioDetalle");
        System.out.println(lanzadera);
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("material",locationService.getCajasLanzadera(l));
        m.getModelMap().addAttribute("materialreserva",cajaEntabladoMedidaService.getCajasLanzadera(l));
        return m;
    }


    @RequestMapping(value="/ConsultaEntabladoCajaVacia" ,method = RequestMethod.GET )
    public ModelAndView consultaEntabladoCajaVaciaPage(@NotNull @RequestParam(value="lanzadera",required = true ,defaultValue = "-1") int lanzadera,
                                                       @NotNull @RequestParam(value = "entablado",required = true ,defaultValue = "-1") int entablado,
                                                       @NotNull @RequestParam(value = "fila",required = true ,defaultValue = "-1") int fila,
                                                       @NotNull @RequestParam(value = "columna",required = true ,defaultValue = "-1") int columna) {
        ModelAndView m =new ModelAndView("ConsultaEntabladoCajaVacia");
        Lanzadera l = lanzaderaService.getLanzadera(lanzadera);
        Entablado e = entabladoService.getEstanteria(l,entablado);
        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("ubicaciones",locationService.getCajasEntablado(l,e));
        m.getModelMap().addAttribute("reservas",cajaEntabladoMedidaService.getCajasEntablado(l,e));
        m.getModelMap().addAttribute("localizacionArticulo",locationService.getCajasEntablado(l,e,fila,columna));
        return m;
    }

    @RequestMapping(value="/ConsultaEntabladoCajaVaciaMedida" ,method = RequestMethod.GET )
    public ModelAndView consultaEntabladoCajaVaciaMedidaPage(@NotNull @RequestParam(value="lanzadera",required = true ,defaultValue = "-1") int lanzadera,
                                                             @NotNull @RequestParam(value = "entablado",required = true ,defaultValue = "-1") int entablado,
                                                             @NotNull @RequestParam(value = "fila",required = true ,defaultValue = "-1") int fila,
                                                             @NotNull @RequestParam(value = "columna",required = true ,defaultValue = "-1") int columna) {
        ModelAndView m =new ModelAndView("ConsultaEntabladoCajaVacia");
        Lanzadera l = lanzaderaService.getLanzadera(lanzadera);
        Entablado e = entabladoService.getEstanteria(l,entablado);
        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("ubicaciones",locationService.getCajasEntablado(l,e));
        m.getModelMap().addAttribute("reservas",cajaEntabladoMedidaService.getCajasEntablado(l,e));
        m.getModelMap().addAttribute("localizacionArticulo",cajaEntabladoMedidaService.getCajasEntablado(l,e,fila,columna));
        return m;
    }












}
