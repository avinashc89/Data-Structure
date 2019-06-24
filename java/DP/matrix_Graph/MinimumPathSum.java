package com.tool.java.DP.matrix_Graph;

public class MinimumPathSum
{
    
    // using DP array [][]
    // Given a m x n grid filled with non-negative numbers, 
    // find a path from top left to bottom right which minimizes the sum of all numbers along its path.
    
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length==0)
            return 0;
     
        int m = grid.length;
        int n = grid[0].length;
     
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];    
     
        // initialize top row => dp[prev col cell](left) + a[curr cell]
        for(int j=1; j<n; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
     
        // initialize left column => dp[prev row cell](up) + a[curr cell]
        for(int i=1; i<m; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
     
        // fill up the dp table
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];   //curr cell + min(left & above)
            }
        }
        return dp[m-1][n-1];
    }
    
}
