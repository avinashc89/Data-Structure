package com.tool.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber1
{
    
    // should fetch same value when rotated 180'  689 = T , 101 = T, 690 = F, 181 = T, 161 = F
    
    /*
      6 > 9 ,, 9 > 6 ,, 8 >> 8 ,, 0 >> 0 ,, 1 >> 1
     
     Read each digit, change if found and append to new digit. if there is anyother number false
     689 => 986 =>  revrese(986) => 689 => 
    
    */
    
    public boolean isStrobogrammatic(String num) {
        if(num == null || num == ""){
           return true; 
        }
        
       char[] arr = num.toCharArray(); 
       StringBuilder sb = new StringBuilder();
        
       for(int i=0; i< arr.length; i++){
           if(arr[i] == '0' || arr[i] == '1' || arr[i] == '8'){
               sb.append(arr[i]);
           }else if(arr[i] == '6'){
               sb.append('9');
           }else if(arr[i] == '9'){
               sb.append('6');
           } else{
               return false;
           }
       } 
      return sb.reverse().toString().equals(num);
     } 
    
    
    //Using HashMap for comparison. read from both end. if i=6 get the value from map and compare with j. if they are not equal false.
    //Also if the digit is not in map, false
    
    public boolean isStrobogrammatic1(String num) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        int i = 0;
        int j = num.length() - 1;
        while(i <= j) {
            if(!map.containsKey(num.charAt(i)) || map.get(num.charAt(i)) != num.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    

}
