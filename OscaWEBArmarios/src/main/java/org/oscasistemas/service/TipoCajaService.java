package org.oscasistemas.service;

import org.oscasistemas.DAO.interfaces.ITipoCaja;
import org.oscasistemas.model.TipoCaja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
@Service("tipoCajaService")
@Transactional
public class TipoCajaService implements ITipoCaja{

    @Autowired
    private ITipoCaja cajaDAO;

    @Transactional
    @Override
    public List<TipoCaja> getCajas() {
        return cajaDAO.getCajas();
    }

    @Transactional
    @Override
    public TipoCaja getTipoCaja(int id_caja) {
        return cajaDAO.getTipoCaja(id_caja);
    }

    @Transactional
    @Override
    public boolean addTipoCaja(TipoCaja t) {
        return cajaDAO.addTipoCaja(t);
    }

    @Transactional
    @Override
    public boolean deleteTipoCaja(TipoCaja t) {
        return cajaDAO.deleteTipoCaja(t);
    }
}
