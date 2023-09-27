/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Graph;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Haritha Pahansith
 */
public class BellmanFordAlgorithm {
    
    Map<Integer,Vertex> map_vertex = new HashMap<>();
    Map<Vertex,Integer> map_vertex_r = new HashMap<>();
    
    Integer [] data;
    int no_of_vertices;
    
    /*
    table[0,0] -> (row,column)
    table[n,0] -> from
    table[n,1] -> to
    table[n,3] -> value
    */
    
    public BellmanFordAlgorithm(Graph graph, Vertex start_vertex) {
        this.no_of_vertices = graph.getVertices().size();
        
        data = new Integer[no_of_vertices];
        
        // Initialization
        for (int i = 0; i < no_of_vertices; i++) {
            Vertex v = graph.getVertices().get(i);
            map_vertex.put(i, v);
            map_vertex_r.put(v, i);
            
            if (v == start_vertex) {
                data[i] = 0;
            } else {
                data[i] = 500;
            }
        }
        
        // Bellman-Ford Algorithm
        for (int x = 0; x < no_of_vertices - 1; x++) {
            for (int i = 0; i < data.length; i++) {
                Vertex v = map_vertex.get(i);

                for (Edge e : v.getEdges()) {
                    int end_index = map_vertex_r.get(e.getEnd());
                    int cal_val = data[i] + e.getWeight();
                    
                    // Relaxation step
                    if (cal_val < data[end_index]) {
                        data[end_index] = cal_val;
                    }
                }
            }
        }

        // Print results
        System.err.println("BellmanFord Values");
        for (int i = 0; i < data.length; i++) {
            System.err.println("from -> " + start_vertex.getData() + " to -> " + map_vertex.get(i).getData() + " is -> " + data[i]);
        }
    }
    
    public int getDistance(Vertex to){
        int index = map_vertex_r.get(to);
        System.err.println("data is -> " + data[index]);
        return data[index];
    }
    
//    public static void main(String[] args) {
//        Graph gg = new Graph();
//        Vertex a = gg.addVertex("A");
//        Vertex b = gg.addVertex("B");
//        Vertex c = gg.addVertex("C");
//        Vertex d = gg.addVertex("D");
//        
//        gg.addEdge(a, b, 3);
//        gg.addEdge(a, c, 5);
//        gg.addEdge(b, c, 3);
//        gg.addEdge(c, d, 4);
//        gg.addEdge(d, b, 2);
//        
//        BellmanFordAlgorithm bb = new BellmanFordAlgorithm(gg, a);
//        bb.getDistance(b);
//    }
}
