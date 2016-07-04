package com.tool.java.interview.shutterfly;

public class ShutterflyLonelyInteger {

	public static void main(String[] args) {

		System.out.println(maxDifference(new int[]{2,3,10,2,4,8,1}));
	}

	static int maxDifference(int[] arr)
	{
		if(arr==null||arr.length<=1)
	        return 0;
		
		int diff = arr[1]-arr[0];
		int curr_sum = diff;
		int max_sum = curr_sum;

		for(int i=1; i<arr.length-1; i++)
		{
			// Calculate current diff
			diff = arr[i+1]-arr[i];

			// Calculate current sum
			if (curr_sum > 0)
				curr_sum += diff;
			else
				curr_sum = diff;

			// Update max sum, if needed
			if (curr_sum > max_sum)
				max_sum = curr_sum;
		}

		return max_sum;
	}

	private static boolean checkInput(int[] a) {
		for(int i :a)
		{
			if(-100000 > i || i>100000){
				return false;
			}
		}
		return false;
	}

}
