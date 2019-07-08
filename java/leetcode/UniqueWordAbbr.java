package com.tool.java.leetcode;

import java.util.*;

public class UniqueWordAbbr
{
    // dict =>"deer", "door", "cake", "card", d2r =2, c2e =1, c2d =1
    private Set<String> dict;
    private Map<String, Integer> map;
    public UniqueWordAbbr(String[] dictionary) 
    {
        dict = new HashSet<>(); 
        map = new HashMap<>();  // <abbr, count>
        for(String word : dictionary) {
            if(dict.contains(word)) continue;
            dict.add(word);
            String abbr = this.getAbbr(word);
            map.put(abbr, map.getOrDefault(abbr, 0) + 1);
        }
    }
    
    // if the word is present in dict, check if the abbr count is 1. if word is not there, then the abbr shouldnt be there in map
    
    public boolean isUnique(String word) {
        String abbr = this.getAbbr(word);   
        if(dict.contains(word))                      
        {              
            return map.get(abbr) == 1;
        }
        else if(map.containsKey(abbr))
        {
            return false;
        }
        return true;
    }
    
    private String getAbbr(String word) {
        if(word.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0)).append(word.length()-2).append(word.charAt(word.length()-1));
        return sb.toString();
    }
    
}
