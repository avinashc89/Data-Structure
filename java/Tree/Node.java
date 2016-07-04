package com.tool.java.Tree;

public class Node {
	
	public Node left;
	public Node right;
	public int key;
	public Node next;
	public int hd;
	
	public Node(int key)
	{
		this.key=key;
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
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	
	public String toString()
	{
		if(new Integer(key)!=null )
			return key+"";
		else
			return null;
		
	}

}
