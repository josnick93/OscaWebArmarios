package org.oscasistemas.controller.Salida.SalidaManual;

import com.dynamics.webServices.Bin_Content_WS.BinContentWS;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFields;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFilter;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.CajaEntabladoMedida;
import org.oscasistemas.model.Entablado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 21/12/2017.
 */
public class SalidaSeleccionUbicacionFinalMedida {

    @Autowired(required = true)
    private IEntablado entabladoService; //shelf service

    @Autowired
    private ICajaEntablado locationService; //box query service

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService; //custom box query service

    /**
     *
     * @param request
     * @param articulo
     * @param entablado
     * @param fila
     * @param columna
     * @param cantidad
     * @param origen
     * @return
     */
    @RequestMapping(value="/SalidaSeleccionUbicacionFinalMedida")
    public ModelAndView salidaSeleccionUbicacionFinalMedidaPage(HttpServletRequest request,
                                                                @NotNull @RequestParam(value="articulo", required=false) String articulo,
                                                                @NotNull @RequestParam(value="entablado", required=false , defaultValue = "-1") String entablado,
                                                                @NotNull @RequestParam(value="fila", required=false  , defaultValue = "-1") int fila,
                                                                @NotNull @RequestParam(value="columna", required=false  , defaultValue = "-1") int columna,
                                                                @NotNull @RequestParam(value="cantidad", required=false  , defaultValue = "-1") int cantidad,
                                                                @NotNull @RequestParam(value="origen", required=false  , defaultValue = "-1") String origen) {
        ModelAndView m=new ModelAndView("Salida/SalidaManual/SalidaArticuloMedida");

        Entablado e=entabladoService.getEstanteria(entablado);
        CajaEntabladoMedida caja=cajaEntabladoMedidaService.getCajasEntablado(e,fila,columna);
        m.getModelMap().addAttribute("lanzadera",e.getLanzadera().getId_lanzadera());
        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("localizacionArticulo", caja);
        m.getModelMap().addAttribute("articulo", WebServicesInit.articulosService.read(caja.getArticulo()));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("origen", origen);
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(e));
        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(e));
        m.getModelMap().addAttribute("contenidoNav", getContenidoNav(entablado,articulo));
        return m;
    }

    /**
     *
     * @param codigo
     * @param articulo
     * @return bin content from NAV Web Service
     */
    private BinContentWS getContenidoNav(String codigo, String articulo){
        List<BinContentWSFilter> filtros = new ArrayList<BinContentWSFilter>();
        BinContentWSFilter f1 = new BinContentWSFilter();
        f1.setField(BinContentWSFields.BIN_CODE);
        f1.setCriteria(codigo);
        filtros.add(f1);
        BinContentWSFilter f2 = new BinContentWSFilter();
        f2.setField(BinContentWSFields.ITEM_NO);
        f2.setCriteria(articulo);
        filtros.add(f2);
        return WebServicesInit.contenidoUbicacionService.readMultiple(filtros, "", 0).getBinContentWS().get(0);
    }

}
