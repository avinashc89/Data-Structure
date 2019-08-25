package com.tool.java.leetcode;

import java.util.ArrayList;
import java.util.Stack;
import com.tool.java.Tree.Node;

public class SerializeDeserializeNAryTree
{
    
    
 // Encodes a tree to a single string.
    public  static String serialize(Node root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(root.data);
        sb.append("[");
        for (Node child : root.children) {
            sb.append(serialize(child));
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {
        Node root = null;
        Stack<Node> stack = new Stack<>();
        int i = 0;
        
        while (i < data.length()) {
            int start = i;
            
            // Move pointer forward until we don't find a digit...
            while (i < data.length() && Character.isDigit(data.charAt(i))) {
                i++;
            }
            
            // If we haven't found a digit then we must have found the end of a child list...
            if (start == i) {
                Node child = stack.pop();
                if (stack.isEmpty()) {
                    root = child;
                    break;
                } else {
                    // Remove the child from the stack and assign it to the previous node on the stack
                    stack.peek().children.add(child);
                }
            } else {
                Node n = new Node(Integer.parseInt(data.substring(start, i)));
                n.children = new ArrayList<>();
                stack.push(n);
            }
            i++;
        }
        return root;
    }
    
    public static void main (String[] args)
    {
        
        /*
                       1
              2     3      4      5
                 6 7 8 9
         */
        
        Node x = new Node(1);
        Node y = new Node(3);
        Node z = new Node(9);
        
        x.children.add(new Node(2));
        x.children.add(y);
        x.children.add(new Node(4));
        x.children.add(new Node(5));
        
        y.children.add(new Node(6));
        y.children.add(new Node(7));
        y.children.add(new Node(8));
        y.children.add(z);
        
        System.out.println(serialize(x)); //1[2[]3[6[]7[]8[]9[]]4[]5[]]
        
    }

}
