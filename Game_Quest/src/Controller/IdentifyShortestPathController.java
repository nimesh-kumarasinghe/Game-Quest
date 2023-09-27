/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.IdentifyShortestPathView;
import java.awt.Color;
import Controller.Graph.*;
import java.util.ArrayList;

import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.util.HashMap;
import java.util.Map;
import javax.swing.event.DocumentListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.json.JSONArray;
import org.json.JSONObject;

import Model.IdentifyShortestPathModel;

/**
 *
 * @author Haritha Pahansith
 */


public class IdentifyShortestPathController {
    public Graph graph = new Graph();
    public Map<JTextPane,Integer> results  = new HashMap<>();
    
    double dijkstraTimeTaken,bellmanFordTimeTaken;
    
    JSONObject answer;
    String selected_city_name;
    
    public void giveDistance(IdentifyShortestPathView view,ArrayList<JLabel> txt_list,ArrayList<JTextPane> input_text_panel,JLabel randomly_selected_city_txt){
        int [] distances = new int[15];

        Random random = new Random();
        
        answer = new JSONObject();
        
        for(int i=0;i<15;i++){
            int randomNumber = random.nextInt(46) + 5;
            
            distances[i] = randomNumber;
        }
        
        Vertex casino = graph.addVertex("casino");Vertex gameshop = graph.addVertex("gameshop");Vertex firestation = graph.addVertex("firestation");
        Vertex office1 = graph.addVertex("office1");Vertex office2 = graph.addVertex("office2");Vertex office3 = graph.addVertex("office3");
        Vertex hospital = graph.addVertex("hospital");Vertex theater = graph.addVertex("theater");Vertex venue = graph.addVertex("venue");
        Vertex police = graph.addVertex("police");
        
        
        view.drawLines("casino", "office1", Color.blue, Integer.toString(distances[0]));
        graph.addEdge(casino, office1, distances[0]);
        
        view.drawLines("office1", "gameshop", Color.BLACK, Integer.toString(distances[1]));
        graph.addEdge(office1, gameshop, distances[1]);
        
        view.drawLines("office1", "office2", Color.BLACK, Integer.toString(distances[2]));
        graph.addEdge(office1, office2, distances[2]);
        
        view.drawLines("office1", "office3", Color.BLACK, Integer.toString(distances[3]));
        graph.addEdge(office1, office3, distances[3]);
        
        view.drawLines("office1", "theater", Color.BLACK, Integer.toString(distances[4]));
        graph.addEdge(office1, theater, distances[4]);
        
        view.drawLines("office1", "venue", Color.BLACK, Integer.toString(distances[5]));
        graph.addEdge(office1, venue, distances[5]);
        
        view.drawLines("gameshop", "firestation", Color.GREEN, Integer.toString(distances[6]));
        graph.addEdge(gameshop, firestation, distances[6]);
        
        view.drawLines("venue", "police", Color.CYAN, Integer.toString(distances[7]));
        graph.addEdge(venue, police, distances[7]);
        
        view.drawLines("police", "hospital", Color.RED, Integer.toString(distances[8]));
        graph.addEdge(police, hospital, distances[8]);
        
        view.drawLines("office2", "venue", Color.ORANGE, Integer.toString(distances[9]));
        graph.addEdge(office2, venue, distances[9]);
        
        view.drawLines("firestation", "office2", Color.GREEN, Integer.toString(distances[10]));
        graph.addEdge(firestation, office2, distances[10]);
        
        view.drawLines("firestation", "office3", Color.GREEN, Integer.toString(distances[11]));
        graph.addEdge(firestation, office3, distances[11]);
        
        view.drawLines("casino", "firestation", Color.blue, Integer.toString(distances[12]));
        graph.addEdge(casino, firestation, distances[12]);
        
        view.drawLines("theater", "hospital", Color.orange, Integer.toString(distances[13]));
        graph.addEdge(theater, hospital, distances[13]);
        
        view.drawLines("theater", "police", Color.orange, Integer.toString(distances[14]));
        graph.addEdge(theater, police, distances[14]);
        
        //selecting a random city
        
        //
        
        int randomIndex = random.nextInt(this.graph.getVertices().size());
        Vertex random_city_vertex = graph.getVertices().get(randomIndex);
        String random_city = random_city_vertex.getData();
        
        randomly_selected_city_txt.setText(random_city);
        
        selected_city_name = random_city;
        
        try{
            answer.put("from",random_city);
        }
        catch(Exception e){
            System.err.println("json error");
        }
        
        long dijkstraStartTime = System.nanoTime(); // Measure start time in nanoseconds
        DijkstrasAlgorithm gg = new DijkstrasAlgorithm(this.graph, random_city_vertex);
        long dijkstraEndTime = System.nanoTime(); // Measure end time in nanoseconds

        // Calculate time taken in milliseconds with decimal points
        dijkstraTimeTaken = (dijkstraEndTime - dijkstraStartTime) / 1e6; // 1e6 is 1 millisecond in nanoseconds

        long bellmanFordStartTime = System.nanoTime(); // Measure start time in nanoseconds
        BellmanFordAlgorithm bb = new BellmanFordAlgorithm(this.graph, random_city_vertex);
        long bellmanFordEndTime = System.nanoTime(); // Measure end time in nanoseconds
        
        // Calculate time taken in milliseconds with decimal points
        bellmanFordTimeTaken = (bellmanFordEndTime - bellmanFordStartTime) / 1e6; // 1e6 is 1 millisecond in nanoseconds

        System.err.println("time for dijkstra - " + dijkstraTimeTaken + " milliseconds");
        System.err.println("time for bellmanFord - " + bellmanFordTimeTaken + " milliseconds");
        
        
        
        JSONArray toCities = new JSONArray();
        
        //cal distance gg.getDistance(v)
        int x = 0;
        for(Vertex v : graph.getVertices()){
            if(v == random_city_vertex){
                continue;
            }
            else{
                String text = random_city;
                text+= " - " + v.getData();
                txt_list.get(x).setText(text);
               // results.put(input_text_panel.get(x), gg.getDistance(v));
                //input_text_panel.get(x).setText(Integer.toString(gg.getDistance(v)));
                results.put(input_text_panel.get(x),gg.getDistance(v) ); // results set in array with label
                
                
                
                try{
                    JSONObject toCity = new JSONObject();
                    toCity.put(v.getData(), gg.getDistance(v));
                    toCities.put(toCity);
                }
                catch(Exception e){
                }
                
                x++;
            }
            
            try{
                answer.put("to",toCities);
            }
            catch(Exception e){
                
            }
        }   
        
        System.err.println("json -> " + answer);
    }
    
    public boolean checkResults(ArrayList<JTextPane> inputs,JTextPane user_name){
        boolean game_won = true;
        
        IdentifyShortestPathModel model = new IdentifyShortestPathModel();
        
        for(JTextPane p : inputs){
            try{
            if(Integer.parseInt(p.getText()) == results.get(p)){
                System.err.println("okay");
            }
            else{
                game_won = false;
                break;
            }
            }
            catch(Exception e){
                System.err.println("error");
            }
        }
        
        
        if(game_won == true){
            System.err.println("you won !!");
            
            //save to database
            //(String playerName, String cityName, JSONObject answer, long dijkstraTime, long bellmanTime) {
            model.OnSuccess(user_name.getText(),selected_city_name, answer, dijkstraTimeTaken,bellmanFordTimeTaken);
            //save to database
            
            return true;
        }
        else{
            return false;
        }
    }
    
}
