package org.oscasistemas.service.interfaces;

import org.oscasistemas.model.Acciones;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 01/08/2017.
 */
@Component
public interface IAccionesService {
    public List<Acciones> getAcciones();
    public Acciones getAccion(int id);
    public void addOrUpdate(Acciones c);
    public void remove(Acciones c);
}
