package org.oscasistemas.controller.Salida.SalidaPicking.Utils;

import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWS;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSFields;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSFilter;
import com.dynamics.webServices.Warehouse_Activity_Line_WS.WarehouseActivityLineWSList;
import org.oscasistemas.controller.WebService.WebServicesInit;

import javax.xml.ws.Holder;
import javax.xml.ws.soap.SOAPFaultException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Portátil1 on 28/02/2018.
 */
public class SalidaUtils {


    /**
     *
     * @param No
     * @param Line_No
     * @throws SOAPFaultException
     */
    public static void salidaActuallizarCantidadManejar(String No, int Line_No)
            throws SOAPFaultException{

        List<WarehouseActivityLineWSFilter> filtros1 = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f4.setCriteria("Pick");
        filtros1.add(f4);
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.NO);
        f5.setCriteria(No);
        filtros1.add(f5);
        WarehouseActivityLineWSFilter f6 = new WarehouseActivityLineWSFilter();
        f6.setField(WarehouseActivityLineWSFields.LINE_NO);
        f6.setCriteria(String.valueOf(Line_No));
        filtros1.add(f6);
        WarehouseActivityLineWS pick= WebServicesInit.articulosPedidoService.readMultiple(filtros1, "", 0)
                .getWarehouseActivityLineWS().get(0);

        pick.setQtyToHandle(pick.getQtyOutstanding());
        //update pick line
        WebServicesInit.articulosPedidoService.update(new Holder<WarehouseActivityLineWS>(pick));
    }

    /**
     *
     * @param No
     * @param Line_No
     * @throws SOAPFaultException
     */
    public static void salidaActuallizarCantidadManejar(String No, int Line_No, int cantidad)
            throws SOAPFaultException{

        List<WarehouseActivityLineWSFilter> filtros1 = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f4.setCriteria("Pick");
        filtros1.add(f4);
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.NO);
        f5.setCriteria(No);
        filtros1.add(f5);
        WarehouseActivityLineWSFilter f6 = new WarehouseActivityLineWSFilter();
        f6.setField(WarehouseActivityLineWSFields.LINE_NO);
        f6.setCriteria(String.valueOf(Line_No));
        filtros1.add(f6);
        WarehouseActivityLineWS pick= WebServicesInit.articulosPedidoService.readMultiple(filtros1, "", 0)
                .getWarehouseActivityLineWS().get(0);

        pick.setQtyToHandle(BigInteger.valueOf(cantidad));
        //update pick line
        WebServicesInit.articulosPedidoService.update(new Holder<WarehouseActivityLineWS>(pick));
    }

    /**
     *
     * @param No
     * @param Bin_Code
     * @return
     * @throws SOAPFaultException
     */
    public static WarehouseActivityLineWSList salidaLineasRegistradas(String No, String Bin_Code)
            throws  SOAPFaultException{
        //Buscar en NAV Pedidos Sin marcar de la lanzadera
        ArrayList<WarehouseActivityLineWSFilter> filtros1 = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f4.setCriteria("Pick");
        filtros1.add(f4);
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.QTY_TO_HANDLE);
        f5.setCriteria(String.valueOf("=0"));
        filtros1.add(f5);
        WarehouseActivityLineWSFilter f7 = new WarehouseActivityLineWSFilter();
        f7.setField(WarehouseActivityLineWSFields.NO);
        f7.setCriteria(No);
        filtros1.add(f7);
        WarehouseActivityLineWSFilter f6 = new WarehouseActivityLineWSFilter();
        f6.setField(WarehouseActivityLineWSFields.BIN_CODE);
        f6.setCriteria(String.valueOf(Bin_Code.substring(0,8)+"*"));
        filtros1.add(f6);
        return WebServicesInit.articulosPedidoService.readMultiple(filtros1, "", 0);
    }


    /**
     *
     * @param No
     * @return
     * @throws SOAPFaultException
     */
    public static WarehouseActivityLineWSList lineasSinRegistrar(String No)
            throws  SOAPFaultException{

        WebServicesInit.functionsService.pickPost(No);
        //listar todos los pedidos
        List<WarehouseActivityLineWSFilter> filtros1 = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f4.setCriteria("Pick");
        filtros1.add(f4);
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.QTY_TO_HANDLE);
        f5.setCriteria(String.valueOf("=0"));
        filtros1.add(f5);
        WarehouseActivityLineWSFilter f7 = new WarehouseActivityLineWSFilter();
        f7.setField(WarehouseActivityLineWSFields.NO);
        f7.setCriteria(No);
        filtros1.add(f7);
        return WebServicesInit.articulosPedidoService.readMultiple(filtros1, "", 0);
    }



}
