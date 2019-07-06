package com.tool.java.leetcode;

import com.tool.java.Util;

public class CandyCrush
{
    // O (3*n*m) => O (n*m) for each time, lets say, we crush all the m*n => we do (m*n)/3 repetition => O (n^2*m^2)

    public int[][] candyCrush(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean shouldContinue = false;
        
        // instead of making it zero or removing, we should make it -value, so that when scanning vertically, we might encounter 
        //        
        //      2               => here during horizontal scanning,           2                 After vertical      -2
        //      2                  we would make the array as           =>    2             =>  scanning        =>  -2 
        //      2  2  2                                                      -2  -2  -2                             -2  -2  -2 
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col-2;j++){
                int value = Math.abs(board[i][j]);
                if(value>0&&Math.abs(board[i][j+1])==value&&Math.abs(board[i][j+2])==value){
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -value;
                    shouldContinue = true;
                }
            }
        }
        
       
        
        for(int i=0;i<row-2;i++){
            for(int j=0;j<col;j++){
                int value = Math.abs(board[i][j]);
                if(value>0&&Math.abs(board[i+1][j])==value&&Math.abs(board[i+2][j])==value){
                    board[i][j]=board[i+1][j]=board[i+2][j] = -value;
                    shouldContinue = true;
                }
            }
        }
        
        Util.printMatrix(board);
        /*
         After first iteration:
            110  ,5   ,112 ,113  ,114  ,
            210  ,211 ,5   ,213  ,214  ,
            310  ,311 ,3   ,313  ,314  ,
            410  ,411 ,412 ,5    ,414  ,
            5    ,1   ,512 ,3    ,3    ,
            610  ,4   ,1   ,613  ,614  ,
            710  ,-1  ,-2  ,713  ,714  ,
            810  ,-1  ,-2  , 1   ,1    ,
            1    ,-1  ,-2  , -2  ,-2   ,
            4    ,-1  ,4   , 4   ,1014  ,
         
         */
        
        //traversing from bottom left. finish of column by column.
        // j = row-1, index = row-1.  
        // if the number is >0 , move j,i to index,i. decrement both j & index, since both are same, update happens in same place.
        // if number < 0, decrement only j, index points to first -(x) cell. 
      
        
        for(int i=0;i<col;i++){
            int index = row-1;
            for(int j=row-1;j>=0;j--){
                if(board[j][i]>=0) 
                    board[index--][i] = board[j][i];
            }
            for(int j=index;j>=0;j--){
                board[j][i] = 0;
            }
        }
        return shouldContinue==true ? candyCrush(board) : board;
        
        
        
    }
    
    public static void main (String[] args)
    {
        int[][] board = 
            {{110 , 5   , 112 , 113 ,  114}  ,  
             {210 , 211 , 5   , 213 ,  214}  ,  
             {310 , 311 , 3   , 313 ,  314}  ,  
             {410 , 411 , 412 , 5   ,  414}  ,  
             {5   , 1   , 512 , 3   ,  3}  ,  
             {610 , 4   , 1   , 613 ,  614}  ,  
             {710 , 1   , 2   , 713 ,  714}  ,  
             {810 , 1   , 2   , 1   ,  1}  ,  
             {1   , 1   , 2   , 2   ,  2}  ,  
             {4   , 1   , 4   , 4   ,  1014}};
        
        CandyCrush c = new CandyCrush();
        c.candyCrush(board);
    }
    
    
    
   // https://leetcode.com/discuss/interview-question/309064/google-phone-interview-remove-repeating-numbers
   /* 
    method 1 : using List<stacks>. for each threes, double the count of stack
     => T=> O(n^2/3) => slightly better than o(n^2)
        S => for every threes we double the stack. worst case, for 9 threes' (len =27), 
        we will have => len*2/3 stacks and each stack will have 1,2,3,4,5..n len => (n*(n-1)/2=> O(2N/3 + (n)(N-1)/2) => O(N^2) 
    
    
    method 2: Using dfs
        312221112231122211123
        => 31212312123  => create List<Pair[]> => {num,count}
           11332123311
        
        for(i=0 to list.length)
        {
            if count >=k 
                check adjacent, if same number, then 
                    ignore those pairs too. 
                    
                recursively call the method without the pair.
        }
        
        O(2^(N/3))
    
    */
    
}
