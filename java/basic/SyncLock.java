package com.tool.java.basic;

public  class SyncLock {

	interface a {}
	interface b extends a{}


	volatile int i=10;
	static int   a =10;
	final int k =10;
	Object lock1 = new Object();
	Object lock2 = new Object();


	public synchronized boolean check1()
	{
		int z = 10;
		return true;
	}


	public  boolean check2()
	{
		int z = 10;
		synchronized (lock1) {
			int j = z+1;
			i = i+1;
		}
		return true;
	}

	public  boolean check3()
	{
		int z = 10;
		synchronized (lock2) {
			int j = z+1;
		}
		return true;
	}

	public void printHello()
	{
		System.out.println("hello");
	}


}


