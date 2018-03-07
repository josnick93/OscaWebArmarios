package org.oscasistemas.service;

import org.oscasistemas.DAO.interfaces.IAcciones;
import org.oscasistemas.DAO.interfaces.IAcessoLazaderas;
import org.oscasistemas.model.Acciones;
import org.oscasistemas.service.interfaces.IAccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 01/08/2017.
 */
@Service("AccionesService")
@Transactional
public class AccionesService implements IAccionesService{

    @Autowired
    private IAcciones accionesDAO;


    @Transactional
    @Override
    public List<Acciones> getAcciones() {
        return accionesDAO.getAcciones();
    }


    @Transactional
    @Override
    public Acciones getAccion(int id) {
        return accionesDAO.getAccion(id);
    }

    @Transactional
    @Override
    public void addOrUpdate(Acciones c) {
        accionesDAO.addOrUpdate(c);
    }

    @Transactional
    @Override
    public void remove(Acciones c) {
        accionesDAO.remove(c);
    }
}
