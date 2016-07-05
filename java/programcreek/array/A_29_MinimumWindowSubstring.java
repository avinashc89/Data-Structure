package com.tool.java.programcreek.array;

import java.util.HashMap;


//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

public class A_29_MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println(minWindow("abceeecabeeedeeeee", "abcd"));
		System.out.println(minWindow("ZBADETOACODABANC", "ABC"));
	}
	
	public static String minWindow(String s, String t) {
	    if(t.length()>s.length()) 
	        return "";
	    String result = "";
	 
	    //character counter for t
	    HashMap<Character, Integer> target = new HashMap<Character, Integer>();
	    for(int i=0; i<t.length(); i++){
	        char c = t.charAt(i);    
	        if(target.containsKey(c)){
	            target.put(c,target.get(c)+1);
	        }else{
	            target.put(c,1);  
	        }
	    }
	 
	    System.out.println("target-"+target);
	    // character counter for s
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    int left = 0;
	    int minLen = s.length()+1;
	 
	    int count = 0; // the total of mapped characters
	 
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	 
	        if(target.containsKey(c)){
	            if(map.containsKey(c)){
	                if(map.get(c)<target.get(c)){
	                    count++;
	                }
	                map.put(c,map.get(c)+1);
	            }else{
	                map.put(c,1);
	                count++;
	            }
	        }
	        System.out.println("char-"+c+"----map-with Count---"+map+"----"+count);
	        
	        if(count == t.length()){
	        	System.out.println(left);
	            char sc = s.charAt(left);
	            while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {			//	if the char is not present in map, then move to next char.class if it is found, and if the count of that char in map is more than what we neeed(count in t), then reduce the count and move the left.
	                if (map.containsKey(sc) && map.get(sc) > target.get(sc))
	                    map.put(sc, map.get(sc) - 1);
	                left++;
	                sc = s.charAt(left);
	            }
	            System.out.println( s.substring(left, i + 1));
	            if (i - left + 1 < minLen) {
	                result = s.substring(left, i + 1);
	                minLen = i - left + 1;
	            }
	        }
	    }
	 
	    return result;
	}
	
	
	
	
	
	public static String find(String s, String p) {
		if (p.length() > s.length())
			return null;
		int[] pCount = new int[256];
		int[] sCount = new int[256];
		// Time: O(p.lenght)
		for(int i=0;i<p.length();i++) {
			pCount[(int)(p.charAt(i))]++;
			sCount[(int)(s.charAt(i))]++;
		}
		int i = 0, j = p.length(), min = Integer.MAX_VALUE;
		String res = null;
		// Time: O(s.lenght)
		while (j < s.length()) {
			if (containsPatternChar(sCount, pCount)) {
				if ((j - i) < min) {
					min = j - i;
					res = s.substring(i, j);
					// This is the smallest possible substring.
					if(min==p.length())
						break;
					// Reduce the window size.
					sCount[(int)(s.charAt(i))]--;
					i++;
				}
			} else {
				sCount[(int)(s.charAt(j))]++;
				// Increase the window size.
				j++;
			}
		}
		System.out.println("0000"+res);
		return res;
	}
 
	// Complexity is O(256), hence constant.
	private static boolean containsPatternChar(int[] sCount, int[] pCount) {
		for(int i=0;i<256;i++) {
			if(pCount[i]>sCount[i])
				return false;
		}
		return true;
	}
}
