package org.oscasistemas.service.interfaces;

import org.oscasistemas.model.Lanzadera;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
@Component
public interface ILanzaderaService {


    public List<Lanzadera> getLanzaderas();
    public Lanzadera getLanzadera(String id_lanzadera);
    public Lanzadera getLanzadera(int id_lanzadera);
    public Lanzadera getLanzaderaIp(String ipAdress);
    public boolean addOrUpdateLanzadera(Lanzadera l);
    public boolean deleteLanzadera(Lanzadera l);

}
