package org.oscasistemas.controller.Salida.SalidaPicking.Operaciones;

import com.dynamics.webServices.Warehouse_Activity_Header_WS.WarehouseActivityHeaderWSFields;
import com.dynamics.webServices.Warehouse_Activity_Header_WS.WarehouseActivityHeaderWSFilter;
import com.dynamics.webServices.Warehouse_Activity_Header_WS.WarehouseActivityHeaderWSList;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.View;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.SOAPFaultException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 21/12/2017.
 */
@RestController
public class ListarPedidosSalida {

    /**
     *
     * @param model
     * @param request
     * @param pedido
     * @return a list of picking
     */
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/ListarPedidosSalida", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String listarPedidosSalida(Model model,HttpServletRequest request,
                               @NotNull @RequestParam(value = "pedido", required = false, defaultValue = "") String pedido) {
        try {
            return new Gson().toJson(getPickingOrders(pedido).getWarehouseActivityHeaderWS());
        }catch(SOAPFaultException e){
            e.printStackTrace();
            return "error:"+e.getMessage();
        }
    }

    private WarehouseActivityHeaderWSList getPickingOrders(String number){
        List<WarehouseActivityHeaderWSFilter> filtros = new ArrayList<WarehouseActivityHeaderWSFilter>();
        WarehouseActivityHeaderWSFilter f1 = new WarehouseActivityHeaderWSFilter();
        f1.setField(WarehouseActivityHeaderWSFields.TYPE);
        f1.setCriteria("Pick");
        filtros.add(f1);

        WarehouseActivityHeaderWSFilter f2 = new WarehouseActivityHeaderWSFilter();
        f2.setField(WarehouseActivityHeaderWSFields.NO);
        f2.setCriteria("*"+number+"*");
        filtros.add(f2);

        return WebServicesInit.PedidoService.readMultiple(filtros, "", 0);
    }
}
