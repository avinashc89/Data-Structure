package com.tool.java.leetcode;

public class GuessGame
{
    /*
     The question asks us to find the minimum money we need to pay in the worst scenario. 
     The hint suggests its a minimax problem.
      I think try to understand the whole algorithm is too complicated. 
      Let's explain it in an easy way. Given range [lower, upper] and a number y, 
      we want to find the minimum money we need to pay before we make the correct guess.
      For a wrong guess x != y, we know the  next guess lies in [lower, x - 1] or [x + 1, upper], 
      the worst scenario exists in the maximum of the money to pay between these two ranges. 
      So the minimum money we need to pay in range [lower, upper] is:
             Math.min(money[lower][upper], Math.max(solve(lower, x - 1), 
                                 solve(x + 1, upper))) 

     */
    
    public int getMoneyAmount(int n) {
        int[][] money = new int[n + 1][n + 1];
        return solve(money, 1, n);
    }
     
    public int solve(int[][] money, int lower, int upper) {
        if (lower >= upper) {
            return 0;
        }
        if (money[lower][upper] != 0) {
            return money[lower][upper];
        }
        money[lower][upper] = Integer.MAX_VALUE;
        for (int i = lower; i <= upper; i++) {
            money[lower][upper] = Math.min(money[lower][upper], 
                            Math.max(solve(money, lower, i - 1), solve(money, i + 1, upper)) + i);
        }
        return money[lower][upper];
    }
    
    public static void main (String[] args)
    {
        GuessGame g = new GuessGame();
        
        g.getMoneyAmount(10);
    }

}
