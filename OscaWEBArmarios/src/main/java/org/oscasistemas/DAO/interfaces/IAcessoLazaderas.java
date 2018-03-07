package org.oscasistemas.DAO.interfaces;

import org.oscasistemas.model.AcessoLanzadera;
import org.oscasistemas.model.CajaEntablado;
import org.oscasistemas.model.Lanzadera;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 25/07/2017.
 */
public interface IAcessoLazaderas {
    public List<AcessoLanzadera> getAcesos();
    public List<AcessoLanzadera> getLanzaderas(String ipOrdenador);
    public AcessoLanzadera getAcesso(Lanzadera l,String ipOrdenador);
    public void addOrUpdate(AcessoLanzadera c);
    public void remove(AcessoLanzadera c);
}
