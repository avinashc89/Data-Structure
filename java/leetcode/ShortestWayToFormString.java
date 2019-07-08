package com.tool.java.leetcode;

import java.util.*;

public class ShortestWayToFormString
{
    /*
     "xyz", "xzyxz" 
     */

    /*
         method 1: comparing chars with two pointers i,j. 
         i-> source
         j-> target
     */
    
    public int shortestWay(String source, String target) {
        int count = 0;
        int i = 0;
        int j = 0;
        
        while(j< target.length())
        {
            int start = j;
            while( i< source.length() && j< target.length() )
            {
                if(source.charAt(i) == target.charAt(j))
                {
                    i++;
                    j++;
                }
                else {
                    i++;            //increment only source till we find next match to target
                }
            }
            if(start == j)          // means no match found in target and while ends
            {
                return -1;
            }
            else
            {
                count++;        //end of one loop in source
                i=0;
            }
        }
        return count;
    }
    
    /*
      method 2 :same as method 3 but using map to know the location of next index
      Create a hashtable to save the first index of character after index i
      for xyz
      -1    => -1-1-1-1..-1-1 0 1 2
      0    => -1-1-1-1..-1-1 -1 1 2
      1    => -1-1-1-1..-1-1 -1 -1 2
      2    => -1-1-1-1..-1-1 -1 -1 -1
      
      for i=0 , => x => at map(0), stores the next indexes. 
      
     */
    public int shortestWay1(String source, String target) {
        int count = 0;
        int[] array = new int[26];
        Arrays.fill(array, -1);
        
        Map<Integer, int[]> map = new HashMap<>(); 
        
        for(int i = source.length()-1 ; i >=0; i--)
        {
            map.put(i , Arrays.copyOf(array, 26));          
            array[source.charAt(i)-'a'] = i;
        }
        map.put(-1, Arrays.copyOf(array, 26));
        
        int i = 0;
        while(i < target.length())
        {
            //everytime start at index =-1 so we start at source start.
            int index = -1;
            while(i < target.length() && map.get(index)[target.charAt(i) - 'a'] != -1)
            {
                index = map.get(index)[target.charAt(i)- 'a'];
                i++;
            }
            if(index == -1)
            {
                return -1;      //we can say no match found for entire iteration. so end. 
            }
            else
            {
                count++;
            }
        }
        return count;
    }
    
    /*
      method 3: Same as 1 but instead of traversing, find the next index using binary search /use indexOf().
      Use map to store the index of each char. 
      //map : {x=[0, 1], y=[2], z=[3]}
      //for x=> [0,1], find the next number of -1.=> 0. 0=>1
     */
    public int shortestWay2(String source, String target) {
        Map<Character, ArrayList<Integer>> map = new HashMap();
        for(int i = 0; i < source.length(); i++)
        {
            char c = source.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }
        //map : {x=[0, 1], y=[2], z=[3]}
        
        int count = 0;
        int i = 0;
        while(i < target.length())
        {
            int j = -1;
            while(i < target.length() && findNextIndex(map.get(target.charAt(i)), j) != -1)  //for x=> [0,1], find the next number of -1.
            {
                j = findNextIndex(map.get(target.charAt(i)), j);
                i++;
            }
            if(j == -1)
            {
                return -1;
            }
            else
            {
                count++;
            }
        }
        return count;

    }
    
    private int findNextIndex(ArrayList<Integer> list, int begin)
    {
        if(list == null)
        {
            return -1;
        }
        if(list.size() == 0)
        {
            return -1;
        }
        int left = 0;
        int right = list.size() - 1;
        while(left < right)
        {
            int mid = (left + right) / 2;
            if(list.get(mid) > begin)
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        if(list.get(left) > begin)
        {
            return list.get(left);
        }
        else
        {
            return -1;
        }
    }
    
    
    public static void main (String[] args)
    {
        ShortestWayToFormString s = new ShortestWayToFormString();
        System.out.println(s.shortestWay3("xxyz", "xxzyxz"));
    }
    
    ///same as method1
    public int shortestWay3(String source, String target) {
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        int j =0;
        int cnt = 0;
        while (j < t.length) {
            int start = j;
            for (int i = 0; j < t.length && i < s.length; ++i) {
                if (s[i] == t[j]) {
                   j++;
                }
            }
            if (start == j) {
                return -1;
            }
            ++cnt;
        }
        return cnt;
    }
    
}
