package com.tool.java.leetcode;

import java.util.*;

public class RearrangeStringKDistanceApart
{
    //Using map to store count and put in Priority queue. take out k items and update count and put it back
    public String rearrangeString(String s, int k) {
        
        
        if(k==0 || s!=null && s.length()==1)
            return s;
        
     
        //initialize the counter for each character
        final HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }
        
        //early pruning
        if(k > map.size())
        {
            return "";
        }
     
        //sort the chars by frequency
        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>(){
            public int compare(Character c1, Character c2){
                if(map.get(c2).intValue()!=map.get(c1).intValue()){
                    return map.get(c2)-map.get(c1);
                }else{
                    return c1.compareTo(c2);
                }
            }
        });
     
     
        for(char c: map.keySet())
            queue.offer(c);
     
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        
        while(!queue.isEmpty()){
            
            ArrayList<Character> temp = new ArrayList<Character>();     
            
            for(int i=0; i<k && i<=len; i++){             // either traverse k times or till the end of the string
                
                if(queue.isEmpty())             // in case of aaabbbcccd and k=5, queue contains a3,b3,c3,d1 but to keep k apart it loops for k times. 
                    return "";                  // if the queue is empty then there is no new element so we cant form result. return ""
     
                char c = queue.poll();
                sb.append(String.valueOf(c));
                len--;                            
     
                map.put(c, map.get(c)-1);
     
                if(map.get(c)>0){
                    temp.add(c);
                }
            }
     
            for(char c: temp)
                queue.offer(c);
        }
        String res = sb.toString();
        return res;
    }

    public static void main (String[] args)
    {
        RearrangeStringKDistanceApart r = new RearrangeStringKDistanceApart();
        //System.out.println(r.rearrangeString("aaabbbcccd",3));
        System.out.println(r.rearrangeString("aaabc",3));
        System.out.println(r.rearrangeString("a",9));
    }
}
