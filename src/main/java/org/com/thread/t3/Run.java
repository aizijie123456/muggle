package org.com.thread.t3;

public class Run {

	public static void main(String[] args) {
		Runnable run1 = new MyRunnable();
		Thread thread = new Thread(run1);
		thread.start();
	}

}
