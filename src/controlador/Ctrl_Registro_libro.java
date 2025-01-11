package controlador;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
import conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import modelo.Libro;

/**
 *
 * @author caill
 */
public class Ctrl_Registro_libro {

    public boolean guardar(Libro objeto) {
        boolean respuesta = false;
        Connection cn = null;
        try {
            cn = Conexion.conectar();
            String query = "INSERT INTO tb_libros (titulo, autor, genero, editorial, fecha, numero_paginas) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement consulta = cn.prepareStatement(query);
            consulta.setString(1, objeto.getTitulo());
            consulta.setString(2, objeto.getAutor());
            consulta.setString(3, objeto.getGenero());
            consulta.setString(4, objeto.getEditorial());

            // Convertir de java.util.Date a java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(objeto.getFecha().getTime());
            consulta.setDate(5, sqlDate);  // Asignar la fecha al PreparedStatement

            consulta.setInt(6, objeto.getNumeroPaginas());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al guardar libro: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return respuesta;
    }

    public boolean actualizar(Libro libro, int idLibro) {
        boolean respuesta = false;
        Connection cn = null;
        try {
            cn = Conexion.conectar();

            String query = "UPDATE tb_libros SET "
                    + "titulo = ?, "
                    + "autor = ?, "
                    + "genero = ?, "
                    + "editorial = ?, "
                    + "fecha = ?, "
                    + "numero_paginas = ? "
                    + "WHERE id_libro = ?";

            PreparedStatement consulta = cn.prepareStatement(query);

            // Establece los valores de los parámetros de la consulta
            consulta.setString(1, libro.getTitulo());
            consulta.setString(2, libro.getAutor());
            consulta.setString(3, libro.getGenero());
            consulta.setString(4, libro.getEditorial());
            consulta.setDate(5, new java.sql.Date(libro.getFecha().getTime())); // Si la fecha es de tipo Date
            consulta.setInt(6, libro.getNumeroPaginas());
            consulta.setInt(7, libro.getIdLibro()); // Asegúrate de tener el id_libro para el WHERE

            // Ejecuta la actualización
            if (consulta.executeUpdate() > 0) {
                respuesta = true; // Si la actualización fue exitosa
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return respuesta;
    }

    public boolean eliminar(int idLibro) {
        boolean respuesta = false;
        Connection cn = null;

        try {
            cn = (Connection) conexion.Conexion.conectar();
            String query = "DELETE FROM tb_libros WHERE id_libro = ?";

            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement(query);
            consulta.setInt(1, idLibro);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar libro" + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión" + e.getMessage());
            }
        }
        return respuesta;
    }

    public Libro buscar(String titulo) {
        Libro libro = null;
        Connection cn = null;

        try {

            cn = (Connection) conexion.Conexion.conectar();
            String query = "SELECT * FROM tb_libros WHERE titulo = ?";

            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement(query);
            consulta.setString(1, titulo);

            ResultSet rs = consulta.executeQuery();
            if (rs.next()) {
                libro = new Libro();
                libro.setIdLibro(rs.getInt("id_libro"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setGenero(rs.getString("genero"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setFecha(rs.getDate("fecha"));
                libro.setNumeroPaginas(rs.getInt("numero_paginas"));
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar libro por titulo" + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión" + e.getMessage());
            }
        }
        return libro;
    }

    public boolean existeLibro(String titulo) {
        boolean respuesta = false;
        String query = "SELECT titulo FROM tb_libros WHERE titulo = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement pst = cn.prepareStatement(query)) {
            pst.setString(1, titulo);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar libro" + e.getMessage());
        }
        return respuesta;
    }

    public ArrayList<Libro> BuscarPorTitulo(String titulo) {
        ArrayList<Libro> listaLibros = new ArrayList<>();
        String sql = "SELECT * FROM tb_libros WHERE 1=1";

        if (titulo != null && !titulo.isEmpty()) {
            sql += " AND titulo LIKE ?"; // Aquí se agrega un espacio antes de "AND"
        }

        try (Connection cn = Conexion.conectar(); PreparedStatement pst = cn.prepareStatement(sql)) {
            int index = 1;

            // Asignar el parámetro del título si se proporciona
            if (titulo != null && !titulo.isEmpty()) {
                pst.setString(index++, "%" + titulo + "%");
            }

            // Ejecutar la consulta y procesar los datos
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Libro libro = new Libro();
                    libro.setIdLibro(rs.getInt("id_libro"));
                    libro.setTitulo(rs.getString("titulo"));
                    libro.setAutor(rs.getString("autor"));
                    libro.setGenero(rs.getString("genero"));
                    libro.setEditorial(rs.getString("editorial"));
                    libro.setFecha(rs.getDate("fecha"));
                    libro.setNumeroPaginas(rs.getInt("numero_paginas"));

                    listaLibros.add(libro);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar el título del libro: " + e.getMessage());
        }
        return listaLibros;
    }

}
