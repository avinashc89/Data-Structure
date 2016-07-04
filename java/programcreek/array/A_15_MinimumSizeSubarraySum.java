package com.tool.java.programcreek.array;

public class A_15_MinimumSizeSubarraySum { 


	//   j		i
	//   |		|
	//	--------------
	
	public int minSubArrayLen(int s, int[] a) {
		if (s <= 0 || a == null || a.length == 0) {
			return 0;
		}

		int j = 0;
		int i = 0;
		int sum = 0;
		int minLen = Integer.MAX_VALUE;

		while (i < a.length) {
			// Moves the hi pointer
			while (i < a.length && sum < s) {
				sum += a[i];
				i++;
			}

			// Move the lo pointer
			while (j <= i && sum >= s) {
				minLen = Math.min(minLen, i - j);
				sum -= a[j];
				j++;
			}
		}
		if (minLen == Integer.MAX_VALUE) {
			return 0;
		} else {
			return minLen;
		}
	}
}
