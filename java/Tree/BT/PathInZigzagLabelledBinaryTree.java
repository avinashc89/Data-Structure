package com.tool.java.Tree.BT;

import java.util.*;

public class PathInZigzagLabelledBinaryTree
{
    // in complete binary tree, parent node = (childnode-1)/2 => 12th parent node => 12-1/2 = 6
    // in zig zg tree, 12 is not in right position. we need to know where the 12 is.
    //   say, lable=12   12th node => (Math.pow(2, level)-label + Math.pow(2,level-1)), 
    //   12th parent => ((Math.pow(2, level)-label + Math.pow(2,level-1))-1) /2
    
    
    public List<Integer> pathInZigZagTree(int label) {

        List<Integer> res = new ArrayList<Integer>();
        res.add(label);
        int level = getLevel(label);
        
        while(label > 1){
            int parentIndex = (int)(((Math.pow(2, level)-label + Math.pow(2,level-1))-1)/2);
            System.out.println(parentIndex);
            res.add(0,parentIndex);
            label = parentIndex;
            level--;
        }
        
        System.out.println(res);
        return res;
            
    }
    
    
    private int getLevel (int label)
    {
        int level = 0;
        while (true)
        {
            if(label < Math.pow(2,level++)){
                return level-1;
            }
        }
        
    }

    public static void main (String[] args)
    {
        PathInZigzagLabelledBinaryTree p = new PathInZigzagLabelledBinaryTree();
        p.pathInZigZagTree(6);
        
        
    }

}
