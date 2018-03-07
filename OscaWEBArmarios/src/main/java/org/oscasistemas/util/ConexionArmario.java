package org.oscasistemas.util;

import org.jboss.logging.Logger;

import java.io.*;
import java.net.Socket;

/**
 * Created by Portátil1 on 26/05/2017.
 */
public class ConexionArmario {

    private static final int PORT=4041;
    private static final Logger logger = Logger.getLogger(ConexionArmario.class);
    /**
     * Funcion que pide mover un entablado de una lanzadera determinada
     */
    public static String moverArmario(int lanzadera,int entablado) {
        //192.168.2.183
        try {
            System.out.println("Inicio Conexion Armario: " + lanzadera + "--" + entablado);
            Socket clientSocket = new Socket("192.168.2.185", PORT);
            DataOutputStream os = null;
            BufferedReader is = null;

            os = new DataOutputStream(clientSocket.getOutputStream());
            is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            if (clientSocket == null || os == null || is == null) {
                System.err.println("No se ha podido establecer conexion con el armario");
                return "Error";
            }
            //int times=5;
            //boolean correct=false;
            //while(!correct && times!=0){
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
            pw.println("MOVER " + entablado + " " + String.format("%02d", lanzadera) + "1");
            return "Sucess";
        }catch (IOException e){
            return "Error conexion Armario";
        }

        /*
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        */

    }
        //}
}
