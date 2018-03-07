package Armarios;

import org.hibernate.SessionFactory;
import org.oscasistemas.DAO.interfaces.*;
import org.oscasistemas.model.CajaEntablado;
import org.oscasistemas.model.Entablado;
import org.oscasistemas.model.TipoCaja;
import org.oscasistemas.service.interfaces.IArticuloService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.Calendar;

/**
 * Created by José Ángel Caudevílla Casaús on 03/10/2017.
 */
public class CrearUbicacion {

    @Autowired(required = true)
    private IEntablado entabladoService;
    @Autowired
    private ICajaEntablado locationService;

    @Autowired
    private ICajaEntabladoMedida cajaEntabladoMedidaService;

    @Autowired
    private IArticuloService articuloService;

    @Autowired
    private IAcessoLazaderas acessoLazaderasService;

    @Autowired (required = true)
    private ITipoCaja tipoCajaService;

    @Autowired
    private ILanzadera lanzaderaService;

    @Autowired
    private IHistorico historicoService;

    @Autowired
    private IAdministrador administradorService;

    @Autowired
    private IAcciones accionesService;

    @Autowired
    private ITareasPendientes tareasPendientesService;

    @Autowired
    private SessionFactory sessionFactory;

    @org.junit.Test
    public void crearUbicacion() throws SQLException {

        Entablado e=new Entablado();
        e.setCodigo("PLNZ.01.0003");
        TipoCaja c=new TipoCaja();
        c.setId_caja(7);
        //ItemCardWS a= WebServicesInit.articulosService.read("00.000.0090");
        CajaEntablado ubicacion= new CajaEntablado();
        ubicacion.setColumna(1);
        ubicacion.setFila(1);
        ubicacion.setEntablado(e);
        ubicacion.setLanzadera(e.getLanzadera());
        ubicacion.setxPos(1.1);
        ubicacion.setyPos(71.6);
        ubicacion.setTipoCaja(c);
        ubicacion.setArticulo("00.000.0090");
        ubicacion.setCantidad(2);
        //l.setPeso(l.getPeso() + (Integer.valueOf(a.getNetWeight().toString()) * cantidad));
        ubicacion.setPeso(0.0);
        ubicacion.setEsVacia((byte)-1);
        ubicacion.setFechaCreacion(new Date(Calendar.getInstance().getTimeInMillis()));
        ubicacion.setFechaActualizacion(new Date(Calendar.getInstance().getTimeInMillis()));
        ubicacion.setTs(new Timestamp(Calendar.getInstance().getTimeInMillis()));



        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.2.2:3306/osca_localizacion","osca","osca");
            // String insertTableSQL = "INSERT INTO cajas_entablado"
            //        + "(Id_lanzadera, codigo, fila, columna,xPos,yPos,Articulo,Id_caja,Cantidad,Peso,esVacia,esReservado,fechaCreacion,fechaActualizacion) VALUES"
            //        + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            String insertTableSQL = "INSERT INTO cajas_entablado"
                    + "(columna,fila,Codigo,Id_lanzadera,xPos,yPos,Id_caja,Articulo,Cantidad,Peso,esVacia,fechaCreacion,fechaActualizacion) VALUES"
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement= conn.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1,ubicacion.getColumna());
            preparedStatement.setInt(2,ubicacion.getFila());
            preparedStatement.setString(3,ubicacion.getEntablado().getCodigo());
            preparedStatement.setInt(4,1);
            preparedStatement.setDouble(5,ubicacion.getxPos());
            preparedStatement.setDouble(6,ubicacion.getyPos());
            preparedStatement.setInt(7,ubicacion.getTipoCaja().getId_caja());
            preparedStatement.setString(8,ubicacion.getArticulo());
            preparedStatement.setInt(9,ubicacion.getCantidad());
            preparedStatement.setDouble(10,ubicacion.getPeso());
            preparedStatement.setDouble(9,ubicacion.getCantidad());
            preparedStatement.setDouble(10,ubicacion.getPeso());
            preparedStatement.setByte(11,ubicacion.getEsVacia());
            preparedStatement.setDate(12,ubicacion.getFechaCreacion());
            preparedStatement.setDate(13,ubicacion.getFechaActualizacion());
            preparedStatement.execute("SET foreign_key_checks = 0;");
            preparedStatement .executeUpdate();
            preparedStatement.execute("SET foreign_key_checks = 1;");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
