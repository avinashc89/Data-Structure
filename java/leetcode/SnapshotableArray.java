package com.tool.java.leetcode;

import java.util.*;

/**
 * The idea is to save the changes between snapshots which track what the previous
 * value of the element at the index was in the previous array.
 * Only need to take edits of elements that change between snapshots to save space.
 * To recover a previous snapshot's value, walk back over the previous snapshots' edits
 * until you get to the desired snapshot. While you walk back, change the value to what it was.
 */
public class SnapshotableArray {
    private final int[] arr;
    private final Map<Integer, List<Edit>> snapshots;
    private final List<Edit> edits;
    private int snapshotId = 0;

    public SnapshotableArray(int size) {
        this(new int[size]);
    }

    public SnapshotableArray(int[] arr) {
        this.arr = arr;
        this.snapshots = new HashMap<>();
        this.edits = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            edits.add(new Edit(i, arr[i], arr[i]));
        }
    }

    /**
     * set's array at index to value
     */
    public void set(int index, int value) {
        validate(index);
        edits.add(new Edit(index, arr[index], value));
        this.arr[index] = value;
    }

    /**
     * return the array at index's value
     */
    public int get(int index) {
        validate(index);
        return this.arr[index];
    }

    /**
     * take a snapshot and return the handle/id of it
     */
    public int takeSnapshot() {
        snapshots.put(snapshotId, new ArrayList<>(edits));
        edits.clear();
        return snapshotId++;
    }

    /**
     * return the array at index's value for the given snapshot, represented by id
     */
    public int getSnapshotValue(int id, int index) {
        validate(index);
        if (!snapshots.containsKey(id)) throw new IllegalArgumentException("Invalid snapshot id");
        int[] copy = arr.clone();

        // revert unsaved changes since last snapshot
        revertEdits(copy, edits);

        //snapshotId = 50; we have done current revert. so start from 49, if id =25, we need to get the 
        // revert saved changes until we get to the desired snapshot
        for (int currId = snapshotId - 1; currId > id; currId--) {
            revertEdits(copy, snapshots.get(currId));
        }

        // apply changes from the target snapshot
        for (Edit edit : snapshots.get(id)) {
            copy[edit.index] = edit.newValue;
        }

        return copy[index];
    }

    private void revertEdits(int[] copy, List<Edit> toRevert) {
        for (int i = toRevert.size() - 1; i >= 0; i--) {
            Edit edit = toRevert.get(i);
            copy[edit.index] = edit.prevValue;
        }
    }

    private void validate(int index) {
        if (index < 0 || index >= arr.length) throw new IllegalArgumentException();
    }

    private static class Edit {
        int index;
        int prevValue;
        int newValue;

        public Edit(int index, int prevValue, int newValue) {
            this.index = index;
            this.prevValue = prevValue;
            this.newValue = newValue;
        }
    }
    
    
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < code.length();)
        {
            if(i>0 && stack.isEmpty()) 
                return false;
            if(code.startsWith("<![CDATA[", i))
            {
                int j = i+9;
                i = code.indexOf("]]>", j);
                if(i < 0) return false;
                i += 3;
            }else if(code.startsWith("</", i))
            {
                int j = i + 2;
                i = code.indexOf('>', j);
                if(i < 0 || i == j || i - j > 9) 
                    return false;
                for(int k = j; k < i; k++){
                    if(!Character.isUpperCase(code.charAt(k))) 
                        return false;
                }
                String s = code.substring(j, i++);
                if(stack.isEmpty() || !stack.pop().equals(s)) 
                    return false;
            }else if(code.startsWith("<", i))
            {
                int j = i + 1;
                i = code.indexOf('>', j);
                if(i < 0 || i == j || i - j > 9) 
                    return false;
                for(int k = j; k < i; k++)
                {
                    if(!Character.isUpperCase(code.charAt(k))) 
                        return false;
                }
                String s = code.substring(j, i++);
                stack.push(s);
            }else{
                i++;
            }
        }
        return stack.isEmpty();
    }
}