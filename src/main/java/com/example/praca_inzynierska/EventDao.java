package com.example.praca_inzynierska;

import com.example.praca_inzynierska.DataSourceProvider;
import com.example.praca_inzynierska.BaseDao;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class EventDao extends BaseDao {



    public List<Event> findAll() {
        final String query = """
                SELECT
                    id, teamA, teamB, rate,  date_added, category_id, user_id
                FROM
                    event d where id != all (select event_id from vote where user_id = 12) order by date_added desc
                """;
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<Event> allEvents = new ArrayList<>();
            while (resultSet.next()) {
                Event event = mapRow(resultSet);
                allEvents.add(event);
            }
            return allEvents;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Event> findByCategory(int categoryId) {
        final String query = """
                SELECT
                    id, teamA, teamB, rate, date_added, category_id, user_id
                FROM
                    event
                WHERE
                    category_id = ? and id != all (select event_id from vote where user_id = 12) order by date_added desc
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, categoryId);
            ResultSet resultSet = statement.executeQuery();
            List<Event> events = new ArrayList<>();
            while (resultSet.next()) {
                Event event = mapRow(resultSet);
                events.add(event);
            }
            return events;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Event event) {
        final String query = """
                        INSERT INTO
                            event (teamA, teamB, rate,  date_added, category_id, user_id)
                        VALUES
                            (?, ?, ?, ?, ?, ?)
                        """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, event.getTeamA());
            statement.setString(2, event.getTeamB());
            statement.setInt(3, event.getRate());
            statement.setObject(4, event.getDateAdded());
            statement.setInt(5, event.getCategoryId());
            statement.setInt(6, event.getUserId());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                event.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Event mapRow(ResultSet set) throws SQLException {
        int eventId = set.getInt("id");
        String teamA = set.getString("teamA");
        String teamB = set.getString("teamB");
        int rate = set.getInt("rate");
          LocalDateTime dateAdded = set.getTimestamp("date_added").toLocalDateTime();
        int categoryId = set.getInt("category_id");
        int userId = set.getInt("user_id");
        return new Event(eventId, teamA, teamB, rate,  dateAdded, categoryId, userId);
    }

}