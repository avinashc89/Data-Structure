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
 
      //this is just for calculating max
        max = Math.max(max, Math.max(current, left + root.data + right));
 
        return current;  // since only the path can be root / root+left / root+right to the above tree, we can't have left + root.data + right
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
    
    
    /************************************************************************************************/
    
    
    public static int maxEvenPathSum(Node root) {
        return maxPathSum(root).maxEven;
    }
    
    private static NodeStatus maxPathSum(Node node) {
        if (node == null) return new NodeStatus();
        
        NodeStatus left = maxPathSum(node.left);
        NodeStatus right = maxPathSum(node.right);
        
        int[] paths = {
            // add node.data
            left.even + node.data, 
            left.odd + node.data, 
            right.even + node.data, 
            right.odd + node.data
        };
        
        int even = 0;
        int odd = 0;
        for (int path : paths) {
            if (isEven(path)) {
                even = Math.max(even, path);
            } else {
                odd = Math.max(odd, path);
            }
        }
        
        
        int maxEven = Math.max(even , Math.max(left.maxEven, right.maxEven)); 
        
        //this is just for calculating max
        int[] totalPaths = {
            node.data + left.odd + right.odd,
            node.data + left.odd + right.even,
            node.data + left.even + right.odd,
            node.data + left.even + right.even
        };
        for (int path : totalPaths) {
            if (isEven(path)) {
                maxEven = Math.max(maxEven, path);   
            }
        }
        
        return new NodeStatus(even, odd, maxEven);
    }
    
    private static boolean isEven(int x) {
        return (x & 1) == 0;
    }
    
    private static class NodeStatus {
        int even;
        int odd;
        int maxEven = Integer.MIN_VALUE;
        
        NodeStatus(int even, int odd, int maxEven) {
            this.even = even;
            this.odd = odd;
            this.maxEven = maxEven;
        }
        public String toString() {
            
            return "Even:"+even+", Odd:"+odd+", maxEven:"+maxEven;
        };
        
        NodeStatus() {}
    }

    
    /*      2            */
    /*     / \           */
    /*    1   3         */
    /*   / \   \       */
    /*  4   6   8       */
    /*     /            */
    /*    5             */
    
    public static void main (String[] args)
    {
        Node root = Node.getSampleTree();
        System.out.println(maxEvenPathSum(root));
    }
}
