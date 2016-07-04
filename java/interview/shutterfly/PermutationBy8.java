package com.tool.java.interview.shutterfly;

import java.util.ArrayList;

public class PermutationBy8 {

	public static void main(String[] args) {

		String[] input = new String[]{"16","17"};
		String[] res = new String[input.length];
		for(int i=0; i< input.length ; i++){
			permutation_print_all_perm_in_String(input[i],input[i].length(), res,i);
			
		}
		
		System.out.println(res[0]);
		System.out.println(res[1]);
			
	}

	public static ArrayList<String> permutation_print_all_perm_in_String(String s, int n , String[] res , int index)
	{
		if(s == null) return null;

		ArrayList<String> perm = new ArrayList<String>();
		if(s.length() == 0){
			perm.add("");
			return perm;
		}

		char x  = s.charAt(0); // split the first char
		String remaining = s.substring(1);
		ArrayList<String> wordList = permutation_print_all_perm_in_String(remaining, n , res, index);
		for(String word : wordList)     // append the first char in all the places inside the words available in the list
		{
			for(int i=0 ; i<=word.length() ; i++) //i<=length - to include {} list at the base case
			{
				String first = word.substring(0,i);
				String last = word.substring(i);
				String permWord = first + x + last;
				perm.add(permWord);		
				if(permWord.length() == n)
				{
					res[index] = Integer.parseInt(permWord)%8==0 ?"YES":"NO";
					
					if(res[index]=="YES")
						return null;
				}
			}
		}
		return perm;

	}
}
