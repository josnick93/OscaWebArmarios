package org.oscasistemas.DAO.interfaces;

import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.model.PedidoEntrada;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 03/11/2017.
 */
public interface IPedidoEntradaDAO {

    public List<PedidoEntrada> getPedidoEntrada();
    public List<PedidoEntrada> getPedidoEntradaCodigo(String nPedido);
    public boolean existePedido(String nPedido);
    public PedidoEntrada getPedidoEntrada(String nPedido,int nLinea);
    public List<PedidoEntrada> getPedidosLanzadera(Lanzadera l);
    public List<PedidoEntrada> getPedidosSinMarcarLanzadera(Lanzadera l);
    public List<PedidoEntrada> getPedidosSinMarcarLanzadera(String codigo,Lanzadera l);
    public List<PedidoEntrada> getLanzaderasPedido(String nPedido);
    public boolean marcarPedidoEntrada(String nPedido,int nLinea);
    public boolean estaPedidoFinalizado(String pedido);
    public boolean addOrUpdatePedidoEntrada(PedidoEntrada l);
    public boolean deletePedidoEntrada(PedidoEntrada l);

}
