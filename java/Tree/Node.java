package com.tool.java.Tree;


public class Node {
	
	public Node left;
	public Node right;
	public int data;
	public Node next;
	public Node parent;
	public int hd;
	
	public Node(int data)
	{
		this.data=data;
		this.left = null;
		this.right = null;
	}
	
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	public String toString()
	{
		if(new Integer(data)!=null )
			return data+"";
		else
			return null;
		
	}
	
	
	public static Node getSampleTree()
	{
	    Node root = new Node(2);              /*    2            */
        root.left    = new Node(1);          /*    / \           */
        root.right   = new Node(3);          /*    1   3         */
        root.left.left = new Node(4);        /*   / \   \       */
        root.left.right = new Node(6);       /*  4   6   8       */
        root.right.right = new Node(8);      /*     /            */
        root.left.right.left = new Node(5);  /*    5             */
        
        return root;
	}
	
	public static Node getSampleBST()
    {
        Node root = new Node(5);              /*    5            */
        root.left    = new Node(2);          /*    / \           */
        root.right   = new Node(6);          /*    2   6         */
        root.left.left = new Node(1);        /*   / \   \       */
        root.left.right = new Node(4);       /*  1   4   8       */
        root.right.right = new Node(8);      /*     /            */
        root.left.right.left = new Node(3);  /*    3             */
        
        return root;
    }
	
	public static void printBST(Node n)
    {
        if(n!=null){
            System.out.println(n.getLeft()+"---"+n.getData()+"---"+n.getRight()+"---"+n.next);
            printBST(n.getLeft());
            printBST(n.getRight());
        }
    }

}
