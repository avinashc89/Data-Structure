package com.tool.java.DP.graph_Algo;

import java.util.*;

public class TopologicalSort<T>
{
    /**
     * Main method to be invoked to do topological sorting.
     */
    
    /*
      Usecase = build system. library dependency
     
     
             A      B
              \    / | 
                C    |
               /     |
             E       D
              \     /
                 F
                 |
                 G
      Here C is dependent on A&B
      D is dependant on B ... and so on..
      
      Any of the below works
      ABCDEFG
      ABDCEFG
      ABCEDFG
      
      =>
      A => C
      C => E
      B => C,D
      D => 
      
     */
    public Stack<Vertex<T>> topSort(Graph<T> graph) {
        Stack<Vertex<T>> stack = new Stack<>();        
        Set<Vertex<T>> visited = new HashSet<>();           //to check if node is visited
        
        //choose any vertex and check if visited. if not, do topological sort
        for (Vertex<T> vertex : graph.getAllVertex()) {
            if (visited.contains(vertex)) {
                continue;
            }
            topSortUtil(vertex,stack,visited);
        }
        return stack;
    }

    // make V as visited and get the childrens and recurse. Once all done add to stack.
    // so for any V, it is added to stack only if the dependencies are done.
    private void topSortUtil(Vertex<T> vertex, Stack<Vertex<T>> stack,
            Set<Vertex<T>> visited) 
    {
        visited.add(vertex);
        for(Vertex<T> childVertex : vertex.getAdjacentVertexes()){
            if(visited.contains(childVertex)){
                continue;
            }
            topSortUtil(childVertex,stack,visited);
        }
        stack.push(vertex);
    }
    
    public static void main(String args[]){
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);
        
        TopologicalSort<Integer> sort = new TopologicalSort<Integer>();
        Stack<Vertex<Integer>> result = sort.topSort(graph);
        while(!result.isEmpty()){
            System.out.println(result.pop());
        }
    }

}
