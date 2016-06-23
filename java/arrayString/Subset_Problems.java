package com.tool.java.arrayString;

import java.util.ArrayList;
import java.util.HashSet;

public class Subset_Problems {

	public static void main(String[] args) {
      
      
      System.out.println(subset_That_Sums_To_N(new int[]{1,2,3,4,5} , 0, 0, 7, ""));  //sum=7
      System.out.println(subset_That_Sums_To_N_DP(new int[]{1,2,3,4,5}, 5, 7));  //sum=7  //length=5
	}

	//
	public static void subset_That_Sums_To_N_Print_All(int[] list, int index, int currSum, int goal, String result)
	{ 
		//if index goes beyond  array length or currSum is greater than given goal sum, just return
		if (list.length < index || currSum>goal)
			return;
		
		//iterate thro' array and add each number to currsum and check with goal sum.
		for (int i = index; i < list.length; i++) {

			if (currSum + list[i]  == goal)   {
				result =  result + " " + list[i];
				System.out.println(result);
				break;
			}
			else if (currSum + list[i] < goal) {
				subset_That_Sums_To_N_Print_All(list, i + 1, currSum + list[i], goal, result + " " + list[i]);
			}
		}
	}
	
	/*****************************************************************************/
	
	static public boolean subset_That_Sums_To_N_DP(int set[], int n, int sum)
	{
		boolean subset[][] = new boolean[sum+1][n+1];

		// If sum is 0, then answer is true
		for (int i = 0; i <= n; i++)
			subset[0][i] = true;

		for (int i = 1; i <= sum; i++)
			subset[i][0] = false;

		// Fill the subset table in botton up manner
		for (int i = 1; i <= sum; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				subset[i][j] = subset[i][j-1];
				if (i >= set[j-1])
					subset[i][j] = subset[i][j] || subset[i - set[j-1]][j-1];
			}
		}

		return subset[sum][n];
	}


	/*****************************************************************************/

	public static void subset_size_k(int[] A, int k, int start, int currLen, boolean[] used) {

		if (currLen == k) {
			for (int i = 0; i < A.length; i++) {
				if (used[i] == true) {
					System.out.print(A[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		if (start == A.length) {			//reaching last element.
			return;
		}
		// For every index we have two options,
		// 1.. Either we select it, means put true in used[] and make currLen+1
		used[start] = true;
		subset_size_k(A, k, start + 1, currLen + 1, used);
		// 2.. OR we dont select it, means put false in used[] and dont increase
		// currLen
		used[start] = false;
		subset_size_k(A, k, start + 1, currLen, used);
	}

	/*****************************************************************************/
	public static HashSet<HashSet<Integer>> subset_in_array1(int[] a)
	{
		//	static int lp = 0;
		//int k = check;

		//	int k = boof;
		HashSet<HashSet<Integer>> result = new HashSet<HashSet<Integer>> ();
		HashSet<Integer> set  = new HashSet<Integer>();
		for(int i : a)
			set.add(i);
		return generateSubset(result , set);

	}

	private static HashSet<HashSet<Integer>> generateSubset(
			HashSet<HashSet<Integer>> result, HashSet<Integer> set) {

		if(!set.isEmpty())
		{
			result.add(set);
			for(int i : set)
			{
				HashSet<Integer> temp = new HashSet<Integer>();
				temp.addAll(set);
				temp.remove(i);
				generateSubset(result, temp);
			}
		}
		return result;
	}

	/*****************************************************************************/
	public static HashSet<HashSet<Integer>>  subset_in_array2(int a[])
	{
		HashSet<HashSet<Integer>> result = new HashSet<HashSet<Integer>> ();
		HashSet<Integer> set  = new HashSet<Integer>();
		result.add(set);

		for(int i=0 ; i< a.length ; i++)
		{
			HashSet<HashSet<Integer>> temp = new HashSet<HashSet<Integer>>(); //cloning result into new temp
			for(HashSet<Integer> h : result)
			{
				HashSet<Integer> newset = new HashSet<Integer>();
				newset.addAll(h);
				temp.add(newset);
			}
			for(HashSet<Integer> h : result) // add a[i] to all hashset in result
			{
				h.add(a[i]);
			}
			result.addAll(temp); // combine temp(old result) and new result
		}
		return result;
	}

	/*****************************************************************************/
	public static ArrayList<String> permutation_print_all_perm_in_String(String s)
	{
		if(s == null) return null;

		ArrayList<String> perm = new ArrayList<String>();
		if(s.length() == 0){
			perm.add("");
			return perm;
		}

		char x  = s.charAt(0); // split the first char
		String remaining = s.substring(1);
		ArrayList<String> wordList = permutation_print_all_perm_in_String(remaining);
		for(String word : wordList)     // append the first char in all the places inside the words available in the list
		{
			for(int i=0 ; i<=word.length() ; i++) //i<=length - to include {} list at the base case
			{
				String first = word.substring(0,i);
				String last = word.substring(i);
				String permWord = first + x + last;
				perm.add(permWord);		
			}
		}
		return perm;

	}

}
