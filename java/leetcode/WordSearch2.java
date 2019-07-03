package com.tool.java.leetcode;

import java.util.*;

public class WordSearch2  //using trie
{
    /*
   Input: 
    board = [
      ['o','a','a','n'],
      ['e','t','a','e'],
      ['i','h','k','r'],
      ['i','f','l','v']
    ]
    words = ["oath","pea","eat","rain"]
    
    Output: ["eat","oath"]
    
    Build a Trie { hashmap<Character, Trie>, string} for the words.
    
    now start from borad[0,0] and do dfs. if the char is found in root trie node and recurse dfs. 
    when we find the node.word ! =null,
            means we are able to reach to this word.
            add to result.
     */

    private TrieNode root;
    private static final int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    
    private static class TrieNode {
        private final HashMap<Character,TrieNode> map;
        private String word;
        
        private TrieNode() {
            map = new HashMap<Character,TrieNode>();
            word = null;
        }
    } 
    
    private void buildTrie(String[] words) {
        
        for (String word : words) {
            TrieNode curr = root;
            int len = word.length();
            
            for (int i = 0; i < len; ++i) 
            {
                char c = word.charAt(i);
                
                if (!curr.map.containsKey(c)) 
                {
                    curr.map.put(c, new TrieNode());
                }
                curr = curr.map.get(c);
            }
            curr.word = word; // assign the word to last trienode
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> rst = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) return rst;
        if (words == null || words.length == 0) return rst;
        
        //part1:
        root = new TrieNode();
        buildTrie(words);
        
        
        //part2:
        for (int r = 0; r < board.length; ++r) {
            for (int c = 0; c < board[0].length; ++c) 
            {
                search(r, c, root.map.get(board[r][c]), board, rst);
            }
        }
        
        return rst;
    }
    
    private void search(int i, int j, TrieNode root, char[][] board, List<String> tmp) 
    {
        if (root == null) 
            return;
        
        if (root.word != null) {
            tmp.add(root.word);
            root.word = null; // we don't want to add this word again 
        }
        
        // mark current grid as visited. Same it before hand , so that it can be placed again.
        char temp = board[i][j];
        board[i][j] = '1';
        
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (!isValid(x, y, board) || !root.map.containsKey(board[x][y])) 
                continue;
            
            search(x, y, root.map.get(board[x][y]), board, tmp);
        }
        
        board[i][j] = temp;
    }
    
    private boolean isValid(int r, int c, char[][] board) {
        return r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] != '1';
    }
    
}
