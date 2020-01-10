package com.tool.java.arrayString.scheduling;

import java.util.ArrayList;
import java.util.List;
import com.tool.java.Util;

public class InsertIntervalArray // Hard
{
    // inserting new interval. 
    
     
    //linear approach
    public static int[][] insert(int[][] intervals, int[] newInterval) 
    {
        if (intervals == null || intervals.length ==0) 
            return new int[][]{newInterval};
        
        Interval[] intervalArray = new Interval[intervals.length];
        for (int i =0 ; i< intervals.length ; i++)
        {
            intervalArray[i] = new Interval(intervals[i][0], intervals[i][1]);
        }
        
        ArrayList<Interval> left = new ArrayList<Interval>();
        ArrayList<Interval> right = new ArrayList<Interval>();
        
        Interval mergeInterval = new Interval(newInterval[0], newInterval[1]);
        
        for (int i =0 ; i< intervalArray.length ; i++)
        {
            if (intervalArray[i].end < newInterval[0])
                left.add(intervalArray[i]);
            else if(intervalArray[i].start > newInterval[1] )
                right.add(intervalArray[i]);
            else
            {
                mergeInterval.start = Math.min(mergeInterval.start, intervalArray[i].start);
                mergeInterval.end = Math.max(mergeInterval.end, intervalArray[i].end);
            }
        }
        
        left.add(mergeInterval);
        left.addAll(right);
        
        int[][] result = new int[left.size()][];
        
        for(int i =0 ; i < left.size(); i++)
        {
            result[i][0] = left.get(i).start;
            result[i][1] = left.get(i).end;
        }
        
        return result;
    }
    
    //Method 2: Binary search - if intervals are already sorted using start time
    /*
      
      find the place where newInterval[0] can be inserted using binary search. = startInterval
      find the place where newInterval[1] can be inserted using binary search. = endInterval
      
      startIntervalIndex = Math.min(newInterval.start, intervals.get(iStart).start)
      endIntervalIndex = Math.max(newInterval.end, intervals.get(iEnd).end));
      
      merge[startInterval,endInterval]
      
      i=0
      while i is less than startInterval => add to arraylist.
      
      add merge to arraylist
      
      i=endIntervalIndex
      while i is less than end of length => add to arraylist.
      
      return result;
      
      
        }   
      
     */
    
    private int findStartPos(List<Interval> intervals, int value) {
        int l = 0, r = intervals.size() - 1;
        while (l <= r) {
            int m = (l + r) /2;
            if (intervals.get(m).start == value) return m;   // return the index of that interval
            else if (intervals.get(m).start < value) l = m + 1;  
            else r = m ;
        }
        return l;  // return the right interval -> l has crossed r ---- r l----
    }
    
    private int findEndPos(List<Interval> intervals, int value) {
        int l = 0, r = intervals.size() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (intervals.get(m).end == value) return m;
            else if (intervals.get(m).end < value) l = m + 1;
            else r = m ;
        }
        return l;
    }
    
    public static void main (String[] args)
    {
        Util.printMatrix(insert(new int[][]{{1,3},{5,7},{2,4},{9,12}}, new int[]{6,10}));
    }

}
