package co.edu.poli.ejemplo.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.ejemplo.modelo.Producto;

public class DAOProducto implements CRUD<Producto>{

    private Connection connection;

    public DAOProducto() {
        try {
            this.connection = Singleton.getConnection();
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }
    }

    @Override
    public String create(Producto p) {
        // Primero, verificamos si ya existe un producto con el mismo ID
        String checkSql = "SELECT * FROM productos WHERE id = ?";
        try (PreparedStatement checkStmt = connection.prepareStatement(checkSql)) {
            checkStmt.setString(1, p.getId());
            try (ResultSet rs = checkStmt.executeQuery()) {
                // Si ya existe un producto con ese ID
                if (rs.next()) {
                    return "Error: Ya existe un producto con el ID " + p.getId();
                }
            }
        } catch (Exception e) {
           return "Error de base de datos: " + e.getMessage();
        }
    
        // Si no existe el producto, procedemos a insertarlo
        String sql = "INSERT INTO productos (id, descripcion, precio) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, p.getId());
            stmt.setString(2, p.getDescripcion());
            stmt.setDouble(3, p.getPrecio());
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return "Producto creado exitosamente";
            } else {
                return "Error al crear producto";
            }
        } catch (Exception e) {
           return "Error de base de datos: " + e.getMessage();
        }
    }
    

    @Override
    public List<Producto> readAll() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getString("id"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getDouble("precio"));
                productos.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }
        return productos;
    }

    @Override
    public Producto read(String id) {
        Producto producto = null;
        String sql = "SELECT * FROM productos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = new Producto();
                    producto.setId(rs.getString("id"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setPrecio(rs.getDouble("precio"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error de base de datos: " + e.getMessage());
            return null;
        }
        return producto;
    }

    @Override
    public String update(String id, Producto p) {
        String sql = "UPDATE productos SET descripcion = ?, precio = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, p.getDescripcion());
            stmt.setDouble(2, p.getPrecio());
            stmt.setString(3, id);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return "Producto actualizado exitosamente";
            } else {
                return "Error al actualizar producto";
            }
        } catch (Exception e) {
            return "Error de base de datos: " + e.getMessage();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Producto eliminado exitosamente");
            } else {
                System.out.println("Error al eliminar producto");
            }
        } catch (Exception e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }
    }
}
