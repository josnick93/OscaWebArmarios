package org.oscasistemas.service.interfaces;

import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.model.TareasPendientes;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 01/08/2017.
 */
public interface ITareasPendientesService {
    public List<TareasPendientes> getTareasPendientes();
    public List<TareasPendientes> getTareasPendientes(String url);
    public TareasPendientes getTareaPendiente(int idTarea);
    public List<TareasPendientes> getTareasPendientesLanzadera(Lanzadera l);
    public void addOrUpdate(TareasPendientes tareasPendientes);
    public boolean exiteTarea(String tarea);
    public void remove(TareasPendientes tareasPendientes);
}
