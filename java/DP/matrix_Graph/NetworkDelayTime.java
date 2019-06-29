package com.tool.java.DP.matrix_Graph;

import java.util.*;

public class NetworkDelayTime
{
 
    
    //Using Djikstra => Single Source Shortest Path Graph Algorithm
    // used to find the shortest path from node k to all the nodes in the graph
    
    public static int networkDelayTime(int[][] times, int N, int K) 
    {
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
        System.out.println(networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, N, K));
    }

}
