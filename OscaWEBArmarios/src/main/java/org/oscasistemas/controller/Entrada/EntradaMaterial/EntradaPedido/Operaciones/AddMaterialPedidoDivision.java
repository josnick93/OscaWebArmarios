package org.oscasistemas.controller.Entrada.EntradaMaterial.EntradaPedido.Operaciones;

import com.dynamics.webServices.Warehouse_Activity_Line_WS.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 22/12/2017.
 */
@RestController
public class AddMaterialPedidoDivision {

    @Autowired(required = true)
    private IEntablado entabladoService; //shelf query
    @Autowired
    private ICajaEntablado locationService; //box query

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService; //custom box query


    @Autowired
    private ITareasPendientes tareasPendientesService; //task query

    /**
     *  THIS FUNCTION IS NOT USED!!!!!!!!!
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
    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/AddMaterialPedidoDivision", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String addMaterialPedido(HttpServletRequest request,
                             @NotNull @RequestParam(value = "No", required = true, defaultValue = "-1") String No,
                             @NotNull @RequestParam(value = "Line_No", required = true, defaultValue = "-1") int Line_No,
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
                //QuantitiyUbication update
                PedidoUtils.updateBinContentLine(Bin_Code, articulo, cantidad);
            }catch(SOAPFaultException ex){
                ex.printStackTrace();
                return "error:"+ex.getMessage();
            }

            try {
                //update quantityToHandle
                actualizarLineasDePedido(No, Line_No, articulo, cantidad);
            }catch(SOAPFaultException ex){
                return "error:"+ex.getMessage();
            }
            CajaEntablado c = locationService.getCajasEntablado(entabladoService.getEstanteria(Bin_Code), fila, columna);
            if (c != null) {
                //c.setPeso(c.getPeso()-(cantidad*a.getNetWeight().doubleValue()));
                c.setCantidad(c.getCantidad() + cantidad);
                //actualizar cantidad en DB
                locationService.addOrUpdateCajaEntablado(c);
            } else {
                CajaEntabladoMedida c1 = cajaEntabladoMedidaService.getCajasEntablado(entabladoService.getEstanteria(Bin_Code), fila, columna);
                //c.setPeso(c.getPeso()-(cantidad*a.getNetWeight().doubleValue()));
                c1.setCantidad(c.getCantidad() + cantidad);
                //actualizar cantidad en DB
                cajaEntabladoMedidaService.addOrUpdateCajaEntablado(c1);
            }
            /*
             * Actualizar cantidad linea de pedido
             */
            //Buscar en NAV Pedidos Sin marcar de la lanzadera



            WarehouseActivityLineWSList lineasSinMarcar = null;
            try{
                lineasSinMarcar= EntradaPedidoUtils.estanLineasEntradaRegistradas(No, Bin_Code);
            }catch (SOAPFaultException ex){
                ex.printStackTrace();
                return "error:"+ex.getMessage();
            }


            //no ubication lines in custom lift
            if (lineasSinMarcar == null || lineasSinMarcar.getWarehouseActivityLineWS().isEmpty()) {
                WebServicesInit.functionsService.putAwayPost(No);

                WarehouseActivityLineWSList lineasPedidoSinMarcarT = EntradaPedidoUtils.estanLineasEntradaRegistradas(No);
                //fin pedido???
                if (lineasPedidoSinMarcarT == null) {

                    if (tareasPendientesService.exiteTarea("/OscaArmarios/EntradaInfoPedido.html?pedido=" + No)) {
                        List<TareasPendientes> pendientes = tareasPendientesService
                                .getTareasPendientes("/OscaArmarios/EntradaInfoPedido.html?pedido=" + No);
                        for (TareasPendientes t : pendientes)
                            tareasPendientesService.remove(t);
                    }
                    return new Gson().toJson("END");

                } else {
                    return new Gson().toJson("LIFTEND");
                }
            }return new Gson().toJson("OK");

    }

    /**
     * Update ubication lines
     * @param No
     * @param Line_No
     * @param articulo
     * @param cantidad
     * @throws SOAPFaultException
     */
    private void actualizarLineasDePedido(String No,int Line_No,String articulo,int cantidad)
            throws SOAPFaultException{

        List<WarehouseActivityLineWSFilter> filtros1 = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f4.setCriteria("Put_away");
        filtros1.add(f4);
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.QTY_TO_HANDLE);
        f5.setCriteria("=0");
        filtros1.add(f5);
        WarehouseActivityLineWSFilter f6 = new WarehouseActivityLineWSFilter();
        f6.setField(WarehouseActivityLineWSFields.ITEM_NO);
        f6.setCriteria(articulo);
        filtros1.add(f6);
        WarehouseActivityLineWSFilter f7 = new WarehouseActivityLineWSFilter();
        f7.setField(WarehouseActivityLineWSFields.NO);
        f7.setCriteria(No);
        filtros1.add(f7);
        List<WarehouseActivityLineWS> lineasPedido = WebServicesInit.articulosPedidoService.readMultiple(filtros1, "", 0).getWarehouseActivityLineWS();

        //actualizar cantidades lineas
        for(WarehouseActivityLineWS linea:lineasPedido){
            if(linea.getActionType()== ActionType.PLACE) {
                linea.setQtyToHandle(BigInteger.valueOf(cantidad));
                WebServicesInit.articulosPedidoService.update(new Holder<WarehouseActivityLineWS>(linea));
            }else {
                linea.setQtyToHandle(linea.getQtyOutstanding());
                WebServicesInit.articulosPedidoService.update(new Holder<WarehouseActivityLineWS>(linea));
            }
        }
        //Line division
        //dividir linea si la cantidad no corresponde a la total
            WebServicesInit.functionsService.putAwaySplitLine(No, Line_No);
            //buscar linea dividida
            for(WarehouseActivityLineWS lineaComo:WebServicesInit.articulosPedidoService.
                    readMultiple(filtros1, "", 0).getWarehouseActivityLineWS()){
                if(lineaComo.getBinCode()==null){
                    lineaComo.setBinCode("PCOM.01.0001");
                    WebServicesInit.articulosPedidoService.update(new Holder<WarehouseActivityLineWS>(lineaComo));
                }
            }

    }
}
