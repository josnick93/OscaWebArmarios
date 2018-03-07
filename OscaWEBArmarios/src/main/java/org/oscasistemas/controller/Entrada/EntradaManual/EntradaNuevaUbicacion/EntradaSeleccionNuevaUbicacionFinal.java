package org.oscasistemas.controller.Entrada.EntradaManual.EntradaNuevaUbicacion;

import com.dynamics.webServices.Item_Card_WS.ItemCardWS;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.*;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.TipoCaja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 21/12/2017.
 */
@RestController
public class EntradaSeleccionNuevaUbicacionFinal {


    @Autowired
    private ILanzadera lanzaderaService; //lift query service

    @Autowired (required = true)
    private ITipoCaja tipoCajaService;  //box query type
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
     * @param cantidad
     * @param entablado
     * @param caja
     * @param origen
     * @param cerrar
     * @return return a page that allow to create new box in a shelf
     * @throws Exception return error page with info
     */
    @RequestMapping(value="/EntradaSeleccionNuevaUbicacionFinal" ,method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView entradaSeleccionNuevaUbicacionFinal(HttpServletRequest request,
                                                            @NotNull @RequestParam(value = "articulo" , required = true) String articulo,
                                                            @NotNull @RequestParam(value = "cantidad", required = true) String cantidad,
                                                            @NotNull @RequestParam(value = "entablado" , required = true ,defaultValue = "PLNZ.00.0000") String entablado,
                                                            @NotNull @RequestParam(value = "caja" ,required = true) int caja,
                                                            @NotNull @RequestParam(value = "origen" ,required = true ,defaultValue = "PLNZ.00.0000") String origen,
                                                            @NotNull @RequestParam(value = "cerrar" , required = false ,defaultValue = "-1") int cerrar)
            throws Exception {
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

        ModelAndView m=new ModelAndView("Entrada/EntradaManual/NuevaUbicacion/NuevaUbicacion");
        TipoCaja c=tipoCajaService.getTipoCaja(caja);
        //get article info From WebService
        ItemCardWS myItemCardWS= WebServicesInit.articulosService.read(articulo);


        Entablado e = entabladoService.getEstanteria(entablado);
        //ip is a lift or not?
        m.getModelMap().addAttribute("lanzadera",lanzaderaService.getLanzaderaIp(remoteAddr));
        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("articulo",myItemCardWS );
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(e));
        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(e));
        m.getModelMap().addAttribute("caja", c);
        m.getModelMap().addAttribute("origen", origen);
        m.getModelMap().addAttribute("cerrar", cerrar);
        return m;
    }
}
