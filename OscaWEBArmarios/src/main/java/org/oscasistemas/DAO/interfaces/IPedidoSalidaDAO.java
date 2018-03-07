package org.oscasistemas.DAO.interfaces;

import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.model.PedidoSalida;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 03/11/2017.
 */
public interface IPedidoSalidaDAO {

    public List<PedidoSalida> getPedidoSalida();
    public List<PedidoSalida> getPedidoSalidaCodigo(String nPedido);
    public boolean existePedido(String nPedido);
    public PedidoSalida getPedidoSalida(String nPedido, int nLinea);
    public List<PedidoSalida> getPedidosLanzadera(Lanzadera l);
    public List<PedidoSalida> getPedidosSinMarcarLanzadera(Lanzadera l);
    public List<PedidoSalida> getPedidosSinMarcarLanzadera(String codigo, Lanzadera l);
    public List<PedidoSalida> getLanzaderasPedido(String nPedido);
    public boolean marcarPedidoSalida(String nPedido, int nLinea);
    public boolean estaPedidoFinalizado(String pedido);
    public boolean addOrUpdatePedidoSalida(PedidoSalida l);
    public boolean deletePedidoSalida(PedidoSalida l);

}
