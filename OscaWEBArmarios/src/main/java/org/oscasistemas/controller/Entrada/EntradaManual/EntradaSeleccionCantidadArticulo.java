package org.oscasistemas.controller.Entrada.EntradaManual;

import com.dynamics.webServices.Bin_Content_WS.BinContentWS;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFields;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFilter;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSList;
import com.dynamics.webServices.Item_Card_WS.ItemCardWS;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.*;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.AcessoLanzadera;
import org.oscasistemas.model.CajaEntablado;
import org.oscasistemas.model.CajaEntabladoMedida;
import org.oscasistemas.model.Lanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.SOAPFaultException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 21/12/2017.
 */
@RestController
public class EntradaSeleccionCantidadArticulo {

    @Autowired
    private ILanzadera lanzaderaService;

    @Autowired
    private IAcessoLazaderas acessoLazaderasService;


    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;

    @Autowired
    private ICajaEntablado locationService;


    /**
     *
     * @param request
     * @param articulo
     * @return
     */
    @RequestMapping(value="/EntradaSeleccionCantidadArticulo",method = RequestMethod.GET)
    public ModelAndView entradaSeleccionCantidadArticuloPage(HttpServletRequest request, @NotNull @RequestParam(value = "articulo"
            ,defaultValue = "00.000.0000", required = false) String articulo)
   {

        ModelAndView m= new ModelAndView("Entrada/EntradaManual/EntradaSeleccionCantidadArticulo");
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        ItemCardWS producto=null;
        try {
            producto = WebServicesInit.articulosService.read(articulo);
        }catch(SOAPFaultException ex){
            ModelAndView model = new ModelAndView("error/generic_error");
            model.addObject("errMsg","El nabo no ha podido obtener el articulo");
            return model;
        }
        m.getModelMap().addAttribute("articulo",producto);
        List<BinContentWS> origenes = null;
        try {
            BinContentWSList ubi = getOrigenesArticulo(articulo);
            origenes = new ArrayList<BinContentWS>();
            if (ubi != null) {
                for (BinContentWS ori : ubi.getBinContentWS()) {
                    if (!ori.getBinCode().contains("PLNZ"))
                        origenes.add(ori);
                }
            }
        }catch(Exception e){
            ModelAndView model = new ModelAndView("error/generic_error");
            model.addObject("errMsg","El nabo no ha encontrado las ubicaciones");
            return model;
        }
        try {
            //añadir ubicacion comodin
            BinContentWS comodin = getUbicacionComodin(articulo);
            if (comodin != null) origenes.add(comodin);
        }catch (Exception e){
            ModelAndView model = new ModelAndView("error/generic_error");
            model.addObject("errMsg","El nabo no ha encontrado el comodin");
            return model;
        }


        Lanzadera l=lanzaderaService.getLanzaderaIp(remoteAddr);
        //if request is from lift
        if(l!=null){
            m.getModelMap().addAttribute("ubicaciones",locationService.getUbicacionesArticulo(producto,l));
            m.getModelMap().addAttribute("reservas",cajaEntabladoMedidaService.getUbicacionesArticulo(producto,l));
            m.getModelMap().addAttribute("lanzadera",l);
            m.getModelMap().addAttribute("origenes",origenes);
        }
        //else, remote access
        else{
            //remote lift access from IP
            List<AcessoLanzadera> acessos=getAcesosLanzadera(remoteAddr);
            // get box ubications
            List<CajaEntablado> ubicaciones=locationService.getUbicacionesArticulo(producto);
            // get custom box ubications
            List<CajaEntabladoMedida> reservas=cajaEntabladoMedidaService.getUbicacionesArticulo(producto);
           //search article ubications from this remote pc
            if(acessos!=null || ubicaciones!=null) {
                for (CajaEntablado u : ubicaciones) {
                    boolean pertenece = false;
                    for (AcessoLanzadera a : acessos) {
                        if (u.getLanzadera().getId_lanzadera() == a.getLanzadera().getId_lanzadera())
                            pertenece = true;
                    }
                    if (!pertenece) ubicaciones.remove(u);
                }
                m.getModelMap().addAttribute("ubicaciones",ubicaciones);
            }
            //search article custom ubications from this remote pc
            if(acessos!=null || reservas!=null) {
                //buscar accesos al articulo
                for (CajaEntabladoMedida u : reservas) {
                    boolean pertenece = false;
                    for (AcessoLanzadera a : acessos) {
                        if (u.getLanzadera().getId_lanzadera() == a.getLanzadera().getId_lanzadera())
                            pertenece = true;
                    }
                    if (!pertenece) reservas.remove(u);
                }
                m.getModelMap().addAttribute("reservas",reservas);
            }
            m.getModelMap().addAttribute("localAdress",remoteAddr);
            m.getModelMap().addAttribute("origenes",origenes);
        }
        return m;
    }

    /**
     *
     * @param articulo
     * @return Get article origins,null not found
     */
    private BinContentWSList getOrigenesArticulo(String articulo){

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
        f3.setField(BinContentWSFields.ITEM_NO);
        f3.setCriteria(articulo);
        filtros.add(f3);
        return WebServicesInit.contenidoUbicacionService.readMultiple(filtros, "", 0);
    }

    /**
     * Return Lifts that can be use remoted by a IP
     */
    private List<AcessoLanzadera> getAcesosLanzadera(String ip){
        List<AcessoLanzadera> acessos=new ArrayList<>();
        for(Lanzadera a:lanzaderaService.getLanzaderas()){
            AcessoLanzadera acesso=acessoLazaderasService.getAcesso(a,ip);
            if(acesso!=null) {
                acessos.add(acesso);
            }
        }
        return acessos;
    }


    /**
     * Return a comodin ubication if it contains the article
     */
    private BinContentWS getUbicacionComodin(String articulo){

        List<BinContentWSFilter> filtros = new ArrayList<BinContentWSFilter>();
        BinContentWSFilter f2 = new BinContentWSFilter();
        f2.setField(BinContentWSFields.BIN_CODE);
        f2.setCriteria("CMDN.01.0001");
        filtros.add(f2);
        BinContentWSFilter f3 = new BinContentWSFilter();
        f3.setField(BinContentWSFields.ITEM_NO);
        f3.setCriteria(articulo);
        filtros.add(f3);
        BinContentWSList comodin=WebServicesInit.contenidoUbicacionService.readMultiple(filtros, "", 1);
        if(comodin==null) return null;
        else if(comodin.getBinContentWS().isEmpty()) return null;
        else return  comodin.getBinContentWS().get(0);

        }
}
