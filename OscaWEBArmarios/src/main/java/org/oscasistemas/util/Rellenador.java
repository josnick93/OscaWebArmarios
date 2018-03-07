package org.oscasistemas.util;

import java.io.*;

/**
 * Created by Portátil1 on 12/06/2017.
 */
public class Rellenador {

    public static void main(String[] args){

        try {
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("script.sql"), "utf-8"))) {
                //cada entablado
                for(int entablado=1;entablado<=50;entablado++){
                    //fila
                    for(int fila=1;fila<=4;fila++){
                        //columna
                        for(int columna=1;columna<=28;columna++){
                            writer.write("INSERT INTO `osca_localizacion`.`cajas_entablado` (`Id_lanzadera`, `Id_entablado`, `fila`, `columna`,`Articulo`, `Id_caja`," +
                                    " `Cantidad`, `esVacia`) VALUES ('A03-02','"+entablado+"', '"+fila+"', '"+columna+"',NULL ,'13', '0.0', '1');");
                        }
                    }
                }
                writer.write("something");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
