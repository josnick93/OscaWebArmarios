package org.oscasistemas.controller.Operaciones.Busqueda;

import com.dynamics.webServices.Production_Order_WS.ProductionOrderWS;
import com.dynamics.webServices.Production_Order_WS.ProductionOrderWSFields;
import com.dynamics.webServices.Production_Order_WS.ProductionOrderWSFilter;
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
public class ListarOrdenesProduccion {


    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/ListarOrdenesProduccion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    List<ProductionOrderWS> listarOrdenesProduccion(Model model,
                                                    HttpServletRequest request,
                                                    @NotNull @RequestParam(value = "articulo", required = false) String artiulo,
                                                    @NotNull @RequestParam(value = "alias", required = false) String alias,
                                                    @NotNull @RequestParam(value = "descripcion", required = false) String descripcion) {

        List<ProductionOrderWSFilter> filtros = new ArrayList<ProductionOrderWSFilter>();
        ProductionOrderWSFilter f1 = new ProductionOrderWSFilter();
        f1.setField(ProductionOrderWSFields.DESCRIPTION);
        f1.setCriteria("");
        filtros.add(f1);
        try {
            return WebServicesInit.ordenesProduccionService.readMultiple(filtros, "", 50).getProductionOrderWS();
        }catch (Exception e){
            return null;
        }
    }
}
