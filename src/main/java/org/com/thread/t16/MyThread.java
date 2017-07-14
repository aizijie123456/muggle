package org.com.thread.t16;

public class MyThread extends Thread {
	 public static int count = 0;

	private static void addCount() {
		for (int i = 0; i < 100; i++) {
			count++;
		}
		System.out.println("count = "+ count);
	}

	@Override
	public void run() {
		addCount();
	}
}
