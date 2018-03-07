package org.oscasistemas.controller.Operaciones.Editar;

import com.dynamics.webServices.Bin_Content_WS.BinContentWS;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFields;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFilter;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.internal.NotNull;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.DAO.interfaces.ITareasPendientes;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.CajaEntablado;
import org.oscasistemas.model.CajaEntabladoMedida;
import org.oscasistemas.model.TareasPendientes;
import org.oscasistemas.model.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Holder;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Portátil1 on 22/12/2017.
 */
@RestController
public class AddMaterialPedidoDivision {

    @Autowired(required = true)
    private IEntablado entabladoService;
    @Autowired
    private ICajaEntablado locationService;

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;


    @Autowired
    private ITareasPendientes tareasPendientesService;


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
        JSONObject outputJsonObj = new JSONObject();


        /**
         * Actualizar cantidad en NAV
         */
        actualizarCantidadEntablado(Bin_Code, articulo, cantidad);
        /**
         * Actualizar cantidad linea de pedido
         */
        actualizarLineasDePedido(No, Line_No, articulo, cantidad);

        //ItemCardWS a=WebServicesInit.articulosService.read(articulo);
        //añadir material en la posicion seleccionada
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
        /*
         * Actualizar cantidad linea de pedido
         */
        //Buscar en NAV Pedidos Sin marcar de la lanzadera




