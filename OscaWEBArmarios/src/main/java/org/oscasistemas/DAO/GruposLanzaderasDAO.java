package org.oscasistemas.DAO;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.oscasistemas.DAO.interfaces.IGruposLanzaderas;
import org.oscasistemas.model.GruposLanzaderas;
import org.oscasistemas.model.Lanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevilla Casaus on 13/02/2018.
 */
@Transactional
@Repository
public class GruposLanzaderasDAO implements IGruposLanzaderas{

    @Autowired
    private SessionFactory sessionFactory;


    private static final Logger logger = Logger.getLogger(GruposLanzaderasDAO.class);
    @Override
    public List<IGruposLanzaderas> getGruposLanzaderas(){
         return sessionFactory.getCurrentSession().createCriteria(GruposLanzaderas.class).list();
    }

    @Override
    public GruposLanzaderas getGrupo(Lanzadera l1, Lanzadera l2) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(GruposLanzaderas.class);
        criteria.add(Restrictions.eq("Lanzadera2", l2));
        criteria.add(Restrictions.eq("Lanzadera1", l1));
        return (GruposLanzaderas) criteria.uniqueResult();
    }

    @Override
    public void addOrUpdate(IGruposLanzaderas g) {
        sessionFactory.getCurrentSession().saveOrUpdate(g);
    }

    @Override
    public void remove(IGruposLanzaderas g) {
        sessionFactory.getCurrentSession().delete(g);
    }
}
