package com.tool.java.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;
import com.tool.java.Tree.Node;

public class ConnectSameLevelBT
{
    
    /************1. connect to next node in same level- recursion( next points to null if node is not available)******************/
    
    public static  void connect_Same_Level_Elements_Using_Reursion(Node root){
        root.next = null;
        recConnect(root);
    }
    private static void recConnect(Node n)
    {
        if(n == null) return;
        if(n.left !=null) 
            n.left.next = n.right;
        if(n.right != null) 
            n.right.next = (n.next !=null )?n.next.left : null;
        
        recConnect(n.right);
        recConnect(n.left);
        
        
    }
    
    /************** 2. connect to next node in same level - queue - level order traversal*****************/
    
    // using level order traversal
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
                if(n.left!=null)
                    q.add(n.left);
                if(n.right!=null)
                    q.add(n.right);
                
                n.next = q.peek();
            }
            
            q.remove();
            if(!q.isEmpty())
                q.add(null);
        }
    }

    /*******************************  3. connect to next node in same level - recursion **********************************/
    
    public static void connectRecur(Node p)  
    { 
        // Base case 
        if (p == null) 
            return; 
   
        if (p.next != null) 
            connectRecur(p.next); 
   
        if (p.left != null) 
        { 
            if (p.right != null)  
            { 
                p.left.next = p.right; 
                p.right.next = getNextRight(p); 
            }  
            else
                p.left.next = getNextRight(p); 
   
            connectRecur(p.left); 
        } 
           
        else if (p.right != null)  
        { 
            p.right.next = getNextRight(p); 
            connectRecur(p.right); 
        }  
        else
            connectRecur(getNextRight(p)); 
    } 
   
    /* This function returns the leftmost child of nodes at the same 
       level as p. This function is used to getNExt right of p's right child 
       If right child of p is NULL then this can also be used for  
       the left child */
    static Node getNextRight(Node p)  
    { 
        Node temp = p.next; 
   
        /* Traverse nodes at p's level and find and return 
         the first node's first child */
        while (temp != null)  
        { 
            if (temp.left != null) 
                return temp.left; 
            if (temp.right != null) 
                return temp.right; 
            temp = temp.next; 
        } 
   
        // If all the nodes at p's level are leaf nodes then return NULL 
        return null; 
    } 
    
    /*****************************************************************/
    
    public static void main (String[] args)
    {
        Node root = Node.getSampleTree();
        connect_Same_Level_Elements_Using_Queue(root);
        Node.printBST(root);
        
        System.out.println("----");
        Node root1 = Node.getSampleTree();
        connectRecur(root1);
        Node.printBST(root1);
    }

}
