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
        return minMeetingRooms1(interval);
    }
    
    //using https://leetcode.com/problems/meeting-rooms-ii/discuss/203658/HashMapTreeMap-resolves-Scheduling-Problem
    
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
    // compare the ongoing meeting and the upcoming meeting.
    //if next meeting starts after ongoing meeting, merge the meeting time. [ongoing start, next end] push to queue again.
    public static int minMeetingRooms(Interval[] intervals) {
        
        Arrays.sort(intervals, (a,b)->a.start-b.start);
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b)->a.end-b.end);
        minHeap.add(intervals[0]);
        
        for(int i=1 ; i< intervals.length ; i++)
        {
            Interval curr = intervals[i];
            Interval min = minHeap.remove();
            if(curr.start >= min.end)
            {
                min.end = curr.end;
            }
            else
            {
                minHeap.add(curr);
            }
            minHeap.add(min);
        }
        System.out.println(minHeap.size());
        return minHeap.size();        
    }
    
    public static void main (String[] args)
    {
        System.out.println(minMeetingRooms(new int[][]{{13,15},{1,13}}));
    }

}

class Interval 
{
    int start;
    int end;
    Interval() {start =0 ; end =0;}
    Interval(int s,int e){start = s; end = e;}
}
