package com.tool.java.DP.graph_Algo;

import java.util.Deque;
import java.util.LinkedList;
import com.tool.java.Util;

public class FloydWarshall_AnyPairShortestPath
{
    /*
     https://www.youtube.com/watch?v=LwJdNfdLF9s&list=PLrmLmBdmIlpu2f2g8ltqaaCZiq6GJvl1j&index=8
     
     to find the min distance & its path any two nodes. 
     (BellmanFord can be used but the Time complexity is more when we want to find min path between all the nodes. )
    
      Using 
    
    */

    private static final int INF = 1000000;
    public  static int[][] allPairShortestPath(int[][] distanceMatrix)
    {

        int distance[][] = new int[distanceMatrix.length][distanceMatrix.length];
        int path[][] = new int[distanceMatrix.length][distanceMatrix.length];

        // build distance matix and path matrix
        for (int i=0; i < distanceMatrix.length; i++) {
            for (int j=0; j< distanceMatrix[i].length; j++){
                distance[i][j] = distanceMatrix[i][j];
                if (distanceMatrix[i][j] != INF && i != j) {
                    path[i][j] = i;
                } else {
                    path[i][j] = -1;
                }
            }
        }
        /*
                0    1    2    3
            0  {0,   3,   6,   15},
            1  {INF, 0,  -2,   INF},              =>ex: {u,v,w} => {0,1,3}
            2  {INF, INF, 0,   2},
            3  {1,   INF, INF, 0}
              
            0  ,3  ,6  ,15  ,
            1000000  ,0  ,-2  ,1000000  ,
            1000000  ,1000000  ,0  ,2  ,
            1  ,1000000  ,1000000  ,0  ,
        
         
         [[-1, 0, 0, 0], 
          [-1, -1, 1, -1],
          [-1, -1, -1, 2],
          [3, 0, 0, -1]]
         */
        Util.printMatrix(distance);
        System.out.println("");
        Util.printMatrix(path);

        for(int k=0; k < distanceMatrix.length; k++){
            for(int i=0; i < distanceMatrix.length; i++){
                for(int j=0; j < distanceMatrix.length; j++){
                    
                    //=> the path from i to j via k => check if dis[i,j] > dis[i,k] + dis[k,j]
                    
                    if(distance[i][k] == INF || distance[k][j] == INF) {
                        continue;
                    }
                    if(distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }
        
        //look for negative weight cycle in the graph
        //if values on diagonal of distance matrix is negative
        //then there is negative weight cycle in the graph.
        for(int i = 0; i < distance.length; i++) {
            if(distance[i][i] < 0) {
                System.out.println("negative cyclic exist ");
            }
        }
        
        
        return distance;
    }
    
    /*
                  0    1    2    3
              0  {0,   3,   6,   15},
              1  {INF, 0,  -2,   INF},              =>ex: {u,v,w} => {0,1,3}
              2  {INF, INF, 0,   2},
              3  {1,   INF, INF, 0}
                
     */
    
    
    
    public static void main(String args[]){
        int[][] graph = {
                {0,   3,   6,   15},
                {INF, 0,  -2,   INF},
                {INF, INF, 0,   2},
                {1,   INF, INF, 0}
        };

        int[][] distance = allPairShortestPath(graph);
        System.out.println("Minimum Distance matrix");
        for(int i=0; i < distance.length; i++){
            for(int j=0; j < distance.length; j++){
                System.out.print(distance[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    /*
     *    [[-1, 0, 0, 0], 
          [-1, -1, 1, -1],
          [-1, -1, -1, 2],
          [3, 0, 0, -1]]
     */
    
    
    public void printPath(int[][] path, int start, int end) {
        if(start < 0 || end < 0 || start >= path.length || end >= path.length) {
            throw new IllegalArgumentException();
        }

        System.out.println("Actual path - between " + start + " " + end);
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(end);
        while (true) {
            end = path[start][end];
            if(end == -1) {
                return;
            }
            stack.addFirst(end);
            if(end == start) {
                break;
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pollFirst() + " ");
        }

        System.out.println();
    }
}
