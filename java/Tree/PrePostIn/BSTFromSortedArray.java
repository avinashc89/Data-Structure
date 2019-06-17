package com.tool.java.Tree.PrePostIn;

import com.tool.java.Tree.Node;

public class BSTFromSortedArray
{
    //if unsorted, sort the array sorted -> o(nlogn)
    
    public Node sortedArrayToBST(int arr[], int start, int end) { 
        
        /* Base Case */
        if (start > end) { 
            return null; 
        } 
  
        /* Get the middle element and make it root */
        int mid = (start + end) / 2; 
        Node node = new Node(arr[mid]); 
  
        /* Recursively construct the left subtree and make it 
         left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1); 
  
        /* Recursively construct the right subtree and make it 
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end); 
          
        return node; 
    } 


}
