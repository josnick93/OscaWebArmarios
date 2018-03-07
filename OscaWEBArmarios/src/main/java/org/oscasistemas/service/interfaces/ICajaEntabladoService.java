package org.oscasistemas.service.interfaces;

import org.oscasistemas.model.Articulo;
import org.oscasistemas.model.CajaEntablado;
import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.Lanzadera;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
@Component
public interface ICajaEntabladoService {

    public List<CajaEntablado> getCajas();
    public List<CajaEntablado> getCajasVacias();
    public List<CajaEntablado> getCajasVacias(Lanzadera l);
    public List<CajaEntablado> getUbicacionesArticulo(Articulo a);
    public List<CajaEntablado> getUbicacionesArticulo(Articulo a , Lanzadera l);
    public List<CajaEntablado> getCajasLanzadera(Lanzadera l);
    public List<CajaEntablado> getCajasEntablado(Entablado entablado);
    public CajaEntablado getCajasEntablado(Lanzadera l,Entablado e, int fila, int columna);
    public void addOrUpdateCajaEntablado(CajaEntablado c);
    public void saveCajaEntablado(CajaEntablado c);
    public void removeCajaEntablado(CajaEntablado c);

}
