package com.tool.java.leetcode;

import java.util.*;

public class FindAndReplaceString
{

    /*
     
     Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
     Output: "eeebffff"
     Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
     "cd" starts at index 2 in S, so it's replaced by "ffff".
     
     */
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder res = new StringBuilder();
        HashMap<Integer, String[]> map = new HashMap<>();
        for(int i = 0; i < indexes.length; i++) {
            int index = indexes[i];
            if(S.substring(index).startsWith(sources[i])) 
            {
                map.put(index, new String[]{sources[i], targets[i]});
            }
        }
        int i = 0;
        while(i < S.length()) {
            if(!map.containsKey(i))             //no replacement info available. so append the next char as usual
                res.append(S.charAt(i++));
            else {                              // else append the target string and move the i to source string length
                res.append(map.get(i)[1]);
                i += map.get(i)[0].length();
            }
        }
        return res.toString();
    }
    
}
