package com.tool.java.leetcode;

public class KMPPrefixTable
{

    public boolean repeatedSubstringPattern(String s) {
        int prefixTable[] = new int[s.length()];
        int i = 0;
        int j = 1;
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                prefixTable[j++] = ++i;
            } else if (i > 0) {
                i = prefixTable[i - 1];
            } else if (i == 0) {
                j++;
            } else
                i = 0;
        }
        int x = s.length() - prefixTable[s.length() - 1];
        
        return prefixTable[s.length() - 1] > 0 && s.length() % (x) ==0;
    }
    
    
    public static void main (String[] args)
    {
        KMPPrefixTable k = new KMPPrefixTable();
       System.out.println( k.repeatedSubstringPattern("asdfasdfasdf"));
    }
}