        if(!existenLineasSinMarcar(articulo, No, Bin_Code)) {
            WarehouseActivityLineWSList lineasPedidoSinMarcarT =  getLineasSinMarcar(No);

            //fin pedido???
            if (lineasPedidoSinMarcarT == null) {
                outputJsonObj.put("res", "fin");
                if (tareasPendientesService.exiteTarea("/OscaArmarios/EntradaInfoPedido.html?pedido=" + No)) {
                    List<TareasPendientes> pendientes = tareasPendientesService
                            .getTareasPendientes("/OscaArmarios/EntradaInfoPedido.html?pedido=" + No);
                    for (TareasPendientes t : pendientes)
                        tareasPendientesService.remove(t);
                }

            }else{
                outputJsonObj.put("res", "finLanzadera");
            }
        }
        else {
            System.out.println("----------------EXITOOO-------------------");

            outputJsonObj.put("res", "true");
        }
        return outputJsonObj.toString();
    }

    private void actualizarCantidadEntablado(String Bin_Code,String articulo,int cantidad) throws Exception{

        /**
         * Actualizar cantidad ubicacion en NAV
         */
        System.out.println("----------------ACTUALIZANDO CANTIDAD EN NAV-------------------");
        List<BinContentWSFilter> filtros = new ArrayList<BinContentWSFilter>();
        BinContentWSFilter f1 = new BinContentWSFilter();
        f1.setField(BinContentWSFields.LOCATION_CODE);
        f1.setCriteria("OSCA");
        filtros.add(f1);
        BinContentWSFilter f2 = new BinContentWSFilter();
        f2.setField(BinContentWSFields.BIN_CODE);
        f2.setCriteria(Bin_Code);
        filtros.add(f2);
        BinContentWSFilter f3 = new BinContentWSFilter();
        f3.setField(BinContentWSFields.ITEM_NO);
        f3.setCriteria(articulo);
        filtros.add(f3);
        BinContentWS myBinContentWS = WebServicesInit.contenidoUbicacionService.readMultiple(filtros, "", 0).getBinContentWS().get(0);


        myBinContentWS.setPutAwayQty(myBinContentWS.getPutAwayQty().add(BigInteger.valueOf(cantidad)));
        //actualizar en NAV
        WebServicesInit.contenidoUbicacionService.update(new Holder<BinContentWS>(myBinContentWS));

    }

    private void actualizarLineasDePedido(String No,int Line_No,String articulo,int cantidad) throws Exception{

        List<WarehouseActivityLineWSFilter> filtros1 = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f4.setCriteria("Put_away");
        filtros1.add(f4);
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.NO);
        f5.setCriteria(No);
        filtros1.add(f5);
        WarehouseActivityLineWSFilter f6 = new WarehouseActivityLineWSFilter();
        f6.setField(WarehouseActivityLineWSFields.ITEM_NO);
        f6.setCriteria(articulo);
        filtros1.add(f6);
        List<WarehouseActivityLineWS> lineasPedido = WebServicesInit.articulosPedidoService.readMultiple(filtros1, "", 0).getWarehouseActivityLineWS();

        //actualizar cantidades lineas
        for(WarehouseActivityLineWS linea:lineasPedido){
            System.out.println(linea.toString());
            linea.setQtyToHandle(linea.getQtyOutstanding());
            WebServicesInit.articulosPedidoService.update(new Holder<WarehouseActivityLineWS>(linea));
        }
        /**
         *
         * DIVIDIR LA LINEA
         */
        //dividir linea si la cantidad no corresponde a la total
            System.out.println("DIVIDIR LA LINEA");
            //actualizar place
            for(WarehouseActivityLineWS linea:lineasPedido){
                //buscar linea place
                if(linea.getActionType()== ActionType.PLACE) {
                    System.out.println("Colocar encontrado");
                    linea.setQtyToHandle(BigInteger.valueOf(cantidad));
                    WebServicesInit.articulosPedidoService.update(new Holder<WarehouseActivityLineWS>(linea));
                }
            }
            WebServicesInit.functionsService.putAwaySplitLine(No, Line_No);
            //buscar linea dividida
            for(WarehouseActivityLineWS lineaComo:WebServicesInit.articulosPedidoService.
                    readMultiple(filtros1, "", 0).getWarehouseActivityLineWS()){
                if(lineaComo.getBinCode()==null){
                    System.out.println(lineaComo.toString());
                    lineaComo.setBinCode("PCOM.01.0001");
                    WebServicesInit.articulosPedidoService.update(new Holder<WarehouseActivityLineWS>(lineaComo));
                }
            }

    }

    private boolean existenLineasSinMarcar(String pedido,String No,String Bin_Code) throws  Exception{
        //Buscar en NAV Pedidos Sin marcar de la lanzadera
        ArrayList<WarehouseActivityLineWSFilter> filtros1 = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f4.setCriteria("Put_away");
        filtros1.add(f4);
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.QTY_TO_HANDLE);
        f5.setCriteria(String.valueOf("=0"));
        filtros1.add(f5);
        WarehouseActivityLineWSFilter f7 = new WarehouseActivityLineWSFilter();
        f7.setField(WarehouseActivityLineWSFields.NO);
        f7.setCriteria(No);
        filtros1.add(f7);
        WarehouseActivityLineWSFilter f6 = new WarehouseActivityLineWSFilter();
        f6.setField(WarehouseActivityLineWSFields.BIN_CODE);
        f6.setCriteria(String.valueOf(Bin_Code.substring(0,8)+"*"));
        filtros1.add(f6);
        WarehouseActivityLineWSList lineasPedidoSinMarcar = WebServicesInit.articulosPedidoService.readMultiple(filtros1, "", 0);
        return WebServicesInit.articulosPedidoService.readMultiple(filtros1, "", 0)!=null;
    }

    private WarehouseActivityLineWSList getLineasSinMarcar(String No) throws  Exception{
        WebServicesInit.functionsService.putAwayPost(No);
        //listar todos los pedidos
        List<WarehouseActivityLineWSFilter> filtros1 = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f4.setCriteria("Put_away");
        filtros1.add(f4);
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.QTY_TO_HANDLE);
        f5.setCriteria(String.valueOf("=0"));
        filtros1.add(f5);
        WarehouseActivityLineWSFilter f7 = new WarehouseActivityLineWSFilter();
        f7.setField(WarehouseActivityLineWSFields.NO);
        f7.setCriteria(No);
        filtros1.add(f7);
        return WebServicesInit.articulosPedidoService.readMultiple(filtros1, "", 0);
    }
}
