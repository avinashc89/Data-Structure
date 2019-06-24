package com.tool.java.DP.matrix_Graph;

public class MostStonesRemoved
{
    /*
     
     [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
     
          0   1   2
       0  X   X 
       1  X       X
       2      X   X 
       
     [[0,0],[0,2],[1,1],[2,0],[2,2]]
     
          0   1   2
       0  X       X
       1      X   
       2  X       X 
       
       
     Using Disjoint union set DSU
     
     // => https://www.youtube.com/watch?v=ID00PMy0-vE
      
     */
    
    class DSU {
        private int[] rank;
        private int[] parent;
        private int count;

        public DSU(int N) {
            rank = new int[N];
            parent = new int[N];  //  the rank for all elements is 0
            count = N;            // total no of islands
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

        private void unionWithCompression(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == parentY) return;  //if both are in same dS

            if (rank[parentY] >= rank[parentX]) {
                parent[parentX] = parentY;
                rank[parentY]++;
            } else {
                parent[parentY] = parentX;
                rank[parentX]++;
            }
            count--;
        }
    }

    public int removeStones(int[][] stones) {
        int N = stones.length;
        DSU dsu = new DSU(N);

        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                // stone1:i , stone2:j
                //if stone1.x == stone2.x or stone1.y=stone2.y then they are in straight line, union i,j
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    dsu.unionWithCompression(i, j);
                }
            }
        }

        return N - dsu.count;
    }

}
