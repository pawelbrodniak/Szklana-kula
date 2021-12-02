package com.example.praca_inzynierska;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class VoteDao extends BaseDao {
    public void save(Vote vote) {
        final String query = """
                INSERT INTO
                    vote (user_id, event_id, type, date_added)
                VALUES
                    (?, ?, ?, ?)
                ON DUPLICATE KEY UPDATE
                    type = ?
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, vote.getUserId());
            statement.setInt(2, vote.getEventId());
            statement.setString(3, vote.getType().toString());
            statement.setObject(4, vote.getDateAdded());
            statement.setString(5, vote.getType().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

public int addScore(int eventId) {
        final String query = """
                      update vote set score = 1 * (select rate from event where id = ?)
                      where event_id = ? and 
                      type =  (select * from (select type from vote where
                      event_id = ? and user_id = 12) x)  and user_id != 12
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, eventId);
            statement.setInt(2, eventId);
            statement.setInt(3, eventId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return 0;
}

    public int addPoints(Integer id) {
        final String query = """
                    update user inner join vote on user.id = vote.user_id set 
                    points = (select  sum(score) from vote where user_id = user.id )
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
    public int countTEAMA(int eventId) {
        final String query = """
                select (select count(event_id) from vote 
                where event_id = ? and type = 'TEAMA' and user_id != 12) as vote_TEAMA
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, eventId);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("vote_TEAMA");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int countDRAW(int eventId) {
        final String query = """
                select (select count(event_id) from vote 
                where event_id = ? and type = 'DRAW' and user_id != 12) as vote_DRAW
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, eventId);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("vote_DRAW");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int countTEAMB(int eventId) {
        final String query = """
                select (select count(event_id) from vote 
                where event_id = ? and type = 'TEAMB' and user_id != 12) as vote_TEAMB
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, eventId);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("vote_TEAMB");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}