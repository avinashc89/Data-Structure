package com.tool.java.leetcode;

import java.util.Arrays;
import com.tool.java.Util;

public class WiggleSorting
{
    
    /*
      sort such that= >  low high low high low high low. => 3,5,1,6,2,4
      
       O(nlogn)
      idea 1 = sort the array and swap the positions correctly.
          swap left and right =>
           left = 1;
           right = if even array => nums.size()-2
                   even odd array =>  nums.size()-1
           left+2
           right-2
           
            123456 => swap 2,5 => 153426 => 4,3 stop.
          
     */

    public static void wiggleSort(int[] nums) {

        Arrays.sort(nums);
        
        int left = 1;
        int right = nums.length%2==0 ? nums.length-2 : nums.length-1;
        
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left = left +2;
            right = right-2;
        }
    }
    
    /*
      O(n)
      method 2: comparing next number. and deciding if it has to be larger then put the larger num there.
      
      3,5,2,1,6,4 => at i= 1, i has to be greater than i-1, if not continue, if not swap i& i-1. 
                     at i=2, i has to be smaller than i-1, if not, swap i & i-1. 
                     
                    here, i = 3, [1] has to larger than [2], we can swap it  coz, at [2]th place the num has to be smaller, 
                    now we are putting a num smaller than [2], so it still satisfies the previous condition..
                    
      
     */
    
    public static void wiggleSort1(int[] nums) {
        
        boolean larger = true; // means that nums[i] should be larger than nums[i - 1]
        for (int i = 1; i < nums.length; i++) {
            if (larger) {
                if (nums[i] < nums[i - 1]) swap(nums, i, i - 1);
            } else {
                if (nums[i] > nums[i - 1]) swap(nums, i, i - 1);
            }
            larger = !larger;
        }
        
        Util.printArray(nums);
    }
    
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    public static void main (String[] args)
    {
        wiggleSort1(new int[]{3,5,2,1,6,4});
    }

}
