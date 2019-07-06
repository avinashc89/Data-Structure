package com.tool.java.leetcode;

public class TrianglesInGraph
{
    public static int totalNumberOfTriangles(int[][] edges, int vCount)
    {
        //build a matrix
        int[][] graph = new int[vCount][vCount];

        for(int[] edge : edges)
        {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        int[][] aux2 = new int[vCount][vCount];   
        
        int[][] aux3 = new int[vCount][vCount]; 
    
        // with 0 
        for (int i = 0; i < vCount; ++i) 
        { 
            for (int j = 0; j < vCount; ++j) 
            { 
                aux2[i][j] = aux3[i][j] = 0; 
            } 
        } 
    
        multiply(graph, graph, aux2, vCount); 
    
        multiply(graph, aux2, aux3, vCount); 
    
        int trace = getTrace(aux3, vCount); 
   
        return trace / 6;

    }

    static void multiply(int A[][], int B[][], 
                  int C[][], int V) 
    { 
        for (int i = 0; i < V; i++) 
        { 
            for (int j = 0; j < V; j++) 
            { 
                C[i][j] = 0; 
                for (int k = 0; k < V; k++) 
                { 
                    C[i][j] += A[i][k]* B[k][j]; 
                } 
            } 
        } 
    } 
    
    static int getTrace(int graph[][], int V) 
    { 
        int trace = 0; 
   
        for (int i = 0; i < V; i++) 
        { 
            trace += graph[i][i]; 
        } 
        return trace; 
    } 

    public static void main (String[] args)
    {
        int N=6;
        int grid[][] = {{0,1}, {3,0}, {0,2}, {3,2}, {1,2}, {4,0}, {3,4}, {3,5}, {4,5}, {1,5}, {1,3}};
        int grid1[][] = {{0,1},{1,2},{2,3},{0,3},{0,2}};
        totalNumberOfTriangles(grid1, 4);
        countTriangle(grid, N, false);
    }
    
    // checking triplelet have 1 ie., connected,
    // for i,j,k, => i,k & i,j & k,j should have 1
    
    static int countTriangle(int edges[][], int vCount ,
                      boolean isDirected) 
    { 
        int[][] graph = new int[vCount][vCount];

        for(int[] edge : edges)
        {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        
        int count_Triangle = 0; 
      
        for (int i = 0; i < vCount; i++) 
        { 
            for (int j = 0; j < vCount; j++) 
            { 
                for (int k = 0; k < vCount; k++) 
                { 
                   if (graph[i][j] ==1 && graph[j][k] ==1 && graph[k][i] ==1) 
                      count_Triangle++; 
                 } 
            } 
        } 
        count_Triangle = isDirected? count_Triangle/3 :  count_Triangle/6; 
      
        return count_Triangle; 
    } 
}
