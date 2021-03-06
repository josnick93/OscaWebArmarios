package org.oscasistemas.controller.Salida.SalidaPicking.SalidaPicking;

import com.dynamics.webServices.Bin_Content_WS.BinContentWS;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFields;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFilter;
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
public class SalidaPickingArticulo {

    @Autowired
    private ILanzadera lanzaderaService; //lift query service

    @Autowired (required = true)
    private IEntablado entabladoService; //shelf query service

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService; //custom box query service

    @Autowired
    private ICajaEntablado locationService; //box service

    @Autowired
    private IAcessoLazaderas acessoLazaderasService; //remote access query service

    @Autowired
    private IGruposLanzaderas gruposLanzaderas; //lift groups


    /**
     *
     * @param request
     * @param pedido
     * @param Nlinea
     * @param cerrar
     * @return
     */
    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value="/SalidaArticuloPedido" ,method= RequestMethod.GET)
    @ResponseBody
    public  ModelAndView salidaSeleccionTipoCajaPedidoPage(HttpServletRequest request,
                                                           @NotNull @RequestParam(value = "pedido" ,required = true) String pedido,
                                                           @NotNull @RequestParam(value = "Nlinea" ,required = false ,defaultValue = "EMPTY") String Nlinea,
                                                           @NotNull @RequestParam(value = "cerrar" ,required = true, defaultValue = "0") String cerrar)
    throws Exception{
          /*
         * Dir ip peticion
         */
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
        //request is a lift
        if(l!=null){
            m=new ModelAndView("Salida/SalidaPicking/SalidaPicking/PedidoSalidaArticulo");
            //no picking line received, search it
            if(Nlinea.equals("EMPTY")) {
                int nLanzaderas=lanzaderaService.getLanzaderas().size();
                //i send a command to this lift?
                boolean[] lanzado= new boolean[nLanzaderas];
                for(int i=0;i<nLanzaderas;i++)
                    lanzado[i]=false;
                //get Lift Picking lines
                List<WarehouseActivityLineWS> lineasPedido=
                        getpedidoSalidaSinMarcar(pedido).getWarehouseActivityLineWS();
                //sort ir
                Collections.sort(lineasPedido,new ComparadorEntablados());
                //for this picking lines send correspond line to this lift
                for(WarehouseActivityLineWS Lpick:lineasPedido){
                    Entablado e=entabladoService.getEstanteria(Lpick.getBinCode());
                    //request lift do this picking line
                    if(e.getLanzadera().getDireccion_ip().equals(remoteAddr)){
                        m.getModelMap().addAttribute("nLineasRestantes", lineasPedido.size());
                        m.getModelMap().addAttribute("entablado", e);
                        m.getModelMap().addAttribute("entabladoN", Lpick.getBinCode());
                        m.getModelMap().addAttribute("articuloPedido", Lpick);
                        m.getModelMap().addAttribute("articulo", WebServicesInit.articulosService.read(Lpick.getItemNo()));
                        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(e));
                        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(e));
                        m.getModelMap().addAttribute("cantidad", Lpick.getQtyOutstanding());
                        m.getModelMap().addAttribute("lanzadera", l);
                        m.getModelMap().addAttribute("cerrar", 0);
                        m.getModelMap().addAttribute("contenidoNav", getContenidoNav(Lpick.getBinCode(),Lpick.getItemNo()));
                        pedidoLanzadera=true;
                    }
                    //ask if remote lift is free and no task send
                    else if((requestLift=peticionLanzadera("http://"+e.getLanzadera().getDireccion_ip()
                            +":8080/ServidorArmarios/JSONServlet","orden=Acceder"))!=null
                            && requestLift.contains("OK")
                            && !lanzado[e.getLanzadera().getId_lanzadera()]
                            && gruposLanzaderas.getGrupo(l,e.getLanzadera())!=null){
                        lanzado[e.getLanzadera().getId_lanzadera()]=true;
                        //send by ssh remote command to lift
                        envioRemoto(new String[]{e.getLanzadera().getDireccion_ip()
                                ,"/OscaArmarios/SalidaArticuloPedido.html?pedido="+Lpick.getNo()
                                +"&Nlinea="+Lpick.getLineNo()+"&cerrar=0"});

                    }
                }
            }
            //request have a line ,get this line
            else{
                //obtener linea pedido de mi lanzadera
                WarehouseActivityLineWS lineaPedido = getLineaPicking(pedido,Integer.valueOf(Nlinea));
                //Collections.sort(lineasPedido,new ComparadorEntablados());
                //leer parametros
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
                m.getModelMap().addAttribute("cerrar", cerrar);
                m.getModelMap().addAttribute("contenidoNav", getContenidoNav(lineaPedido.getBinCode(),lineaPedido.getItemNo()));
                pedidoLanzadera=true;
            }
            m.getModelMap().addAttribute("tengoLineaPedido", pedidoLanzadera);
            return m;
        }
        //request is a PC
        else{
            m=new ModelAndView("Home");
            //lift wiout send remote command
            int nLanzaderas=lanzaderaService.getLanzaderas().size();
            boolean[] lanzado= new boolean[nLanzaderas];
            for(int i=0;i<nLanzaderas;i++)
                lanzado[i]=false;
            //get picking lines
            List<WarehouseActivityLineWS> lineasPedido=
                    getpedidoSalidaSinMarcar(pedido).getWarehouseActivityLineWS();
            //sort it
            Collections.sort(lineasPedido,new ComparadorEntablados());


            for(WarehouseActivityLineWS Lpick:lineasPedido){
                Entablado e=entabladoService.getEstanteria(Lpick.getBinCode());
                //if lift is free and no command sended, send a comand
                if((requestLift=peticionLanzadera("http://"+e.getLanzadera().getDireccion_ip()
                        +":8080/ServidorArmarios/JSONServlet","orden=Acceder"))!=null
                        && !lanzado[e.getLanzadera().getId_lanzadera()]
                        && requestLift.contains("OK")
                        && acessoLazaderasService.getAcesso(l,remoteAddr)!=null){
                    //enviar linea de pedido a la lanzadera
                    lanzado[e.getLanzadera().getId_lanzadera()]=true;
                    //send remote command to lift
                    envioRemoto(new String[]{e.getLanzadera().getDireccion_ip()
                            ,"/OscaArmarios/SalidaArticuloPedido.html?pedido="+Lpick.getNo()
                            +"&Nlinea="+Lpick.getLineNo()+"&cerrar=0"});

                }
            }
            return m;
        }
    }

    /**
     *
     * @param codigo
     * @param articulo
     * @return
     */
    private BinContentWS getContenidoNav(String codigo, String articulo){
        List<BinContentWSFilter> filtros = new ArrayList<BinContentWSFilter>();
        BinContentWSFilter f1 = new BinContentWSFilter();
        f1.setField(BinContentWSFields.BIN_CODE);
        f1.setCriteria(codigo);
        filtros.add(f1);
        BinContentWSFilter f2 = new BinContentWSFilter();
        f2.setField(BinContentWSFields.ITEM_NO);
        f2.setCriteria(articulo);
        filtros.add(f2);
        return WebServicesInit.contenidoUbicacionService.readMultiple(filtros, "", 0).getBinContentWS().get(0);
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
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.BIN_CODE);
        f5.setCriteria("PLNZ*");
        filtros.add(f5);
        return WebServicesInit.articulosPedidoService.readMultiple(filtros, "", 0);

    }


    /**
     *
     * @param targetURL
     * @param urlParameters
     * @return
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
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.BIN_CODE);
        f5.setCriteria("PLNZ*");
        filtros.add(f5);
        WarehouseActivityLineWSList aux=WebServicesInit.articulosPedidoService.readMultiple(filtros, "", 0);
        if(aux==null) return null;
        else return aux.getWarehouseActivityLineWS().get(0);

    }


    /**
     *
     * @param args
     */
    private void envioRemoto(String[] args){
        System.setProperty("java.net.preferIPv4Stack", "true");
        args[1] = "pkill midori; DISPLAY=:0 midori -e Fullscreen -a "
                + "'http://192.168.2.8"+args[1]+"'";
        System.out.println(args[1]);
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
            System.out.println("Connected");

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
