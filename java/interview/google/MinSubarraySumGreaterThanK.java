package com.tool.java.interview.google;

public class MinSubarraySumGreaterThanK {

	public static void main(String[] args) throws java.lang.Exception {
		int[] arrA = {1,5,20,70,8,10,88};
		MinSubarraySumGreaterThanK i = new MinSubarraySumGreaterThanK();
		i.minSubArray(arrA, 97);
	}
	
	public void minSubArray(int[] arrA, int x) {
		int start = 0;
		int ansEnd = 0;
		int ansStart = 0;
		int currSum = 0;
		int minLen = arrA.length;
		for (int i = 0; i < arrA.length; i++) {
			currSum = currSum + arrA[i];
			System.out.println(currSum);
			
			while (currSum > x) {
				if (i - start < minLen) {
					minLen = (i - start);
					ansEnd = i;
					ansStart = start;
				}
				currSum = currSum - arrA[start];
				start++;
			}
		}
		
		System.out.println("Minimum length of subarray to get " + x + " is : "
				+ minLen);
		
		System.out.print("SubArray is:");
		for (int i = ansStart; i <= ansEnd; i++) {
			System.out.print("   " + arrA[i]);
		}
	}

	
}
