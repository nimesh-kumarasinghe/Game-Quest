package Controller;

import Model.EightQueenPuzzleModel;
import View.EightQueenPuzzleView;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Nisal 
 */
public class EightQueenPuzzleController {
    private EightQueenPuzzleModel model;
    private EightQueenPuzzleView view;

    private String playerName; 

    public EightQueenPuzzleController(EightQueenPuzzleModel model, EightQueenPuzzleView view, String playerName) {
        this.model = model;
        this.view = view;
        this.playerName = playerName; 
        view.setController(this);
        updateScoreLabel(); 
             
    }

  public void handleSquareClick(int row, int col) {
    if (model.placeQueen(row, col)) {
        ImageIcon queenIcon = new ImageIcon(getClass().getResource("/Images/queen1.jpeg"));
          int width = 80; 
          int height = 80; 
          Image resizedImage = queenIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
          queenIcon = new ImageIcon(resizedImage);
        view.updateSquare(row, col, queenIcon);
        
        updateScoreLabel();
       if (model.isGameOver()) {
          if (model.isGameLost()) {
             view.showMessage("You Lose!"); 
             resetChessboard();
            } 
            else 
            {
               view.showMessage("You Won!");
        
        // Save player details to the database
        int queensPlaced = model.getQueensPlaced();
        if (queensPlaced == model.getTotalQueens()) 
         { 
            savePlayerDetails(playerName, 8, model.getMetrixAnswer());
         }
             resetChessboard();
         }
}

    } else {
        view.showMessage("Invalid Queen Placement!");
    }
}



    private void updateScoreLabel() {
        int queensPlaced = model.getQueensPlaced();
        int totalQueens = model.getTotalQueens();
        view.updateScore("Queens: " + queensPlaced + " / " + totalQueens);
    }

    

    public void resetChessboard() {
        int[][] chessBoard = model.getChessBoard();
        int size = model.getTotalQueens();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                chessBoard[row][col] = '-';
                // Clear the queen icon
                view.updateSquare(row, col, null); 
            }
        }

        model.resetQueensPlaced(); // Reset the queens 
        updateScoreLabel(); // Update the score 
    }

    private void savePlayerDetails(String playerName, int score,String queensPattern) {
       
        model.savePlayerData(playerName, score,queensPattern); 
    }

    public static void main(String[] args) {
       /* SwingUtilities.invokeLater(() -> {
            String playerName = getPlayerNameDialog(); // Get the player's name 
            if (playerName != null && !playerName.isEmpty()) {
                int boardSize = 8; 
              //  EightQueenPuzzleModel model = new EightQueenPuzzleModel(8);
               // EightQueenPuzzleView view = new EightQueenPuzzleView(8);
              //  EightQueenPuzzleController controller = new EightQueenPuzzleController(model, view, playerName);
               // view.setPlayerNameLabel(playerName);
               // view.setVisible(true);
            } else {
                System.out.println("Player's name not provided. Exiting the game.");
            }
        });*/
    }

    
  public static String getPlayerNameDialog() {
    String playerName = null;
    while (true) {
        JTextField nameField = new JTextField();
        JComponent[] inputs = new JComponent[]{
            new JLabel("Enter your name:"),
            nameField
        };

        int result = JOptionPane.showOptionDialog(
            null,
            inputs,
            "Player Name Input",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[]{"Start", "Exit"}, 
            "Start" 
        );

        if (result == JOptionPane.OK_OPTION) {
           
            playerName = nameField.getText();
            if (!playerName.isEmpty()) {
               
                break;
            } else {
              
                JOptionPane.showMessageDialog(null, "Please enter a valid name.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
           
            playerName = null;
            break;
        }
    }
    return playerName;
}

  
}
