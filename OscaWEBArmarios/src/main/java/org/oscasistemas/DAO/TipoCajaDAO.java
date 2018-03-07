package org.oscasistemas.DAO;

import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.oscasistemas.DAO.interfaces.ITipoCaja;
import org.oscasistemas.model.Articulo;
import org.oscasistemas.model.TipoCaja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
@Transactional
@Repository
public class TipoCajaDAO implements ITipoCaja{

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(TipoCaja.class);


    @Override
    public List<TipoCaja> getCajas() {
        return sessionFactory.getCurrentSession().createCriteria(TipoCaja.class).list();
    }

    @Override
    public TipoCaja getTipoCaja(int id_caja) {
        return (TipoCaja) sessionFactory.getCurrentSession().get(TipoCaja.class,id_caja);
    }

    @Override
    public boolean addTipoCaja(TipoCaja t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return true;
    }

    @Override
    public boolean deleteTipoCaja(TipoCaja t) {
       sessionFactory.getCurrentSession().delete(t);
       return true;
    }
}
