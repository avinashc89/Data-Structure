package com.tool.java.leetcode;

import java.util.HashSet;

public class WordBreak {

	
	public boolean findUsingDP(String s, HashSet<String> dict,
			HashSet<String> memory, String answer) {
		if (s.length() == 0) {
			System.out.println(answer);
			return true;
		} else if (memory.contains(s)) {
			return false;
		} else {

			int index = 0;
			String word = "";
			while (index < s.length()) {
				word += s.charAt(index);// add one char at a time
				// check if word already being solved
				if (dict.contains(word)) {
					if (findUsingDP(s.substring(index + 1), dict, memory,
							answer + word + " ")) {
						return true;
					} else {
						index++;
					}
				} else {					
					index++;
				}
			}
			memory.add(s);// memoization for future;
			return false;
		}
	}

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("this");
		hs.add("is");
		hs.add("sam");
		hs.add("samsung");
		hs.add("tv");
		hs.add("ice");
		hs.add("icecream");
		hs.add("cats");
		hs.add("cat");
		hs.add("and");
		hs.add("sand");
		hs.add("dogs");
		hs.add("sun");
		String s = "samsungtvcissand";
		String s1 = "catsanddogs";
		WordBreak ws = new WordBreak();
		
		// create another HashSet so store the sub problems result
		HashSet<String> memoization = new HashSet<String>();
		ws.findUsingDP(s, hs, memoization, "");
		
		HashSet<String> memoization1 = new HashSet<String>();
		ws.findUsingDP(s1, hs, memoization1, "");
	}
	
	
}
