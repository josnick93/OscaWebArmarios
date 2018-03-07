package org.oscasistemas.controller.Operaciones.Obtencion;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.internal.NotNull;
import org.json.JSONObject;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.View;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 21/12/2017.
 */
@RestController
public class obtenerDescripcionArticulo {

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/obtenerDescripcionArticulo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String getDescripcionArticulo(Model model,
                                  HttpServletRequest request,
                                  @NotNull @RequestParam(value = "articulo", required = true, defaultValue = "00.000.0000") String articulo) {
        try {
            return JSONObject.quote(WebServicesInit.functionsService.getItemDescription(articulo));
        }
        catch(Exception e){
            return JSONObject.quote("Error");
        }
        //return  "{\"success\":"++"}";
    }
}
