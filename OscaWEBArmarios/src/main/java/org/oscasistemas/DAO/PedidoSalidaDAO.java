package org.oscasistemas.DAO;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.jboss.logging.Logger;
import org.oscasistemas.DAO.interfaces.IPedidoSalidaDAO;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.model.PedidoSalida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 03/11/2017.
 */
@Transactional
@Repository
public class PedidoSalidaDAO implements IPedidoSalidaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(PedidoSalidaDAO.class);


    @Override
    public List<PedidoSalida> getPedidoSalida() {
        return sessionFactory.getCurrentSession().createCriteria(PedidoSalida.class).list();
    }

    @Override
    public List<PedidoSalida> getPedidoSalidaCodigo(String nPedido) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PedidoSalida.class);
        criteria.add(Restrictions.eq("Npedido", nPedido));
        return criteria.list();
    }

    @Override
    public boolean existePedido(String nPedido) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PedidoSalida.class);
        criteria.add(Restrictions.eq("Npedido", nPedido));
        return criteria.uniqueResult()!=null;
    }

    @Override
    public PedidoSalida getPedidoSalida(String nPedido, int nLinea) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PedidoSalida.class);
        criteria.add(Restrictions.eq("Npedido", nPedido));
        criteria.add(Restrictions.eq("Nlinea", nLinea));
        return (PedidoSalida) criteria.uniqueResult();
    }

    @Override
    public List<PedidoSalida> getPedidosLanzadera(Lanzadera l) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PedidoSalida.class);
        criteria.add(Restrictions.eq("lanzadera", l));
        return criteria.list();
    }

    @Override
    public List<PedidoSalida> getPedidosSinMarcarLanzadera(Lanzadera l) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PedidoSalida.class);
        criteria.add(Restrictions.eq("lanzadera", l));
        criteria.add(Restrictions.eq("Marcado", false));
        return criteria.list();
    }

    @Override
    public List<PedidoSalida> getPedidosSinMarcarLanzadera(String codigo, Lanzadera l) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PedidoSalida.class);
        criteria.add(Restrictions.eq("lanzadera", l));
        criteria.add(Restrictions.eq("Npedido", codigo));
        criteria.add(Restrictions.eq("Marcado", false));
        return criteria.list();
    }

    @Override
    public List<PedidoSalida> getLanzaderasPedido(String nPedido) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PedidoSalida.class);
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
        criteria.setResultTransformer(Transformers.aliasToBean(PedidoSalida.class));
        return  criteria.list();
    }

    @Override
    public boolean marcarPedidoSalida(String nPedido, int nLinea) {
        PedidoSalida aux=getPedidoSalida(nPedido,nLinea);
        aux.setMarcado(true);
        sessionFactory.getCurrentSession().saveOrUpdate(aux);
        return true;
    }

    @Override
    public boolean addOrUpdatePedidoSalida(PedidoSalida l) {
        sessionFactory.getCurrentSession().saveOrUpdate(l);
        return true;
    }


    @Override
    public boolean estaPedidoFinalizado(String pedido) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PedidoSalida.class);
        criteria.add(Restrictions.eq("Npedido", pedido));
        criteria.add(Restrictions.eq("Marcado", false));
        return criteria.list().isEmpty();
    }

    @Override
    public boolean deletePedidoSalida(PedidoSalida l) {
        sessionFactory.getCurrentSession().delete(l);
        return true;
    }
}
