package org.com.thread.t6;

public class TestMyThread {

	public static void main(String[] args) throws InterruptedException {
		Thread mythread = new Mythread();
		mythread.start();
		Thread.sleep(200);
		mythread.interrupt();
		System.out.println("end");
	}
}
