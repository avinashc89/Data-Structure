package com.tool.java.leetcode;

import java.util.*;
import com.tool.java.Util;

public class BracesExpansion2
{
    public static List<String> braceExpansionII(String s) {
        char[] ca = s.toCharArray();
        Queue<Character> q = new LinkedList<>();
        for(char c : ca) 
            q.offer(c);
        Set<String> res = helper(q);
        List<String> r = new ArrayList<>();
        for(String i: res) 
            r.add(i);
        Collections.sort(r);
        return r;
    }
   
    public static Set<String> helper(Queue<Character> q){
        Stack<Set<String>> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("");

        while(!q.isEmpty()){
            char c = q.poll();
            if(c == '{'){
                Set<String> recursive = helper(q);  // recursive
                Set<String> newSet = new HashSet<>(); 
                for(String s1: set){
                    for(String s2 : recursive){ // current set * recursive result
                        newSet.add(s1 + s2);
                    }
                }
                set = newSet;       
            }else if (c == '}') // if it is }, break the function. always encountered inside
            { 
                 break;
            }
            else if (c == ',') // if it is ',', it means plus, we need to store the old set, and create a new set.
            { 
                 stack.push(set);
                 set = new HashSet<>();
                 set.add("");
            }
            else // if it is 'a-z', mulitple current set with the c. 
            { 
                HashSet<String> newSet = new HashSet<>();
                for(String s: set){
                    newSet.add(s + c);
                }
                set = newSet;
            }
        }
        stack.push(set);
        HashSet<String> res = new HashSet<>();
        while(!stack.isEmpty()){
            Set<String> tmp = stack.pop();
            for(String i: tmp) res.add(i);
        }
        return res;
    }
    
    public static void main (String[] args)
    {
        BracesExpansion2 b = new BracesExpansion2();
        System.out.println(b.braceExpansionII("{{a,z},a{b,c},{ab,z}}"));
    }
}
