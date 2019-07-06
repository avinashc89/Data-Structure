package com.tool.java.leetcode;

public class GooglePalindromeSplit
{
    public static boolean is_pal(String s1, String s2){  //O(2n)
        
        // s1 => a1+b1
        // s2 => a2+b2
        
        boolean a_switch = false; 
        boolean a_split = true; 
        boolean b_switch = false;
        boolean b_split = true;
        char a[] = s1.toCharArray();
        char b[] = s2.toCharArray();
        
        int i = 0;
        int ii = s1.length() - 1;
        
        int j = 0;
        int jj = s2.length() - 1;

      //a1+b2
       while (a_split && i < jj)
       {
           
           if(a_switch)
           {
               if(b[i] != b[jj])
                   a_split = false;
           }
           if(a[i] != b[jj])
           {
               a_switch = true;
               if(b[i] != b[jj])
                   a_split = false;
           }
           if(i >= ii)
           {
               a_switch = true;
           }
           i++;
           jj--;
          
       }
       
       if(a_split)
           return a_split;
       
     //a2+b1
       while(b_split && j < ii) 
       {
           
           if(b_switch)
           {
               if(b[j] != a[ii])
                   b_split = false;
           }
           if(b[j] != a[ii])
           {
               b_switch = true;
               if(a[j] != a[ii])
                   b_split = false;
           }
           if(j >= ii)
           {
               b_switch = true;
           }
           j++;
           jj--;
       }
       
       return b_split;
        
    }
    
    
    public static boolean canPalinFormed(String a , String b)
    {
        return is_pal(a,b) || is_pal(b,a);
    }
    
    public static void main (String[] args)
    {
        System.out.println(canPalinFormed("abcddcb", "mxyyyba"));
        System.out.println(canPalinFormed("apcbbbb", "xbcbcba"));
    }
}
