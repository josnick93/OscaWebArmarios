package org.oscasistemas.controller.Entrada.EntradaManual.EntradaNuevaUbicacion.Operaciones;

import com.dynamics.webServices.Item_Card_WS.ItemCardWS;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.DAO.interfaces.ITipoCaja;
import org.oscasistemas.controller.Entrada.EntradaManual.EntradaNuevaUbicacion.Operaciones.Utils.CrearUtils;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.CajaEntablado;
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
public class CrearUbicacion {

    @Autowired(required = true)
    private IEntablado entabladoService; //shelf query service

    @Autowired (required = true)
    private ITipoCaja tipoCajaService;  //box type service


    /**
     * Function that create a box in a shelf
     * @param request
     * @param entablado
     * @param fila
     * @param columna
     * @param articulo
     * @param cantidad
     * @param caja
     * @param origen
     * @param xCoord
     * @param yCoord
     * @return Ok if box could be created, error if cannot
     */
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/NuevaUbicacion", method = RequestMethod.GET)
    public @ResponseBody
    String crearUbicacion(HttpServletRequest request,
                          @NotNull @RequestParam(value = "entablado", required = true, defaultValue = "PLNZ.00.0000") String entablado,
                          @NotNull @RequestParam(value = "xPos", required = true, defaultValue = "-1") int fila,
                          @NotNull @RequestParam(value = "yPos", required = true, defaultValue = "-1") int columna,
                          @NotNull @RequestParam(value = "articulo", required = true) String articulo,
                          @NotNull @RequestParam(value = "cantidad", required = true, defaultValue = "-1") int cantidad,
                          @NotNull @RequestParam(value = "caja", required = true, defaultValue = "0.0") int caja,
                          @NotNull @RequestParam(value = "origen", required = true, defaultValue = "") String origen,
                          @NotNull @RequestParam(value = "xCoord", required = true, defaultValue = "0.0") double xCoord,
                          @NotNull @RequestParam(value = "yCoord", required = true, defaultValue = "0.0") double yCoord){

        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

        Entablado e = entabladoService.getEstanteria(entablado);
        ItemCardWS a = null;

        try {
            a = WebServicesInit.articulosService.read(articulo);
            WebServicesInit.functionsService.createMovement("OSCA", "SERWEB", "", articulo, "",
                    "", BigInteger.valueOf(cantidad), "UDS", origen, entablado);
            actualizarUbicacionFija(entablado,articulo);

        }catch(SOAPFaultException soapException){
            return "error:"+soapException.getMessage();
        }

        CajaEntablado l = new CajaEntablado();
        l.setColumna(columna);
        l.setFila(fila);
        l.setEntablado(e);
        l.setLanzadera(e.getLanzadera());
        l.setxPos(xCoord);
        l.setyPos(yCoord);
        l.setTipoCaja(tipoCajaService.getTipoCaja(caja));
        l.setArticulo(articulo);
        l.setCantidad(cantidad);
        //l.setPeso(l.getPeso() + (Integer.valueOf(a.getNetWeight().toString()) * cantidad));
        l.setPeso(0.0);
        l.setEsVacia((byte) -1);
        l.setFechaCreacion(new Date(Calendar.getInstance().getTimeInMillis()));
        l.setFechaActualizacion(new Date(Calendar.getInstance().getTimeInMillis()));
        l.setTs(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        //e.setPesoActual(e.getPesoActual()+(l.getArticulo().getPeso()*cantidad));
        //e.setHuecosLibres(e.getHuecosLibres()-l.getTipoCaja().getNum_huecos());
        //actualizar entablado
        entabladoService.addOrUpdateCajaEntablado(e);
        try {
            CrearUtils.crearUbicacion(l);
        } catch (SQLException e1) {
            return "error:"+e1.getMessage();
        }
        //añadir al historico
        Historico h = new Historico();
        h.setId_historico(1);
        h.setLanzadera(e.getLanzadera());
        h.setEntablado(e);
        h.setFila(fila);
        h.setColumna(columna);
        TipoMovimiento tm = new TipoMovimiento();
        tm.setId_tipoMovimiento(1);
        h.setTipoMovimiento(tm);
        h.setArticulo(a.getNo());
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
