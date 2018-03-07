package Armarios;

import com.jcraft.jsch.*;

import java.io.InputStream;
import java.sql.*;

/**
 * Created by José Ángel Caudevilla Casaus on 25/01/2018.
 */
public class ConexionRemotaTest {

    @org.junit.Test
    public void abrirRemoto() throws SQLException {

        String[] args=new String[]{"192.168.2.37" ,"/OscaArmarios/SalidaSeleccionUbicacionFinal.html?articulo=040200235&entablado=PLNZ.07.0011&cerrar=0"};

        System.setProperty("java.net.preferIPv4Stack", "true");
        args[1] = "pkill midori; DISPLAY=:0 midori -e Fullscreen -a "
                + "\"'http://192.168.2.8/OscaArmarios/"+args[1]+"'\"";
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