package org.oscasistemas.controller.Tareas.Entrada.SugerirUbicacion;

import com.dynamics.webServices.Item_Card_WS.ItemCardWS;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import org.oscasistemas.DAO.interfaces.*;
import org.oscasistemas.controller.WebService.WebServicesInit;
import org.oscasistemas.model.*;
import org.oscasistemas.service.interfaces.IArticuloService;
import org.oscasistemas.utils.Posiciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 21/12/2017.
 */
@RestController
public class TareaEntradaSugerirUbicacionFinal {

    @Autowired
    private IArticuloService articuloService;

    @Autowired
    private ILanzadera lanzaderaService;

    @Autowired (required = true)
    private ITipoCaja tipoCajaService;

    @Autowired (required = true)
    private IEntablado entabladoService;


    @Autowired
    private ICajaEntablado locationService;

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;
    //EntradaSugerirUbicacionfinal
    @RequestMapping(value="/TareaEntradaSugerirUbicacionFinal")
    public ModelAndView TareaEntradaSugerirUbicacionFinalPage(HttpServletRequest request,
                                                              @NotNull @RequestParam(value="articulo", required=false) String articulo,
                                                              @NotNull @RequestParam(value="lanzadera", required=false , defaultValue = "-1") int lanzadera,
                                                              @NotNull @RequestParam(value="cantidad", required=false  , defaultValue = "-1") int cantidad,
                                                              @NotNull @RequestParam(value="caja", required = false , defaultValue = "-1") int caja,
                                                              @NotNull @RequestParam(value="nsugerencia", required = false , defaultValue = "0") int nsugerencia,
                                                              @NotNull @RequestParam(value = "idTarea" ,required = true) int id_tarea) {
        ModelAndView m=new ModelAndView("Tarea/Entrada/SugerirUbicacion/TareaEntradaSugerirUbicacionFinal");
        ItemCardWS a= WebServicesInit.articulosService.read(articulo);

        TipoCaja c=tipoCajaService.getTipoCaja(caja);
          /*
         * Dir ip peticion
         */
        String remoteAddr = "";
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || "".equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

        //listar entablados que no superen el peso y no esten vacios
        //List<Entablado> posiblesEntablados=entabladoService.getEstanteriasNoSuperanPeso(l,a.getPeso()*cantidad,c);
        Lanzadera l=lanzaderaService.getLanzadera(lanzadera);
        List<Entablado> posiblesEntablados=null;
        List<CajaEntablado> ubicaciones =null;
        List<CajaEntabladoMedida> reservas=null;
        List<Posiciones> posiciones=null;
        List<Posiciones> posicionesSubdivision=null;
        posiblesEntablados = entabladoService.getEstanteriasNoSuperanPeso(l, 1 * cantidad, c);
        //List<Entablado> posiblesEntablados=entabladoService.getEstanterias();
        ubicaciones=locationService.getCajasEntablado(posiblesEntablados.get(nsugerencia));
        reservas = cajaEntabladoMedidaService.getCajasEntablado(posiblesEntablados.get(nsugerencia));
        //buscarPosiciones
        posiciones = null;
        posicionesSubdivision = new ArrayList<Posiciones>();
        if (c.getId_caja() == 10) {
            posicionesSubdivision = obtenerPosicionesSubdivision2x1(ubicaciones, c);
        } else if (c.getId_caja() == 11) {
            posicionesSubdivision = obtenerPosicionesSubdivision1x1(ubicaciones, c);
        }
        posiciones = obtenerPosiciones(ubicaciones, reservas, c);
        if (posicionesSubdivision.isEmpty() && posiciones.isEmpty()) {

            while ((posiciones = obtenerPosiciones(ubicaciones, reservas, c)).isEmpty()) {
                nsugerencia++;
                ubicaciones = locationService.getCajasEntablado(posiblesEntablados.get(nsugerencia));
                reservas = cajaEntabladoMedidaService.getCajasEntablado(posiblesEntablados.get(nsugerencia));
                if (c.getId_caja() == 10) {
                    posicionesSubdivision = obtenerPosicionesSubdivision2x1(ubicaciones, c);
                } else if (c.getId_caja() == 11) {
                    posicionesSubdivision = obtenerPosicionesSubdivision1x1(ubicaciones, c);
                }
            }
        }

        m.getModelMap().addAttribute("lanzadera",l);
        if(posiblesEntablados==null)  m.getModelMap().addAttribute("entablado",posiblesEntablados);
        else m.getModelMap().addAttribute("entablado",posiblesEntablados.get(nsugerencia));
        m.getModelMap().addAttribute("articulo",a);
        m.getModelMap().addAttribute("nsugerencia",nsugerencia);
        m.getModelMap().addAttribute("cantidad", cantidad);
        m.getModelMap().addAttribute("ubicaciones", ubicaciones);
        m.getModelMap().addAttribute("reservas", reservas);
        m.getModelMap().addAttribute("TipoCaja", c);
        m.getModelMap().addAttribute("posiblesPosiciones", new Gson().toJson(posiciones) );
        m.getModelMap().addAttribute("posiblesPosicionesSubdivision", new Gson().toJson(posicionesSubdivision) );
        m.getModelMap().addAttribute("id_tarea", id_tarea);

        return m;
    }



