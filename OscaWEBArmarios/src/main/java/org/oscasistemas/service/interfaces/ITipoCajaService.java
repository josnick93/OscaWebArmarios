package org.oscasistemas.service.interfaces;

import org.oscasistemas.model.TipoCaja;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
@Component
public interface ITipoCajaService {

    public List<TipoCaja> getCajas();
    public TipoCaja getTipoCaja(int id_caja);
    public boolean addTipoCaja(TipoCaja t);
    public boolean deleteTipoCaja(TipoCaja t);
}
