package com.tool.java.arrayString.subset_subseq;

public class LongestPalindromicSubsequence
{
    
   // if first and last char are same, then DP[remaining chars]+2 => DP[i][j] = DP[i+1][j-1] + 2;
    // if not equal, then max of palin formed using remaining chars => DP[i][j] = Math.max(DP[i+1][j], DP[i][j-1]);
    
    public static int LPS(String s) {
        int n = s.length();
        int DP[][] = new int[n][n]; //Table to store lengths of DP subsequences.
         
        //Trivial case: single letter palindromes
        for (int i = 0; i < n; i++) {
            DP[i][i] = 1;
        }
         
        //Finding palindromes of length 2 to n and saving the longest
        for (int curr_len = 2; curr_len <= n; curr_len++) {
          for (int i = 0; i < n-curr_len+1; i++) {
            int j = i+curr_len-1;
            if (s.charAt(i) == s.charAt(j))//Trim if match and add 2  
            {
              DP[i][j] = DP[i+1][j-1] + 2; 
            }
            else //Trim one at a time and take max
            {
              DP[i][j] = Math.max(DP[i+1][j], DP[i][j-1]);
            }
          }
        }
         
        return DP[0][n-1];
      }

  public static void main(String args[])
  {
      System.out.println(LPS("LPSSAPAL"));
  }

}
