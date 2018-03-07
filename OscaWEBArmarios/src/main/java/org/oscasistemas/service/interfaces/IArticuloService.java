package org.oscasistemas.service.interfaces;

import org.oscasistemas.model.Articulo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 22/05/2017.
 */

@Component
public interface IArticuloService {

    public List<Articulo> getArticulos();
    public Articulo getArticulo(String code);
    public List<Articulo> getArticulos(String codigo,String alias,String descripcion);
}
