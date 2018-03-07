package org.oscasistemas.service;

import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
@Service("entabladoService")
@Transactional
public class EntabladoService implements IEntablado {

    @Autowired
    private IEntablado entabladoDAO;

    @Transactional
    @Override
    public List<Entablado> getEstanterias() {
        return entabladoDAO.getEstanterias();
    }

    @Transactional
    @Override
    public Entablado getEstanteria(String codigo) {
        return entabladoDAO.getEstanteria(codigo);
    }


    @Transactional
    @Override
    public List<Entablado> getEstanterias(Lanzadera lanzadera, int entablado) {
        return entabladoDAO.getEstanterias(lanzadera,entablado);
    }
    @Transactional
    @Override
    public List<Entablado> getEstanteriasNoSuperanPeso(Lanzadera lanzadera, double peso, TipoCaja caja) {
        return entabladoDAO.getEstanteriasNoSuperanPeso(lanzadera,peso,caja);
    }

    @Override
    public List<Entablado> getEstanteriasNoSuperanPesoMedida(Lanzadera lanzadera, double peso, int nfilas, int ncolumnas) {
        return entabladoDAO.getEstanteriasNoSuperanPesoMedida(lanzadera,peso,nfilas,ncolumnas);
    }

    @Transactional
    @Override
    public List<Entablado> getEstanteriasNoSuperanPesoRakingArticulo(Lanzadera lanzadera, Articulo a, double peso) {
        return entabladoDAO.getEstanteriasNoSuperanPesoRakingArticulo(lanzadera,a,peso);
    }
    @Transactional

    @Override
    public void addOrUpdateCajaEntablado(Entablado c) {
        entabladoDAO.addOrUpdateCajaEntablado(c);
    }
    @Transactional

    @Override
    public void removeCajaEntablado(Entablado c) {
        entabladoDAO.removeCajaEntablado(c);
    }
}
