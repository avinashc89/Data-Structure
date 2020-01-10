package com.tool.java.leetcode;

public class DecodeWays
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
    
    input=>     1   2   2   2   5
    ways => 1   1   2   3   5   8 
    
     */
    //O(N) : O(N)
    public int numDecodings(String s) {

        int dp[] = new int[s.length()+1];
        
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0:1;
        
        for(int i=2 ; i<= s.length() ;i++)
        {
            //the previous digit 
            if(s.charAt(i-1) > '0')
                dp[i] =  dp[i] + dp[i-1];
            
            //the previous two digit is greater than 10 and less than 27
            if(s.charAt(i-2) == '1' || s.charAt(i-2) == '2' && s.charAt(i-1) < '7' )
                dp[i] = dp[i] + dp[i-2];
            
        }
        return dp[s.length()];
    }
    
//    O(N) : O(1)
    
    public int numDecodings1(String s) {

        int a = 1;
        
        if(s.charAt(0) == '0')
            return 0;

        int b = 1;
        
        for(int i=2 ; i<= s.length() ;i++)
        {
            //the previous digit 
            int c =0;
            if(s.charAt(i-1) > '0')
                c =  c + b;
            
            //the previous two digit is greater than 10 and less than 27
            if(s.charAt(i-2) == '1' || s.charAt(i-2) == '2' && s.charAt(i-1) < '7' )
                c = c + a;
            
            a=b;
            b=c;
        }
        
        return b;
    }

    public static void main (String[] args)
    {
        DecodeWays d = new DecodeWays();
        System.out.println(d.numDecodings("12225"));
        System.out.println(d.numDecodings1("12225"));
    }
}
