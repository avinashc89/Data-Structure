package com.tool.java.leetcode;

public class LongestWordInDictionary
{

    /*
        Input:  words = ["w","wo","wor","worl", "world"]
        Output: "world"
        Explanation:  The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

        Input:  words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
        Output: "apple"
        Explanation:  Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".

     Using trie

     1. Add all the words of dictionary into  trie.
     
     2. find the longest word in the trie.
         from root get the children node. 
             if that node is null || node.word is null no use. continue with iteration
             if not, get the curr.word.
                 again find the longest by reading the children (recursive call)
                 say we got result from above line s.
                 if s len is greater than curr.word len.
                     then return back s
                     if not return back curr.word.
     */

    private static final int R = 26;
    private TrieNode root;

    private static class TrieNode {
        private final TrieNode[] children;
        private String word;

        private TrieNode() {
            children = new TrieNode[R];
            word = null;
        }
    }
    
    private void insertWord(String word) {
        int len = word.length();
        TrieNode curr = root;
        char c;
        int idx;
        for (int i = 0; i < len; ++i) {
            c = word.charAt(i);
            idx = c - 'a';
            
            if (curr.children[idx] == null) 
            {
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
        }

        curr.word = word;
    }

    
    private String findLongestWord(TrieNode root)
    {
        
        String rst = "";
        if (root.word == null) 
            rst = "";
        else
            rst =  root.word;

        for (TrieNode child : root.children) 
        {
            if (child == null || child.word == null)
                continue;
            String s = findLongestWord(child);
            if (s.length() > rst.length())
                rst = s;
        }
        return rst;
    }


    public String longestWord(String[] words) {
        // initialize a new trie
        root = new TrieNode();

        // construct the trie based on input dictionary words
        for (String word : words) {
            insertWord(word);
        }

        // find the longest dictionary word in this trie according to given rules
        return findLongestWord(root);
    }
}
