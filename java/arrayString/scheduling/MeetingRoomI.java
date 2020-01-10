package com.tool.java.arrayString.scheduling;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MeetingRoomI
{
    public static boolean canAttendMeetings(int[][] a)
    {
        if(a==null) return false;
        if(a.length==1) return true;
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int[] interval : a){
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1 );
            map.put(interval[1], map.getOrDefault(interval[1], 0) - 1 );
        }
        int k =0 ;
        
        for(int values : map.values())
        {
            k = k+values;
            if(k>1)
                return false;
        }
        return true;
    }
    
    
    public static boolean canAttendMeetings1(int[][] a)
    {
        if(a==null) return false;
        if(a.length==1) return true;
        
        Interval[] intervals = new Interval[a.length];
        
        for(int i=0 ; i<a.length ; i++)
        {
            intervals[i] = new Interval(a[i][0], a[i][1]);
        }
        
        return caAttendMeeting(intervals);
    }
    
    
   /*
       Mtd 2: Using Treemap orders the map entry with key
       ex: 2,3    1,4     5,8   
       
       up   up  dn  dn  up          dn
       1    2   3   4   5   6   7   8   9   
       
       Add total no of up and dn.
       up and dn should compliment each other when traversing. ie., up = +1, dn = -1.
       if the curr total is more than 1 then he has to attend two meeting simultaneously.
       
    */
//    O(nlogn)
    private static boolean caAttendMeeting (Interval[] intervals)
    {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(Interval interval : intervals){
            map.put(interval.start, map.getOrDefault(interval.start, 0) + 1 );
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1 );
        }
        int k =0 ;
        
        for(int values : map.values())
        {
            k = k+values;
            if(k>1)
                return false;
        }
        return true;
    }
    
//    Mtd 1: Sorting start and end time. 
//    O(nlogn)
    public boolean canAttendMeetings(Interval[] intervals) {
        int len=intervals.length;
        if(len==0){
            return true;
        }
        int[]begin=new int[len];
        int[]stop=new int[len];
        for(int i=0;i<len;i++){
            begin[i]=intervals[i].start;
            stop[i]=intervals[i].end;
        }
        Arrays.sort(begin);
        Arrays.sort(stop);
        for(int i=1;i<len;i++){
            if(begin[i]<stop[i-1]){
                return false;
            }
        }
        return true;
}

    public static void main (String[] args)
    {
        System.out.println(canAttendMeetings(new int[][]{{13,15},{1,13}, {10,11}}));
    }

    
    
}
