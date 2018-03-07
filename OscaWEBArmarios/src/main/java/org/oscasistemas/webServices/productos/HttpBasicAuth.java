package org.oscasistemas.webServices.productos;

import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Portátil1 on 14/09/2017.
 */
public class HttpBasicAuth {

    public static void main(String[] args) {

        try {
            URL url = new URL ("http://192.168.2.6:7047/DynamicsNAV100CU08_OSCASIST/WS/Oscapruebas/Page/Item_Card");

            Base64 b = new Base64();
            String encoding = b.encodeAsString(new String("administrador:Passw0rd").getBytes());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty  ("Authorization", "Basic " + encoding);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in   =
                    new BufferedReader (new InputStreamReader (content));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

}
