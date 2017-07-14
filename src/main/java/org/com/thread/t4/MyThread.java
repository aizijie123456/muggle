package org.com.thread.t4;

public class MyThread extends Thread {
	private int count = 5;

	@Override
	synchronized public void run() {
		super.run();
		count--;
		System.out.println("Thread-" + Thread.currentThread().getId() + "计算：" + count);

	}

}
