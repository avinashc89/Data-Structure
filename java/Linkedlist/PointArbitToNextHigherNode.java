package com.tool.java.Linkedlist;

public class PointArbitToNextHigherNode
{

    //small modification in merge sort list -> set the arbit to next and sort the using arbit
    //step 1
    private Node populateArbit(Node start) 
    { 
        Node temp = start; 
  
        // Copy next pointers to arbit pointers 
        while (temp != null) 
        { 
            temp.arbit = temp.next; 
            temp = temp.next; 
        } 
        return mergeSort(start); 
    } 
    
    // Move fastptr by two and slow ptr by one. Finally slowptr will point to middle node 
    Node getMiddle(Node h) 
    { 
        if (h == null) 
            return h; 
        
        Node fastptr = h.arbit; 
        Node slowptr = h; 
        
        while (fastptr != null && fastptr.arbit!=null) { 
                slowptr = slowptr.arbit; 
                fastptr = fastptr.arbit.arbit; 
            } 
        
        //this is in middle now
        return slowptr; 
    } 
    
    //step 2
    Node mergeSort(Node h) 
    { 
        // Base case : if head is null 
        if (h == null || h.next == null) { 
            return h; 
        } 
  
        // get the middle of the list 
        Node middle = getMiddle(h); 
        Node nextofmiddle = middle.arbit; 
  
        // set the next of middle Node to null 
        middle.arbit = null; 
  
        // Apply mergeSort on left list 
        Node left = mergeSort(h); 
  
        // Apply mergeSort on right list 
        Node right = mergeSort(nextofmiddle); 
  
        // Merge the left and right lists 
        Node sortedlist = sortedMerge(left, right); 
        return sortedlist; 
    } 
    
    
    //step 3
    static Node sortedMerge(Node h1, Node h2) 
    { 
        if (h1 == null) 
            return h2; 
        if (h2 == null) 
            return h1; 
  
        // start with the linked list 
        // whose head data is the least 
        if (h1.data < h2.data) { 
            h1.arbit = sortedMerge(h1.arbit, h2); 
            return h1; 
        } 
        else { 
            h2.arbit = sortedMerge(h1, h2.arbit); 
            return h2; 
        } 
    } 
    
}
