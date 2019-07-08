package com.tool.java.leetcode;

import java.util.*;
import com.tool.java.Util;

public class BracesExpansion
{
    public String[] expand(String S) {
        if (S == null || S.length() == 0) {
            return new String[0];
        }
        Deque<String[]> deque = convert(S);
        for(String[] s : deque)
        {
            Util.printArray(s);
        }
        while (deque.size() != 1) {
            String[] a = deque.pollFirst();
            String[] b = deque.pollFirst();
            String[] s = new String[a.length * b.length];
            int i = 0;
            for (String s1 : a) {
                for (String s2 : b) {
                    s[i++] = s1 + s2;
                }
            }
            deque.offerFirst(s);
        }
        String[] res = deque.pollFirst();
        Arrays.sort(res);
        return res;
    }
    
    private Deque<String[]> convert(String S) {
        char[] s = S.toCharArray();
        Deque<String[]> deque = new LinkedList<>();
        int i = 0, n = s.length;
        while (i < n) {
            StringBuilder sb = new StringBuilder();
            if (s[i] == '{') {
                // skip '{'
                i++;
                while (i < n && s[i] != '}') {
                    sb.append(s[i]);
                    i++;
                }
                // skip '}'
                i++;
            } else {
                while (i < n && s[i] != '{') {
                    sb.append(s[i]);
                    i++;
                }
            }
            deque.offerLast(sb.toString().split(","));
        }
        return deque;
    }
    public static void main (String[] args)
    {
        BracesExpansion b = new BracesExpansion();
        b.expand("{a,b}c{d,e}f");
    }
}
