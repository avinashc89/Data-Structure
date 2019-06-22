package com.tool.java.Tree.BST;

import com.tool.java.Tree.Node;

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
	
	/*****************************************************************************/
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

	/*****************************************************************************/
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

	/*****************************************************************************/
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

	/*****************************************************************************/
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

	/*****************************************************************************/
	/**
     * return if BST is valid
     * @param node
     * @return
     */
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
	
	
	/*****************************************************************************/
	/**
     * Print all nodes between k1 & k2
     * @param node
     * @return
     */
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
	
	/*****************************************************************************/
	/**
     * Print kth largest in BST
     * @param node
     * @return
     */
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
	
	/*****************************************************************************/
	/** Split BST - https://www.coursera.org/lecture/data-structures/split-and-merge-22BgE
	 * @param root
	 * @param V -> value used to split
	 * @return Node[root of left tree1, root of right tree] -> tree is split into left tree1 & right tree
	 */
	public Node[] splitBST(Node node, int V) {
	       Node[] res = new Node[2];
	       if (node == null) return res;
	       
	       // if node's data is less than V,  
	       //    then that node belongs to left tree. => res[0] = node and now find the split in right tree.
	       if (node.data <= V) {
	           res[0] = node;
	           Node[] rightRes = splitBST(node.right, V);  //=> this gives rightRes[0] is less than k and  rightRes[1] is greater than k. add rightRes[0] to res[0]. 
	           node.right = rightRes[0];
	           res[1] = rightRes[1];
	       } 
	       //similarly in split is in left tree. res[1] = node and leftRes[1] also in res[1]
	       else {
	           res[1] = node;
	           Node[] leftRes = splitBST(node.left, V);
	           node.left = leftRes[1];
	           res[0] = leftRes[0];
	       }
	       return res;
	   }

}
