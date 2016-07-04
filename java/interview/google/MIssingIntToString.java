package com.tool.java.interview.google;

import java.util.Arrays;

public class MIssingIntToString {
	
	public static void main(String[] args) {
		
		
		System.out.println(missingInt(new int[]{1,2,4,7,12,13,245,247,678,999}));
		System.out.println(missingInt(new int[]{}));
		System.out.println(missingInt(new int[]{1}));
		System.out.println(missingInt(new int[]{1000}));
		System.out.println(missingInt(new int[]{1,1000}));
		System.out.println(missingInt(null));
	}
	
	public static String missingInt(int[] a)
	{
		if(a==null) return null;
		
		if(a.length ==0) return "1-1000";
		
		Arrays.sort(a);
		
		StringBuilder result = new StringBuilder();
		
		int start ;
		if(a[0]!=1)
			start =1;
		else
			start =2;
		
		int end;
		for(int i=0 ; i<a.length ;i++)
		{
			end = a[i]-1;
			if(start == end)
				result.append(start).append(",");
			else 
			{
				if(start < end)
					result.append(start).append("-").append(end).append(",");
			}
			
			start = a[i]+1;
		}
		
		if(start<1001)
		{
			if(start == 1000)
			{
				result.append(start).append(",");
			}
			else
			{
				result.append(start).append("-").append("1000").append(",");
			}
		}
		return result.substring(0, result.length()-1);
	}

}
