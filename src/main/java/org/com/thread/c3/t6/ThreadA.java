package org.com.thread.c3.t6;

import java.util.Random;

public class ThreadA extends Thread {

	@Override
	public void run() {
		try {
			System.out.println("ThreadA:"+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("ThreadA:等待五秒");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		super.run();
	}

}
