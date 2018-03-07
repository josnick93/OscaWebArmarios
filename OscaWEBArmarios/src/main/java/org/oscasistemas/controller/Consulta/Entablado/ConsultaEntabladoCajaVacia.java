package org.oscasistemas.controller.Consulta.Entablado;

import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.CajaEntablado;
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
public class ConsultaEntabladoCajaVacia {

    @Autowired(required = true)
    private IEntablado entabladoService; //shelf query service
    @Autowired
    private ICajaEntablado locationService; //box query service

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService; //custom box query service


    @Autowired
    private ILanzadera lanzaderaService; //lift query service

    /**
     *
     * @param request
     * @param model
     * @param entablado
     * @param fila
     * @param columna
     * @return
     */
    @RequestMapping(value="/ConsultaEntabladoCajaVacia" ,method = RequestMethod.GET )
    public ModelAndView consultaEntabladoCajaVaciaPage(HttpServletRequest request, Model model,
                                                       @NotNull @RequestParam(value = "entablado",required = true
                                                               ,defaultValue = "-1") String entablado,
                                                       @NotNull @RequestParam(value = "fila",required = true
                                                               ,defaultValue = "-1") int fila,
                                                       @NotNull @RequestParam(value = "columna",required = true
                                                               ,defaultValue = "-1") int columna)
    throws Exception{
        ModelAndView m =new ModelAndView("Consulta/CajasVacias/ConsultaCajaVaciaEntablado");


        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

        Entablado e=entabladoService.getEstanteria(entablado);
        CajaEntablado c=locationService.getCajasEntablado(e,fila,columna);


        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("lanzadera",lanzaderaService.getLanzaderaIp(remoteAddr));
        m.getModelMap().addAttribute("ubicaciones",locationService.getCajasEntablado(e));
        m.getModelMap().addAttribute("articulo", WebServicesInit.articulosService.read(c.getArticulo()));
        m.getModelMap().addAttribute("reservas",cajaEntabladoMedidaService.getCajasEntablado(e));
        m.getModelMap().addAttribute("localizacionArticulo",c);
        return m;
    }
}
