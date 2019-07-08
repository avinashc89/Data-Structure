package com.tool.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithMUniqueCharacters
{
    
   // using hashmap to track char & count
    // start, end =0 
    // move end and put it in map
    // if map.size is greater than M, move start and count-- and remove from map if zero
    
    //Solution 1 HashMap<num,count>
    public static int lengthOfLongestSubstringKDistinct1(String s, Integer k) throws Exception
    {
        int max = 0;
        if (s.isEmpty() || k==0)
            return 0;
        Map<Character, Integer>map = new HashMap<>();
        map.put(s.charAt(0),1);
        max=1;
        for (int begin=0, end=0;end<s.length()-1;){
            end++;
            char endC = s.charAt(end);
            if (map.get(endC)==null)map.put(endC, 1);
            else 
                map.put(endC, map.get(endC)+1);
                 while (map.size()>k){
                     char beginC = s.charAt(begin);
                     int amount = map.get(beginC);
                     if (amount>1)map.put(beginC, amount-1);
                     else map.remove(beginC);
                     begin++;
                 
            } 
            max=Math.max(max, end-begin+1);
        }
        return max; 
    }
    
    public static boolean isLessThanM(HashMap<Character,Integer> hash, Integer m)
    {
        int count =0;
        for(char key:hash.keySet())
            if(hash.get(key) > 0) count++;
        
        return (count <= m); 
    }   

    public static void main(String args[]) throws Exception
    {
        System.out.println(lengthOfLongestSubstringKDistinct1("aa",1));
    }
    
    //Solution 2 HashMap<num,index>
    static HashMap<Character,Integer> map = new HashMap<Character,Integer>();  // num,index
    public static int lengthOfLongestSubstringKDistinct(String s, Integer k) 
    {
        if(s == null || s.length()==0 || k==0)
            return 0;
        int start =0, windowSize =1, windowStart = 0;
        int size = s.length();
        
        char ch = s.charAt(0);
        map.put(ch, 0);
        int i;
        for(i=1; i<size;i++)
        {
            ch = s.charAt(i);
            map.put(ch, i);
            
            if(map.size() > k)
            {
                int index = removeFarthestIndex();
                if(i-start > windowSize)
                {
                    windowSize = i-start;
                    windowStart = start;
                }   
                start = index+1;
            }
        }
        
        if(i-start > windowSize)
        {
            windowSize = i-start;
            windowStart = start;
        }   
        
        return windowSize;    
    }

    private static int removeFarthestIndex ()
    {
        int min = Integer.MAX_VALUE;
        Character key = null;
        for(char c : map.keySet())
        {
            if(map.get(c) < min)
            {
                min = map.get(c);
                key = c;
            }
        }
        if(key!=null)
            map.remove(key);
        
        return min;
    }

}
