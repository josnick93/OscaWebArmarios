package org.oscasistemas.controller.Operaciones.Editar;

import com.dynamics.webServices.Bin_Content_WS.BinContentWS;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFields;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFilter;
import com.sun.istack.internal.NotNull;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Holder;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 26/12/2017.
 */
@RestController
public class RegularizarCajaMedida {


    @Autowired(required = true)
    private IEntablado entabladoService;
    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;

    @Autowired
    private ILanzadera lanzaderaService;

    private static final Logger logger = Logger.getLogger(RegularizarCajaMedida.class);


    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value = "Operacion/regularizarCajaMedida", method = RequestMethod.GET)
    public @ResponseBody
    String regularizarMaterialMedida(HttpServletRequest request,
                                     @NotNull @RequestParam(value = "lanzadera", required = true, defaultValue = "-1") int lanzadera,
                                     @NotNull @RequestParam(value = "entablado", required = true, defaultValue = "PLNZ.00.0001") String entablado,
                                     @NotNull @RequestParam(value = "xPos", required = true, defaultValue = "-1") int xPos,
                                     @NotNull @RequestParam(value = "yPos", required = true, defaultValue = "-1") int yPos,
                                     @NotNull @RequestParam(value = "cantidad", required = true) int cantidad) throws Exception {
        Lanzadera l = lanzaderaService.getLanzadera(lanzadera);
        //Entablado e=entabladoService.getEstanteria(l,entablado);
        Entablado e = null;
        logger.debug("------------------Regularizar caja medida--------------------------------");
        CajaEntabladoMedida c = cajaEntabladoMedidaService.getCajasEntablado(l, e, xPos, yPos);
        logger.debug("Caja antes actualizar "+c.toString());
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

        try{
            actualizarCantidadNav(entablado,c.getArticulo(),cantidad);
        }catch (Exception e1){
            logger.debug("Error "+e1.getMessage());
            JSONObject outputJsonObj = new JSONObject();
            return outputJsonObj.put("res", e1.getMessage()).toString();
        }

        /*
        if(c.getCantidad()<cantidad)
            e.setPesoActual(e.getPesoActual()+(c.getArticulo().getPeso()*(cantidad-c.getCantidad())));
        else
            e.setPesoActual(e.getPesoActual()-(c.getArticulo().getPeso()*(c.getCantidad()-cantidad)));
            */
        //actualizar entablado
        entabladoService.addOrUpdateCajaEntablado(e);
        c.setCantidad(cantidad);
        if(c.getCantidad()==0.0)
            c.setEsVacia((byte)1);
        else if(c.getCantidad()>0.0)
            c.setEsVacia((byte)-1);
        actualizarCantidad(c);
        logger.debug("Despues: "+c.toString());


        //añadir al historico
        Historico h=new Historico();
        h.setArticulo(c.getArticulo());
        h.setId_historico(1);
        h.setLanzadera(l);
        h.setEntablado(e);
        h.setFila(yPos);
        h.setColumna(xPos);
        TipoMovimiento tm=new TipoMovimiento();
        tm.setId_tipoMovimiento(3);
        h.setTipoMovimiento(tm);
        h.setArticulo(c.getArticulo());
        h.setCantidad(c.getCantidad());
        crearHistorio(h);
        logger.debug("Historico creado: "+h.toString());



        JSONObject outputJsonObj = new JSONObject();
        outputJsonObj.put("res", "true");
        return outputJsonObj.toString();
    }

    private void actualizarCantidad(CajaEntabladoMedida ubicacion) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.2.2:3306/osca_localizacion", "osca", "osca");
            String insertTableSQL = "UPDATE cajas_entablado_medida SET Cantidad=? , esVacia=? WHERE Codigo=? AND fila=? AND columna=?";
            preparedStatement = conn.prepareStatement(insertTableSQL);
            preparedStatement.setDouble(1, ubicacion.getCantidad());
            preparedStatement.setDouble(2, ubicacion.getEsVacia());
            preparedStatement.setString(3, ubicacion.getEntablado().getCodigo());
            preparedStatement.setInt(4, ubicacion.getFila());
            preparedStatement.setDouble(5, ubicacion.getColumna());
            preparedStatement.executeUpdate();
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

    private void actualizarCantidadNav(String entablado,String articulo,int cantidad) throws  Exception{
        logger.debug("Actualizando cantidad en nav");
        //actualizar en NAV
        List<BinContentWSFilter> filtros = new ArrayList<BinContentWSFilter>();
        BinContentWSFilter f1 = new BinContentWSFilter();
        f1.setField(BinContentWSFields.LOCATION_CODE);
        f1.setCriteria("OSCA");
        filtros.add(f1);
        BinContentWSFilter f2 = new BinContentWSFilter();
        f2.setField(BinContentWSFields.BIN_CODE);
        f2.setCriteria(entablado);
        filtros.add(f2);
        BinContentWSFilter f3 = new BinContentWSFilter();
        f3.setField(BinContentWSFields.ITEM_NO);
        f3.setCriteria(articulo);
        filtros.add(f3);
        BinContentWS myBinContentWS = WebServicesInit.contenidoUbicacionService.readMultiple(filtros, "", 0).getBinContentWS().get(0);
        logger.debug("Antes: "+myBinContentWS.toString());
        if(cantidad<myBinContentWS.getQuantity().intValue()){
            myBinContentWS.setQuantity(BigInteger.valueOf(myBinContentWS.getQuantity().intValue()-cantidad));
        }else if(cantidad>myBinContentWS.getQuantity().intValue()){
            myBinContentWS.setQuantity(BigInteger.valueOf(myBinContentWS.getQuantity().intValue()+cantidad));
        }
        WebServicesInit.contenidoUbicacionService.update(new Holder<BinContentWS>(myBinContentWS));
        logger.debug("Despues: "+myBinContentWS.toString());

    }

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
