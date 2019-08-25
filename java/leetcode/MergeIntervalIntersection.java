package com.tool.java.leetcode;

import java.util.*;

public class MergeIntervalIntersection
{
    /*
             i
      A = [[0,2],[5,10],[13,23],[24,25]], 
      B = [[1,5],[8,12],[15,24],[25,26]]
             j
     
      get the lo=max(start) & hi=min(ends) => lo=1; hi=2 => if hi is less than or equal to lo, => new set (lo,hi)
      
      if j's end is greater move i
      else move j
      
      
     */
    //Using two pointer. 
    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> ans = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (hi >= lo)
                ans.add(new int[]{lo, hi});
            if (A[i][1] > B[j][1])
                j++;
            else i++;
        }
        return ans.toArray(new int[ans.size()][2]);
    }
    
    public static void main (String[] args)
    {
        
    }

}
