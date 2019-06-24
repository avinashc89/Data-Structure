package com.tool.java.leetcode;

import java.util.*;

public class LoggerRateLimiter
{
    
    class Logger {

        Map<String,Integer> messageMap;
        /** Initialize your data structure here. */
        public Logger() {
            messageMap = new HashMap<String,Integer>();
        }
        
        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
            If this method returns false, the message will not be printed.
            The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if(!messageMap.containsKey(message) || (timestamp - messageMap.get(message))>=10)
            {
                messageMap.put(message,timestamp);
                return true;
            }
                
            return false;
        }
    }

}
