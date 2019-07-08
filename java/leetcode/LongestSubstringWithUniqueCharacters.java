package com.tool.java.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithUniqueCharacters
{
    //Using Hashset.put all the char in set. if say 'a' is found again, then remove all the char encountered till a.
    // ie., read from i=0 till a, remove s.charAt(i) . remove a and break.
    // everytime char is added in set, maximum set.size is answer
    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
     
        HashSet<Character> set = new HashSet<>();
        int result = 1;
        int i=0; 
        for(int j=0; j<s.length(); j++){
            char c = s.charAt(j);
            if(!set.contains(c))
            {
                set.add(c);
                result = Math.max(result, set.size());
            }
            else
            {
                while(i<j){
                    if(s.charAt(i)==c){         // say a is duplicate,  start from the 0, read the char and remove all till a is found.
                        i++;
                        break;
                    }
                    set.remove(s.charAt(i));    // say a is duplicate,  start from the 0, read the char and remove all till a is found.
                    i++;
                }
            }    
        }
        return result;
    }

    public static void main(String args[]) throws Exception
    {
        System.out.println(lengthOfLongestSubstring("karap"));
    }

}
