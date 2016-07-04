package com.tool.java.programcreek.array;

import java.util.ArrayList;

public class A_07_InsertInterval {

	
	/*
	   	 S		  E
	   	 
	New  |  curr  |  New
		 |        |
		 |        |	
		 |        |
		New	
		 		 New
		 	New
	  Neeeeeeeeeeeeew	 	
		 
		 */
		 
	  public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInt) {
		  
	        ArrayList<Interval> result = new ArrayList<Interval>();
	 
	        for(Interval curr: intervals){
	            if(curr.end < newInt.start)
	            {
	                result.add(curr);
	            }
	            else if(curr.start > newInt.end)
	            {
	                result.add(newInt);
	                newInt = curr;        
	            }
	            else if(curr.end >= newInt.start || curr.start <= newInt.end)
	            {
	                newInt = new Interval(Math.min(curr.start, newInt.start), Math.max(newInt.end, curr.end));
	            }
	        }
	 
	        result.add(newInt); 
	 
	        return result;
	    }
}


