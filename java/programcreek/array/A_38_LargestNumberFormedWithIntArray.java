package com.tool.java.programcreek.array;

import java.util.Arrays;
import java.util.Comparator;

public class A_38_LargestNumberFormedWithIntArray {

	public static void main(String[] args) {
		System.out.println(largestNumber(new int[]{3,30,9,45,93})); // 99345330
	}
	
	public static String largestNumber(int[] nums) {
	    String[] strs = new String[nums.length];
	    for(int i=0; i<nums.length; i++){
	        strs[i] = String.valueOf(nums[i]);
	    }
	 
	    
	    Arrays.sort(strs, new Comparator<String>(){
	        public int compare(String s1, String s2){
	            String leftRight = s1+s2;
	            String rightLeft = s2+s1;
	            return -leftRight.compareTo(rightLeft);  //comparing by concating the two numbers -- 4,35  -> 435 or 354. (-) for sorting in descending order
	 
	        }
	    });
	 
	    StringBuilder sb = new StringBuilder();
	    for(String s: strs){
	        sb.append(s);
	    }
	 
	    //if the first number is zero, remove it
	    while(sb.charAt(0)=='0' && sb.length()>1){
	        sb.deleteCharAt(0);
	    }
	 
	    return sb.toString();
	}
	
	
	
}
