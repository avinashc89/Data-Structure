import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
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
  
    Boolean isCyclicUtil(int v, Boolean visited[], int parent) 
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
    
    /**
     * Check if graph is valid tree
     * An undirected graph is tree if it has following properties.
        1) There is no cycle.
        2) The graph is connected.
     * @param node
     * @return
     */
    Boolean isTree() 
    { 
        // Mark all the vertices as not visited and not part 
        // of recursion stack 
        Boolean visited[] = new Boolean[V]; 
        for (int i = 0; i < V; i++) 
            visited[i] = false; 
  
        if (isCyclicUtil(0, visited, -1)) 
            return false; 
  
        // If we find a vertex which is not visited
        // then we return false, since not connected 
        for (int u = 0; u < V; u++) 
            if (!visited[u]) 
                return false; 
  
        return true; 
    } 
    
    /**
     * Clone graph
     * @param node
     * @return
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