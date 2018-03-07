package org.oscasistemas.controller.Operaciones.Busqueda;

import com.dynamics.webServices.Bin_Content_WS.BinContentWS;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFields;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFilter;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSList;
import com.dynamics.webServices.Item_Card_WS.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.IAcessoLazaderas;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.init.WebMvcConfig;
import org.oscasistemas.model.Articulo;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.model.View;
import org.oscasistemas.service.interfaces.IArticuloService;
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
public class ListarArticulosEntrada {

    @Autowired
    private IArticuloService articuloService;

    @Autowired
    private ILanzadera lanzaderaService;

    @Autowired
    private IAcessoLazaderas acessoLazaderasService;

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/ListarArticulosEntrada", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.SummaryWithRecipients.class)
    public @ResponseBody
    List<ItemCardWS> listarArticulos(Model model,
                                     HttpServletRequest request,
                                     @NotNull @RequestParam(value = "articulo", required = false, defaultValue = "") String articulo,
                                     @NotNull @RequestParam(value = "alias", required = false, defaultValue = "") String alias,
                                     @NotNull @RequestParam(value = "descripcion", required = false, defaultValue = "") String descripcion) {
        /**
         * Leer articulos
         */
        // Warehouse_Shipment_Header_WS
        // Creamos el servicio con el WSDL
        //cast producto



        //obtener lanzadera
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        Lanzadera l=lanzaderaService.getLanzaderaIp(remoteAddr);
        if (WebMvcConfig.useSerWebNav) {
                return getArticulos(articulo, alias, descripcion).getItemCardWS();
            } else {
                return getMapeoArticulos(articulo, alias, descripcion);
            }
    }


    private ItemCardWSList getArticulos(String articulo,String alias, String descripcion){


        List<BinContentWS> origenes = null;
        BinContentWSList ubi = getOrigenes();
        origenes = new ArrayList<BinContentWS>();
        if (ubi != null) {
            for (BinContentWS ori : ubi.getBinContentWS()) {
                if (!ori.getBinCode().contains("PLNZ"))
                    origenes.add(ori);
            }
        }

        //añadir ubicacion comodin
        System.out.println("COMODIN");
        BinContentWSList comodin = getUbicacionComodin();
        if (comodin != null) origenes.addAll(comodin.getBinContentWS());


        ItemCardWSList result=new ItemCardWSList();

        //añadir articulos en la lanzadera
        for(BinContentWS c:origenes){
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

    private List<ItemCardWS>  getMapeoArticulos(String articulo,String alias, String descripcion){
        List<ItemCardWS> articulos=new ArrayList<>();
        for(Articulo a:articuloService.getArticulos(articulo,alias,descripcion)) {
            ItemCardWS itemCardWS = new ItemCardWS();
            itemCardWS.setNo(a.getNo());
            itemCardWS.setSearchDescription(a.getSearchDescription());
            itemCardWS.setDescription(a.getDescripcion());
            itemCardWS.setDescription2(a.getDescripcion2());
            //itemCardWS.setSafetyStockQuantity(BigInteger.valueOf(a.getSafetyStockQuantity()));
            //itemCardWS.setNetWeight(BigInteger.valueOf(a.getNetWeight()));
            itemCardWS.setType(Type.INVENTORY);
            //itemCardWS.setSafetyStockQuantity(BigInteger.valueOf(a.getQuantity()));
            articulos.add(itemCardWS);
        }
        return articulos;

    }



    private BinContentWSList getOrigenes(){

        List<BinContentWSFilter> filtros = new ArrayList<BinContentWSFilter>();
        BinContentWSFilter f1 = new BinContentWSFilter();
        f1.setField(BinContentWSFields.LOCATION_CODE);
        f1.setCriteria("OSCA");
        filtros.add(f1);
        BinContentWSFilter f2 = new BinContentWSFilter();
        f2.setField(BinContentWSFields.BIN_TYPE_CODE);
        f2.setCriteria("UBPICK");
        filtros.add(f2);
        BinContentWSFilter f3 = new BinContentWSFilter();
        f3.setField(BinContentWSFields.QUANTITY);
        f3.setCriteria(">0");
        filtros.add(f3);
        try {
            return WebServicesInit.contenidoUbicacionService.readMultiple(filtros, "", 0);
        }catch(Exception e){
            return null;
        }

    }

    private BinContentWSList getUbicacionComodin(){

        List<BinContentWSFilter> filtros = new ArrayList<BinContentWSFilter>();
        BinContentWSFilter f2 = new BinContentWSFilter();
        f2.setField(BinContentWSFields.BIN_CODE);
        f2.setCriteria("PCOM.01.0001");
        filtros.add(f2);
        BinContentWSFilter f3 = new BinContentWSFilter();
        f3.setField(BinContentWSFields.QUANTITY);
        f3.setCriteria(">0");
        filtros.add(f3);
        try {
            BinContentWSList comodin = WebServicesInit.contenidoUbicacionService.readMultiple(filtros, "", 0);
            return comodin;
        }catch(Exception e){
            return null;
        }

    }


}
