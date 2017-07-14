package org.com.thread.c3.t8;

public class MyThread extends Thread {
	private MyService myService;

	public MyThread(MyService myService) {
		super();
		this.myService = myService;
	}

	@Override
	public void run() {
		myService.testMethod();
	}

}	
