package com.tool.java.DP.graph_Algo;

import java.util.*;

public class MinimumSpanningTreeKruskal
{
    /*
      Greedy algorithm => so we sort first to get the min at first
      S: O(E+V)  T:(ElogE + E)
      given a undirected graph, minimum cost to travel from node A to node B such that each is visited only once.
      
      https://www.youtube.com/watch?v=fAuF0EuZVCk&list=PLrmLmBdmIlpu2f2g8ltqaaCZiq6GJvl1j&index=3
      
      AD1,DE6,AB3,DB3,DC1,BC1,CE5,CF4,EF2
      
      first sort all vertex-edges 
      
      AD1,DC1,BC1,EF2,AB3,DB3,CF4,CE5,DE6
      
      apply disjointset union on T[0],T[1]
      
      if same parent ignore. 
     */
    static class DSU {
        private int[] parent;
        public List<String> edgesOfMST = new ArrayList<String>();

        public DSU(int N) {
            parent = new int[N];  //  the rank for all elements is 0
            // initially for all element, they are their own parent
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }
        
        // recurse till parent of x is same as itself. ie., x
        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        private void union(String edge) {
            int parentX = find(edge.charAt(0));
            int parentY = find(edge.charAt(1));
            if (parentX == parentY) return;  //if both are in same dS
            else
            {
                edgesOfMST.add(edge);
                parent[edge.charAt(0)]  = edge.charAt(1);
            }
                
           
        }
    }
    
    
    //cant run
    public static void main (String[] args)
    {
        int N = 6;  // 6 vertices
        DSU dsu = new DSU(N);
        String[] edges =new String[]{"AD1","DC1","BC1","EF2","AB3","DB3","CF4","CE5","DE6"};
        
        for(String s : edges)
        {
            dsu.union(s);
        }
        System.out.println(dsu.edgesOfMST);
        
    }

    
    

}
