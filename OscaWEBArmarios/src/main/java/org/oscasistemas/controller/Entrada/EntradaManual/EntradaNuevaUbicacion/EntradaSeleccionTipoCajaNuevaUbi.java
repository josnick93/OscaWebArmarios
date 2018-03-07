package org.oscasistemas.controller.Entrada.EntradaManual.EntradaNuevaUbicacion;

import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.DAO.interfaces.ITipoCaja;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 21/12/2017.
 */
@RestController
public class EntradaSeleccionTipoCajaNuevaUbi {


    @Autowired
    private ILanzadera lanzaderaService; //lift query service

    @Autowired (required = true)
    private ITipoCaja tipoCajaService; //box type query service

    /**
     *
     * @param request
     * @param articulo
     * @param cantidad
     * @param id_lanzadera
     * @param origen
     * @param cerrar
     * @return a page that allow to select a box to be created in a custom shelf
     */
    @RequestMapping(value="/EntradaSeleccionTipoCajaNuevaUbi" ,method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView entradaSeleccionTipoCajaNuevaUbi(HttpServletRequest request,
                                                         @NotNull @RequestParam(value = "articulo" ,required = true) String articulo,
                                                         @NotNull @RequestParam(value = "cantidad" ,required = true) String cantidad,
                                                         @NotNull @RequestParam(value = "lanzadera" ,required = true) int id_lanzadera,
                                                         @NotNull @RequestParam(value = "origen" ,required = true) String origen,
                                                         @NotNull @RequestParam(value="cerrar", required=false  , defaultValue = "-1") int cerrar)
    throws Exception{
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        ModelAndView m=new ModelAndView("Entrada/EntradaManual/NuevaUbicacion/TipoCajaNuevaUbicacion");

        m.getModelMap().addAttribute("articulo", WebServicesInit.articulosService.read(articulo));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("lanzadera", lanzaderaService.getLanzadera(id_lanzadera));
        m.getModelMap().addAttribute("cajas", tipoCajaService.getCajas());
        m.getModelMap().addAttribute("origen", origen);
        m.getModelMap().addAttribute("cerrar", cerrar);
        return m;
    }
}
