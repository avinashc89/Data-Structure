package com.tool.java.leetcode;

public class BombEnemy
{

    /*
     Input: [["0","E","0","0"],
             ["E","0","W","E"],
             ["0","E","0","0"]]
    Output: 3 

     we can do by traversing from all direction => 4*n*m space complexity. and add all cell to get the max.
    
     */
    // Time : O(2nm)  Space: O(2nm+n+m) => O(3nm)

    public static int maxKilledEnemies(char[][] grid) {
        int rowNum = grid.length;
        if (rowNum == 0) return 0;
        int colNum = grid[0].length;

        int[][] fromBottom = new int[rowNum][colNum];
        int[][] fromRight = new int[rowNum][colNum];
        
        for (int i = rowNum - 1; i >= 0; i--) {
            for (int j = colNum - 1; j >= 0; j--) {
                if (grid[i][j] != 'W') 
                {
                    if(grid[i][j] == 'E')
                    {
                        if(i == rowNum - 1){
                            fromBottom[i][j] = 1;
                        }
                        else{
                            fromBottom[i][j] = fromBottom[i+1][j] + 1;
                        }
                        if(j == colNum - 1) {
                            fromRight[i][j] = 1;
                        }
                        else {
                            fromRight[i][j] =  fromRight[i][j+1] + 1;
                        }
                    }
                    else 
                    {
                       if(i == rowNum - 1){
                            fromBottom[i][j] = 0;
                        }
                       else{
                           fromBottom[i][j] =fromBottom[i+1][j];
                       }
                       if(j == colNum - 1) {
                            fromRight[i][j] = 0;
                        } else {
                            fromRight[i][j] = fromRight[i][j+1];
                        }
                    }
                }
                else {
                    fromBottom[i][j] = 0;
                    fromRight[i][j] = 0;
                }
            }
        }
         

//        for (int i = rowNum - 1; i >= 0; i--) {
//            for (int j = colNum - 1; j >= 0; j--) {
//                if (grid[i][j] != 'W') {
//                    int enemy = grid[i][j] == 'E' ? 1 : 0;
//                    fromBottom[i][j] = (i == rowNum - 1) ? enemy : fromBottom[i+1][j] + enemy;
//                    fromRight[i][j] = (j == colNum - 1) ? enemy : fromRight[i][j+1] + enemy;
//                }
//                else {
//                    fromBottom[i][j] = 0;
//                    fromRight[i][j] = 0;
//                }
//            }
//        }

        //we need the last row/column as dp so, two 1D arrays is enough 
        int[] fromTop = new int[colNum];
        int[] fromLeft = new int[rowNum];
        int max = 0;

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (grid[i][j] != '0') {
                    fromTop[j] = grid[i][j] == 'W' ? 0 : fromTop[j] + 1;
                    fromLeft[i] = grid[i][j] == 'W' ? 0 : fromLeft[i] + 1;
                }
                else {
                    int num = fromTop[j] + fromLeft[i] + fromBottom[i][j] + fromRight[i][j];
                    max = Math.max(num, max);
                }
            }
        }
        return max;
    }

    public static void main (String[] args)
    {
        char[][] grid = new char[][]{{'0','E','0','0'},
            {'E','0','W','E'},
            {'0','E','0','0'}};
      //  System.out.println(maxKilledEnemies(grid));
        System.out.println(maxKilledEnemies(new char[][]{{'0','E'}}));
    }

}
