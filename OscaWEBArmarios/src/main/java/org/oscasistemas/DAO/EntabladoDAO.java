package org.oscasistemas.DAO;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.model.Articulo;
import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.Lanzadera;
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
public class EntabladoDAO implements IEntablado {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(EntabladoDAO.class);


    @Override
    public List<Entablado> getEstanterias() {
        return sessionFactory.getCurrentSession().createCriteria(Entablado.class).list();
    }

    @Override
    public Entablado getEstanteria(String codigo) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Entablado.class);
       criteria.add(Restrictions.eq("codigo", codigo));
        return (Entablado) criteria.uniqueResult();
    }

    @Override
    public List<Entablado> getEstanterias(Lanzadera lanzadera, int entablado) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Entablado.class);
        String codigo = "PLNZ";
        if (lanzadera!=null) {
            codigo = codigo + "." + String.format("%02d", lanzadera.getId_lanzadera());
            if (entablado != -1) {
                codigo = codigo + "." + String.format("%04d", entablado);
            } else codigo = codigo + ".*";
        } else
        /*
        if (!descripcion.equals("")) {
            BinWSFilter f2 = new BinWSFilter();
            f2.setField(BinWSFields.DESCRIPTION);
            f2.setCriteria("*" + descripcion + "*");
            filtros.add(f2);
        }
        */
        if(!codigo.equals("PLNZ"))  criteria.add(Restrictions.eq("codigo", entablado));
        //if(descripcion!="")  criteria.add(Restrictions.like("descripcion" , "%"+descripcion+"%"));
        return criteria.list();
    }

    @Override
    public List<Entablado> getEstanteriasNoSuperanPeso(Lanzadera lanzadera, double peso,TipoCaja c) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Entablado.class);

        criteria.add(Restrictions.eq("Lanzadera", lanzadera))
                //.add(Restrictions.ge("PesoRestante", peso))
                //.add(Restrictions.ge("HuecosLibres",c.getNum_huecos()))
                //.add(Restrictions.ne("HuecosLibres",512))
          .addOrder(Order.desc("HuecosLibres"));
        List<Entablado> l=criteria.list();

        //listar vacias
        criteria = sessionFactory.getCurrentSession().createCriteria(Entablado.class);
        criteria.add(Restrictions.eq("Lanzadera", lanzadera))
                .add(Restrictions.ge("PesoRestante", peso))
                //.add(Restrictions.eq("HuecosLibres",512))
                //.addOrder(Order.asc("codigo"))
        ;
        l.addAll(criteria.list());
        //"codigo",
        return l;


        //return criteria.list();
    }

    @Override
    public List<Entablado> getEstanteriasNoSuperanPesoMedida(Lanzadera lanzadera, double peso, int nfilas, int ncolumnas) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Entablado.class);

        criteria.add(Restrictions.eq("Lanzadera", lanzadera))
               // .add(Restrictions.ge("PesoRestante", peso))
               // .add(Restrictions.ge("HuecosLibres",nfilas*ncolumnas))
               // .add(Restrictions.ne("HuecosLibres",512))
               .addOrder(Order.desc("HuecosLibres"));
        List<Entablado> l=criteria.list();

        //listar vacias
        criteria = sessionFactory.getCurrentSession().createCriteria(Entablado.class);
        criteria.add(Restrictions.eq("Lanzadera", lanzadera))
                .add(Restrictions.ge("PesoRestante", peso))
                .add(Restrictions.eq("HuecosLibres",512))
                .addOrder(Order.asc("codigo"));
        l.addAll(criteria.list());
        //"codigo",
        return l;
    }


    @Override
    public void addOrUpdateCajaEntablado(Entablado c) {
        sessionFactory.getCurrentSession().saveOrUpdate(c);
    }

    @Override
    public void removeCajaEntablado(Entablado c) {
        sessionFactory.getCurrentSession().delete(c);
    }


    /*
    @Override
    public List<Entablado> getEstanteriasNoSuperanPeso(Lanzadera lanzadera, double peso, TipoCaja caja) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Entablado.class);
        criteria.add(Restrictions.eq("lanzadera", lanzadera));
        criteria.add(Restrictions.ge("PesoRestante",peso));
        criteria.addOrder(Order.asc("HuecosLibres"));
        return criteria.list();
    }
    */

    @Override
    public List<Entablado> getEstanteriasNoSuperanPesoRakingArticulo(Lanzadera lanzadera, Articulo a, double peso) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Entablado.class);
        /*
        criteria.add(Restrictions.eq("lanzadera", lanzadera))
        .add(Restrictions.ge("PesoRestante", peso))
            .add(Restrictions.ne("HuecosLibres",512));
        List<Entablado> l=criteria.list();

        //listar vacias
        criteria = sessionFactory.getCurrentSession().createCriteria(Entablado.class);
        criteria.add(Restrictions.eq("lanzadera", lanzadera))
                .add(Restrictions.ge("PesoRestante", peso))
                .add(Restrictions.eq("HuecosLibres",512))
        .addOrder(Order.asc("codigo"));
        l.addAll(criteria.list());
        //"codigo",
        */
        return criteria.list();
    }
}
