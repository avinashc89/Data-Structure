package com.tool.java.Tree.BT;

import com.tool.java.Tree.Node;

public class SumBT
{
    /*
     * 1. check if sum of child is parent
     */
    public static  boolean check_if_sum_of_child_is_parent(Node root)
    {
        int left_data = 0,  right_data = 0;

        if(root == null || (root.left == null && root.right == null))
            return true;
        else{
            if(root.left != null)
                left_data = root.left.data;

            if(root.right != null)
                right_data = root.right.data;

            if((root.data == left_data + right_data)&&
                    check_if_sum_of_child_is_parent(root.left) &&
                    check_if_sum_of_child_is_parent(root.right))
                return true;
            else
                return false;
        }
    }
    
    /************************************************************************************************/

    
    public static boolean Path_Sum_From_Root_Exist(Node node, int sum)
    {
      /* return true if we run out of tree and sum==0 */
      if (node == null)
      {
         return (sum == 0);
      }
      else
      {
        boolean flag = false;  
      
        /* otherwise check both subtrees */
        int subSum = sum - node.data;
      
        /* If we reach a leaf node and sum becomes 0 then return true*/
        if ( subSum == 0 && node.left == null && node.right == null )
          return true;
      
        if(node.left != null)
            flag = flag || Path_Sum_From_Root_Exist(node.left, subSum);
        if(node.right != null)
            flag = flag || Path_Sum_From_Root_Exist(node.right, subSum);
      
        return flag;
      }
    }
    
    /************************************************************************************************/
    
    public static  int Path_Max_Sum(Node root) {
        Integer max = new Integer(Integer.MIN_VALUE);
        calculateSum(root, max);
        return max;
    }
 
    public static  int calculateSum(Node root, Integer max) {
        if (root == null)
            return 0;
 
        int left = calculateSum(root.left, max);
        int right = calculateSum(root.right, max);
 
        int current = Math.max(root.data, Math.max(root.data + left, root.data + right));
 
        max = Math.max(max, Math.max(current, left + root.data + right));
 
        return current;
    }
    
    /************************************************************************************************/
    
    //printAllPathWithSumN(root,sum,0,"")
    public static  void print_All_Path_With_Sum_N(Node root, int sum,int currSum , StringBuilder result)
    {
        if(root ==null) return;
        currSum += root.data;
        result = result.append(root.data).append("-");
        if(currSum == sum)
        {
            System.out.println(result.toString());
        }
        else if(currSum < sum)
        {
            print_All_Path_With_Sum_N(root.left, sum , currSum, result);
            print_All_Path_With_Sum_N(root.right, sum , currSum, result);
        }
        print_All_Path_With_Sum_N(root.left, sum , 0, new StringBuilder(""));
        print_All_Path_With_Sum_N(root.right, sum , 0, new StringBuilder(""));
    }

}
