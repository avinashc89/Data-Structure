package com.tool.java.arrayString.subset_subseq;

public class SplitKSubsetEqualSum
{
    int sum;
    boolean[] used;
    
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        sum = sum / k;
        used = new boolean[nums.length];
        return subsetHelper(nums, 0, 0, k);
    }
    
    public boolean subsetHelper(int[] nums, int cur_sum, int start, int k) {
        if (k == 0) {
            return true;
        }
        if (cur_sum == sum) {
            return subsetHelper(nums, 0, 0, k - 1);
        }
        for (int i = start; i < nums.length; i++)
        {
            if (!used[i] && cur_sum + nums[i] <= sum)
            {
                    used[i] = !used[i]; //use it
                    if (subsetHelper(nums, cur_sum + nums[i], i + 1, k))
                    {
                        return true;
                    }
                    used[i] = !used[i]; // unuse it
            }
        }
        return false;
    }

}
