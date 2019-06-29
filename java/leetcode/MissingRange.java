package com.tool.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MissingRange
{
    /*
     //sorted
     Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
            Output: ["2", "4->49", "51->74", "76->99"]
            
     Input: nums = [0, 1, 3, 50, 75], lower = 12 and upper = 99,
            Output: ["12->49", "51->74", "76->99"]
     
      Input: nums = [0, 1, 3, 50, 75], lower = 50 and upper = 99,
            Output: ["51->74", "76->99"]
            
        step1 = lower to first number
        step 2= iterate comparing a[i-1] a[i] i=1->n
        step 3= last number to upper
     */

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) 
        {
            if (lower == upper) {
                res.add(String.valueOf(lower));
            } else if (lower < upper) {
                res.add(lower + "->" + upper);
            }
            return res;
        }
        
        
        int n = nums.length;
        
        //lower to first number
        if (nums[0] != Integer.MIN_VALUE) {
            if(lower == nums[0]-1)
                res.add(String.valueOf(lower));
            else if(lower < nums[0]-1)
                res.add(lower +"->"+(nums[0]-1));
                
        }
        
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] != nums[i]) 
            {
                if( nums[i-1]+1 == nums[i]-1)                    // 3 5 => 3+1 = 5-1 then only choose 4
                    res.add(String.valueOf(nums[i-1]+1));
                else if(nums[i-1]+1 < nums[i]-1)                         // 3 6 => 3+1 to 6-1
                    res.add(nums[i-1]+1 +"->"+(nums[i]-1));
            }
        }
        
        ///last number to upper
        if (nums[n - 1] != Integer.MAX_VALUE) {
            if(nums[n - 1] == upper-1)
                res.add(String.valueOf(upper));
            else if(nums[n - 1] < upper-1)
                res.add((nums[n - 1]+1) +"->"+upper);
        }
        return res;
    }
    
    public static int findBinaryInsertIndex(int[] nums, int k)
    {
        int l= 0;
        int r = nums.length-1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid] == k)
                return k;
            else if( nums[mid] > k)
                r = mid;
            else
                l= mid+1;
        }
        return l;
    }
    
    public static void main (String[] args)
    {
       System.out.println( findMissingRanges(new int[]{0, 1, 3, 50, 75}, 12,99));
    }
}
