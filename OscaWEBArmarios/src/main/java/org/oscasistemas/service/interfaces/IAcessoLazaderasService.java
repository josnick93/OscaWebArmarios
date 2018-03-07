package org.oscasistemas.service.interfaces;

import org.oscasistemas.model.AcessoLanzadera;
import org.oscasistemas.model.Lanzadera;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 25/07/2017.
 */
@Component
public interface IAcessoLazaderasService {

    public List<AcessoLanzadera> getLanzaderas(String ipOrdenador);
    public List<AcessoLanzadera> getAcesos();
    public AcessoLanzadera getAcesso(Lanzadera l, String ipOrdenador) ;
    public void addOrUpdate(AcessoLanzadera c);
    public void remove(AcessoLanzadera c);
}
