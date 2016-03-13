
public class ClassLevelLocking{
	
	public static void main(String[] args) {
		
		Avinash2 obj = new Avinash2();
		Shriram2 obj3 = new Shriram2();
		
		obj.start();
		obj3.start();
	}
}


class Avinash2 extends Thread
{
	@Override
	public void run() {
		TestNonStaticLocking2.testSyncBlockThis();
	}
}

class Shriram2 extends Thread
{
	TestNonStaticLocking2 obj = new TestNonStaticLocking2();
	@Override
	public void run() {
		obj.testSyncMethod();
	}
}



class TestNonStaticLocking2
{

	final static MyLockingClass2 cObj = new MyLockingClass2(); 

	public static synchronized void testSyncMethod(){
		System.out.println("inside testSyncMethod"+Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("exit testSyncMethod"+Thread.currentThread().getName());
	}


	public static void testSyncBlockThis(){
		System.out.println("inside testSyncBlockThis"+Thread.currentThread().getName());
		synchronized(TestNonStaticLocking2.class){
			System.out.println("locked by this"+Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("exit testSyncBlockThis"+Thread.currentThread().getName());
	}

//	public void testSyncBlockByLockLocal(){
//		System.out.println("inside testSyncBlockByLockLocal"+Thread.currentThread().getName());
//		MyLockingClass obj = new MyLockingClass(); 
//		synchronized(obj){
//			System.out.println("locked by MyLockingClass local level object"+Thread.currentThread().getName());
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println("exit testSyncBlockByLockLocal"+Thread.currentThread().getName());
//	}

	public static void testSyncBlockByLockClass(){
		System.out.println("inside testSyncBlockByLockClass"+Thread.currentThread().getName());
		synchronized(cObj){
			System.out.println("locked by MyLockingClass class level object"+Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("exit testSyncBlockByLockClass"+Thread.currentThread().getName());
	}


	
}


class MyLockingClass2
{
	private int lockId;
}



