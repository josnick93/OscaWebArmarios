package org.oscasistemas.DAO.interfaces;

import org.oscasistemas.model.TipoCaja;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
public interface ITipoCaja {

    public List<TipoCaja> getCajas();
    public TipoCaja getTipoCaja(int id_caja);
    public boolean addTipoCaja(TipoCaja t);
    public boolean deleteTipoCaja(TipoCaja t);
}
