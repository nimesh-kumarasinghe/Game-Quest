/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controller;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ndila
 */
public class KnightsTourProblemControllerTest {
    
    private KnightsTourProblemController instance;

    @Before
    public void setUp() {
        instance = new KnightsTourProblemController(8); // Adjust the size based on your board size
    }

    @Test
    public void testReset() {
        instance.makeMove(0, 0);
        instance.reset();

        int[][] board = instance.getBoard();
        int[][] moveSquare = instance.moveSquare;
        List<Point> solution = instance.getSolution();

        for (int[] row : board) {
            for (int cell : row) {
                assertEquals(0, cell);
            }
        }

        for (int[] row : moveSquare) {
            for (int cell : row) {
                assertEquals(0, cell);
            }
        }

        assertEquals(0, instance.getMoveCount());
        assertTrue(solution.isEmpty());
    }

    @Test
    public void testSolveKnightTour() {
        assertTrue(instance.solveKnightTour(0, 0));
        List<Point> solution = instance.getSolution();
        assertEquals(64, solution.size()); // Check that the solution contains all 64 squares
    }

    @Test
    public void testIsValidMove() {
        assertTrue(instance.isValidMove(0, 0));
        assertFalse(instance.isValidMove(-1, 0));
        assertFalse(instance.isValidMove(8, 8));
        assertTrue(instance.isValidMove(2, 1));
        assertTrue(instance.isValidMove(1, 2));
    }

    @Test
    public void testGetBoard() {
        int[][] board = instance.getBoard();
        assertNotNull(board);
        assertEquals(8, board.length); // Adjust this based on your board size
        assertEquals(8, board[0].length); // Adjust this based on your board size
    }

    @Test
    public void testGetSolution() {
        assertTrue(instance.getSolution().isEmpty());
        instance.solveKnightTour(0, 0);
        assertFalse(instance.getSolution().isEmpty());
    }

    @Test
    public void testGetSize() {
        assertEquals(8, instance.getSize());
        assertNotEquals(9, instance.getSize());
    }

    @Test
    public void testGetMoveCount() {
        assertEquals(0, instance.getMoveCount());
        instance.makeMove(0, 0);
        instance.makeMove(2, 1);
        assertEquals(2, instance.getMoveCount());
    }

    @Test
    public void testMakeMove() {
        assertTrue(instance.makeMove(0, 0));
        assertEquals(1, instance.getBoard()[0][0]);
        assertFalse(instance.makeMove(0, 0)); // Attempting to move to the same square should fail
    }

    @Test
    public void testHasNoEmptyMoveSquares() {
        assertFalse(instance.hasNoEmptyMoveSquares(0, 0));
        instance.makeMove(0, 0);
        instance.makeMove(2, 1);
        assertFalse(instance.hasNoEmptyMoveSquares(2, 1));
    }

    @Test
    public void testCalculatePossibleMoves() {
        List<Point> possibleMoves = instance.calculatePossibleMoves(0, 0);
        assertEquals(2, possibleMoves.size());
        assertTrue(possibleMoves.contains(new Point(2, 1)));
        assertTrue(possibleMoves.contains(new Point(1, 2)));
    }

    @Test
    public void testGetMetrixAnswer() {
        assertNotNull(instance.getMetrixAnswer());
        // Add more specific tests for the expected format of the answer
    }

    @Test
    public void testSolveKnightTourWithDifferentStart() {
        assertTrue(instance.solveKnightTour(0, 2));
        List<Point> solution = instance.getSolution();
        assertEquals(64, solution.size()); // Check that the solution contains all 64 squares
    }

    @Test
    public void testMakeInvalidMove() {
        assertFalse(instance.makeMove(-1, 0)); // Invalid move, should fail
        assertTrue(instance.makeMove(0, 1));
        assertTrue(instance.makeMove(2, 0));
        assertFalse(instance.makeMove(0, 1));
    }

    @Test
    public void testMakeMultipleMoves() {
        assertTrue(instance.makeMove(0, 0));
        assertTrue(instance.makeMove(2, 1));
        assertTrue(instance.makeMove(0, 2));
        assertFalse(instance.makeMove(1, 3));
        assertEquals(3, instance.getMoveCount());
    }

