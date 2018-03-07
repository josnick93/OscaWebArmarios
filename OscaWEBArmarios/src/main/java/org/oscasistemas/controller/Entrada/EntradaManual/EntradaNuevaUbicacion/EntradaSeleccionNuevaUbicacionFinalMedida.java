package org.oscasistemas.controller.Entrada.EntradaManual.EntradaNuevaUbicacion;

import com.dynamics.webServices.Item_Card_WS.ItemCardWS;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.*;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.Entablado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 21/12/2017.
 */
@RestController
public class EntradaSeleccionNuevaUbicacionFinalMedida {



    @Autowired
    private ILanzadera lanzaderaService; //lift query service

    @Autowired (required = true)
    private IEntablado entabladoService;  //shelf query service
    @Autowired
    private ICajaEntablado locationService;  //box query service

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService; //custom box query service


    /**
     *
     * @param request
     * @param articulo
     * @param origen
     * @param entablado
     * @param fila
     * @param columna
     * @param cantidad
     * @param cerrar
     * @return return a page that allow to create new custom box in a shelf
     * @throws Exception
     */
    @RequestMapping(value="/EntradaSeleccionNuevaUbicacionFinalMedida" ,method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView entradaSeleccionNuevaUbicacionFinalMedida(HttpServletRequest request,
                                                                  @NotNull @RequestParam(value="articulo", required=false) String articulo,
                                                                  @NotNull @RequestParam(value="origen", required=true) String origen,
                                                                  @NotNull @RequestParam(value="entablado", required=false , defaultValue = "PLNZ.00.0000") String entablado,
                                                                  @NotNull @RequestParam(value="cajafila", required=false  , defaultValue = "-1") int fila,
                                                                  @NotNull @RequestParam(value="cajacolumna", required=false  , defaultValue = "-1") int columna,
                                                                  @NotNull @RequestParam(value="cantidad", required=false  , defaultValue = "-1") int cantidad,
                                                                  @NotNull @RequestParam(value="cerrar", required=false  , defaultValue = "-1") int cerrar
    ) throws Exception {

        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        ModelAndView m=new ModelAndView("Entrada/EntradaManual/NuevaUbicacion/NuevaUbicacionMedida");
        Entablado e=entabladoService.getEstanteria(entablado);
        ItemCardWS myItemCardWS= WebServicesInit.articulosService.read(articulo);


        m.getModelMap().addAttribute("lanzadera",lanzaderaService.getLanzaderaIp(remoteAddr));
        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("articulo", myItemCardWS);
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(e));
        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(e));
        m.getModelMap().addAttribute("filascaja", fila);
        m.getModelMap().addAttribute("columnascaja", columna);
        m.getModelMap().addAttribute("cerrar", cerrar);
        m.getModelMap().addAttribute("origen", origen);
        return m;
    }
}
