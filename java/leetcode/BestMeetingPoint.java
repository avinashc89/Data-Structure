package com.tool.java.leetcode;

import java.util.LinkedList;
import com.tool.java.Util;

public class BestMeetingPoint
{

    /*method 1: 
        find the minimum distance ppl can travel north or south. (row wise)
        find the minimim distance ppl can travel east or west (column wise).
        add both.
     */

    static final Integer INF = Integer.MAX_VALUE;

    public static int minTotalDistance(int[][] grid) {

        if (grid == null) {
            throw new NullPointerException();
        }

        int rows = grid.length;
        int columns = grid[0].length;
        if (rows == 0 || columns == 0) {
            return 0;
        }


        int[] NofPplInRowWise = new int[grid.length];
        int[] NofPplInColumnWise = new int[grid[0].length];
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j=0 ; j<grid[0].length ; j++)
            {
                NofPplInRowWise[i] +=  grid[i][j];
                NofPplInColumnWise[j] +=  grid[i][j];
            }
        }

        int minColDist = calculateMinDist(NofPplInRowWise);
        int minRowDist = calculateMinDist(NofPplInColumnWise);

        return minColDist + minRowDist;
    }

    /*
         {1,0,0,0,1},         2     now calculate the minimum distance to move so that all are in same row. 
         {0,0,1,0,0},    =>   1     if 2 ppl move 1 step down => total 2 steps => now mving to next step there are three ppl => 2(already travelled)+3 = 5
         {0,0,0,0,0}          0     if 0 ppl move 1 step up => total 0 steps => now moving 1 ppl to top => 1 step 
     */

    static int[] NofPplInRow(int[][] grid) {

        int[] NofPplInRowWise = new int[grid.length];
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j=0 ; j<grid[0].length ; j++)
            {
                NofPplInRowWise[i] +=  grid[i][j];
            }
        }

        return NofPplInRowWise;

    }


    /*
        {1,0,1,0,1}    
             ||
        {1,0,0,0,1},        
        {0,0,1,0,0},       similar approach for column travel.
        {0,0,0,0,0}          
     */

    static int[] NofPplInColumn(int[][] grid) {

        int[] NofPplInColumnWise = new int[grid[0].length];
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j=0 ; j<grid[0].length ; j++)
            {
                NofPplInColumnWise[j] +=  grid[i][j];
            }
        }
        return NofPplInColumnWise;

    }

    static int calculateMinDist(int[] houseArray) {

        int n = houseArray.length;

        int[] prefixDist = new int[n];
        int[] suffixDist = new int[n];

        int prefixCount = houseArray[0];
        for (int i = 1; i < n; i++) {
            prefixDist[i] = prefixDist[i - 1] + prefixCount;
            prefixCount += houseArray[i];
        }
        
        int suffixCount = houseArray[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixDist[i] = suffixDist[i + 1] + suffixCount;
            suffixCount += houseArray[i];
        }
        //[0, 2, 5] top to bottom  for row wise.        => 2 1 0 => 
        //[1, 0, 0] bottom to top.                      => 0 2 0 
        //    2                                         => 0 2 5
        //    1
        //    0
        
        int min = prefixDist[n-1];
        for(int i = 0 ; i< houseArray.length ;i++)
            min = Math.min(min, prefixDist[i] + suffixDist[i]);

        return min; //1 for row
    }       




    public static void main (String[] args)
    {
        int[][] grid = new int[][]{ {1,0,0,0,1}, 
            {0,0,1,0,0},  
            {0,0,0,0,0}};

            System.out.println(minTotalDistance(grid));   


    }


    //method 2: using dfs
    public static int shortestDistance(int[][] grid) {
        int[][] distance = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, distance, i, j);
                    Util.printMatrix(distance);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {              
                result = Math.min(result, distance[i][j]);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
    private static void dfs(int[][] grid, int[][] distance, int i, int j) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        Util.printMatrix(visited);
        LinkedList<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.offer(new int[]{i, j, 1});

        while (!q.isEmpty()) {
            int[] head = q.poll();
            int dis = head[2];

            for (int k = 0; k < 4; k++) {
                int x = head[0] + dx[k];
                int y = head[1] + dy[k];

                if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !visited[x][y]) {
                    visited[x][y] = true;    //make visited
                    distance[x][y] += dis;
                    q.offer(new int[]{x, y, dis + 1});
                }
            }
        }
    }
}
