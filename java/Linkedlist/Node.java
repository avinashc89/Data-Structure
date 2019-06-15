package com.tool.java.Linkedlist;

public class Node
{
    int data;
    Node next;
    Node arbit;
    Node prev;
    
    Node (int data)
    {
        this.data = data;
        next = null;
        arbit = null;
        prev = null;
    }

    public int getData ()
    {
        return data;
    }

    public void setData (int data)
    {
        this.data = data;
    }

    public Node getNext ()
    {
        return next;
    }

    public void setNext (Node next)
    {
        this.next = next;
    }

    public Node getArbit ()
    {
        return arbit;
    }

    public void setArbit (Node arbit)
    {
        this.arbit = arbit;
    }

    public Node getPrev ()
    {
        return prev;
    }

    public void setPrev (Node prev)
    {
        this.prev = prev;
    }
    
    
    
}
