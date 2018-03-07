package org.oscasistemas.service;

import org.oscasistemas.DAO.interfaces.IGruposLanzaderas;
import org.oscasistemas.model.GruposLanzaderas;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.service.interfaces.IGruposLanzaderasService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Portátil1 on 13/02/2018.
 */
public class GruposLanzaderasService implements IGruposLanzaderasService {

    @Autowired
    private IGruposLanzaderas gruposLanzaderasDAO;

    @Override
    public List<IGruposLanzaderas> getGruposLanzaderas() {
        return gruposLanzaderasDAO.getGruposLanzaderas();
    }

    @Override
    public GruposLanzaderas getGrupo(Lanzadera l1, Lanzadera l2) {
        return gruposLanzaderasDAO.getGrupo(l1,l2);
    }

    @Override
    public void addOrUpdate(IGruposLanzaderas g) {
        gruposLanzaderasDAO.addOrUpdate(g);
    }

    @Override
    public void remove(IGruposLanzaderas g) {
        gruposLanzaderasDAO.remove(g);
    }
}
