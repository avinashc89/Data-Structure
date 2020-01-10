package com.tool.java.arrayString.scheduling;

import java.util.*;

public class MyCalendar2
{
    //  https://leetcode.com/problems/meeting-rooms-ii/discuss/203658/HashMapTreeMap-resolves-Scheduling-Problem
    // double booking is allowed and triple booking is not allowed
    
    //to store booking
    private TreeMap<Integer, Integer> map = new TreeMap<>();
   
    
    //similar to meeting room1.
    // each time booking is added into map, check for the max no of rooms needed. 
    //if it is more than 2, ie., more than two overlapping meeting, then remove the slot from map and return false
    public boolean book1(int s, int e) 
    {
        map.put(s, map.getOrDefault(s, 0) + 1); 
        map.put(e, map.getOrDefault(e, 0) - 1); 
        
        int currLevel = 0, k = 0;  // k = maxLevelReached
        for (int v : map.values()) { 
            currLevel += v;
            k = Math.max(k,currLevel );
            if (k > 2) { 
                map.put(s, map.get(s) - 1); // remove the booking, since already 2 booking available during given timeslot
                map.put(e, map.get(e) + 1); 
                return false; 
            }
        }
        return true;
    }

    public static void main (String[] args)
    {

        MyCalendar2 c = new MyCalendar2();
        
        System.out.println(c.book1(5, 7));
        System.out.println(c.book1(5, 17));
        System.out.println(c.book1(5, 11));

    }

}
