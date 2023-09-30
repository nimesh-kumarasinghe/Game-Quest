/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.DatabaseConnection;
import Controller.LCSController;
import View.LCSView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.lang.String;

/**
 *
 * @author risin
 */
public class LCSModel {
    
    private  DatabaseConnection dbCon;
    private LCSController controller;
    private LCSView view;
    
    //passing the LCSView object as a parameter to the constructor
    public LCSModel(LCSView view){
        
       this.dbCon = dbCon;
       this.controller = new LCSController();
       this.view = view;
    }
    
    public void savePlayerInfo(String userAnswer){
        try {
               Connection connection = dbCon.getConnection();
               String sql = "INSERT INTO longest_common_sequence(player_name, result) VALUES (?, ?)";
               PreparedStatement statement = connection.prepareStatement(sql);
              
                statement.setString(1, view.playerName);
                statement.setString(2, userAnswer);
                // Set the values for the placeholders

            
                statement.executeUpdate();
            // Execute the SQL statement to insert data into the database
                statement.close();

    }
        catch(SQLException e){
            e.printStackTrace();
            
        }
    }
     
    
}

