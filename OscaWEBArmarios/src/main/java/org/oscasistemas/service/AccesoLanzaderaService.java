package org.oscasistemas.service;

import org.oscasistemas.DAO.interfaces.IAcessoLazaderas;
import org.oscasistemas.DAO.interfaces.IArticuloDAO;
import org.oscasistemas.model.AcessoLanzadera;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.service.interfaces.IAcessoLazaderasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 25/07/2017.
*/
@Service("acessoLanzaderaService")
@Transactional
public class AccesoLanzaderaService implements IAcessoLazaderasService{

    @Autowired
    private IAcessoLazaderas acessoLazaderas;

    @Transactional
    @Override
    public List<AcessoLanzadera> getLanzaderas(String ipOrdenador) {
        return acessoLazaderas.getLanzaderas(ipOrdenador);
    }
    @Transactional
    @Override
    public List<AcessoLanzadera> getAcesos() {
        return acessoLazaderas.getAcesos();
    }
    @Transactional
    @Override
    public AcessoLanzadera getAcesso(Lanzadera l, String ipOrdenador) {
        return acessoLazaderas.getAcesso(l,ipOrdenador);
    }


    @Transactional
    @Override
    public void addOrUpdate(AcessoLanzadera c) {
        acessoLazaderas.addOrUpdate(c);
    }

    @Transactional
    @Override
    public void remove(AcessoLanzadera c) {
        acessoLazaderas.remove(c);
    }
}
