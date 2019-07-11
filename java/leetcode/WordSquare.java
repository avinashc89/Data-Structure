package com.tool.java.leetcode;

import java.util.*;

public class WordSquare
{
    
    class Node {
        List<String> list = new ArrayList<>();
        Node[] child = new Node[26];
    }

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> wordSquares(String[] words) {
        Node root = new Node();
        for (String word : words) {
            Node cur = root;
            for (Character ch : word.toCharArray()) {
                cur.list.add(word);
                if (cur.child[ch - 'a'] == null) {
                    cur.child[ch - 'a'] = new Node();
                }
                cur = cur.child[ch - 'a'];
            }
        }
        dfs(new ArrayList<>(), root, words[0].length());
        return res;
    }

    void dfs(List<String> item, Node root, int n) {
        // System.out.println("item: " + item);
        if (item.size() == n) {
            res.add(new ArrayList<>(item));
            return;
        }
        List<String> valid = findPre(root, item);
        // System.out.println("valid: " + valid);
        for (String s : valid) {
            item.add(s);
            dfs(item, root, n);
            item.remove(item.size() - 1);
        }
    }

    List<String> findPre(Node root, List<String> item) {
        Node cur = root;
        int size = item.size();
        for (String s : item) {
            int idx = s.charAt(size) - 'a';
            if (cur.child[idx] == null) {
                return new ArrayList<String>();
            }
            cur = cur.child[idx];
        }
        return cur.list;
    }

}
