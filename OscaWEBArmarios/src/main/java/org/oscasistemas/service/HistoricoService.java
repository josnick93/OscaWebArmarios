package org.oscasistemas.service;

import org.oscasistemas.DAO.interfaces.IHistorico;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.Historico;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.service.interfaces.IHistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 11/07/2017.
 */
@Service("historicoService")
@Transactional
public class HistoricoService implements IHistoricoService {

    @Autowired
    private IHistorico historicoDAO;


    @Transactional
    @Override
    public List<Historico> getHistorio(Lanzadera l, Entablado e) {
        return historicoDAO.getHistorio(l,e);
    }

    @Transactional
    @Override
    public List<Historico> getHistoricoUltimoMes(Lanzadera l, Entablado e) {
        return historicoDAO.getHistoricoUltimoMes(l,e);
    }

    @Transactional
    @Override
    public List<Historico> getHistoricoUltimos3Meses(Lanzadera l, Entablado e) {
        return historicoDAO.getHistoricoUltimos3Meses(l,e);
    }

    @Transactional
    @Override
    public List<Historico> getHistoricoUltimoAno(Lanzadera l, Entablado e) {
        return historicoDAO.getHistoricoUltimoAno(l,e);
    }

    @Transactional
    @Override
    public void addOrUpdateHistorico(Historico h) {
        historicoDAO.addOrUpdateHistorico(h);
    }
}
