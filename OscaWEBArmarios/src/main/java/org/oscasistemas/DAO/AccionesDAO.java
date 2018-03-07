package org.oscasistemas.DAO;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.oscasistemas.DAO.interfaces.IAcciones;
import org.oscasistemas.model.Acciones;
import org.oscasistemas.model.Administrador;
import org.oscasistemas.model.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 01/08/2017.
 */
@Transactional
@Repository
public class AccionesDAO implements IAcciones{

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(Acciones.class);

    @Override
    public List<Acciones> getAcciones() {
        return sessionFactory.getCurrentSession().createCriteria(Acciones.class).list();
    }

    @Override
    public Acciones getAccion(int id) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(Acciones.class);
        criteria.add(Restrictions.eq("Id_accion",id));
        return (Acciones) criteria.uniqueResult();
    }

    @Override
    public void addOrUpdate(Acciones c) {
        sessionFactory.getCurrentSession().saveOrUpdate(c);
    }

    @Override
    public void remove(Acciones c) {
        sessionFactory.getCurrentSession().delete(c);
    }
}
