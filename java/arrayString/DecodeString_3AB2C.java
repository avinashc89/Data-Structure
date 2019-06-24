package com.tool.java.arrayString;

import java.util.*;

public class DecodeString_3AB2C
{
    /*  "3[a]2[bc]", return "aaabcbc".
     iterate from back, and 
     if we see [, 
          travel to left and find the repeatCount
          pop from stack until ] -> substring
          push the substring in stack for repeatCount times
      if not put inside stack  
                
    */
    public String decodeString(String s) {
        if (s == null) return null;
               
        Deque<String> stack = new ArrayDeque<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            String cur = String.valueOf(s.charAt(i));
            
            if (cur.equals("[")) {
                int repeat = 0;
                int count = 0;
                while (i - 1 >= 0 && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9') {
                    repeat += (s.charAt(i - 1) - '0') * Math.pow(10, count);
                    i--;
                    count++;
                }
                
                StringBuilder sb = new StringBuilder();
                
                // get the substring between "[" and "]"
                while (!stack.isEmpty()) {
                    String pre = stack.pop();
                    if (pre.equals("]")) 
                        break;
                    sb.append(pre);
                }
                String subStr = sb.toString();
                
                // repeat the substring above and push it back to stack
                sb = new StringBuilder();
                for (int j = 0; j < repeat; j++) {
                    sb.append(subStr);
                }
                stack.push(sb.toString());
            } else {
                stack.push(cur);
            }
        }
        
        // calculate the final result
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

}
