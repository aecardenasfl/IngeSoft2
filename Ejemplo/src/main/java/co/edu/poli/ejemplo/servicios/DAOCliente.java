package co.edu.poli.ejemplo.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.ejemplo.modelo.Cliente;

public class DAOCliente implements CRUD {

    private Connection connection;

    public DAOCliente() {
        try {
            this.connection = Singleton.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String createCliente(Cliente c) {
        String sql = "INSERT INTO clientes (id, nombre) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, c.getId());
            stmt.setString(2, c.getNombre());
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return "Cliente creado exitosamente";
            } else {
                return "Error al crear cliente";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error de base de datos: " + e.getMessage();
        }
    }

    @Override
    public List<Cliente> readAllCliente() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getString("id"));
                c.setNombre(rs.getString("nombre"));
                clientes.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public Cliente readCliente(String id) {
        Cliente cliente = null;
        String sql = "SELECT * FROM clientes WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setId(rs.getString("id"));
                    cliente.setNombre(rs.getString("nombre"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public String updateCliente(String id, Cliente c) {
        String sql = "UPDATE clientes SET nombre = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, c.getNombre());
            stmt.setString(2, id);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return "Cliente actualizado exitosamente";
            } else {
                return "Error al actualizar cliente";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error de base de datos: " + e.getMessage();
        }
    }

    @Override
    public void deleteCliente(String id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cliente eliminado exitosamente");
            } else {
                System.out.println("Error al eliminar cliente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
