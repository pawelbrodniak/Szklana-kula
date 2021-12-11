package com.example.praca_inzynierska.classification;

import com.example.praca_inzynierska.configuration.BaseDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClassificationDao extends BaseDao  {

    public List<Classification> findAll() {
        final String query = """
                select id, username, points from user where 
                id != 12 order by points desc
                """;
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<Classification> allClassifications = new ArrayList<>();
            while (resultSet.next()) {
                Classification classification = mapRow(resultSet);
                allClassifications.add(classification);
            }
            return allClassifications;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    private static Classification mapRow(ResultSet set) throws SQLException {
        int id = set.getInt("id");
        String name = set.getString("username");
        int points = set.getInt("points");
        return new Classification(id, name, points);
    }
}