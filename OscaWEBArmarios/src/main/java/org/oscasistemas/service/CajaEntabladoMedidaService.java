package org.oscasistemas.service;

import com.dynamics.webServices.Item_Card_WS.ItemCardWS;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.model.Articulo;
import org.oscasistemas.model.CajaEntabladoMedida;
import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.Lanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
@Service("cajaEntabladoMedidaService")
@Transactional
public class CajaEntabladoMedidaService implements ICajaEntabladoMedida {

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaDAO;

    @Transactional
    @Override
    public List<CajaEntabladoMedida> getCajas() {
        return cajaEntabladoMedidaDAO.getCajas();
    }
    @Transactional
    @Override
    public List<CajaEntabladoMedida> getCajasVacias() {
        return cajaEntabladoMedidaDAO.getCajasVacias();
    }
    @Transactional
    @Override
    public List<CajaEntabladoMedida> getUbicacionesArticulo(Articulo a) {
        return cajaEntabladoMedidaDAO.getUbicacionesArticulo(a);
    }

    @Override
    public List<CajaEntabladoMedida> getUbicacionesArticulo(ItemCardWS a) {
        return cajaEntabladoMedidaDAO.getUbicacionesArticulo(a);
    }

    @Override
    public List<CajaEntabladoMedida> getUbicacionesArticulo(Articulo a, Lanzadera l) {
        return cajaEntabladoMedidaDAO.getUbicacionesArticulo(a,l);
    }

    @Override
    public List<CajaEntabladoMedida> getUbicacionesArticulo(ItemCardWS a, Lanzadera l) {
        return cajaEntabladoMedidaDAO.getUbicacionesArticulo(a,l);
    }

    @Transactional
    @Override
    public List<CajaEntabladoMedida> getCajasLanzadera(Lanzadera l) {
        return cajaEntabladoMedidaDAO.getCajasLanzadera(l);
    }

    @Transactional
    @Override
    public List<CajaEntabladoMedida> getCajasEntablado(Entablado entablado) {
        return cajaEntabladoMedidaDAO.getCajasEntablado(entablado);
    }
    @Transactional
    @Override
    public CajaEntabladoMedida getCajasEntablado(Lanzadera l, Entablado e, int fila, int columna) {
        return cajaEntabladoMedidaDAO.getCajasEntablado(l,e,fila,columna);
    }

    @Override
    public CajaEntabladoMedida getCajasEntablado(Entablado e, int fila, int columna) {
        return cajaEntabladoMedidaDAO.getCajasEntablado(e,fila,columna);
    }

    @Transactional
    @Override
    public void addOrUpdateCajaEntablado(CajaEntabladoMedida c) {
        cajaEntabladoMedidaDAO.addOrUpdateCajaEntablado(c);
    }
    @Transactional
    @Override
    public void removeCajaEntablado(CajaEntabladoMedida c) {
        cajaEntabladoMedidaDAO.removeCajaEntablado(c);
    }
}
