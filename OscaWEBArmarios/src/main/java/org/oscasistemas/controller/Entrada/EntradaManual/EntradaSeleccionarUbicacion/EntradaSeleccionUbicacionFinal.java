package org.oscasistemas.controller.Entrada.EntradaManual.EntradaSeleccionarUbicacion;

import com.sun.istack.NotNull;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.Entablado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 26/12/2017.
 */
@RestController
public class EntradaSeleccionUbicacionFinal {


    @Autowired
    private ILanzadera lanzaderaService; //lift query service

    @Autowired (required = true)
    private IEntablado entabladoService; //shelf query service
    @Autowired
    private ICajaEntablado locationService; //box query service

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService; //custom query box service


    /**
     *
     * @param request
     * @param articulo
     * @param entablado
     * @param fila
     * @param columna
     * @param cantidad
     * @param cerrar
     * @param origen
     * @return a page that allow to add material on a box
     */
    @RequestMapping(value="/EntradaSeleccionUbicacionFinal")
    public ModelAndView entradaSeleccionUbicacionFinalPage(HttpServletRequest request,
                                                           @NotNull @RequestParam(value="articulo", required=true) String articulo,
                                                           @NotNull @RequestParam(value="entablado", required=true , defaultValue = "PLNZ.00.0000") String entablado,
                                                           @NotNull @RequestParam(value="fila", required=true  , defaultValue = "-1") int fila,
                                                           @NotNull @RequestParam(value="columna", required=true  , defaultValue = "-1") int columna,
                                                           @NotNull @RequestParam(value="cantidad", required=true  , defaultValue = "-1") int cantidad,
                                                           @NotNull @RequestParam(value="cerrar", required=false  , defaultValue = "-1") int cerrar,
                                                           @NotNull @RequestParam(value="origen", required=false  , defaultValue = "-1") String origen)
    throws Exception{
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        ModelAndView m=new ModelAndView("Entrada/EntradaManual/EntradaUbicacion/EntradaSeleccionUbicacionFinal");
        Entablado  e=entabladoService.getEstanteria(entablado);


        m.getModelMap().addAttribute("articulo", WebServicesInit.articulosService.read(articulo));
        m.getModelMap().addAttribute("lanzadera",lanzaderaService.getLanzaderaIp(remoteAddr));
        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("localizacionArticulo", locationService.getCajasEntablado(e,fila,columna));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(e));
        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(e));
        m.getModelMap().addAttribute("cerrar", cerrar);
        m.getModelMap().addAttribute("origen", origen);
        return m;
    }
}
