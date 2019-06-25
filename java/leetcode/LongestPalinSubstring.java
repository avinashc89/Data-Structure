package com.tool.java.leetcode;

import java.util.Arrays;

public class LongestPalinSubstring {



	public static void main(String[] args) {
		System.out.println(new LongestPalinSubstring().longestPalindrome("abbcbcbsaa"));
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
		System.out.println(ret);
		return ret; //^#A#B#A#B#A#B#A#$
	}

	String longestPalindrome(String s) {
		char T[] = preProcess(s).toCharArray();
		int n = T.length;
		int P[] = new int[n];
		int C = 0, R = 0;
		for (int i = 1; i < n-1; i++) {
			int mirror = 2*C-i; // equals to i' = C - (i-C)

			if(i<R) 
				P[i]= Math.min(R-i, P[mirror]);

			// Attempt to expand palindrome centered at i
			while (T[i + 1 + P[i]] == T[i - 1 - P[i]])
				P[i]++; 

			// If palindrome centered at i expand past R,
			// adjust center and R based on expanded palindrome.
			if (i + P[i] > R) {
				C = i;
				R = i + P[i];
			}
		}

		// Find the maximum element in P.
		int maxLen = 0;
		int center  = 0;
		for (int i = 1; i < n-1; i++) {

			System.out.println(i+"~~~"+P[i]);
			if (P[i] > maxLen) {
				maxLen = P[i];
				center  = i;
			}
		}

		System.out.println(maxLen);

		return (s.substring((center - 1 - maxLen) / 2, (center - 1 + maxLen) / 2));
	}

}
