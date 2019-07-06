package com.tool.java.leetcode;

public class AddTwoNumbersList2
{
    // 2->4->3 + 5->6->4 = 7->0->8 
    // initally carry =0, add carry with l1 node(if not null). then again add carry with l2 node(if not null). 
    // p.next = new Node(carry%10);   carry = carry/10   p=p.next
    
    public Node addTwoNumbers(Node l1, Node l2) {
        
        Node dummy = new Node(0);
        Node p = dummy;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0)
        {
            if(l1!=null){
                carry += l1.data;
                l1 = l1.next;
            }
            if(l2!=null){
                carry += l2.data;
                l2 = l2.next;
            }
            p.next = new Node(carry%10);
            p = p.next;
            carry /= 10;
        }
        return dummy.next;
        
    }

}
