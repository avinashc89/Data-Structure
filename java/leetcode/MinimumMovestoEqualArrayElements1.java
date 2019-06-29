package com.tool.java.leetcode;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElements1
{
        //using median. sort the array and mid elem is median. 
        //now calc how much left should increase and right should decrease => right - left
        public int minMoves2(int[] nums) {
        
        if(nums==null||nums.length<2){
            return 0;
        }
        Arrays.sort(nums);
       
        int res =0;
        for(int i=0, j= nums.length-1; i<j ; i++,j--)
        {
            res+=nums[j]-nums[i];
        }
       
        return res;
        
    }
 
}
