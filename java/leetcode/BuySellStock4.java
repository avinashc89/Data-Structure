package com.tool.java.leetcode;

public class BuySellStock4
{
    
    int maxProfit(int price[],  
                         int n, int k) 
    { 
          
        // table to store results of subproblems 
        // profit[t][i] stores maximum profit 
        // using atmost t transactions up to day 
        // i (including day i) 
        int profit[][] = new int[k + 1][ n + 1]; 
  
        // For day 0, you can't earn money 
        // irrespective of how many times you trade 
        for (int i = 0; i <= k; i++) 
            profit[i][0] = 0; 
  
        // profit is 0 if we don't do any  
        // transation (i.e. k =0) 
        for (int j = 0; j <= n; j++) 
            profit[0][j] = 0; 
  
        // fill the table in bottom-up fashion 
        for (int i = 1; i <= k; i++)  
        { 
            int prevDiff = Integer.MIN_VALUE; 
            for (int j = 1; j < n; j++)  
            { 
                prevDiff = Math.max( profit[i - 1][j - 1] - price[j - 1], prevDiff); 
                
                profit[i][j] = Math.max(profit[i][j - 1],  
                               price[j] + prevDiff); 
            } 
        } 
  
        return profit[k][n - 1]; 
    } 
    public static void main (String[] args)
    {
        BuySellStock4 b =  new BuySellStock4();
        b.maxProfit( new int[]{2,5,7,1,4,3,1,3},8, 3);
    }

}
