package com.tool.java.DP.matrix_Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class IsGraphValidTree
{
    
    private int V;   // No. of vertices -> no of nodes
    private LinkedList<Integer> adj[]; //Adjacency List 
    
    
    /**
     * Check if graph is valid tree
     * An undirected graph is tree if it has following properties.
        1) There is no cycle.
        2) The graph is connected.
     * @param node
     * @return
     */
   
    
    boolean isTree() 
    { 
        // Mark all the vertices(nodes) as not visited and not part 
        // of recursion stack 
        Boolean visited[] = new Boolean[V]; 
        for (int i = 0; i < V; i++) 
            visited[i] = false; 
  
        if (isCyclicUtil(0, visited, -1)) 
            return false; 
  
        // If we find a vertex which is not visited
        // then we return false, since not connected 
        for (int i = 0; i < V; i++) 
            if (!visited[i]) 
                return false; 
  
        return true; 
    } 
    
    boolean isCyclicUtil(int v, Boolean visited[], int parent) 
    { 
        // Mark the current node as visited 
        visited[v] = true; 
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> it = adj[v].iterator(); 
        while (it.hasNext()) 
        { 
            Integer i = it.next(); 
            
            if (!visited[i]) // If an adjacent is not visited, then recur for that adjacent 
            { 
                if (isCyclicUtil(i, visited, v)) 
                    return true; 
            } 
            // If an adjacent is visited and not parent of  
            // current vertex, then there is a cycle. 
            else if (i != parent) 
               return true; 
        } 
        return false; 
    } 
    
    
    
    // method 2 -> using BFS - queue
    
    // n = no of nodes => V, Given n nodes labeled from 0 to n - 1 , lets say n=5. 0 ,1,2,3,4 are the nodes
    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
 
        //build the graph with list<list>
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
 
            list.get(a).add(b);
            list.get(b).add(a);
        }
        //use queue to traverse the graph
        HashSet<Integer> visited = new HashSet<>();
        LinkedList<Integer> q = new LinkedList<>();
        q.offer(0);
 
        while(!q.isEmpty()){
            int head = q.poll();
 
            // if the node is already visited ,then it is cyclic. return false
            if(visited.contains(head)){
                return false;
            }
 
            visited.add(head);
 
            //get the neighbors
            for(int neighbors: list.get(head)){
                if(!visited.contains(neighbors)){
                    q.offer(neighbors); 
                }     
            }
        }
 
        // if there is disconnected graph, the map size is less than n
        if(visited.size()<n){
            return false;
        }
 
        return true;
    }

}
