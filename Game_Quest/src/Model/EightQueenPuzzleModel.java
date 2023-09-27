package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EightQueenPuzzleModel {
    private final int[][] chessBoard;
    private int queensPlaced;
    private final int totalQueens;
    private final int size;
    private DatabaseConnection dbConnection;
    
    private String queenPattern;

    //private static final String DB_URL = "jdbc:mysql://localhost:3306/testgame";
    //private static final String DB_USER = "root";
    //private static final String DB_PASSWORD = "";

    public EightQueenPuzzleModel(int size) {
        this.queenPattern = "";
        this.size = size;
        chessBoard = new int[size][size];
        queensPlaced = 0;
        totalQueens = size;
        this.dbConnection = dbConnection;

        initializeChessboard(size);
    }
    
    public void setQueenPattern(String pattern) {
        this.queenPattern = pattern;
    }
    
    private void initializeChessboard(int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                chessBoard[row][col] = 0;
            }
        }
    }
    public boolean isGameLost() {
    return queensPlaced != totalQueens && noValidCellsAvailable();
    }

    public int[][] getChessBoard() {
        return chessBoard;
    }

    public int getQueensPlaced() {
        return queensPlaced;
    }

    public int getTotalQueens() {
        return totalQueens;
    }

    public boolean placeQueen(int row, int col) {
        if (isValidPlacement(row, col)) {
            chessBoard[row][col] = 1;
            queensPlaced++;
            return true;
        }
        return false;
    }

    public void resetQueensPlaced() {
        queensPlaced = 0;
    }

    public boolean isValidPlacement(int row, int col) {
        // Check if there's no queen in the same row and column
        for (int i = 0; i < size; i++) {
            if (chessBoard[row][i] == 1 || chessBoard[i][col] == 1) {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 1) {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row, j = col; i >= 0 && j < size; i--, j++) {
            if (chessBoard[i][j] == 1) {
                return false;
            }
        }

        // Check lower-right diagonal
        for (int i = row, j = col; i < size && j < size; i++, j++) {
            if (chessBoard[i][j] == 1) {
                return false;
            }
        }

        // Check lower-left diagonal
        for (int i = row, j = col; i < size && j >= 0; i++, j--) {
            if (chessBoard[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public boolean isGameOver() {      
        return queensPlaced == totalQueens || noValidCellsAvailable();
    }

    private boolean noValidCellsAvailable() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (chessBoard[row][col] != 1 && isValidPlacement(row, col)) {
                    return false; 
                }
            }
        }
        return true; 
    }

    public String getMetrixAnswer(){
        StringBuilder answerBuilder = new StringBuilder();

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                answerBuilder.append(chessBoard[i][j] + "\t");
            }

            if(i < size - 1){
                answerBuilder.append("\n");
            }
        }
        System.out.println(answerBuilder.toString());
        return answerBuilder.toString();
    }
   /*public void savePlayerData(String playerName, int playerScore, String queenPattern) {
    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        String selectPatternSql = "SELECT PatternData FROM Players WHERE PatternData = ?";
        boolean patternExists = false;

        try (PreparedStatement selectStatement = connection.prepareStatement(selectPatternSql)) {
            selectStatement.setString(1, queenPattern);
            ResultSet resultSet = selectStatement.executeQuery();
            patternExists = resultSet.next(); 
        }

        if (patternExists) {
            JOptionPane.showMessageDialog(null, "This pattern has already been recognized.Try again", "Pattern Recognized", JOptionPane.WARNING_MESSAGE);
        } else {
            // Save player info
            String insertPlayerSql = "INSERT INTO Players (PlayerName, Score, PatternData) VALUES (?, ?, ?)";
        
            try (PreparedStatement insertStatement = connection.prepareStatement(insertPlayerSql)) {
                insertStatement.setString(1, playerName);
                insertStatement.setInt(2, playerScore);
                insertStatement.setString(3, queenPattern);
                insertStatement.executeUpdate();
            }
        }
    } 

catch (SQLException e) {
        e.printStackTrace();
    }
}
*/
    
public void savePlayerData(String playerName, int playerScore, String queenPattern) {
    try  {
        Connection connection = dbConnection.getConnection(); // Get the database connection
       
        String selectPatternSql = "SELECT PatternData FROM eight_queens_puzzle WHERE PatternData = ?";
        boolean patternExists = false;

        try (PreparedStatement selectStatement = connection.prepareStatement(selectPatternSql)) {
            selectStatement.setString(1, queenPattern);
            ResultSet resultSet = selectStatement.executeQuery();
            patternExists = resultSet.next(); // Check if there is a matching pattern
        }
          if (patternExists) {
            JOptionPane.showMessageDialog(null, "This pattern has already been recognized.Try again", "Pattern Recognized", JOptionPane.WARNING_MESSAGE);
        } else {
        // Save player info
        String insertPlayerSql = "INSERT INTO eight_queens_puzzle (PlayerName, Score, PatternData) VALUES (?, ?, ?)";

        if (!patternExists) {
            try (PreparedStatement insertStatement = connection.prepareStatement(insertPlayerSql)) {
                insertStatement.setString(1, playerName);
                insertStatement.setInt(2, playerScore);
                insertStatement.setString(3, queenPattern);
                insertStatement.executeUpdate();
            }
            }
          
            String countPatternsSql = "SELECT COUNT(*) AS patternCount FROM eight_queens_puzzle";
            int patternCount = 0;

            try (PreparedStatement countStatement = connection.prepareStatement(countPatternsSql)) {
                ResultSet countResultSet = countStatement.executeQuery();
                if (countResultSet.next()) {
                    patternCount = countResultSet.getInt("patternCount");
                }
            }

            if (patternCount >= 92) {
                String resetDatabaseSql = "DELETE FROM eight_queens_puzzle";
                try (PreparedStatement resetStatement = connection.prepareStatement(resetDatabaseSql)) {
                    resetStatement.executeUpdate();
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


}
