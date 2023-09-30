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
public class GraphTest {
    
    public GraphTest() {
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
     * Test of addVertex method, of class Graph.
     */
    @Test
    public void testAddVertex() {
        System.out.println("testAddVertex");
        Graph instance = new Graph();
        Vertex result = instance.addVertex("A");
        assertNotNull(result);
        assertEquals("A", result.getData());
        assertTrue(instance.getVertices().contains(result));
    }

    @Test
    public void testAddEdge() {
        System.out.println("testAddEdge");
        Graph instance = new Graph();
        Vertex vertex1 = instance.addVertex("A");
        Vertex vertex2 = instance.addVertex("B");
        instance.addEdge(vertex1, vertex2, 3);
        assertTrue(vertex1.addEdge(vertex2, Integer.SIZE));
        assertTrue(vertex2.addEdge(vertex2, Integer.SIZE));
    }

    @Test
    public void testRemoveEdge() {
        System.out.println("testRemoveEdge");
        Graph instance = new Graph();
        Vertex vertex1 = instance.addVertex("A");
        Vertex vertex2 = instance.addVertex("B");
        instance.addEdge(vertex1, vertex2, 3);
        instance.removeEdge(vertex1, vertex2);
        assertTrue(vertex1.removeEdge(vertex2));
        assertTrue(vertex2.removeEdge(vertex1));
    }

    @Test
    public void testRemoveVertex() {
        System.out.println("testRemoveVertex");
        Graph instance = new Graph();
        Vertex vertex = instance.addVertex("A");
        instance.removeVertex(vertex);
        assertFalse(instance.getVertices().contains(vertex));
    }

    @Test
    public void testGetVertices() {
        System.out.println("testGetVertices");
        Graph instance = new Graph();
        Vertex vertex1 = instance.addVertex("A");
        Vertex vertex2 = instance.addVertex("B");
        Vertex vertex3 = instance.addVertex("C");
        assertTrue(instance.getVertices().contains(vertex1));
        assertTrue(instance.getVertices().contains(vertex2));
        assertTrue(instance.getVertices().contains(vertex3));
    }

    @Test
    public void testGetVertexByValue() {
        System.out.println("testGetVertexByValue");
        Graph instance = new Graph();
        Vertex vertex = instance.addVertex("A");
        Vertex result = instance.getVertexByValue("A");
        assertNotNull(result);
        assertEquals("A", result.getData());
    }
    
}
