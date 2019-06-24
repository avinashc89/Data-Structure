package com.tool.java.arrayString.subset_subseq;

import java.util.ArrayList;

public class AllSubsetOfSumK
{
    static boolean[][] T;

    public static void subsetSumExist(int a[], int k ) {

         T  = new boolean[a.length + 1][k + 1];

        for (int i = 0; i <= a.length; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (j - a[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - a[i - 1]];
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }
        
        System.out.println(T[a.length][k]);
        
        ArrayList<Integer> p = new ArrayList<>(); 
        printSubsetsRec(a, a.length-1, k, p); 

    }


    static void printSubsetsRec(int arr[], int i, int sum,  
                                ArrayList<Integer> p) 
    { 
        
     // If sum becomes 0 
        if (i == 0 && sum == 0) 
        { 
            System.out.println(p);  
            p.clear(); 
            return; 
        }
        
     // reached top row (i=0) and sum !=0 and if that cell is T, then YES
        if (i == 0 && sum != 0 && T[0][sum])  
        { 
            p.add(arr[i]); 
            System.out.println(p); 
            p.clear(); 
            return; 
        } 

       // If given sum can be achieved after considering 
        // current element. 
        if (sum >= arr[i] && T[i-1][sum-arr[i]]) 
        { 
            p.add(arr[i]); 
            printSubsetsRec(arr, i-1, sum-arr[i], p); 
        } 

        // If given sum can be achieved after ignoring 
        // current element. 
        if (T[i-1][sum]) 
        { 
            // Create a new vector to store path 
            ArrayList<Integer> b = new ArrayList<>(); 
            b.addAll(p); 
            printSubsetsRec(arr, i-1, sum, b); 
        } 

        
    } 

    public static void main (String[] args)
    {
        int[] input = {2,3,7,8,10};
        int k = 11;
        subsetSumExist(input, k);

    }



}
