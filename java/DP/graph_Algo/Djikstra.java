package com.tool.java.DP.graph_Algo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Djikstra
{
    

    
    
    /*Using Djikstra => Single Source Shortest Path Graph Algorithm
    Usecase : to find the shortest path from node k to all the nodes in the graph (directed/undirected) for non negative weights
    
    build a graph => either matrix or two maps 
    {2,1,1},{2,3,5},{1,3,2},{3,4,1}
    
    2->1 with weight 1
    2->3 with weight 5
    1->3 with weight 2
    3->4 with weight 1
    
    build graph <map<map>> or matrix
    {1={3=2}, 2={1=1, 3=5}, 3={4=1}}
      
    using priority queue (minheap), lets say start node is 2 => put [2,0] => [k, distance from k]
    
    start the iteration until queue is empty 
             pop the node n. get the current distance from k => dis
             read the adjacent nodes of n => 1,3 put it in the node [1, 1+dis], [3, 5+dis] if not visited.
    
     here, for any node, n, the one with shorted distance from k is at the top of the min heap.
     
    */
    
    
    public static int networkDelayTime(int[][] times, int N, int K) 
    {
        //build a graph => either matrix or two maps
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] edge : times) {
            map.putIfAbsent(edge[0], new HashMap<>());
            map.get(edge[0]).put(edge[1], edge[2]);
        }
        
        System.out.println(map);
        
        //int[] => <node,shorest ditance to reach from k>
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //add source with min distance to reach node = 0 
        queue.add(new int[]{K, 0});
        Set<Integer> visited = new HashSet<>();
        int ans = 0;

        while (queue.size() > 0) {
            int[] cur = queue.remove();
            if (visited.contains(cur[0])) continue;
            visited.add(cur[0]);
            ans = cur[1];

            if (map.containsKey(cur[0])) {
                for (int next : map.get(cur[0]).keySet()) {
                    queue.add(new int[]{next, cur[1] + map.get(cur[0]).get(next)});
                }
            }
        }
        return visited.size() == N ? ans : -1;
    }
    
    public static void main (String[] args)
    {
        int N =4; int K=2;
        System.out.println(networkDelayTime(new int[][]{{2,1,1},{2,3,5},{1,3,2},{3,4,1}}, N, K));
    }



}
