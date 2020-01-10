package com.tool.java.arrayString.scheduling;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MeetingRoomII
{
    
    public static int minMeetingRooms(int[][] intervals) {
        if(intervals ==null || intervals.length == 0)
            return 0;
        
        Interval[] interval = new Interval[intervals.length];
 
        for( int i =0 ;i<interval.length; i++)
        {
            interval[i] = new Interval(intervals[i][0], intervals[i][1]);
        }
        return minMeetingRooms(interval);
    }
    
    /*
    Mtd 2: Using Treemap orders the map entry with key
    using https://leetcode.com/problems/meeting-rooms-ii/discuss/203658/HashMapTreeMap-resolves-Scheduling-Problem
    
    ex: 2,3    1,4     5,8   
    
    up   up  dn  dn  up          dn
    1    2   3   4   5   6   7   8   9   
    
    Add total no of up and dn.
    up and dn will compliment each other when traversing. ie., up = +1, dn = -1. 
    if the curr total is more than 1 then he has to attend two meeting simultaneously. => meeting room needed = 2
    max total => no of meeting rooms needed.
 */
    public static int minMeetingRooms1(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        
        for (Interval itl : intervals) {
            map.put(itl.start, map.getOrDefault(itl.start, 0) + 1);
            map.put(itl.end, map.getOrDefault(itl.end, 0) - 1);
        }
        int room = 0, k = 0; 
        for (int v : map.values()) {
            room += v;
            k = Math.max(k, room); 
        }
        return k; 
    }
    
    //sort using the start time.
    // use priorityqueue to have the meeting that ends first at the top (heap) (ongoing meeting)
    // compare the ongoing meeting(min) and the upcoming meeting(curr).
    //if next meeting starts after ongoing meeting, merge the meeting time. [ongoing start, next end] push to queue again.
    public static int minMeetingRooms(Interval[] intervals) {
        
        Arrays.sort(intervals, (a,b)->a.start-b.start);
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b)->a.end-b.end); //heap using end time. min end time is at top of queue
        minHeap.add(intervals[0]);
        
        for(int i=1 ; i< intervals.length ; i++)
        {
            Interval upcoming = intervals[i];
            Interval ongoing = minHeap.remove();
            if(upcoming.start >= ongoing.end)
            {
                ongoing.end = upcoming.end;             
            }
            else
            {
                minHeap.add(upcoming);
            }
            minHeap.add(ongoing);
        }
        System.out.println(minHeap.size());
        return minHeap.size();        
    }
    
    public static void main (String[] args)
    {
        System.out.println(minMeetingRooms(new int[][]{{13,15},{1,13},{3,5},{7,12},{5,8}}));
    }

}

class Interval 
{
    int start;
    int end;
    Interval() {start =0 ; end =0;}
    Interval(int s,int e){start = s; end = e;}
}
