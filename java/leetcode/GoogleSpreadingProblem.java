package com.tool.java.leetcode;

import java.util.*;

public class GoogleSpreadingProblem
{
    /*
        Input array: (Cell A, Cell D)
        This is a representation of the starting graph
        A,5----B,0----E,2
        |      |
        |      |
        D.0----C,-1
        
        Final graph
        A,1----B,1----E,2
        |      |
        |      |
        D.1----C,1
        
        Result from calling:
        A.spread(B)
        B.spread(C)
        C.spread(D)
        or 
        A.spread(D)
        D.spread(C)
        C.spread(B)
        
        this is like there are 5 bacteria. when spreading to next cell, it leaves the one bacteria behind and moves to next.
        Say a cell has -3, means there are 3 resistance. If 10 bacteria comes from spreader. it has to leave 4 behind to make it affected 
        and  go to the next.
        
     */
    
    class Cell {
        // number of points the cell has
        private int points;
        
        // returns the private int points
        int getPoints(){
            return points;
        }

        // returns list of neighbor cells that are children of this cell
        List<Cell> getNeighbors(){
            return null;
        }

        // spreads from this cell to the inputted cell
        // spreading is defined as moving all points from the current cell into a cell that has a value less than 1
        // the result is the spreader has 1 point and the spreadee has (spreader + spreadee - 1) points
        // sometimes cells will have negitive values. 
        // you can only spread to neighboring cells
        void spread(Cell cell)
        {
            
        }
    }

}
