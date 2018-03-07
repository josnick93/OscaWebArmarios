package org.oscasistemas.controller.Consulta.Entablado;

import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.model.Entablado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 29/12/2017.
 */
@RestController
public class ConsultaEntablado {

    @Autowired(required = true)
    private IEntablado entabladoService; //shelf query

    @Autowired
    private ILanzadera lanzaderaService; //lift query

    @Autowired
    private ICajaEntablado locationService; //box query

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService; //custom box query


    /**
     * URL:http://192.168.2.8/OscaArmarios/ConsultaSeleccionEntablado.html
     * @param request
     * @param model
     * @param entablado
     * @return
     */
    @RequestMapping(value="/ConsultaEntablado" ,method = RequestMethod.GET )
    public ModelAndView consultaEntabladoPage(HttpServletRequest request, Model model,
                                              @NotNull @RequestParam(value = "entablado",required = true
                                                      ,defaultValue = "PLNZ.00.0000") String entablado )
    throws Exception
    {
        ModelAndView m =new ModelAndView("Consulta/Entablado/ConsultaEntablado");
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        Entablado e=entabladoService.getEstanteria(entablado);

        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("lanzadera",lanzaderaService.getLanzaderaIp(remoteAddr));
        m.getModelMap().addAttribute("ubicaciones",locationService.getCajasEntablado(e));
        m.getModelMap().addAttribute("reservas",cajaEntabladoMedidaService.getCajasEntablado(e));
        return m;
    }
}
