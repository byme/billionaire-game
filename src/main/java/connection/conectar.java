package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conectar {

    private Connection conexion;
    private PreparedStatement stm = null;
    private ResultSet rs;

    public static void main(String[] args) {

        conectar obcconexion = new conectar();

        obcconexion.conectar();

    }

    public conectar conectar() {
        try {
            Class.forName("org.postgresql.Driver");
//
            String BaseDeDatos = "jdbc:postgresql://money-database.postgres.database.azure.com:5432/" +
                    "postgres?user=sofka@money-database&password=Ubuntu123&sslmode=require";
            conexion = (Connection) DriverManager.getConnection(BaseDeDatos);

//            jdbc:postgresql://<host>:<port>/<dbname>?sslmode=require&user=<username>&password=<password>
            if (conexion != null) {
                System.out.println("conexión exitosa con la base de datos");
            } else {
                System.out.println("conexion fallo");
            }
        } catch (Exception e) {

            System.out.println("Error conectando: " + e.getMessage());
        }
        return this;

    }

    public void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error desconectando: " + ex.getMessage());
        }
    }

    public Connection getConexion() {
        return this.conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}
