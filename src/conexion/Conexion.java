package conexion;

import java.sql.*;

/**
 *
 * @author caill
 */
public class Conexion {

    public static Connection conectar() {
        Connection cn = null; // Inicializamos la variable aquí para poder devolverla en cualquier caso
        try {
            cn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bd_registroLibros?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "admin"
            );
        } catch (SQLException e) {
            System.out.println("Error en la conexión local: " + e);
        }
        return cn; // Devolvemos la conexión (o null si ocurrió un error)
    }

}
