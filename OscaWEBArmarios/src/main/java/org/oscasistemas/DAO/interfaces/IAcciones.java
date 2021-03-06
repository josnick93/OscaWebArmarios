package org.oscasistemas.DAO.interfaces;

import org.oscasistemas.model.Acciones;
import org.oscasistemas.model.AcessoLanzadera;
import org.oscasistemas.model.Lanzadera;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 01/08/2017.
 */
public interface IAcciones {
    public List<Acciones> getAcciones();
    public Acciones getAccion(int id);
    public void addOrUpdate(Acciones c);
    public void remove(Acciones c);
}
