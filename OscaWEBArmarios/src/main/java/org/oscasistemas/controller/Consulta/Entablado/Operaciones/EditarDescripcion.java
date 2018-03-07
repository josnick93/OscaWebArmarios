package org.oscasistemas.controller.Consulta.Entablado.Operaciones;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.model.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 22/12/2017.
 */
@RestController
public class EditarDescripcion {
    @Autowired(required = true)
    private IEntablado entabladoService;

    /**
     * UNUSED!!!!!!!
     * Change the description of a lift
     * @param model
     * @param request
     * @param idLanzadera
     * @param entablado
     * @param descripcion
     * @return
     */
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/editarDescripcion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String editarDescripcion(Model model,
                             HttpServletRequest request,
                             @NotNull @RequestParam(value = "lanzadera", required = true, defaultValue = "-1") int idLanzadera,
                             @NotNull @RequestParam(value = "entablado", required = true, defaultValue = "-1") String entablado,
                             @NotNull @RequestParam(value = "descripcion", required = true, defaultValue = "") String descripcion)
    throws Exception{
        //Entablado e = entabladoService.getEstanteria(entablado);
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        return descripcion;
    }

}
