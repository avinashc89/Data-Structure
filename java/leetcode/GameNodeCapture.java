package com.tool.java.leetcode;


import java.util.*;
import com.tool.java.Tree.Node;
public class GameNodeCapture
{
    
    
    public static boolean win(Node root, Node n) { //N is the first move by opponent
        int sizeParent = countNodes(n.parent, n); //size of parent component
        int sizeLeft = countNodes(n.left, n);   //size of left subtree component
        int sizeRight = countNodes(n.right, n); //size of right subtree component

        int myScore = Math.max(Math.max(sizeParent, sizeLeft), sizeRight); //I take the biggest component
        int treeSize = 1 + sizeParent + sizeLeft + sizeRight;
        int opponentScore = treeSize - myScore; //opponent takes remaining nodes
        System.out.print("my best score is " + myScore + "/" + treeSize + ". ");
        if(myScore > opponentScore) {
            Node bestmove = myScore == sizeParent ? n.parent: myScore == sizeLeft ? n.left : n.right;
            System.out.println("my first move on " + bestmove.data);
        }
        return myScore > opponentScore;
    }

    private static int countNodes(Node node, Node ignore) {
        if(node == null) return 0;
        int count = 1;
        if(node.parent != ignore) {
            count += countNodes(node.parent, node);
        }
        if(node.left != ignore) {
            count += countNodes(node.left, node);
        }
        if(node.right != ignore) {
            count += countNodes(node.right, node);
        }
        return count;
    }

   
   public static Node postOrderFirst(Node root)
   {
       if(root == null) return null;
       Node curr = root;
       while(curr.left!=null)
       {
           curr = curr.left;
       }
       if(curr.right==null)
       {   
           return curr;
       }
       else
       {
           return postOrderFirst(curr.right);
       }
   }
   
   static Node postOrderSuccessor(Node n)
   {
       if(n == null) return null;
       Node parent = n.parent;
       if(parent!=null)
       {
           if(parent.right == n || parent.right ==null)
           {   
               return parent;
           }
           else if(parent.right!=null)
           {
               return postOrderFirst(parent.right);
           }
       }

       return null;    
   }
   
   
   
   /** Split BST
 * @param root
 * @param V
 * @return
 */
public Node[] splitBST(Node root, int V) {
       Node[] res = new Node[2];
       if (root == null) return res;
       if (root.data <= V) {
           res[0] = root;
           Node[] rightRes = splitBST(root.right, V);
           root.right = rightRes[0];
           res[1] = rightRes[1];
       } else {
           res[1] = root;
           Node[] leftRes = splitBST(root.left, V);
           root.left = leftRes[1];
           res[0] = leftRes[0];
       }
       return res;
   }

    
}
