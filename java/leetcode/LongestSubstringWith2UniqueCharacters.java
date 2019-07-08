package com.tool.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWith2UniqueCharacters
{
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        
        int start=0, end=0;
        Map<Character, Integer> t = new HashMap<Character, Integer>();
        
        int max = 0;
        char[] c = s.toCharArray();
        while(end < c.length)
        {
            t.put(c[end], t.getOrDefault(c[end],0)+1);  
            end++;       
            
            while(t.size() == 3) {
                t.put(c[start], t.get(c[start])-1);
                t.remove(c[start],0);
                start++;
            }
            
            // Every window will have atmost 2 distinct chars
            max = Math.max(max,end - start);
        }   
        return max;
    }
   

    public static void main(String args[]) throws Exception
    {
        System.out.println(lengthOfLongestSubstringTwoDistinct("aba"));
    }
    
   

}
