package com.tool.java.leetcode;

import java.util.LinkedList;
import com.tool.java.Util;

public class ShortestDistanceFromAllBuilding
{
    public static int shortestDistance(int[][] grid) {
       
        int[][] distance = new int[grid.length][grid[0].length];
        int[][] hits = new int[grid.length][grid[0].length];
     
        int numBuilding = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, distance, hits, i, j);
                    Util.printMatrix(distance);
                    numBuilding++;
                }
            }
        }
     
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && hits[i][j] == numBuilding) {
                    result = Math.min(result, distance[i][j]);
                }
            }
        }
     
        return result == Integer.MAX_VALUE ? -1 : result;
       
    }
    
    private static void dfs(int[][] grid, int[][] distance, int[][] hits, int i, int j) {
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
     
        LinkedList<int[]> q = new LinkedList<>();
     
        q.offer(new int[]{i, j, 1});
     
        while (!q.isEmpty()) {
            int[] head = q.poll();
            int dis = head[2];
     
            for (int k = 0; k < 4; k++) {
                int x = head[0] + dx[k];
                int y = head[1] + dy[k];
     
                if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 0) {
                    grid[x][y] = -1;    //make visited
                    distance[x][y] += dis;
                    hits[x][y]++;
                    q.offer(new int[]{x, y, dis + 1});
                }
            }
        }
     
        // make unvisited for next dfs
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                if (grid[m][n] == -1) {
                    grid[m][n] = 0;
                }
            }
        }
    }
    
    public static void main (String[] args)
    {
        int[][] grid = new int[][]{ {1,1,0,0,1}, 
                                    {0,0,0,0,0},  
                                    {0,0,1,0,0}};
                                  
        System.out.println(shortestDistance(grid));   
        
        
    }

}
