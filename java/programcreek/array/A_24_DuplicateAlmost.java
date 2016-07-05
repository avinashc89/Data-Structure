package com.tool.java.programcreek.array;

import java.util.SortedSet;
import java.util.TreeSet;

public class A_24_DuplicateAlmost {

	
//	Given an array of integers, find out whether there are two distinct indices i and j in the array 
//	such that the difference between nums[i] and nums[j] is at most t 
//	and the difference between i and j is at most k.
	
	
	public static void main(String[] args) {
		System.out.println(containsNearbyAlmostDuplicate(new int[]{1,75,83,123,419,454,117,44,78},5,6));
	}
	
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	    if(nums==null||nums.length<2||k<0||t<0)
	        return false;
	 
	    TreeSet<Long> set = new TreeSet<Long>(); // initially empty set , acts like windows
	    for(int i=0; i<nums.length; i++){
	    	System.out.println("set = "+set);
	        long curr = (long) nums[i];
	 
	        long l = (long) curr-t;
	        long r = (long) curr+t+1; //right boundary is exclusive, so +1
	        System.out.println(l+"*****"+curr+"*****"+(r-1)+"");
	        SortedSet<Long> sub = set.subSet(l, r);					//will return all the numbers bet l&r (till r-1)
	        if(sub.size()>0)
	            return true;
	 
	        set.add(curr);   //add number to set
	 
	        if(i>=k){
	            set.remove((long)nums[i-k]); 		//if set size exceed more than k, then remove first inserted element 
	        }
	    }
	 
	    return false;
	}
}

/*
 * 
set = []
-5*****1*****7
[]
set = [1]
69*****75*****81
[]
set = [1, 75]
77*****83*****89
[]
set = [1, 75, 83]
111*****117*****123
[]
set = [1, 75, 83, 117]
413*****419*****425
[]
set = [1, 75, 83, 117, 419]
448*****454*****460
[]
set = [75, 83, 117, 419, 454]
117*****123*****129
[117]
true
 */
