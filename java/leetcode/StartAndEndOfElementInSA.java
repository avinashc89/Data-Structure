package com.tool.java.leetcode;

import java.util.Arrays;

public class StartAndEndOfElementInSA
{

    public int[] searchRange(int[] nums, int target) {


        int first = first(nums, target);
        int last = last(nums, target);

        return new int[] {first, last};
    }

    private int last(int[] nums, int target) {
        int low = 0, high = nums.length-1; 
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] > target) {
                high = mid -1;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }

    private int first(int[] nums, int target) {
        int low = 0, high = nums.length-1; 
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > target) {
                high = mid -1;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
    
    
    
    
    public int[] searchRange1(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums == null || nums.length == 0){
            return res;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start <= end)
        {
            int mid = (end + start) / 2;
            if(nums[mid] == target)
            {
                if(nums[start] < target) 
                    start++;
                if(nums[end] > target) 
                    end--;
                if(nums[start] == target && nums[end] == target){
                    res[0] = start;
                    res[1] = end;
                    return res;
                }
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
        }
        return res;
    }
}
