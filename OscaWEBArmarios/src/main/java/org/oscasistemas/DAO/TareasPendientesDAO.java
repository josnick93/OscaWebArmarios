package org.oscasistemas.DAO;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.oscasistemas.DAO.interfaces.ITareasPendientes;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.model.TareasPendientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 01/08/2017.
 */
@Transactional
@Repository
public class TareasPendientesDAO implements ITareasPendientes {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(EntabladoDAO.class);

    @Override
    public List<TareasPendientes> getTareasPendientes() {
        return sessionFactory.getCurrentSession().createCriteria(TareasPendientes.class).list();
    }

    @Override
    public List<TareasPendientes> getTareasPendientes(String url) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(TareasPendientes.class);
        criteria.add(Restrictions.eq("URL",url));
        return criteria.list();
    }

    @Override
    public TareasPendientes getTareaPendiente(int idTarea) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(TareasPendientes.class);
        criteria.add(Restrictions.eq("idTareaPendiente",idTarea));
        return (TareasPendientes) criteria.uniqueResult();
    }
    @Override
    public List<TareasPendientes> getTareasPendientesLanzadera(Lanzadera l) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(TareasPendientes.class);
        criteria.add(Restrictions.eq("lanzadera",l));
        return criteria.list();
    }

    @Override
    public boolean exiteTarea(String Urltarea) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(TareasPendientes.class);
        criteria.add(Restrictions.eq("URL",Urltarea));
        return criteria.uniqueResult()!=null;
    }

    @Override
    public void addOrUpdate(TareasPendientes tareasPendientes) {
        sessionFactory.getCurrentSession().saveOrUpdate(tareasPendientes);
    }
    @Override
    public void remove(TareasPendientes tareasPendientes) {
        sessionFactory.getCurrentSession().delete(tareasPendientes);
    }
}
