package org.oscasistemas.controller.Entrada.EntradaManual.EntradaSugerirUbicacion;

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
public class EntradaSeleccionTipoCajaSugerirUbi {


    @Autowired
    private ILanzadera lanzaderaService; //lift query service

    @Autowired (required = true)
    private ITipoCaja tipoCajaService;  //box type service

    /**
     *
     * @param request
     * @param articulo
     * @param cantidad
     * @param id_lanzadera
     * @param cerrar
     * @param origen
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/EntradaSeleccionTipoCajaSugerirUbi" ,method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView entradaSeleccionTipoCajaSugerirUbi(HttpServletRequest request,
                                                           @NotNull @RequestParam(value = "articulo" ,required = true) String articulo,
                                                           @NotNull @RequestParam(value = "cantidad" ,required = true) String cantidad,
                                                           @NotNull @RequestParam(value = "lanzadera" ,required = true , defaultValue = "-1" ) int id_lanzadera,
                                                           @NotNull @RequestParam(value="cerrar", required=false  , defaultValue = "-1") int cerrar,
                                                           @NotNull @RequestParam(value="origen", required=true  , defaultValue = "-1") String origen)
    throws  Exception{
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        ModelAndView m=new ModelAndView("Entrada/EntradaManual/SugerirUbicacion/TipoCajaSugerirUbicacion");
        m.getModelMap().addAttribute("articulo", WebServicesInit.articulosService.read(articulo));
        m.getModelMap().addAttribute("lanzadera", lanzaderaService.getLanzadera(id_lanzadera));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("cajas", tipoCajaService.getCajas());
        m.getModelMap().addAttribute("cerrar", cerrar);
        m.getModelMap().addAttribute("origen", origen);
        return m;
    }


}
