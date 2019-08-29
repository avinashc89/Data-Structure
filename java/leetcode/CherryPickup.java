package com.tool.java.leetcode;

import java.util.Arrays;

public class CherryPickup
{
    /*
     * can travel two trip from topleft to bottomright(moving right or bottom)
     * and back to topleft(moving left or top) 
     * 
     * Input: grid = [ [0, 1, -1], 
     *                 [1, 0, -1], 
     *                 [1, 1,  1] ] 
     * Output: 5 (trip1 picks 4 cherry and trip2 picks 1 => total=5)
     *
     * 
     Ref: https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-741-cherry-pickup/
     Solution: DP / Recursion with memoization.
     
    Key observation: (0,0) to (n-1, n-1) to (0, 0) is the same as (n-1,n-1) to (0,0) twice (using strategy of moving left or up)

    Two people A,B  starting from (n-1, n-1) and go to (0, 0).
    They move one step (left or up) at a time simultaneously. 
    They pick up the cherry within the grid (if there is one).
    if they ended up at the same grid with a cherry. Only one of them can pick up it.
    
    lets say,   A is at x1,y1
                B is at x2,y2
    
    and dp(x1,y1,x2,y2) represents the max no of cherry picked up. we done need to calculate y2 using below explataion to reduce space&time complexity to N^3
    
    A at (x1, y1)  
    B at (x2, y2) = > (x2, x1 + y1 - x2)
    because we can only go left and up, so we have x1 + y1 = x2 + y2, since the number of steps has to be same. 
    when travel either, up/left, the no of steps taken by person A should be same as the B. 
    
    So, dp(x1, y1, x2) computes the max cherries if start from {(x1, y1), (x2, y2)} to (0, 0), which is a recursive function.
    
    Since two people move independently, A&B could have come from:  
       A    B
    (left, left),   => dp(x1-1,y1,x2-1)
    (left, up),     => dp(x1-1,y1,x2)
    (up, left),     => dp(x1,y1-1,x2-1)
    (left, up).     => dp(x1,y1-1,x2)
     
    so, the max cherry pick = pick by B at curr pos  + pick by A at curr pos + max( above previous positions)
    
    also make sure, if both A&B are currently in same position, they pick only once
    
    dp(x1, y1, x2)= g[y1][x1] + g[y2][x2] + max{dp(x1-1,y1,x2-1), dp(x1,y1-1,x2-1), dp(x1-1,y1,x2), dp(x1,y1-1,x2)}
          
     consider moving left => x1 - 1, y1, x2 - 1, y2  => lets say initial pos is 2,2. moving left indicted=> 1,2 in the grid =>
     represnted by grid(y1,x1)
     in short => x is moving left => moving j
              => y is moving up  => moving i in the grid
    
     
     */
    private static int[][] mat;
    private static int[][][] dp;

    
    //bottom up approach
    public static int cherryPickup (int[][] grid)
    {
        mat = grid;
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        return Math.max(0, dp(n - 1, m - 1, n - 1));
    }

    private static int dp (int x1, int y1, int x2)
    {
        final int y2 = x1 + y1 - x2;
        if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0)
            return -1;

        if (mat[y1][x1] < 0 || mat[y2][x2] < 0) // thorn in grid
            return -1;

        if (x1 == 0 && y1 == 0)
            return mat[0][0];

        if (dp[x1][y1][x2] != Integer.MIN_VALUE)
            return dp[x1][y1][x2];

        dp[x1][y1][x2] = Math.max(
            Math.max(dp(x1 - 1, y1, x2 - 1), dp(x1, y1 - 1, x2)),
            Math.max(dp(x1, y1 - 1, x2 - 1), dp(x1 - 1, y1, x2)));

        if (dp[x1][y1][x2] >= 0) {
            dp[x1][y1][x2] += mat[y1][x1];
            if (x1 != x2 && y1 != y2)
                dp[x1][y1][x2] += mat[y2][x2];
        }

        return dp[x1][y1][x2];
    }

    public static void main (String[] args)
    {
        int[][] grid = { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 1, 1 } };

        int[][] grid1 = { { 0, -1 }, { -1, 1 } };
        System.out.println(cherryPickup(grid));
    }

    
    //top down approach
    public static int cherryPickup1 (int[][] grid)
    {
        int n = grid.length;
        int[][][] dp = new int[n + 1][n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        dp[1][1][1] = grid[0][0];
        for (int x1 = 1; x1 <= n; x1++) 
        {
            for (int y1 = 1; y1 <= n; y1++) 
            {
                for (int x2 = 1; x2 <= n; x2++) 
                {
                    int y2 = x1 + y1 - x2;
                    if (dp[x1][y1][x2] > 0 || y2 < 1 || y2 > n
                        || grid[x1 - 1][y1 - 1] == -1 || grid[x2 - 1][y2 - 1] == -1)
                    {
                        continue;
                        // have already detected || out of boundary || cannot
                        // access
                    }
                    int cur = Math.max(
                        Math.max(dp[x1 - 1][y1][x2], dp[x1 - 1][y1][x2 - 1]),
                        Math.max(dp[x1][y1 - 1][x2], dp[x1][y1 - 1][x2 - 1]));
                    if (cur < 0) 
                    {
                        continue;
                    }
                    dp[x1][y1][x2] = cur + grid[x1 - 1][y1 - 1];
                    if (x1 != x2) {
                        dp[x1][y1][x2] += grid[x2 - 1][y2 - 1];
                    }
                }
            }
        }
        return dp[n][n][n] < 0 ? 0 : dp[n][n][n];
    }

}
