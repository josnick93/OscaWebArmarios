package org.oscasistemas.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import org.jboss.logging.Logger;
import org.oscasistemas.DAO.interfaces.*;
import org.oscasistemas.model.*;
import org.oscasistemas.service.interfaces.IArticuloService;
import org.oscasistemas.util.Posiciones;
import org.oscasistemas.util.SugerirUbicaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Portátil1 on 03/08/2017.
 */
@RestController
public class TareaController {

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

    @Autowired
    private IAcciones accionesService;

    @Autowired
    private ITareasPendientes tareasPendientesService;


    private static final Logger logger = Logger.getLogger(TareaController.class);

    public TareaController() {
        System.out.println("TareaEntradaSeleccionTipoCajaNuevaUbi()");
    }

    @RequestMapping(value="/TareaSeleccionTarea"  ,method = RequestMethod.GET )
    public ModelAndView tareasPendietesPage(@NotNull @RequestParam(value="lanzadera",required = true ,defaultValue = "-1") int lanzadera) {
        ModelAndView m=new ModelAndView("TareaSeleccionTarea");
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("tareas",tareasPendientesService.getTareasPendientesLanzadera(l));
        return m;
    }


    @RequestMapping(value="/TareaEntradaSeleccionTipoCajaSugerirUbi" ,method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView TareaEntradaSeleccionTipoCajaSugerirUbi(@NotNull @RequestParam(value = "articulo" ,required = true) String articulo,
                                                              @NotNull @RequestParam(value = "cantidad" ,required = true) String cantidad,
                                                              @NotNull @RequestParam(value = "lanzadera" ,required = true) int id_lanzadera,
                                                              @NotNull @RequestParam(value = "idTarea" ,required = true) int id_tarea
    ) {
        ModelAndView m=new ModelAndView("TareaEntradaSeleccionTipoCajaSugerirUbi");
        m.getModelMap().addAttribute("articulo", articuloService.getArticulo(articulo));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("lanzadera", lanzaderaService.getLanzadera(id_lanzadera));
        m.getModelMap().addAttribute("cajas", tipoCajaService.getCajas());
        m.getModelMap().addAttribute("id_tarea", id_tarea);
        return m;
    }



    @RequestMapping(value="/TareaEntradaSeleccionTipoCajaNuevaUbi" ,method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView TareaEntradaSeleccionTipoCajaNuevaUbi(@NotNull @RequestParam(value = "articulo" ,required = true) String articulo,
                                                              @NotNull @RequestParam(value = "cantidad" ,required = true) String cantidad,
                                                              @NotNull @RequestParam(value = "lanzadera" ,required = true) int id_lanzadera,
                                                              @NotNull @RequestParam(value = "idTarea" ,required = true) int id_tarea)
    {
        ModelAndView m=new ModelAndView("TareaEntradaSeleccionTipoCajaNuevaUbi");
        m.getModelMap().addAttribute("articulo", articuloService.getArticulo(articulo));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("lanzadera", lanzaderaService.getLanzadera(id_lanzadera));
        m.getModelMap().addAttribute("cajas", tipoCajaService.getCajas());
        m.getModelMap().addAttribute("id_tarea", id_tarea);
        return m;
    }


    //EntradaSeleccionUbicacionfinal
    @RequestMapping(value="/TareaEntradaSeleccionNuevaUbicacionFinal")
    public ModelAndView TareaEntradaSeleccionUbicacionFinalPage(@NotNull @RequestParam(value = "articulo" , required = true) String articulo,
                                                                @NotNull @RequestParam(value = "cantidad", required = true) String cantidad,
                                                                @NotNull @RequestParam(value = "lanzadera", required = true ,defaultValue = "-1") int lanzadera,
                                                                @NotNull @RequestParam(value = "entablado" , required = true ,defaultValue = "-1") int entablado,
                                                                @NotNull @RequestParam(value = "caja" ,required = true) String caja,
                                                                @NotNull @RequestParam(value = "idTarea" ,required = true) int id_tarea) {
        ModelAndView m=new ModelAndView("TareaEntradaSeleccionNuevaUbicacionFinal");
        TipoCaja c=tipoCajaService.getTipoCaja(Integer.valueOf(caja));
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("entablado",entabladoService.getEstanteria(l,entablado));
        articulo= articulo.length()==9 ? articulo : String.format("%0" + (9 - articulo.length()) + "d%s", 0, articulo);
        m.getModelMap().addAttribute("articulo", articuloService.getArticulo(articulo));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(l,entabladoService.getEstanteria(l,entablado)));
        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(l,entabladoService.getEstanteria(l,entablado)));
        m.getModelMap().addAttribute("caja", c);
        m.getModelMap().addAttribute("id_tarea", id_tarea);
        return m;
    }


