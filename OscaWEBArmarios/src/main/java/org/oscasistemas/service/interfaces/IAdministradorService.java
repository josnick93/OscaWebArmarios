package org.oscasistemas.service.interfaces;

import org.oscasistemas.model.Administrador;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 31/07/2017.
 */
@Component
public interface IAdministradorService {
    public List<Administrador> getAdministradores();
    public Administrador getAdministrador(int id);
    public Administrador getAdministrador(String ip);
    public void addOrUpdateAdministrador(Administrador a);
    public void removeAdministrador(Administrador a);
}
