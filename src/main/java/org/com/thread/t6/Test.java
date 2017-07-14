package org.com.thread.t6;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		InterruptThread it = new InterruptThread();
		it.start();
		Thread.sleep(20);
		it.interrupt();
	}

}
