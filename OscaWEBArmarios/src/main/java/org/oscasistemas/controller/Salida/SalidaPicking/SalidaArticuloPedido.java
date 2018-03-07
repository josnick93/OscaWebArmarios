package org.oscasistemas.controller.Salida.SalidaPicking;

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
import org.oscasistemas.model.PedidoSalida;
import org.oscasistemas.service.interfaces.IPedidoSalidaService;
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
public class SalidaArticuloPedido {

    @Autowired
    private ILanzadera lanzaderaService;

    @Autowired
    private IPedidoSalidaService pedidosalidaService;

    @Autowired (required = true)
    private IEntablado entabladoService;

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;

    @Autowired
    private ICajaEntablado locationService;

    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value="/SalidaArticuloPedido" ,method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView salidaSeleccionTipoCajaPedidoPage(HttpServletRequest request,
                                                           @NotNull @RequestParam(value = "pedido" ,required = true) String pedido,
                                                           @NotNull @RequestParam(value = "Nlinea" ,required = false ,defaultValue = "EMPTY") String Nlinea,
                                                           @NotNull @RequestParam(value = "cerrar" ,required = true, defaultValue = "0") String cerrar) {
          /*
         * Dir ip peticion
         */
        System.out.println("-------------------------INICIO SALIDA ARTICULO -------------------------------"+pedido);
        ModelAndView m=null;
        String requestLift="";
        boolean pedidoLanzadera=false; //tengo alguna linea en mi lanzadera
        Lanzadera l=null;
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        l=lanzaderaService.getLanzaderaIp(remoteAddr);
        if(l!=null){
            m=new ModelAndView("SalidaArticuloPedido");
            //lanzadera encargada lanzar pedido
            if(Nlinea.equals("EMPTY")) {
                System.out.println("Inicio busqueda");
                //enviar ordenes lanzaderas si es posible
                for(WarehouseActivityLineWS Lpick:
                        getpedidoSalidaSinMarcar(pedido).getWarehouseActivityLineWS()){
                    Entablado e=entabladoService.getEstanteria(Lpick.getBinCode());
                    System.out.println(Lpick.toString());
                    //si soy mi lanzadera cargo la pagina como poseedor
                    if(e.getLanzadera().getDireccion_ip().equals(remoteAddr)){
                        System.out.println("SALIDA PEDIDO EN LANZADERA");
                        m.getModelMap().addAttribute("entablado", e);
                        m.getModelMap().addAttribute("entabladoN", Lpick.getBinCode());
                        m.getModelMap().addAttribute("articuloPedido", Lpick);
                        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(e));
                        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(e));
                        m.getModelMap().addAttribute("cantidad", Lpick.getQtyOutstanding());
                        m.getModelMap().addAttribute("lanzadera", l);
                        m.getModelMap().addAttribute("cerrar", cerrar);
                        pedidoLanzadera=true;
                    }
                    //consultar si la lanzadera esta libre
                    else if((requestLift=peticionLanzadera("http://"+e.getLanzadera().getDireccion_ip()
                            +":8080/ServidorArmarios/JSONServlet","orden=Acceder"))!=null && requestLift.contains("OK")){
                        //enviar linea de pedido a la lanzadera
                        Thread ventana=new Thread(new WebBrowserOpener(new String[]{e.getLanzadera().getDireccion_ip()," '/OscaArmarios/SalidaArticuloPedido.html?pedido="+Lpick.getNo()+"&Nlinea="+Lpick.getLineNo()+"&cerrar=1"}));
                        ventana.run();
                    }
                }

            }else{
                System.out.println("LINEA");
                //obtener linea pedido de mi lanzadera
                WarehouseActivityLineWS lineaPedido = getLineaPicking(pedido,Integer.valueOf(Nlinea));
                //leer parametros
                Entablado e=entabladoService.getEstanteria(lineaPedido.getBinCode());
                m.getModelMap().addAttribute("entablado", e);
                m.getModelMap().addAttribute("entabladoN", lineaPedido.getBinCode());
                m.getModelMap().addAttribute("articuloPedido", lineaPedido);
                m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(e));
                m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(e));
                m.getModelMap().addAttribute("articuloPedido", lineaPedido);
                m.getModelMap().addAttribute("cantidad", lineaPedido.getQtyOutstanding());
                m.getModelMap().addAttribute("lanzadera", l);
                m.getModelMap().addAttribute("cerrar", cerrar);
                pedidoLanzadera=true;
            }
            m.getModelMap().addAttribute("tengoLineaPedido", pedidoLanzadera);
            return m;
        }
        //ordenador distribuir Tareas
        else{
            m=new ModelAndView("Home");
            List<PedidoSalida> lineaPedido=pedidosalidaService.getLanzaderasPedido(pedido);
            //enviar ordenes lanzaderas si es posible
            for(PedidoSalida Lpick:lineaPedido){
                List<WarehouseActivityLineWSFilter> filtros = new ArrayList<WarehouseActivityLineWSFilter>();
                WarehouseActivityLineWSFilter f1 = new WarehouseActivityLineWSFilter();
                f1.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
                f1.setCriteria("Pick");
                filtros.add(f1);
                WarehouseActivityLineWSFilter f2 = new WarehouseActivityLineWSFilter();
                f2.setField(WarehouseActivityLineWSFields.NO);
                f2.setCriteria(Lpick.getNpedido());
                filtros.add(f2);
                WarehouseActivityLineWSFilter f3 = new WarehouseActivityLineWSFilter();
                f3.setField(WarehouseActivityLineWSFields.LINE_NO);
                f3.setCriteria(String.valueOf(Lpick.getNlinea()));
                filtros.add(f3);
                WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
                f4.setField(WarehouseActivityLineWSFields.ACTION_TYPE);
                f4.setCriteria("Take");
                filtros.add(f4);

                System.out.println(Lpick.toString());
                WarehouseActivityLineWS myWarehouseActivityLineWS = WebServicesInit.articulosPedidoService.readMultiple(filtros, "", 0).getWarehouseActivityLineWS().get(0);
                Entablado e=entabladoService.getEstanteria(myWarehouseActivityLineWS.getBinCode());
                //consultar si la lanzadera esta libre
                if((requestLift=peticionLanzadera("http://"+e.getLanzadera().getDireccion_ip()
                        +":8080/ServidorArmarios/JSONServlet","orden=Acceder"))!=null && requestLift.contains("OK")){
                    //enviar linea de pedido a la lanzadera
                    String url="/OscaArmarios/SalidaArticuloPedido.html?pedido="+myWarehouseActivityLineWS.getNo()+"&Nlinea="+myWarehouseActivityLineWS.getLineNo();
                    new WebBrowserOpener(new String[]{e.getLanzadera().getDireccion_ip()
                            ,"/OscaArmarios/SalidaArticuloPedido.html?pedido="+myWarehouseActivityLineWS.getNo()
                            +"&Nlinea="+myWarehouseActivityLineWS.getLineNo()+"&cerrar=1"}).run();

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
    private WarehouseActivityLineWSList getpedidoSalidaSinMarcar(String pedido){
        List<WarehouseActivityLineWSFilter> filtros = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f1 = new WarehouseActivityLineWSFilter();
        f1.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f1.setCriteria("Pick");
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
        f4.setCriteria("Take");
        filtros.add(f4);
        return WebServicesInit.articulosPedidoService.readMultiple(filtros, "", 0);

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

    /**
     * Devulve una linea de pedido
     * @param pedido
     * @param no
     * @return
     */
    private WarehouseActivityLineWS getLineaPicking(String pedido,int no){
        List<WarehouseActivityLineWSFilter> filtros = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f1 = new WarehouseActivityLineWSFilter();
        f1.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f1.setCriteria("Pick");
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
        f4.setCriteria("Take");
        filtros.add(f4);
        WarehouseActivityLineWSList aux=WebServicesInit.articulosPedidoService.readMultiple(filtros, "", 0);
        if(aux==null) return null;
        else return aux.getWarehouseActivityLineWS().get(0);

    }



}
