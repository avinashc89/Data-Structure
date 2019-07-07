package com.tool.java.leetcode;

import java.util.*;

public class BullAndCow
{

    public String getHint(String secret, String guess) {
        Set<Integer> set = new HashSet<>(); //holds unmatches indecies of guess. let say sec = 3436, guess = 6533, set holds 0,1,3
        int[] secretCount = new int[10];
        int bulls = 0;
        for(int i = 0; i <= secret.length() - 1; i++) {
            if(guess.charAt(i) == secret.charAt(i)) {
                bulls++;
            } else {
                secretCount[secret.charAt(i) - '0']++;
                set.add(i);
            }
        }
        int cows = 0;

        // get the unmatched indexes and check if those digits are present in secret. if yes, decrement the count and add cow
        for(int i: set) {
            int val = guess.charAt(i) - '0';
            if(secretCount[val] > 0) {
                cows++;
                secretCount[val]--;
            }
        }
        return bulls + "A" + cows + "B";
    }

    //increment and decrement.
    // part1: if digit and index matches, increse bull
    //          if not increase the cow.
    //          for example 3436,  6533 => 2nd pos is bull. ignore it. rest are considered not matched. 
    //          we have 346, 653 =>  once the loop ends only 4 & 5 have values in the counter. rest all would have incremented and decremented by 1. 
    // part2: cow count is 3, so reduce the remaining index which are never a match. (4). 
    public String getHint1(String secret, String guess) {

        //part1
        int[] counter=new int[10];
        int a=0,b=0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i))
                a++;
            else{
                b++;
                counter[secret.charAt(i)-'0']++;
                counter[guess.charAt(i)-'0']--;
            }
        }

        //part2
        for(int i=0;i<10;i++){
            if(counter[i]<0)
                b+=counter[i];
        }
        return a+"A"+b+"B";
    }

    public static void main (String[] args)
    {
        BullAndCow b = new BullAndCow();
        System.out.println(b.getHint1("3436", "6533"));
    }
}
