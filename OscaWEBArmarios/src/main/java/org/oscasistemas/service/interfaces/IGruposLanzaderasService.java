package org.oscasistemas.service.interfaces;

import org.oscasistemas.DAO.interfaces.IGruposLanzaderas;
import org.oscasistemas.model.GruposLanzaderas;
import org.oscasistemas.model.Lanzadera;

import java.util.List;

/**
 * Created by Portátil1 on 13/02/2018.
 */
public interface IGruposLanzaderasService {

    public List<IGruposLanzaderas> getGruposLanzaderas();
    public GruposLanzaderas getGrupo(Lanzadera l1, Lanzadera l2);
    public void addOrUpdate(IGruposLanzaderas g);
    public void remove(IGruposLanzaderas g);
}
