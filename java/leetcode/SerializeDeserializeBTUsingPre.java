package com.tool.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.tool.java.Tree.Node;
import com.tool.java.Tree.BT.BinaryTree;

public class SerializeDeserializeBTUsingPre
{

    public static String serialize(Node root) {
        StringBuilder list = new StringBuilder();
        serializeBT(root, list);
        return list.toString();
    }

    
    //if there is null node, append the value in the list as -1. since we need to recreate the null node when -1 is encountered during deserialise.
    // this is not the case in BST, since it is based on the min&max. 
    static void serializeBT(Node root, StringBuilder list)
    {
        if(root == null)
        {
            list.append("null").append(",");
            return;
        }
        list.append(root.data).append(",");
        serializeBT(root.left,list);
        serializeBT(root.right, list);
    }



    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {
        
        int index[] ={0};
        String list[] = data.substring(0,data.length()-1).split(",");
       
        return deserializeBT(Arrays.asList(list), index);
    }

    

    static Node deserializeBT(List<String> array, int[] index)
    {
        if(index[0] > array.size())
            return null;
        if (index[0] == array.size() || array.get(index[0]).equals("-1"))
        {
            index[0]++;  
            return null;
        }

        Node root = new Node(Integer.parseInt(array.get(index[0])));
        index[0]++;

        root.left = deserializeBT(array, index);
        root.right = deserializeBT(array, index);

        return root;
    }

    public static void main (String[] args)
    {
        Node root = deserialize(serialize(Node.getSampleTree()));
        System.out.println(BinaryTree.identicalTrees(Node.getSampleTree(), root));

    }

}
