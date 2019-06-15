package com.tool.java.Tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
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

	
	public static  int total_node_count(Node root)
	{
	    if (root == null)
	        return (0);
	    return (1 + total_node_count(root.left) + total_node_count(root.right));
	}
	/************************************************************************************************/
	
	public static   void spiral_Tree_Recursion(Node root)
	{
		if(root ==null) return;
	//	int h = height(root);
		int h=5;
		boolean flag = false;
		
		for(int i=1 ; i<=h ; i++){
			spiral_Tree_Recursion(root ,  h,  flag);     //start again from root for each call-- 
			flag=!flag;
		}
	}
	 /*level is reduced by 1... 
	  * when initial value of level is 5 => it starts at root with 5 and decrements at each level with 1 
	  * and when it reaches the 5th level k becomes 0*/
	private static void spiral_Tree_Recursion(Node node, int level, boolean flag) {
		
		if(node == null) return;
		if(level ==1 ) System.out.println(node.data);
		else{
			if(flag)
			{
				spiral_Tree_Recursion(node.left ,  level-1,  flag);			
				spiral_Tree_Recursion(node.right ,  level-1,  flag);
			}
			else
			{
				spiral_Tree_Recursion(node.right ,  level-1,  flag);
				spiral_Tree_Recursion(node.left ,  level-1,  flag);
			}
		}
	}
	
	/************************************************************************************************/
	
	public static  boolean check_if_sum_of_child_is_parent(Node root)
	{
		int left_data = 0,  right_data = 0;

		if(root == null || (root.left == null && root.right == null))
			return true;
		else{
			if(root.left != null)
				left_data = root.left.data;

			if(root.right != null)
				right_data = root.right.data;

			if((root.data == left_data + right_data)&&
					check_if_sum_of_child_is_parent(root.left) &&
					check_if_sum_of_child_is_parent(root.right))
				return true;
			else
				return false;
		}
	}

	/************************************************************************************************/
	
	public static  void connect_Same_Level_Elements_Using_Reursion(Node root){
		root.left = null;
		recConnect(root);
	}
	private static void recConnect(Node n)
	{
		if(n == null) return;
		if(n.left !=null) n.left.next = n.right;
		if(n.right != null) n.right.next = (n.next !=null )?n.next.left : null;
	}
	
	/************************************************************************************************/
	
	public static  void connect_Same_Level_Elements_Using_Queue(Node root)
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty())
		{
			while(q.peek()!=null)
			{
				Node n = q.peek();
				q.remove();
				if(n.left!=null)q.add(n.left);
				if(n.right!=null)q.add(n.right);
				
				n.next = q.peek();
			}
			
			q.remove();
			if(!q.isEmpty())
				q.add(null);
		}
	}

	/************************************************************************************************/
	//printAllPathWithSumN(root,sum,0,"")
	public static  void print_All_Path_With_Sum_N(Node root, int sum,int currSum , StringBuilder result)
	{
		if(root ==null) return;
		currSum += root.data;
		result = result.append(root.data).append("-");
		if(currSum == sum)
		{
			System.out.println(result.toString());
		}
		else if(currSum < sum)
		{
			print_All_Path_With_Sum_N(root.left, sum , currSum, result);
			print_All_Path_With_Sum_N(root.right, sum , currSum, result);
		}
		print_All_Path_With_Sum_N(root.left, sum , 0, new StringBuilder(""));
		print_All_Path_With_Sum_N(root.right, sum , 0, new StringBuilder(""));
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
	
	public static boolean Path_Sum_From_Root_Exist(Node node, int sum)
	{
	  /* return true if we run out of tree and sum==0 */
	  if (node == null)
	  {
	     return (sum == 0);
	  }
	  else
	  {
	    boolean flag = false;  
	  
	    /* otherwise check both subtrees */
	    int subSum = sum - node.data;
	  
	    /* If we reach a leaf node and sum becomes 0 then return true*/
	    if ( subSum == 0 && node.left == null && node.right == null )
	      return true;
	  
	    if(node.left != null)
	    	flag = flag || Path_Sum_From_Root_Exist(node.left, subSum);
	    if(node.right != null)
	    	flag = flag || Path_Sum_From_Root_Exist(node.right, subSum);
	  
	    return flag;
	  }
	}
	
	/************************************************************************************************/
	
	public static  int Path_Max_Sum(Node root) {
		Integer max = new Integer(Integer.MIN_VALUE);
		calculateSum(root, max);
		return max;
	}
 
	public static  int calculateSum(Node root, Integer max) {
		if (root == null)
			return 0;
 
		int left = calculateSum(root.left, max);
		int right = calculateSum(root.right, max);
 
		int current = Math.max(root.data, Math.max(root.data + left, root.data + right));
 
		max = Math.max(max, Math.max(current, left + root.data + right));
 
		return current;
	}
	
	/************************************************************************************************/
	
	
	public static  void print_all_path_Sums_to_K(Node n, int sum, int currentSum, String buffer) {
	     if (n == null) {
	         return;
	     }
	     int newSum = currentSum + n.data;
	     String newBuffer = buffer + " " + n.data;
	     if (newSum == sum) {
	         System.out.println(newBuffer);
	     }
	     if(sum > newSum){
		     print_all_path_Sums_to_K(n.left, sum, newSum, newBuffer);
		     print_all_path_Sums_to_K(n.right, sum, newSum, newBuffer);
	     }
	     print_all_path_Sums_to_K(n.left, sum, 0, "");
	     print_all_path_Sums_to_K(n.right, sum, 0, "");
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
	
	
	//remove_nodes_on_root_to_leaf_path_less_than_K
	//removeShortPathNodesUtil(root, 1, k)
	public static Node remove_nodes_pathLen_less_than_K(Node root, int level, int k)
	{
	    //Base condition
	    if (root == null)
	        return null;
	 
	    // Traverse the tree in postorder fashion so that if a leaf
	    // node path length is shorter than k, then that node and
	    // all of its descendants till the node which are not
	    // on some other path are removed.
	    root.left = remove_nodes_pathLen_less_than_K(root.left, level + 1, k);
	    root.right = remove_nodes_pathLen_less_than_K(root.right, level + 1, k);
	 
	    // If root is a leaf node and it's level is less than k then
	    // remove this node.
	    // This goes up and check for the ancestor nodes also for the
	    // same condition till it finds a node which is a part of other
	    // path(s) too.
	    if (root.left == null && root.right == null && level < k)
	    {
	       root=null;
	    }
	 
	    // Return root;
	    return root;
	}
	
	/************************************************************************************************/
	
	
	//remove_nodes_on_root_to_leaf_path_less_than_K
	//removeShortPathNodesUtil(root,new int[1]{0} , 20)
	
	public static Node remove_nodes_pathSum_less_than_K(Node root, int[] currSum, int maxSum)
	{
	    //Base condition
	    if (root == null)
	        return null;
	    
	    // Initialize left and right sums as sum from root to
	    // this node (including this node)
	    int[] lsum = new int[1];
	    int[] rsum  = new int[1];
	   
	    lsum[0]= currSum[0] + (root.data);
	    rsum[0] = currSum[0] + (root.data);
	 
	 
	    // Recursively remove left and right subtrees
	    root.left = remove_nodes_pathSum_less_than_K(root.left, lsum ,maxSum);
	    root.right = remove_nodes_pathSum_less_than_K(root.right , rsum, maxSum);
	 
	    // Get the maximum of left and right sums
	    currSum[0] = Math.max(lsum[0], rsum[0]);
	    
	    if (currSum[0] < maxSum)
	    {
	        root = null;
	    }
	    return root;
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
	
	
	public void bottom_View_BT(Node root)
    {
        if (root == null)
            return;
 
        // Initialize a variable 'hd' with 0 for the root element.
        int hd = 0;
 
        // TreeMap which stores key value pair sorted on key value
        Map<Integer, Integer> map = new TreeMap<>();
 
         // Queue to store tree nodes in level order traversal
        Queue<Node> queue = new LinkedList<Node>();
 
        // Assign initialized horizontal distance value to root
        // node and add it to the queue.
        root.hd = hd;
        queue.add(root);
 
        // Loop until the queue is empty (standard level order loop)
        while (!queue.isEmpty())
        {
        	Node temp = queue.remove();
 
            // Extract the horizontal distance value from the
            // dequeued tree node.
            hd = temp.hd;
 
            // Put the dequeued tree node to TreeMap having key
            // as horizontal distance. Every time we find a node
            // having same horizontal distance we need to replace
            // the data in the map.
            map.put(hd, temp.data);
 
            // If the dequeued node has a left child add it to the
            // queue with a horizontal distance hd-1.
            if (temp.left != null)
            {
                temp.left.hd = hd-1;
                queue.add(temp.left);
            }
            // If the dequeued node has a left child add it to the
            // queue with a horizontal distance hd+1.
            if (temp.right != null)
            {
                temp.right.hd = hd+1;
                queue.add(temp.right);
            }
        }
 
        // Extract the entries of map into a set to traverse
        // an iterator over that.
        Set<Entry<Integer, Integer>> set = map.entrySet();
 
        // Make an iterator
        Iterator<Entry<Integer, Integer>> iterator = set.iterator();
 
        // Traverse the map elements using the iterator.
        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> me = iterator.next();
            System.out.print(me.getValue()+" ");
        }
    }
	
	
	static boolean identicalTrees(Node a, Node b)  
    { 
        if (a == null && b == null) 
            return true; 
              
        if (a != null && b != null)  
            return (a.data == b.data 
                    && identicalTrees(a.left, b.left) 
                    && identicalTrees(a.right, b.right)); 
   
        return false; 
    } 
   
}
