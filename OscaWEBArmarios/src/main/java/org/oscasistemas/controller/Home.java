package org.oscasistemas.controller;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.oscasistemas.DAO.interfaces.IAcessoLazaderas;
import org.oscasistemas.DAO.interfaces.IAdministrador;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.DAO.interfaces.ITareasPendientes;
import org.oscasistemas.model.AcessoLanzadera;
import org.oscasistemas.model.Administrador;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.model.TareasPendientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 08/05/2017.
 */

@Controller

public class Home {
    @Autowired
    private ILanzadera lanzaderaService;

    @Autowired(required = true)
    private IAdministrador administradorService;

    @Autowired
    private IAcessoLazaderas acessoLazaderasService;

    @Autowired
    private ITareasPendientes tareasPendientesService;

    private static final Logger logger = Logger.getLogger(Home.class);




    //carga la pagina principal
    @RequestMapping(value="/")
    public ModelAndView mainPage(HttpServletRequest request) {

        String remoteAddr = "";
        /**
         * Get address
         */
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        ModelAndView m=new ModelAndView("Home");
        if (remoteAddr == null || "".equals(remoteAddr))
            remoteAddr = request.getRemoteAddr();
        /**
         * Comprobar direccion Ip
         */
        //comprobar si es lanzadera
        Lanzadera l=null;
        List<TareasPendientes> tareas=new ArrayList<TareasPendientes>();
        m.getModelMap().addAttribute("ip",remoteAddr);
        if((l=lanzaderaService.getLanzaderaIp(remoteAddr))!=null){
            //mostrar tareas de esa lanzadera
            m.getModelMap().addAttribute("EsLanzadera",true);
            m.getModelMap().addAttribute("Lanzadera",l);
            m.getModelMap().addAttribute("TareasPendientes",tareasPendientesService.getTareasPendientesLanzadera(l));
        }
        else {
            m.getModelMap().addAttribute("EsLanzadera",false);
        }
        Administrador a=null;
        //comprobar si es administrador
        if((a=administradorService.getAdministrador(remoteAddr))!=null){
            //activar opcion administrador
            m.getModelMap().addAttribute("EsAdministrador",true);
        }else {
            m.getModelMap().addAttribute("EsAdministrador",false);
        }
        //tareas de ese ordenador
        List<AcessoLanzadera> acesos=new ArrayList<AcessoLanzadera>();
        if(!(acesos=acessoLazaderasService.getLanzaderas(remoteAddr)).isEmpty()){
            //buscar Tareas
            for(AcessoLanzadera ac:acesos)
                tareas.addAll(tareasPendientesService.getTareasPendientesLanzadera(ac.getLanzadera()));
            m.getModelMap().addAttribute("TareasPendientes",tareas);
        }

        return m;

    }
    //carga  home desde login
    @RequestMapping(value="/Ejemplo")
    public ModelAndView ejemploPage() {
        return new ModelAndView("Ejemplo");
    }

    //carga  home desde login
    @RequestMapping(value="/Prueba")
    public ModelAndView pruebaPage() {
        return new ModelAndView("Prueba");
    }

    //carga  home desde login
    @RequestMapping(value = "Operacion/PruebaAjax", method = RequestMethod.GET)
    public @ResponseBody
    String pruebaAjax() {

        return new Gson().toJson("OK");
    }


    @RequestMapping(value="/uknowError")
    public ModelAndView uknowError() {
        System.out.println("Error desconocido");
        return new ModelAndView("ConfiguradorArticulos");
    }

    @RequestMapping(value="/AdministradorHome")
    public ModelAndView administradorPage() {
        return new ModelAndView("Administracion/AdministradorHome");
    }

    @RequestMapping(value="/ConfiguradorArticulos")
    public ModelAndView condifuradorArticulosPage() {
        return new ModelAndView("ConfiguradorArticulos");
    }



    @RequestMapping(value="/Home")
    public ModelAndView indexPage(HttpServletRequest request) {
        String remoteAddr = "";
        /**
         * Get address
         */
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        ModelAndView m=new ModelAndView("Home");
        if (remoteAddr == null || "".equals(remoteAddr))
            remoteAddr = request.getRemoteAddr();
        /**
         * Comprobar direccion Ip
         */
        //comprobar si es lanzadera
        Lanzadera l=null;
        List<TareasPendientes> tareas=new ArrayList<TareasPendientes>();
        m.getModelMap().addAttribute("ip",remoteAddr);
        if((l=lanzaderaService.getLanzaderaIp(remoteAddr))!=null){
            //mostrar tareas de esa lanzadera
            m.getModelMap().addAttribute("EsLanzadera",true);
            m.getModelMap().addAttribute("Lanzadera",l);
            m.getModelMap().addAttribute("TareasPendientes",tareasPendientesService.getTareasPendientesLanzadera(l));
        }
        else {
            m.getModelMap().addAttribute("EsLanzadera",false);
        }
        Administrador a=null;
        //comprobar si es administrador
        if((a=administradorService.getAdministrador(remoteAddr))!=null){
            //activar opcion administrador
            m.getModelMap().addAttribute("EsAdministrador",true);
        }else {
            m.getModelMap().addAttribute("EsAdministrador",false);
        }
        //tareas de ese ordenador
        List<AcessoLanzadera> acesos=new ArrayList<AcessoLanzadera>();
        if(!(acesos=acessoLazaderasService.getLanzaderas(remoteAddr)).isEmpty()){
            //buscar Tareas
            for(AcessoLanzadera ac:acesos)
                tareas.addAll(tareasPendientesService.getTareasPendientesLanzadera(ac.getLanzadera()));
            m.getModelMap().addAttribute("TareasPendientes",tareas);
        }

        return m;
    }



}
