package org.oscasistemas.DAO;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.oscasistemas.DAO.interfaces.IHistorico;
import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.Historico;
import org.oscasistemas.model.Lanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 11/07/2017.
 */
@Transactional
@Repository
public class HistoricoDAO implements IHistorico {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(EntabladoDAO.class);



    @Override
    public List<Historico> getHistorio(Lanzadera l, Entablado e) {
        return sessionFactory.getCurrentSession().createCriteria(Historico.class).list();
    }

    @Override
    public List<Historico> getHistoricoUltimoMes(Lanzadera l, Entablado e) {
        Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Historico.class);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Timestamp ts=new Timestamp(cal.getTimeInMillis());
        criteria.add(Restrictions.ge("fecha", ts));
        return criteria.list();
    }

    @Override
    public List<Historico> getHistoricoUltimos3Meses(Lanzadera l, Entablado e) {
        Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Historico.class);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -3);
        Timestamp ts=new Timestamp(cal.getTimeInMillis());
        criteria.add(Restrictions.ge("fecha", ts));
        return criteria.list();
    }

    @Override
    public List<Historico> getHistoricoUltimoAno(Lanzadera l, Entablado e) {
        Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Historico.class);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -1);
        Timestamp ts=new Timestamp(cal.getTimeInMillis());
        criteria.add(Restrictions.ge("fecha", ts));
        return criteria.list();
    }

    @Override
    public List<Historico> getHistorio(Entablado e) {
        return sessionFactory.getCurrentSession().createCriteria(Historico.class).list();
    }

    @Override
    public List<Historico> getHistoricoUltimoMes(Entablado e) {
        Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Historico.class);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -3);
        Timestamp ts=new Timestamp(cal.getTimeInMillis());
        criteria.add(Restrictions.ge("fecha", ts));
        criteria.add(Restrictions.eq("entablado",e));
        return criteria.list();
    }

    @Override
    public List<Historico> getHistoricoUltimos3Meses(Entablado e) {
        Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Historico.class);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Timestamp ts=new Timestamp(cal.getTimeInMillis());
        criteria.add(Restrictions.ge("fecha", ts));
        criteria.add(Restrictions.eq("entablado",e));
        return criteria.list();
    }

    @Override
    public List<Historico> getHistoricoUltimoAno(Entablado e) {
        Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Historico.class);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -1);
        Timestamp ts=new Timestamp(cal.getTimeInMillis());
        criteria.add(Restrictions.ge("fecha", ts));
        criteria.add(Restrictions.eq("entablado",e));
        return criteria.list();
    }

    @Override
    public void addOrUpdateHistorico(Historico h) {
        sessionFactory.getCurrentSession().save(h);
    }
}
