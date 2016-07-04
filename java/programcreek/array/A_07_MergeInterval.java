package com.tool.java.programcreek.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class A_07_MergeInterval {

	public static void main(String[] args) {
		
	}
	
	public List<Interval> merge(List<Interval> intervals) {
	    List<Interval> result = new ArrayList<Interval>();
	 
	    if(intervals==null||intervals.size()==0)
	        return result;
	 
//	    sort the interval
	    Collections.sort(intervals, new Comparator<Interval>(){
	        public int compare(Interval i1, Interval i2){
	            if(i1.start!=i2.start)
	                return i1.start-i2.start;
	            else
	                return i1.end-i2.end;
	        }
	    });
	 
	    Interval pre = intervals.get(0);
	    for(Interval curr : intervals){
	        
	        if(curr.start > pre.end)	// compare curr's start and previous's end
	        {
	            result.add(pre);
	            pre = curr;
	        }
	        else
	        {
	            Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
	            pre = merged;
	        }
	    }
	    result.add(pre);
	 
	    return result;
	}
}

class Interval
{
	int start;
	int end;
	public Interval(int start,int end) {
		this.start = start;
		this.end = end;
		// TODO Auto-generated constructor stub
	}
}