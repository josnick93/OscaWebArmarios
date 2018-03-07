package org.oscasistemas.controller.Salida.SalidaManual.Operaciones;

import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.DAO.interfaces.IEntablado;
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
import java.sql.*;

/**
 * Created by José Ángel Caudevílla Casaús on 26/12/2017.
 */
@RestController
public class DescontarMaterialMedida {

    @Autowired(required = true)
    private IEntablado entabladoService; //shelf service

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;//custom box service


    /**
     * Discount material of a custom box in a shelf
     * @param request
     * @param entablado
     * @param articulo
     * @param fila
     * @param columna
     * @param cantidad
     * @param destino
     * @return
     * @throws Exception
     */
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/dropCustomMaterial", method = RequestMethod.GET)
    public @ResponseBody
    String descontarCantidadMedida(HttpServletRequest request,
                           @NotNull @RequestParam(value = "entablado", required = true, defaultValue = "00.000.0090") String entablado,
                           @NotNull @RequestParam(value = "articulo", required = true, defaultValue = "00.000.0090") String articulo,
                           @NotNull @RequestParam(value = "fila", required = true, defaultValue = "-1") int fila,
                           @NotNull @RequestParam(value = "columna", required = true, defaultValue = "-1") int columna,
                           @NotNull @RequestParam(value = "cantidad", required = true, defaultValue = "-1") int cantidad,
                           @NotNull @RequestParam(value = "destino", required = true, defaultValue = "") String destino) throws Exception {
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        try {
            //WEB SERVICE MOVEMENT FUNCTION
            WebServicesInit.functionsService.createMovement("OSCA", "SERWEB", "", articulo, "",
                    "", BigInteger.valueOf(cantidad), "UDS", entablado, destino);
        }catch(SOAPFaultException e){
            e.printStackTrace();
            return "error:"+e.getMessage();
        }

        Entablado e = entabladoService.getEstanteria(entablado);

        CajaEntabladoMedida c1 = cajaEntabladoMedidaService.getCajasEntablado(e, fila, columna);
        //e.setPesoActual(e.getPesoActual()-(c1.getArticulo().getPeso()*cantidad));
        if (c1.getCantidad() - cantidad == 0)
            c1.setEsVacia((byte) -1);
        c1.setCantidad(c1.getCantidad() - cantidad);
        //c1.setPeso(c1.getPeso()- (c1.getArticulo().getPeso()*cantidad));
        //actualizarCantidad(c1);
        cajaEntabladoMedidaService.addOrUpdateCajaEntablado(c1);
        //añadir al historico
        Historico h = new Historico();
        h.setId_historico(1);
        h.setLanzadera(e.getLanzadera());
        h.setEntablado(e);
        h.setFila(columna);
        h.setColumna(fila);
        TipoMovimiento tm = new TipoMovimiento();
        tm.setId_tipoMovimiento(2);
        h.setTipoMovimiento(tm);
        h.setArticulo(c1.getArticulo());
        h.setCantidad(cantidad);
        crearHistorio(h);

        entabladoService.addOrUpdateCajaEntablado(e);

        return new Gson().toJson("OK");
    }

    /**
     *  Create hitoric regist
     * @param h
     * @throws SQLException
     */
    private void crearHistorio(Historico h) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.2.2:3306/osca_localizacion", "osca", "osca");
            String insertTableSQL = "INSERT INTO historico"
                    + "(Id_lanzadera, Codigo,Id_tipoMovimiento,usuario, fila, columna,Articulo,Cantidad,fecha) VALUES"
                    + "(?,?,?,?,?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, h.getLanzadera().getId_lanzadera());
            preparedStatement.setString(2, h.getEntablado().getCodigo());
            preparedStatement.setInt(3, h.getTipoMovimiento().getId_tipoMovimiento());
            preparedStatement.setString(4, h.getUsuario());
            preparedStatement.setInt(5, h.getFila());
            preparedStatement.setInt(6, h.getColumna());
            preparedStatement.setString(7, h.getArticulo());
            preparedStatement.setDouble(8, h.getCantidad());
            preparedStatement.setTimestamp(9, h.getFecha());
            preparedStatement.execute("SET foreign_key_checks = 0;");
            preparedStatement.executeUpdate();
            preparedStatement.execute("SET foreign_key_checks = 1;");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

}
