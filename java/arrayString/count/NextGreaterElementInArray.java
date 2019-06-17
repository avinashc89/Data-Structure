package com.tool.java.arrayString.count;

import java.util.Stack;

public class NextGreaterElementInArray
{
    
    /*
    0. push the first num in stack and start the iteration from i=1
    1. while the stack is not empty and the current element is greater than top element of the stack, 
            this is the next greater element of the top element.
            pop elements from the stack and print it with the next greater element as input[i]
       if the current element is smaller than top element of the stack 
            just push input[i] to stack
    2. Repeat steps 1 till the end of array is reached.
    
    3. Finally pop remaining elements from the stack and print null for them.
    
    Please note that at any instance, the stack will always be in sorted order having least element at the top and largest element at the bottom.
     */
    
    public static void printNextGreaterElement(int[] input) {
        Stack<Integer> stack = new Stack<Integer>();
        int inputSize = input.length;
        stack.push(input[0]);
        for (int i = 1; i < inputSize; i++) {
            while (!stack.isEmpty() && stack.peek() < input[i]) {
                System.out.println("Next greater element for "
                                    + stack.pop() + "\t = " + input[i]);
            }
            stack.push(input[i]);
        }
        while (!stack.isEmpty()) {
            int top = (int) stack.pop();
            System.out.println("Next greater element for " + top + "\t = " + null);
        }
    }
 
    public static void main(String[] args) {
        int[] input = { 98, 23, 54, 12, 20, 7, 27 };
        printNextGreaterElement(input);
    }

}
