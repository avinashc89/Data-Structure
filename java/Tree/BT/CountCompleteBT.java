package com.tool.java.Tree.BT;

import com.tool.java.Tree.Node;

public class CountCompleteBT
{

    // if balanced, at level h, total nodes = (2^h -1) or (1<<h) -1
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        Node node = root.left;
        int height = 0;
        while (node != null) {
            node = node.left;
            height++;
        }
        
        //we got the height
        
        int level = 0;
        int depth = 0;
        int count = 0;
        
        while (root != null) {
            depth = level;
            node = root.left;
            if (node == null) {
                break;
            }
            while (node != null) {
                node = node.right;
                depth++;
            }
            level++;
            if (depth == height) {
                root = root.right;
                count += 1 << (height - level);
            }
            else {
                root = root.left;
            }
        }
        if (root != null && level == height) {
            count++;
        }
        return (int)(Math.pow(2,height) - 1 + count); 
    }
    
    public static void main (String[] args)
    {
            Node root = new Node(2);              /*    2            */
            root.left    = new Node(1);          /*    / \           */
            root.right   = new Node(3);          /*    1   3         */
            root.left.left = new Node(4);        /*   / \  / \       */
            root.left.right = new Node(6);       /*  4   67   8       */
            root.right.left = new Node(7);       /* / \               */
            root.right.right = new Node(8);    /*  5   10            */
            root.left.left.left = new Node(5); 
            root.left.left.left = new Node(10);
            
            System.out.println(countNodes(root));
    }

}
