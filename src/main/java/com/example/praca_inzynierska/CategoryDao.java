package com.example.praca_inzynierska;

import com.example.praca_inzynierska.DataSourceProvider;
import com.example.praca_inzynierska.BaseDao;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;

public class CategoryDao extends BaseDao  {

    public List<Category> findAll() {
        final String query = """
                SELECT
                    id, name
                FROM
                    category
                """;
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<Category> allCategories = new ArrayList<>();
            while (resultSet.next()) {
                Category category = mapRow(resultSet);
                allCategories.add(category);
            }
            return allCategories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Category> findById(int categoryId) {
        final String query = """
                SELECT
                    id, name
                FROM
                    category
                WHERE
                    id = ?
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, categoryId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Category category = mapRow(resultSet);
                return Optional.of(category);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Category mapRow(ResultSet set) throws SQLException {
        int id = set.getInt("id");
        String name = set.getString("name");
        return new Category(id, name);
    }
}