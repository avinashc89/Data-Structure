package com.tool.java.leetcode;

import java.util.*;

public class MyCalendar3
{
    //  https://leetcode.com/problems/meeting-rooms-ii/discuss/203658/HashMapTreeMap-resolves-Scheduling-Problem
   
    public MyCalendar3() {
    }

    private TreeMap<Integer, Integer> map = new TreeMap<>();
   
    public int book1(int s, int e) {
       

        map.put(s, map.getOrDefault(s, 0) + 1); 
        map.put(e, map.getOrDefault(e, 0) - 1); 
        
        int currLevel = 0, k = 0;  // k = maxLevelReached
        for (int v : map.values()) { 
            currLevel += v;
            k = Math.max(k,currLevel );
            
        }
        return k;
        
    }

    public static void main (String[] args)
    {

        MyCalendar3 c = new MyCalendar3();
        
        System.out.println(c.book1(5, 7));
        System.out.println(c.book1(5, 17));
        System.out.println(c.book1(5, 11));
        System.out.println(c.book1(15, 21));

    }

}
