package com.tool.java.Tree;

import java.util.ArrayList;

public class SerializeDeserializeBinaryTree
{

    static ArrayList<Integer> list = new ArrayList<Integer>();
    
    static void serialize(Node root, ArrayList<Integer> list)
    {
        if(root == null)
        {
            list.add(-1);
            return;
        }
        list.add(root.data);
        serialize(root.left,list);
        serialize(root.right, list);
    }
    
    
    static int index =0;
    
    static Node deserialize(ArrayList<Integer> array)
    {
        if (index == array.size() || array.get(index) == -1)
        {
            index++;  
            return null;
        }
        
        Node root = new Node(array.get(index));
        index++;
        
        root.left = deserialize(array);
        root.right = deserialize(array);
        
        return root;
    }
    
    public static void main (String[] args)
    {
        serialize(Node.getSampleTree(), list);
        System.out.println(list);
        index = 0;
        Node root = deserialize(list);
        
        System.out.println(BinaryTree.identicalTrees(Node.getSampleTree(), root));
        
    }
    
}
