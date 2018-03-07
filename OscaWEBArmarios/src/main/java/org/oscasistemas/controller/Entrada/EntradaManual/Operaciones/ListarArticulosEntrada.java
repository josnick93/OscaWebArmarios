package org.oscasistemas.controller.Entrada.EntradaManual.Operaciones;

import com.dynamics.webServices.Item_Card_WS.ItemCardWSFields;
import com.dynamics.webServices.Item_Card_WS.ItemCardWSFilter;
import com.dynamics.webServices.Item_Card_WS.ItemCardWSList;
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
public class ListarArticulosEntrada {


    /**
     *
     * @param model
     * @param request
     * @param articulo
     * @param alias
     * @param descripcion
     * @return a json with articles find by request parameters
     */
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/ListarArticulosEntrada", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String listarArticulos(Model model,
                                     HttpServletRequest request,
                                     @NotNull @RequestParam(value = "articulo", required = false, defaultValue = "") String articulo,
                                     @NotNull @RequestParam(value = "alias", required = false, defaultValue = "") String alias,
                                     @NotNull @RequestParam(value = "descripcion", required = false, defaultValue = "") String descripcion) {
        //cast producto
        //obtener lanzadera
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        try {
            //JSON RESPONSE
            return  new Gson().toJson(getListaArticulo(articulo, alias, descripcion).getItemCardWS());
        }catch(SOAPFaultException soapException){
            soapException.printStackTrace();
            return "error:"+soapException.getMessage();
        }
    }

    /**
     * WEb service to itemCardWS
     * @param articulo
     * @param alias
     * @param descripcion
     * @return a ItemCardWSList by parameters
     */
    private ItemCardWSList getListaArticulo(String articulo,String alias, String descripcion){
        List<ItemCardWSFilter> filtros = new ArrayList<ItemCardWSFilter>();

        ItemCardWSFilter f1 = new ItemCardWSFilter();
        f1.setField(ItemCardWSFields.NO);
        f1.setCriteria(articulo + "*");
        filtros.add(f1);

        ItemCardWSFilter f2 = new ItemCardWSFilter();
        f2.setField(ItemCardWSFields.SEARCH_DESCRIPTION);
        f2.setCriteria("*" + alias.toUpperCase() + "*");
        filtros.add(f2);

        ItemCardWSFilter f3 = new ItemCardWSFilter();
        f2.setField(ItemCardWSFields.DESCRIPTION);
        f2.setCriteria("*" + descripcion.toUpperCase() + "*");
        filtros.add(f3);


        ItemCardWSList aux=WebServicesInit.articulosService.readMultiple(filtros, "", 50);
        return aux;
    }
}
