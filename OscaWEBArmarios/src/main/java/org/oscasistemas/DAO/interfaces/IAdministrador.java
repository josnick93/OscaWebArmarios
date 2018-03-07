package org.oscasistemas.DAO.interfaces;

import org.oscasistemas.model.Administrador;
import org.oscasistemas.model.Entablado;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 31/07/2017.
 */
public interface IAdministrador {
    public List<Administrador> getAdministradores();
    public Administrador getAdministrador(int id);
    public Administrador getAdministrador(String ip);
    public void addOrUpdateAdministrador(Administrador a);
    public void removeAdministrador(Administrador a);
}
