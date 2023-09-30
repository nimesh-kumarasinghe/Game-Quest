
package Model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nisal
 */
public class EightQueenPuzzleModelTest {
    private EightQueenPuzzleModel model;

    @Before
    public void setUp() {
        model = new EightQueenPuzzleModel(8);
    }

    @Test
    public void testPlaceQueen_ValidPlacement() {
        assertTrue(model.placeQueen(0, 0));
        assertEquals(1, model.getQueensPlaced());
        assertEquals(1, model.getChessBoard()[0][0]);
    }

    @Test
    public void testPlaceQueen_InvalidPlacement() {
        assertTrue(model.placeQueen(0, 0));
       // Placing another queen in the same cell
        assertFalse(model.placeQueen(0, 0)); 
        assertEquals(1, model.getQueensPlaced());
    }

    @Test
    public void testIsValidPlacement_Valid() {
        assertTrue(model.isValidPlacement(0, 0));
        assertTrue(model.isValidPlacement(1, 3));
    }

    @Test
    public void testIsValidPlacement_Invalid() {
        model.placeQueen(0, 0);
        assertFalse(model.isValidPlacement(0, 0)); // Same cell
        assertFalse(model.isValidPlacement(1, 0)); // Same column
        assertFalse(model.isValidPlacement(0, 1)); // Same row
        assertFalse(model.isValidPlacement(1, 1)); // Diagonal
    }

    @Test
    public void testIsGameLost_NotLost() {
        assertFalse(model.isGameLost());
    }

    @Test
    public void testIsGameLost_Lost() {
        // Place queens in a way that the game is lost
        model.placeQueen(0, 0);
        model.placeQueen(1, 2);
        model.placeQueen(2, 4);
        model.placeQueen(3, 6);
        model.placeQueen(4, 1);
        model.placeQueen(5, 3);
        model.placeQueen(6, 5);
        model.placeQueen(7, 7);
        
        assertTrue(model.isGameLost());
    }

    @Test
    public void testResetQueensPlaced() {
        model.placeQueen(0, 0);
        model.resetQueensPlaced();
        assertEquals(0, model.getQueensPlaced());
    }

  
@Test
public void testGetMetrixAnswer() {
    model.placeQueen(0, 2);
    model.placeQueen(1, 5);
    model.placeQueen(2, 7);
    model.placeQueen(3, 0);
    model.placeQueen(4, 3);
    model.placeQueen(5, 6);
    model.placeQueen(6, 4);
    model.placeQueen(7, 1);

    String expected = "0 0 1 0 0 0 0 0\n" +
                     "0 0 0 0 0 1 0 0\n" +
                     "0 0 0 0 0 0 0 1\n" +
                     "1 0 0 0 0 0 0 0\n" +
                     "0 0 0 1 0 0 0 0\n" +
                     "0 0 0 0 0 0 1 0\n" +
                     "0 0 0 0 1 0 0 0\n" +
                     "0 1 0 0 0 0 0 0";

    System.out.println("Matrix Pattern:");
    System.out.println(expected);

    
}
 @Test
   
public void testSavePlayerData() {
    System.out.println("testSavePlayerData");

    // Initialize the test data
    String playerName = "TestPlayer";
    int playerScore = 120;
    String queenPattern = "0 0 1 0 0 0 0 0\n" +
                         "0 0 0 0 0 1 0 0\n" +
                         "0 0 0 0 0 0 0 1\n" +
                         "1 0 0 0 0 0 0 0\n" +
                         "0 0 0 1 0 0 0 0\n" +
                         "0 0 0 0 0 0 1 0\n" +
                         "0 0 0 0 1 0 0 0\n" +
                         "0 1 0 0 0 0 0 0";

    model.savePlayerData(playerName, playerScore, queenPattern);
}

    
}
