package org.oscasistemas.service;

import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.model.Articulo;
import org.oscasistemas.model.CajaEntablado;
import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.service.interfaces.ICajaEntabladoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
@Service("cajaEntabladoService")
@Transactional
public class CajaEntabladoService implements ICajaEntabladoService {

    @Autowired
    private ICajaEntablado cajaEntabladoDAO;

    @Transactional
    @Override
    public List<CajaEntablado> getCajas() {
        return cajaEntabladoDAO.getCajas();
    }

    @Transactional
    @Override
    public List<CajaEntablado> getCajasVacias() {
        return cajaEntabladoDAO.getCajasVacias();
    }

    @Override
    public List<CajaEntablado> getCajasVacias(Lanzadera l) {
        return cajaEntabladoDAO.getCajasVacias(l);
    }

    @Transactional
    @Override
    public List<CajaEntablado> getUbicacionesArticulo(Articulo a) {
        return cajaEntabladoDAO.getUbicacionesArticulo(a);
    }

    @Transactional
    @Override
    public List<CajaEntablado> getUbicacionesArticulo(Articulo a, Lanzadera l) {
        return cajaEntabladoDAO.getUbicacionesArticulo(a,l);
    }

    @Transactional
    @Override
    public List<CajaEntablado> getCajasLanzadera(Lanzadera l) {
        return cajaEntabladoDAO.getCajasLanzadera(l);
    }

    @Transactional
    @Override
    public List<CajaEntablado> getCajasEntablado(Entablado entablado) {
        return cajaEntabladoDAO.getCajasEntablado(entablado);
    }

    @Override
    public CajaEntablado getCajasEntablado(Lanzadera l, Entablado e, int fila, int columna) {
        return cajaEntabladoDAO.getCajasEntablado(l,e,fila,columna);
    }

    @Transactional
    @Override
    public void addOrUpdateCajaEntablado(CajaEntablado c) {
        cajaEntabladoDAO.addOrUpdateCajaEntablado(c);
    }

    @Override
    public void saveCajaEntablado(CajaEntablado c) {
        cajaEntabladoDAO.saveCajaEntablado(c);
    }


    @Transactional
    @Override
    public void removeCajaEntablado(CajaEntablado c) {
        cajaEntabladoDAO.removeCajaEntablado(c);
    }
}
