package com.tool.java.leetcode;

public class AnagramSubstring
{
    /*
     Input:  txt[] = "BACDGABCDA"  pat[] = "ABCD"
     Output:   Found at Index 0
               Found at Index 5
               Found at Index 6
     */
    //1) The first count array store frequencies of characters in pattern.
   // 2) The second count array stores frequencies of characters in current window of text.
    
    static final int MAX = 256; 
    
  
    static boolean compare(char arr1[], char arr2[]) 
    { 
        for (int i = 0; i < MAX; i++) 
            if (arr1[i] != arr2[i]) 
                return false; 
        return true; 
    } 
  
  
    static void search(String pat, String txt) 
    { 
        int M = pat.length(); 
        int N = txt.length(); 
  
        char[] countP = new char[MAX]; 
        char[] countTW = new char[MAX]; 
        
        //first put the freq for first pattern length
        for (int i = 0; i < M; i++) 
        { 
            (countP[pat.charAt(i)])++; 
            (countTW[txt.charAt(i)])++; 
        } 
  
        // Traverse through remaining characters 
        // of pattern 
        for (int i = M; i < N; i++) 
        { 
            if (compare(countP, countTW)) 
                System.out.println("Found at Index " + 
                                          (i - M)); 
            countTW[txt.charAt(i)]++;                 //increase the count of ith char and decrease the count of i-mth char
            countTW[txt.charAt(i-M)]--; 
        } 
        
        //last step compare
        if (compare(countP, countTW)) 
            System.out.println("Found at Index " +  
                                       (N - M)); 
    } 
  
    public static void main(String args[]) 
    { 
        String txt = "BACDGABCDA"; 
        String pat = "ABCD"; 
        search(pat, txt); 
    } 

}
