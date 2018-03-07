package org.oscasistemas.controller.Entrada.EntradaSeleccionPedido;

import com.dynamics.webServices.Warehouse_Activity_Header_WS.WarehouseActivityHeaderWS;
import com.dynamics.webServices.Warehouse_Activity_Header_WS.WarehouseActivityHeaderWSFields;
import com.dynamics.webServices.Warehouse_Activity_Header_WS.WarehouseActivityHeaderWSFilter;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSFields;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSFilter;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSList;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.controller.WebService.WebServicesInit;
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
 * Created by Portátil1 on 21/12/2017.
 */
@RestController
public class EntradaInfoPedido {


    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value="/EntradaInfoPedido",method = RequestMethod.GET)
    public ModelAndView EntradaInfoPedidoPage(HttpServletRequest request, @NotNull @RequestParam(value = "pedido" , required = true) String pedido) {
        ModelAndView m= new ModelAndView("EntradaInfoPedido");
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        m.getModelMap().addAttribute("articulos_pedido",getLineasPedidoEntrada(pedido).getWarehouseActivityLineWS());
        m.getModelMap().addAttribute("pedido",getPedidoEntrada(pedido));
        return m;
    }


    /*
     * Devuelve las lineas de pedido de la lanzadera
     */
    private WarehouseActivityLineWSList getLineasPedidoEntrada(String pedido){
        List<WarehouseActivityLineWSFilter> filtros=new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f1=new WarehouseActivityLineWSFilter();
        f1.setField(WarehouseActivityLineWSFields.NO);
        f1.setCriteria(pedido);
        WarehouseActivityLineWSFilter f2=new WarehouseActivityLineWSFilter();
        f2.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f2.setCriteria("Put_away");
        WarehouseActivityLineWSFilter f4=new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTION_TYPE);
        f4.setCriteria("Place");
        WarehouseActivityLineWSFilter f3=new WarehouseActivityLineWSFilter();
        f3.setField(WarehouseActivityLineWSFields.BIN_CODE);
        f3.setCriteria("PLNZ*");
        filtros.add(f1);
        filtros.add(f2);
        filtros.add(f3);
        return WebServicesInit.articulosPedidoService.readMultiple(filtros,"",0);
    }

    private WarehouseActivityHeaderWS getPedidoEntrada(String pedido){
        List<WarehouseActivityHeaderWSFilter> filtros=new ArrayList<WarehouseActivityHeaderWSFilter>();
        WarehouseActivityHeaderWSFilter f1=new WarehouseActivityHeaderWSFilter();
        f1.setField(WarehouseActivityHeaderWSFields.NO);
        f1.setCriteria(pedido);
        filtros.add(f1);
        return WebServicesInit.PedidoService.readMultiple(filtros,"",0).getWarehouseActivityHeaderWS().get(0);
    }

}
