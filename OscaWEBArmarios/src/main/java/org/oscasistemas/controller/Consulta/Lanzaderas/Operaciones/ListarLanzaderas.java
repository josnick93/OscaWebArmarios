package org.oscasistemas.controller.Consulta.Lanzaderas.Operaciones;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.IAcessoLazaderas;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.model.AcessoLanzadera;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.model.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 21/12/2017.
 */
@RestController
public class ListarLanzaderas {


    @Autowired
    private IAcessoLazaderas acessoLazaderasService;

    @Autowired
    private ILanzadera lanzaderaService;

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/ListarLanzaderas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    List<AcessoLanzadera> listarLanzaderas(Model model,
                                           HttpServletRequest request,
                                           @NotNull @RequestParam(value = "ip", required = true, defaultValue = "127.0.0.1") String ipAdress) {
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

        List<Lanzadera> lanzaderas=lanzaderaService.getLanzaderas();

        List<AcessoLanzadera> accesos=new ArrayList<>();

        for(Lanzadera l:lanzaderas){
            AcessoLanzadera aux=acessoLazaderasService.getAcesso(l,remoteAddr);
            if(aux!=null){
                accesos.add(aux);
            }
        }

        return  accesos;
    }
}
