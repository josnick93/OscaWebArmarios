package org.oscasistemas.controller.Salida.SalidaManual;

import com.dynamics.webServices.Bin_Content_WS.BinContentWS;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFields;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFilter;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.CajaEntablado;
import org.oscasistemas.model.Entablado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 21/12/2017.
 */
@RestController
public class SalidaSeleccionUbicacionFinal {



    @Autowired (required = true)
    private IEntablado entabladoService;//shelf query service

    @Autowired
    private ICajaEntablado locationService; //box query service


    /**
     *
     * @param articulo
     * @param entablado
     * @param fila
     * @param columna
     * @param cantidad
     * @param cerrar
     * @param destino
     * @return a page that allows to discount stock from a box
     */
    @RequestMapping(value="/SalidaSeleccionUbicacionFinal")
    public ModelAndView salidaSeleccionUbicacionFinalPage(@NotNull @RequestParam(value="articulo", required=false) String articulo,
                                                          @NotNull @RequestParam(value="entablado", required=false , defaultValue = "-1") String entablado,
                                                          @NotNull @RequestParam(value="fila", required=false  , defaultValue = "-1") int fila,
                                                          @NotNull @RequestParam(value="columna", required=false  , defaultValue = "-1") int columna,
                                                          @NotNull @RequestParam(value="cantidad", required=false  , defaultValue = "-1") int cantidad,
                                                          @NotNull @RequestParam(value="cerrar", required=false  , defaultValue = "-1") int cerrar,
                                                          @NotNull @RequestParam(value="dest", required=false  , defaultValue = "-1") String destino) {
        ModelAndView m=new ModelAndView("Salida/SalidaManual/SalidaArticulo");

        Entablado e=entabladoService.getEstanteria(entablado);
        CajaEntablado c= locationService.getCajasEntablado(e,fila,columna);

        m.getModelMap().addAttribute("entablado",e);
        m.getModelMap().addAttribute("localizacionArticulo",c);
        m.getModelMap().addAttribute("articulo", WebServicesInit.articulosService.read(c.getArticulo()));
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(e));
        m.getModelMap().addAttribute("cerrar", cerrar);
        m.getModelMap().addAttribute("dest", destino);
        m.getModelMap().addAttribute("contenidoNav", getContenidoNav(entablado,articulo));

        return m;
    }


    /**
     *
     * @param codigo
     * @param articulo
     * @return bin content from NAV Web Service
     */
    private BinContentWS getContenidoNav(String codigo,String articulo){
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
