package com.tool.java.programcreek.array;

import java.util.HashSet;
import java.util.LinkedList;

public class A_04_WordLadder {

	public static void main(String[] args) {
		HashSet<String> D = new HashSet<String>();
	    D.add("poon");
	    D.add("plee");
	    D.add("same");
	    D.add("poie");
	    D.add("plie");
	    D.add("poin");
	    D.add("plea");
	    String start = "toon";
	    String target = "plea";
	    
	    System.out.println("Length of shortest chain is: "+shortestChainLen(start, target, D)); 
	}
	
	static boolean isadjacent(String a, String b)
	{
	    int count = 0;  // to store count of differences
	    for (int i = 0; i < a.length(); i++)
	    {
	        if (a.charAt(i) != b.charAt(i)) count++;
	        if (count > 1) return false;
	    }
	    return count == 1 ? true : false;
	}
	
	static int shortestChainLen(String start, String target, HashSet<String> dict)
	{
	    // Create a queue for BFS and insert 'start' as source vertex
		LinkedList<Word> q = new LinkedList<Word>();
	    Word item = new Word(start, 1);  // Chain length for start word is 1
	    q.add(item);
	 
	    // While queue is not empty
	    while (!q.isEmpty())
	    {
	        // Take the front word
	        Word curr = q.getFirst();
	        q.remove();
	 
	        // Go through all words of dictionary
	        for (String s : new HashSet<String>(dict))
	        {
	            if (isadjacent(curr.word, s))
	            {
	                // Add the dictionary word to Q
	                q.add(new Word(s,curr.len +1));
	                dict.remove(s);
	                // If we reached target
	                if (s == target)
	                  return curr.len+1;
	            }
	        }
	    }
	    return 0;
	}
}

class Word
{
    public Word(String word, int len) {
		this.word = word;
		this.len = len;
	}
	String word;
    int len;
}
