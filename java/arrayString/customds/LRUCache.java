package com.tool.java.arrayString.customds;

import java.util.HashMap;

class MapNode{
    int key;
    int value;
    MapNode prev;
    MapNode next;
 
    public MapNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}

//most recently will always move to head 
// least recently used can be fetched from end
public class LRUCache {
    int capacity;
    HashMap<Integer, MapNode> map = new HashMap<Integer, MapNode>();
    MapNode head=null;
    MapNode end=null;
 
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
 
    public int get(int key) {
        if(map.containsKey(key)){
            MapNode n = map.get(key);
            delete(n);
            setHead(n);
            return n.value;
        }
 
        return -1;
    }
 
    /*This method will delete node*/
    public void delete(MapNode node){
        if(node.prev!=null){
            node.prev.next = node.next;
        }else{
            head = node.next;
        }
 
        if(node.next!=null){
            node.next.prev = node.prev;
        }else{
            end = node.prev;
        }
 
    }
 
    /*This method will make passed node as head*/
    public void setHead(MapNode node){
        node.next = head;
        node.prev = null;
 
        if(head!=null)
            head.prev = node;
 
        head = node;
 
        if(end ==null)
            end = head;
    }
 
    public void set(int key, int value) {
        if(map.containsKey(key)){
            // update the old value
            MapNode old = map.get(key);
            old.value = value;
            delete(old);
            setHead(old);
        }else{
            MapNode newNode = new MapNode(key, value);
            if(map.size()>=capacity){
                
                map.remove(end.key);
                // remove last node
                delete(end);
                setHead(newNode);
 
            }else{
                setHead(newNode);
            }    
 
            map.put(key, newNode);
        }
    }   
    
    public static void main(String[] args) throws java.lang.Exception {
        LRUCache lrucache = new LRUCache(4);
        lrucache.set(1, 100);
        lrucache.set(10, 99);
        lrucache.set(15, 98);
        lrucache.set(10, 97);
        lrucache.set(12, 96);
        lrucache.set(18, 95);
        lrucache.set(1, 94);
 
        System.out.println(lrucache.get(1));
        System.out.println(lrucache.get(10));
        System.out.println(lrucache.get(15));
 
    }
}
 