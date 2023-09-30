/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Lakshan
 */
public class TicTacToeModel {    
    Connection con = null;
    PreparedStatement pst = null;
    
    public TicTacToeModel() {
        con = DatabaseConnection.getConnection();
    }    
    
    public void savePlayerResponse(String playerName, String correctResponse) {
        try {
            String sql = "INSERT INTO tic_tac_toe (player_name, correct_answer) VALUES (?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, playerName);
            pst.setString(2, correctResponse);
            pst.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
