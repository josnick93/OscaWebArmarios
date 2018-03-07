package org.oscasistemas.DAO;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.oscasistemas.DAO.interfaces.IAdministrador;
import org.oscasistemas.model.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 31/07/2017.
 */
@Transactional
@Repository
public class AdministradorDAO implements IAdministrador {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(Administrador.class);


    @Override
    public List<Administrador> getAdministradores() {
        return sessionFactory.getCurrentSession().createCriteria(Administrador.class).list();
    }

    @Override
    public Administrador getAdministrador(int id) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(Administrador.class);
        criteria.add(Restrictions.eq("idAdmmin",id));
        return (Administrador) criteria.uniqueResult();
    }

    @Override
    public Administrador getAdministrador(String ip) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(Administrador.class);
        criteria.add(Restrictions.eq("direccionIp",ip));
        return (Administrador) criteria.uniqueResult();
    }

    @Override
    public void addOrUpdateAdministrador(Administrador a) {
        sessionFactory.getCurrentSession().saveOrUpdate(a);
    }

    @Override
    public void removeAdministrador(Administrador a) {
        sessionFactory.getCurrentSession().delete(a);
    }
}
