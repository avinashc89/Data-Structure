package com.tool.java.leetcode;

import java.util.*;
import java.util.Iterator;

class WordAndCount {
    public WordAndCount (String word2, int i)
    {
        word = word2;
        count = i;
    }
    public String word;
    public int count;
}

// use a queue to store word&count pair. use wordIterator.getNext to get the word from words. 
// if queue is empty, add the word with count 1.
// if not, check the peekfirst word. if same increment the count, else make new entry with count as 1.

public class GoogleWordCountIterator implements Iterator<WordAndCount> {

    Deque<WordAndCount> wordCountQueue;
    
    public GoogleWordCountIterator(Iterator<String> words) 
    {  
        wordCountQueue = new LinkedList<>();
        
        while(words.hasNext()){
            
            String word = words.next();
            
            //to insert first item
            if(wordCountQueue.isEmpty())
            {
                wordCountQueue.offer(new WordAndCount(word, 1));
            }
            else
            {
                //check if the previous has same word. if yes increment the counter, else add the word with count 1
                String lastWord = wordCountQueue.peekLast().word;
                if(lastWord.equals(word))
                {
                    wordCountQueue.peekLast().count++;
                } 
                else
                {
                    wordCountQueue.offer(new WordAndCount(word, 1));
                }
            }
            
        }
    }

    @Override
    public WordAndCount next() {
        return wordCountQueue.poll();
    }

    @Override
    public boolean hasNext() {
        return  !wordCountQueue.isEmpty();
    }
}