import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgendaCRUD {

    // Métodos de inserción

    public void insertCategoria(String categoria, String descripcion) {
        String sql = "INSERT INTO categorias (Categoria, Descripcion) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, categoria);
            pstmt.setString(2, descripcion);
            pstmt.executeUpdate();
            System.out.println("Categoría insertada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertProvincia(int provincia, String nombreProvincia) {
        String sql = "INSERT INTO provincias (Provincia, NombreProvincia) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, provincia);
            pstmt.setString(2, nombreProvincia);
            pstmt.executeUpdate();
            System.out.println("Provincia insertada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertContacto(String nombre, String apellidos, String dni, String telefono, String ecorreo, String fechacumple, String direccion, String poblacion, int provincia, String codigoPostal, String categoria, int deuda) {
        String sql = "INSERT INTO contactos (Nombre, Apellidos, DNI, Telefono, Ecorreo, Fechacumple, Direccion, Poblacion, Provincia, CodigoPostal, Categoria, Deuda) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, dni);
            pstmt.setString(4, telefono);
            pstmt.setString(5, ecorreo);
            pstmt.setString(6, fechacumple);
            pstmt.setString(7, direccion);
            pstmt.setString(8, poblacion);
            pstmt.setInt(9, provincia);
            pstmt.setString(10, codigoPostal);
            pstmt.setString(11, categoria);
            pstmt.setInt(12, deuda);
            pstmt.executeUpdate();
            System.out.println("Contacto insertado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métodos de lectura

    public void readCategorias() {
        String sql = "SELECT * FROM categorias";
        try (Connection conn = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Categoria: " + rs.getString("Categoria") + ", Descripcion: " + rs.getString("Descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readProvincias() {
        String sql = "SELECT * FROM provincias";
        try (Connection conn = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Provincia: " + rs.getInt("Provincia") + ", NombreProvincia: " + rs.getString("NombreProvincia"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readContactos() {
        String sql = "SELECT * FROM contactos";
        try (Connection conn = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id_contacto") + ", Nombre: " + rs.getString("Nombre") + ", Apellidos: " + rs.getString("Apellidos") + ", DNI: " + rs.getString("DNI") + ", Telefono: " + rs.getString("Telefono") + ", Ecorreo: " + rs.getString("Ecorreo") + ", FechaCumple: " + rs.getDate("Fechacumple") + ", Direccion: " + rs.getString("Direccion") + ", Poblacion: " + rs.getString("Poblacion") + ", Provincia: " + rs.getInt("Provincia") + ", CodigoPostal: " + rs.getString("CodigoPostal") + ", Categoria: " + rs.getString("Categoria") + ", Deuda: " + rs.getInt("Deuda"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métodos de actualización

    public void updateCategoria(String categoria, String descripcion) {
        String sql = "UPDATE categorias SET Descripcion = ? WHERE Categoria = ?";
        try (Connection conn = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, descripcion);
            pstmt.setString(2, categoria);
            pstmt.executeUpdate();
            System.out.println("Categoría actualizada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProvincia(int provincia, String nombreProvincia) {
        String sql = "UPDATE provincias SET NombreProvincia = ? WHERE Provincia = ?";
        try (Connection conn = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreProvincia);
            pstmt.setInt(2, provincia);
            pstmt.executeUpdate();
            System.out.println("Provincia actualizada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateContacto(int idContacto, String nombre, String apellidos, String dni, String telefono, String ecorreo, String fechacumple, String direccion, String poblacion, int provincia, String codigoPostal, String categoria, int deuda) {
        String sql = "UPDATE contactos SET Nombre = ?, Apellidos = ?, DNI = ?, Telefono = ?, Ecorreo = ?, Fechacumple = ?, Direccion = ?, Poblacion = ?, Provincia = ?, CodigoPostal = ?, Categoria = ?, Deuda = ? WHERE Id_contacto = ?";
        try (Connection conn = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, dni);
            pstmt.setString(4, telefono);
            pstmt.setString(5, ecorreo);
            pstmt.setString(6, fechacumple);
            pstmt.setString(7, direccion);
            pstmt.setString(8, poblacion);
            pstmt.setInt(9, provincia);
            pstmt.setString(10, codigoPostal);
            pstmt.setString(11, categoria);
            pstmt.setInt(12, deuda);
            pstmt.setInt(13, idContacto);
            pstmt.executeUpdate();
            System.out.println("Contacto actualizado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métodos de eliminación

    public void deleteCategoria(String categoria) {
        String sql = "DELETE FROM categorias WHERE Categoria = ?";
        try (Connection conn = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, categoria);
            pstmt.executeUpdate();
            System.out.println("Categoría eliminada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProvincia(int provincia) {
        String sql = "DELETE FROM provincias WHERE Provincia = ?";
        try (Connection conn = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, provincia);
            pstmt.executeUpdate();
            System.out.println("Provincia eliminada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteContacto(int idContacto) {
        String sql = "DELETE FROM contactos WHERE Id_contacto = ?";
        try (Connection conn = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idContacto);
            pstmt.executeUpdate();
            System.out.println("Contacto eliminado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
