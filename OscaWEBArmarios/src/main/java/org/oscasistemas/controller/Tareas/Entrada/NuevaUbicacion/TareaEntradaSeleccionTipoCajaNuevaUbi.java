package org.oscasistemas.controller.Tareas.Entrada.NuevaUbicacion;

import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.DAO.interfaces.ITipoCaja;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by José Ángel Caudevílla Casaús on 22/12/2017.
 */
@RestController
public class TareaEntradaSeleccionTipoCajaNuevaUbi {


    @Autowired (required = true)
    private ITipoCaja tipoCajaService;

    @Autowired
    private ILanzadera lanzaderaService;



    @RequestMapping(value="/TareaEntradaSeleccionTipoCajaNuevaUbi" ,method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView TareaEntradaSeleccionTipoCajaNuevaUbi(@NotNull @RequestParam(value = "articulo" ,required = true) String articulo,
                                                              @NotNull @RequestParam(value = "cantidad" ,required = true) String cantidad,
                                                              @NotNull @RequestParam(value = "lanzadera" ,required = true) int id_lanzadera,
                                                              @NotNull @RequestParam(value = "idTarea" ,required = false , defaultValue = "1") int id_tarea)
    {
        ModelAndView m=new ModelAndView("Tarea/Entrada/NuevaUbicacion/TareaEntradaSeleccionTipoCajaNuevaUbi");
        m.getModelMap().addAttribute("articulo", WebServicesInit.articulosService.read(articulo));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("lanzadera", lanzaderaService.getLanzadera(id_lanzadera));
        m.getModelMap().addAttribute("cajas", tipoCajaService.getCajas());
        m.getModelMap().addAttribute("id_tarea", id_tarea);
        return m;
    }
}
