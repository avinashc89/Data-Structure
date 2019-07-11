package com.tool.java.leetcode;

public class New21Game
{
    /*
     say there are W events, x+1, x+2, ...x+W  => total probability = f(x+1) +f(x+2) +...+f(x+W) divided by W
      16th            17th  18th
     f(x)=( 1/w) ∗(f(x+1)+f(x+2)+...+f(x+W)) 
     
     */
    public double new21Game1(int N, int K, int W) {
        
        double[] dp = new double[K + W];
        
        // dp[x] = the answer when Alice has x points
        for (int k = K; k <= N; ++k)
            dp[k] = 1.0;
        
        
        double S = Math.min(N - K + 1, W);      // we need to find from 17 to 21 => total events = 5*1.0
        // S = dp[k+1] + dp[k+2] + ... + dp[k+W]
        for (int k = K - 1; k >= 0; --k) {
            dp[k] = S / W;
            S += dp[k] - dp[k + W];
        }
        return dp[0];
    }
    
    public double new21Game(int N, int K, int W) {
        double[] prob = new double[W + K];
        double window = 0;
        //Terminal Cases
        for (int i = K + W - 1; i >= K; i--) {
            prob[i] = (i <= N) ? 1 : 0;
            window += prob[i];
        }

        //Count down
        for (int i = K - 1; i >= 0; i--) {
            prob[i] = window / W;
            window += prob[i] - prob[i + W];
        }

        return prob[0];
    }
    
    
    public static void main (String[] args)
    {
        New21Game g = new New21Game();
        g.new21Game(21, 17, 10);
        
    }

}
