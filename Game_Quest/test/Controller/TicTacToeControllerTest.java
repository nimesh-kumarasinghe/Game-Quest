/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class TicTacToeControllerTest {

    private TicTacToeController instance;

    @Before
    public void setUp() {
        instance = new TicTacToeController();
    }

    @Test
    public void testPrintBoard() {
        System.out.println("printBoard");
        instance.printBoard();
        // You can add assertions to check the printed output if applicable.
    }

    @Test
    public void testGetBoard() {
        System.out.println("getBoard");
        char[][] board = instance.getBoards();
        // For example, you can check that the board has the expected dimensions:
        assertEquals(3, board.length); // Assuming a 3x3 board
        assertEquals(3, board[0].length);

    }

    @Test
    public void testGetMatrixAnswer() {
        String inputmatrix = 
        "-	-	-	"+"\n"+"-	-	-	"
                +"\n"+"-	-	-	";
        System.out.println("getMatrixAnswer");
        String result = instance.getMatrixAnswer();        
        System.out.println("Matrix Input\n"+inputmatrix);
        System.out.println("Matrix Result\n"+result);
        assertEquals(inputmatrix, result);
        //if (inputmatrix.equals(result)){
        //    System.out.println("Successful");
        //}
    }

    @Test
    public void testIsMoveValid() {
        System.out.println("isMoveValid");
        int row = 1;
        int col = 0;
        boolean expResult = true;
        boolean result = instance.isMoveValid(row, col);
        assertEquals(expResult, result);
        //assertNotEquals(expResult, result);
    } 

    @Test
    public void testIsBoardFull() {
        System.out.println("isBoardFull");
        boolean expResult = false;
        boolean result = instance.isBoardFull();
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckForWin() {
        /*System.out.println("draw");
        // Simulate a draw scenario
        instance.makeMove(0, 0, 'X');
        instance.makeMove(0, 1, 'O');
        instance.makeMove(0, 2, 'X');
        instance.makeMove(1, 0, 'X');
        instance.makeMove(1, 1, 'O');
        instance.makeMove(1, 2, 'X');
        instance.makeMove(2, 0, 'O');
        instance.makeMove(2, 1, 'X');
        instance.makeMove(2, 2, 'O');
        // Check if the game is over (draw)
        boolean result = instance.checkForWin('O');
        System.out.println(result);
        assertFalse(result); // The game should be a draw */
        System.out.println("check For Win - X Player");
        // Check for a win by player 'X'        
        // Simulate a horizontal win by one player
        instance.makeMove(0, 0, 'X');
        instance.makeMove(0, 1, 'X');
        instance.makeMove(0, 2, 'X');
        boolean result = instance.checkForWin('X');
        assertTrue(result); // 'X' should win horizontally
        
        
    }

    @Test
    public void testIsGameOver() {
        System.out.println("isGameOver");
        boolean expResult = false;
        boolean result = instance.isGameOver();
        assertEquals(expResult, result);
    }

    @Test
    public void testMakeMove() {
        System.out.println("makeMove");
        int row = 0;
        int col = 0;
        char player = ' ';
        instance.makeMove(row, col, player);
        // update the game board to reflect that player has made a move
    }

    @Test
    public void testUndoMove() {
        System.out.println("undoMove");
        int row = 0;
        int col = 0;
        // Perform a move first to undo it later
        instance.makeMove(row, col, 'X');

        instance.undoMove(row, col);
        // Add assertions to check the state after undoing a move.
    }

    @Test
    public void testEvaluateBoard() {
        System.out.println("evaluateBoard");
        int expResult = 0;
        int result = instance.evaluateBoard();
        assertEquals(expResult, result);
    }

    @Test
    public void testMakeAIMove() {
        System.out.println("makeAIMove");
        instance.makeAIMove();
        // Add assertions to check the state after AI makes a move.
    } 

    @Test
    public void testGetAiMoveRow() {
        System.out.println("getAiMoveRow");
        int expResult = 0;
        int result = instance.getAiMoveRow();
        assertEquals(expResult, result);
    } 

    @Test
    public void testGetAiMoveCol() {
        System.out.println("getAiMoveCol");
        int expResult = 0;
        int result = instance.getAiMoveCol();
        assertEquals(expResult, result);
    }
}
