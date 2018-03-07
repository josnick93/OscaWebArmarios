package org.oscasistemas.controller.Entrada.EntradaManual.EntradaNuevaUbicacion.Operaciones;

import com.dynamics.webServices.Item_Card_WS.ItemCardWS;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.controller.Entrada.EntradaManual.EntradaNuevaUbicacion.Operaciones.Utils.CrearUtils;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.CajaEntabladoMedida;
import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.Historico;
import org.oscasistemas.model.TipoMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.SOAPFaultException;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import static org.oscasistemas.controller.Entrada.EntradaManual.EntradaNuevaUbicacion.Operaciones.Utils.CrearUtils.actualizarUbicacionFija;
import static org.oscasistemas.controller.Entrada.EntradaManual.EntradaNuevaUbicacion.Operaciones.Utils.CrearUtils.crearHistorio;

/**
 * Created by José Ángel Caudevílla Casaús on 26/12/2017.
 */
@RestController
public class CrearUbicacionMedida {

    @Autowired(required = true)
    private IEntablado entabladoService; //shelf query service


    /**
     * Function that create a custom box in a shelf
     * @param request
     * @param entablado
     * @param xPos
     * @param yPos
     * @param articulo
     * @param cantidad
     * @param origen
     * @param xCoord
     * @param yCoord
     * @param nfilas
     * @param ncolumnas
     * @return
     */
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/CrearUbicacionMedida", method = RequestMethod.GET)
    public @ResponseBody
    String crearUbicacionMedida(HttpServletRequest request,
                                @NotNull @RequestParam(value = "entablado", required = true, defaultValue = "PLNZ.00.0000") String entablado,
                                @NotNull @RequestParam(value = "xPos", required = true, defaultValue = "-1") int xPos,
                                @NotNull @RequestParam(value = "yPos", required = true, defaultValue = "-1") int yPos,
                                @NotNull @RequestParam(value = "articulo", required = true) String articulo,
                                @NotNull @RequestParam(value = "cantidad", required = true, defaultValue = "-1") int cantidad,
                                @NotNull @RequestParam(value = "origen", required = true) String origen,
                                @NotNull @RequestParam(value = "xCoord", required = true, defaultValue = "13") double xCoord,
                                @NotNull @RequestParam(value = "yCoord", required = true, defaultValue = "13") double yCoord,
                                @NotNull @RequestParam(value = "nfilas", required = true, defaultValue = "0") int nfilas,
                                @NotNull @RequestParam(value = "ncolumnas", required = true, defaultValue = "0") int ncolumnas){
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        //crear movimiento en NAV
        ItemCardWS a = null;
        try {
            a = WebServicesInit.articulosService.read(articulo);
            WebServicesInit.functionsService.createMovement("OSCA", "SERWEB", "", articulo, "",
                    "", BigInteger.valueOf(cantidad), "UDS", origen, entablado);
            //Poner ubicacion fija
            actualizarUbicacionFija(entablado,articulo);
        }catch(SOAPFaultException soapException){
            return "error:"+soapException.toString();
        }

        Entablado e=entabladoService.getEstanteria(entablado);

        //introducir posicion en la BD

            CajaEntabladoMedida l= new CajaEntabladoMedida();
            l.setEntablado(e);
            l.setLanzadera(e.getLanzadera());
            l.setFila(xPos);
            l.setColumna(yPos);
            l.setxPos(xCoord);
            l.setyPos(yCoord);
            l.setNfilas(nfilas);
            l.setNcolumnas(ncolumnas);
            l.setArticulo(a.getNo());
            l.setCantidad(cantidad);
            l.setPeso(0.0);
            l.setEsVacia((byte)-1);
            l.setFechaCreacion(new Date(Calendar.getInstance().getTimeInMillis()));
            l.setFechaActualizacion(new Date(Calendar.getInstance().getTimeInMillis()));
            l.setTs(new Timestamp(Calendar.getInstance().getTimeInMillis()));
            //e.setPesoActual(e.getPesoActual()+(l.getArticulo().getPeso()*cantidad));
            e.setHuecosLibres(e.getHuecosLibres()+(l.getNfilas()*l.getNcolumnas()));
            //actualizar entablado
            entabladoService.addOrUpdateCajaEntablado(e);
        try {
            CrearUtils.crearUbicacion(l);
        } catch (SQLException e1) {
            return "error:"+e1.getMessage();
        }

        //add historic
            Historico h=new Historico();
            h.setId_historico(1);
            h.setLanzadera(e.getLanzadera());
            h.setEntablado(e);
            h.setFila(yPos);
            h.setColumna(xPos);
            TipoMovimiento tm=new TipoMovimiento();
            tm.setId_tipoMovimiento(1);
            h.setTipoMovimiento(tm);
            h.setArticulo(articulo);
            h.setCantidad(cantidad);
        try {
            crearHistorio(h);
        } catch (SQLException e1) {
            return "error:"+e1.getMessage();
        }

        //response json
        return new Gson().toJson("OK");
    }

}
