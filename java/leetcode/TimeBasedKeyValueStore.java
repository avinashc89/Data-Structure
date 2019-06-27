package com.tool.java.leetcode;

import java.util.*;

public class TimeBasedKeyValueStore
{
    HashMap<String,ArrayList<TimeValueNode>> map ;
    public TimeBasedKeyValueStore() {
        map = new HashMap<String,ArrayList<TimeValueNode>>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        if(map.containsKey(key))
        {
            int index = binaryInsert(map.get(key), timestamp);
            map.get(key).add(index,new TimeValueNode(value,timestamp));
        }
        else{
            ArrayList<TimeValueNode> nodes = new ArrayList<TimeValueNode>();
            nodes.add(new TimeValueNode(value,timestamp));
            map.put(key, nodes);
        }
    }
    
    public String get(String key, int timestamp) {
        
        if(!map.containsKey(key)){
            return "";
        } 
        ArrayList<TimeValueNode> set = map.get(key);
        int index = binarySearch(set, timestamp);
        if(index==-1)
            return "";
        return set.get(index).value;
    }
    
    int binarySearch(ArrayList<TimeValueNode> list, int ts) 
    { 
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if(list.get(mid).timestamp == ts)
                return mid;
            if(list.get(mid).timestamp > ts)
                high = mid - 1;
            else
                low =  mid+1;
        }
        return low-1;
    } 
    
    int binaryInsert(ArrayList<TimeValueNode> list, int ts) 
    { 
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if(list.get(mid).timestamp == ts)
                return mid;
            if(list.get(mid).timestamp > ts)
                high = mid - 1;
            else
                low =  mid+1;
        }
        return low;
    } 
    
    public static void main (String[] args)
    {
        TimeBasedKeyValueStore kv = new TimeBasedKeyValueStore();
        kv.set("foo", "bar", 1);
        System.out.println(kv.get("foo", 1));
        System.out.println(kv.get("foo", 3));
        kv.set("foo", "bar2", 4); 
        System.out.println(kv.get("foo", 4));
        System.out.println(kv.get("foo", 5));
    }

}
class TimeValueNode
{
    String value;
    int timestamp;
    public TimeValueNode(String v,int ts)
    {
        value=v;
        timestamp =ts;
    }
    
    @Override
    public String toString ()
    {
        // TODO Auto-generated method stub
        return value+","+timestamp;
    }
}