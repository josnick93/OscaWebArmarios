package org.oscasistemas.service;

import org.oscasistemas.DAO.interfaces.ITareasPendientes;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.model.TareasPendientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 01/08/2017.
 */
@Service("tareasPendientesService")
@Transactional
public class TareasPendientesService implements ITareasPendientes {


    @Autowired
    private ITareasPendientes tareasPendientesDAO;


    @Transactional
    @Override
    public List<TareasPendientes> getTareasPendientes() {
        return tareasPendientesDAO.getTareasPendientes();
    }

    @Override
    public List<TareasPendientes> getTareasPendientes(String url) {
        return tareasPendientesDAO.getTareasPendientes(url);
    }

    @Transactional
    @Override
    public TareasPendientes getTareaPendiente(int idTarea) {
        return tareasPendientesDAO.getTareaPendiente(idTarea);
    }

    @Transactional
    @Override
    public List<TareasPendientes> getTareasPendientesLanzadera(Lanzadera l) {
        return tareasPendientesDAO.getTareasPendientesLanzadera(l);
    }

    @Override
    public boolean exiteTarea(String tarea) {
        return tareasPendientesDAO.exiteTarea(tarea);
    }

    @Transactional
    @Override
    public void addOrUpdate(TareasPendientes tareasPendientes) {
        tareasPendientesDAO.addOrUpdate(tareasPendientes);
    }

    @Transactional
    @Override
    public void remove(TareasPendientes tareasPendientes) {
        tareasPendientesDAO.remove(tareasPendientes);
    }
}
