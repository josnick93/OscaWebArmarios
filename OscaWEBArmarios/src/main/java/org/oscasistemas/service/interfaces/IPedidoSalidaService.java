package org.oscasistemas.service.interfaces;

import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.model.PedidoSalida;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 03/11/2017.
 */
@Component
public interface IPedidoSalidaService {

    public List<PedidoSalida> getPedidoSalida();
    public List<PedidoSalida> getPedidoSalidaCodigo(String nPedido);
    public PedidoSalida getPedidoSalida(String nPedido, int nLinea);
    public List<PedidoSalida> getPedidosLanzadera(Lanzadera l);
    public boolean existePedido(String nPedido);
    public List<PedidoSalida> getPedidosSinMarcarLanzadera(Lanzadera l);
    public List<PedidoSalida> getPedidosSinMarcarLanzadera(String codigo, Lanzadera l);
    public List<PedidoSalida> getLanzaderasPedido(String nPedido);
    public boolean marcarPedidoSalida(String nPedido, int nLinea);
    public boolean estaPedidoFinalizado(String pedido);
    public boolean addOrUpdatePedidoSalida(PedidoSalida l);
    public boolean deletePedidoSalida(PedidoSalida l);
}
