package com.tool.java.leetcode;

import java.util.ArrayList;
import com.tool.java.Tree.Node;
import com.tool.java.Tree.BT.BinaryTree;

public class SerializeDeserializeBSTUsingPre
{
    
    
    public static void main (String[] args)
    {
        
        Node root = deserialize(serialize(Node.getSampleBST()));
        System.out.println(BinaryTree.identicalTrees(Node.getSampleBST(),root));
 
    }
    
    //using preorder just append the values to form a string
    public static void serializeBST(Node root, StringBuilder serializedString)
    {
        if(root == null)
            return;
        
        serializedString.append(root.data).append(",");
        serializeBST(root.left, serializedString);
        serializeBST(root.right, serializedString);
    }
    
    public static String serialize(Node root) {
        StringBuilder serializedString = new StringBuilder();
        serializeBST(root, serializedString);
        return serializedString.toString();
    }

    
    
    // Decodes your encoded data to tree.
    public static Node deserialize(String data) 
    {
       if(data == null || data.isEmpty())
           return null;
       int min  = Integer.MIN_VALUE;
       int max  = Integer.MAX_VALUE;
       int[] currIndex = {0};
       String[] preOrder = data.substring(0,data.length()-1).split(",");
       return deserializeBST(preOrder, currIndex, min, max);
        
    }
    
    //with preorder, the first val is always root, so, currIndex starts at 0 and create root with it,.
    // then the left and right can have value between (min to rootval) and (rootval to max) respectively.
    public static Node deserializeBST(String[] preorder, int[] currIndex, int min, int max)
    {
        if (currIndex[0] >= preorder.length) return null;
         
        Node root = null;
        int num = Integer.parseInt(preorder[currIndex[0]]);
        if (num > min && num < max)
        {
            root = new Node(num);
            currIndex[0] += 1;
            root.left = deserializeBST(preorder, currIndex, min, root.data);
            root.right = deserializeBST(preorder, currIndex, root.data, max);
        }
         
        return root;
    }

}
