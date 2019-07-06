package com.tool.java.leetcode;


import java.util.*;
import com.tool.java.Tree.Node;
public class GameNodeCapture
{
    
    /*
     
    The player who eventually owns more nodes wins the game.
    Player A and B each claims a node at first.
    After the first round, a player will only be able to claim a node adjacent to any node owned by himself.
    A tree node is adjacent to its parent, left right and right child.
    A node owned cannot be re-claimed.
    End game when all nodes are owned.
    
    If opponent gets the first claim at node N, find whether it is possible for you to win.
    If yes, find out which node you should claim at his first move.
    
    Follow up: if you take the first hand instead, which node should you pick?
     
     */
    
    public static boolean win(Node root, Node n) { //N is the first move by opponent
        int sizeParent = countNodes(n.parent, n); //size of parent component
        int sizeLeft = countNodes(n.left, n);   //size of left subtree component
        int sizeRight = countNodes(n.right, n); //size of right subtree component

        int totalNodes = 1 + sizeParent + sizeLeft + sizeRight;
        
        int myScore = Math.max(Math.max(sizeParent, sizeLeft), sizeRight); //I take the biggest component
        
        
        int opponentScore = totalNodes - myScore; //opponent takes remaining nodes
        System.out.print("my best score is " + myScore + "/" + totalNodes + ". ");
        
        if(myScore > opponentScore) {
            Node bestmove = null;
            if(myScore == sizeParent)
                bestmove = n.parent;
            else if (myScore == sizeLeft)
                bestmove = n.left;
            else
                bestmove = n.right;
            System.out.println("my first move on " + bestmove.data);
        }
        return myScore > opponentScore;
    }
    
    //if parent is not given, we can also use normal count(). Get the count of right tree and left tree. Get the total count from root. 
    // parent count = totalcount - ( 1 + leftcount + rightcount)

    private static int countNodes(Node node, Node ignore) {
        if(node == null) 
            return 0;
        
        int count = 1;
        if(node.parent != ignore) {
            count += countNodes(node.parent, node);
        }
        if(node.left != ignore) {
            count += countNodes(node.left, node);
        }
        if(node.right != ignore) {
            count += countNodes(node.right, node);
        }
        return count;
    }


    
    
    public static Node bestMove(Node root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) 
            return root;

        // map stores size of every component
        // each node at most has 3 components - to its left, to its right, to its top (parent)
        // Map<node, Map<which component, size>>
        Map<Node, Map<Node, Integer>> components = new HashMap<>();
        Node dummy = new Node(-1);
        dummy.left = root;

        // calculate size of child components for all nodes
        getComponentSize(dummy, root, components);

        int treeSize = components.get(dummy).get(root);
        for (Node node : components.keySet()) {
            int maxSize = 0; // maximum score possible for opponent
            for (int size : components.get(node).values()) {
                maxSize = Math.max(maxSize, size);
            }
            if (treeSize / 2.0 > maxSize) { // opponent cannot get half of the tree. You win.
                return node; // best first move
            }
        }
        return null; // no winning play
    }

    // we can also use count() and find leftCount and rightCount of each node. parentCount = TC - (1+LC+R). put in the map. return (1+LC+R).
    //while computing, also compute the max out of three in each node. if max(lets say opponent takes) is less than half of three. then we win.
    
    private static int getComponentSize(Node n, Node branch, Map<Node, Map<Node, Integer>> components) {
        if (n == null || branch == null) return 0;

        if (components.containsKey(n) && components.get(n).containsKey(branch)) {
            return components.get(n).get(branch); // component size of a branch from node n (n excluded)
        }
        // a node n has 3 branches at most - parent, left, right
        if (!components.containsKey(n)) {
            components.put(n, new HashMap<>());
        }

        int size = 1; // 1 is the size of TreeNode branch
        if (branch == n.left || branch == n.right) {
            // size of the subtree 'branch' is size(branch.left) + size(branch.right) + 1
            size += getComponentSize(branch, branch.left, components);
            size += getComponentSize(branch, branch.right, components);
        } else { //else when (branch == n.parent)
            // see the tree from left-side or right-side view (see parent as a child; see one of the children as parent)
            // size of the component is size(branch.parent) + size(branch.left/right child)
            size += getComponentSize(branch, branch.parent, components);
            size += branch.left == n ? getComponentSize(branch, branch.right, components) : getComponentSize(branch, branch.left, components);
        }
        components.get(n).put(branch, size); // cache the result of recursion
        getComponentSize(n, n.parent, components); // calculate size of parent component for current node
        return size;
    }
    
}
