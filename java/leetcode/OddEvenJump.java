package com.tool.java.leetcode;

import java.util.TreeMap;

public class OddEvenJump
{
    
    public int oddEvenJumps(int[] A) {
        boolean[][] dp = new boolean[A.length][2];
        int N = A.length-1;
        int count = 1;
        dp[N][0] = dp[N][1] = true;
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        tree.put(A[N], N);
        for (int i=N-1; i>=0; i--) {
            if (tree.containsKey(A[i])) {
                dp[i][0] = dp[tree.get(A[i])][1];
                dp[i][1] = dp[tree.get(A[i])][0];
            } else {
                Integer odd = tree.higherKey(A[i]);
                Integer even = tree.lowerKey(A[i]);
                if (odd!=null) {
                    dp[i][0] = dp[tree.get(odd)][1];        //this jump is odd the next jump is even. dp[tree.get(odd)][1] gives the value for next jump. 
                }                                           // so if next even jump is true  then  current odd jump is true.
                if (even!=null) {
                    dp[i][1] = dp[tree.get(even)][0];
                }
            }
            tree.put(A[i], i);
            if (dp[i][0]) count++;
        }
        return count;
    }
    
    public static void main (String[] args)
    {
        OddEvenJump j = new OddEvenJump();
        j.oddEvenJumps(new int[]{10,13,12,14,15});
    }

}