    //EntradaSugerirUbicacionfinal
    @RequestMapping(value="/TareaEntradaSugerirUbicacionFinal")
    public ModelAndView TareaEntradaSugerirUbicacionFinalPage(@NotNull @RequestParam(value="articulo", required=false) String articulo,
                                                         @NotNull @RequestParam(value="lanzadera", required=false , defaultValue = "-1") int lanzadera,
                                                         @NotNull @RequestParam(value="cantidad", required=false  , defaultValue = "-1") int cantidad,
                                                         @NotNull @RequestParam(value="caja", required = false , defaultValue = "-1") int caja,
                                                         @NotNull @RequestParam(value="nsugerencia", required = false , defaultValue = "0") int nsugerencia,
                                                              @NotNull @RequestParam(value = "idTarea" ,required = true) int id_tarea) {
        ModelAndView m=new ModelAndView("TareaEntradaSugerirUbicacionFinal");
        Articulo a=articuloService.getArticulo(articulo);
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        TipoCaja c=tipoCajaService.getTipoCaja(caja);
        //listar entablados que no superen el peso y no esten vacios
        List<Entablado> posiblesEntablados=entabladoService.getEstanteriasNoSuperanPeso(l,a.getPeso()*cantidad,c);
        List<CajaEntablado> ubicaciones=locationService.getCajasEntablado(l,posiblesEntablados.get(nsugerencia));
        List<CajaEntabladoMedida> reservas=cajaEntabladoMedidaService.getCajasEntablado(l,posiblesEntablados.get(nsugerencia));
        SugerirUbicaciones.obtenerPosicionesSubdivision2x1(ubicaciones,c);
        //buscarPosiciones
        List<Posiciones> posiciones=null;
        List<Posiciones> posicionesSubdivision=new ArrayList<Posiciones>();
        posiciones=SugerirUbicaciones.obtenerPosiciones(ubicaciones,reservas,c);
        if(c.getId_caja()==10){
            posicionesSubdivision=SugerirUbicaciones.obtenerPosicionesSubdivision2x1(ubicaciones,c);
        }else if(c.getId_caja()==11){
            posicionesSubdivision=SugerirUbicaciones.obtenerPosicionesSubdivision1x1(ubicaciones,c);
        }
        while((posiciones=SugerirUbicaciones.obtenerPosiciones(ubicaciones,reservas,c)).isEmpty()){
            nsugerencia++;
            ubicaciones=locationService.getCajasEntablado(l,posiblesEntablados.get(nsugerencia));
            reservas=cajaEntabladoMedidaService.getCajasEntablado(l,posiblesEntablados.get(nsugerencia));
            if(c.getId_caja()==10){
                posicionesSubdivision=SugerirUbicaciones.obtenerPosicionesSubdivision2x1(ubicaciones,c);
            }else if(c.getId_caja()==11){
                posicionesSubdivision=SugerirUbicaciones.obtenerPosicionesSubdivision1x1(ubicaciones,c);
            }
        }

        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("entablado",posiblesEntablados.get(nsugerencia));
        m.getModelMap().addAttribute("articulo",a);
        m.getModelMap().addAttribute("nsugerencia",nsugerencia);
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("ubicaciones", ubicaciones);
        m.getModelMap().addAttribute("reservas", reservas);
        m.getModelMap().addAttribute("TipoCaja", c);
        m.getModelMap().addAttribute("posiblesPosiciones", new Gson().toJson(posiciones) );
        m.getModelMap().addAttribute("posiblesPosicionesSubdivision", new Gson().toJson(posicionesSubdivision) );
        m.getModelMap().addAttribute("id_tarea", id_tarea);
        return m;
    }

    //EntradaSeleccionUbicacionfinal
    @RequestMapping(value="/TareaEntradaSeleccionUbicacionFinal")
    public ModelAndView entradaSeleccionUbicacionFinalPage(@NotNull @RequestParam(value="articulo", required=false) String articulo,
                                                           @NotNull @RequestParam(value="lanzadera", required=false , defaultValue = "-1") int lanzadera,
                                                           @NotNull @RequestParam(value="entablado", required=false , defaultValue = "-1") int entablado,
                                                           @NotNull @RequestParam(value="fila", required=false  , defaultValue = "-1") int fila,
                                                           @NotNull @RequestParam(value="columna", required=false  , defaultValue = "-1") int columna,
                                                           @NotNull @RequestParam(value="cantidad", required=false  , defaultValue = "-1") int cantidad,
                                                           @NotNull @RequestParam(value = "idTarea" ,required = true) int id_tarea) {
        ModelAndView m=new ModelAndView("TareaEntradaSeleccionUbicacionFinal");
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        Entablado e=entabladoService.getEstanteria(l,entablado);
        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("localizacionArticulo", locationService.getCajasEntablado(l,e,fila,columna));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(l,entabladoService.getEstanteria(l,entablado)));
        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(l,entabladoService.getEstanteria(l,entablado)));
        m.getModelMap().addAttribute("id_tarea", id_tarea);
        return m;
    }

    @RequestMapping(value="/TareaSalidaSeleccionUbicacionFinal")
    public ModelAndView salidaSeleccionUbicacionFinalPage(@NotNull @RequestParam(value="articulo", required=false) String articulo,
                                                          @NotNull @RequestParam(value="lanzadera", required=false , defaultValue = "-1") int lanzadera,
                                                          @NotNull @RequestParam(value="entablado", required=false , defaultValue = "-1") int entablado,
                                                          @NotNull @RequestParam(value="fila", required=false  , defaultValue = "-1") int fila,
                                                          @NotNull @RequestParam(value="columna", required=false  , defaultValue = "-1") int columna,
                                                          @NotNull @RequestParam(value="cantidad", required=false  , defaultValue = "-1") int cantidad,
                                                          @NotNull @RequestParam(value = "idTarea" ,required = true) int id_tarea) {
        ModelAndView m=new ModelAndView("TareaSalidaSeleccionUbicacionFinal");
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        Entablado e=entabladoService.getEstanteria(l,entablado);
        m.getModelMap().addAttribute("lanzadera",l);
        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("localizacionArticulo", locationService.getCajasEntablado(l,e,fila,columna));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(l,entabladoService.getEstanteria(l,entablado)));
        m.getModelMap().addAttribute("id_tarea", id_tarea);
        return m;
    }



    @RequestMapping(value = "Operacion/BorrarTarea",method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String borrarTarea(Model model,  @NotNull @RequestParam(value = "idTarea" ,required = true, defaultValue = "-1") int id_tarea) {
        tareasPendientesService.remove(tareasPendientesService.getTareaPendiente(id_tarea));
        return "";
    }


}
