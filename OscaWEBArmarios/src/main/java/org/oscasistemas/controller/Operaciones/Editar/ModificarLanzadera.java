package org.oscasistemas.controller.Operaciones.Editar;

import com.sun.istack.internal.NotNull;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.model.Lanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by José Ángel Caudevílla Casaús on 26/12/2017.
 */
@RestController
public class ModificarLanzadera {

    @Autowired
    private ILanzadera lanzaderaService;


    @RequestMapping(value = "Operacion/ModificarLanzadera", method = RequestMethod.GET)
    public @ResponseBody
    String modificarLanzadera(HttpServletRequest request,
                              @NotNull @RequestParam(value = "idLanzadera", required = true, defaultValue = "-1") int id_lanzadera,
                              @NotNull @RequestParam(value = "alias", required = true, defaultValue = "") String alias,
                              @NotNull @RequestParam(value = "descripcion", required = true, defaultValue = "") String descripcion,
                              @NotNull @RequestParam(value = "direccionIp", required = true, defaultValue = "") String direccionIp,
                              @NotNull @RequestParam(value = "pesoMax", required = true, defaultValue = "0.0") double pesoMax,
                              @NotNull @RequestParam(value = "pAcesso", required = true, defaultValue = "000") String pAcesso,
                              @NotNull @RequestParam(value = "nMaxEntablado", required = true, defaultValue = "-1") int nMaxEntablados) throws Exception {
        JSONObject outputJsonObj = new JSONObject();
        Lanzadera l = lanzaderaService.getLanzadera(id_lanzadera);
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        /*
        if(!alias.equals("")) l.setAlias_lanzadera(alias);
        if(!descripcion.equals("")) l.setDescripcion(descripcion);
        if(!direccionIp.equals("")) l.setDireccion_ip(direccionIp);
        if(pesoMax!=0.0) l.setPeso_max(pesoMax);
        if(!pAcesso.equals("000")) l.setPunto_acesso(pAcesso);
        //crear o remover entablados
        if(nMaxEntablados!=-1) {
            if (l.getNum_entablados() > nMaxEntablados) {
                //borrar entablados
                Session session = sessionFactory.openSession();
                Transaction tx = session.beginTransaction();
                for(int i=nMaxEntablados;i<=l.getNum_entablados();i++){
                    session.delete(entabladoService.getEstanteria(l,i));
                    if ( i % 10 == 0 ) { //20, same as the JDBC batch size
                        //flush a batch of inserts and release memory:
                        session.flush();
                        session.clear();
                    }
                }
                session.flush();
                tx.commit();
                l.setNum_entablados(nMaxEntablados);
            }
            else if (l.getNum_entablados() < nMaxEntablados) {
                //añadir entablados
                Session session = sessionFactory.openSession();
                Transaction tx = session.beginTransaction();
                for(int i=l.getNum_entablados();i<=nMaxEntablados;i++){
                    Entablado e=new Entablado();
                    e.setLanzadera(l);
                    e.setcodigo(i);
                    e.setDescripcion("Entablado "+i);
                    e.setPesoMaximo(400.00);
                    e.setPesoActual(0.00);
                    e.setHuecosLibres(512);
                    session.save(e);
                    if ( i % 10 == 0 ) { //20, same as the JDBC batch size
                        //flush a batch of inserts and release memory:
                        session.flush();
                        session.clear();
                    }
                }
                session.flush();
                tx.commit();
                l.setNum_entablados(nMaxEntablados);
            }
        }
        */
        lanzaderaService.addOrUpdateLanzadera(l);
        outputJsonObj.put("res", "true");
        return outputJsonObj.toString();
    }
}
