package org.oscasistemas.controller.Operaciones.Busqueda;

import com.dynamics.webServices.Bin_WS.BinWS;
import com.dynamics.webServices.Bin_WS.BinWSFields;
import com.dynamics.webServices.Bin_WS.BinWSFilter;
import com.dynamics.webServices.Bin_WS.BinWSList;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.init.WebMvcConfig;
import org.oscasistemas.model.Entablado;
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
 * Created by Portátil1 on 21/12/2017.
 */
@RestController
public class ListarEntablados {

    @Autowired(required = true)
    private IEntablado entabladoService;

    @Autowired
    private ILanzadera lanzaderaService;

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/ListarEntablados", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    List<BinWS> listarEntablado(Model model,
                                HttpServletRequest request,
                                @NotNull @RequestParam(value = "lanzadera", required = false, defaultValue = "-1") int lanzadera,
                                @NotNull @RequestParam(value = "entablado", required = false, defaultValue = "-1") int entablado,
                                @NotNull @RequestParam(value = "descripcion", required = false, defaultValue = "") String descripcion) {
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

        if(WebMvcConfig.useSerWebNav) {
            try{
                return getEntablado(lanzadera,entablado,descripcion).getBinWS();
            }catch(Exception e){
                return null;
            }
        }else{
            List<BinWS> ubicaciones=new ArrayList<>();
            for(Entablado e :entabladoService.getEstanterias(lanzaderaService.getLanzadera(lanzadera),entablado)){
                BinWS b=new BinWS();
                b.setCode(e.getCodigo());
                b.setDescription("");
                ubicaciones.add(b);
            }
            return ubicaciones;
        }

    }
    private BinWSList getEntablado(int lanzadera,int entablado,String descripcion) throws  Exception{
        List<BinWSFilter> filtros = new ArrayList<BinWSFilter>();
        String codigo = "PLNZ";
        if (lanzadera != -1) {
            codigo = codigo + "." + String.format("%02d", lanzadera);
            if (entablado != -1) {
                codigo = codigo + "." + String.format("%04d", entablado);
            } else codigo = codigo + ".*";
        } else {
            if (entablado != -1) {
                codigo = codigo + ".*." + String.format("%04d", entablado);
            } else codigo = codigo + ".*";
        }
        if (!descripcion.equals("")) {
            BinWSFilter f2 = new BinWSFilter();
            f2.setField(BinWSFields.DESCRIPTION);
            f2.setCriteria("*" + descripcion + "*");
            filtros.add(f2);
        }
        BinWSFilter f1 = new BinWSFilter();
        f1.setField(BinWSFields.CODE);
        f1.setCriteria(codigo);
        filtros.add(f1);
        return WebServicesInit.ubicacionesService.readMultiple(filtros, "", 0);

    }
}
