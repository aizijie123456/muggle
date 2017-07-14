package org.com.thread.c3.t9;

import java.lang.Thread.UncaughtExceptionHandler;

public class Run {

	public static void main(String[] args) {
		MyThread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("线程："+t.getName() + "出现了异常");
				//e.printStackTrace();
			}
		});
		
		MyThread t1 = new MyThread();
		t1.setName("线程1");
		t1.start();
		
		MyThread t2 = new MyThread();
		t2.setName("线程2");
		t2.start();
	}
	
}
