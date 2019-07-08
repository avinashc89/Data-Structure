package com.tool.java.leetcode;

public class MagicDictionary
{
    private class TrieNode {
        TrieNode[] children;
        boolean isWord;
        
        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    private TrieNode root;
    
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    public void buildDict(String[] dict) {
        for (String w : dict) {
            insert(root, w.toCharArray());
        }
    }
    
    public void insert(TrieNode root, char[] c)
    {
        for(int i =0 ; i< c.length ; i++)
        {
            int x = c[i] - 'a';
            if(root.children[x]==null)
                root.children[x] = new TrieNode();
            root = root.children[x];
        }
        root.isWord = true;
    }
    
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        return search(root, word.toCharArray(), 0, false);
    }

    private boolean search (TrieNode root, char[] c, int i, boolean flag)
    {
       if( i == c.length)
           return flag && root.isWord;
       
       int x = c[i] - 'a';
       if(root.children[x]!=null && search(root.children[x], c, i+1, flag))
           return true;
       else
       {
           for (int k = 0; !flag && k < 26; k++) {
               if (k == x || root.children[k] == null) {        //we have already visited for k=x so skipping it.
                   continue;
               }
               if (search(root.children[k], c, i + 1, true)) {
                   return true;
               }
           }
           return false;
       }
        
    }
    

}
