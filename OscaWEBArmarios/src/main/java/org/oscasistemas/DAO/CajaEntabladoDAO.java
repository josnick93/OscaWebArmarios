package org.oscasistemas.DAO;

import com.dynamics.webServices.Item_Card_WS.ItemCardWS;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.model.Articulo;
import org.oscasistemas.model.CajaEntablado;
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
public class CajaEntabladoDAO implements ICajaEntablado{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CajaEntablado> getCajas() {
        return sessionFactory.getCurrentSession().createCriteria(CajaEntablado.class).list();
    }

    @Override
    public List<CajaEntablado> getCajasVacias() {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntablado.class);
        criteria.add(Restrictions.eq("Cantidad",0));
        return criteria.list();
    }

    @Override
    public List<CajaEntablado> getCajasVacias(Lanzadera l) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntablado.class);
        criteria.add(Restrictions.eq("Cantidad",0));
        criteria.add(Restrictions.eq("Lanzadera",l));
        return criteria.list();
    }

    @Override
    public List<CajaEntablado> getUbicacionesArticulo(Articulo a) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntablado.class);
        criteria.add(Restrictions.eq("Articulo",a));
        return criteria.list();
    }

    @Override
    public List<CajaEntablado> getUbicacionesArticulo(ItemCardWS a) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntablado.class);
        criteria.add(Restrictions.eq("Articulo",a.getNo()));
        return criteria.list();
    }

    @Override
    public List<CajaEntablado> getUbicacionesArticulo(Articulo a, Lanzadera l) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntablado.class);
        criteria.add(Restrictions.eq("Articulo",a));
        criteria.add(Restrictions.eq("Lanzadera",l));
        return criteria.list();
    }

    @Override
    public List<CajaEntablado> getUbicacionesArticulo(ItemCardWS a, Lanzadera l) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntablado.class);
        criteria.add(Restrictions.eq("Articulo",a.getNo()));
        criteria.add(Restrictions.eq("Lanzadera",l));
        return criteria.list();
    }

    @Override
    public List<CajaEntablado> getCajasLanzadera(Lanzadera l) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntablado.class);
        criteria.add(Restrictions.eq("Lanzadera",l));
        return criteria.list();
    }

    @Override
    public List<CajaEntablado> getCajasEntablado(Entablado entablado) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntablado.class);
        criteria.add(Restrictions.eq("entablado",entablado));
        return criteria.list();
    }

    @Override
    public CajaEntablado getCajasEntablado(Lanzadera l, Entablado e, int fila, int columna) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntablado.class);
        criteria.add(Restrictions.eq("Lanzadera",l));
        criteria.add(Restrictions.eq("entablado",e));
        criteria.add(Restrictions.eq("fila",fila));
        criteria.add(Restrictions.eq("columna",columna));
        return  (CajaEntablado) criteria.uniqueResult();
    }

    @Override
    public CajaEntablado getCajasEntablado(Entablado e, int fila, int columna) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(CajaEntablado.class);
        criteria.add(Restrictions.eq("entablado",e));
        criteria.add(Restrictions.eq("fila",fila));
        criteria.add(Restrictions.eq("columna",columna));
        return  (CajaEntablado) criteria.uniqueResult();
    }


    @Override
    public void addOrUpdateCajaEntablado(CajaEntablado c) {
        sessionFactory.getCurrentSession().saveOrUpdate(c);
    }

    @Override
    public void saveCajaEntablado(CajaEntablado c) {
        sessionFactory.getCurrentSession().save(c);
    }

    @Override
    public void removeCajaEntablado(CajaEntablado c) {
        sessionFactory.getCurrentSession().delete(c);
    }
}
