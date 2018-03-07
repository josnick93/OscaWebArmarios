package org.oscasistemas.DAO.interfaces;

import com.dynamics.webServices.Item_Card_WS.ItemCardWS;
import org.oscasistemas.model.*;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
public interface ICajaEntabladoMedida {

    public List<CajaEntabladoMedida> getCajas();
    public List<CajaEntabladoMedida> getCajasVacias();
    public List<CajaEntabladoMedida> getUbicacionesArticulo(Articulo a);
    public List<CajaEntabladoMedida> getUbicacionesArticulo(ItemCardWS a);
    public List<CajaEntabladoMedida> getUbicacionesArticulo(Articulo a,Lanzadera l);
    public List<CajaEntabladoMedida> getUbicacionesArticulo(ItemCardWS a, Lanzadera l);
    public List<CajaEntabladoMedida> getCajasLanzadera(Lanzadera l);
    public List<CajaEntabladoMedida> getCajasEntablado(Entablado entablado);
    public CajaEntabladoMedida getCajasEntablado(Lanzadera l, Entablado e, int fila, int columna);
    public CajaEntabladoMedida getCajasEntablado(Entablado e, int fila, int columna);
    public void addOrUpdateCajaEntablado(CajaEntabladoMedida c);
    public void removeCajaEntablado(CajaEntabladoMedida c);

}
