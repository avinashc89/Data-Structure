package com.tool.java.programcreek.array;


class Elem{
    public int value;
    public int min;
    public Elem next;
    public Elem(int value, int min){
        this.value = value;
        this.min = min;
    }
}

public class A_33_MinStack {
    public Elem top;
 
    public void push(int x) {
        if(top == null){
            top = new Elem(x, x);			//if no elements were added, then min would be same as elem
        }else{
            Elem e = new Elem(x, Math.min(x,top.min)); //compare elem with top's min
            e.next = top;
            top = e;
        }
    }
 
    public void pop() {
        if(top == null)
            return;
        Elem temp = top.next;
        top.next = null;
        top = temp;
    }
 
    public int top() {
        if(top == null)
            return -1;
        return top.value;
    }
 
    public int getMin() {
        if(top == null)
            return -1;
        return top.min;
    }
}

//Approach2: we can keep a separate stack to track the min. if first elem, add element to s1 and min to s2. for next number, compare elem with s2.top.. WHen popping elem, pop from s1 & s2
//Approach3: optimizing the stack space in Approach 2 : no need to add the min to s2 when it doesn't change. when poping elemnt, check if s2.top = s1.top then pop from both. else pop frpm s1
