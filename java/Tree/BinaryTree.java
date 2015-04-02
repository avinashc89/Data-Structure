package com.tool.java.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	

	/************************************************************************************************/
	
	public static int biggest(Node node)
	{
		if (node==null)
			return 0;
		else
			return Math.max(node.getKey(),Math.max(biggest(node.getLeft()), biggest(node.getRight())));
	}

	/************************************************************************************************/
	
	public  void spiral_Tree_Recursion(Node root)
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
	private void spiral_Tree_Recursion(Node node, int level, boolean flag) {
		
		if(node == null) return;
		if(level ==1 ) System.out.println(node.key);
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
	
	public boolean check_if_sum_of_child_is_parent(Node root)
	{
		int left_data = 0,  right_data = 0;

		if(root == null || (root.left == null && root.right == null))
			return true;
		else{
			if(root.left != null)
				left_data = root.left.key;

			if(root.right != null)
				right_data = root.right.key;

			if((root.key == left_data + right_data)&&
					check_if_sum_of_child_is_parent(root.left) &&
					check_if_sum_of_child_is_parent(root.right))
				return true;
			else
				return false;
		}
	}

	/************************************************************************************************/
	
	public void connect_Same_Level_Elements_Using_Reursion(Node root){
		root.left = null;
		recConnect(root);
	}
	private void recConnect(Node n)
	{
		if(n == null) return;
		if(n.left !=null) n.left.next = n.right;
		if(n.right != null) n.right.next = (n.next !=null )?n.next.left : null;
	}
	
	/************************************************************************************************/
	
	public void connect_Same_Level_Elements_Using_Queue(Node root)
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
	public void print_All_Path_With_Sum_N(Node root, int sum,int currSum , StringBuilder result)
	{
		if(root ==null) return;
		currSum += root.key;
		result = result.append(root.key).append("-");
		if(currSum == sum)
		{
			System.out.println(result.toString());
		}
		else if(currSum < sum)
		{
			
		}
	}
	
	/************************************************************************************************/
}
