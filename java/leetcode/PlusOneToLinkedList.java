package com.tool.java.leetcode;

public class PlusOneToLinkedList
{

    public Node plusOne(Node head)
    {
        if(reverse(head) == 0)     // no carry for next element
            return head;
        
        Node n = new Node(1);
        n.next = head;
        head = n;
        return head;
    }
    
    
    private int reverse(Node root)
    {
        if(root ==null) return 1;
        int carry = reverse(root.next);
        
//        if(carry ==0)                       // we can stop here since no need to travel further
//            return 0;
        int newvalue = (root.data + carry);
        root.data = newvalue%10;
         return newvalue/10;
    }
}
