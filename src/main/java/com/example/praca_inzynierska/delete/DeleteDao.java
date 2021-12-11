package com.example.praca_inzynierska.delete;

import com.example.praca_inzynierska.configuration.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteDao extends BaseDao {


    public void deleteVote() {
        final String query = """
                    delete from vote
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEvent() {
        final String query = """
                    delete from event
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deletePoints() {
        final String query = """
                    update user set points = 0
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUsers_Role() {
        final String query = """
                    delete from user_role where username != 'admin';
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUsers() {
        final String query = """
                    delete from user where id != 12;
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}