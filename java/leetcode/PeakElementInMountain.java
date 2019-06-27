package com.tool.java.leetcode;

public class PeakElementInMountain
{
    // find peak element in mountain array => ascending and then descending 

    //using binary search
    // 

    public static int findPeakElement(int[] nums) {

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
    
    //if its two peak mountain array descending ascending descending => compare result with left most value.
    
    public static void main (String[] args)
    {
        System.out.println(findPeakElement(new int[]{0,1,0}));
        System.out.println(findPeakElement(new int[]{0,4,5,6,4,3,2,1,0}));
        
        System.out.println(findPeakElement(new int[]{140, 8, 6, 5, 4, 3,34, 56, 78, 123, 130, 20, 19, 18, 13}));
    }

}
