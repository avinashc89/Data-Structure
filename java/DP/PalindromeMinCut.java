package com.tool.java.DP;

import com.tool.java.Util;

public class PalindromeMinCut {


	public static void main(String[] args) {

		System.out.println(minCut("abcbm"));

	}

	static int minPalPartion(String str)
	{
		// Get the length of the string
		int n = str.length();

		int C[][] = new int[n][n];

		int i, j, k, L; // different looping variables

		for (i=0; i<n; i++)
		{
			C[i][i] = 0;
		}

		for (L=2; L<=n; L++)
		{
			for (i=0; i<=n-L; i++)
			{
				j = i+L-1; // Set ending index

				if (L == 2)
					C[i][j] = str.charAt(i) == str.charAt(j) ? 0 :1;
				else
				{
					if(  (str.charAt(i) == str.charAt(j) && C[i+1][j-1]==0))
						C[i][j] = 0; 

					else
					{
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
