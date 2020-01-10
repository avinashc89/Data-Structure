package com.tool.java.arrayString.scheduling;

import java.util.*;

public class MyCalendar1
{
    //double booking is not allowed
    
    ArrayList<Integer[]> slots; //List<[start,end]>
    TreeMap<Integer,Integer> slots1;
    
    public MyCalendar1() {
        slots = new ArrayList<Integer[]>();
        slots1 = new TreeMap<Integer,Integer>();
    }

    // each time traverse thro list and check previous and next time slots, if it can fit in between them
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
    
    //floorkey(x) returns the value of key that is immediate previous to x 
    //ceilingkey(x) returns the value of key that is immediate next to x 
    public boolean book1(int start, int end) {
       
        Integer prevSlotX = slots1.floorKey(start);
        if (prevSlotX!=null && slots1.get(prevSlotX) > start ) 
            return false;
            
        Integer nextSlotX = slots1.ceilingKey(start);
        if (nextSlotX!=null && nextSlotX < end) 
            return false;
        
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
