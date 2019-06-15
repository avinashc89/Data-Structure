package com.tool.java.arrayString.subset_subseq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Subset_Problems {

	public static void main(String[] args) {
		//		subset_That_Sums_To_N_Print_All(new int[]{1,2,3,4,5} , 0, 0, 7, ""); 

		String s = "aabc";
		ArrayList<String> result = printPerms(s);
		System.out.println("Count: " + result.size());
		for (String r : result) {
			System.out.println(r);
		}
	}

	/******************************print all Subset sum k***********************************************/

	//subset_That_Sums_To_N(int[] list,  0, 0, N ,"")
	//	In the worst case for every number you take you have 2 paths to go, one is directly to the next number using the for loop and the other is recursive call to the next number. 
	//	Therefore the complexity of the program is (2^n)

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
	/********************************subset sum k present?*********************************************/
	static public boolean subset_That_Sums_To_N_Present(int a[], int sum)
	{
		int n = a.length;
		boolean T[][] = new boolean[n+1][sum+1];

		// If sum is 0, then answer is true
		for (int i = 0; i <= n; i++)
			T[i][0] = true;

		/*	for (int i = 1; i <= sum; i++)
			T[i][0] = false;
		 */

		// Fill the subset table in botton up manner
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= sum ; j++)
			{
				if(j < a[i-1])
					T[i][j] = T[i-1][j];				//copy the top value
				else 
					T[i][j] = T[i-1][j- a[i-1]] ||  T[i-1][j];  // copy T[one step up, a[i] steps left] || top value
			}
		}

		return T[n][sum];
	}


	/*************************************two subset with equal sum****************************************/

	//	int arr[] = {1, 3, 5, 5, 2, 1, 1, 6};  //need to find if the array can be split into two(can be diff size) equal sum
	//    System.out.println(ss.partition(arr)); // so find the sum subset for sum/2. if such subset present, then remaining int forms another subset of sum = sum/2


	public boolean partition(int arr[]) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		if (sum % 2 != 0) {
			return false;
		}
		sum = sum / 2;
		boolean[][] T = new boolean[arr.length + 1][sum + 1];

		for (int i = 0; i <= arr.length; i++) {
			T[i][0] = true;
		}

		for (int i = 1; i <= arr.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j - arr[i - 1] >= 0) {
					T[i][j] = T[i - 1][j - arr[i - 1]] || T[i - 1][j];
				} else {
					T[i][j] = T[i-1][j];
				}
			}
		}
		return T[arr.length][sum];
	}

	/*********************************print all subset size k********************************************/

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

	/******************************Print all subset/ combination of array/ powerset***********************************************/

	public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>(); 
		int index = 0;
		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}

	public static ArrayList<ArrayList<Integer>> PowerSet(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size(); /* Compute 2^n */ 
		for (int k = 0; k < max; k++) {
			ArrayList<Integer> subset = convertIntToSet(k, set);
			allsubsets.add(subset);
		}
		return allsubsets;
	}

	/***********************************Print all subset/ combination of array/ powerset******************************************/


	/*public static HashSet<HashSet<Integer>> powerSet1(int[] a)
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
	}*/

	/****************************************Print all subset/ combination of array/ powerset*************************************/
	/*public static HashSet<HashSet<Integer>>  PowerSet2(int a[])
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
	}*/

	/********************************Permutation of string/ Anagrams of String o(n!) n! words formed*********************************************/
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
	/*********************************Permutation of string/ Anagrams of String with duplicates********************************************/

	public static HashMap<Character, Integer> buildFreqTable(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}
		System.out.println("---"+map);
		return map;
	}

	public static void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
		if (remaining == 0) {
			result.add(prefix);
			return;
		}

		for (Character c : map.keySet()) {
			int count = map.get(c);
			if (count > 0) {
				map.put(c,  count - 1);										//reduce one count of that character and add to prefix
				printPerms(map, prefix + c, remaining - 1, result);
				map.put(c,  count);											// put back the count again, so that the count remains same when string starts with other character 
			}
		}
	}

	public static ArrayList<String> printPerms(String s) {
		ArrayList<String> result = new ArrayList<String>();
		HashMap<Character, Integer> map = buildFreqTable(s);
		printPerms(map, "", s.length(), result);
		return result;
	}


}
