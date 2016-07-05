package com.tool.java.programcreek.array;

import java.util.HashMap;

public class A_28_LongestUniqueKSubstring {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringKDistinct("abcadcacacaca", 3));
	}

	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		int max=0;
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		int start=0;

		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			
			//build frequency table
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c,1);
			}

			//when map size is greated than k
			if(map.size()>k){
				max = Math.max(max, i-start);

				while(map.size()>k){
					char t = s.charAt(start);
					int count = map.get(t);
					if(count>1){
						map.put(t, count-1);
					}else{
						map.remove(t);
					}
					start++;
				}
			}
		}

		max = Math.max(max, s.length()-start);

		System.out.println(s.substring(start,start+max));
		return max;
	}
	
	
	/************************** Approach 2 ***************************************************/
	
	public static boolean isValid(int count[], int k)
	{
	    int val = 0;
	    for (int i=0; i<26; i++)
	        if (count[i] > 0)
	            val++;
	 
	    // Return true if k is greater than or equal to val
	    return (k >= val);
	}
	public static void Substring_with_K_unique_char(char[] s, int k)
	{
	    int u = 0; // number of unique characters
	    int n = s.length;
	 
	    int count[]  = new int[26];
	 
	    for (int i=0; i<n; i++)
	    {
	        if (count[s[i]-'a']==0)
	            u++;
	        count[s[i]-'a']++;
	    }
	 
	    if (u < k)
	    {
	       //"Not enough unique characters";
	        return;
	    }
	 
	    int curr_start = 0, curr_end = 0;
	    int maxlength = 1, max_start = 0;
	 
	   count = new int[26];
	    
	    count[s[0]-'a']++;  // put the first character
	 
	    // Start from the second character and add
	    // characters in window according to above
	    // explanation
	    for (int i=1; i<n; i++)
	    {
	        // Add the character 's[i]' to current window
	        count[s[i]-'a']++;
	        curr_end++;
	 
	        // If there are more than k unique characters in
	        // current window, remove from left side
	        while (!isValid(count, k))
	        {
	            count[s[curr_start]-'a']--;
	            curr_start++;
	        }
	 
	        // Update the max window size if required
	        if (curr_end-curr_start+1 > maxlength)
	        {
	        	maxlength = curr_end-curr_start+1;
	        	max_start = curr_start;
	        }
	    }
	 
	  System.out.println(s.toString().substring(max_start, max_start+maxlength));
	}
}
