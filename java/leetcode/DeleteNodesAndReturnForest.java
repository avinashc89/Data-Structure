package com.tool.java.leetcode;

import java.util.*;
import com.tool.java.Tree.Node;

public class DeleteNodesAndReturnForest
{
    HashSet<Integer> delete = new HashSet<Integer>();
    
    public List<Node> delNodes1(Node root, int[] to_delete) {
        
        List<Node> result = new ArrayList<Node>();
        
        for(int i : to_delete)
            delete.add(i);
        
        deleteHelper(null, root, result );

        System.out.println(result);
        for(Node c : result)
        {
            Node.printBST(c);
        }
        
        return result;
    }
  
    private void deleteHelper (Node prev, Node curr, List<Node> result)
    {
       if(curr == null)
           return;
       
       //if parent is null && doesnt contain in delete list
       if(prev ==null && !delete.contains(curr.data))
       {
           result.add(curr);
       }
       
       if(delete.contains(curr.data))
       {
           if(prev !=null)
               if(prev.left == curr)
                   prev.left = null;
               else
                   prev.right = null;
           
           if(curr.left!=null){
               deleteHelper(null,curr.left , result );
           }
           if(curr.right!=null)  {
               deleteHelper(null,curr.right , result );
           }
           return;
       }
       
       deleteHelper(curr, curr.left ,result );
       deleteHelper(curr, curr.right ,result );
        
    }

    public static void main (String[] args)
    {
        Node root = Node.getSampleTree();
     
        DeleteNodesAndReturnForest d = new DeleteNodesAndReturnForest();
        
        d.delNodes1(root , new int[]{1,6});
    }
    /*      2            */
    /*     / \           */
    /*    1   3         */
    /*   / \   \       */
    /*  4   6   8       */
    /*     /            */
    /*    5             */
    

}