    /**
     * Deuelves las posibles subdivisiones de una caja 2x1
     */
    private List<Posiciones> obtenerPosicionesSubdivision2x1(List<CajaEntablado> cajas,TipoCaja tipoCaja){
        List<Posiciones> posiciones=new ArrayList<Posiciones>();
        Byte[][] entablado=new Byte[8][16];
        System.out.println("-------------------------------------------------------------------");
        for(int i=entablado.length-1;i>=0;i--)
            for (int j = 0; j < entablado[0].length; j++)
                entablado[i][j]=0;
        for(CajaEntablado c:cajas){
            System.out.println(c.toString());
            switch (c.getTipoCaja().getTipo_caja()){
                case "1x2_2x4":
                    //caja ocupada
                    entablado[c.getFila()][c.getColumna()-1]=0;
                    entablado[c.getFila()-1][c.getColumna()-1]=1;

                    if(entablado[c.getFila()+1][c.getColumna()-1] != 9) entablado[c.getFila()+1][c.getColumna()-1]=3;
                    if(entablado[c.getFila()-1][c.getColumna()] !=9) entablado[c.getFila()-1][c.getColumna()]=2;
                    if(entablado[c.getFila()+1][c.getColumna()] !=9) entablado[c.getFila()+1][c.getColumna()]=4;
                    break;
                case "1x2":
                    entablado[c.getFila()-1][c.getColumna()-1]=9;
                    entablado[c.getFila()-2][c.getColumna()-1]=9;
                    break;
                case "1x1_2x4":
                    //caja ocupada
                    //entablado[c.getFila()][c.getColumna()-1]=2;
                    entablado[c.getFila()-1][c.getColumna()-1]=9;
                    //posibles posiciones
                    if(entablado[c.getFila()][c.getColumna()-1]   <= 1) entablado[c.getFila()][c.getColumna()-1]=9;
                    if(entablado[c.getFila()+1][c.getColumna()-1] <= 1) entablado[c.getFila()+1][c.getColumna()-1]=9;
                    if(entablado[c.getFila()+2][c.getColumna()-1] <= 1) entablado[c.getFila()+2][c.getColumna()-1]=9;


                    if(entablado[c.getFila()-1][c.getColumna()] <= 1) entablado[c.getFila()-1][c.getColumna()]=9;
                    if(entablado[c.getFila()][c.getColumna()]   <= 1) entablado[c.getFila()][c.getColumna()]=9;
                    if(entablado[c.getFila()+1][c.getColumna()] <= 1) entablado[c.getFila()+1][c.getColumna()]=9;
                    if(entablado[c.getFila()+2][c.getColumna()] <= 1) entablado[c.getFila()+2][c.getColumna()]=9;
                    break;
                case "1x1":
                    entablado[c.getFila()-1][c.getColumna()-1]=9;
                    break;
            }

        }
        for(int i=entablado.length-1;i>=0;i--) {
            for (int j = 0; j < entablado[0].length; j++) {
                System.out.print(entablado[i][j]+"  ");
            }
            System.out.println();
        }
        for(int i=0;i< entablado.length;i++) {
            for (int j = 0; j < entablado[0].length; j++) {
                if (entablado[i][j] == 1) {
                    //posiciones.add(new Posiciones(i + 1, j + 1));
                    if (entablado[i][j+1] == 2) {
                        posiciones.add(new Posiciones(i + 1, j + 2));
                        entablado[i][j+1]=9;
                    }
                    if (entablado[i+2][j] == 3) {
                        posiciones.add(new Posiciones(i + 3, j + 1));
                        entablado[i+2][j]=9;
                    }
                    if (entablado[i+2][j+1] == 4) {
                        posiciones.add(new Posiciones(i + 3, j + 2));
                        entablado[i+2][j+1]=9;
                    }
                }
            }
        }
        for(Posiciones p:posiciones)
            System.out.println(p);
        System.out.println("-------------------------------------------------------------------");
        return posiciones;
    }



