package org.oscasistemas.controller.Salida.SalidaPicking.SalidaPickingAgrupado.Operaciones;

import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWS;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSFields;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSFilter;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSList;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.DAO.interfaces.ITareasPendientes;
import org.oscasistemas.controller.Salida.SalidaPicking.Utils.SalidaUtils;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.CajaEntablado;
import org.oscasistemas.model.CajaEntabladoMedida;
import org.oscasistemas.model.TareasPendientes;
import org.oscasistemas.utils.PedidoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Holder;
import javax.xml.ws.soap.SOAPFaultException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 26/12/2017.
 */
@RestController
public class DiscountMaterialPedidoAgrupado {


    @Autowired(required = true)
    private IEntablado entabladoService; //shelf query service
    @Autowired
    private ICajaEntablado locationService; //box query service

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService; //custom box query service


    @Autowired
    private ITareasPendientes tareasPendientesService; //queue task service


    /**
     *
     * @param request
     * @param No
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
    @RequestMapping(value = "Operacion/DiscountMaterialPedidoAgrupado", method = RequestMethod.GET)
    public @ResponseBody
    String discountMaterialPedidoAgrupado(HttpServletRequest request,
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
            //ItemCardWS a=WebServicesInit.articulosService.read(articulo);

            try {
                //update picking bin quantity
                PedidoUtils.updateBinContentLine(Bin_Code, articulo, cantidad);
            }catch(SOAPFaultException ex){
                ex.printStackTrace();
                return "error:"+ex.getMessage();
            }

            try {
                //update picking lines that contains same article,CODE
                actualizarLineasDePedidoArticulo(No, Bin_Code, articulo);
            } catch (SOAPFaultException ex){
                ex.printStackTrace();
                return ex.getMessage();
            }


            WarehouseActivityLineWSList lineasSinMarcar=null;

            try{
                lineasSinMarcar=SalidaUtils.salidaLineasRegistradas(No, Bin_Code);
            }catch(SOAPFaultException ex){
                ex.printStackTrace();
                return "error:"+ex.getMessage();
            }

            CajaEntablado c=locationService.getCajasEntablado(entabladoService.getEstanteria(Bin_Code),fila,columna);
            if(c!=null) {
                //c.setPeso(c.getPeso()-(cantidad*a.getNetWeight().doubleValue()));
                c.setCantidad(c.getCantidad() - cantidad);
                //actualizar cantidad en DB
                locationService.addOrUpdateCajaEntablado(c);
            }
            else{
                CajaEntabladoMedida c1=cajaEntabladoMedidaService.getCajasEntablado(entabladoService.getEstanteria(Bin_Code),fila,columna);
                //c.setPeso(c.getPeso()-(cantidad*a.getNetWeight().doubleValue()));
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
            }
        return new Gson().toJson("OK");
    }


    /**
     * Update quantityToHandle in all article ubication lines
     * @param No
     * @param ubicacion
     * @param articulo
     * @throws Exception
     */
    private void actualizarLineasDePedidoArticulo(String No,String ubicacion,String articulo) throws Exception{

        List<WarehouseActivityLineWSFilter> filtros1 = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f3 = new WarehouseActivityLineWSFilter();
        f3.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f3.setCriteria("Pick");
        filtros1.add(f3);
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.NO);
        f4.setCriteria(No);
        filtros1.add(f4);
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.BIN_CODE);
        f5.setCriteria(ubicacion);
        filtros1.add(f5);
        WarehouseActivityLineWSFilter f6 = new WarehouseActivityLineWSFilter();
        f6.setField(WarehouseActivityLineWSFields.ITEM_NO);
        f6.setCriteria(articulo);
        filtros1.add(f6);
        WarehouseActivityLineWSFilter f7 = new WarehouseActivityLineWSFilter();
        f7.setField(WarehouseActivityLineWSFields.QTY_TO_HANDLE);
        f7.setCriteria("=0");
        filtros1.add(f7);

        WarehouseActivityLineWSList list=WebServicesInit.articulosPedidoService.readMultiple(filtros1, "", 0);

        for(WarehouseActivityLineWS l:list.getWarehouseActivityLineWS()) {
            l.setQtyToHandle(l.getQtyOutstanding());
            WebServicesInit.articulosPedidoService.update(new Holder<WarehouseActivityLineWS>(l));
            SalidaUtils.salidaActuallizarCantidadManejar(No,l.getLineNo()+10000);
        }
    }
}
