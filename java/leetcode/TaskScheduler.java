package com.tool.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TaskScheduler
{
    /*
     
    ["A","A","A","B","B","B"], n = 2 => minimum 2 task should be between the same task. it can do any other task or be idle
    A -> B -> idle -> A -> B -> idle -> A -> B
    
    freq count using hashmap
    PQ with sorting on frequency and alphabetical order
    
    put everything on 
    * 
    */
    
    public int leastInterval1(char[] tasks, int k) {

        if(tasks == null)
            return 0;
        
        if(k==0 || tasks.length==1)
            return tasks.length;
        
     
        //initialize the counter for each character
        final HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<tasks.length; i++){
            char c = tasks[i];
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
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
     
        int totalTime = 0;
        int len = tasks.length;
        
        while(!queue.isEmpty()){
            
            ArrayList<Character> temp = new ArrayList<Character>();     
            
            for(int i=0; i<=k && len>0 ; i++){             // either traverse k times or till the end of the string
                
                if(queue.isEmpty())  {           // in case of aaabbbcccd and k=5, queue contains a3,b3,c3,d1 but to keep k apart it loops for k times. 
                     totalTime++;                // if the queue is empty then there is no new element so we cant form result. return ""
                     continue;
                }
                char c = queue.poll();
                totalTime++;
                len--;                            
     
                map.put(c, map.get(c)-1);
     
                if(map.get(c)>0){
                    temp.add(c);
                }
            }
     
            for(char c: temp)
                queue.offer(c);
        }
        return totalTime;
    
    }
    
    public static void main (String[] args)
    {
        TaskScheduler t = new TaskScheduler();
        System.out.println(t.leastInterval(new char[]{'A','A','A','B','B','B','C'}, 4));
    }
    
    /*
     using mathematical formula:
     
     let say A is repeated 15 times,  A will be in in 15 cycles 
      ex: AAAABBB,2 => ABIABIABIA
                      1st 2nd 3rd.      max char count = 4 => A
                      
                      So, A will appear in 4 intervals, where in 4th interval, only maxcount chars appears(i.e, A)
                      remaining 3 intervals, A appears atleast once and each interval is of length N+1.
                      
                      => 3(N+1) + 1 (no of max count chars) = 3(2+1)+1 => 10
     
     so find the most occuring char's count. => maxcount 
     see how many char are there with such count // these appears in last interval => maxcountchars
     
     (maxcount-1)*(N+1) + maxcountchars
     
     spl case, k =0, we can return the tasks.length
    */
    public int leastInterval(char[] tasks, int n) {
        
        int[] count = new int[26];
        
        int maxCount;
        
        int numberOfMaxCount = 0;
        
        for(char ch : tasks) {
            count[ch - 'A']++;
        }
        
        Arrays.sort(count);
        maxCount = count[25];

        for(int num : count) {
            if(num == maxCount ) {
                numberOfMaxCount++;
            }
        }
        
        return Math.max((maxCount - 1) * (n + 1) + numberOfMaxCount, tasks.length);
        
    }
}
