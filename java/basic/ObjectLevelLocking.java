
public class ObjectLevelLocking{
	
	public static void main(String[] args) {
		
		Avinash obj = new Avinash();
		Thread t1 = new Thread(obj,"--t1");
		Thread t2 = new Thread(obj,"--t2");
		t1.start();
		t2.start();
	}
}


class Avinash implements Runnable
{
	TestNonStaticLocking test = new TestNonStaticLocking();
	@Override
	public void run() {
		test.testSyncBlockByLockClass();
	}
}



class TestNonStaticLocking
{

	final static MyLockingClass cObj = new MyLockingClass(); 

	public synchronized void testSyncMethod(){
		System.out.println("inside testSyncMethod"+Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("exit testSyncMethod"+Thread.currentThread().getName());
	}


	public void testSyncBlockThis(){
		System.out.println("inside testSyncBlockThis"+Thread.currentThread().getName());
		synchronized(this){
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

	public void testSyncBlockByLockClass(){
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


class MyLockingClass
{
	private int lockId;
}



