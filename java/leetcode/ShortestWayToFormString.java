package com.tool.java.leetcode;

public class ShortestWayToFormString
{

    public int shortestWay(String source, String target) {
        int count = 0;
        int i = 0;
        int j = 0;
        int m = target.length();
        int n = source.length();
        
        while(i < m)
        {
            int start = i;
            while(i < m && j < n)
            {
                if(target.charAt(i) == source.charAt(j))
                {
                    i++;
                    j++;
                }
                else
                {
                    j++;
                }
            }
            if(start == i)
            {
                return -1;
            }
            else
            {
                count++;
                j = 0;
            }
        }
        return count;
    }
    
    public static void main (String[] args)
    {
        ShortestWayToFormString s = new ShortestWayToFormString();
        s.shortestWay("xyz", "xzyxz");
    }
}
