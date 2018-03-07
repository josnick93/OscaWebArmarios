package org.oscasistemas.DAO;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.Lanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
@Transactional
@Repository
public class LanzaderaDAO implements ILanzadera {


    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(LanzaderaDAO.class);

    @Override
    public List<Lanzadera> getLanzaderas() {
        return sessionFactory.getCurrentSession().createCriteria(Lanzadera.class).list();
    }

    @Override
    public Lanzadera getLanzadera(int id_lanzadera) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Lanzadera.class);
        criteria.add(Restrictions.eq("Id_lanzadera", id_lanzadera));
        return (Lanzadera) criteria.uniqueResult();
    }

    @Override
    public Lanzadera getLanzadera(String id_lanzadera) {
        return (Lanzadera) sessionFactory.getCurrentSession().get(Lanzadera.class,id_lanzadera);
    }

    @Override
    public Lanzadera getLanzaderaIp(String ipAdress) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Lanzadera.class);
        criteria.add(Restrictions.eq("direccion_ip", ipAdress));
        return (Lanzadera) criteria.uniqueResult();
    }

    @Override
    public boolean addOrUpdateLanzadera(Lanzadera l) {
        sessionFactory.getCurrentSession().saveOrUpdate(l);
        return true;
    }

    @Override
    public boolean deleteLanzadera(Lanzadera l) {
        sessionFactory.getCurrentSession().delete(l);
        return true;
    }
}
