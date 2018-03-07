package org.oscasistemas.controller.Operaciones.Creacion;

import com.sun.istack.internal.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.model.Lanzadera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Portátil1 on 26/12/2017.
 */
@RestController
public class CrearLanzadera {


    @Autowired
    private ILanzadera lanzaderaService;


    @Autowired
    private SessionFactory sessionFactory;


    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/CrearLanzadera", method = RequestMethod.GET)
    public @ResponseBody
    String crearLanzadera(HttpServletRequest request,
                          @NotNull @RequestParam(value = "alias", required = true, defaultValue = "") String alias,
                          @NotNull @RequestParam(value = "descripcion", required = true, defaultValue = "") String descripcion,
                          @NotNull @RequestParam(value = "direccionIp", required = true, defaultValue = "") String direccionIp,
                          @NotNull @RequestParam(value = "pesoMax", required = true, defaultValue = "250000.0") double pesoMax,
                          @NotNull @RequestParam(value = "pAcesso", required = true, defaultValue = "000") String pAcesso,
                          @NotNull @RequestParam(value = "nMaxEntablado", required = true, defaultValue = "50") int nMaxEntablados) throws Exception {
        JSONObject outputJsonObj = new JSONObject();
        Lanzadera l = new Lanzadera();
         /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        /*
        l.setAlias_lanzadera(alias);
        l.setDescripcion(descripcion);
        l.setDireccion_ip(direccionIp);
        l.setPunto_acesso(pAcesso);
        l.setPeso_max(pesoMax);
        l.setNum_entablados(nMaxEntablados);
        l.setNum_filas(8);
        l.setNum_columnas(16);
        */
        lanzaderaService.addOrUpdateLanzadera(l);
        l = lanzaderaService.getLanzaderaIp(direccionIp);
        //añadir Entablados

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        for (int i = 1; i <= nMaxEntablados; i++) {
            /*
            Entablado entablado=new Entablado();
            entablado.setLanzadera(l);
            entablado.setcodigo(i);
            entablado.setDescripcion("Entablado "+i);
            entablado.setPesoMaximo(400.000);
            entablado.setPesoActual(0.000);
            entablado.setHuecosLibres(512);
            session.save(entablado);
            if ( i % 20 == 0 ) { //20, same as the JDBC batch size
                //flush a batch of inserts and release memory:
                session.flush();
                session.clear();
            }
            */

        }
        tx.commit();
        session.close();
        outputJsonObj.put("res", "true");

        return outputJsonObj.toString();
    }

}
