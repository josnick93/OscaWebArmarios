package org.oscasistemas.DAO.interfaces;

import org.oscasistemas.model.Articulo;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 29/05/2017.
 */
public interface IArticuloDAO {

    public List<Articulo> getArticulos();
    public Articulo getArticulo(String code);
    public List<Articulo> getArticulos(String codigo,String alias,String descripcion);
}
