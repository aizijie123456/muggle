package org.com.thread.c3.t9;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {

	private AtomicInteger i ;
	
	@Override
	public void run() {
		String str = null;
		System.out.println(str.hashCode());
	}
	
}
