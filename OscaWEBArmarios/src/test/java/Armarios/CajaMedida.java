package Armarios;

import java.sql.*;

/**
 * Created by José Ángel Caudevílla Casaús on 06/10/2017.
 */
public class CajaMedida {



    @org.junit.Test
    public void crearHistorico() throws SQLException {

        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.2.2:3306/osca_localizacion","osca","osca");
            String insertTableSQL = "INSERT INTO cajas_entablado_medida"
                    + "(Codigo,fila,columna,Id_lanzadera,xPos,yPos,nfilas,ncolumnas,Articulo,Cantidad,Peso,esVacia,fechaCreacion,fechaActualizacion) VALUES"
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement= conn.prepareStatement(insertTableSQL);
            preparedStatement.setString(1,"PLNZ.08.0053");
            preparedStatement.setInt(2,4);
            preparedStatement.setInt(3,1);
            preparedStatement.setInt(4,8);
            preparedStatement.setDouble(5,1.1);
            preparedStatement.setDouble(6,1.1);
            preparedStatement.setInt(7,3);
            preparedStatement.setInt(8,3);
            preparedStatement.setString(9,"00.000.0110");
            preparedStatement.setDouble(10,100);
            preparedStatement.setDouble(11,0);
            preparedStatement.setByte(12,(byte)-1);
            preparedStatement.setDate(13,new Date((long)1000.0));
            preparedStatement.setDate(14,new Date((long)1000.0));
            preparedStatement.execute("SET foreign_key_checks = 0;");
            preparedStatement .executeUpdate();
            preparedStatement.execute("SET foreign_key_checks = 1;");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
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
