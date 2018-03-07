package org.oscasistemas.util;

import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Portátil1 on 29/08/2017.
 */
public class WebBrowserOpener {


    public static void main(String[] args)  {

        try {
            openWebpage(new URI("http://google.com"));
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
    }

    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
