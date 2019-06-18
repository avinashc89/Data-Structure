package com.tool.java.programcreek.array;

public class A_15_MinimumSizeSubarraySum { 


	//   i		j
	//   |		|
	//	--------------
	
	public int minSubArrayLen(int s, int[] nums) {
		if (s <= 0 || nums == null || nums.length == 0) {
			return 0;
		}

		int j = 0;
		int i = 0;
		int currsum = 0;
		int minLen = Integer.MAX_VALUE;

		while(j<nums.length){
	        if(currsum<s){
	            currsum += nums[j];
	            j++;        
	        }else{
	            minLen = Math.min(minLen, j-i);
//	            if(i==j-1)
//	                return 1;
	            currsum -=nums[i];
	            i++;
	        }
	    }
	 
	    while(currsum>=s){
	        minLen = Math.min(minLen, j-i);
	        currsum -=nums[i];
	        i++;
	    }
		if (minLen == Integer.MAX_VALUE) {
			return 0;
		} else {
			return minLen;
		}
	}
}
