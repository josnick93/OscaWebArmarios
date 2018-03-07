package org.oscasistemas.controller.Consulta.Articulo.Operaciones;

import com.dynamics.webServices.Item_Card_WS.ItemCardWS;
import com.dynamics.webServices.Item_Card_WS.ItemCardWSFields;
import com.dynamics.webServices.Item_Card_WS.ItemCardWSFilter;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.Gson;
import com.sun.istack.NotNull;
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
 * Created by José Ángel Caudevílla Casaús on 29/12/2017.
 */
@RestController
public class BusquedaArticulosConsulta {


    /**
     * URL: http://192.168.2.8/OscaArmarios/ConsultaBusquedaArticulo.html
     * @param model
     * @param request
     * @param artiulo
     * @param alias
     * @param descripcion
     * @return list of articles by parameter fields
     */
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/ListarArticulos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String listarArticulos(Model model,
                                     HttpServletRequest request,
                                     @NotNull @RequestParam(value = "articulo", required = false, defaultValue = "") String artiulo,
                                     @NotNull @RequestParam(value = "alias", required = false, defaultValue = "") String alias,
                                     @NotNull @RequestParam(value = "descripcion", required = false, defaultValue = "") String descripcion) {
            try {
                return new Gson().toJson(getArticulo(artiulo, alias, descripcion));
            } catch(SOAPFaultException soapException){
                soapException.printStackTrace();
                return "error:"+soapException.getMessage();
            }
        }

        /**
         * Service web call to get ItemCardWs by fields
         * @param articulo
         * @param alias
         * @param descripcion
         * @return
         */
        private List<ItemCardWS> getArticulo(String articulo,String alias,String descripcion){
                List<ItemCardWSFilter> filtros = new ArrayList<ItemCardWSFilter>();

                ItemCardWSFilter f1 = new ItemCardWSFilter();
                f1.setField(ItemCardWSFields.NO);
                f1.setCriteria("*"+articulo.toUpperCase() + "*");
                filtros.add(f1);

                ItemCardWSFilter f2=new ItemCardWSFilter();
                f2.setField(ItemCardWSFields.SEARCH_DESCRIPTION);
                f2.setCriteria("*"+alias.toUpperCase()+"*");
                filtros.add(f2);

                ItemCardWSFilter f3 = new ItemCardWSFilter();
                f3.setField(ItemCardWSFields.DESCRIPTION);
                f3.setCriteria("*" + descripcion.toUpperCase() + "*");
                filtros.add(f3);

                return WebServicesInit.articulosService.readMultiple(filtros, "", 50).getItemCardWS();

        }

}
