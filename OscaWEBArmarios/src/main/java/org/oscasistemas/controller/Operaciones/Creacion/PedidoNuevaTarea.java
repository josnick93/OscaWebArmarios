package org.oscasistemas.controller.Operaciones.Creacion;

import com.sun.istack.internal.NotNull;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.*;
import org.oscasistemas.model.PedidoEntrada;
import org.oscasistemas.model.TareasPendientes;
import org.oscasistemas.service.interfaces.IArticuloService;
import org.oscasistemas.service.interfaces.IPedidoEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 26/12/2017.
 */
@RestController
public class PedidoNuevaTarea {


    @Autowired
    private IArticuloService articuloService;



    @Autowired
    private ILanzadera lanzaderaService;

    @Autowired
    private IAcciones accionesService;

    @Autowired
    private ITareasPendientes tareasPendientesService;


    @Autowired
    private IPedidoEntradaService pedidoentradaService;

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/PedidoNuevaTarea", method = RequestMethod.GET)
    public @ResponseBody
    String PedidonuevaTarea(HttpServletRequest request,
                            @NotNull @RequestParam(value = "lanzadera", required = true, defaultValue = "-1") int id_lanzadera,
                            @NotNull @RequestParam(value = "url", required = true, defaultValue = "") String url,
                            @NotNull @RequestParam(value = "articulo", required = true, defaultValue = "00.000.0000") String articulo,
                            @NotNull @RequestParam(value = "pedido", required = true, defaultValue = "U000000") String pedido,
                            @NotNull @RequestParam(value = "cantidad", required = true, defaultValue = "-1") double cantidad,
                            @NotNull @RequestParam(value = "accion", required = true, defaultValue = "-1") int accion) throws Exception {
        JSONObject outputJsonObj = new JSONObject();
        TareasPendientes tareasPendientes = new TareasPendientes();
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        if(!tareasPendientesService.exiteTarea(url)) {
            for(PedidoEntrada p:pedidoentradaService.getLanzaderasPedido(pedido)) {
                tareasPendientes.setLanzadera(lanzaderaService.getLanzadera(
                        Integer.valueOf(p.getEntablado().getCodigo().substring(5,7))));
                tareasPendientes.setAccion(accionesService.getAccion(accion));
                tareasPendientes.setArticulo(articuloService.getArticulo(articulo));
                tareasPendientes.setCantidad(cantidad);
                tareasPendientes.setURL(url);
                tareasPendientesService.addOrUpdate(tareasPendientes);
            }
        }
        return outputJsonObj.toString();
    }
}
