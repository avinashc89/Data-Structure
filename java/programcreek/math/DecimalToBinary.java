package com.tool.java.programcreek.math;

public class DecimalToBinary {


	public static void main(String[] args) {
		int x=1314530000;
		decTobin(x);
		noofZeros(x);
		longestConsecutiveZeros(x);
		longestConsecutiveZerosInsideOnes(x);
	//
	}

	public static void decTobin(int x)
	{
		StringBuilder s = new StringBuilder();
		for(int i= x ; i>0; i>>=1)
		{
			if((i&1)==1)
				s.append(1);
			else
				s.append(0);
		}
		System.out.println(s.reverse().toString());
	}
	
	public static void noofZeros(int x)
	{
		int count=0;
		for(int i= x ; i>0; i>>=1)
		{
			if((i&1)==0)
				count++;
		}
		System.out.println(count);
	}
	
	public static void longestConsecutiveZeros(int x)
	{
		int maxLen =0 ;
		int currLen=0;
		for(int i=x ;i>0 ; i>>=1)
		{
			if((i&1)==0)
			{
				currLen++;
			}
			else
			{
				if(currLen > maxLen)
					maxLen=currLen;
				
				currLen=0;
			}
		}
		if(currLen > maxLen)
			maxLen=currLen;
		System.out.println(maxLen);
	}
	
	public static void longestConsecutiveZerosInsideOnes(int x)
	{
		boolean zeroStart=false;
		int maxLen =0 ;
		int currLen=0;
		for(int i=x ;i>0 ; i>>=1)
		{
			if(zeroStart && (i&1)==0)
			{
				currLen++;
			}
			else
			{
				zeroStart=true;
				if(currLen > maxLen)
					maxLen=currLen;
				
				currLen=0;
			}
		}
		
		System.out.println(maxLen);
	}
}