    /**
     * Deuelves las posibles subdivisiones de una caja 2x1
     */
    private List<Posiciones> obtenerPosicionesSubdivision1x1(List<CajaEntablado> cajas,TipoCaja tipoCaja){
        List<Posiciones> posiciones=new ArrayList<Posiciones>();
        Byte[][] entablado=new Byte[8][16];
        System.out.println("-------------------------------------------------------------------");
        for(int i=entablado.length-1;i>=0;i--)
            for (int j = 0; j < entablado[0].length; j++)
                entablado[i][j]=0;
        for(CajaEntablado c:cajas){
            switch (c.getTipoCaja().getTipo_caja()){
                case "1x1_2x4":
                    //caja ocupada
                    //entablado[c.getFila()][c.getColumna()-1]=2;
                    entablado[c.getFila()-1][c.getColumna()-1]=3;
                    //posibles posiciones
                    if(entablado[c.getFila()][c.getColumna()-1]   <= 1) entablado[c.getFila()][c.getColumna()-1]=1;
                    if(entablado[c.getFila()+1][c.getColumna()-1] <= 1) entablado[c.getFila()+1][c.getColumna()-1]=1;
                    if(entablado[c.getFila()+2][c.getColumna()-1] <= 1) entablado[c.getFila()+2][c.getColumna()-1]=1;


                    if(entablado[c.getFila()-1][c.getColumna()] <= 1) entablado[c.getFila()-1][c.getColumna()]=1;
                    if(entablado[c.getFila()][c.getColumna()]   <= 1) entablado[c.getFila()][c.getColumna()]=1;
                    if(entablado[c.getFila()+1][c.getColumna()] <= 1) entablado[c.getFila()+1][c.getColumna()]=1;
                    if(entablado[c.getFila()+2][c.getColumna()] <= 1) entablado[c.getFila()+2][c.getColumna()]=1;
                    break;
                case "1x1":
                    entablado[c.getFila()-1][c.getColumna()-1]=2;
                    break;
                case "1x2_2x4":
                    //caja ocupada
                    entablado[c.getFila()][c.getColumna()-1]=2;
                    entablado[c.getFila()-1][c.getColumna()-1]=2;
                    if(entablado[c.getFila()+1][c.getColumna()-1] <= 1) entablado[c.getFila()+1][c.getColumna()-1]=2;
                    if(entablado[c.getFila()-1][c.getColumna()] <= 1) entablado[c.getFila()-1][c.getColumna()]=2;
                    if(entablado[c.getFila()+1][c.getColumna()] <= 1) entablado[c.getFila()+1][c.getColumna()]=2;
                    break;
                case "1x2":
                    entablado[c.getFila()-1][c.getColumna()-1]=2;
                    entablado[c.getFila()-2][c.getColumna()-1]=2;
                    break;
            }

        }
        for(int i=entablado.length-1;i>=0;i--) {
            for (int j = 0; j < entablado[0].length; j++) {
                System.out.print(entablado[i][j]+"  ");
            }
            System.out.println();
        }
        for(int i=0;i< entablado.length;i++)
            for (int j = 0; j < entablado[0].length; j++)
                //if(entablado[i][j]==1) {
                //    posiciones.add(new Posiciones(i, j + 1));
                //}
                if(entablado[i][j]==3){
                    if(entablado[i][j+1]==1){
                        posiciones.add(new Posiciones(i, j + 2));
                        entablado[i][j+1]=2;
                    }if(entablado[i+1][j]==1){
                        posiciones.add(new Posiciones(i+1, j + 1));
                        entablado[i+1][j]=2;
                    }if(entablado[i+1][j+1]==1){
                        posiciones.add(new Posiciones(i+1, j + 2));
                        entablado[i+1][j+1]=2;
                    }if(entablado[i+2][j]==1){
                        posiciones.add(new Posiciones(i+2, j + 1));
                        entablado[i+2][j]=2;
                    }if(entablado[i+2][j+1]==1){
                        posiciones.add(new Posiciones(i+2, j + 2));
                        entablado[i+2][j+1]=2;
                    }if(entablado[i+3][j]==1){
                        posiciones.add(new Posiciones(i+3, j + 1));
                        entablado[i+3][j]=2;
                    }if(entablado[i+3][j+1]==1){
                        posiciones.add(new Posiciones(i+3, j + 2));
                        entablado[i+3][j+1]=2;
                    }
                }
        for(Posiciones p:posiciones)
            System.out.println(p);
        System.out.println("-------------------------------------------------------------------");
        return posiciones;
    }


