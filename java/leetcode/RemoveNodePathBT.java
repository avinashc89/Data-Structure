package com.tool.java.leetcode;

import com.tool.java.Tree.Node;

public class RemoveNodePathBT
{

  //remove_nodes_on_root_to_leaf_path_less_than_K
    //removeShortPathNodesUtil(root, 1, k)
    /*
     
                           1
                       /      \
                     2          3
                  /     \         \
                4         5        6
              /                   /
             7                   8 
            Input: Root of above Binary Tree
                   k = 4
            
            Output: The tree should be changed to following  
                       1
                    /     \
                  2          3
                 /             \
               4                 6
             /                  /
            7                  8
     
     */
    public static Node remove_nodes_pathLen_less_than_K(Node root, int level, int k)
    {
        //Base condition
        if (root == null)
            return null;
     
        // Traverse the tree in postorder fashion so that if a leaf
        // node path length is shorter than k, then that node and
        // all of its descendants till the node which are not
        // on some other path are removed.
        root.left = remove_nodes_pathLen_less_than_K(root.left, level + 1, k);
        root.right = remove_nodes_pathLen_less_than_K(root.right, level + 1, k);
     
        // If root is a leaf node and it's level is less than k then
        // remove this node.
        // This goes up and check for the ancestor nodes also for the
        // same condition till it finds a node which is a part of other
        // path(s) too.
        if (root.left == null && root.right == null && level < k)
        {
           root=null;
        }
     
        // Return root;
        return root;
    }
    
    /************************************************************************************************/
    
    
    //remove_nodes_on_root_to_leaf_path_less_than_K
    //removeShortPathNodesUtil(root,new int[1]{0} , 20)
    
    public static Node remove_nodes_pathSum_less_than_K(Node root, int[] currSum, int maxSum)
    {
        //Base condition
        if (root == null)
            return null;
        
        // Initialize left and right sums as sum from root to
        // this node (including this node)
        int[] lsum = new int[1];
        int[] rsum  = new int[1];
       
        lsum[0]= currSum[0] + (root.data);
        rsum[0] = currSum[0] + (root.data);
     
     
        // Recursively remove left and right subtrees
        root.left = remove_nodes_pathSum_less_than_K(root.left, lsum ,maxSum);
        root.right = remove_nodes_pathSum_less_than_K(root.right , rsum, maxSum);
     
        // Get the maximum of left and right sums
        currSum[0] = Math.max(lsum[0], rsum[0]);
        
        if (currSum[0] < maxSum)
        {
            root = null;
        }
        return root;
    }
}
