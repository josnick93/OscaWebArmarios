package org.oscasistemas.utils;

import com.dynamics.webServices.Bin_Content_WS.BinContentWS;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFields;
import com.dynamics.webServices.Bin_Content_WS.BinContentWSFilter;
import org.oscasistemas.controller.WebService.WebServicesInit;

import javax.xml.ws.Holder;
import javax.xml.ws.soap.SOAPFaultException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Portátil1 on 28/02/2018.
 */
public class PedidoUtils {

    /**
     * update put away content in a bin_code shelf
     * @param bin_code
     * @param item_no
     * @param cantidad
     * @throws SOAPFaultException
     */
    public static void updateBinContentLine(String bin_code, String item_no, int cantidad)
            throws SOAPFaultException{

        List<BinContentWSFilter> filtros = new ArrayList<BinContentWSFilter>();
        BinContentWSFilter f1 = new BinContentWSFilter();
        f1.setField(BinContentWSFields.LOCATION_CODE);
        f1.setCriteria("OSCA");
        filtros.add(f1);
        BinContentWSFilter f2 = new BinContentWSFilter();
        f2.setField(BinContentWSFields.ITEM_NO);
        f2.setCriteria(bin_code);
        filtros.add(f2);
        BinContentWSFilter f3 = new BinContentWSFilter();
        f3.setField(BinContentWSFields.ITEM_NO);
        f3.setCriteria(item_no);
        filtros.add(f3);
        BinContentWS myBinContentWS = WebServicesInit.contenidoUbicacionService.readMultiple(filtros, "", 0).getBinContentWS().get(0);
        myBinContentWS.setPutAwayQty(myBinContentWS.getPutAwayQty().add(BigInteger.valueOf(cantidad)));
        //actualizar en NAV
        WebServicesInit.contenidoUbicacionService.update(new Holder<BinContentWS>(myBinContentWS));
    }
}
