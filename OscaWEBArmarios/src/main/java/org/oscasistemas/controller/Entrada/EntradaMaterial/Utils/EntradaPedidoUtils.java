package org.oscasistemas.controller.Entrada.EntradaMaterial.Utils;

import com.dynamics.webServices.Warehouse_Activity_Header_WS.WarehouseActivityHeaderWS;
import com.dynamics.webServices.Warehouse_Activity_Header_WS.WarehouseActivityHeaderWSFields;
import com.dynamics.webServices.Warehouse_Activity_Header_WS.WarehouseActivityHeaderWSFilter;
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
public class EntradaPedidoUtils {


    /**
     * Update quantitytohandle value to quantityoutstanding value
     * @param No
     * @param lineNo
     * @throws SOAPFaultException
     */
    public static void entradaActualizarCantidadAManipular(String No, int lineNo)
            throws SOAPFaultException {

        List<WarehouseActivityLineWSFilter> filtros1 = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f4.setCriteria("Put_away");
        filtros1.add(f4);
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.NO);
        f5.setCriteria(No);
        filtros1.add(f5);
        WarehouseActivityLineWSFilter f6 = new WarehouseActivityLineWSFilter();
        f6.setField(WarehouseActivityLineWSFields.LINE_NO);
        f6.setCriteria(String.valueOf(lineNo));
        filtros1.add(f6);
        WarehouseActivityLineWS line = WebServicesInit.articulosPedidoService.readMultiple(filtros1, "", 0)
                .getWarehouseActivityLineWS().get(0);
        line.setQtyToHandle(line.getQtyOutstanding());
        WebServicesInit.articulosPedidoService.update(new Holder<WarehouseActivityLineWS>(line));
    }

    /**
     * Update quantitytohandle value to quantityoutstanding value
     * @param No
     * @param lineNo
     * @throws SOAPFaultException
     */
    public static void entradaActualizarCantidadAManipular(String No, int lineNo, int quantity)
            throws SOAPFaultException {

        List<WarehouseActivityLineWSFilter> filtros1 = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f4.setCriteria("Put_away");
        filtros1.add(f4);
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.NO);
        f5.setCriteria(No);
        filtros1.add(f5);
        WarehouseActivityLineWSFilter f6 = new WarehouseActivityLineWSFilter();
        f6.setField(WarehouseActivityLineWSFields.LINE_NO);
        f6.setCriteria(String.valueOf(lineNo));
        filtros1.add(f6);
        WarehouseActivityLineWS line = WebServicesInit.articulosPedidoService.readMultiple(filtros1, "", 0)
                .getWarehouseActivityLineWS().get(0);
        line.setQtyToHandle(BigInteger.valueOf(quantity));
        WebServicesInit.articulosPedidoService.update(new Holder<WarehouseActivityLineWS>(line));
    }

    /**
     *
     * @param No
     * @param Bin_Code
     * @return lines wiout register in a specific lift
     * @throws SOAPFaultException
     */
    public static  WarehouseActivityLineWSList estanLineasEntradaRegistradas(String No, String Bin_Code)
            throws SOAPFaultException{
        //Buscar en NAV Pedidos Sin marcar de la lanzadera
        ArrayList<WarehouseActivityLineWSFilter> filtros1 = new ArrayList<>();
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f4.setCriteria("Put_away");
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
     * @return a list with no register lines in a ubication
     * @throws SOAPFaultException
     */
    public static WarehouseActivityLineWSList estanLineasEntradaRegistradas(String No)
            throws  SOAPFaultException{

        //listar todos los pedidos
        List<WarehouseActivityLineWSFilter> filtros1 = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f4.setCriteria("Put_away");
        filtros1.add(f4);
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.QTY_TO_HANDLE);
        f5.setCriteria(String.valueOf("=0"));
        filtros1.add(f5);
        WarehouseActivityLineWSFilter f6 = new WarehouseActivityLineWSFilter();
        f6.setField(WarehouseActivityLineWSFields.BIN_CODE);
        f6.setCriteria("PLNZ*");
        filtros1.add(f6);
        WarehouseActivityLineWSFilter f7 = new WarehouseActivityLineWSFilter();
        f7.setField(WarehouseActivityLineWSFields.NO);
        f7.setCriteria(No);
        filtros1.add(f7);
        return WebServicesInit.articulosPedidoService.readMultiple(filtros1, "", 0);
    }

    /**
     * Change the ubication line Bin Code to newBinCode
     * @param newBinCode
     * @param pedido
     * @param lineaPedido
     */
     public static void entradaCambiarUbicacion(String newBinCode, String pedido, int lineaPedido)
            throws SOAPFaultException{

        List<WarehouseActivityLineWSFilter> filtros1 = new ArrayList<WarehouseActivityLineWSFilter>();
        WarehouseActivityLineWSFilter f4 = new WarehouseActivityLineWSFilter();
        f4.setField(WarehouseActivityLineWSFields.ACTIVITY_TYPE);
        f4.setCriteria("Put_away");
        filtros1.add(f4);
        WarehouseActivityLineWSFilter f5 = new WarehouseActivityLineWSFilter();
        f5.setField(WarehouseActivityLineWSFields.NO);
        f5.setCriteria(pedido);
        filtros1.add(f5);
        WarehouseActivityLineWSFilter f6 = new WarehouseActivityLineWSFilter();
        f6.setField(WarehouseActivityLineWSFields.LINE_NO);
        f6.setCriteria(String.valueOf(lineaPedido));
        filtros1.add(f6);
        List<WarehouseActivityLineWS> lineasPedido = WebServicesInit.articulosPedidoService.readMultiple(filtros1, "", 1).getWarehouseActivityLineWS();
        //actualizar ubicacion del articulo
        WarehouseActivityLineWS lineaPedidoMod=lineasPedido.get(0);
        lineaPedidoMod.setBinCode(newBinCode);
        WebServicesInit.articulosPedidoService.update(new Holder<WarehouseActivityLineWS>(lineaPedidoMod));
    }

    /**
     * get ubication header
     * @param pedido
     * @return
     */
    public static WarehouseActivityHeaderWS obtenerPedido(String pedido){
        List<WarehouseActivityHeaderWSFilter> filtros = new ArrayList<WarehouseActivityHeaderWSFilter>();
        WarehouseActivityHeaderWSFilter f1 = new WarehouseActivityHeaderWSFilter();
        f1.setField(WarehouseActivityHeaderWSFields.NO);
        f1.setCriteria(pedido);
        filtros.add(f1);
        return WebServicesInit.PedidoService.readMultiple(filtros, "", 1).getWarehouseActivityHeaderWS().get(0);

    }

    /**
     * get ubicaciont lines
     * @param pedido
     * @param linea
     * @return
     */
    public static WarehouseActivityLineWS obtenerLineaPedido(String pedido,int linea){
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
        f3.setCriteria(String.valueOf(linea));
        filtros.add(f3);
        return WebServicesInit.articulosPedidoService.readMultiple(filtros, "", 1).getWarehouseActivityLineWS().get(0);
    }


}
