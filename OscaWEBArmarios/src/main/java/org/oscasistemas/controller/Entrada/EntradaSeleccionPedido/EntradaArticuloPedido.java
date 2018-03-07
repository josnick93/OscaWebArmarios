package org.oscasistemas.controller.Entrada.EntradaSeleccionPedido;

import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWS;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSFields;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSFilter;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSList;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.ICajaEntablado;
import org.oscasistemas.DAO.interfaces.ICajaEntabladoMedida;
import org.oscasistemas.DAO.interfaces.IEntablado;
import org.oscasistemas.DAO.interfaces.ILanzadera;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.service.interfaces.IPedidoEntradaService;
import org.oscasistemas.util.WebBrowserOpener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Portátil1 on 21/12/2017.
 */
@RestController
public class EntradaArticuloPedido {


    @Autowired
    private ILanzadera lanzaderaService;

    @Autowired
    private IPedidoEntradaService pedidoentradaService;

    @Autowired (required = true)
    private IEntablado entabladoService;

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;

    @Autowired
    private ICajaEntablado locationService;


    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value="/EntradaArticuloPedido" ,method= {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ModelAndView entradaSeleccionTipoCajaPedidoPage(HttpServletRequest request,
                                                           @NotNull @RequestParam(value = "pedido" ,required = true) String pedido,
                                                           @NotNull @RequestParam(value = "Nlinea" ,required = true, defaultValue = "EMPTY") String Nlinea,
                                                           @NotNull @RequestParam(value = "cerrar" ,required = true, defaultValue = "0") String cerrar) {
        /*
         * Dir ip peticion
         */

        ModelAndView m=null;
        String requestLift="";
        Lanzadera l=null;
        boolean pedidoLanzadera=false; //tengo alguna linea en mi lanzadera
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        l=lanzaderaService.getLanzaderaIp(remoteAddr);

        if(l!=null){
            m=new ModelAndView("EntradaArticuloPedido");
            //lanzadera encargada lanzar pedido
            if(Nlinea.equals("EMPTY")) {

                //obtener lineas de pedido sin marcar
                for(WarehouseActivityLineWS Lpedido:
                        getpedidoEntradaSinMarcar(pedido).getWarehouseActivityLineWS()) {

                    Entablado e = entabladoService.getEstanteria(Lpedido.getBinCode());
                    //si soy mi lanzadera cargo la pagina como poseedor
                    if (e.getLanzadera().getDireccion_ip().equals(remoteAddr)) {
                        m.getModelMap().addAttribute("entablado", e);
                        m.getModelMap().addAttribute("entabladoN", Lpedido.getBinCode());
                        m.getModelMap().addAttribute("articuloPedido", Lpedido);
                        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(e));
                        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(e));
                        m.getModelMap().addAttribute("cantidad", Lpedido.getQtyOutstanding());
                        m.getModelMap().addAttribute("lanzadera", l);
                        m.getModelMap().addAttribute("cerrar", cerrar);
                        pedidoLanzadera = true;
                    }
                    //consultar si la lanzadera esta libre
                    else if ((requestLift = peticionLanzadera("http://" + e.getLanzadera().getDireccion_ip()
                            + ":8080/ServidorArmarios/JSONServlet", "orden=Acceder")) != null && requestLift.contains("OK")) {
                        //enviar linea de pedido a la lanzadera
                        new WebBrowserOpener(new String[]{e.getLanzadera().getDireccion_ip(),
                                "/OscaArmarios/EntradaArticuloPedido.html?pedido=" + Lpedido.getNo()
                                        + "&Nlinea=" + Lpedido.getLineNo() + "&cerrar=1"}).run();
                    }
                }
            }
            //ordenador remoto
            else{
                //obtener linea pedido de mi lanzadera
                WarehouseActivityLineWS lineaPedido = getLineaPedido(pedido,Integer.valueOf(Nlinea));
                Entablado e=entabladoService.getEstanteria(lineaPedido.getBinCode());
                m.getModelMap().addAttribute("entablado", e);
                m.getModelMap().addAttribute("entabladoN", lineaPedido.getBinCode());
                m.getModelMap().addAttribute("articuloPedido", lineaPedido);
                m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(e));
                m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(e));
                m.getModelMap().addAttribute("articuloPedido", lineaPedido);
                m.getModelMap().addAttribute("cantidad", lineaPedido.getQtyOutstanding());
                m.getModelMap().addAttribute("lanzadera", l);
                m.getModelMap().addAttribute("cerrar",cerrar);
                pedidoLanzadera=true;
            }
            m.getModelMap().addAttribute("tengoLineaPedido", pedidoLanzadera);
            m.getModelMap().addAttribute("cerrar", cerrar);
            return m;
        }
        //ordenador distribuir Tareas
        else{
            m=new ModelAndView("Home");
            //obtener lineas de pedido sin marcar
            for(WarehouseActivityLineWS Lpedido:getpedidoEntradaSinMarcar(pedido).getWarehouseActivityLineWS()){
                Entablado e=entabladoService.getEstanteria(Lpedido.getBinCode());
                //consultar si la lanzadera esta libre
                if((requestLift=peticionLanzadera("http://"+e.getLanzadera().getDireccion_ip()
                        +":8080/ServidorArmarios/JSONServlet","orden=Acceder"))!=null && requestLift.contains("OK")){
                    new WebBrowserOpener(new String[]{e.getLanzadera().getDireccion_ip() ,
                            "/OscaArmarios/EntradaArticuloPedido.html?pedido="+Lpedido.getNo()
                                    +"&Nlinea="+Lpedido.getLineNo()+"&cerrar=1"}).run();
                }
            }
            return m;
        }
    }

    /**
     * Devulve una lista con los pedidos sin marcar (candidad a manipular = 0)
     * @param pedido
     * @return
     */
    private WarehouseActivityLineWSList getpedidoEntradaSinMarcar(String pedido){
        List<WarehouseActivityLineWSFilter> filtros = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f1 = new WarehouseActivityLineWSFilter();
        f1.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f1.setCriteria("Put_away");
        filtros.add(f1);
        WarehouseActivityLineWSFilter f2 = new WarehouseActivityLineWSFilter();
        f2.setField(WarehouseActivityLineWSFields.NO);
        f2.setCriteria(pedido);
        filtros.add(f2);
        WarehouseActivityLineWSFilter f3 = new WarehouseActivityLineWSFilter();
        f3.setField(WarehouseActivityLineWSFields.QTY_TO_HANDLE);
        f3.setCriteria(String.valueOf("=0"));
        filtros.add(f3);
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTION_TYPE);
        f4.setCriteria("Place");
        filtros.add(f4);
        return WebServicesInit.articulosPedidoService.readMultiple(filtros, "", 0);

    }

    /**
     * Devulve una linea de pedido
     * @param pedido
     * @param no
     * @return
     */
    private WarehouseActivityLineWS getLineaPedido(String pedido,int no){
        List<WarehouseActivityLineWSFilter> filtros = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f1 = new WarehouseActivityLineWSFilter();
        f1.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f1.setCriteria("Put_away");
        filtros.add(f1);
        WarehouseActivityLineWSFilter f2 = new WarehouseActivityLineWSFilter();
        f2.setField(WarehouseActivityLineWSFields.NO);
        f2.setCriteria(pedido);
        filtros.add(f2);
        WarehouseActivityLineWSFilter f3 = new WarehouseActivityLineWSFilter();
        f3.setField(WarehouseActivityLineWSFields.LINE_NO);
        f3.setCriteria(String.valueOf(no));
        filtros.add(f3);
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTION_TYPE);
        f4.setCriteria("Place");
        filtros.add(f4);
        WarehouseActivityLineWSList aux=WebServicesInit.articulosPedidoService.readMultiple(filtros, "", 0);
        if(aux==null) return null;
        else return aux.getWarehouseActivityLineWS().get(0);

    }


    private String peticionLanzadera(String targetURL, String urlParameters) {
        java.net.HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }


}
