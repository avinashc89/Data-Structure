package com.tool.java.arrayString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextHigherNumberInPermutation
{
    
    /*
     1. Start scanning from the right.
    2. Find a digit D1 which is not in ascending order from right.
    3. If all the digits from right to left are ascending then print "None".
    4. Find a digit D2 which is right of D1, such that it is the smallest number greater than D1.
    5. Swap D1 and D2.
    6. Now sort the digits right of D1's original position.
     */
    
    public static void nextHigherNumber(Integer num) {
        Integer temp = num;
        ArrayList<Integer> digits = new ArrayList<Integer>();
        
        //put the numbers in arraylist
        while (temp > 0) {
            int digit = temp % 10;
            temp = temp / 10;
            digits.add(digit);
        }
 
        int j = 0;
        int i = j + 1;
 
        if (digits.size() > 1) {
 
          //Start scanning from the right. Find a digit D1 which is not in ascending order from right.
            while (i < digits.size()) {
                if (digits.get(i) < digits.get(j)) {
                    break;
                }
                j++;
                i++;
            }
 
            if (i >= digits.size()) {
                System.out.println("None");
                return;
            }
 
            //Find a digit D2 which is right of D1, such that it is the smallest number greater than D1.
            // where to swap
            
            j = 0;
 
            while (j < i) {
                if (digits.get(j) > digits.get(i))
                    break;
                j++;
            }
            // swap last and i
            int dg = digits.get(i);
            digits.set(i, digits.get(j));
            digits.set(j, dg);
        } else {
            System.out.println("None");
            return;
        }
  
        //Now sort the digits right of D1's original position.
        List<Integer> subList = digits.subList(0, i);
        Collections.sort(subList);
        int m = digits.size() - 1;
        while (m >= i) {
            System.out.print(digits.get(m));
            m--;
        }
 
        m = 0;
        while (m < subList.size()) {
            System.out.print(subList.get(m));
            m++;
        }
 
        System.out.println();
 
    }
    
    public static void main(String args[]) {
        nextHigherNumber(12543);
        nextHigherNumber(4132);
        nextHigherNumber(1234);
        nextHigherNumber(32841);
        nextHigherNumber(30102);
        nextHigherNumber(98765);
    }

}
