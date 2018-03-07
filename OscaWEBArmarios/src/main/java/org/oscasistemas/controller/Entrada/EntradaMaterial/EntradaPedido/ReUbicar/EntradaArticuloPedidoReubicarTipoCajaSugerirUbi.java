package org.oscasistemas.controller.Entrada.EntradaMaterial.EntradaPedido.ReUbicar;

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
 * Created by José Ángel Caudevilla Casaus on 29/01/2018.
 */
@RestController
public class EntradaArticuloPedidoReubicarTipoCajaSugerirUbi {

    //EntradaArticuloPedidoReubicarTipoCajaSugerirUbi
    @Autowired
    private ILanzadera lanzaderaService;

    /**
     *
     * @param request
     * @param pedido
     * @param articulo
     * @param lineNo
     * @param fila
     * @param columna
     * @return
     */
    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value="/EntradaArticuloPedidoReubicarTipoCajaSugerirUbi",method = RequestMethod.GET)
    public ModelAndView EntradaArticuloPedidoReubicarTipoCajaSugerirUbiPage(HttpServletRequest request,
                                              @NotNull @RequestParam(value = "pedido" , required = true) String pedido,
                                              @NotNull @RequestParam(value = "articulo" , required = true) String articulo,
                                              @NotNull @RequestParam(value = "linea" , required = true) int  lineNo,
                                              @NotNull @RequestParam(value = "fila" , required = true) double fila,
                                              @NotNull @RequestParam(value = "columna" , required = true) double columna

                                                                            )
    throws Exception{
        ModelAndView m= new ModelAndView("Entrada/EntradaMaterial/EntradaPedido/ReUbicar/EntradaArticuloPedidoReubicarTipoCajaSugerirUbi");
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

        m.getModelMap().addAttribute("cerrar",0);
        m.getModelMap().addAttribute("lanzadera",lanzaderaService.getLanzaderaIp(remoteAddr));
        //articulo
        m.getModelMap().addAttribute("articulo", WebServicesInit.articulosService.read(articulo));
        m.getModelMap().addAttribute("pedido", obtenerPedido(pedido));
        m.getModelMap().addAttribute("lineaPedido", obtenerLineaPedido(pedido,lineNo));
        m.getModelMap().addAttribute("fila", fila);
        m.getModelMap().addAttribute("columna", columna);

        return m;
    }
}
