package com.tool.java.arrayString;

public class SwapLRString
{
/*
     Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
    Output: True
    Explanation:
    We can transform start to end following these steps:
    RXXLRXRXL ->
    XRXLRXRXL ->
    XRLXRXRXL ->
    XRLXXRRXL ->
    XRLXXRRLX
    R - right facing person, L - left facing person.
    for any reason, R & L can cross each other
    Rule 1: if R is in ith position in start, it can only be in ith++++ positions in end
    Rule 2: if L is in ith poition in start, it can only be in ith --- position in end.
    Rule 3: if X is removed, both should have same string.
    
 */
    public boolean canTransform(String start, String end) {
        int length = start.length();
        int i = -1;
        int j = -1;
        
        while (++i < length && ++j < length) {
            while (i < length && start.charAt(i) == 'X') {i++;}
            while (j < length && end.charAt(j) == 'X') {j++;}
            if ((i < length) ^ (j < length)) {
                return false;
            }
            if (i < length && j < length && 
                (start.charAt(i) != end.charAt(j) ||
                 (start.charAt(i) == 'L' && i < j) ||
                 (start.charAt(i) == 'R' && i > j))) {
                return false;
            }
        }
        return true;
    }
}
