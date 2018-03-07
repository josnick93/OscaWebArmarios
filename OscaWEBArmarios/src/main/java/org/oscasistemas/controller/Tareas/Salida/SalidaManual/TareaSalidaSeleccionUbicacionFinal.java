package org.oscasistemas.controller.Tareas.Salida.SalidaManual;

import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.CajaEntablado;
import org.oscasistemas.model.Entablado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 22/12/2017.
 */
public class TareaSalidaSeleccionUbicacionFinal {

    @Autowired(required = true)
    private IEntablado entabladoService;
    @Autowired
    private ICajaEntablado locationService;

    @RequestMapping(value="/TareaSalidaSeleccionUbicacionFinal")
    public ModelAndView salidaSeleccionUbicacionFinalPage(HttpServletRequest request,
                                                          @NotNull @RequestParam(value="articulo", required=false) String articulo,
                                                          @NotNull @RequestParam(value="entablado", required=false , defaultValue = "-1") String entablado,
                                                          @NotNull @RequestParam(value="fila", required=false  , defaultValue = "-1") int fila,
                                                          @NotNull @RequestParam(value="columna", required=false  , defaultValue = "-1") int columna,
                                                          @NotNull @RequestParam(value="cantidad", required=false  , defaultValue = "-1") int cantidad,
                                                          @NotNull @RequestParam(value = "idTarea" ,required = false, defaultValue="1") int id_tarea) {
        ModelAndView m=new ModelAndView("Tarea/Salida/TareaSalidaSeleccionUbicacionFinal");
        //Entablado e=entabladoService.getEstanteria(l,entablado);
        Entablado e=entabladoService.getEstanteria(entablado);
        CajaEntablado c= locationService.getCajasEntablado(e,fila,columna);
        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("localizacionArticulo",c);
        m.getModelMap().addAttribute("articulo", WebServicesInit.articulosService.read(c.getArticulo()));
        m.getModelMap().addAttribute("cantidad", cantidad);
        //m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(l,entabladoService.getEstanteria(l,entablado)));
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(e));
        m.getModelMap().addAttribute("id_tarea", id_tarea);
        return m;
    }

}
