package com.tool.java.DP;

import java.util.Arrays;

public class TotalPalindromeInString {



	public static void main(String[] args) {
		System.out.println(new TotalPalindromeInString().longestPalindrome("hellolle"));
	}

	// Transform S into T.
	// For example, S = "abba", T = "^#a#b#b#a#$".
	// ^ and $ signs are sentinels appended to each end to avoid bounds checking
	String preProcess(String s) {
		int n = s.length();
		if (n == 0) return "^$";

		String ret = "^";
		for (int i = 0; i < n; i++)
			ret += "#" + s.charAt(i);

		ret += "#$";
		return ret; //^#A#B#A#B#A#B#A#$
	}

	int longestPalindrome(String s) {
		char T[] = preProcess(s).toCharArray();
		int n = T.length;
		int palinLen[] = new int[n];
		int center = 0, right = 0;
		for (int i = 1; i < n-1; i++) {
			int mirror = 2*center-i; // equals to i' = center - (i-center)

			if(i<right) 
				palinLen[i]= Math.min(right-i, palinLen[mirror]);

			// AttempalinLent to expalinLenand palinLenalindrome centered at i
			while (T[i + 1 + palinLen[i]] == T[i - 1 - palinLen[i]])
				palinLen[i]++; 

			
			// If palinLenalindrome centered at i expalinLenand palinLenast right,
			// adjust center and right based on expalinLenanded palinLenalindrome.
			if (i + palinLen[i] > right) {
				center = i;
				right = i + palinLen[i];
			}
		}

		// Find the maximum element in palinLen.
	
	
		System.out.println(Arrays.toString(palinLen));

		int count =0;
		for(int i=0 ; i< palinLen.length ; i++)
		{
			System.out.println(palinLen[i]);
			int temp = palinLen[i];
			while(temp>0)
			{
				temp = temp-2;
				count++;
			}
			
		}
		System.out.println("*****"+count);
		return count;
	}

}
