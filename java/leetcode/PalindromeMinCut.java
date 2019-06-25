package com.tool.java.leetcode;

import com.tool.java.Util;

public class PalindromeMinCut {


	public static void main(String[] args) {

		System.out.println(minPalPartion("abcbm"));

	}

	static int minPalPartion(String str)
	{
		// Get the length of the string
		int n = str.length();

		/* Create two arrays to build the solution in bottom up manner
	       C[i][j] = Minimum number of cuts needed for palindrome partitioning
	                 of substring str[i..j]
	      */
		int C[][] = new int[n][n];

		int i, j, k, L; // different looping variables

		// Every substring of length 1 is a palindrome
		for (i=0; i<n; i++)
		{
			C[i][i] = 0;
		}

		/* L is substring length. Build the solution in bottom up manner by
	       considering all substrings of length starting from 2 to n.
	       The loop structure is same as Matrx Chain Multiplication problem (
	       See http://www.geeksforgeeks.org/archives/15553 )*/
		for (L=2; L<=n; L++)
		{
			// For substring of length L, set different possible starting indexes  for ababc(total length 5)& L=2, i can go from 0 to 3;  L=3, i can go from 0 to 2 => till n-L => i<=n-L
			for (i=0; i<=n-L; i++)
			{
				j = i+L-1; // Set ending index

				// If L is 2, then we just need to compare two characters. Else
				// need to check two corner characters and value of P[i+1][j-1]
				if (L == 2)
					C[i][j] = str.charAt(i) == str.charAt(j) ? 0 :1;
				else
				{
					if(  (str.charAt(i) == str.charAt(j) && C[i+1][j-1]==0))
						C[i][j] = 0; 

					else
					{
						// Make a cut at every possible localtion starting from i to j,
						// and get the minimum cost cut.

						C[i][j] = Integer.MAX_VALUE;
						for (k=i; k<=j-1; k++)
							C[i][j] = Math.min (C[i][j], C[i][k] + C[k+1][j] + 1);
					}
				}
			}
		}

		// Return the min cut value for complete string. i.e., str[0..n-1]
		return C[0][n-1];
	}
	
	
	
	
	// method 2:
	
	public static int minCut(String str){
        if (str.length() == 0) {
            return 0;
        }

        int[] cut = new int[str.length()];
        boolean isPal[][] = new boolean[str.length()][str.length()];
        for (int i = 1; i < str.length(); i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == str.charAt(j) && (i <= j + 1 || isPal[i - 1][j + 1])) {
                    isPal[i][j] = true;
                    min = Math.min(min, j == 0 ? 0 : 1 + cut[j - 1]);
                }
                System.out.println(i+"--"+j);
                Util.printMatrix(isPal);
            }
            cut[i] = min;
        }
        return cut[str.length() - 1];
    }

}
