package org.oscasistemas.controller.Tareas.Entrada.NuevaUbicacion;

import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.CajaEntablado;
import org.oscasistemas.model.Entablado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by José Ángel Caudevílla Casaús on 22/12/2017.
 */
@RestController
public class TareaEntradaSeleccionUbicacionFinal {


    @Autowired(required = true)
    private IEntablado entabladoService;
    @Autowired
    private ICajaEntablado locationService;

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;


    //EntradaSeleccionUbicacionfinal
    @RequestMapping(value="/TareaEntradaSeleccionUbicacionFinal")
    public ModelAndView entradaSeleccionUbicacionFinalPage(@NotNull @RequestParam(value="articulo", required=false) String articulo,
                                                           @NotNull @RequestParam(value="entablado", required=false , defaultValue = "PLNZ.00.0000") String entablado,
                                                           @NotNull @RequestParam(value="fila", required=false  , defaultValue = "-1") int fila,
                                                           @NotNull @RequestParam(value="columna", required=false  , defaultValue = "-1") int columna,
                                                           @NotNull @RequestParam(value="cantidad", required=false  , defaultValue = "-1") int cantidad,
                                                           @NotNull @RequestParam(value = "idTarea" ,required = false , defaultValue = "1") int id_tarea) {
        ModelAndView m=new ModelAndView("Tarea/Entrada/NuevaUbicacion/TareaEntradaSeleccionUbicacionFinal");

        //Entablado e=entabladoService.getEstanteria(l,entablado);
        Entablado e=entabladoService.getEstanteria(entablado);
        CajaEntablado c=locationService.getCajasEntablado(e,fila,columna);
        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("localizacionArticulo", c);
        m.getModelMap().addAttribute("infoArticulo", WebServicesInit.articulosService.read(c.getArticulo()));
        m.getModelMap().addAttribute("cantidad", cantidad);
        // m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(l,entabladoService.getEstanteria(l,entablado)));
        //m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(l,entabladoService.getEstanteria(l,entablado)));
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(e));
        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(e));
        m.getModelMap().addAttribute("id_tarea", id_tarea);
        return m;
    }
}
