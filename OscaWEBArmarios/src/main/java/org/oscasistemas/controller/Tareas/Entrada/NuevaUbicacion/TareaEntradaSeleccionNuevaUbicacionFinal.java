package org.oscasistemas.controller.Tareas.Entrada.NuevaUbicacion;

import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.*;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.model.TipoCaja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 22/12/2017.
 */
@RestController
public class TareaEntradaSeleccionNuevaUbicacionFinal {

    @Autowired(required = true)
    private IEntablado entabladoService;
    @Autowired
    private ICajaEntablado locationService;

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;

    @Autowired (required = true)
    private ITipoCaja tipoCajaService;

    @Autowired
    private ILanzadera lanzaderaService;


    @RequestMapping(value="/TareaEntradaSeleccionNuevaUbicacionFinal")
    public ModelAndView TareaEntradaSeleccionUbicacionFinalPage(HttpServletRequest request,
                                                                @NotNull @RequestParam(value = "articulo" , required = true) String articulo,
                                                                @NotNull @RequestParam(value = "cantidad", required = true) String cantidad,
                                                                @NotNull @RequestParam(value = "entablado" , required = true ,defaultValue = "-1") String entablado,
                                                                @NotNull @RequestParam(value = "caja" ,required = true) String caja,
                                                                @NotNull @RequestParam(value = "idTarea" ,required = true , defaultValue = "1") int id_tarea) {
        ModelAndView m=new ModelAndView("Tarea/Entrada/NuevaUbicacion/TareaEntradaSeleccionNuevaUbicacionFinal");
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        Lanzadera l=lanzaderaService.getLanzaderaIp(remoteAddr);



        TipoCaja c=tipoCajaService.getTipoCaja(Integer.valueOf(caja));
        Entablado e= entabladoService.getEstanteria(entablado);
        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("lanzadera",l);
        //m.getModelMap().addAttribute("entablado",entabladoService.getEstanteria(l,entablado));
        //articulo= articulo.length()==9 ? articulo : String.format("%0" + (9 - articulo.length()) + "d%s", 0, articulo);
        m.getModelMap().addAttribute("articulo", WebServicesInit.articulosService.read(articulo));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(e));
        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(e));
        //m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(l,entabladoService.getEstanteria(l,entablado)));
        //m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(l,entabladoService.getEstanteria(l,entablado)));
        m.getModelMap().addAttribute("caja", c);
        m.getModelMap().addAttribute("id_tarea", id_tarea);
        return m;
    }

}
