package conexioncompany;

import java.math.BigDecimal;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConexionCompany {

    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        Statement stmt2 = null;
        ResultSet rs = null;
        try {
            String connectionStr = "jdbc:mysql://127.0.0.1:3306/company?user=myslqMF&password=abc123.";
            connection = DriverManager.getConnection(connectionStr);
            // Ejemplo de consulta que devuelve algo
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT empno, ename from emp");
            while (rs.next()) {
                int x = rs.getInt("empno");
                String s = rs.getString("ename");
                System.out.println(x + " " + s);
            }

            //Ejemplo de consulta que no devuelve nada

            stmt2 = connection.createStatement();

            int n =stmt2.executeUpdate("UPDATE emp SET job = 'SALESMAN' where job like 'CLERK' ");

            System.out.println("Actualizadas " + n + " filas");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if ( stmt2 != null ){
                    stmt2.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
