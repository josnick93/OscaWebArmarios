package Armarios;

import java.sql.*;

/**
 * Created by José Ángel Caudevílla Casaús on 06/10/2017.
 */
public class CrearHistorial {


    @org.junit.Test
    public void crearHistorico() throws SQLException {

        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.2.2:3306/osca_localizacion", "osca", "osca");
            String insertTableSQL = "INSERT INTO historico"
                    + "(Id_lanzadera, Codigo,Id_tipoMovimiento,usuario, fila, columna,Articulo,Cantidad,fecha) VALUES"
                    + "(?,?,?,?,?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, 8);
            preparedStatement.setString(2, "PLNZ.08.0006");
            preparedStatement.setInt(3, 3);
            preparedStatement.setString(4, "");
            preparedStatement.setInt(5, 1);
            preparedStatement.setInt(6, 1);
            preparedStatement.setString(7, "00.000.0110");
            preparedStatement.setDouble(8, 100);
            preparedStatement.setTimestamp(9, new Timestamp((long)1000000.0));
            preparedStatement.execute("SET foreign_key_checks = 0;");
            preparedStatement.executeUpdate();
            preparedStatement.execute("SET foreign_key_checks = 1;");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

}
