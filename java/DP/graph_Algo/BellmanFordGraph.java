package com.tool.java.DP.graph_Algo;

import java.util.Arrays;

public class BellmanFordGraph
{
    
    /*
      Usecase : find the shortest path from K to all the nodes. directed/undirected with any weights
      similar to DSU idea but we need to apply V-1 times.
      
      array to store the min distance. 
      initially, any node n to reach n = Interger.max. => for node k, dist=0 => for 2=>0
      
      iterate v-1 times, 
          get an edge from edges
           ex:2,1,1 => to goes from 2 to 1 takes 1 sec =>  
               if dist taken from 0->2 + 2->1  < 0->1 
                       then update distance for 0->1 = 0->2 + 2->1 & update the parent[1] as 2.
      
      at the end of V-1 times, we can get all  min ditance from node k.
      
      do the opertion one more time. if the distance can be changed , then there is negative cyclic rotation. we cant find min dis.
      
     */
    
    //parent is not captured here. modify accordingly
    public  static int networkDelayTime(int[][] times, int N, int K) {
        int[] min = new int[N + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        
        //min distance from k to k =0
        min[K] = 0;
        
        //if any distance is updated, we need to check everything again. this is similar to doing V-1 iterations for V nodes.
        boolean updated = true;
        while (updated) {
            updated = false;
            for (int[] edge : times) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (min[u] != Integer.MAX_VALUE && (min[u] + w < min[v])) {
                    updated = true;
                    min[v] = min[u] + w;
                }
            }
        }
        
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (min[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, min[i]);
        }
        return max;
    }
    
    public static void main (String[] args)
    {
        int N =4; int K=2;
        System.out.println(networkDelayTime(new int[][]{{2,1,1},{2,3,5},{1,3,2},{3,4,1}}, N, K));
    }

}
