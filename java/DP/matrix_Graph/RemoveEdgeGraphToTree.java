package com.tool.java.DP.matrix_Graph;

public class RemoveEdgeGraphToTree
{
    /*
     
      Input: [[1,2], 
              [1,3], 
              [2,3]]
        Output: [2,3]
        Explanation: The given undirected graph will be like this:
          1
         / \
        2 - 3
        
        1-2 => 3-1-2 => when union joining [2,3] both have same parent, so that is the redundant edge
        
        nodes 1,2,3
        parent [1,2,3]
        rank   [0,0,0]
     
     */
    
    class DSU {
        private int[] rank;
        private int[] parent;

        public DSU(int N) {
            rank = new int[N];
            parent = new int[N];  //  the rank for all elements is 0
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

        private boolean unionWithCompression(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == parentY) 
                  return false;  //if both are in same parent
            if (rank[parentY] >= rank[parentX]) {
                parent[parentX] = parentY;
                rank[parentY]++;
            } else {
                parent[parentY] = parentX;
                rank[parentX]++;
            }
            return true;
        }
    }
    
    
    public int[] findRedundantConnection(int[][] edges) {
        
        DSU d = new DSU(edges.length);
        for(int[] edge: edges)
        {
            if(!d.unionWithCompression(edge[0], edge[1])){
                return edge;
            }
        }
        return null;
    }


}
