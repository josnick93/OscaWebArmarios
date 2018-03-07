package org.oscasistemas.controller.Entrada.EntradaMaterial.EntradaPedidoAgrupado;

import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWS;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSFields;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSFilter;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSList;
import com.jcraft.jsch.*;
import com.sun.istack.internal.NotNull;
import org.apache.log4j.Logger;
import org.oscasistemas.DAO.interfaces.*;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.Lanzadera;
import org.oscasistemas.service.interfaces.IPedidoEntradaService;
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
import java.util.HashMap;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 21/12/2017.
 */
@RestController
public class EntradaArticuloPedidoAgrupado {


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

    @Autowired
    private IGruposLanzaderas gruposLanzaderas;

    @Autowired
    private IAcessoLazaderas acessoLazaderasService;


    private static final Logger logger = Logger.getLogger(EntradaArticuloPedidoAgrupado.class);


    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
    @RequestMapping(value="/EntradaArticuloPedidoAgrupado" ,method= {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ModelAndView entradaPedidoAgrupado(HttpServletRequest request,
                                                           @NotNull @RequestParam(value = "pedido" ,required = true) String pedido,
                                                           @NotNull @RequestParam(value = "articulo" ,required = true, defaultValue = "EMPTY") String articulo,
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
            m=new ModelAndView("Entrada/EntradaMaterial/EntradaPedidoAgrupado/EntradaArticuloPedidoAgrupado");
            //lanzadera encargada lanzar pedido
            if(articulo.equals("EMPTY")) {
                int nLanzaderas=lanzaderaService.getLanzaderas().size();
                boolean[] lanzado= new boolean[nLanzaderas];
                for(int i=0;i<nLanzaderas;i++)
                    lanzado[i]=false;

                //obtener lineas de pedido sin marcar
                for(WarehouseActivityLineWS Lpedido:
                        getpedidoEntradaSinMarcar(pedido)) {
                    boolean lineaEncontrada=false;

                    Entablado e = entabladoService.getEstanteria(Lpedido.getBinCode());
                    //si soy mi lanzadera cargo la pagina como poseedor
                    if (e.getLanzadera().getDireccion_ip().equals(remoteAddr)) {
                        WarehouseActivityLineWS lineaPedido = getSumaTotalArticulo(Lpedido.getNo(),Lpedido.getItemNo(),Lpedido.getBinCode());
                        m.getModelMap().addAttribute("entablado", e);
                        m.getModelMap().addAttribute("entabladoN", lineaPedido.getBinCode());
                        m.getModelMap().addAttribute("articuloPedido", Lpedido);
                        m.getModelMap().addAttribute("articulo", WebServicesInit.articulosService.read(lineaPedido.getItemNo()));
                        m.getModelMap().addAttribute("ubicaciones", locationService.getCajasEntablado(e));
                        m.getModelMap().addAttribute("reservas", cajaEntabladoMedidaService.getCajasEntablado(e));
                        m.getModelMap().addAttribute("cantidad", Lpedido.getQtyOutstanding());
                        m.getModelMap().addAttribute("lanzadera", l);
                        m.getModelMap().addAttribute("cerrar", cerrar);
                        pedidoLanzadera = true;
                    }
                    //consultar si la lanzadera esta libre
                    else if ((requestLift = peticionLanzadera("http://" + e.getLanzadera().getDireccion_ip()
                            + ":8080/ServidorArmarios/JSONServlet", "orden=Acceder")) != null
                            && !lanzado[e.getLanzadera().getId_lanzadera()]
                            && requestLift.contains("OK")
                            && gruposLanzaderas.getGrupo(l,e.getLanzadera())!=null) {
                        //enviar linea de pedido a la lanzadera
                        /*
                        new WebBrowserOpener(new String[]{e.getLanzadera().getDireccion_ip(),
                                "/OscaArmarios/EntradaArticuloPedidoAgrupado.html?pedido=" + Lpedido.getNo()
                                        + "&articulo=" + Lpedido.getItemNo() + "&&cerrar=0"}).run();
                                        */
                        lanzado[e.getLanzadera().getId_lanzadera()]=true;
                        envioRemoto(new String[]{e.getLanzadera().getDireccion_ip(),
                                "/OscaArmarios/EntradaArticuloPedidoAgrupado.html?pedido=" + Lpedido.getNo()
                                        + "&articulo=" + Lpedido.getItemNo() + "&cerrar=0"});
                    }
                }
            }
            //ordenador remoto
            else{
                //obtener suma cantidad articulo lanzadera

                WarehouseActivityLineWS lineaPedido = getSumaTotalArticulo(pedido,articulo);
                logger.debug("LINEA PEDIDO AGRUPADO: "+lineaPedido.toString());
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
            for(WarehouseActivityLineWS Lpedido:getpedidoEntradaSinMarcar(pedido)){
                Entablado e=entabladoService.getEstanteria(Lpedido.getBinCode());
                int nLanzaderas=lanzaderaService.getLanzaderas().size();
                boolean[] lanzado= new boolean[nLanzaderas];
                for(int i=0;i<nLanzaderas;i++)
                    lanzado[i]=false;
                //consultar si la lanzadera esta libre y tiene permiso de acceso
                if((requestLift=peticionLanzadera("http://"+e.getLanzadera().getDireccion_ip()
                        +":8080/ServidorArmarios/JSONServlet","orden=Acceder"))!=null
                        && !lanzado[e.getLanzadera().getId_lanzadera()]
                        && requestLift.contains("OK")
                        && acessoLazaderasService.getAcesso(e.getLanzadera(),remoteAddr)!=null){
                    /*
                    new WebBrowserOpener(new String[]{e.getLanzadera().getDireccion_ip() ,
                            "/OscaArmarios/EntradaArticuloPedidoAgrupado.html?pedido="+Lpedido.getNo()
                                    +"&articulo="+Lpedido.getItemNo()+"&&cerrar=0"}).run();
                     */
                    lanzado[e.getLanzadera().getId_lanzadera()]=true;
                    envioRemoto(new String[]{e.getLanzadera().getDireccion_ip(),
                            "/OscaArmarios/EntradaArticuloPedidoAgrupado.html?pedido=" + Lpedido.getNo()
                                    + "&articulo=" + Lpedido.getItemNo() + "&cerrar=0"});
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
    private List<WarehouseActivityLineWS> getpedidoEntradaSinMarcar(String pedido){
        HashMap<String,WarehouseActivityLineWS> grupoArticulos=new HashMap<>();


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
        for(WarehouseActivityLineWS w:WebServicesInit.articulosPedidoService.readMultiple(filtros, "", 0).getWarehouseActivityLineWS()){
            grupoArticulos.put(w.getItemNo(),w);
        }
        return new ArrayList<>(grupoArticulos.values());
    }

    /**
     *     Obtiene la suma total del articulo en las ubicaciones
     */

    private WarehouseActivityLineWS getSumaTotalArticulo(String pedido,String articulo){
        WarehouseActivityLineWS linea=new WarehouseActivityLineWS();

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
        f3.setField(WarehouseActivityLineWSFields.ITEM_NO);
        f3.setCriteria(String.valueOf(articulo));
        filtros.add(f3);
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTION_TYPE);
        f4.setCriteria("Place");
        filtros.add(f4);
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.QTY_TO_HANDLE);
        f5.setCriteria(String.valueOf("=0"));
        filtros.add(f5);
        WarehouseActivityLineWSList aux=WebServicesInit.articulosPedidoService.readMultiple(filtros, "", 0);
        linea=aux.getWarehouseActivityLineWS().get(0);
        for(int i=1;i<aux.getWarehouseActivityLineWS().size();i++){
           linea.setQtyToHandle(linea.getQtyToHandle().add(aux.getWarehouseActivityLineWS().get(i).getQtyToHandle()));
        }
        return linea;
    }

    private WarehouseActivityLineWS getSumaTotalArticulo(String pedido,String articulo,String ubicacion){
        WarehouseActivityLineWS linea=new WarehouseActivityLineWS();

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
        f3.setField(WarehouseActivityLineWSFields.ITEM_NO);
        f3.setCriteria(String.valueOf(articulo));
        filtros.add(f3);
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTION_TYPE);
        f4.setCriteria("Place");
        filtros.add(f4);
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.QTY_TO_HANDLE);
        f5.setCriteria(String.valueOf("=0"));
        filtros.add(f5);
        WarehouseActivityLineWSFilter f6 = new WarehouseActivityLineWSFilter();
        f6.setField(WarehouseActivityLineWSFields.BIN_CODE);
        f6.setCriteria(ubicacion);
        filtros.add(f6);
        WarehouseActivityLineWSList aux=WebServicesInit.articulosPedidoService.readMultiple(filtros, "", 0);
        linea=aux.getWarehouseActivityLineWS().get(0);
        for(int i=1;i<aux.getWarehouseActivityLineWS().size();i++){
            linea.setQtyToHandle(linea.getQtyToHandle().add(aux.getWarehouseActivityLineWS().get(i).getQtyToHandle()));
        }
        return linea;
    }

    private void envioRemoto(String[] args){
        System.setProperty("java.net.preferIPv4Stack", "true");
        args[1] = "pkill midori; DISPLAY=:0 midori -e Fullscreen -a "
                + "'http://192.168.2.8"+args[1]+"'";
        System.out.println(args[1]);
        String user = "oscasistemas";
        String password = "osca";
        Channel channel = null;
        try {
            System.out.println(args[0]);
            System.out.println(args[1]);
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
                System.out.print(new String(tmp, 0, i));
            }
            if (channel.isClosed()) {
                System.out.println("exit-status: "
                        + channel.getExitStatus());
                //break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ee) {
            }
            //}
            channel.disconnect();
            session.disconnect();
            System.out.println("DONE");
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
                System.out.println(channel.isConnected());
            }
        }


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
        HttpURLConnection connection = null;

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
