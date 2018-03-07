package org.oscasistemas.service;

import org.oscasistemas.DAO.interfaces.IArticuloDAO;
import org.oscasistemas.model.Articulo;
import org.oscasistemas.service.interfaces.IArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("articuloService")
@Transactional
public class ArticuloService implements IArticuloService {

    @Autowired
    private IArticuloDAO articuloDAO;

    @Transactional
    @Override
    public List<Articulo> getArticulos() {
        return articuloDAO.getArticulos();
    }


    @Transactional
    @Override
    public Articulo getArticulo(String code) {
        return articuloDAO.getArticulo(code);
    }

    @Transactional
    @Override
    public List<Articulo> getArticulos(String codigo, String alias, String descripcion) {
        return articuloDAO.getArticulos(codigo,alias,descripcion);
    }
}
