package com.tool.java.leetcode;

import java.util.Arrays;

public class BookShelfFilling
{
    /*
     Input: books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelf_width = 4
    Output: 6
    Explanation:
    The sum of the heights of the 3 shelves are 1 + 3 + 2 = 6.
    Notice that book number 2 does not have to be on the first shelf.

     */
    public static int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 999999999);
        dp[0] = 0;
        for(int i = 1;i <= n;i++){
            int rem = shelf_width;
            int max = 0;
            for(int j = i-1;j >= 0;j--){
                rem -= books[j][0];
                max = Math.max(max, books[j][1]);
                if(rem >= 0){
                    dp[i] = Math.min(dp[i], dp[j] + max);
                }
            }
        }
        return dp[n];
    }
    
    public static void main (String[] args)
    {
        minHeightShelves( new int[][]{{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}},4);
    }

}
