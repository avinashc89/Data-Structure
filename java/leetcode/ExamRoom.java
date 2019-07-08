package com.tool.java.leetcode;

import java.util.*;

public class ExamRoom
{
    int n;
    TreeSet<Integer> set;

    public ExamRoom(int N) {
        n = N;
        set = new TreeSet<>();
    }

    public int seat() 
    {
        if (set.isEmpty()) 
        {
            set.add(0);
            return 0;
        }
        int lastSeatPos = -1;
        int maxDis = set.first();   // whatever the number is, if n, 0->n => n is the max
        int res = 0;
        for (int occPos : set) 
        {
            if (lastSeatPos != -1) 
            {
                int farthestDistance = (occPos - lastSeatPos) / 2;
                if (farthestDistance > maxDis) {
                    maxDis = farthestDistance;
                    res = lastSeatPos + farthestDistance;
                }
            }
            lastSeatPos = occPos;
        }
        if (n - 1 - set.last() > maxDis)
        {
            res = n - 1;
        }
        set.add(res);
        return res;
    }

    public void leave(int p) {
        set.remove(p);
    }

    
    public static void main (String[] args)
    {
        ExamRoom e = new ExamRoom(10);
        e.seat();
        e.seat();
        e.seat();
        e.seat();
    }
}
