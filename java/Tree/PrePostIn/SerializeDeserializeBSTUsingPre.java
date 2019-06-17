package com.tool.java.Tree.PrePostIn;

import java.util.ArrayList;
import com.tool.java.Tree.BinaryTree;
import com.tool.java.Tree.Node;

public class SerializeDeserializeBSTUsingPre
{
    
    public static void main (String[] args)
    {
       
        int[] currIndex = {0};
         
        int min  = Integer.MIN_VALUE;
        int max  = Integer.MAX_VALUE;
        
        
        ArrayList<Integer> preorder = new ArrayList<Integer>();
        
        serializeBST(Node.getSampleBST(),preorder);
        System.out.println(preorder);
        
        Integer arr[] = preorder.toArray(new Integer[preorder.size()]); 
        
        Node root = deserializeBST(arr, currIndex, min, max);
         
        System.out.println(BinaryTree.identicalTrees(Node.getSampleBST(),root));
 
    }
    
    private static void serializeBST(Node root, ArrayList<Integer> preorder)
    {
        if(root == null)
            return;
        
        preorder.add(root.data);
        serializeBST(root.left, preorder);
        serializeBST(root.right, preorder);
    }
    
    
    
    private static Node deserializeBST(Integer[] preorder, int[] currIndex, int min, int max)
    {
        if (currIndex[0] >= preorder.length) return null;
         
        Node root = null;
         
        if ((preorder[currIndex[0]] > min) && (preorder[currIndex[0]] < max))
        {
            root = new Node(preorder[currIndex[0]]);
            currIndex[0] += 1;
            root.left = deserializeBST(preorder, currIndex, min, root.data);
            root.right = deserializeBST(preorder, currIndex, root.data, max);
        }
         
        return root;
    }

}
