package org.oscasistemas.DAO;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.jboss.logging.Logger;
import org.oscasistemas.DAO.interfaces.IPedidoEntradaDAO;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.model.PedidoEntrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 03/11/2017.
 */
@Transactional
@Repository
public class PedidoEntradaDAO implements IPedidoEntradaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(PedidoEntradaDAO.class);


    @Override
    public List<PedidoEntrada> getPedidoEntrada() {
        return sessionFactory.getCurrentSession().createCriteria(PedidoEntrada.class).list();
    }

    @Override
    public List<PedidoEntrada> getPedidoEntradaCodigo(String nPedido) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PedidoEntrada.class);
        criteria.add(Restrictions.eq("Npedido", nPedido));
        return criteria.list();
    }

    @Override
    public boolean existePedido(String nPedido) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PedidoEntrada.class);
        criteria.add(Restrictions.eq("Npedido", nPedido));
        return criteria.uniqueResult()!=null;
    }

    @Override
    public PedidoEntrada getPedidoEntrada(String nPedido, int nLinea) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PedidoEntrada.class);
        criteria.add(Restrictions.eq("Npedido", nPedido));
        criteria.add(Restrictions.eq("Nlinea", nLinea));
        return (PedidoEntrada) criteria.uniqueResult();
    }

    @Override
    public List<PedidoEntrada> getPedidosLanzadera(Lanzadera l) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PedidoEntrada.class);
        criteria.add(Restrictions.eq("lanzadera", l));
        return criteria.list();
    }

    @Override
    public List<PedidoEntrada> getPedidosSinMarcarLanzadera(Lanzadera l) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PedidoEntrada.class);
        criteria.add(Restrictions.eq("lanzadera", l));
        criteria.add(Restrictions.eq("Marcado", false));
        return criteria.list();
    }

    @Override
    public List<PedidoEntrada> getPedidosSinMarcarLanzadera(String codigo, Lanzadera l) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PedidoEntrada.class);
        criteria.add(Restrictions.eq("lanzadera", l));
        criteria.add(Restrictions.eq("Npedido", codigo));
        criteria.add(Restrictions.eq("Marcado", false));
        return criteria.list();
    }

    @Override
    public List<PedidoEntrada> getLanzaderasPedido(String nPedido) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PedidoEntrada.class);
        criteria.add(Restrictions.eq("Npedido", nPedido));
        criteria.add(Restrictions.eq("Marcado", false));
        criteria  .setProjection( Projections.projectionList()
                        .add(Projections.property("Npedido"), "Npedido")
                        .add(Projections.property("Nlinea"), "Nlinea")
                        .add(Projections.property("entablado"), "entablado")
                        .add(Projections.property("Marcado"), "Marcado")
                        .add(Projections.property("Marcado"), "Marcado")
                        .add(Projections.groupProperty("lanzadera"), "lanzadera" ))
                .addOrder( Order.asc("lanzadera") );
        criteria.setResultTransformer(Transformers.aliasToBean(PedidoEntrada.class));
        return  criteria.list();
    }

    @Override
    public boolean marcarPedidoEntrada(String nPedido, int nLinea) {
        PedidoEntrada aux=getPedidoEntrada(nPedido,nLinea);
        aux.setMarcado(true);
        sessionFactory.getCurrentSession().saveOrUpdate(aux);
        return true;
    }

    @Override
    public boolean addOrUpdatePedidoEntrada(PedidoEntrada l) {
        sessionFactory.getCurrentSession().saveOrUpdate(l);
        return true;
    }


    @Override
    public boolean estaPedidoFinalizado(String pedido) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PedidoEntrada.class);
        criteria.add(Restrictions.eq("Npedido", pedido));
        criteria.add(Restrictions.eq("Marcado", false));
        return criteria.list().isEmpty();
    }

    @Override
    public boolean deletePedidoEntrada(PedidoEntrada l) {
        sessionFactory.getCurrentSession().delete(l);
        return true;
    }
}
