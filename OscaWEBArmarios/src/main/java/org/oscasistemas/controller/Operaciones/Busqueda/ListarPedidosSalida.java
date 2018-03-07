package org.oscasistemas.controller.Operaciones.Busqueda;

import com.dynamics.webServices.Warehouse_Activity_Header_WS.WarehouseActivityHeaderWS;
import com.dynamics.webServices.Warehouse_Activity_Header_WS.WarehouseActivityHeaderWSFields;
import com.dynamics.webServices.Warehouse_Activity_Header_WS.WarehouseActivityHeaderWSFilter;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.View;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Portátil1 on 21/12/2017.
 */
@RestController
public class ListarPedidosSalida {

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/ListarPedidosSalida", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    List<WarehouseActivityHeaderWS> listarPedidosSalida(Model model,
                                                        HttpServletRequest request,
                                                        @NotNull @RequestParam(value = "pedido", required = false, defaultValue = "") String pedido,
                                                        @NotNull @RequestParam(value = "localizacion", required = false, defaultValue = "") String localizacion,
                                                        @NotNull @RequestParam(value = "descripcion", required = false, defaultValue = "") String descripcion) {
        /**
         * Leer Pedidos entrada
         */
        // Warehouse_Shipment_Header_WS
        // Creamos el servicio con el WSDL
        /*
         FILTROS
         */
        List<WarehouseActivityHeaderWSFilter> filtros = new ArrayList<WarehouseActivityHeaderWSFilter>();
        WarehouseActivityHeaderWSFilter f1 = new WarehouseActivityHeaderWSFilter();
        f1.setField(WarehouseActivityHeaderWSFields.TYPE);
        f1.setCriteria("Pick");
        filtros.add(f1);
        if (!pedido.equals("")) {

        }
        if (!pedido.equals("")) {

        }
        try {
            return WebServicesInit.PedidoService.readMultiple(filtros, "", 100).getWarehouseActivityHeaderWS();
        }catch(Exception e){
            return null;
        }
    }
}
