package com.tool.java.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import com.tool.java.Tree.Node;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class BinaryTree {

	

	/************************************************************************************************/
	
	public static int biggest(Node node)
	{
		if (node==null)
			return 0;
		else
			return Math.max(node.getData(),Math.max(biggest(node.getLeft()), biggest(node.getRight())));
	}

	/************************************************************************************************/
	public static  int total_node_count(Node root)
	{
	    if (root == null)
	        return (0);
	    return (1 + total_node_count(root.left) + total_node_count(root.right));
	}
	
	/************************************************************************************************/
	 public static int countOfLeafNode(Node root) 
	   {
	       if (root==null) return 0;
	       else 
	       {
	           if(root.left ==null && root.right ==null)
	               return 1;
	       }
	      return countOfLeafNode(root.left)+countOfLeafNode(root.right);
	   }
	
	/************************************************************************************************/
	
	
	public static  void print_all_leaf_node(Node root)
	{
		if(root != null)
		{
			print_all_leaf_node(root.left);
			print_all_leaf_node(root.right);
			
			if(root.left == null && root.right ==null)
				System.out.println(root.data);
		}
	}
	
	/************************************************************************************************/
	
	
	public static  int count_leaves_node(Node root)
	{
		if(root == null) return 0;
		
		if(root.left == null && root.right ==null)
			return 1;
		
		return count_leaves_node(root.left) + count_leaves_node(root.right);
	}
	
	
	/************************************************************************************************/
	
	public static  int[] diameter_of_BT(Node root)
	{
		int[] result=new int[]{0,0}; // [Diameter, Height]

		if(root == null) return result;

		int[] leftResult =  diameter_of_BT(root.left);
		int[] rightResult = diameter_of_BT(root.right);

		int rootDiameter = leftResult[1] + rightResult[1] + 1;
		int leftDiameter = leftResult[0];
		int rightDiameter = rightResult[0];
		result[0] = Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
		
		int height = Math.max(leftResult[1], rightResult[1]) + 1;
		result[1] = height;

		return result;

	}


	/************************************************************************************************/
	
	//isCompleteBT(root, 0 , total_node_count(root))
	public static boolean isCompleteBT (Node root, int index, int number_nodes)
	{
		// An empty tree is complete
		if (root == null)
		   return (true);
		
		// If index assigned to current node is more than
		// number of nodes in tree, then tree is not complete
		if (index >= number_nodes)
		   return (false);
		
		// Recur for left and right subtrees
		return (isCompleteBT(root.left, 2*index + 1, number_nodes) &&
				isCompleteBT(root.right, 2*index + 2, number_nodes));
	}
	
/************************************************************************************************/

    
    public static boolean identicalTrees(Node a, Node b)  
    { 
        if (a == null && b == null) 
            return true; 
              
        if (a != null && b != null)  
            return (a.data == b.data 
                    && identicalTrees(a.left, b.left) 
                    && identicalTrees(a.right, b.right)); 
   
        return false; 
    } 
    
      /************************************************************************************************/

    
    public boolean isSymmetric(Node root1, Node root2)
       {
           if (root1 == null && root2 == null)
           {
               return true;
           }
           else if (root1 == null || root2 == null)
           {
               return false;
           }
            
           if (root1.data == root2.data)
           {
               return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
           }
           
           return false;
       }
   
	
	/************************************************************************************************/
	
	
	public static int minDepth(Node root)
	{
	    // Base cases
	    if (root == null)
	        return Integer.MAX_VALUE;
	    if (root.left == null && root.right == null)
	        return 0;
	 
	    // Return minimum of left and right, plus one
	    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}
	
	
	
    /************************************************************************************************/
	
	public int checkBalanceBT(Node currentNode)
    {
        if (currentNode == null) 
        {
            return 0;
        }
         
        // check if left sub-tree is balanced
        int leftSubtreeHeight = checkBalanceBT(currentNode.left);
        if (leftSubtreeHeight == -1) 
            return -1;
         
        // check if right sub-tree is balanced
        int rightSubtreeHeight = checkBalanceBT(currentNode.right);
        if (rightSubtreeHeight == -1) return -1;
         
        // if both sub-trees are balanced, check the difference of heights
        // should be less than or equal to 1 
        if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1)
        {
            return -1;
        }
 
        // if tree rooted at this node is balanced, return height if tree rooted at this this node
        return (Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1);
    }
     
	/************************************************************************************************/
	
	  public  static void printGivenLevel (Node root ,int level) 
	    { 
	        if (root == null || level < 0) 
	            return; 
	        if (level == 0) 
	            System.out.print(root.data + " "); 
	        else 
	        { 
	            printGivenLevel(root.left, level-1); 
	            printGivenLevel(root.right, level-1); 
	        } 
	    } 
	  
    /************************************************************************************************/  
	  
	public void convertBTtoBST (Node root)
	{
	    if(root == null) 
	        return; 
	    
	    ArrayList<Integer> inorderList = new ArrayList<Integer>();
	    
	    storeInorder (root, inorderList); 
	    Collections.sort(inorderList);
	    arrayToBST(inorderList, root, 0);
	}
	
	 public static void storeInorder(Node root, ArrayList<Integer> preorder)
	    {
	        if(root == null)
	            return;
	        storeInorder(root.left, preorder);
	        preorder.add(root.data);
	        storeInorder(root.right, preorder);
	    }
	   
	 public void arrayToBST (ArrayList<Integer> arr, Node root, int index) 
	 { 
	     if (root == null) 
	       return; 
	   
	     /* first update the left subtree */
	     arrayToBST (arr, root.left, index); 
	   
	     /* Now update root's data and increment index */
	     root.data = arr.get(index); 
	     index++; 
	   
	     arrayToBST (arr, root.right, index); 
	 } 
	   
	 /************************************************************************************************/
	
	 //returns the level with maximum nodes. Using level order traversal.
	 static int maxNodeLevel(Node root) 
	    { 
	        if (root == null) 
	            return -1; 

	        Queue<Node> q = new LinkedList<Node> (); 
	        q.add(root); 

	        // Current level 
	        int level = 0; 
	        // Maximum Nodes at same level 
	        int max = 1; 
	        // Level having maximum Nodes 
	        int level_no = 0; 

	        while (q.size()>0) 
	        { 
	            if (q.size() > max) 
	            { 
	                max = q.size(); 
	                level_no = level; 
	            } 
	            int count = q.size();
	            //remove all the current level nodes in the queue
	            while (count > 0) 
	            { 
	                Node Node = q.peek(); 
	                q.remove(); 
	                if (Node.left != null) 
	                    q.add(Node.left); 
	                if (Node.right != null) 
	                    q.add(Node.right); 
	                count--;
	            } 
	            // Increment for next level 
	            level++; 
	        } 
	        return level_no; 
	    } 
	 
	   /************************************************************************************************/

	    
}
