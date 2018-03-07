package org.oscasistemas.controller.Entrada.EntradaMaterial.EntradaPedido.Operaciones;

import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSList;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.DAO.interfaces.ITareasPendientes;
import org.oscasistemas.controller.Entrada.EntradaMaterial.Utils.EntradaPedidoUtils;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.CajaEntabladoMedida;
import org.oscasistemas.model.TareasPendientes;
import org.oscasistemas.model.View;
import org.oscasistemas.utils.PedidoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.SOAPFaultException;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 22/12/2017.
 */
@RestController
public class AddMaterialPedidoMedida {

    @Autowired(required = true)
    private IEntablado entabladoService; //shelf service
    @Autowired
    private ICajaEntablado locationService; //box service

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService; //custom box service

    @Autowired
    private ITareasPendientes tareasPendientesService; //queue task

    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/AddMaterialPedidoMedida", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String addMaterialPedidoMedida(HttpServletRequest request,
                             @NotNull @RequestParam(value = "No", required = true, defaultValue = "-1") String No,
                             @NotNull @RequestParam(value = "Line_No", required = true, defaultValue = "-1") int Line_No,
                             @NotNull @RequestParam(value = "sourceNo", required = true, defaultValue = "-1") String sourceNo,
                             @NotNull @RequestParam(value = "Bin_Code", required = true, defaultValue="-1") String Bin_Code,
                             @NotNull @RequestParam(value = "fila", required = true, defaultValue = "-1") int fila,
                             @NotNull @RequestParam(value = "columna", required = true, defaultValue = "-1") int columna,
                             @NotNull @RequestParam(value = "cantidad", required = true, defaultValue = "-1") int cantidad,
                             @NotNull @RequestParam(value = "Item_No", required = true, defaultValue = "000000000") String articulo)
    {

        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

        try {
            //Update Quantity put away on bin content
            PedidoUtils.updateBinContentLine(Bin_Code, articulo, cantidad);
        }catch(SOAPFaultException ex){
            ex.printStackTrace();
            return "error:"+ex.getMessage();
        }
        try {
            // update queatityToHandle on ubication line
            EntradaPedidoUtils.entradaActualizarCantidadAManipular(No, Line_No);
            EntradaPedidoUtils.entradaActualizarCantidadAManipular(No, Line_No-10000);
        }catch(SOAPFaultException ex){
            ex.printStackTrace();
            ex.getMessage();
        }

        CajaEntabladoMedida c1=cajaEntabladoMedidaService.getCajasEntablado(entabladoService.getEstanteria(Bin_Code),fila,columna);
        //c.setPeso(c.getPeso()-(cantidad*a.getNetWeight().doubleValue()));
        c1.setCantidad(c1.getCantidad() + cantidad);
        //actualizar cantidad en DB
        cajaEntabladoMedidaService.addOrUpdateCajaEntablado(c1);
        //no register ubication lines in custom lift
        WarehouseActivityLineWSList lineasSinMarcar=null;
        try{
            lineasSinMarcar=EntradaPedidoUtils.estanLineasEntradaRegistradas(No, Bin_Code);
        }catch(SOAPFaultException ex){
            ex.printStackTrace();
            return "error:"+ex.getMessage();
        }

        //if no more lines in request lift
        if(lineasSinMarcar==null || lineasSinMarcar.getWarehouseActivityLineWS().isEmpty()) {
            WebServicesInit.functionsService.putAwayPost(No);
            WarehouseActivityLineWSList lineasPedidoSinMarcarT =  null;
            try{
                lineasPedidoSinMarcarT=EntradaPedidoUtils.estanLineasEntradaRegistradas(No);
            }catch(SOAPFaultException e){
                e.printStackTrace();
                return "error:"+e.getMessage();
            }
            //fin pedido???
            if (lineasPedidoSinMarcarT == null) {

                if (tareasPendientesService.exiteTarea("/OscaArmarios/EntradaInfoPedido.html?pedido=" + No)) {
                    List<TareasPendientes> pendientes = tareasPendientesService
                            .getTareasPendientes("/OscaArmarios/EntradaInfoPedido.html?pedido=" + No);
                    for (TareasPendientes t : pendientes)
                        tareasPendientesService.remove(t);
                }
               return new Gson().toJson("FIN");

            }else{
                return new Gson().toJson("ENDLIFT");
            }
        }
        return new Gson().toJson("OK");
    }
}
