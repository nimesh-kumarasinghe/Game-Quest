/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Haritha Pahansith
 */
public class DijkstrasAlgorithm {
    Map<Integer,Vertex> map_vertex = new HashMap<>();
    Map<Vertex,Integer> map_vertex_r = new HashMap<>();
    
    Integer size;
    Integer [][] table;
    
    /*
    [1-n][0] -> vertex
    [0][1] -> k (taken / not)
    [0][2] -> d (distance)
    [0][3] -> p (prev)
    
    vertex , taken/not (boolean) , distance , previus vertex
    0         1                     0            -
    1         0                     int max      -
    
    */
    
    public DijkstrasAlgorithm(Graph graph,Vertex startVertex){
        this.size = graph.getVertices().size();
        this.table = new Integer[size][4];
        
        int count = 0;
        for(Vertex v : graph.getVertices()){
            map_vertex.put(count,v);
            map_vertex_r.put(v, count);
            
            table[count][0] = count;
            if(v == startVertex){
                table[count][1] = 0;
                table[count][2] = 0;
                table[count][3] = count;
            }
            else{
            table[count][1] = 0;
            table[count][2] = Integer.MAX_VALUE;
            }
            count++;
        }

        calDistance();
        
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(table[i][j] + "\t \t");
            }
            System.out.println(); // Move to the next row
        }
        
        
        for (int i = 0; i < size; i++) {
        if (i != map_vertex_r.get(startVertex)) {
            System.out.println("from -> " + startVertex.getData() + " to -> " + map_vertex.get(i).getData() + " distance is -> " + table[i][2]);
        }
        }
    }
    
    private void makeTaken(int index){
        table[index][1] = 1;
    }
    
    private int getCurrentMinDistance() {
        int minDistance = -1; // Initialize to a value that doesn't occur in your table
        int index = -1;
        
        for (int i = 0; i < this.size; i++) {
            if (table[i][1] == 0) { // Only consider unprocessed vertices
                if (minDistance == -1 || table[i][2] < minDistance) {
                    minDistance = table[i][2];
                    index = i;
                }
            }
        }

        if (minDistance == -1) {
            return -1; // no minimum distance found
        } else {
            return index;
        }
    }
    
    private void calDistance() {
        while (true) {
            int vertex = getCurrentMinDistance();

            if (vertex == -1) {
                break; // All vertices have been processed
            }

            Vertex selected = map_vertex.get(vertex);

            for (Edge e : selected.getEdges()) {
                int from = vertex; // The current vertex
                int to = map_vertex_r.get(e.getEnd());
                int weight = e.getWeight();

                if (table[to][1] == 1) {
                    continue; // Skip already taken vertices
                }

                int newDistance = table[from][2] + weight;

                if (newDistance < table[to][2]) {
                    table[to][2] = newDistance;
                    table[to][3] = from;    
                }
            }

            makeTaken(vertex); // Mark the current vertex as taken
        }
    }
    
    public int getDistance(Vertex vertex_to) {
        int index = map_vertex_r.get(vertex_to);
        return table[index][2];
    }
}
