package org.oscasistemas.DAO.interfaces;


import org.oscasistemas.model.GruposLanzaderas;
import org.oscasistemas.model.Lanzadera;

import java.util.List;

/**
 * Created by José Ángel Caudevilla Casaus on 13/02/2018.
 */
public interface IGruposLanzaderas {

    public List<IGruposLanzaderas> getGruposLanzaderas();
    public GruposLanzaderas getGrupo(Lanzadera l1, Lanzadera l2);
    public void addOrUpdate(IGruposLanzaderas g);
    public void remove(IGruposLanzaderas g);
}
