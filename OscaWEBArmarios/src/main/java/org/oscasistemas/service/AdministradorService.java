package org.oscasistemas.service;

import org.oscasistemas.DAO.interfaces.IAdministrador;
import org.oscasistemas.model.Administrador;
import org.oscasistemas.service.interfaces.IAdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 31/07/2017.
 */
@Service("administradorService")
@Transactional
public class AdministradorService implements IAdministrador{

    @Autowired
    private IAdministrador administradorDAO;

    @Override
    public List<Administrador> getAdministradores() {
        return administradorDAO.getAdministradores();
    }

    @Override
    public Administrador getAdministrador(int id) {
        return administradorDAO.getAdministrador(id);
    }

    @Override
    public Administrador getAdministrador(String ip) {
        return administradorDAO.getAdministrador(ip);
    }

    @Override
    public void addOrUpdateAdministrador(Administrador a) {
        administradorDAO.addOrUpdateAdministrador(a);
    }

    @Override
    public void removeAdministrador(Administrador a) {
        administradorDAO.removeAdministrador(a);
    }
}
