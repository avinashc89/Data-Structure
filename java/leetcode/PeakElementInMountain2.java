package com.tool.java.leetcode;

public class PeakElementInMountain2
{
    /* find max peak element  in mountain array => find the local maxima => x is local maxima when adjacent is smaller than x
      
            /\
       /\  /  \
      /  \/    \/\
       
      using binary search
    */ 

    // should be solved linearly. 
    
    public static int findPeakElement(int[] nums) {

        int n = nums.length;
        int res[] = new int[1];
        localMinUtil(nums, 0, n - 1, n , res); 
        return res[0];
    }
    static int max = Integer.MIN_VALUE;
    public static void localMinUtil(int[] arr, int low,  
                                   int high, int n, int[] res) 
    { 
        if(high>low) return;  
        int mid = low + (high - low) / 2; 
          
         // Compare middle element with its neighbours 
        if(mid == 0 || arr[mid - 1] < arr[mid] && mid == n - 1 ||  
           arr[mid] > arr[mid + 1]) 
                res[0] = Math.max(res[0], mid); 
      
        else if(mid > 0 && arr[mid - 1] > arr[mid]) 
                localMinUtil(arr, low, mid - 1, n, res); 
          
        // If middle element is not minima and its right 
        // neighbour is smaller than it, then right half 
        // must have a local minima. 
        localMinUtil(arr, mid + 1, high, n, res); 
    } 
    
    
    public static void main (String[] args)
    {
        System.out.println(findPeakElement(new int[]{0,1,0}));
        System.out.println(findPeakElement(new int[]{0,4,5,6,4,3,2,1,0}));
        
        System.out.println(findPeakElement(new int[]{140, 8, 6, 5, 4, 3,34,56,78,123, 130, 20, 19, 18, 13}));
    }

}
