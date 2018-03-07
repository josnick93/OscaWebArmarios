package org.oscasistemas.controller.Entrada.EntradaMaterial.EntradaPedido;

import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWS;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSFields;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSFilter;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSList;
import com.jcraft.jsch.*;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.*;
import org.oscasistemas.utils.ComparadorEntablados;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.Lanzadera;
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
import java.util.Collections;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 21/12/2017.
 */
@RestController
public class EntradaArticuloPedido {


    @Autowired
    private ILanzadera lanzaderaService;

    @Autowired (required = true)
    private IEntablado entabladoService;

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;

    @Autowired
    private ICajaEntablado locationService;

    @Autowired
    private IAcessoLazaderas acessoLazaderasService;

    @Autowired
    private IGruposLanzaderas gruposLanzaderas;

    /**
     *
     * @param request
     * @param pedido
     * @param Nlinea
     * @param indice
     * @return A page that contains the line of ubication in the designed lift
     */
    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value="/EntradaArticuloPedido" ,method= {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ModelAndView entradaSeleccionTipoCajaPedidoPage(HttpServletRequest request,
                                                           @NotNull @RequestParam(value = "pedido" ,required = true) String pedido,
                                                           @NotNull @RequestParam(value = "Nlinea" ,required = true, defaultValue = "EMPTY") String Nlinea,
                                                           @NotNull @RequestParam(value = "indiceLinea" ,required = false, defaultValue = "0") int indice)
    throws Exception{
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
            m=new ModelAndView("Entrada/EntradaMaterial/EntradaPedido/EntradaArticuloPedido");
            //lanzadera encargada lanzar pedido
            if(Nlinea.equals("EMPTY")) {

                int nLanzaderas=lanzaderaService.getLanzaderas().size();
                boolean[] lanzado= new boolean[nLanzaderas];
                for(int i=0;i<nLanzaderas;i++)
                    lanzado[i]=false;
                //obtener lineas de pedido sin marcar
                List<WarehouseActivityLineWS> lineasPedido=
                        getpedidoEntradaSinMarcar(pedido).getWarehouseActivityLineWS();
                //sort list by shelf code
                Collections.sort(lineasPedido,new ComparadorEntablados());
                for(WarehouseActivityLineWS Lpedido:lineasPedido) {
                    Entablado e = entabladoService.getEstanteria(Lpedido.getBinCode());
                    //si soy mi lanzadera cargo la pagina como poseedor
                    if (e.getLanzadera().getDireccion_ip().equals(remoteAddr)) {
                        m.getModelMap().addAttribute("nLineasPedido", lineasPedido.size());
                        m.getModelMap().addAttribute("entablado", e);
                        m.getModelMap().addAttribute("entabladoN", Lpedido.getBinCode());
                        m.getModelMap().addAttribute("articuloPedido", Lpedido);
                        m.getModelMap().addAttribute("articulo", WebServicesInit.articulosService.read(Lpedido.getItemNo()));
                        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(e));
                        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(e));
                        m.getModelMap().addAttribute("cantidad", Lpedido.getQtyOutstanding());
                        m.getModelMap().addAttribute("lanzadera", l);
                        m.getModelMap().addAttribute("indiceLinea", indice);
                        pedidoLanzadera = true;
                    }
                    //consultar si la lanzadera esta libre y pertenece al grupo
                    else if ((requestLift = peticionLanzadera("http://" + e.getLanzadera().getDireccion_ip()
                            + ":8080/ServidorArmarios/JSONServlet", "orden=Acceder")) != null
                            && !lanzado[e.getLanzadera().getId_lanzadera()]
                            && requestLift.contains("OK")
                            && gruposLanzaderas.getGrupo(l,e.getLanzadera())!=null) {
                        lanzado[e.getLanzadera().getId_lanzadera()]=true;
                        //enviar linea de pedido a la lanzadera
                        envioRemoto(new String[]{e.getLanzadera().getDireccion_ip(),
                                "/OscaArmarios/EntradaArticuloPedido.html?pedido=" + Lpedido.getNo()
                                        + "&Nlinea=" + Lpedido.getLineNo() + "&indiceLinea=0"});
                    }
                }
            }
            //ordenador remoto
            else{
                //obtener linea pedido de mi lanzadera
                WarehouseActivityLineWS lineaPedido= null;
                if(indice!=0){
                    lineaPedido = getLineaPedido(pedido,Integer.valueOf(Nlinea));
                }else{
                    lineaPedido = getLineaPedidoIndice(pedido, indice);
                }

                Entablado e=entabladoService.getEstanteria(lineaPedido.getBinCode());
                m.getModelMap().addAttribute("entablado", e);
                m.getModelMap().addAttribute("entabladoN", lineaPedido.getBinCode());
                m.getModelMap().addAttribute("articuloPedido", lineaPedido);
                m.getModelMap().addAttribute("articulo", WebServicesInit.articulosService.read(lineaPedido.getItemNo()));
                m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(e));
                m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(e));
                m.getModelMap().addAttribute("articuloPedido", lineaPedido);
                m.getModelMap().addAttribute("cantidad", lineaPedido.getQtyOutstanding());
                m.getModelMap().addAttribute("lanzadera", l);
                m.getModelMap().addAttribute("indiceLinea",indice);
                pedidoLanzadera=true;
            }
            m.getModelMap().addAttribute("tengoLineaPedido", pedidoLanzadera);
            m.getModelMap().addAttribute("indiceLinea", indice);
            return m;
        }
        //ordenador distribuir Tareas
        else{
            m=new ModelAndView("Home");
            int nLanzaderas=lanzaderaService.getLanzaderas().size();
            boolean[] lanzado= new boolean[nLanzaderas];
            for(int i=0;i<nLanzaderas;i++)
                lanzado[i]=false;
            //obtener lineas de pedido sin marcar
            List<WarehouseActivityLineWS> lineasPedido=
                    getpedidoEntradaSinMarcar(pedido).getWarehouseActivityLineWS();
            Collections.sort(lineasPedido,new ComparadorEntablados());
            for(WarehouseActivityLineWS Lpedido:lineasPedido){
                Entablado e=entabladoService.getEstanteria(Lpedido.getBinCode());
                //consultar si la lanzadera esta libre, y tiene permiso para mover
                if((requestLift=peticionLanzadera("http://"+e.getLanzadera().getDireccion_ip()
                        +":8080/ServidorArmarios/JSONServlet","orden=Acceder"))!=null
                        && !lanzado[e.getLanzadera().getId_lanzadera()]
                        && requestLift.contains("OK")
                        && acessoLazaderasService.getAcesso(e.getLanzadera(),remoteAddr) != null){
                    lanzado[e.getLanzadera().getId_lanzadera()]=true;
                    envioRemoto(new String[]{e.getLanzadera().getDireccion_ip() ,
                            "/OscaArmarios/EntradaArticuloPedido.html?pedido="+Lpedido.getNo()
                                    +"&Nlinea="+Lpedido.getLineNo()+"&indiceLinea=0"});
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
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.BIN_CODE);
        f5.setCriteria("PLNZ*");
        filtros.add(f5);
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

    /**
     * Devulve una linea de pedido basada en un indice
     * @param pedido
     * @param indice
     * @return
     */
    private WarehouseActivityLineWS getLineaPedidoIndice(String pedido,int indice){
        List<WarehouseActivityLineWSFilter> filtros = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f1 = new WarehouseActivityLineWSFilter();
        f1.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f1.setCriteria("Put_away");
        filtros.add(f1);
        WarehouseActivityLineWSFilter f2 = new WarehouseActivityLineWSFilter();
        f2.setField(WarehouseActivityLineWSFields.NO);
        f2.setCriteria(pedido);
        filtros.add(f2);
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTION_TYPE);
        f4.setCriteria("Place");
        filtros.add(f4);
        WarehouseActivityLineWSList aux=WebServicesInit.articulosPedidoService.readMultiple(filtros, "", 0);
        if(aux==null) return null;
        else return aux.getWarehouseActivityLineWS().get(indice);

    }


    /**
     * Ask to a lift if it is free or not
     * @param targetURL
     * @param urlParameters
     * @return the target response OK, null if not reponse
     */
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
     * Sends by ssh a command to remote device
     * @param args : 0 destinity IP
     *               1 remoteURL
     */
    private void envioRemoto(String[] args){
        System.setProperty("java.net.preferIPv4Stack", "true");
        args[1] = "pkill midori; DISPLAY=:0 midori -e Fullscreen -a "
                + "'http://192.168.2.8"+args[1]+"'";
        String user = "oscasistemas";
        String password = "osca";
        Channel channel = null;
        try {
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, args[0], 22);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(args[1]);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);

            InputStream in = channel.getInputStream();
            channel.connect();
            byte[] tmp = new byte[1024];
            //while (true) {
            while (in.available() > 0) {
                int i = in.read(tmp, 0, 1024);
                if (i <= 0){
                    System.out.println("--->>>FIN");
                    break;
                }
            }
            if (channel.isClosed()) {
                //break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ee) {
            }
            //}
            channel.disconnect();
            session.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                Session session = null;
                try {
                    session = channel.getSession();
                } catch (JSchException e) {
                    e.printStackTrace();
                }
                channel.disconnect();
                session.disconnect();
            }
        }


    }


}
