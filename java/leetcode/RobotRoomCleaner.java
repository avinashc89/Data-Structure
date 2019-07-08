package com.tool.java.leetcode;

import java.util.*;

public class RobotRoomCleaner
{
    
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        cleanRoomHelper(robot, visited, 0, 0, 0);
    }
    
    //t = 0 , 1 , 2, 3   => 0 means robot moves up. so when dir is 0, we should start the scan 0-1-2-3. 
    //if robot looks right => first iteration would be to go x,y+1. => 1-2-3-0
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};
    
    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    
    private void cleanRoomHelper(Robot robot, Set<String> visited, int i, int j, int t) {
        String pos = i + "," + j;
        robot.clean();
        visited.add(pos);
        for (int k = 0; k < 4; ++k) {
            int z = (t + k) % 4;            //explained above.  https://youtu.be/VQp7pfij7_Q?t=2445
            int x = i + dx[z];
            int y = j + dy[z];
            if (!visited.contains(x + "," + y) && robot.move()) {
                cleanRoomHelper(robot, visited, x, y, z);
                goBack(robot);
            }
            robot.turnRight();
        }
    }

}

interface Robot {
         // Returns true if the cell in front is open and robot moves into the cell.
         // Returns false if the cell in front is blocked and robot stays in the current cell.
         public boolean move();
    
         // Robot will stay in the same cell after calling turnLeft/turnRight.
         // Each turn will be 90 degrees.
         public void turnLeft();
         public void turnRight();
    
         // Clean the current cell.
         public void clean();
     }
