package com.tool.java.DP.matrix_Graph;


public class LongestIncreasingPath {
    
    /* Using DFS. walk to neighbours(x,y) if grid(i,j) < neighbours(x,y), in all four directions. return the maxlen of four direction. 
     * if t{x,y} is already calc ie., >0 , return it. => DP
     
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
      
        //dynamic programming to return if already calculated
        if(dp[i][j] > 0){
            return dp[i][j];
        }
        
        int maxLen = 0;

        for(int d = 0; d < dir.length; d++)
        {
            int r = i+dir[d][0];
            int c = j+dir[d][1];
            if(!isSafe(mat, r, c) || mat[r][c] <= mat[i][j]){       //checking if increasing path
                continue;
            }
            
            int pathLen = 1+walk(mat, r, c); 
            maxLen = Math.max(maxLen, pathLen);  // each direction can bring different len. get the maxlen
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