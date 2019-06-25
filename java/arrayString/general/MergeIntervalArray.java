package com.tool.java.arrayString.general;

import java.util.*;

public class MergeIntervalArray
{
   //[starttime, endtime] => merge if overlaps
    public int[][] merge(int[][] intervals) 
    {
        List<int[]> res=new ArrayList<int[]>();
        
        if(intervals==null||intervals.length==0){
            return res.toArray(new int[res.size()][]);
        }
        
        //first sort using the start time.
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        
        
        //0th data
        int[] cur=intervals[0];
        
        // for every next time if, next's start time is less than curr's end => overlapping occurs. 
        
        for(int[] next:intervals)
        {
            if(next[0]<=cur[1])
            {
                if(next[1]>cur[1])   // if next end time is greater, then curr end time = next's end time. else curr end time is greated, leave it as such
                    cur[1]=next[1];
            }
            else            // if overlap doesnt occur
            {
                res.add(cur);
                cur=next;
            }
        }
        
        res.add(cur);
        
        return res.toArray(new int[res.size()][]);
    }
    
    
}
