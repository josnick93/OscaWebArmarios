package org.oscasistemas.controller.Operaciones.Remoto;

import com.jcraft.jsch.*;
import com.sun.istack.internal.NotNull;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

/**
 * Created by José Ángel Caudevílla Casaús on 26/12/2017.
 */
@RestController
public class AbrirVentana {

    @RequestMapping(value="OperacionEntablado/AbrirVentana" ,method = RequestMethod.GET )
    public   @ResponseBody
    String modificarAcessoLanzadera(HttpServletRequest request,
                                    @NotNull @RequestParam(value = "ip",required = true ,defaultValue = "0.0.0.0")  String ip,
                                    @NotNull @RequestParam(value = "url",required = true ,defaultValue = "Home")String url) throws Exception {
        JSONObject outputJsonObj = new JSONObject();
        String line;
        /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

        //Process proc = Runtime.getRuntime().exec("java -jar "+request.getSession().getServletContext().getRealPath("/src/WEBOpener.jar")+" "+ip+" '"+url+"&cerrar=1'");
        System.out.println("********Iniciando thread");
        //new WebBrowserOpener().run();
        synchronized (this){
            envioRemoto(new String[]{ip ,url});
        }
        outputJsonObj.put("res","true");
        return outputJsonObj.toString();
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
}
