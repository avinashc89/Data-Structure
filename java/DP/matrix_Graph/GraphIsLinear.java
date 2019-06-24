package com.tool.java.DP.matrix_Graph;


import java.io.*; 
import java.util.*; 
  
// This class represents a undirected graph  
// using adjacency list representation 
public class GraphIsLinear { 
    private int V; // No. of vertices 
  
    // Adjacency List 
    private LinkedList<Integer> adj[]; 
  
    // Constructor 
    GraphIsLinear(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i = 0; i < v; ++i) 
            adj[i] = new LinkedList<Integer>(); 
    } 
  
    // Function to add an edge into the graph 
    void addEdge(int v, int w) 
    { 
        adj[v].add(w); 
        adj[w].add(v); 
    } 
  
    // Returns true if the graph is linear,  =>
    // else false. 
    /**
     * @return
     */
    //  1 . Nodes should have only two adjacent nodes and 
    //  2.  Total no of node with two adj, should be V-2, V is the total nodes.
    
    boolean isLinear() 
    { 
        // If the number of vertice is 1 then 
        // the tree is always Linear 
        if (V == 1) 
            return true; 
        int count = 0; 
  
        // Counting the number of vertices 
        // with indegree 2 
        for (int i = 0; i < V; i++) { 
            if (adj[i].size() == 2) 
                count++; 
        } 
        if (count == V - 2) 
            return true; 
        else
            return false; 
    } 
  
    // Driver method 
    public static void main(String args[]) 
    { 
        // Create a graph given in the above example 
        GraphIsLinear g1 = new GraphIsLinear(3); 
        g1.addEdge(0, 1); 
        g1.addEdge(0, 2); 
        if (g1.isLinear()) 
            System.out.println("YES"); 
        else
            System.out.println("NO"); 
    } 
} 