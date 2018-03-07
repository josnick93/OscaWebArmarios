package org.oscasistemas.DAO;


import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.oscasistemas.DAO.interfaces.IArticuloDAO;
import org.oscasistemas.model.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Repository
public class ArticuloDAO implements IArticuloDAO {


    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(ArticuloDAO.class);

    @Override
    public List<Articulo> getArticulos() {
        return sessionFactory.getCurrentSession().createCriteria(Articulo.class).list();
    }

    @Override
    public Articulo getArticulo(String code) {
        return (Articulo) sessionFactory.getCurrentSession().get(Articulo.class,code);
    }

    @Override
    public List<Articulo> getArticulos(String codigo, String alias, String descripcion) {
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(Articulo.class);
        if(!codigo.equals(""))  criteria.add(Restrictions.like("No","%"+codigo+"%"));
        if(!alias.equals(""))  criteria.add(Restrictions.like("searchDescription","%"+alias+"%"));
        if(!descripcion.equals("")){
            criteria.add(Restrictions.like("Descripcion","%"+descripcion+"%"));
            criteria.add(Restrictions.like("Descripcion2","%"+descripcion+"%"));
        }
        if(codigo.equals("") && alias.equals("") && descripcion.equals("")) criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
        return criteria.setMaxResults(100).list();
    }
}
