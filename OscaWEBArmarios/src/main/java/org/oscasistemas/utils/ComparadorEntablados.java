package org.oscasistemas.utils;

import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWS;

import java.util.Comparator;

/**
 * Created by Portátil1 on 19/02/2018.
 * This class is use to compare shelf codes and order it.
 */
public class ComparadorEntablados implements Comparator<WarehouseActivityLineWS> {
    @Override
    public int compare(WarehouseActivityLineWS o1, WarehouseActivityLineWS o2) {
        int entablado1=Integer.valueOf(o1.getBinCode().substring(8,o1.getBinCode().length()));
        int entablado2=Integer.valueOf(o2.getBinCode().substring(8,o2.getBinCode().length()));
        if(entablado1 == entablado2){

            return Integer.valueOf(o1.getItemNo()) < Integer.valueOf(o2.getItemNo()) ? 1 : -1;
        }
        else return entablado1 < entablado2 ? -1 : 1;
    }
}
