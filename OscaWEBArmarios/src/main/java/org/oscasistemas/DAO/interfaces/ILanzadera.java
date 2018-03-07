package org.oscasistemas.DAO.interfaces;

import org.oscasistemas.model.Lanzadera;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
public interface ILanzadera {
    public List<Lanzadera> getLanzaderas();
    public Lanzadera getLanzadera(int id_lanzadera);
    public Lanzadera getLanzadera(String id_lanzadera);
    public Lanzadera getLanzaderaIp(String ipAdress);
    public boolean addOrUpdateLanzadera(Lanzadera l);
    public boolean deleteLanzadera(Lanzadera l);

}
