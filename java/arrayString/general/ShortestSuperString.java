package com.tool.java.arrayString.general;

public class ShortestSuperString
{

    //Given an array A of strings, find any smallest string that contains each string in A as a substring.

    //Input: ["catg","ctaagt","gcta","ttca","atgcatc"]
    //Output: "gctaagttcatgcatc"

    //this is NP complete problem. No efficient solution. 

    /*
     SuperString can be obtained by overlapping the two adjacent string
     overlapping -check prefix of s1 matches with suffix of s2

     for ex : AAA AAB ABA ABB BAA BAB BBA BBB (in alphabetical order)
       SS =>   AAABABBAABAABABBABBB 
       if it was order differently , we can get longer/shorter SS.
       So we need to try all the n! order and do the overlapping to get the min SS.

    or can use TPS
     */

    private int n;
    private int[][] dp;
    private String[] a;
    private int best_len;
    private int[] path;
    private int[] best_path;

    private void tps(int curr_indx, int visited, int cur_len) {
        if (cur_len >= best_len)           // no need to travel more.
            return;
        if (curr_indx == n) {                   //visited all strings, 
            best_len = cur_len;
            best_path = path.clone();
            return;
        }

        for (int string = 0; string < n; string++) {
            int k = 1 << string ;
            if ((visited & k) != 0) 
                continue;    // string is visited 
            
            //else mark as visited and use it in the path
            path[curr_indx] = string;

            //increment visited , make visited for that string,  
            // if its a first string, then currlen is total string length
            //          or curr_len + dp[start,destination]=>dp[what was previously visited][currstirng]=> dp[path[curr_indx-1][string]]
            
            tps(curr_indx + 1,  visited | k,  curr_indx == 0 ? a[string].length() : cur_len + dp[path[curr_indx - 1]][string]);
        }
    }

    
    public String shortestSuperstring(String[] A) {
        n = A.length;
        dp = new int[n][n];
        a = A;
        for (int i = 0; i < n; ++i) 
        {
            for (int j = 0; j < n; ++j) 
            {
                dp[i][j] = A[j].length();
                for (int k = 1; k <= Math.min(A[i].length(), A[j].length()); ++k) 
                {
                    if (A[i].substring(A[i].length() - k).equals(A[j].substring(0, k)))
                    {
                        dp[i][j] = A[j].length() - k; 
                    }
                }
            }
        }

        path = new int[n];
        best_len = Integer.MAX_VALUE;

        tps(0, 0, 0);

        String ans = A[best_path[0]];
        for (int k = 1; k < n; ++k) {
            int i = best_path[k - 1];
            int j = best_path[k];
            ans += A[j].substring(A[j].length() - dp[i][j]);      
        }
        System.out.println(ans);
        return ans;
    }
    
    public static void main (String[] args)
    {
        ShortestSuperString ss = new ShortestSuperString();
        ss.shortestSuperstring(new String[]{"AAA","AAB","ABA","ABB","BAA","BAB","BBA","BBB"});
    }

}
