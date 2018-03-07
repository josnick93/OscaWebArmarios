package org.oscasistemas.controller.Consulta.Articulo;

import com.dynamics.webServices.Item_Card_WS.ItemCardWS;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 29/12/2017.
 */
@RestController
public class ConsultaArticulo {

    @Autowired
    private ICajaEntablado locationService; //box query


    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService; //custom box query

    @Autowired
    private ILanzadera lanzaderaService; //lift query

    /**
     * URL
     * @param request
     * @param model
     * @param articulo
     * @return
     */
    @RequestMapping(value="/ConsultaArticulo")
    public ModelAndView consultaArticulo(HttpServletRequest request, Model model,
                                         @NotNull @RequestParam(value = "articulo" ,
                                                 required = false, defaultValue = "000000000") String articulo)
    throws Exception{

        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

        ItemCardWS a=WebServicesInit.articulosService.read(articulo);

        ModelAndView m=new ModelAndView("Consulta/Articulo/ConsultaArticulo");
        m.getModelMap().addAttribute("articulo", a);
        m.getModelMap().addAttribute("lanzadera", lanzaderaService.getLanzaderaIp(remoteAddr));
        m.getModelMap().addAttribute("ubicaciones",locationService.getUbicacionesArticulo(a));
        m.getModelMap().addAttribute("reservas",cajaEntabladoMedidaService.getUbicacionesArticulo(a));
        return m;
    }
}
