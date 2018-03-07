package org.oscasistemas.controller.Consulta.EliminarCajasVacias;

import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.model.Lanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 29/12/2017.
 */
@RestController
public class ConsultaEliminarCajasVacias {

    @Autowired
    private ICajaEntablado locationService;

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;

    @Autowired
    private ILanzadera lanzaderaService;


    /**
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/ConsultaEliminarCajasVacias" , method = RequestMethod.GET )
    @ResponseBody
    public ModelAndView listCajasVacias(HttpServletRequest request) throws  Exception{
        ModelAndView m=new ModelAndView("Consulta/CajasVacias/ConsultaCajasVacias");
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        Lanzadera l=lanzaderaService.getLanzaderaIp(remoteAddr);
        if(l!=null){
            m.getModelMap().addAttribute("lanzadera",l);
            m.getModelMap().addAttribute("ubicaciones", locationService.getCajasVacias(l));
        }else {
            m.getModelMap().addAttribute("ubicaciones", locationService.getCajasVacias());
        }
        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasVacias());
        return m;
    }
}
