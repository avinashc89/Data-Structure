package com.tool.java.leetcode;

import com.tool.java.Util;

public class RedundantConnection2
{
    /*
      Directed graph - also a node should have only one parent.
      Input: [[1,2],  [1,3],  [2,3]]
        Output: [2,3]
        Explanation: The given directed graph will be like this:
          1
         / \
        v   v
        2-->3
        
        1-2 => 3-1-2 => when union joining [2,3] both have same parent, so that is the redundant edge
        
        nodes 1,2,3
        parent [1,2,3]
        rank   [0,0,0]
     
     [[1,2], [2,3], [3,4], [4,1], [1,5]] => [4,1]
      [[2,3], [3,4], [4,1], [1,5],[1,2]] => [1,2]
      
     5 <- 1 -> 2
          ^    |
          |    v
          4 <- 3
     
     */
    
    /*
    A new edge makes a node have 2 parents. (I). We store 2 possible edges that should be removed. twoParents[0], and twoParents[1]
   A new edge makes a cycle in the graph. (II). We store the possible edge that should be removed. cycle

    There are 4 possibilities happen:

   (I) happens before (II) : we need to remove the edge twoParents[0], because when we remove twoParents[0]:
   
   the graph has no node that has 2 parents
   the graph has no cycle.
   (II) happens before (I)) : the same as above. We should remove twoParents[0]
   
   Only (I) happens: we should remove one of twoParents. Because we must remove the one that occurs last in the given 2D-array. So twoParents[1] should be removed.
   
   Only (II) happens: ofcourse we must remove the edge that makes the graph become cycle: so we remove cycle.


    */
    
    static class DSU {
        private int[] parent;
        private int count;
        public DSU(int N) {
            parent = new int[N]; 
            
            // initially for all element, they are their own parent
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }
        
        // recurse till parent of x is same as itself. ie., x
        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        private void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX != parentY) {
                count--;
                parent[parentY] = parentX;  // x->y
            }
        }
    }
    
    
    public static int[] findRedundantDirectedConnection(int[][] edges) {
        
        int N = edges.length;
        DSU dsu = new DSU(N + 1);
        int[] cycleEdge = null;
        int[] twoParentsEdge = null;
        
        for(int[] edge: edges)  //[u,v]
        {
            int pu = dsu.find(edge[0]);
            int pv = dsu.find(edge[1]);
            if (pv != edge[1]) {            //if (pv == pu)
                twoParentsEdge = edge;
            } else {
                // if parent of u is v  then cycle is found i.e,  u->v, u<-v
                if (pu == edge[1]) {
                    cycleEdge = edge;
                }
                dsu.union(pu, pv);
            }
            
        }
        if (twoParentsEdge != null && cycleEdge!=null) {
            for (int[] edge : edges) {
                if (edge[1] == twoParentsEdge[1]) {
                        return edge;
                }
            }
        }
        if(twoParentsEdge!=null)
            return twoParentsEdge;
        
        return cycleEdge;
    }

    public static void main (String[] args)
    {
        int[][] edges = {{1,2},  {1,3},  {2,3}};
        int[][] edges1 = { {4,1}, {4,2}, {1,2}, {2,3}, {3,4},{1,5}};
        int[][] edges3 = {{2,1},{3,1},{4,2},{1,4}};
        Util.printArray(findRedundantDirectedConnection(edges));
        Util.printArray(findRedundantDirectedConnection(edges1));
        Util.printArray(findRedundantDirectedConnection(edges3));
    }
    
    
}
