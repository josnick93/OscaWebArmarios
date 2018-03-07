package org.oscasistemas.controller.Salida.SalidaManual.Operaciones;

import com.dynamics.webServices.Bin_Content_WS.BinContentWS;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFields;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFilter;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSList;
import com.dynamics.webServices.Item_Card_WS.ItemCardWSFields;
import com.dynamics.webServices.Item_Card_WS.ItemCardWSFilter;
import com.dynamics.webServices.Item_Card_WS.ItemCardWSList;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.IAcessoLazaderas;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.AcessoLanzadera;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.model.View;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ListarArticulosSalida {

    @Autowired
    private ILanzadera lanzaderaService;

    @Autowired
    private IAcessoLazaderas acessoLazaderasService; //remote access query

    /**
     * Return a list of artciles inside specific lift/lifts
     * @param model
     * @param request
     * @param articulo
     * @param alias
     * @param descripcion
     * @return
     */
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/ListarArticulosSalida", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    String listarArticulosSalida(Model model,
                                     HttpServletRequest request,
                                     @NotNull @RequestParam(value = "articulo", required = false, defaultValue = "") String articulo,
                                     @NotNull @RequestParam(value = "alias", required = false, defaultValue = "") String alias,
                                     @NotNull @RequestParam(value = "descripcion", required = false, defaultValue = "") String descripcion) {


        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        Lanzadera l=lanzaderaService.getLanzaderaIp(remoteAddr);

        //is a lift
        if(l!=null){
            try {
                return new Gson().toJson(getArticulos(l,articulo, alias, descripcion).getItemCardWS());
            }catch(SOAPFaultException e){
                e.getMessage();
                return "error:"+e.getMessage();
            }
        }else {
            //remote lift access
            List<AcessoLanzadera> acessosLanzaderas = acessoLazaderasService.getLanzaderas(remoteAddr);
            if (acessosLanzaderas.isEmpty()) {
                return null;
            }
            return new Gson().toJson(getArticulos(acessosLanzaderas, articulo, alias, descripcion)
                    .getItemCardWS());
        }

    }


    /**
     *
     * @param l
     * @param articulo
     * @param alias
     * @param descripcion
     * @returna  list of articles inside lift based on article code,alias and description
     */
    private ItemCardWSList getArticulos(Lanzadera l,String articulo,String alias, String descripcion){

        ItemCardWSList result=new ItemCardWSList();

        //añadir articulos en la lanzadera
        for(BinContentWS c:getUbicacionesLanzadera(l).getBinContentWS()){
            List<ItemCardWSFilter> filtros = new ArrayList<ItemCardWSFilter>();
            ItemCardWSFilter f4 = new ItemCardWSFilter();
            f4.setField(ItemCardWSFields.NO);
            f4.setCriteria(c.getItemNo());
            filtros.add(f4);

            //añadir filtros correspondientes
            if (!articulo.equals("") && articulo.contains(".")) {
                ItemCardWSFilter f1 = new ItemCardWSFilter();
                f1.setField(ItemCardWSFields.NO);
                f1.setCriteria(articulo + "*");
                filtros.add(f1);

            } else if (!articulo.equals("")) {
                ItemCardWSFilter f1 = new ItemCardWSFilter();
                f1.setField(ItemCardWSFields.NO);
                System.out.println(articulo + "*");
                f1.setCriteria(articulo + "*");
                filtros.add(f1);
            }
            if (!descripcion.equals("")) {
                ItemCardWSFilter f3 = new ItemCardWSFilter();
                f3.setField(ItemCardWSFields.DESCRIPTION);
                f3.setCriteria("*" + descripcion.toUpperCase() + "*");
                filtros.add(f3);
            }
            ItemCardWSList aux=WebServicesInit.articulosService.readMultiple(filtros, "", 1);
            if(aux!=null)result.getItemCardWS().add(aux.getItemCardWS().get(0));
        }
        return result;
    }

    /**
     *
     * @param lanzaderas
     * @param articulo
     * @param alias
     * @param descripcion
     * @return a list of articles on a group of lifts
     */
    private ItemCardWSList getArticulos(List<AcessoLanzadera> lanzaderas,String articulo,String alias, String descripcion){
        ItemCardWSList result=new ItemCardWSList();

        //añadir articulos en la lanzadera
        for(BinContentWS c:getUbicacionesLanzadera(lanzaderas).getBinContentWS()){
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
            f3.setField(ItemCardWSFields.DESCRIPTION);
            f3.setCriteria("*" + descripcion.toUpperCase() + "*");
            filtros.add(f3);

            ItemCardWSList aux=WebServicesInit.articulosService.readMultiple(filtros, "", 1);
            if(aux!=null)result.getItemCardWS().add(aux.getItemCardWS().get(0));
        }
        return result;
    }

    private BinContentWSList getUbicacionesLanzadera(Lanzadera l){
        /**
         * Listar contenidos ubicacion de la lanzadera
         */
        List<BinContentWSFilter> filtros = new ArrayList<BinContentWSFilter>();
        BinContentWSFilter f1 = new BinContentWSFilter();
        f1.setField(BinContentWSFields.BIN_CODE);
        f1.setCriteria(String.valueOf("PLNZ."+String.format("%02d", l.getId_lanzadera())+".*"));
        filtros.add(f1);
        //añadir comodin
        BinContentWSFilter f2 = new BinContentWSFilter();
        f2.setField(BinContentWSFields.QUANTITY);
        f2.setCriteria(">0");
        filtros.add(f2);
        return WebServicesInit.contenidoUbicacionService.readMultiple(filtros, "", 75);

    }



    private BinContentWSList getUbicacionesLanzadera(List<AcessoLanzadera> l){
        /**
         * Listar contenidos ubicacion de la lanzadera
         */
        BinContentWSList result=new BinContentWSList();
        for (AcessoLanzadera lanzadera:l){
            result.getBinContentWS().addAll(getUbicacionesLanzadera(lanzadera.getLanzadera()).getBinContentWS());
        }
        return result;

    }


}
