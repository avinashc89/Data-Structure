package com.tool.java.leetcode;

public class MergeSortList
{
    
    // Move fastptr by two and slow ptr by one. Finally slowptr will point to middle node 
    Node getMiddle(Node h) 
    { 
        if (h == null) 
            return h; 
        
        Node fastptr = h.next; 
        Node slowptr = h; 
        
        while (fastptr != null && fastptr.next!=null) { 
                slowptr = slowptr.next; 
                fastptr = fastptr.next.next; 
            } 
        
        //this is in middle now
        return slowptr; 
    } 
    
    //step 1
    Node mergeSort(Node h) 
    { 
        // Base case : if head is null 
        if (h == null || h.next == null) { 
            return h; 
        } 
  
        // get the middle of the list 
        Node middle = getMiddle(h); 
        Node nextofmiddle = middle.next; 
  
        // set the next of middle Node to null 
        middle.next = null; 
  
        // Apply mergeSort on left list 
        Node left = mergeSort(h); 
  
        // Apply mergeSort on right list 
        Node right = mergeSort(nextofmiddle); 
  
        // Merge the left and right lists 
        Node sortedlist = sortedMerge(left, right); 
        return sortedlist; 
    } 
    
    
    //step 2
    static Node sortedMerge(Node h1, Node h2) 
    { 
        if (h1 == null) 
            return h2; 
        if (h2 == null) 
            return h1; 
  
        // start with the linked list 
        // whose head data is the least 
        if (h1.data < h2.data) { 
            h1.next = sortedMerge(h1.next, h2); 
            return h1; 
        } 
        else { 
            h2.next = sortedMerge(h1, h2.next); 
            return h2; 
        } 
    } 
    
    

}
