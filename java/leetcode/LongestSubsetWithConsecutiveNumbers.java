package com.tool.java.leetcode;

import java.util.HashSet;

public class LongestSubsetWithConsecutiveNumbers
{
    //Longest Consecutive Sequence
    //put in hashset -> start from 0 -> and check if a[0]-1 in hashset. 
    //if no, then thats the start of set and while loop to find next in hashset
    
    static int findLongestConseqSubseq(int arr[],int n) 
    { 
        HashSet<Integer> S = new HashSet<Integer>(); 
        int ans = 0; 
  
        // Hash all the array elements 
        for (int i=0; i<n; ++i) 
            S.add(arr[i]); 
  
        for (int i=0; i<n; ++i) 
        { 
            // if num-1 is in hash then no need to proceed since it will be part of previous num set. 
            if (!S.contains(arr[i]-1)) 
            { 
                int j = arr[i]; 
                while (S.contains(j)) 
                    j++; 
                
                int totNum = j-arr[i];
                if (ans < totNum) 
                    ans = j-arr[i]; 
            } 
        } 
        return ans; 
    } 
  
    public static void main(String args[]) 
    { 
        int arr[] =  {1, 9, 3, 10, 4, 20, 2}; //4 => 1,2,3,4
        int n = arr.length; 
        System.out.println("Length of the Longest consecutive subsequence is " + 
                           findLongestConseqSubseq(arr,n)); 
    }

}
