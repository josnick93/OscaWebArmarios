package org.oscasistemas.service.interfaces;

import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.Historico;
import org.oscasistemas.model.Lanzadera;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 11/07/2017.
 */
@Component
public interface IHistoricoService {

    public List<Historico> getHistorio(Lanzadera l, Entablado e);
    public List<Historico> getHistoricoUltimoMes(Lanzadera l,Entablado e);
    public List<Historico> getHistoricoUltimos3Meses(Lanzadera l,Entablado e);
    public List<Historico> getHistoricoUltimoAno(Lanzadera l,Entablado e);
    public void addOrUpdateHistorico(Historico h);
}
