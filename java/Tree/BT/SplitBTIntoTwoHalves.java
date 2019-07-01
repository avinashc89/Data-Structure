package com.tool.java.Tree.BT;

import com.tool.java.Tree.Node;

public class SplitBTIntoTwoHalves
{
    boolean check(Node root)  
    { 
        int n = count(root); 
        boolean[] res = {false};
        checkRec(root, n, res); 
  
       return res[0];
    }

    private int count (Node root)
    {
        if (root == null) 
            return 0; 
        return count(root.left)+count(root.right)+1;
    }

    //get the count n.
    // again do the same logic as count now check at each stage if c = n/2
    private int checkRec (Node root, int n, boolean[] res)
    {
        if (root == null) 
            return 0;
        
        int count = checkRec(root.left, n, res) + 1
            + checkRec(root.right, n, res); 
        
        if (count == n/2)  
            res[0] = true; 

        return count;
    } 
    
    

}
