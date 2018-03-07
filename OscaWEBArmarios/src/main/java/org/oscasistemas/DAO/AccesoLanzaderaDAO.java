package org.oscasistemas.DAO;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.oscasistemas.DAO.interfaces.IAcessoLazaderas;
import org.oscasistemas.model.AcessoLanzadera;
import org.oscasistemas.model.Lanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 25/07/2017.
 */
@Transactional
@Repository
public class AccesoLanzaderaDAO implements IAcessoLazaderas {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(EntabladoDAO.class);

    @Override
    public List<AcessoLanzadera> getAcesos() {
        return sessionFactory.getCurrentSession().createCriteria(AcessoLanzadera.class).list();
    }

    @Override
    public List<AcessoLanzadera> getLanzaderas(String ipOrdenador) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(AcessoLanzadera.class);
        criteria.add(Restrictions.eq("ipOrdenador",ipOrdenador));
        return criteria.list();
    }

    @Override
    public AcessoLanzadera getAcesso(Lanzadera l, String ipOrdenador) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AcessoLanzadera.class);
        criteria.add(Restrictions.eq("Lanzadera", l));
        criteria.add(Restrictions.eq("ipOrdenador", ipOrdenador));
        return (AcessoLanzadera) criteria.uniqueResult();
    }

    @Override
    public void addOrUpdate(AcessoLanzadera l) {
        sessionFactory.getCurrentSession().saveOrUpdate(l);
    }

    @Override
    public void remove(AcessoLanzadera l) {
        sessionFactory.getCurrentSession().delete(l);
    }
}