    @Test
    public void testSolveKnightTourWithDifferentStart2() {
        assertTrue(instance.solveKnightTour(4, 4));
        List<Point> solution = instance.getSolution();
        assertEquals(64, solution.size());
    }

    @Test
    public void testMakeMoveBackAndForth() {
        assertTrue(instance.makeMove(0, 0));
        assertTrue(instance.makeMove(2, 1));
        assertFalse(instance.makeMove(0, 0)); // Move back to a previously visited square
        assertEquals(2, instance.getMoveCount());
    }

    @Test
    public void testSolveKnightTourWithDifferentStart3() {
        assertTrue(instance.solveKnightTour(7, 7));
        List<Point> solution = instance.getSolution();
        assertEquals(64, solution.size());
    }

    @Test
    public void testMakeMoveToEdge() {
        assertTrue(instance.makeMove(0, 0));
        assertTrue(instance.makeMove(2, 1));
        assertTrue(instance.makeMove(0, 2));
        assertTrue(instance.makeMove(1, 0));
        assertTrue(instance.makeMove(3, 1));
        assertTrue(instance.makeMove(1, 2));
        assertTrue(instance.makeMove(0, 4));
        assertTrue(instance.makeMove(2, 5));
        assertTrue(instance.makeMove(4, 4));
        assertTrue(instance.makeMove(5, 2));
        assertTrue(instance.makeMove(7, 1));
        assertTrue(instance.makeMove(6, 3));
        assertTrue(instance.makeMove(4, 2));
        assertTrue(instance.makeMove(6, 1));
        assertTrue(instance.makeMove(5, 3));
        assertTrue(instance.makeMove(7, 4));
        assertEquals(16, instance.getMoveCount());
    }
    
    @Test
    public void testKnightTourOutput() { 
//        int[][] inputMatrix = {
//        {22, 25, 12, 1, 14, 19, 6, 3},
//        {11, 28, 21, 24, 5, 2, 15, 18},
//        {26, 23, 10, 13, 20, 17, 4, 7},
//        {29, 44, 27, 36, 9, 32, 39, 16},
//        {64, 51, 30, 43, 38, 35, 8, 33},
//        {45, 48, 37, 54, 31, 56, 59, 40},
//        {52, 63, 50, 47, 42, 61, 34, 57},
//        {49, 46, 53, 62, 55, 58, 41, 60}
//    };

        int[][] inputMatrix = {
        {40, 19, 16, 1, 38, 29, 14, 11},
        {17, 2, 39, 30, 15, 12, 37, 28},
        {20, 41, 18, 59, 44, 35, 10, 13},
        {3, 64, 51, 42, 31, 46, 27, 36},
        {52, 21, 60, 45, 58, 43, 34, 9},
        {61, 4, 63, 50, 55, 32, 47, 26},
        {22, 53, 6, 57, 24, 49, 8, 33},
        {5, 62, 23, 54, 7, 56, 25, 48}
    };

        // Run the Knight's Tour game
        instance.solveKnightTour(0, 3);

        int[][] actualMatrix = new int[8][8];
        List<Point> solution = instance.getSolution();
        int move = 1;

        // Fill the actualMatrix with the knight's tour moves
        for (Point point : solution) {
            int row = (int) point.getX();
            int col = (int) point.getY();
            actualMatrix[row][col] = move++;
        }

        // Print the generated knight's tour pattern
        System.out.println("System Generated Knight's Tour Pattern:");
        StringBuilder matrixAsString = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matrixAsString.append(actualMatrix[i][j]).append(" ");
            }
            matrixAsString.append("\n");
        }
        System.out.println(matrixAsString.toString());
        assertNotEquals(inputMatrix, actualMatrix);
        
        if (!Arrays.deepEquals(inputMatrix, actualMatrix)) {
            System.out.println("User Inserted Knight's tour pattern is wrong!");
        }
        else{
            System.out.println("User Inserted Knight's tour pattern is correct!");
        }

    }
}
