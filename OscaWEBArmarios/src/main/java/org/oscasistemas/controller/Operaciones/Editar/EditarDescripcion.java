package org.oscasistemas.controller.Operaciones.Editar;

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
 * Created by Portátil1 on 22/12/2017.
 */
@RestController
public class EditarDescripcion {
    @Autowired(required = true)
    private IEntablado entabladoService;

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/editarDescripcion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String editarDescripcion(Model model,
                             HttpServletRequest request,
                             @NotNull @RequestParam(value = "lanzadera", required = true, defaultValue = "-1") int idLanzadera,
                             @NotNull @RequestParam(value = "entablado", required = true, defaultValue = "-1") String entablado,
                             @NotNull @RequestParam(value = "descripcion", required = true, defaultValue = "") String descripcion) {
        //Entablado e = entabladoService.getEstanteria(entablado);
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        //modificar servicio web de NAV
        //e.setDescripcion(descripcion);
        //entabladoService.addOrUpdateCajaEntablado(e);
        return descripcion;
    }

}
