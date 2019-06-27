package com.tool.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordAbbreviation
{

    /*

      if same length ignore
      if two words have same abbr, then create abbr based on the common prefix+one char(where it differs) among the words => again rule 1 applies


    Input: ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
    Output: ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
    
    {inte4n=intension, internal=internal, i6t=internet, me=me, f2e=face, interval=interval, intr4n=intrusion, god=god, l2e=like}
    
        like => l2e
        god => g1d => same length => god
        internal => i6l  longest prefix =>intern1l => same length => internal
        interval => i6l  longest prefix => interv1l same length => interval
        me => me
        face => f2e
        intension => i8n => inte4n
        intrusion => i8n => intr4n
        internet => i6t

        iterate
        put in map=> <s.charAt(0)+"s.length()-2"+ s.charAt(s.length-1) , s>

        if already present, then find the length of common prefix of the s1 and s2 (say k)
           put<(s.substring(0,k)+"s.length()-k-2"+ s.charAt(s.length-1) , s> for both words

     */

    /*
     initially total prefix to be used is 0
     helper: words,total prefix to be used
         calc prefix, num, suffix
         for each word. key=> prefix+num+sufix
         for first map => {i7n=[intension, intrusion], a5g=[abcdefg, abccefg, abcckkg], m0e=[me], i6t=[internet], f2e=[face], g1d=[god], l2e=[like], i6l=[internal, intelval, interval]}
         
         iterate Map entry
             if the value size(no of words) is one, then add <value,key> in result map
             else
                 call helper again (words, prefix+1) 
     
     */
    public static List<String> wordsAbbreviation(List<String> dict) {
        Map<String, String> map = helper(dict, 1);
        List<String> res = new ArrayList<>();
        for(String s : dict) {
            res.add(map.get(s));
        }
        return res;
    }
    private static Map<String, String> helper(List<String> dict, int prefixSize)
    {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : dict) {
            String prefix = s.substring(0, prefixSize);
            String surfix = s.substring(s.length() - 1, s.length());
            String key = prefix +""+ (s.length() - 1-prefixSize )+""+surfix;
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        Map<String, String> res = new HashMap<>();
        for(Map.Entry<String, List<String>> e : map.entrySet()) {
            if(e.getValue().size() == 1) {
                String s = e.getValue().get(0);
                int num = s.length() - prefixSize - 1;
                if(num <= 1) {
                    res.put(s, s);
                } else {
                    res.put(s, e.getKey());
                }
            } else {
                res.putAll(helper(e.getValue(), prefixSize+1));
            }
        }
        return res;
    }

    public static void main (String[] args)
    {
        String[] words = {"like", "god", "internal", "me", "internet","intelval", "interval", "intension", "face", "intrusion", "abcdefg","abccefg","abcckkg"};
        List<String> res = wordsAbbreviation(Arrays.asList(words));
        System.out.println(res);
    }
    
    /*
     ["abcdefg","abccefg","abcckkg"]
     {"abcdefg","abccefg","abcckkg"};
     
     a5g
     a5g
     a5g
     
     
     */




}
