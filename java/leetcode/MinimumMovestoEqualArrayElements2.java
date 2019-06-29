package com.tool.java.leetcode;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElements2
{
     /*
      Input:
    [1,2,3]
    
    Output:
    3
    
    Explanation:
    Only three moves are needed (remember each move increments two elements):
    
    [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

    every move  n - 1  elements incremented by 1.
      
     1. lets say => final array is [x x x] => means for sure min element is added m times to read x.
      
      => min + m = x
      
     2. we also know then over all (n-1) elements is increased by m times to obtain [x x x]
      
      => x * n = (initial sum) + m*(n-1)  
      
      solving 1&2 =>
      =>( min + m ) * n= (initialsum) + m(n-1)
      =>  min*n + m*n = (initialsum) + m*n -m
      => min*n - (initialsum) = -m
      => m = (initialsum) -  (min*n)
      
      */
    
    public static int minMoves(int[] nums) {
        
        if(nums==null||nums.length<2){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0; i< nums.length ; i++)
        {
           sum = sum + nums[i];
           min = Math.min(min, nums[i]);
        }
       
        return sum - min*nums.length;
        
    }
    
    public static void main (String[] args)
    {
        System.out.println(minMoves(new int[]{1,2,3}));
    }
 
}
