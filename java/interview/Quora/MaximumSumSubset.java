package com.tool.java.interview.Quora;

import java.util.Arrays;

public class MaximumSumSubset {

	/*
	 * To execute Java, please define "static void main" on a class
	 * named Solution.
	 *
	 * If you need more classes, simply define them inline.
	 
	 Given a list of integers, return the maximum sum you can create from a subset such that if you pick n, you cannot pick n + 1
	 
	 e.g. [1, 2, 1, 3] -> 5 (1, 1, 3)
	 
	 1 3  7  8  9 9  10 11 11 
	 
	 1 4 11 12  20 29 22 40 51
	 
	 
	 [1, 5, 10] -> 16 (1, 5, 10)
	 
	 */
	public static void main(String[] args) {
	    
	    findMaximumSum(new int[]{1,3,7,8,9,9,10,11,11});
	      
	  }
	  
	  public static int findMaximumSum(int a[])
	  {
		  
	      if(a==null || a.length==0) return -1;
	     // if(a.length==1) return a[0];
	    
	      Arrays.sort(a);
	      int result =a[0];
	      int max[] = new int[a.length];
	      
	      max[0] = a[0];
	    
	      for(int i=1; i< a.length ;i++)
	      {
	        if(a[i]!= a[i-1]+1)
	        {
	          max[i] = max[i-1]+a[i];
	        }
	        else
	        {
	          int j=i-1;
	          while(j>0 && a[i]==a[j]+1)
	          {
	              j--;
	          }
	          max[i] = max[j]+a[i];
	        }
	        
	        if(result < max[i] )
	            result=max[i];
	      }
	    
	      System.out.println(result);
	    return result;
	      
	  }
	
}
