package org.oscasistemas.controller.Salida.SalidaManual;

import com.dynamics.webServices.Bin_WS.BinWS;
import com.dynamics.webServices.Bin_WS.BinWSFields;
import com.dynamics.webServices.Bin_WS.BinWSFilter;
import com.dynamics.webServices.Bin_WS.BinWSList;
import com.dynamics.webServices.Item_Card_WS.ItemCardWS;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.IAcessoLazaderas;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.AcessoLanzadera;
import org.oscasistemas.model.CajaEntablado;
import org.oscasistemas.model.CajaEntabladoMedida;
import org.oscasistemas.model.Lanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 21/12/2017.
 */
@RestController
public class SalidaSeleccionUbicacion {

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
     * @param lanzadera
     * @return a page that allow select a shelf for a output
     * @throws Exception
     */
    @RequestMapping(value="/SalidaSeleccionUbicacion" ,method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView salidaSeleccionUbicacionPage(HttpServletRequest request, @NotNull @RequestParam(value = "articulo")String articulo,
                                                     @NotNull @RequestParam(value="lanzadera" ,required = false, defaultValue = "-1") int lanzadera) throws Exception {
        ModelAndView m= new ModelAndView("Salida/SalidaManual/SalidaSeleccionUbicacion");
        //Articulo a=articuloService.getArticulo(articulo);
        ItemCardWS a= WebServicesInit.articulosService.read(articulo);
        m.getModelMap().addAttribute("articulo",a);


        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        Lanzadera l=lanzaderaService.getLanzaderaIp(remoteAddr);
        //request ip is a lift
        if(l!=null) {
            m.getModelMap().addAttribute("lanzadera",l);
            m.getModelMap().addAttribute("ubicaciones", locationService.getUbicacionesArticulo(a,l));
            m.getModelMap().addAttribute("reservas",cajaEntabladoMedidaService.getUbicacionesArticulo(a,l));

        }
        //is a remote lift??
        else {
            //list of remote lifs access
            List<AcessoLanzadera> acessos=getAcesosLanzadera(remoteAddr);
            //list of ubications of this article
            List<CajaEntablado> ubicaciones=locationService.getUbicacionesArticulo(a);
            //list of custom ubications of this article
            List<CajaEntabladoMedida> reservas=cajaEntabladoMedidaService.getUbicacionesArticulo(a);
            //can i access to this box from my ip???
            for(CajaEntablado u:ubicaciones){
                boolean pertenece=false;
                for(AcessoLanzadera acceso:acessos){
                    if(u.getLanzadera().getId_lanzadera()==acceso.getLanzadera().getId_lanzadera())
                        pertenece=true;
                }
                if (!pertenece) ubicaciones.remove(u);
            }
            //can i access to this custom box from my ip???
            for(CajaEntabladoMedida u:reservas){
                boolean pertenece=false;
                for(AcessoLanzadera accesos:acessos){
                    if(u.getLanzadera().getId_lanzadera()==accesos.getLanzadera().getId_lanzadera())
                        pertenece=true;
                }
                if (!pertenece) reservas.remove(u);
            }
            m.getModelMap().addAttribute("ubicaciones",ubicaciones);
            m.getModelMap().addAttribute("reservas",reservas);
            m.getModelMap().addAttribute("lanzadera",null);
        }

        //get list of destiny ubications
        BinWSList destinos = getDestinosArticulo();
        List<BinWS> destinos2 = null;
        if(destinos!=null) {
            destinos2 = new ArrayList<BinWS>();
            for (BinWS des : destinos.getBinWS()) {
                if (!des.getCode().contains("PLNZ")){
                    destinos2.add(des);
                }

            }

        }
        BinWSList comodin=getUbicacionComodin();
        if(comodin!=null) destinos2.addAll(comodin.getBinWS());

        if(destinos2!=null)m.getModelMap().addAttribute("destinos",destinos2);
        return m;
    }

    /**
     * Obtiene aquellas ubicacion destino
     * @return
     */
    private BinWSList getDestinosArticulo() throws  Exception{

        List<BinWSFilter> filtros = new ArrayList<BinWSFilter>();
        BinWSFilter f1 = new BinWSFilter();
        f1.setField(BinWSFields.LOCATION_CODE);
        f1.setCriteria("OSCA");
        filtros.add(f1);
        BinWSFilter f2 = new BinWSFilter();
        f2.setField(BinWSFields.BIN_TYPE_CODE);
        f2.setCriteria("UBPICK");
        filtros.add(f2);
        BinWSList resultado= WebServicesInit.ubicacionesService.readMultiple(filtros, "", 0);
        if (resultado == null) return null;
        else if (resultado.getBinWS().isEmpty()) return null;
        else return resultado;

    }

    /*
       * Devuelve las lanzaderas a las que se tiene acceso desde una ip
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
     * Return CMDN Bin code if it contains the article
     * @return
     * @throws Exception
     */
    private BinWSList getUbicacionComodin() throws  Exception{

        List<BinWSFilter> filtros = new ArrayList<BinWSFilter>();
        BinWSFilter f1 = new BinWSFilter();
        f1.setField(BinWSFields.LOCATION_CODE);
        f1.setCriteria("OSCA");
        filtros.add(f1);
        BinWSFilter f2 = new BinWSFilter();
        f2.setField(BinWSFields.BIN_TYPE_CODE);
        f2.setCriteria("QC");
        filtros.add(f2);
        return WebServicesInit.ubicacionesService.readMultiple(filtros, "", 0);
    }

}
