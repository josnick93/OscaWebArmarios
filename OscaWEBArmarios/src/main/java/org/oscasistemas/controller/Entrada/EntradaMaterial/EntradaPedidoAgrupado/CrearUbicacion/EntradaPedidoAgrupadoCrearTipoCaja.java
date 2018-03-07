package org.oscasistemas.controller.Entrada.EntradaMaterial.EntradaPedidoAgrupado.CrearUbicacion;

import com.dynamics.webServices.Warehouse_Activity_Header_WS.WarehouseActivityHeaderWS;
import com.dynamics.webServices.Warehouse_Activity_Header_WS.WarehouseActivityHeaderWSFields;
import com.dynamics.webServices.Warehouse_Activity_Header_WS.WarehouseActivityHeaderWSFilter;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWS;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSFields;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSFilter;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSList;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Portátil1 on 14/02/2018.
 */
@RestController
public class EntradaPedidoAgrupadoCrearTipoCaja {

    @Autowired
    private ILanzadera lanzaderaService; //lift query service

    /**
     *
     * @param request
     * @param pedido
     * @param articulo
     * @param codigoEntablado
     * @return
     */
    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value="/EntradaPedidoAgrupadoCrearTipoCaja",method = RequestMethod.GET)
    public ModelAndView EntradaInfoPedidoPage(HttpServletRequest request, @NotNull @RequestParam(value = "pedido" , required = true) String pedido,
                                              @NotNull @RequestParam(value = "articulo" , required = true) String articulo,
                                              @NotNull @RequestParam(value = "ubicacion" , required = true) String  codigoEntablado) {
        ModelAndView m= new ModelAndView("Entrada/EntradaMaterial/EntradaPedidoAgrupado/CrearUbicacion/EntradaPedidoAgrupadoCrearTipoCaja");
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
        m.getModelMap().addAttribute("lineaPedido", getLineaSumaTotal(pedido,articulo,codigoEntablado));
        m.getModelMap().addAttribute("codigoEntablado",codigoEntablado);
        return m;
    }

    /**
     *
     * @param pedido
     * @return
     */
    private WarehouseActivityHeaderWS obtenerPedido(String pedido){
        List<WarehouseActivityHeaderWSFilter> filtros = new ArrayList<WarehouseActivityHeaderWSFilter>();
        WarehouseActivityHeaderWSFilter f1 = new WarehouseActivityHeaderWSFilter();
        f1.setField(WarehouseActivityHeaderWSFields.NO);
        f1.setCriteria(pedido);
        filtros.add(f1);
        return WebServicesInit.PedidoService.readMultiple(filtros, "", 1).getWarehouseActivityHeaderWS().get(0);

    }

    /**
     *
     * @param pedido
     * @param articulo
     * @param ubicacion
     * @return
     */
    private WarehouseActivityLineWS getLineaSumaTotal(String pedido,String articulo,String ubicacion){
        WarehouseActivityLineWS linea=new WarehouseActivityLineWS();

        List<WarehouseActivityLineWSFilter> filtros = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f1 = new WarehouseActivityLineWSFilter();
        f1.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f1.setCriteria("Put_away");
        filtros.add(f1);
        WarehouseActivityLineWSFilter f2 = new WarehouseActivityLineWSFilter();
        f2.setField(WarehouseActivityLineWSFields.NO);
        f2.setCriteria(pedido);
        filtros.add(f2);
        WarehouseActivityLineWSFilter f3 = new WarehouseActivityLineWSFilter();
        f3.setField(WarehouseActivityLineWSFields.ITEM_NO);
        f3.setCriteria(String.valueOf(articulo));
        filtros.add(f3);
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTION_TYPE);
        f4.setCriteria("Place");
        filtros.add(f4);
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.QTY_TO_HANDLE);
        f5.setCriteria(String.valueOf("=0"));
        filtros.add(f5);
        WarehouseActivityLineWSFilter f6 = new WarehouseActivityLineWSFilter();
        f6.setField(WarehouseActivityLineWSFields.BIN_CODE);
        f6.setCriteria(ubicacion);
        filtros.add(f6);
        WarehouseActivityLineWSList aux=WebServicesInit.articulosPedidoService.readMultiple(filtros, "", 0);
        linea=aux.getWarehouseActivityLineWS().get(0);
        for(int i=1;i<aux.getWarehouseActivityLineWS().size();i++){
            linea.setQtyToHandle(linea.getQtyToHandle().add(aux.getWarehouseActivityLineWS().get(i).getQtyToHandle()));
        }
        return linea;
    }

}
