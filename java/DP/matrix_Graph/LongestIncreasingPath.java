package com.tool.java.DP.matrix_Graph;


public class LongestIncreasingPath {
    
    /*
     
     Input: nums = 
                [
                  [9,9,4],
                  [6,6,8],
                  [2,1,1]
                ] 
                Output: 4 
                =>9,6,2,1

     */
    private static final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int[][] dp;

    public static int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        if(matrix.length == 1 && matrix[0].length == 1){
            return matrix[0][0];
        }
        
        dp = new int[matrix.length][matrix[0].length];
        int maxLen = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                int pathLen = 1+walk(matrix, i, j);
                maxLen = Math.max(maxLen, pathLen);
            }
        }

        return maxLen;
    }

    public static int walk(int[][] mat, int i, int j){
        if(dp[i][j] > 0){
            return dp[i][j];
        }

        int maxLen = 0;

        //wal to all 4 directions // or split into 4 ifs
        for(int d = 0; d < dir.length; d++){
            int r = i+dir[d][0];
            int c = j+dir[d][1];

            //if not safe or not incerasing then prune this path
            if(!isSafe(mat, r, c) || mat[r][c] <= mat[i][j]){
                continue;
            }

            //other wise do a dfs walk
            int pathLen = 1+walk(mat, r, c);
            maxLen = Math.max(maxLen, pathLen);
        }

        //update dp table for current position i,j
        dp[i][j] = maxLen;
        return maxLen;
    }

    private static boolean isSafe(int mat[][], int i, int j){
        if(i >= mat.length || i < 0 || j >= mat[0].length || j < 0){
            return false;
        }

        return true;
    }
    
    public static void main (String[] args)
    {
        int[][] nums = 
        {
             {9,9,4},
             {6,6,8},
             {2,1,1}
             } ;
        
        System.out.println(longestIncreasingPath(nums));
    }
}