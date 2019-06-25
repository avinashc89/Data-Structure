package com.tool.java.arrayString.scheduling;

import java.util.*;

public class MyCalendar1
{

    ArrayList<Integer[]> slots;
    TreeMap<Integer,Integer> slots1;

    public MyCalendar1() {
        slots = new ArrayList<Integer[]>();
        slots1 = new TreeMap<Integer,Integer>();
    }

    public boolean book(int start, int end) {
        for (Integer[] slot : slots)
        {
            if((start < slot[0] && end < slot[0]) || start > slot[1] && end > slot[1]){
                continue;
            }
            else{
                return false;
            }
        }
        slots.add(new Integer[]{start,end});
        return true;
    }
    
    public boolean book1(int start, int end) {
       
        Integer prevSlotX = slots1.floorKey(start);
        
        if (prevSlotX!=null && slots1.get(prevSlotX) > start ) return false;
            
        Integer nextSlotX = slots1.ceilingKey(start);
        if (nextSlotX!=null && nextSlotX < end) return false;
        
        slots1.put(start, end);
        return true;
    }

    public static void main (String[] args)
    {

        MyCalendar1 c = new MyCalendar1();
        
        System.out.println(c.book1(5, 7));
        System.out.println(c.book1(5, 17));

    }

}
