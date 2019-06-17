package com.tool.java.Linkedlist;

public class SegregateEvenOdd
{
    Node head; 
    
    //using two pointers for odd and even. if curr node is even, then append to even pointer, else append to odd pointer 
    
    public Node segregateEvenOdd() { 
        
        Node evenStart = null; 
        Node evenEnd = null; 
        Node oddStart = null; 
        Node oddEnd = null; 
        Node currentNode = head; 
          
        while(currentNode != null) { 
            int element = currentNode.data; 
              
            //if even, 
            if(element % 2 == 0) { 
                  
                if(evenStart == null) { 
                    evenStart = currentNode; 
                    evenEnd = evenStart; 
                } else { 
                    evenEnd.next = currentNode; 
                    evenEnd = evenEnd.next; 
                } 
                  
            } else { 
                  
                if(oddStart == null) { 
                    oddStart = currentNode; 
                    oddEnd = oddStart; 
                } else { 
                    oddEnd.next = currentNode; 
                    oddEnd = oddEnd.next; 
                } 
            } 
                        // Move head pointer one step in forward direction 
            currentNode = currentNode.next;     
        } 
          
          
        if(oddStart == null || evenStart == null) { 
          return oddStart==null?evenStart:oddStart;
        } 
          
        evenEnd.next = oddStart; 
        oddEnd.next = null; 
        head=evenStart; 
        
        return head;
    } 

}
