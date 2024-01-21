package org.example.dao;

import org.example.db.Database;
import org.example.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    public long create(String name) {
        validateName(name);

        String sql = "INSERT INTO clients (name) VALUES (?)";
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, name);
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating client failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to create client", e);
        }
    }

    public String getById(long id) {
        validateClientId(id);

        String sql = "SELECT name FROM clients WHERE id = ?";
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() ? resultSet.getString("name") : null;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to get client by ID", e);
        }
    }

    public void setName(long id, String name) {
        validateClientId(id);
        validateName(name);

        String sql = "UPDATE clients SET name = ? WHERE id = ?";
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setLong(2, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to update client name", e);
        }
    }

    public void deleteById(long id) {
        validateClientId(id);

        String sql = "DELETE FROM clients WHERE id = ?";
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete client by ID", e);
        }
    }

    public List<Client> listAll() {
        List<Client> result = new ArrayList<>();

        String sql = "SELECT * FROM clients";
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                result.add(new Client(id, name));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to list all clients", e);
        }

        return result;
    }

    private void validateName(String name) {
        if (name == null || name.length() < 2 || name.length() > 100) {
            throw new IllegalArgumentException("Invalid name");
        }
    }

    private void validateClientId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid client ID");
        }
    }
}