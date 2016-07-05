package com.tool.java.programcreek.array;

import java.util.HashMap;

public class A_27_LongestUniqueSubstring {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("ghavinashchander"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if(s==null)
			return 0;
		boolean[] flag = new boolean[256];

		int result = 0;
		int start = 0;
		char[] arr = s.toCharArray();
		int i;
		for ( i= 0; i < arr.length; i++) {
			char current = arr[i];
			if (flag[current]==false) {
				flag[current] = true;
			}
			else{
				result = Math.max(result, i - start);

				/*
				s     s     i
				g h a v i n a s

				k-> until a is reached. Make all flag false -> g- false, h - false. when a found update s(start) as a's next elem -> v
				 */
				for (int k = start; k < i; k++) {
					if (arr[k] == current) {
						start = k + 1; 
						break;
					}
					flag[arr[k]] = false;
				}

			}
		}

		result = Math.max(i - start, result);

		return result;
	}




	//using hashmap... hashmap clear everytime a duplicate occurs and i runs again from next index of last encountered index.
	public static int lengthOfLongestSubstring2(String s) {
		if(s==null)
			return 0;
		char[] arr = s.toCharArray();
		int pre = 0;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			} else {
				pre = Math.max(pre, map.size());
				i = map.get(arr[i]);
				map.clear();
			}
		}

		return Math.max(pre, map.size());
	}

}
