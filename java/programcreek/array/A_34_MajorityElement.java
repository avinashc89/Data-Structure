package com.tool.java.programcreek.array;

import java.util.ArrayList;
import java.util.List;

//Given an array of size n, find the majority element. The majority element is the element that appears more than n/2  times. 

public class A_34_MajorityElement {
	
	public static void main(String[] args) {
		System.out.println(majorityElement(new int[]{2,4,5,6,2,3,4,4,2,2,3,4,2,3,1,2,1,3,2}));
	}
	
	public static int majorityElement(int[] nums) {
	    int result = 0, count = 0;
	 
	    for(int i = 0; i<nums.length; i++ ) {
	        if(count == 0){
	            result = nums[ i ];						//whenever count becomes zero. start a new majority element
	            count = 1;	
	        }else if(result == nums[i]){				// if curr elem is curr majority elem, then increase the count
	           count++;
	        }else{
	           count--;									// if curr elem is not curr majority elem, then decrease the count
	        }
	    }
	 
	    for(int i=0;i<nums.length;i++)
	    {
	    	if(nums[i]==result)count++;
	    }
	    
	    if(count>nums.length/2)
	    	return result;							//eventually it will have element with majority. but check for count!!
	    else
	    	return -1;
	}
	
//	Given an integer array of size n, find all elements that appear more than n/3 times. The algorithm should run in linear time and in O(1) space.

	
	public List<Integer> majorityElement_3(int[] nums) {
	    List<Integer> result = new ArrayList<Integer>();
	 
	    Integer n1=null, n2=null;	//	maximum there can be two nums greated than n/3 length
	    int c1=0, c2=0;				//two counter variable
	 
	    for(int i: nums){
	        if(n1!=null && i==n1.intValue()){
	            c1++;
	        }else if(n2!=null && i==n2.intValue()){
	            c2++;
	        }else if(c1==0){
	            c1=1;
	            n1=i;
	        }else if(c2==0){
	            c2=1;
	            n2=i;
	        }else{
	            c1--;
	            c2--;
	        }
	    }
	 
	    c1=c2=0;
	 
	    for(int i: nums){
	        if(i==n1.intValue()){
	            c1++;
	        }else if(i==n2.intValue()){
	            c2++;
	        }
	    }
	 
	    if(c1>nums.length/3)
	        result.add(n1);
	    if(c2>nums.length/3)
	        result.add(n2);
	 
	    return result;
	}
}
