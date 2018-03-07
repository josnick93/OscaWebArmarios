package org.oscasistemas.DAO.interfaces;

import org.oscasistemas.model.*;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
public interface IEntablado {

    public List<Entablado> getEstanterias();
    public Entablado getEstanteria(String codigo);
    /*
     * Busqueda de estanterias
     */
    public List<Entablado> getEstanterias(Lanzadera lanzadera, int entablado);
    public List<Entablado> getEstanteriasNoSuperanPeso(Lanzadera lanzadera, double peso,TipoCaja c);
    public List<Entablado> getEstanteriasNoSuperanPesoMedida(Lanzadera lanzadera, double peso,int nfilas,int ncolumnas);
    public List<Entablado> getEstanteriasNoSuperanPesoRakingArticulo(Lanzadera lanzadera, Articulo a, double peso);
    public void addOrUpdateCajaEntablado(Entablado c);
    public void removeCajaEntablado(Entablado c);
}
