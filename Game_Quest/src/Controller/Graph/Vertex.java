/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Graph;

import java.util.ArrayList;

/**
 *
 * @author Haritha Pahansith
 */
public class Vertex {
    private String data;
    private ArrayList<Edge> edges;
    
    public Vertex(String inputData){
        this.data = inputData;
        this.edges = new ArrayList<Edge>();
    }
    
    public void addEdge(Vertex endVertex,Integer weight){
        this.edges.add(new Edge(this, endVertex, weight));
    }
    
    public void removeEdge(Vertex endVertex){
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }
    
    public String getData(){
        return this.data;
    }
    
    public ArrayList<Edge> getEdges(){
        return this.edges;
    }
    
    public void print(boolean showWeight){
        String msg = "";
        if(this.edges.size() == 0){
            System.out.println(this.data + "-->");
            return;
        }
        
        for(int i=0;i<this.edges.size();i++){
            if(i==0){
                msg += this.edges.get(i).getStart().data + "--> ";
            }
            msg += this.edges.get(i).getEnd().data;
            
            if(showWeight){
                msg += "( " + this.edges.get(i).getWeight() + ")";
            }
            
            if(i!= this.edges.size() -1){
                msg += ", ";
            }
            
            System.out.println(msg);
        }
    }
}
