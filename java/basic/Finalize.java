package com.tool.java.basic;

public class Finalize {
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
        for(int i=1;i<=3;i++)
        {
            new Thread(new TryCatchFinallyTest()).start();
            Runtime.runFinalizersOnExit(true);             // to call finalise method explicitly.
            
            //Runtime.getRuntime().runFinalization();   //another method . it only guarantees that GC will make best efforts.
            
            /*
             * 
             * “This method is inherently unsafe. It may result in finalizers being called on live objects while other 
             * 	threads are concurrently manipulating those objects, resulting in erratic behavior or deadlock.”
			 * So, in one way we can not guarantee the execution and in another way we the system in danger. Better, don’t use it.
             *
             */
        }
    }

}

class TryCatchFinallyTest implements Runnable {
	 
    private void testMethod() throws InterruptedException
    {
        try
        {
            System.out.println("In try block");
            throw new NullPointerException();
        }
        catch(NullPointerException npe)
        {
            System.out.println("In catch block");
        }
        finally
        {
            System.out.println("In finally block");
        }
    }
 
    @Override
    protected void finalize() throws Throwable {
        System.out.println("In finalize block");
        super.finalize();
    }
 
    @Override
    public void run() {
        try {
            testMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 
 * output:
 * 
 In try block
 In catch block
 In finally block
 In try block
 In try block
 In catch block
 In finally block
 In catch block
 In finally block
 In finalize block
 In finalize block
 In finalize block
 * 
 * /
 */

/**
 * 
 *		Reasons for not using finalise:
 *		
 *		1) finalize() methods do not work in chaining like constructors. 
 *		It means like when you call a constructor then constructors of all super classes will be invokes implicitly. 
 *		But, in case of finalize methods, this is not followed. Super class’s finalize() should be called explicitly.
 *		Suppose, you created a class and wrote its finalize method with care. Someone comes and extend your class and does not call super.finalize() in subclass’s finalize() block, then super class’s finalize() will never be invoked anyhow.
 *		
 *		2) Any Exception thrown by finalize method is ignored by GC thread and it will not be propagated further, 
 *		in fact it will not be logged in your log files.
 * 
 * /
 */