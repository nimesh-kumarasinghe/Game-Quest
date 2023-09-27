/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.json.JSONObject;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Haritha Pahansith
 */
public class IdentifyShortestPathModel {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/gamedb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public int insertGameRoundAndGetID(String randomCity) {
        String sqlInsert = "INSERT INTO GameRounds (random_city) VALUES (?)";
        int roundId = -1; // Initialize with a default value

        try (Connection connection = getConnection();
             PreparedStatement insertStatement = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            insertStatement.setString(1, randomCity);
            int affectedRows = insertStatement.executeUpdate();

            if (affectedRows > 0) {
                // Successfully inserted a new game round, retrieve its generated ID
                try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        roundId = generatedKeys.getInt(1);
                    } else {
                        throw new SQLException("Creating game round failed, no ID obtained.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roundId;
    }

    public int insertPlayer(String playerName) {
        String sqlSelect = "SELECT player_id FROM Players WHERE player_name = ?";
        String sqlInsert = "INSERT INTO Players (player_name) VALUES (?)";
        int playerId = -1; // Initialize with a default value

        try (Connection connection = getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(sqlSelect);
             PreparedStatement insertStatement = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            // Check if the player already exists
            selectStatement.setString(1, playerName);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                playerId = resultSet.getInt("player_id"); // Player exists, retrieve their ID
            } else {
                // Player doesn't exist, insert a new player
                insertStatement.setString(1, playerName);
                int affectedRows = insertStatement.executeUpdate();
                if (affectedRows > 0) {
                    // Successfully inserted a new player, retrieve their generated ID
                    try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            playerId = generatedKeys.getInt(1);
                        } else {
                            throw new SQLException("Creating player failed, no ID obtained.");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return playerId;
    }

    public void insertAnswer(int roundId, int playerId, String algorithmUsed, JSONObject answerJson, boolean isCorrect) {
        String sql = "INSERT INTO Answers (round_id, player_id, algorithm_used, answer_json, is_correct) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, roundId);
            preparedStatement.setInt(2, playerId);
            preparedStatement.setString(3, algorithmUsed);
            preparedStatement.setString(4, answerJson.toString());
            preparedStatement.setBoolean(5, isCorrect);
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAlgorithmTimes(int roundId, double dijkstraTime, double bellmanFordTime) {
        String sql = "INSERT INTO AlgorithmTimes (round_id, dijkstra_time, bellman_ford_time) VALUES (?, ?, ?)";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, roundId);
            preparedStatement.setDouble(2, dijkstraTime);
            preparedStatement.setDouble(3, bellmanFordTime);
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void OnSuccess(String playerName, String cityName, JSONObject answer, double dijkstraTime, double bellmanTime) {
        // Insert the player and retrieve their ID
        int playerId = insertPlayer(playerName);

        // Insert the game round and retrieve its ID
        int roundId = insertGameRoundAndGetID(cityName);

        // Insert the answer using the retrieved player and game round IDs
        insertAnswer(roundId, playerId, "Dijkstra and Bellman Ford", answer, true);

        // Insert algorithm times using the retrieved game round ID
        insertAlgorithmTimes(roundId, dijkstraTime, bellmanTime);
    }
    
//    public static void main(String[] args) {
//        IdentifyShortestPathModel model = new IdentifyShortestPathModel();
//
//        // Sample data
//        String playerName = "Player1";
//        String cityName = "test city";
//        JSONObject answer = new JSONObject();
//        try{
//            answer.put("from", "test city");
//            answer.put("to", new JSONObject().put("destination1", 10).put("destination2", 20));
//        }
//        catch(Exception e){
//        }
//        long dijkstraTime = 1000L; // Sample time in milliseconds
//        long bellmanTime = 1500L; // Sample time in milliseconds
//
//        // Call the OnSuccess method to insert the sample data
//        model.OnSuccess(playerName, cityName, answer, dijkstraTime, bellmanTime);
//    }
}
