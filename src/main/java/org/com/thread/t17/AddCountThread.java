package org.com.thread.t17;

import java.util.concurrent.atomic.AtomicInteger;

public class AddCountThread extends Thread {
	private AtomicInteger count = new AtomicInteger(0);
	//private int count = 0;
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName()+"  "+count.incrementAndGet());
			//System.out.println(Thread.currentThread().getName()+"  "+ count++);
		}
	}
}
