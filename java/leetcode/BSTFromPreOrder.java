package com.tool.java.leetcode;


import java.util.*;
import com.tool.java.Tree.Node; 

/*
 1. Create an empty stack.

2. Make the first value as root. Push it to the stack.

3. Keep on popping while the stack is not empty and the next value is greater than stack’s top value. Make this value as the right child of the last popped node. Push the new node to the stack.

4. If the next value is less than the stack’s top value, make this value as the left child of the stack’s top node. Push the new node to the stack.

5. Repeat steps 2 and 3 until there are items remaining in pre[].

 *   
 */
class BSTFromPreOrder { 
  
    // The main function that constructs BST from pre[] 
    Node constructTree(int pre[], int size) { 
  
        // The first element of pre[] is always root 
        Node root = new Node(pre[0]); 
        
        Stack<Node> s = new Stack<Node>(); 
        s.push(root); 
  
        for (int i = 1; i < size; ++i) { 
            Node temp = null; 
  
            /* Keep on popping while the next value is greater than 
             stack's top value. */
            while (!s.isEmpty() && pre[i] > s.peek().data) { 
                temp = s.pop(); 
            } 
  
            // if greater value is found set it to right of last popped node
            if (temp != null) { 
                temp.right = new Node(pre[i]); 
                s.push(temp.right); 
            }  
              
           //else set it to left node of stack's top node.
            else { 
                temp = s.peek(); 
                temp.left = new Node(pre[i]); 
                s.push(temp.left); 
            } 
        } 
  
        return root; 
    } 
  
    // A utility function to print inorder traversal of a Binary Tree 
    void printInorder(Node node) { 
        if (node == null) { 
            return; 
        } 
        printInorder(node.left); 
        System.out.print(node.data + " "); 
        printInorder(node.right); 
    } 
  
    // Driver program to test above functions 
    public static void main(String[] args) { 
        BSTFromPreOrder tree = new BSTFromPreOrder(); 
        int pre[] = new int[]{10, 5, 1, 7, 40, 50}; 
        int size = pre.length; 
        Node root = tree.constructTree(pre, size); 
        System.out.println("Inorder traversal of the constructed tree is "); 
        tree.printInorder(root); 
    } 
} 