package com.tool.java.leetcode;

public class MaxAvgSubarrayofSizeK
{
    
    //Since k > 0, the maximum sum subarray of size k will also be maximum average subarray of size k. 
     // So, the problem reduces to finding maximum sum subarray of size k in the array.

    
    private static int getMaxAvgSubarrayStartIndex(int input[], int k)
    {
        int n = input.length;
        if (k > n)
            throw new IllegalArgumentException("k should be less than or equal to n");
      
        if(k == n) {
            return 0;   // whole array is the solution
        }
 
        // Sum of first k elements
        int sum = input[0];
        for (int i = 1; i < k; i++)
            sum += input[i];
      
        // Initialized to first k elements sum
        int maxSum = sum;
        int maxSumIndex = 0;
      
        // Sum of remaining sub arrays
        for (int i = k; i < n; i++)
        {
            // Remove first element of the current window and add next element to the window
            sum = sum - input[i-k] + input[i] ;
            if (sum > maxSum)
            {
                maxSum = sum;
                maxSumIndex = i-k;
            }
        }
      
        // Return starting index of max avg sub array
        return maxSumIndex + 1;
    }
}
