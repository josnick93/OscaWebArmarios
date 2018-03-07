package org.oscasistemas.controller.Entrada.EntradaMaterial.Operaciones;

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
public class ListarPedidosEntrada {


    /**
     *
     * @param model
     * @param request
     * @param pedido
     * @param alias
     * @param descripcion
     * @return list of ubications
     */
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/ListarPedidosEntrada", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String listarPedidosEntrada(Model model,HttpServletRequest request,
                                                         @NotNull @RequestParam(value = "pedido", required = false, defaultValue = "") String pedido,
                                                         @NotNull @RequestParam(value = "alias", required = false, defaultValue = "") String alias,
                                                         @NotNull @RequestParam(value = "descripcion", required = false, defaultValue = "") String descripcion) {

        try {
            return new Gson().toJson(getLines(pedido).getWarehouseActivityHeaderWS());
        }catch(SOAPFaultException e){
            return "error:"+e.getMessage();
        }
    }

    /**
     *
     * @param pedido
     * @return a list of header ubications
     */
    private WarehouseActivityHeaderWSList getLines(String pedido){
        List<WarehouseActivityHeaderWSFilter> filtros = new ArrayList<WarehouseActivityHeaderWSFilter>();
        WarehouseActivityHeaderWSFilter f1 = new WarehouseActivityHeaderWSFilter();
        f1.setField(WarehouseActivityHeaderWSFields.TYPE);
        f1.setCriteria("Put_away");
        filtros.add(f1);

        WarehouseActivityHeaderWSFilter f2=new WarehouseActivityHeaderWSFilter();
        f2.setField(WarehouseActivityHeaderWSFields.NO);
        f2.setCriteria("*"+pedido.toUpperCase()+"*");
        filtros.add(f2);

        return WebServicesInit.PedidoService.readMultiple(filtros, "", 0);
    }
}
