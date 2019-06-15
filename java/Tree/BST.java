package com.tool.java.Tree;

public class BST {


	Node root;

	public BST()
	{
		this.root=null;
	}

	public static void main(String[] args) {

		BST obj = new BST();

		obj.insert(17);
		obj.insert(6);
		obj.insert(21);
		obj.insert(13);
		obj.insert(20);


		obj.printBST(obj.getRoot());

		System.out.println(obj.maxHeight(obj.getRoot()));
		System.out.println(obj.size(obj.getRoot()));
		System.out.println(isValidBST(obj.getRoot()));

	}
	
	
	/**
	 * insert key in tree
	 * @param key
	 */
	public void insert(int key)
	{
		Node n1 = new Node(key);
		if(root == null){
			root = n1;
		}
		else
		{
			Node parentNode = root;
			Node currNode = root;
			while(currNode!=null)
			{
				parentNode = currNode;
				if(currNode.getData() < key)
					currNode = currNode.getRight();
				else
					currNode = currNode.getLeft();
			}		
			if(key > parentNode.getData())
				parentNode.setRight(n1);
			else
				parentNode.setLeft(n1);
		}
	}

	/**
	 * prints tree for the given node n
	 * @param n
	 */
	public void printBST(Node n)
	{
		if(n!=null){
			System.out.println(n.getLeft()+"---"+n.getData()+"---"+n.getRight());
			printBST(n.getLeft());
			printBST(n.getRight());
		}
	}

	/**
	 * return the maximum height from the 
	 * @param node
	 * @return
	 */
	public int maxHeight(Node node) { 
		if (node==null) { 
			return 0; 
		} 
		else { 		    
			int lHeight = maxHeight(node.getLeft()); 
			int rHeight = maxHeight(node.getRight());

			if (lHeight > rHeight) 
				return lHeight+1; 
			else 
				return rHeight+1; 
		} 
	} 

	/**
	 * return the total number of nodes in the tree
	 * @param node
	 * @return
	 */
	public int size(Node node)
	{
		if(node ==null)
			return 0;
		else
		{
			int lSize = size(node.getLeft());
			int rSize = size(node.getRight());
			return lSize+rSize+1;		
		}
	}

	public static boolean isValidBST(Node root) {
		return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private static boolean validate(Node root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.getData() <= min || root.getData() >= max) {
			return false;
		}
		// left subtree must be < root.val && right subtree must be > root.val
		return validate(root.getLeft(), min, root.getData()) && validate(root.getRight(), root.getData(), max);
	}
	
	
	public void printAllElementbetTwoInt(Node root, int k1,int k2)
	{
		if(root==null) return;
		if(root.data  > k1 )
			printAllElementbetTwoInt (root.left, k1,k2);
		if(root.data  >= k1 && root.data  <= k2 )
			System.out.println(root.getData());
		if(root.data  < k2 )
			printAllElementbetTwoInt (root.right, k1,k2);
	}
	
	public void printKthLargestElement(Node root,int k)
	{
		if(k<0) return;
		if(root ==null) return;
		printKthLargestElement(root.right , k);
		k--;
		if(k==0)
			System.out.println(root.data);
		
		printKthLargestElement(root.left ,k);
	}
	
	

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

}
