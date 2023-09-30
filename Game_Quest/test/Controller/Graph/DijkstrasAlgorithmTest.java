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
public class DijkstrasAlgorithmTest {
    
    public DijkstrasAlgorithmTest() {
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
    public void testGetDistance() {
        System.out.println("getDistance");

        Graph graph = new Graph();
        Vertex a = graph.addVertex("A");
        Vertex b = graph.addVertex("B");
        Vertex c = graph.addVertex("C");

        graph.addEdge(a, b, 3);
        graph.addEdge(b, c, 2);

        DijkstrasAlgorithm instance = new DijkstrasAlgorithm(graph, a);

        Vertex vertex_to = c;

        int expResult = 5; 

        int result = instance.getDistance(vertex_to);

        assertEquals(expResult, result);
    }
    
}
