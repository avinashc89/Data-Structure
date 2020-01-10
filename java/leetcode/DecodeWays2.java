package com.tool.java.leetcode;

import com.tool.java.Util;

public class DecodeWays2
{

    /*
    Input: "226"
    Output: 3
    Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
    
    
    similar to fibo
    12225 => 
    
    decoding last char = xxxxE / xxxY => no of ways to decode 1222 + no of ways to decode 122
    lets say we have x ways to decode 1222 and y ways to decode 122
    then adding extra char at the end gives same number of decodes => x (with E at last) + y (with Y at last)
    
    input=>     1           2           *                    2               5
    ways => 1   1           2           24                  
                                    9*2 + 6*1
                                  (1-9)*1 + (21-26)*1    
                                  
    
    ** => 11-19 or 21-26 => 15 ways
    
    chances are (2*)  or (1*) or (**)  
    if curr is a[i-1] = *
        if a[i-2] = 2 =>6*dp[i-2]
        if a[i-2] = 1 =>9*dp[i-2]
        if a[i-2] = * => 15*dp[i-2]
    
    
    or 
    (1X) (2X) (*X) (0X)  in which *X => 10-26 => if X<7 we have( 10-16 & 20 - 26 ) else just 17-19
    
    
    
     */
    //O(N) : O(N)
    public int numDecodings(String s) {

        int dp[] = new int[s.length()+1];
        
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*'? 9 : s.charAt(0) == '0' ? 0:1;
        
        for(int i=2 ; i<= s.length() ;i++)
        {
            if(s.charAt(i-1) == '*')
            {
                dp[i] =  9*dp[i-1];
                
                if(s.charAt(i-2) == '1')
                    dp[i] = dp[i] + 9*dp[i-2];
                else if(s.charAt(i-2) == '2')
                    dp[i] = dp[i] + 6*dp[i-2];
                else if(s.charAt(i-2) == '*')
                    dp[i] = dp[i] + 15*dp[i-2];
            }
            else{                                       
                if(s.charAt(i-1) != '0')
                    dp[i] =  dp[i-1];
                
                if(s.charAt(i-2) == '1')
                    dp[i] = dp[i] + dp[i-2];
                else if (s.charAt(i-2) == '2' && s.charAt(i-1) < '7' )
                    dp[i] = dp[i] + dp[i-2];
                if(s.charAt(i-2) == '*')
                {
                    if(s.charAt(i-1) < '7')
                        dp[i] = dp[i] + 2*(dp[i-2]);
                    else
                        dp[i] = dp[i] + dp[i-2];
                }
                    
            }
        }
        return dp[s.length()];
    }
    
    public static void main (String[] args)
    {
        DecodeWays2 d = new DecodeWays2();
        System.out.println(d.numDecodings("*********"));
    }
    
    
    //based on leetcode max 
    public int numDecodings2(String s) {

        int M = 1000000007;
        long dp[] = new long[s.length()+1];
        
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*'? 9 : s.charAt(0) == '0' ? 0:1;
        
        for(int i=2 ; i<= s.length() ;i++)
        {
            if(s.charAt(i-1) == '*')
            {
                dp[i] =  9*dp[i-1];
                
                if(s.charAt(i-2) == '1')
                    dp[i] = (dp[i] + 9*dp[i-2]) % M;
                else if(s.charAt(i-2) == '2')
                    dp[i] = (dp[i] + 6*dp[i-2]) % M;
                else if(s.charAt(i-2) == '*')
                    dp[i] = (dp[i] + 15*dp[i-2]) % M;
            }
            else{                                       
                if(s.charAt(i-1) != '0')
                    dp[i] =  dp[i-1];
                else
                    dp[i] = 0;
                
                if(s.charAt(i-2) == '1')
                    dp[i] = (dp[i] + dp[i-2]) % M;
                else if (s.charAt(i-2) == '2' && s.charAt(i-1) < '7' )
                    dp[i] = (dp[i] + dp[i-2]) % M;
                if(s.charAt(i-2) == '*')
                {
                    if(s.charAt(i-1) < '7')
                        dp[i] = (dp[i] + 2*(dp[i-2])) % M;
                    else
                        dp[i] = (dp[i] + dp[i-2]) % M;
                }
                    
            }
        }
        return (int)dp[s.length()];
    }
    
}
