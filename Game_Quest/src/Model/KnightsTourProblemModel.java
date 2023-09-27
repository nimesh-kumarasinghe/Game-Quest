/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ndila
 */

import Model.DatabaseConnection;
//import com.fasterxml.jackson.core.JsonProcessingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import com.fasterxml.jackson.databind.ObjectMapper;


public class KnightsTourProblemModel {
    private DatabaseConnection dbConnection;

    public KnightsTourProblemModel() {
        this.dbConnection = dbConnection;
    }
    public void saveUserData(String playerName, String answer){      
        try {
                Connection connection = dbConnection.getConnection(); // Get the database connection

                String sql = "INSERT INTO knights_tour_problem (player_Name, correct_Answer) VALUES (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, playerName);
                // Serialize the answer matrix to a suitable format (JSON)
                //ObjectMapper objectMapper = new ObjectMapper();
                //String answerMatrixJson = objectMapper.writeValueAsString(controller.moveSquare);
                preparedStatement.setString(2, answer);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("User data saved successfully.");
                } else {
                    System.out.println("User data save failed.");
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}


