package race_condition;

public class TestRaceCondition implements Runnable {
	
	//the initialized inventory variable
	private int inventory = 1;

	public static void main(String[] args) {
		TestRaceCondition prc = new TestRaceCondition();
		Thread firstThread = new Thread(prc, "First thread");
		Thread secondThread = new Thread(prc, "Second thread");
		firstThread.start();
		secondThread.start();
	}

	public void run() {
		
		//two thread are executing the same critical section but the decrement happens two times because 
		
		//synchronized (this) {
			if (inventory > 0) {
				try {
					System.out.println("Thread " + Thread.currentThread().getName() + " starting with inventory: " + inventory);
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// no op
				}
				inventory--;
				System.out.println("Thread " + Thread.currentThread().getName() + " leaving with inventory: " + inventory);
			} else { System.out.println("Need to backorder! Thread " + Thread.currentThread().getName()
						+ " found inventory with: " + inventory);
			}
		//}

	}
}
