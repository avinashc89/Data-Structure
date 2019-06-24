package com.tool.java.leetcode;

import java.util.Stack;
import com.tool.java.Tree.Node;

public class TraversalSpiralBT
{
    /*
     1. using recursion and height(to know what level recursion should occur)
     */
    public static void spiral_Tree_Recursion(Node root)
    {
        if(root ==null) return;
        //  int h = height(root);
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


    /*
    2. using two stacks
     */
    public void spiralTraversal(Node root)
    {
        if (root == null)
        {
            return;
        }
        Stack<Node> stackEven = new Stack();
        Stack<Node> stackOdd = new Stack(); 
        stackEven.push(root);

        while (!stackEven.isEmpty() || !stackOdd.isEmpty())
        {
            // visit nodes at even level and push their children in odd level stack
            while (!stackEven.isEmpty())
            {
                Node currentNode = stackEven.pop();
                System.out.print(" " + currentNode.data);

                if (currentNode.right != null)
                    stackOdd.push(currentNode.right);
                if (currentNode.left != null)
                    stackOdd.push(currentNode.left);
            }
            // visit nodes at odd level and push their children in even level stack
            while (!stackOdd.isEmpty())
            {
                Node currentNode = stackOdd.pop();
                System.out.print(" " + currentNode.data);
               
                if (currentNode.left != null)
                    stackEven.push(currentNode.left);
                if (currentNode.right != null)
                    stackEven.push(currentNode.right);
            }
            System.out.println();
        }
    }

}
