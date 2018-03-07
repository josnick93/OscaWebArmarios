package org.oscasistemas.controller.Salida.SalidaPicking.SalidaPicking.Operaciones;

import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSList;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.DAO.interfaces.ITareasPendientes;
import org.oscasistemas.controller.Salida.SalidaPicking.Utils.SalidaUtils;
import org.oscasistemas.model.CajaEntablado;
import org.oscasistemas.model.CajaEntabladoMedida;
import org.oscasistemas.model.TareasPendientes;
import org.oscasistemas.utils.PedidoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.SOAPFaultException;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 26/12/2017.
 */
@RestController
public class DiscountMaterialPedido {


    @Autowired(required = true)
    private IEntablado entabladoService; //shelf query service
    @Autowired
    private ICajaEntablado locationService; //box query service

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;//custom box query service


    @Autowired
    private ITareasPendientes tareasPendientesService; //queue task service



    /**
     * Register picking line and discount quantity from box
     * @param request
     * @param No
     * @param Line_No
     * @param sourceNo
     * @param Bin_Code
     * @param fila
     * @param columna
     * @param cantidad
     * @param articulo
     * @return
     * @throws Exception
     */
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/DiscountMaterialPedido", method = RequestMethod.GET)
    public @ResponseBody
    String discountMaterialPedido(HttpServletRequest request,
                                  @NotNull @RequestParam(value = "No", required = true, defaultValue = "-1") String No,
                                  @NotNull @RequestParam(value = "Line_No", required = true, defaultValue = "-1") int Line_No,
                                  @NotNull @RequestParam(value = "sourceNo", required = true, defaultValue = "-1") String sourceNo,
                                  @NotNull @RequestParam(value = "Bin_Code", required = true, defaultValue="-1") String Bin_Code,
                                  @NotNull @RequestParam(value = "fila", required = true, defaultValue = "-1") int fila,
                                  @NotNull @RequestParam(value = "columna", required = true, defaultValue = "-1") int columna,
                                  @NotNull @RequestParam(value = "cantidad", required = true, defaultValue = "-1") int cantidad,
                                  @NotNull @RequestParam(value = "Item_No", required = true, defaultValue = "000000000") String articulo){
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
            //ItemCardWS a=WebServicesInit.articulosService.read(articulo);
            try {
                //update shelf quantity
                PedidoUtils.updateBinContentLine(Bin_Code, articulo, cantidad);
            }catch(SOAPFaultException ex){
                ex.printStackTrace();
                return "error:"+ex.getMessage();
            }
            try {
                //update quantityToHandle picking line
                SalidaUtils.salidaActuallizarCantidadManejar(No, Line_No);
                //put line
                SalidaUtils.salidaActuallizarCantidadManejar(No, Line_No+10000);
            }catch(SOAPFaultException ex){
                ex.printStackTrace();
                return "error:"+ex.getMessage();
            }


            WarehouseActivityLineWSList lineasSinMarcar=null;
            try{
                lineasSinMarcar=SalidaUtils.salidaLineasRegistradas(No, Bin_Code);
            }catch (SOAPFaultException ex){
                ex.printStackTrace();
                return "error:"+ex.getMessage();
            }



            //box discount
            CajaEntablado c=locationService.getCajasEntablado(entabladoService.getEstanteria(Bin_Code),fila,columna);
            if(c!=null) {
                //c.setPeso(c.getPeso()-(cantidad*a.getNetWeight().doubleValue()));
                c.setCantidad(c.getCantidad() - cantidad);
                //actualizar cantidad en DB
                locationService.addOrUpdateCajaEntablado(c);
            }
            else{
                CajaEntabladoMedida c1=cajaEntabladoMedidaService.getCajasEntablado(entabladoService.getEstanteria(Bin_Code),fila,columna);
                c1.setCantidad(c.getCantidad() - cantidad);
                //actualizar cantidad en DB
                cajaEntabladoMedidaService.addOrUpdateCajaEntablado(c1);
            }



            if (lineasSinMarcar==null || lineasSinMarcar.getWarehouseActivityLineWS().isEmpty()) {
                WarehouseActivityLineWSList lineasPedidoSinMarcarT = null;
                try{
                    lineasPedidoSinMarcarT=SalidaUtils.lineasSinRegistrar(No);
                }catch(SOAPFaultException ex){
                    ex.printStackTrace();
                    return "error:"+ex.getMessage();
                }

                if (lineasPedidoSinMarcarT == null) {
                    if (tareasPendientesService.exiteTarea("/OscaArmarios/SalidaInfoPedido.html?pedido=" + No)) {
                        List<TareasPendientes> pendientes = tareasPendientesService
                                .getTareasPendientes("/OscaArmarios/SalidaInfoPedido.html?pedido=" + No);
                        for (TareasPendientes t : pendientes)
                            tareasPendientesService.remove(t);
                    }
                    return new Gson().toJson("END");

                } else {
                    return new Gson().toJson("ENDLIFT");
                }
            } else {
               return new Gson().toJson("OK");
            }
    }

}
