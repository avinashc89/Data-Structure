package com.tool.java.leetcode;

public class RotatedSortedArray
{
/*
 let lo = 0;
    let hi = nums.length - 1;
    while (lo < hi) {
        let mid = Math.floor((lo + hi) / 2);
        if (nums[mid] > nums[hi]) {
            lo = mid + 1;
        } else {
            hi = mid;
        }
    }
    return nums[lo];
 */
    
    public static int findMin(int[] nums) {
        
        int l =0;
        int r = nums.length-1;
        
        while(l<r)
        {
            int m = (l+r)/2;
            if(nums[m] > nums[r]) //in sorted, m < r, if not, then rotation has gone past mid, so search in right
            {
                //move right
                l = m+1;
            }
            else
            {
                //move left
                r = m;
            }
                
        }
        return nums[l];
        
    }
    
    public static void main (String[] args)
    {
        System.out.println(findMin(new int[]{5,6,7,0,1,2,3,4}));
        System.out.println(findMinWithDuplicates(new int[]{5,5,5,5,5,5,5,5,1,2,3,4,5}));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
    }
    
    public static int findMinWithDuplicates(int[] nums) {
        
        if(nums.length == 0)
            return -1;
        int l = 0, r = nums.length-1;
        
        if(nums[l] < nums[r])//No rotation
            return nums[l];
        
        while(l < r)
        {
            int mid = l + (r - l)/2;
            if(nums[l] <= nums[mid] && nums[mid] > nums[r] )            
                l = mid + 1;
            else if(nums[l] > nums[mid] && nums[mid] <= nums[r])
                r = mid;
            else //5555055 both sides same number
                r--;
        }
        return nums[l];
    }
    
    public static int search(int[] nums, int k) {
     
        if(nums.length == 0)
            return -1;
        int l = 0, r = nums.length-1;
        
        while(l < r)
        {
            int m = l + (r - l)/2;
            
            if(nums[m]>nums[r]){                   // sorted point in right side
                if(nums[l]<=k && k<nums[m]){
                    r=m-1;
                }else{
                    l=m+1;
                }
            }else{                                  //sorted in left point
                if(nums[m]<k && k<=nums[r]){
                    l=m+1;
                }else{
                    r=m-1;
                }
            }   
        }
        
        return nums[l]==k? l : -1;
        
    }

}
