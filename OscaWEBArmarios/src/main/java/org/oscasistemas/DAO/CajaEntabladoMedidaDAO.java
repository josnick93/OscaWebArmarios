package org.oscasistemas.DAO;

import com.dynamics.webServices.Item_Card_WS.ItemCardWS;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
@Transactional
@Repository
public class CajaEntabladoMedidaDAO implements ICajaEntabladoMedida {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(CajaEntabladoMedidaDAO.class);


    @Override
    public List<CajaEntabladoMedida> getCajas() {
        return sessionFactory.getCurrentSession().createCriteria(CajaEntabladoMedida.class).list();
    }

    @Override
    public List<CajaEntabladoMedida> getCajasVacias() {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntabladoMedida.class);
        criteria.add(Restrictions.eq("Cantidad",0));
        return criteria.list();
    }

    @Override
    public List<CajaEntabladoMedida> getUbicacionesArticulo(Articulo a) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntabladoMedida.class);
        criteria.add(Restrictions.eq("Articulo",a));
        return criteria.list();
    }

    @Override
    public List<CajaEntabladoMedida> getUbicacionesArticulo(ItemCardWS a) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntabladoMedida.class);
        criteria.add(Restrictions.eq("Articulo",a.getNo()));
        return criteria.list();
    }

    @Override
    public List<CajaEntabladoMedida> getUbicacionesArticulo(Articulo a, Lanzadera l) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntabladoMedida.class);
        criteria.add(Restrictions.eq("Articulo",a));
        criteria.add(Restrictions.eq("Lanzadera",l));
        return criteria.list();
    }

    @Override
    public List<CajaEntabladoMedida> getUbicacionesArticulo(ItemCardWS a, Lanzadera l) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntabladoMedida.class);
        criteria.add(Restrictions.eq("Articulo",a.getNo()));
        criteria.add(Restrictions.eq("Lanzadera",l));
        return criteria.list();
    }

    @Override
    public List<CajaEntabladoMedida> getCajasLanzadera(Lanzadera l) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntabladoMedida.class);
        criteria.add(Restrictions.eq("Lanzadera",l));
        return criteria.list();
    }

    @Override
    public List<CajaEntabladoMedida> getCajasEntablado(Entablado entablado) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntabladoMedida.class);
        criteria.add(Restrictions.eq("entablado",entablado));
        return criteria.list();
    }

    @Override
    public CajaEntabladoMedida getCajasEntablado(Lanzadera l, Entablado e, int fila, int columna) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntabladoMedida.class);
        criteria.add(Restrictions.eq("Lanzadera",l));
        criteria.add(Restrictions.eq("entablado",e));
        criteria.add(Restrictions.eq("fila",fila));
        criteria.add(Restrictions.eq("columna",columna));
        return  (CajaEntabladoMedida) criteria.uniqueResult();
    }

    @Override
    public CajaEntabladoMedida getCajasEntablado(Entablado e, int fila, int columna) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntabladoMedida.class);
        criteria.add(Restrictions.eq("entablado",e));
        criteria.add(Restrictions.eq("fila",fila));
        criteria.add(Restrictions.eq("columna",columna));
        return  (CajaEntabladoMedida) criteria.uniqueResult();
    }

    @Override
    public void addOrUpdateCajaEntablado(CajaEntabladoMedida c) {
        sessionFactory.getCurrentSession().saveOrUpdate(c);
    }

    @Override
    public void removeCajaEntablado(CajaEntabladoMedida c) {
        sessionFactory.getCurrentSession().delete(c);
    }
}
