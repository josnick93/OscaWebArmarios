package org.oscasistemas.service;

import org.oscasistemas.DAO.interfaces.IPedidoSalidaDAO;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.model.PedidoSalida;
import org.oscasistemas.service.interfaces.IPedidoSalidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 03/11/2017.
 */
@Service("pedidosalidaService")
@Transactional
public class PedidoSalidaService implements IPedidoSalidaService {

    @Autowired
    private IPedidoSalidaDAO pedidoSalidaDAO;

    @Transactional
    @Override
    public List<PedidoSalida> getPedidoSalida() {
        return pedidoSalidaDAO.getPedidoSalida();
    }

    @Transactional
    @Override
    public List<PedidoSalida> getPedidoSalidaCodigo(String nPedido) {
        return pedidoSalidaDAO.getPedidoSalidaCodigo(nPedido);
    }

    @Transactional
    @Override
    public boolean existePedido(String nPedido) {
        return false;
    }

    @Transactional
    @Override
    public PedidoSalida getPedidoSalida(String nPedido, int nLinea) {
        return pedidoSalidaDAO.getPedidoSalida(nPedido,nLinea);
    }

    @Transactional
    @Override
    public List<PedidoSalida> getPedidosLanzadera(Lanzadera l) {
        return pedidoSalidaDAO.getPedidosLanzadera(l);
    }

    @Transactional
    @Override
    public List<PedidoSalida> getPedidosSinMarcarLanzadera(Lanzadera l) {
        return pedidoSalidaDAO.getPedidosSinMarcarLanzadera(l);
    }

    @Transactional
    @Override
    public List<PedidoSalida> getPedidosSinMarcarLanzadera(String codigo, Lanzadera l) {
        return pedidoSalidaDAO.getPedidosSinMarcarLanzadera(codigo,l);
    }

    @Transactional
    @Override
    public List<PedidoSalida> getLanzaderasPedido(String nPedido) {
        return pedidoSalidaDAO.getLanzaderasPedido(nPedido);
    }

    @Transactional
    @Override
    public boolean marcarPedidoSalida(String nPedido, int nLinea) {
        return pedidoSalidaDAO.marcarPedidoSalida(nPedido,nLinea);
    }

    @Override
    public boolean estaPedidoFinalizado(String pedido) {
        return pedidoSalidaDAO.estaPedidoFinalizado(pedido);
    }

    @Transactional
    @Override
    public boolean addOrUpdatePedidoSalida(PedidoSalida l) {
        return pedidoSalidaDAO.addOrUpdatePedidoSalida(l);
    }

    @Transactional
    @Override
    public boolean deletePedidoSalida(PedidoSalida l) {
        return pedidoSalidaDAO.deletePedidoSalida(l);
    }
}
