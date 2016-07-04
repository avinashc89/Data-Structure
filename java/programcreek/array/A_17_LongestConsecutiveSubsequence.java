package com.tool.java.programcreek.array;

import java.util.HashSet;

public class A_17_LongestConsecutiveSubsequence {

	public static void main(String args[])
	{
		int a[] =  {3, 9, 4, 10, 1, 20, 2};
		System.out.println("Length of the Longest consecutive subsequence is " +
				findLongestConseqSubseq(a));
	}


	static int findLongestConseqSubseq(int a[])
	{
		HashSet<Integer> s = new HashSet<Integer>();
		int maxlen = 0;
		String result ="";

		for (int i=0; i<a.length; ++i)
			s.add(a[i]);

		for (int i=0; i<a.length; ++i)
		{
			// if current element is the starting element of a sequence, then it wont have previous number in the set, 
			//now go inside if and find oher numbers
			if (!s.contains(a[i]-1))
			{
				String tempres="";
				int j = a[i];
				while (s.contains(j)){
					tempres+=Integer.toString(j);
					j++;
				}

				// update  optimal length if this length is more
				if (maxlen < j-a[i]){
					maxlen = j-a[i];
					result = tempres;
				}
			}
		}
		System.out.println(result);
		return maxlen;
	}



}
