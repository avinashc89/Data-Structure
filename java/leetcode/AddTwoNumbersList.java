package com.tool.java.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class AddTwoNumbersList
{
    
   // 7->2->3->4   +  5->6->4  = 7->8->0->7
    //using 2 stack. Put everything in stack. pop from both => add them. calc carry. 
    
    public Node addTwoNumbers(Node l1, Node l2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        
        while (l1 != null) {
            s1.push(l1.data);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.data);
            l2 = l2.next;
        }
        int carry = 0;
        Node list = new Node(0); // this is last node in res.
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) carry += s1.pop();
            if (!s2.isEmpty()) carry += s2.pop();
            
            list.data =  carry % 10;
            Node head = new Node(carry / 10);
            head.next = list;
            list = head;
            carry /= 10; 
        }
        return list.data == 0 ? list.next : list;
    }
    
    
    // reverse each list and add
    public Node addTwoNumbers1(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node p = dummy;
        int carry = 0;
        l1 = reverse(l1);
        l2 = reverse(l2);
        while(l1!=null || l2!=null || carry!=0){
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
        return reverse(dummy.next);
    }
    public Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        while(curr!=null && curr.next!=null){
            prev = curr.next;
            curr.next = curr.next.next;
            prev.next = head;
            head = prev;
        }
        return head;
    }

}