    public static List<Posiciones> obtenerPosiciones(List<CajaEntablado> cajas, List<CajaEntabladoMedida> cajasMedida,TipoCaja tipoCaja){
        List<Posiciones> posiciones=new ArrayList<Posiciones>();
        Byte[][] entablado=new Byte[8][16];
        for(int i=entablado.length-1;i>=0;i--)
            for (int j = 0; j < entablado[0].length; j++)
                entablado[i][j]=0;
        for(CajaEntablado c:cajas){
            switch (c.getTipoCaja().getTipo_caja()){
                case "2x2":
                    entablado[c.getFila()-1][c.getColumna()-1]=1;
                    entablado[c.getFila()-1][c.getColumna()]=1;

                    entablado[c.getFila()-2][c.getColumna()-1]=1;
                    entablado[c.getFila()-2][c.getColumna()]=1;

                    break;
                case "2x4":
                    entablado[c.getFila()-1][c.getColumna()-1]=1;
                    entablado[c.getFila()-1][c.getColumna()]=1;


                    entablado[c.getFila()-2][c.getColumna()-1]=1;
                    entablado[c.getFila()-2][c.getColumna()]=1;

                    entablado[c.getFila()-3][c.getColumna()-1]=1;
                    entablado[c.getFila()-3][c.getColumna()]=1;

                    entablado[c.getFila()-4][c.getColumna()-1]=1;
                    entablado[c.getFila()-4][c.getColumna()]=1;



                    break;
                case "2x4 A":
                    entablado[c.getFila()-1][c.getColumna()-1]=1;
                    entablado[c.getFila()-1][c.getColumna()]=1;


                    entablado[c.getFila()-2][c.getColumna()-1]=1;
                    entablado[c.getFila()-2][c.getColumna()]=1;

                    entablado[c.getFila()-3][c.getColumna()-1]=1;
                    entablado[c.getFila()-3][c.getColumna()]=1;

                    entablado[c.getFila()-4][c.getColumna()-1]=1;
                    entablado[c.getFila()-4][c.getColumna()]=1;
                    break;
                case "4x4":
                    entablado[c.getFila()-1][c.getColumna()-1]=1;
                    entablado[c.getFila()-1][c.getColumna()]=1;
                    entablado[c.getFila()-1][c.getColumna()+1]=1;
                    entablado[c.getFila()-1][c.getColumna()+2]=1;

                    entablado[c.getFila()-2][c.getColumna()-1]=1;
                    entablado[c.getFila()-2][c.getColumna()]=1;
                    entablado[c.getFila()-2][c.getColumna()+1]=1;
                    entablado[c.getFila()-2][c.getColumna()+2]=1;

                    entablado[c.getFila()-3][c.getColumna()-1]=1;
                    entablado[c.getFila()-3][c.getColumna()]=1;
                    entablado[c.getFila()-3][c.getColumna()+1]=1;
                    entablado[c.getFila()-3][c.getColumna()+2]=1;

                    entablado[c.getFila()-4][c.getColumna()-1]=1;
                    entablado[c.getFila()-4][c.getColumna()]=1;
                    entablado[c.getFila()-4][c.getColumna()+1]=1;
                    entablado[c.getFila()-4][c.getColumna()+2]=1;
                    break;
                case "4x8":
                    entablado[c.getFila()-1][c.getColumna()-1]=1;
                    entablado[c.getFila()-1][c.getColumna()]=1;
                    entablado[c.getFila()-1][c.getColumna()+1]=1;
                    entablado[c.getFila()-1][c.getColumna()+2]=1;

                    entablado[c.getFila()-2][c.getColumna()-1]=1;
                    entablado[c.getFila()-2][c.getColumna()]=1;
                    entablado[c.getFila()-2][c.getColumna()+1]=1;
                    entablado[c.getFila()-2][c.getColumna()+2]=1;

                    entablado[c.getFila()-3][c.getColumna()-1]=1;
                    entablado[c.getFila()-3][c.getColumna()]=1;
                    entablado[c.getFila()-3][c.getColumna()+1]=1;
                    entablado[c.getFila()-3][c.getColumna()+2]=1;

                    entablado[c.getFila()-4][c.getColumna()-1]=1;
                    entablado[c.getFila()-4][c.getColumna()]=1;
                    entablado[c.getFila()-4][c.getColumna()+1]=1;
                    entablado[c.getFila()-4][c.getColumna()+2]=1;

                    entablado[c.getFila()-5][c.getColumna()-1]=1;
                    entablado[c.getFila()-5][c.getColumna()]=1;
                    entablado[c.getFila()-5][c.getColumna()+1]=1;
                    entablado[c.getFila()-5][c.getColumna()+2]=1;

                    entablado[c.getFila()-6][c.getColumna()-1]=1;
                    entablado[c.getFila()-6][c.getColumna()]=1;
                    entablado[c.getFila()-6][c.getColumna()+1]=1;
                    entablado[c.getFila()-6][c.getColumna()+2]=1;

                    entablado[c.getFila()-7][c.getColumna()-1]=1;
                    entablado[c.getFila()-7][c.getColumna()]=1;
                    entablado[c.getFila()-7][c.getColumna()+1]=1;
                    entablado[c.getFila()-7][c.getColumna()+2]=1;

                    entablado[c.getFila()-8][c.getColumna()-1]=1;
                    entablado[c.getFila()-8][c.getColumna()]=1;
                    entablado[c.getFila()-8][c.getColumna()+1]=1;
                    entablado[c.getFila()-8][c.getColumna()+2]=1;
                    break;
                case "Medio":
                    entablado[c.getFila()-1][c.getColumna()-1]=1;
                    entablado[c.getFila()-1][c.getColumna()]=1;
                    entablado[c.getFila()-1][c.getColumna()+1]=1;
                    entablado[c.getFila()-1][c.getColumna()+2]=1;
                    entablado[c.getFila()-1][c.getColumna()+3]=1;
                    entablado[c.getFila()-1][c.getColumna()+4]=1;
                    entablado[c.getFila()-1][c.getColumna()+5]=1;
                    entablado[c.getFila()-1][c.getColumna()+6]=1;

                    entablado[c.getFila()-2][c.getColumna()-1]=1;
                    entablado[c.getFila()-2][c.getColumna()]=1;
                    entablado[c.getFila()-2][c.getColumna()+1]=1;
                    entablado[c.getFila()-2][c.getColumna()+2]=1;
                    entablado[c.getFila()-2][c.getColumna()+3]=1;
                    entablado[c.getFila()-2][c.getColumna()+4]=1;
                    entablado[c.getFila()-2][c.getColumna()+5]=1;
                    entablado[c.getFila()-2][c.getColumna()+6]=1;

                    entablado[c.getFila()-3][c.getColumna()-1]=1;
                    entablado[c.getFila()-3][c.getColumna()]=1;
                    entablado[c.getFila()-3][c.getColumna()+1]=1;
                    entablado[c.getFila()-3][c.getColumna()+2]=1;
                    entablado[c.getFila()-3][c.getColumna()+3]=1;
                    entablado[c.getFila()-3][c.getColumna()+4]=1;
                    entablado[c.getFila()-3][c.getColumna()+5]=1;
                    entablado[c.getFila()-3][c.getColumna()+6]=1;

                    entablado[c.getFila()-4][c.getColumna()-1]=1;
                    entablado[c.getFila()-4][c.getColumna()]=1;
                    entablado[c.getFila()-4][c.getColumna()+1]=1;
                    entablado[c.getFila()-4][c.getColumna()+2]=1;
                    entablado[c.getFila()-4][c.getColumna()+3]=1;
                    entablado[c.getFila()-4][c.getColumna()+4]=1;
                    entablado[c.getFila()-4][c.getColumna()+5]=1;
                    entablado[c.getFila()-4][c.getColumna()+6]=1;


                    entablado[c.getFila()-5][c.getColumna()-1]=1;
                    entablado[c.getFila()-5][c.getColumna()]=1;
                    entablado[c.getFila()-5][c.getColumna()+1]=1;
                    entablado[c.getFila()-5][c.getColumna()+2]=1;
                    entablado[c.getFila()-5][c.getColumna()+3]=1;
                    entablado[c.getFila()-5][c.getColumna()+4]=1;
                    entablado[c.getFila()-5][c.getColumna()+5]=1;
                    entablado[c.getFila()-5][c.getColumna()+6]=1;

                    entablado[c.getFila()-6][c.getColumna()-1]=1;
                    entablado[c.getFila()-6][c.getColumna()]=1;
                    entablado[c.getFila()-6][c.getColumna()+1]=1;
                    entablado[c.getFila()-6][c.getColumna()+2]=1;
                    entablado[c.getFila()-6][c.getColumna()+3]=1;
                    entablado[c.getFila()-6][c.getColumna()+4]=1;
                    entablado[c.getFila()-6][c.getColumna()+5]=1;
                    entablado[c.getFila()-6][c.getColumna()+6]=1;

                    entablado[c.getFila()-7][c.getColumna()-1]=1;
                    entablado[c.getFila()-7][c.getColumna()]=1;
                    entablado[c.getFila()-7][c.getColumna()+1]=1;
                    entablado[c.getFila()-7][c.getColumna()+2]=1;
                    entablado[c.getFila()-7][c.getColumna()+3]=1;
                    entablado[c.getFila()-7][c.getColumna()+4]=1;
                    entablado[c.getFila()-7][c.getColumna()+5]=1;
                    entablado[c.getFila()-7][c.getColumna()+6]=1;

                    entablado[c.getFila()-8][c.getColumna()-1]=1;
                    entablado[c.getFila()-8][c.getColumna()]=1;
                    entablado[c.getFila()-8][c.getColumna()+1]=1;
                    entablado[c.getFila()-8][c.getColumna()+2]=1;
                    entablado[c.getFila()-8][c.getColumna()+3]=1;
                    entablado[c.getFila()-8][c.getColumna()+4]=1;
                    entablado[c.getFila()-8][c.getColumna()+5]=1;
                    entablado[c.getFila()-8][c.getColumna()+6]=1;
                    break;
                case "Completo":
                    for(int i=entablado.length-1;i>=0;i--)
                        for (int j = 0; j < entablado[0].length; j++)
                            entablado[i][j]=0;
                    break;
                case "1x1_2x4":
                    entablado[c.getFila()-1][c.getColumna()-1]=1;
                    entablado[c.getFila()-1][c.getColumna()]=1;

                    entablado[c.getFila()][c.getColumna()-1]=1;
                    entablado[c.getFila()][c.getColumna()]=1;

                    entablado[c.getFila()+1][c.getColumna()-1]=1;
                    entablado[c.getFila()+1][c.getColumna()]=1;

                    entablado[c.getFila()+2][c.getColumna()-1]=1;
                    entablado[c.getFila()+2][c.getColumna()]=1;
                    break;
                case "1x2_2x4":
                    entablado[c.getFila()-1][c.getColumna()-1]=1;
                    entablado[c.getFila()-1][c.getColumna()]=1;

                    entablado[c.getFila()][c.getColumna()-1]=1;
                    entablado[c.getFila()][c.getColumna()]=1;

                    entablado[c.getFila()+1][c.getColumna()-1]=1;
                    entablado[c.getFila()+1][c.getColumna()]=1;

                    entablado[c.getFila()+2][c.getColumna()-1]=1;
                    entablado[c.getFila()+2][c.getColumna()]=1;
                    break;
            }

        }
        //posiciones cajas a medida
        for(CajaEntabladoMedida c:cajasMedida){

            for(int i=(c.getFila()-c.getNfilas());i<(c.getNfilas());i++) {
                for (int j = (c.getColumna()-1); j < (c.getColumna() + c.getNcolumnas()-1); j++) {
                    entablado[i][j]=2;
                }
            }
        }
        for(int i=entablado.length-1;i>=0;i--) {
            for (int j = 0; j < entablado[0].length; j++) {
                System.out.print(entablado[i][j]+"  ");
            }
            System.out.println();
        }
        for(int i=0;i< entablado.length;i++) {
            for (int j = 0; j < entablado[0].length; j++) {
                if(entablado[i][j]==0) {
                    boolean vacia=false;
                    switch (tipoCaja.getTipo_caja()){
                        case "2x2":
                            if(i+2 <= entablado.length && j+2 <= entablado[0].length) {
                                boolean vacias = false;
                                for (int x = i; x < (i + 2 - 1) && !vacias; x++)
                                    for (int y = j; y <= (j + 2 - 1); y++)
                                        if (x > entablado.length || y > entablado[0].length || entablado[x][y] != 0)
                                            vacias = true;
                                if (!vacias) {
                                    posiciones.add(new Posiciones(((i + 1)), (j)));
                                }
                            }
                            break;
                        case "2x4":
                            if(i+4 <= entablado.length && j+2 <= entablado[0].length){
                                boolean vacias=false;
                                for(int x=i;x < (i+4) && !vacias ;x++)
                                    for (int y = j; y <= (j+2-1); y++)
                                        if(x > entablado.length || y > entablado[0].length || entablado[x][y]!=0)
                                            vacias=true;
                                if(!vacias) {
                                    posiciones.add(new Posiciones(((i + 1)), (j)));
                                }
                            }
                            break;
                        case "1x2_2x4":
                            if(i+4 <= entablado.length && j+2 <= entablado[0].length){
                                boolean vacias=false;
                                for(int x=i;x < (i+4) && !vacias ;x++)
                                    for (int y = j; y <= (j+2-1); y++)
                                        if(x > entablado.length || y > entablado[0].length || entablado[x][y]!=0)
                                            vacias=true;
                                if(!vacias) {
                                    posiciones.add(new Posiciones(((i + 1)), (j)));
                                }
                            }
                            break;
                        case "1x1_2x4":
                            if(i+4 <= entablado.length && j+2 <= entablado[0].length){
                                boolean vacias=false;
                                for(int x=i;x < (i+4) && !vacias ;x++)
                                    for (int y = j; y <= (j+2-1); y++)
                                        if(x > entablado.length || y > entablado[0].length || entablado[x][y]!=0)
                                            vacias=true;
                                if(!vacias) {
                                    posiciones.add(new Posiciones(((i + 1)), (j)));
                                }
                            }
                            break;
                        case "2x4 A":
                            if(i+4 <= entablado.length && j+2 <= entablado[0].length){
                                boolean vacias=false;
                                for(int x=i;x < (i+4) && !vacias ;x++)
                                    for (int y = j; y <= (j+2-1); y++)
                                        if(x > entablado.length || y > entablado[0].length || entablado[x][y]!=0)
                                            vacias=true;
                                if(!vacias) {
                                    posiciones.add(new Posiciones(((i + 1)), (j)));
                                }
                            }
                            break;
                        case "4x4":
                            if(i+4 <= entablado.length && j+4 <= entablado[0].length){
                                boolean vacias=false;
                                for(int x=i;x < (i+4) && !vacias ;x++)
                                    for (int y = j; y <= (j+4-1); y++)
                                        if(x > entablado.length || y > entablado[0].length || entablado[x][y]!=0)
                                            vacias=true;
                                if(!vacias) {
                                    posiciones.add(new Posiciones(((i + 1)), (j)));
                                }
                            }
                            break;
                        case "4x8":
                            if(i+8 <= entablado.length && j+4 <= entablado[0].length){
                                boolean vacias=false;
                                for(int x=i;x < (i+7) && !vacias ;x++)
                                    for (int y = j; y <= (j+4-1); y++)
                                        if(x > entablado.length || y > entablado[0].length || entablado[x][y]!=0)
                                            vacias=true;
                                if(!vacias) {
                                    posiciones.add(new Posiciones(((i + 1)), (j)));
                                }
                            }
                            break;
                        case "Medio":
                            boolean cabe=true;
                            if(j+3>=entablado[0].length || i!=0)
                                cabe=false;
                            else {
                                for (int iMed = 0; iMed < entablado.length; iMed++)
                                    for (int jMed = j; jMed < j + 4 ; jMed++)
                                        if (entablado[iMed][jMed] == 1)
                                            cabe = false;
                            }
                            if(cabe) {
                                posiciones.add(new Posiciones(((i + 1)), (j)));
                            }
                            break;
                        case "Completo":
                            boolean cabec=true;
                            if(i==0 && j==0) {
                                for (int iMed = 0; iMed < entablado.length; iMed++)
                                    for (int jMed = 0; jMed < entablado[0].length; jMed++)
                                        if (entablado[iMed][jMed] == 1)
                                            cabec = false;
                                if (cabec) {
                                    posiciones.add(new Posiciones(((i + 1)) , (j)));
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        for(Posiciones p:posiciones)
            System.out.println(p);
        return posiciones;
    }


}
