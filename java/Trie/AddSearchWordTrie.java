package com.tool.java.Trie;

public class AddSearchWordTrie
{
    class TrieNode{
        public TrieNode[] children=new TrieNode[26];
        public boolean isLeaf=false;
    }
    
    public TrieNode root;
    
    public AddSearchWordTrie() {
        root=new TrieNode();    
    }
    
    public void addWord(String word) 
    {
        TrieNode node=root;
        for(char c:word.toCharArray())
        {
            int x = c-'a';
            if(node.children[x]==null)
                node.children[x]=new TrieNode();
            node=node.children[x];
        }
        node.isLeaf=true;
    }
    
    //search can be "apple" or "..ple"
    public boolean search(String word) {
        return match(word.toCharArray(),0,root);
    }
    
    public boolean normalSearch(String word)
    {
        TrieNode node=root;
        for(char c:word.toCharArray())
        {
            int x = c-'a';
            if(node.children[x] ==null)
                return false;
            node = node.children[x] ;
        }
        return node.isLeaf;
    }
    
    //recursive search with extra modification
    private boolean match(char[] c,int i,TrieNode node){
        
        if(i==c.length)
            return node.isLeaf;
        
        if(c[i]!='.') 
        {
            return (node.children[c[i]-'a']!=null && match(c,i+1,node.children[c[i]-'a']));
        }
        else
        {
            // if . is found, then search in all children
            for(int k=0;k<node.children.length;k++)
            {
                if(node.children[k]!=null) {
                    if(match(c,i+1,node.children[k]))
                        return true;
                }
            }
        }
        return false;
    }

}
