import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Agenda;encrypt=false";
    private static final String USUARIO = "sa";
    private static final String CONTRASEÑA = "sa";
    private static Connection conexion = null;

    private DatabaseConnection() {}

    public static Connection obtenerConexion() {
        if (conexion == null || isConnectionClosed()) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
                System.out.println("Conexión establecida.");
            } catch (ClassNotFoundException e) {
                System.err.println("No se encontró el controlador JDBC: " + e.getMessage());
                e.printStackTrace();
                conexion = null;
            } catch (SQLException e) {
                e.printStackTrace();
                conexion = null;
            }
        }
        return conexion;
    }

    private static boolean isConnectionClosed() {
        try {
            return conexion == null || conexion.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                conexion = null;
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
