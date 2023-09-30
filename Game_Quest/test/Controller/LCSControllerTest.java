/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controller;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;
/**
 *
 * @author risin
 */
public class LCSControllerTest {
    private LCSController controller;
    
    
    @Before
    public void setUp() {
        controller = new LCSController();
    }
    
    @Test
    public void testCalculateLCS_NoCommonValues() {
        System.out.println("testCalculateLCS_NoCommonValues");
        LCSController instance = new LCSController();
        // Create two distinct strings
        String x = "HELLL";
        String y = "WRRPD";

        String result = instance.calculateLCS(x, y);
        // Check if the result is an empty string, indicating no common values
        assertEquals("", result);
    }
   
    @Test
    public void testGenerateRandomString() {
                // Test if the generated random string has the correct length (10 characters)
        String randomString = controller.generateRandomString();
        assertEquals(10, randomString.length());
                // Test if the generated random string consists of uppercase letters only
        assertTrue(randomString.matches("[A-Z]+"));
         
    }
    
    @Test
    public void testCalculateLCS_IdenticalStrings() {
        System.out.println("testCalculateLCS_IdenticalStrings");
        // Test case: Check LCS for two identical strings
        String result = controller.calculateLCS("ABC", "ABC");
        assertEquals("ABC", result);
    }

    @Test
    public void testCalculateLCS_CompletelyDifferentStrings() {
        System.out.println("testCalculateLCS_CompletelyDifferentStrings");
        // Test case: Check LCS for two completely different strings
        String result = controller.calculateLCS("XYZ", "123");
        assertEquals("", result);
    }
    
}
