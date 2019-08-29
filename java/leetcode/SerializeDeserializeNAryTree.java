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
    
    
    public String serialize1(Node root)
    {
        if(root == null)
            return "";
        
        StringBuilder s = new StringBuilder();
        s.append(root.data);
        s.append("[");
        for(Node children: root.children)
        {
            s.append(serialize(children));
        }
        s.append("]");
        return s.toString();
        
    }
    
    public Node deserialize1(String data)
    {
        Node root = null;
        Stack<Node> stack = new Stack<Node>();
        
        int end=0;
        
        while(end < data.length())
        {
            int start = end;
            
            // Move pointer forward until we don't find a digit...
            // ie., moves to [
            while(end < data.length() && Character.isDigit(data.charAt(end)))
            {
                end++;
            }
            
            // If we haven't found a digit then we must have found the end of a child list...
            // ie., start = ] ,  end = ] => in this case we have reached end of that child for a particular parent
            if(end == start)
            {
               
                Node child = stack.pop();
                //pop the child and assign it to parent 
                if(!stack.isEmpty()){
                    stack.peek().children.add(child);
                }
                else // else the only node in the stack is the root.
                {
                    root = child;
                    break;
                }
            }
            else            // take the num and make it as node and push into stack
            {
                Node n = new Node(Integer.parseInt(data.substring(start,end)));
                n.children = new ArrayList<Node>();
                stack.add(n);
            }
            
            end++;
        }
        return root;
    }

    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {
        Node root = null;
        Stack<Node> stack = new Stack<>();
        int end = 0;
        
        while (end < data.length()) {
            int start = end;
            
            // Move pointer forward until we don't find a digit...
            while (end < data.length() && Character.isDigit(data.charAt(end))) {
                end++;
            }
            
            // If we haven't found a digit then we must have found the end of a child list...
            if (start == end) {
                Node child = stack.pop();
                if (stack.isEmpty()) {
                    root = child;
                    break;
                } else {
                    // Remove the child from the stack and assign it to the previous node on the stack
                    stack.peek().children.add(child);
                }
            } else {
                Node n = new Node(Integer.parseInt(data.substring(start, end)));
                n.children = new ArrayList<>();
                stack.push(n);
            }
            end++;
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
        
        String data  = serialize(x);
        System.out.println(serialize(x)); //1[2[]3[6[]7[]8[]9[]]4[]5[]]
        deserialize(data);
        
    }

}
