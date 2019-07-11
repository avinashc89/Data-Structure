package com.tool.java.leetcode;

import java.util.TreeSet;

public class KEmptySlots
{
    public static int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {

            int slot = flowers[i];
            set.add(slot);
            Integer leftSlot = set.lower(slot); // closet slot from left 
            Integer rightSlot = set.higher(slot); // closet slot from right

            if (leftSlot != null && slot - leftSlot == k + 1 
                || rightSlot != null && rightSlot - slot == k + 1) {
                return i + 1;
            }
        }

        return -1;
    }



    public static int kEmptySlots1(int[] flowers, int k) {
        int[] days = new int[flowers.length];
        for (int i = 0; i < days.length; i++) {
            days[flowers[i] - 1] = i + 1;
        }
        int left = 0;
        int right = k + 1;
        int res = Integer.MAX_VALUE;
        for (int i = 1; right < days.length; i++) {
            // current days[i] is valid, continue scanning => means //35764 l=3 r=4, so, bet l&r there was no blossom, coz they are future blossoms.
            if (days[i] > days[left] && days[i] > days[right]) {
                continue;
            }
           // reach boundary of sliding window, since previous number are all valid, record result  
            if (i == right) {
                res = Math.min(res, Math.max(days[left],days[right]));
            }
            // not valid, move the sliding window
            left = i;
            right = left + k + 1;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main (String[] args)
    {
        kEmptySlots1(new int[]{6,7,1,5,2,4,3},3);
    }

}
