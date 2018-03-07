package org.oscasistemas.controller.Entrada.EntradaMaterial.EntradaPedido.CrearUbicacion;

import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.*;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.Entablado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

import static org.oscasistemas.controller.Entrada.EntradaMaterial.Utils.EntradaPedidoUtils.obtenerLineaPedido;
import static org.oscasistemas.controller.Entrada.EntradaMaterial.Utils.EntradaPedidoUtils.obtenerPedido;

/**
 * Created by José Ángel Caudevilla Casaus on 19/01/2018.
 */
@RestController
public class EntradaArticuloPedidoSeleccionNuevaUbicacionFinal {

    @Autowired
    private ILanzadera lanzaderaService; //lift service

    @Autowired (required = true)
    private ITipoCaja tipoCajaService;  //box type service
    @Autowired (required = true)
    private IEntablado entabladoService; //shelf service
    @Autowired
    private ICajaEntablado locationService; //box service

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService; //custom box service

    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value="/EntradaArticuloPedidoSeleccionNuevaUbicacionFinal",method = RequestMethod.GET)
    public ModelAndView EntradaArticuloPedidoSeleccionNuevaUbicacionFinalPage(HttpServletRequest request, @NotNull @RequestParam(value = "articulo" , required = true) String articulo,
                                              @NotNull @RequestParam(value = "pedido" , required = true) String pedido,
                                              @NotNull @RequestParam(value = "linea" , required = true) int  lineNo,
                                              @NotNull @RequestParam(value = "entablado" , required = true ,defaultValue = "PLNZ.00.0000") String entablado,
                                              @NotNull @RequestParam(value = "caja" ,required = true) String caja,
                                              @NotNull @RequestParam(value = "cerrar" , required = false ,defaultValue = "0") int cerrar)
    throws Exception{
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        ModelAndView m= new ModelAndView("Entrada/EntradaMaterial/EntradaPedido/NuevaUbicacion/PedidoNuevaUbicacion");

        Entablado e = entabladoService.getEstanteria(entablado);
        m.getModelMap().addAttribute("lanzadera",lanzaderaService.getLanzaderaIp(remoteAddr));
        m.getModelMap().addAttribute("entablado",e);
        //Comprobacion con nav

        m.getModelMap().addAttribute("articulo",WebServicesInit.articulosService.read(articulo) );
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(e));
        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(e));
        m.getModelMap().addAttribute("caja", tipoCajaService.getTipoCaja(Integer.valueOf(caja)));
        m.getModelMap().addAttribute("cerrar", cerrar);
        m.getModelMap().addAttribute("pedido", obtenerPedido(pedido));
        m.getModelMap().addAttribute("lineaPedido", obtenerLineaPedido(pedido,lineNo));

        return m;
    }
}
