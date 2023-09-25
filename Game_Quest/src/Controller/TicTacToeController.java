/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Lakshan
 */

import java.util.Random;

public class TicTacToeController {
    
    private static final int boardSize = 3;
    private static final char humanPlayer = 'X';
    private static final char aiPlayer = 'O';
    private static final char Enull = '-';
    
    private char[][] board;
    private int AIMoveRow;
    private int AIMoveCol;
    
    public TicTacToeController() {
        board = new char[boardSize][boardSize];
        setBoard();
       
    }
    
    private void setBoard() {
        
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = Enull;
            }
        }
    }
    
    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n---------");
        }
    }
    
    public void getBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n---------");
        }
    }
    
    public String getMatrixAnswer() {
        StringBuilder answerBuilder = new StringBuilder();

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                answerBuilder.append(board[i][j]+ "\t");
            }

            // Add a comma after each row except the last one
            if (i < boardSize - 1) {
                answerBuilder.append("\n");
            }
        }

        return answerBuilder.toString();
    }

        
    public boolean isMoveValid(int row, int col) {
        return  board[row][col] == Enull;
    }
    
    public boolean isBoardFull() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == Enull) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkForWin(char player) {
        // Check rows
        for (int i = 0; i < boardSize; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        
        // Check columns
        for (int i = 0; i < boardSize; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        
        return false;
    }
    
    public boolean isGameOver() {
        return isBoardFull() || checkForWin(humanPlayer) || checkForWin(aiPlayer);
    }
    
    public void makeMove(int row, int col, char player) {
        board[row][col] = player;
    }
    
    public void undoMove(int row, int col) {
        board[row][col] = Enull;
    }
    
    public int evaluateBoard() {
        if (checkForWin(aiPlayer)) {
            return 1;
        }
        if (checkForWin(humanPlayer)) {
            return -1;
        }
        return 0;
    }
        
    private int minimax(int depth, boolean isMaximizingPlayer) {
        int score = evaluateBoard();
        
        if (score == 1 || score == -1) {
            return score;
        }
        
        if (isBoardFull()) {
            return 0;
        }
        
        if (isMaximizingPlayer) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    if (board[i][j] == Enull) {
                        board[i][j] = aiPlayer;
                        int currentScore = minimax(depth + 1, false);
                        board[i][j] = Enull;
                        bestScore = Math.max(bestScore, currentScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    if (board[i][j] == Enull) {
                        board[i][j] = humanPlayer;
                        int currentScore = minimax(depth + 1, true);
                        board[i][j] = Enull;
                        bestScore = Math.min(bestScore, currentScore);
                    }
                }
            }
            return bestScore;
        }
    }
        
    public void makeAIMove() {
        int bestScore = Integer.MIN_VALUE;
        Random random = new Random();
        
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == Enull) {
                    board[i][j] = aiPlayer;
                    int currentScore = minimax(0, false);
                    board[i][j] = Enull;
                    
                    if (currentScore > bestScore) {
                        bestScore = currentScore;
                        AIMoveRow = i;
                        AIMoveCol = j;
                    } else if (currentScore == bestScore && random.nextBoolean()) {
                        // If the current score is the same as the best score, randomly choose one of the moves
                        AIMoveRow = i;
                        AIMoveCol = j;
                    }
                }
            }
        }        
        board[AIMoveRow][AIMoveCol] = aiPlayer;
    }
            
    public int getAiMoveRow() {
        return AIMoveRow;
    }
    
    public int getAiMoveCol() {
        return AIMoveCol;
    }
}
