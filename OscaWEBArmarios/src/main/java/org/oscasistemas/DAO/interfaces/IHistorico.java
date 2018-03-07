package org.oscasistemas.DAO.interfaces;

import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.Historico;
import org.oscasistemas.model.Lanzadera;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 11/07/2017.
 */
public interface IHistorico {

    public List<Historico> getHistorio(Lanzadera l, Entablado e);
    public List<Historico> getHistoricoUltimoMes(Lanzadera l,Entablado e);
    public List<Historico> getHistoricoUltimos3Meses(Lanzadera l,Entablado e);
    public List<Historico> getHistoricoUltimoAno(Lanzadera l,Entablado e);
    public List<Historico> getHistorio(Entablado e);
    public List<Historico> getHistoricoUltimoMes(Entablado e);
    public List<Historico> getHistoricoUltimos3Meses(Entablado e);
    public List<Historico> getHistoricoUltimoAno(Entablado e);
    public void addOrUpdateHistorico(Historico h);

}
