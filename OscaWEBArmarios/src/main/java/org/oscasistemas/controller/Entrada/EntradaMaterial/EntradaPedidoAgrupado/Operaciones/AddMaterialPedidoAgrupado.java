package org.oscasistemas.controller.Entrada.EntradaMaterial.EntradaPedidoAgrupado.Operaciones;

import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWS;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSFields;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSFilter;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSList;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import org.apache.log4j.Logger;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.DAO.interfaces.ITareasPendientes;
import org.oscasistemas.controller.Entrada.EntradaMaterial.Utils.EntradaPedidoUtils;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.CajaEntablado;
import org.oscasistemas.model.CajaEntabladoMedida;
import org.oscasistemas.model.TareasPendientes;
import org.oscasistemas.model.View;
import org.oscasistemas.utils.PedidoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Holder;
import javax.xml.ws.soap.SOAPFaultException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 22/12/2017.
 */
@RestController
public class AddMaterialPedidoAgrupado {

    @Autowired(required = true)
    private IEntablado entabladoService;
    @Autowired
    private ICajaEntablado locationService;

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;


    @Autowired
    private ITareasPendientes tareasPendientesService;

    private static final Logger logger = Logger.getLogger(AddMaterialPedidoAgrupado.class);


    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/AddMaterialPedidoAgrupado", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String addMaterialPedidoAgrupado(HttpServletRequest request,
                             @NotNull @RequestParam(value = "No", required = true, defaultValue = "-1") String No,
                             @NotNull @RequestParam(value = "sourceNo", required = true, defaultValue = "-1") String sourceNo,
                             @NotNull @RequestParam(value = "Bin_Code", required = true, defaultValue="-1") String Bin_Code,
                             @NotNull @RequestParam(value = "fila", required = true, defaultValue = "-1") int fila,
                             @NotNull @RequestParam(value = "columna", required = true, defaultValue = "-1") int columna,
                             @NotNull @RequestParam(value = "cantidad", required = true, defaultValue = "-1") int cantidad,
                             @NotNull @RequestParam(value = "Item_No", required = true, defaultValue = "000000000") String articulo) throws Exception {
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

        try {
            PedidoUtils.updateBinContentLine(Bin_Code, articulo, cantidad);
        } catch(SOAPFaultException ex){
            ex.printStackTrace();
            return "error:"+ex.getMessage();
        }

        try{
        actualizarLineasDePedidoAgrupado(No, Bin_Code,articulo);
        } catch(SOAPFaultException ex){
            ex.printStackTrace();
            return "error:"+ex.getMessage();
        }
        CajaEntablado c=locationService.getCajasEntablado(entabladoService.getEstanteria(Bin_Code),fila,columna);
        if(c!=null) {
            //c.setPeso(c.getPeso()-(cantidad*a.getNetWeight().doubleValue()));
            c.setCantidad(c.getCantidad() + cantidad);
            //actualizar cantidad en DB
            locationService.addOrUpdateCajaEntablado(c);
        }
        else{
            CajaEntabladoMedida c1=cajaEntabladoMedidaService.getCajasEntablado(entabladoService.getEstanteria(Bin_Code),fila,columna);
            //c.setPeso(c.getPeso()-(cantidad*a.getNetWeight().doubleValue()));
            c1.setCantidad(c.getCantidad() + cantidad);
            //actualizar cantidad en DB
            cajaEntabladoMedidaService.addOrUpdateCajaEntablado(c1);
        }
        WarehouseActivityLineWSList lineasSinMarcar=null;
        try{
            lineasSinMarcar=EntradaPedidoUtils.estanLineasEntradaRegistradas(No, Bin_Code);
        }catch (SOAPFaultException ex){
            ex.printStackTrace();
            return "error:"+ex.getMessage();
        }

        if(lineasSinMarcar==null || lineasSinMarcar.getWarehouseActivityLineWS().isEmpty()) {
            try {
                WebServicesInit.functionsService.putAwayPost(No);
            }catch(SOAPFaultException ex){
                ex.printStackTrace();
                return "error:"+ex.getMessage();
            }
            WarehouseActivityLineWSList lineasPedidoSinMarcarT =  EntradaPedidoUtils.estanLineasEntradaRegistradas(No);

            //fin pedido???
            if (lineasPedidoSinMarcarT == null) {
                if (tareasPendientesService.exiteTarea("/OscaArmarios/EntradaInfoPedido.html?pedido=" + No)) {
                    List<TareasPendientes> pendientes = tareasPendientesService
                            .getTareasPendientes("/OscaArmarios/EntradaInfoPedido.html?pedido=" + No);
                    for (TareasPendientes t : pendientes)
                        tareasPendientesService.remove(t);
                }
                return  new Gson().toJson("END");

            }else{
                return  new Gson().toJson("ENDLIFT");
            }
        }
        return  new Gson().toJson("OK");
    }


    private void actualizarLineasDePedidoAgrupado(String No,String ubicacion,String articulo) throws Exception{

        List<WarehouseActivityLineWSFilter> filtros1 = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f4.setCriteria("Put_away");
        filtros1.add(f4);
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.BIN_CODE);
        f5.setCriteria(ubicacion);
        filtros1.add(f5);
        WarehouseActivityLineWSFilter f6 = new WarehouseActivityLineWSFilter();
        f6.setField(WarehouseActivityLineWSFields.ITEM_NO);
        f6.setCriteria(articulo);
        filtros1.add(f6);
        WarehouseActivityLineWSList lineasPedido = WebServicesInit.articulosPedidoService.readMultiple(filtros1, "", 0);

        //actualizar cantidades lineas
        for(WarehouseActivityLineWS linea:lineasPedido.getWarehouseActivityLineWS()) {
            linea.setQtyToHandle(linea.getQtyOutstanding());
            WebServicesInit.articulosPedidoService.update(new Holder<WarehouseActivityLineWS>(linea));
            //actualizar linea traer
            EntradaPedidoUtils.entradaActualizarCantidadAManipular(linea.getNo(),linea.getLineNo()-10000);
        }
    }
}
