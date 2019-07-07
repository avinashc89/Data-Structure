package com.tool.java.leetcode;

import java.util.*;

public class ReorganizeString
{
    /*
     get Freq count map. sort by count using PQ and comparator
     
     last ="" to check the last appended char
     
     while PQ is not empty,
         poll one, check if it is the last char, if not, append the char, reduce count put back in PQ
                         if it is last char, 
                                 if PQ still has elements
                                         poll one more, append the char, reduce count put back both in PQ 
                                 if not, return "" nothing can be done.
      
     */
    public String reorganizeString(String S) {

        if (S.isEmpty()) return "";

        //get freq count map
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < S.length(); i++) 
        {
            if (!counts.containsKey(S.charAt(i))) 
                counts.put(S.charAt(i), 1);
            else 
                counts.put(S.charAt(i), counts.get(S.charAt(i))+1);
        }

        //sort using PQ // by count & then alphabetical order
        PriorityQueue<Freq> sorted = new PriorityQueue<>((e1, e2) -> {
            if (e1.freq != e2.freq) 
                return e2.freq - e1.freq;
            else return e1.c - e2.c;
        });

        for (Map.Entry<Character, Integer> e : counts.entrySet()) 
            sorted.add(new Freq(e.getKey(), e.getValue()));


        StringBuilder b = new StringBuilder();
        Character last = null;                      // to know the last char appended to string. 

        while (!sorted.isEmpty()) {
            Freq f = sorted.poll();
            if (last == null || f.c != last) 
            {
                b.append(f.c);
                last = f.c;
                
                int newCount = f.freq - 1;
                if (newCount != 0) 
                    sorted.add(new Freq(f.c, newCount));
                
            } 
            else if (!sorted.isEmpty())         // say a=5 b=4 => after first iteration a is appened, PQ will a4 b4, again a in front.
            {
                Freq next = sorted.poll();      // so if last == sorted.poll,, poll one more. do the operation and put back both.
                
                b.append(next.c);
                last = next.c;
                
                int newCount = next.freq - 1;
                if (newCount != 0) 
                    sorted.add(new Freq(next.c, newCount));
                
                sorted.add(f);      // add the first removed back to PQ
                
            } 
            else return "";
        }
        
        return b.toString(); 

    }
    
    public static void main (String[] args)
    {
        ReorganizeString r = new ReorganizeString();
        System.out.println(r.reorganizeString("aaaaabbbb"));
    }

}


class Freq {
    char c;
    int freq;

    public Freq(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }

    @Override
    public String toString ()
    {
        // TODO Auto-generated method stub
        return this.c+"-"+this.freq;
    }
  
}
