package com.tool.java.basic;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreeWaysToCreateThread {

}


//1: By extending thread class
class MyClass3 extends Thread{
	 
    @Override
    public void run() {
        System.out.println("Thread created by extending thread class");
    }
}
class MainClass3 {
 
    public static void main(String[] args) {
 
        MyClass3 thread = new MyClass3();
        thread.start();
    }
 
}


//2: By using Executor framework
class MyClass1 implements Runnable{
	 
  @Override
  public void run() {
      System.out.println("Thread created by implementing Runnable interface");
  }
}
class MainClass1 {

  public static void main(String[] args) {
      Thread thread = new Thread(new MyClass1());
      thread.start();
  }

}

//3: By implementing Runnable interface
class MyClass2 implements Runnable{
 
    @Override
    public void run() {
        System.out.println("Thread created by using Executor Framework");
    }
}
class MainClass2 {
 
    public static void main(String[] args) {
        ExecutorService thread = Executors.newSingleThreadExecutor();
        thread.execute(new MyClass2());
 
//      ExecutorService executor = Executors.newFixedThreadPool(10);
//      ExecutorService executor = Executors.newCachedThreadPool();
    }
 
}
