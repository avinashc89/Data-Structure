package com.tool.java.arrayString.subset_subseq;

public class SplitArrayLargestSum //Hard o(nlogn) using binary search
{
    
    /*
     Given an array which consists of non-negative integers and an integer m, 
     you can split the array into m non-empty continuous subarrays. 
     Write an algorithm to minimize the largest sum among these m subarrays. 
     
     for the given example {7,2,5,10,8} => 
     the maxSum of any chunk can be between 10(when chunk size is 1, split =5) to 32(when chunk size is 5, split =1)
     so x => 10->32
     lets say x = 22
     split the array, such that each continuous chuck has max sum 22. check how many splits. 
         if split is less than 'm', then we have put more elements into a chunks,=> can take away few num in chunk, so check for 21.
         if split is more than 'm', then we have put less elements into a chunk,=> can merge few nums in chunks, so check for 23 
     this can be done in binary search
         10->32 => check for 21 
             if no of split is more than m, (then each chunk can have extra element, so extra sum )=> then check between 22 -> 32
             else -> 10 -> 21
     */
    public static int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int lo = max;
        int hi = sum;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int numOfSubarrays = split(nums, mid);
            if (numOfSubarrays > m) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int split(int[] nums, int validMaxSum) {
        int sum = 0;
        int count = 1;
        for (int num : nums) {
            if (sum + num > validMaxSum) {
                sum = num;
                count++;
            } else {
                sum += num;
            }
        }

        return count;
    }
    
    public static void main (String[] args)
    {
        int[] nums =  {7,2,5,10,8};
        int   m = 1;
         
         System.out.println(splitArray(nums,m));
    }

}
