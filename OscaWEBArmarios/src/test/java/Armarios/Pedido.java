package Armarios;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.oscasistemas.service.interfaces.IPedidoEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by José Ángel Caudevílla Casaús on 06/11/2017.
 */

@ContextConfiguration
public class Pedido {


    @Autowired
    private IPedidoEntradaService pedidoentradaService;


    @org.junit.Test
    public void readTest(){

       pedidoentradaService.getLanzaderasPedido("UA000008");

        Assert.assertTrue(true);



    }
}
