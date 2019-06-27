package com.tool.java.leetcode;

import java.util.ArrayList;

class HashNode<K, V> 
{ 
    K key; 
    V value; 
    HashNode<K, V> next; 
  
    public HashNode(K key, V value) 
    { 
        this.key = key; 
        this.value = value; 
    } 
} 
  
class CustomMap<K, V> 
{ 
    // list is used to store array of chains 
    private ArrayList<HashNode<K, V>> list; 
  
    // Current capacity of array list 
    private int capacity; 
  
    // Current size of array list 
    private int size; 
  
    // Constructor (Initializes capacity, size and 
    // empty chains. 
    public CustomMap() 
    { 
        list = new ArrayList<>(); 
        capacity = 10; 
        size = 0; 
  
        // Create empty chains 
        for (int i = 0; i < capacity; i++) 
            list.add(null); 
    } 
  
    public int size() { return size; } 
    public boolean isEmpty() { return size() == 0; } 
  
    // This implements hash function to find index 
    // for a key 
    private int getIndex(K key) 
    { 
        int hashCode = key.hashCode(); 
        int index = hashCode % capacity; 
        return  Math.abs(index); 
    } 
  
    // Method to remove a given key 
    public V remove(K key) 
    { 
        // Apply hash function to find index for given key 
        int index = getIndex(key); 
  
        // Get head of chain 
        HashNode<K, V> head = list.get(index); 
  
        // Search for key in its chain 
        HashNode<K, V> prev = null; 
        while (head != null) 
        { 
            // If Key found 
            if (head.key.equals(key)) 
                break; 
  
            // Else keep moving in chain 
            prev = head; 
            head = head.next; 
        } 
  
        // If key was not there 
        if (head == null) 
            return null; 
  
        // Reduce size 
        size--; 
  
        // Remove key 
        if (prev != null) 
            prev.next = head.next; 
        else
            list.set(index, head.next); 
  
        return head.value; 
    } 
  
    // Returns value for a key 
    public V get(K key) 
    { 
        // Find head of chain for given key 
        int index = getIndex(key); 
        HashNode<K, V> head = list.get(index); 
  
        // Search key in chain 
        while (head != null) 
        { 
            if (head.key.equals(key)) 
                return head.value; 
            head = head.next; 
        } 
  
        // If key not found 
        return null; 
    } 
  
    // Adds a key value pair to hash 
    public void add(K key, V value) 
    { 
        // Find head of chain for given key 
        int index = getIndex(key); 
        HashNode<K, V> node = list.get(index); 
  
        // Check if key is already present 
        while (node != null) 
        { 
            if (node.key.equals(key)) 
            { 
                node.value = value; 
                return; 
            } 
            node = node.next; 
        } 
  
        // Insert key in chain 
        size++; 
        node = list.get(index); 
        HashNode<K, V> newNode = new HashNode<K, V>(key, value); 
        newNode.next = node; 
        list.set(index, newNode); 
  
        // If load factor goes beyond threshold, ie., 70% filled
        // double hash table size 
        if (size/capacity >= 0.7) 
        { 
            ArrayList<HashNode<K, V>> temp = list; 
            list = new ArrayList<>(); 
            capacity = 2 * capacity; 
            size = 0; 
            for (int i = 0; i < capacity; i++) 
                list.add(null); 
  
            for (HashNode<K, V> headNode : temp) 
            { 
                while (headNode != null) 
                { 
                    add(headNode.key, headNode.value); 
                    headNode = headNode.next; 
                } 
            } 
        } 
    } 
  
    // Driver method to test Map class 
    public static void main(String[] args) 
    { 
        CustomMap<String, Integer>map = new CustomMap<>(); 
        map.add("this",1 ); 
        map.add("coder",2 ); 
        map.add("this",4 ); 
        map.add("hi",5 ); 
        System.out.println(map.size()); 
        System.out.println(map.remove("this")); 
        System.out.println(map.remove("this")); 
        System.out.println(map.size()); 
        System.out.println(map.isEmpty()); 
    } 
} 