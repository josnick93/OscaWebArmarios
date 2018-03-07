package org.oscasistemas.service.interfaces;

import org.oscasistemas.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
@Component
public interface ICajaEntabladoMedidaService {

    public List<CajaEntabladoMedida> getCajas();
    public List<CajaEntabladoMedida> getCajasVacias();
    public List<CajaEntabladoMedida> getUbicacionesArticulo(Articulo a);
    public List<CajaEntablado> getUbicacionesArticulo(Articulo a , Lanzadera l);
    public List<CajaEntabladoMedida> getCajasLanzadera(Lanzadera l);
    public List<CajaEntabladoMedida> getCajasEntablado(Entablado entablado);
    public CajaEntabladoMedida getCajasEntablado(Lanzadera l, Entablado e, int fila, int columna);
    public CajaEntabladoMedida getCajasEntablado(Entablado e, int fila, int columna);
    public void addOrUpdateCajaEntablado(CajaEntabladoMedida c);
    public void removeCajaEntablado(CajaEntabladoMedida c);

}
