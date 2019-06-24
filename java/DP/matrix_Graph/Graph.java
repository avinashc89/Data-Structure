package com.tool.java.DP.matrix_Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Graph 
{ 
    
    class Node {
        public Node (int int1, ArrayList arrayList)
        {
            val = int1;
            neighbors = arrayList;
        }
        int val;
        ArrayList<Node> neighbors;
    }
    private int V;   // No. of vertices -> no of nodes
    private LinkedList<Integer> adj[]; //Adjacency List 
  
    // Constructor 
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    // Function to add an edge into the graph 
    void addEdge(int v,int w) 
    { 
        adj[v].add(w); 
        adj[w].add(v); 
    } 
  
    
    
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
    
    /**
     * Clone graph
     * @param node
     * @return
     * 
     * using map <originalnode, cloneNode>
     * 
     */
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
     
        queue.offer(node);
        map.put(node, new Node(node.val, new ArrayList<>()));
        while (!queue.isEmpty()) {
            Node h = queue.poll();
     
            for (Node neighbor : h.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                map.get(h).neighbors.add(map.get(neighbor));
            }
        }
     
        return map.get(node);
    }
  
    // Driver method 
    public static void main(String args[]) 
    { 
        // Create a graph given in the above diagram 
        Graph g1 = new Graph(5); 
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
        if (g1.isTree()) 
            System.out.println("Graph is Tree"); 
        else
            System.out.println("Graph is not Tree"); 
  
        Graph g2 = new Graph(5); 
        g2.addEdge(1, 0); 
        g2.addEdge(0, 2); 
        g2.addEdge(2, 1); 
        g2.addEdge(0, 3); 
        g2.addEdge(3, 4); 
  
        if (g2.isTree()) 
            System.out.println("Graph is Tree"); 
        else
            System.out.println("Graph is not Tree"); 
  
    } 
} 