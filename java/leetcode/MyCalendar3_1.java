package com.tool.java.leetcode;

import java.util.*;

public class MyCalendar3_1
{
    List<int[]> list; // start, end, count
    int res = 0;
   
    public MyCalendar3_1() {
        list = new ArrayList<>();
        list.add(new int[]{0, Integer.MAX_VALUE, 0});
    }

    public int book(int start, int end) {
        binaryInsert(start, end, 0, list.size());
        return res;
    }

    private void binaryInsert(int start, int end, int i, int j) {
        int mid = i + (j - i) / 2;
        if(mid < 0 ||  mid >= list.size()) return;
        int[] curr = list.get(mid);
        if(curr[1] <= start) {
            // left
            binaryInsert(start, end, mid + 1, j);
        } else if(curr[0] >= end) {
            binaryInsert(start, end, i, mid - 1);
        } else {
            int inserted = 0;
            if(curr[0] < start) {
                list.add(mid, new int[]{curr[0], start, curr[2]});
                inserted++;
                mid++;
            }
            if(curr[1] > end) {
                list.add(mid + 1, new int[]{end, curr[1], curr[2]});
                inserted++;
            }
            curr[1] = Math.min(end, curr[1]);
            curr[0] = Math.max(start, curr[0]);
            curr[2]++;
            res = Math.max(curr[2], res);
            printList();
            if(curr[0] > start) binaryInsert(start, curr[0], i, mid - 1 + inserted);
            if(curr[1] < end) binaryInsert(curr[1], end, mid + 1, j + inserted);
        }
    }
    
    public static void main (String[] args)
    {

        MyCalendar3_1 c = new MyCalendar3_1();
        c.printList();
        System.out.println(c.book(5, 7));
        System.out.println(c.book(15, 20));
        System.out.println(c.book(9, 13));
        System.out.println(c.book(11, 16));

    }
    
    public  void printList()
    {
        for(int[] a : list)
            System.out.print(a[0]+"\t");
        System.out.println();
        for(int[] a : list)
            System.out.print(a[1]+"\t");
        System.out.println();
        for(int[] a : list)
            System.out.print(a[2]+"\t");
        System.out.println("\n----------------");
    }
    
    /*
        0    
        147483647  
        0  
        ----------------c.book(5, 7)
        0   5   7   
        5   7   2147483647  
        0   1   0   
        
        ----------------c.book(15, 20)
        0   5   7   15  20  
        5   7   15  20  2147483647  
        0   1   0   1   0   
        
        ----------------c.book(9, 13)
        0   5   7   9   13  15  20  
        5   7   9   13  15  20  2147483647  
        0   1   0   1   0   1   0   
        
        ----------------c.book(11, 16)  => inserts 11,13
        0   5   7   9   11  13  15  20  
        5   7   9   11  13  15  20  2147483647  
        0   1   0   1   2   0   1   0   
        ----------------                    => search right & inserts (15,16) 
        0   5   7   9   11  13  15  16  20  
        5   7   9   11  13  15  16  20  2147483647  
        0   1   0   1   2   0   2   1   0   
        ----------------                   => search left & insert(13,15)
        0   5   7   9   11  13  15  16  20  
        5   7   9   11  13  15  16  20  2147483647  
        0   1   0   1   2   1   2   1   0   
        ----------------
     */
}
