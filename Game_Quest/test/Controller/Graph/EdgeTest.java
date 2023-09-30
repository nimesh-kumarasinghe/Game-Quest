/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controller.Graph;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Haritha Pahansith
 */
public class EdgeTest {
    
    public EdgeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetStart() {
        System.out.println("getStart");
        Vertex vertexA = new Vertex("A");
        Edge instance = new Edge(vertexA, null, null);
        Vertex expResult = vertexA;
        Vertex result = instance.getStart();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEnd() {
        System.out.println("getEnd");
        Vertex vertexB = new Vertex("B");
        Edge instance = new Edge(null, vertexB, null);
        Vertex expResult = vertexB;
        Vertex result = instance.getEnd();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        Edge instance = new Edge(null, null, 5);
        Integer expResult = 5;
        Integer result = instance.getWeight();
        assertEquals(expResult, result);
    }
    
}
