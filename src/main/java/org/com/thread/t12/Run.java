package org.com.thread.t12;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		DealThread d1 = new DealThread();
		Thread t1 = new Thread(d1);
		d1.setFlag("a");
		t1.start();
		Thread.sleep(1000);
		
		Thread t2 = new Thread(d1);
		d1.setFlag("b");
		t2.start();
	}

}
