/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controller.Graph;

import java.util.ArrayList;
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
public class VertexTest {
    
    public VertexTest() {
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

    /**
     * Test of addEdge method, of class Vertex.
     */

    @Test
    public void testAddEdge() {
        System.out.println("testAddEdge");
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        vertex1.addEdge(vertex2, 3);
        assertTrue(vertex1.getEdges().size() == 1);
        assertTrue(vertex1.getEdges().get(0).getEnd().equals(vertex2));
        assertEquals(3, (int) vertex1.getEdges().get(0).getWeight());
    }

    @Test
    public void testRemoveEdge() {
        System.out.println("testRemoveEdge");
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        vertex1.addEdge(vertex2, 3);
        vertex1.removeEdge(vertex2);
        assertTrue(vertex1.getEdges().isEmpty());
    }

    @Test
    public void testGetData() {
        System.out.println("testGetData");
        Vertex vertex = new Vertex("A");
        assertEquals("A", vertex.getData());
    }

    @Test
    public void testGetEdges() {
        System.out.println("testGetEdges");
        Vertex vertex = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");
        vertex.addEdge(vertex2, 1);
        vertex.addEdge(vertex3, 2);
        assertEquals(2, vertex.getEdges().size());
    }

    @Test
    public void testPrint() {
        System.out.println("testPrint");
        Vertex vertex = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");
        vertex.addEdge(vertex2, 1);
        vertex.addEdge(vertex3, 2);
        System.out.println("Vertex Information (Without Weights):");
        vertex.print(false);
        System.out.println("Vertex Information (With Weights):");
        vertex.print(true);
    }
    
}
