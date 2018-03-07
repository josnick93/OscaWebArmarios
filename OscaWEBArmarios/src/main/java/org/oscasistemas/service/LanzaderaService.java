package org.oscasistemas.service;

import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.service.interfaces.ILanzaderaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
@Service("lanzaderaService")
@Transactional
public class LanzaderaService implements ILanzaderaService {

    @Autowired
    private ILanzadera lanzaderaDAO;


    @Transactional
    @Override
    public List<Lanzadera> getLanzaderas() {
        return lanzaderaDAO.getLanzaderas();
    }

    @Transactional
    @Override
    public Lanzadera getLanzadera(int id_lanzadera) {
        return lanzaderaDAO.getLanzadera(id_lanzadera);
    }

    @Transactional
    @Override
    public Lanzadera getLanzadera(String id_lanzadera) {
        return lanzaderaDAO.getLanzadera(id_lanzadera);
    }

    @Transactional
    @Override
    public Lanzadera getLanzaderaIp(String ipAdress) {
        return lanzaderaDAO.getLanzaderaIp(ipAdress);
    }

    @Transactional
    @Override
    public boolean addOrUpdateLanzadera(Lanzadera l) {
        return lanzaderaDAO.addOrUpdateLanzadera(l);
    }

    @Transactional
    @Override
    public boolean deleteLanzadera(Lanzadera l) {
        return lanzaderaDAO.deleteLanzadera(l);
    }
}
