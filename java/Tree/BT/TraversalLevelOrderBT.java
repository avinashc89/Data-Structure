package com.tool.java.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;
import com.tool.java.Tree.Node;

public class TraversalLevelOrderBT
{
    
    static void printLevelOrder(Node root) 
    { 
        if(root == null) 
            return; 
          
        Queue<Node> q =new LinkedList<Node>(); 
        q.add(root); 
          
        while(true) 
        { 
            int nodeCount = q.size(); 
            if(nodeCount == 0) 
                break; 
            // Dequeue all nodes of current level and Enqueue all 
            // nodes of next level 
            while(nodeCount > 0) 
            { 
                Node node = q.peek(); 
                System.out.print(node.data + " "); 
                q.remove(); 
                if(node.left != null) 
                    q.add(node.left); 
                if(node.right != null) 
                    q.add(node.right); 
                nodeCount--; 
            } 
            System.out.println(); 
        } 
    }
    
    //we can also use two queues for level order traversal. TraversalSpiralBT is modifies to insert in order-> left, right in both queues

}
