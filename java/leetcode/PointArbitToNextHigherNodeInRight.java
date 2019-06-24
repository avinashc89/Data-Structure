package com.tool.java.leetcode;

public class PointArbitToNextHigherNodeInRight
{
    
    static Node reverse(Node head)  
    {  
        Node prev = null, current = head, next = null;  
        while (current != null)  
        {  
            next = current.next;  
            current.next = prev;  
            prev = current;  
            current = next;  
        }  
        return prev;  
    }  
    
    static Node populateArbit(Node head)  
    {  
        // Reverse given linked list  
        head = reverse(head);  
      
        // Initialize pointer to maximum value node  
        Node max = head;  
      
        Node temp = head.next;  
        while (temp != null)  
        {  
            // Connect max through arbit pointer  
            temp.arbit = max;  
      
            // Update max if required  
            if (max.data < temp.data)  
                max = temp;  
      
            temp = temp.next;  
        }  
      
        return reverse(head);  
    }  
    
    static Node maxNode; 
    static void populateArbitRecursive(Node node) 
    { 
  
        if (node == null) 
            return; 
  
        //this is last node. so keep that as maxNode
        if (node.next == null) 
        { 
            maxNode = node; 
            return; 
        } 
  
        /* Calling the populateArbit to the next node */
        populateArbit(node.next); 
  
        /* updating the arbit node of the current 
        node with the maximum value on the right side */
        node.arbit = maxNode; 
  
        /* update the currNode as maxNode if greater */
        if (node.data > maxNode.data) 
            maxNode = node; 
  
        return; 
    } 
    

}
