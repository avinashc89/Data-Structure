package com.tool.java.matrix_Graph;


public class PalindromeMinCut
{
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
    
    public static void main (String[] args)
    {
        System.out.println(minCut("banana"));
    }

}
