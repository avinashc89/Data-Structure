package com.tool.java.leetcode;


public class UniquePath3
{

    /*
     Input: [[1,0,0,0],
             [0,0,0,0],
             [0,0,2,-1]]
    Output: 2

    Input: [[1,0,0,0],
            [0,0,0,0],
            [0,0,0,2]]
    Output: 4

    Input: [[0,1],
            [2,0]]
    Output: 0

    we need to find unique path from 1 to 2 such that it travels thro all 0 once. -1 is obstacles

    Idea: iterate and find the number of zero(tobevisited). also the start point, when i,j ==1 
        start from start point => 
        using dfs(startx, starty, tobevisited ) => find 2, 
                for every recursion increment reduce the tobevisited by 1.
                when i,j =2 and tobevisted =0 then found path.


     */

    int count = 0;
    int[][] grid;
    int rows, cols;

    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        count = 0;

        int toVisit = 0;
        int startR = 0, startC = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == -1) continue;

                if (grid[r][c] == 1) {
                    startC = c;
                    startR = r;
                }
                toVisit++;
            }
        }

        dfs(startR, startC, toVisit);

        return count;
    }

    private static final int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    
    void dfs(int r, int c, int toVisit) {
        toVisit--;
        
        if (toVisit < 0)
            return;
        
        if (grid[r][c] == 2 && toVisit == 0) {
            count++;
            return;
        }
        
        if (grid[r][c] == -1)
            return;
        
        int temp = grid[r][c];
        grid[r][c] = 3;          // making it visited
        
        for(int[] direction : directions)
        {
            int x = r+direction[0];
            int y = c+direction[1];
            
            if(isSafe(x,y)){
                dfs(x, y, toVisit);
            }
        }
        grid[r][c] = temp;
        
    }

    private boolean isSafe (int x, int y)
    {
        if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y] !=-1 && grid[x][y]!=3)
            return true;
        return false;
    }
    
    public static void main (String[] args)
    {
        UniquePath3 u = new UniquePath3();
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        
        int[][] grid1 = {{1,0},{0,2}};
        System.out.println(u.uniquePathsIII(grid1));
    }


}
