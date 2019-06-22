package com.tool.java.Tree.BT;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import com.tool.java.Tree.Node;

public class ViewBT
{
    
    /**
     * Bottom view of BT - 
     * Using Queue to read level order and 
     * Map<hd,node> stores Node and horizontal distance with root hd =0 and root.left hd = -1 and root.right hd = 1 and so on..
     * the map updates the hd value with nodes read till the bottom.
     * 
     * @param root
     */
    public void bottom_View_BT(Node root)
    {
        if (root == null)
            return;
 
        int hd = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<Node>();

        root.hd = hd;
        queue.add(root);
 
        while (!queue.isEmpty())
        {
            Node temp = queue.remove();
            hd = temp.hd;
            map.put(hd, temp.data);

            if (temp.left != null)
            {
                temp.left.hd = hd-1;
                queue.add(temp.left);
            }

            if (temp.right != null)
            {
                temp.right.hd = hd+1;
                queue.add(temp.right);
            }
        }
        //print the bottom view - not ordered.
        Set<Entry<Integer, Integer>> set = map.entrySet();
        Iterator<Entry<Integer, Integer>> iterator = set.iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> me = iterator.next();
            System.out.print(me.getValue()+" ");
        }
    }
    
    
    /**
     * Top view of BT - 
     * Using Queue to read level order and 
     * Map<hd,node> stores Node and horizontal distance with root hd =0 and root.left hd = -1 and root.right hd = 1 and so on..
     * the map puts the first occuring hd value with node .
     * 
     * @param root
     */
    public void top_View_BT(Node root)
    {
        if (root == null)
            return;
 
        int hd = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<Node>();

        root.hd = hd;
        queue.add(root);
 
        while (!queue.isEmpty())
        {
            Node temp = queue.remove();
            hd = temp.hd;
            
            if(!map.containsKey(hd))
                map.put(hd, temp.data);

            if (temp.left != null)
            {
                temp.left.hd = hd-1;
                queue.add(temp.left);
            }

            if (temp.right != null)
            {
                temp.right.hd = hd+1;
                queue.add(temp.right);
            }
        }
        //print the top view - not ordered.
        Set<Entry<Integer, Integer>> set = map.entrySet();
        Iterator<Entry<Integer, Integer>> iterator = set.iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> me = iterator.next();
            System.out.print(me.getValue()+" ");
        }
    }
    
    /**
     * Right view of BT - 
     * Using recursion - have current level = 0 and next level =1, if currLevel is encountered first, print and set it to next level
     * 
     * 
     * @param root
     */
    public static int currentLevel =0;
    public void rightViewRecur(Node root, int nextLevel){
        if(root==null) return;
        if(currentLevel<nextLevel){
            System.out.print ("  " + root.data);
            currentLevel = nextLevel;
        }
        rightViewRecur(root.right,nextLevel+1);
        rightViewRecur(root.left,nextLevel+1);
    }
    
    
    /**
     * left view of BT - 
     * Using recursion - have current level = 0 and next level =1, if currLevel is encountered first, print and set it to next level
     * 
     * 
     * @param root
     */
    public void leftViewRecur(Node root, int nextLevel){
        if(root==null) return;
        if(currentLevel<nextLevel){
            System.out.print ("  " + root.data);
            currentLevel = nextLevel;
        }
        leftViewRecur(root.left,nextLevel+1);
        leftViewRecur(root.right,nextLevel+1);
    }

}
