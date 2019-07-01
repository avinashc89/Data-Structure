package com.tool.java.leetcode;

import java.util.*;
import java.util.Random;

public class RandomNodeLinkedList
{
    Node l;
    Random rand;

    public RandomNodeLinkedList(Node head) {
        rand = new Random();
        l = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int res = -1, length = 0;
        Node curr = l;
        while(curr != null) {
            ++length;
            int x = rand.nextInt(length);
            if(x == 0) 
                res =curr.data;
            curr = curr.next;
        }
        return res;
    }

    public static void main (String[] args)
    {
        int a[] = {2,6,1,46,8,23,67,41,76,32,6,8,2,10,5,67};
        Node temp = new Node(8);
        Node head = temp;

        for(int i : a ) {
            temp.next = new Node(i);
            temp = temp.next;
        }
        RandomNodeLinkedList r = new RandomNodeLinkedList(head);
        System.out.println(r.getRandom());
    }

    
    private List<Integer> list = new ArrayList<Integer>();
    public RandomNodeLinkedList(Node head,int x) 
    { 
        for( ; head!=null; head=head.next ) 
            list.add( head.data );
    }
    public int getRandom1()
    { 
        return list.get( new Random().nextInt( list.size() ) ); 
    }
    
    

}







