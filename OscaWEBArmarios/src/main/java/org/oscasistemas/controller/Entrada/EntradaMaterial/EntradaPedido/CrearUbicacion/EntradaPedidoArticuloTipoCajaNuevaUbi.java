package org.oscasistemas.controller.Entrada.EntradaMaterial.EntradaPedido.CrearUbicacion;

import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.controller.WebService.WebServicesInit;
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
public class EntradaPedidoArticuloTipoCajaNuevaUbi {


    @Autowired
    private ILanzadera lanzaderaService; //lift service

    /**
     *
     * @param request
     * @param pedido
     * @param articulo
     * @param lineNo
     * @return
     */
    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value="/EntradaPedidoArticuloTipoCajaNuevaUbi",method = RequestMethod.GET)
    public ModelAndView EntradaPedidoArticuloTipoCajaNuevaUbiPage(HttpServletRequest request, @NotNull @RequestParam(value = "pedido" , required = true) String pedido,
                                              @NotNull @RequestParam(value = "articulo" , required = true) String articulo,
                                              @NotNull @RequestParam(value = "linea" , required = true) int  lineNo)
    throws Exception{
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        ModelAndView m= new ModelAndView("Entrada/EntradaMaterial/EntradaPedido/NuevaUbicacion/PedidoNuevaUbicacionTipoCaja");



        m.getModelMap().addAttribute("cerrar",0);
        m.getModelMap().addAttribute("lanzadera",lanzaderaService.getLanzaderaIp(remoteAddr));
        m.getModelMap().addAttribute("articulo", WebServicesInit.articulosService.read(articulo));
        m.getModelMap().addAttribute("pedido", obtenerPedido(pedido));
        m.getModelMap().addAttribute("lineaPedido", obtenerLineaPedido(pedido,lineNo));
        return m;
    }




}
