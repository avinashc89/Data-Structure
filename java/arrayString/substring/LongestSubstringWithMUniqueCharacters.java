package com.tool.java.arrayString.substring;

import java.util.HashMap;

public class LongestSubstringWithMUniqueCharacters
{
    
   // using hashmap to track char & count
    // start, end =0 
    // move end and put it in map
    // if map.size is greater than M, move start and count-- and remove from map if zero
    
    
    public static String solution(String s, Integer m) throws Exception
    {
        int start =0, end=0, windowSize =1, windowStart = 0;
        int size = s.length();
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        int ch = (int)s.charAt(0);
        hash.put(ch, 1);

        for(int i=1; i<size;i++)
        {
            ch = (int)s.charAt(i);
            if(!hash.containsKey(ch))
            {
                hash.put(ch, 1);
            }
            else
            {
                int temp =  hash.get(ch);
                hash.put(ch,++temp);
            }
            end++;
            //move start forward if number of unique characters is greater than m
            while(!isLessThanM(hash,m))
            {
                int temp =  hash.get((int)s.charAt(start));
                hash.put((int)s.charAt(start),--temp);
                start++;
            }
            if(end-start+1 >windowSize)
            {
                windowSize = end-start + 1;
                windowStart = start;
            }   
        }
        return s.substring(windowStart, windowStart+windowSize);    
    }
    
    public static boolean isLessThanM(HashMap<Integer,Integer> hash, Integer m)
    {
        int count =0;
        for(Integer key:hash.keySet())
            if(hash.get(key) > 0) count++;
        
        return (count <= m); 
    }   

    public static void main(String args[]) throws Exception
    {
        System.out.println(solution("karap",2));
    }

}
