package com.tool.java.arrayString;

import java.util.Arrays;
import java.util.PriorityQueue;

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
        minMeetingRooms(new int[][]{{13,15},{1,13}});
    }

}

class Interval 
{
    int start;
    int end;
    Interval() {start =0 ; end =0;}
    Interval(int s,int e){start = s; end = e;}
}
