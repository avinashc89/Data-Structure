package com.tool.java.leetcode;

public class ExpressiveWords
{
    
    /*
     S = "heeellooo"
    words = ["hello", "hi", "helo"]
    Output: 1 
     
     */

    public static int expressiveWords(String S, String[] words) {
        int res = 0;
        for(String word : words)
        {
            if(canExpand(S, word))
            {
                res++;
            }
        }
        return res;
    }
    
    public static boolean canExpand(String S , String W)
    {
        int i = 0, j = 0;
        while (i< S.length() && j<W.length())
        {
            char Si = S.charAt(i);
            char Wj = W.charAt(j);
            
            if(Si!=Wj) return false;
            
            int groupLenSi = getGroupLen(S, i, Si);
            int groupLenWj = getGroupLen(W, j, Wj); 
            
            if(groupLenWj > groupLenSi) return false;  // the grouplen of word should be lesser than S
            
            if(groupLenSi < 3 && groupLenWj!=groupLenSi) return false; // if grouplen of S is lesser than 3, then the char count in both should be same
            
            i = i+groupLenSi;
            j = j+groupLenWj;
        }
        
        if(i< S.length() || j<W.length())
            return false;
        
        return true;
    }

    private static int getGroupLen (String S, int idx, char c)
    {
        int count = 0;
        int curr = idx;
        while (curr < S.length() && S.charAt(curr) == c)
        {
            count++;
            curr++;
        }
        return count;
    }
    
    public static void main (String[] args)
    {
        System.out.println(expressiveWords("heeellooom", new String[]{"hello", "hi", "hellooo"}));
        System.out.println(expressiveWords("abcd", new String[]{"abc"}));
    }
    
    
}
