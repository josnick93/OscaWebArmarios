package org.oscasistemas.service;

import org.oscasistemas.DAO.interfaces.IPedidoEntradaDAO;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.model.PedidoEntrada;
import org.oscasistemas.service.interfaces.IPedidoEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 03/11/2017.
 */
@Service("pedidoentradaService")
@Transactional
public class PedidoEntradaService implements IPedidoEntradaService {

    @Autowired
    private IPedidoEntradaDAO pedidoEntradaDAO;

    @Transactional
    @Override
    public List<PedidoEntrada> getPedidoEntrada() {
        return pedidoEntradaDAO.getPedidoEntrada();
    }

    @Transactional
    @Override
    public List<PedidoEntrada> getPedidoEntradaCodigo(String nPedido) {
        return pedidoEntradaDAO.getPedidoEntradaCodigo(nPedido);
    }

    @Transactional
    @Override
    public boolean existePedido(String nPedido) {
        return false;
    }

    @Transactional
    @Override
    public PedidoEntrada getPedidoEntrada(String nPedido, int nLinea) {
        return pedidoEntradaDAO.getPedidoEntrada(nPedido,nLinea);
    }

    @Transactional
    @Override
    public List<PedidoEntrada> getPedidosLanzadera(Lanzadera l) {
        return pedidoEntradaDAO.getPedidosLanzadera(l);
    }

    @Transactional
    @Override
    public List<PedidoEntrada> getPedidosSinMarcarLanzadera(Lanzadera l) {
        return pedidoEntradaDAO.getPedidosSinMarcarLanzadera(l);
    }

    @Transactional
    @Override
    public List<PedidoEntrada> getPedidosSinMarcarLanzadera(String codigo, Lanzadera l) {
        return pedidoEntradaDAO.getPedidosSinMarcarLanzadera(codigo,l);
    }

    @Transactional
    @Override
    public List<PedidoEntrada> getLanzaderasPedido(String nPedido) {
        return pedidoEntradaDAO.getLanzaderasPedido(nPedido);
    }

    @Transactional
    @Override
    public boolean marcarPedidoEntrada(String nPedido, int nLinea) {
        return pedidoEntradaDAO.marcarPedidoEntrada(nPedido,nLinea);
    }

    @Override
    public boolean estaPedidoFinalizado(String pedido) {
        return pedidoEntradaDAO.estaPedidoFinalizado(pedido);
    }

    @Transactional
    @Override
    public boolean addOrUpdatePedidoEntrada(PedidoEntrada l) {
        return pedidoEntradaDAO.addOrUpdatePedidoEntrada(l);
    }

    @Transactional
    @Override
    public boolean deletePedidoEntrada(PedidoEntrada l) {
        return pedidoEntradaDAO.deletePedidoEntrada(l);
    }
}
