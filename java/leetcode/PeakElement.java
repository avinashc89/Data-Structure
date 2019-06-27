package com.tool.java.leetcode;

public class PeakElement
{
    // find peak element 

    //using binary search
    // 

    public int findPeakElement(int[] nums) {

        if (nums ==null || nums.length ==0) return 0; 
        if (nums.length ==1) {
            return nums[0];
        }

        int left = 0, right = nums.length -1;
        int length = nums.length;
        while (left < right) {
            int mid = left + (right - left) /2;
            
            //if mid is smaller than next number => move right
            if (mid < length &&  nums[mid] < nums[mid +1]) {
                left = mid +1;
            }
            else if (mid >0 &&  nums[mid] < nums[mid -1]){
                right = mid;
            }
            else return mid;
        }
        
        return left;

    }
    
    public static void main (String[] args)
    {
        
    }

}
