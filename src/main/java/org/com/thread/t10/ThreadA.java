package org.com.thread.t10;

public class ThreadA extends Thread {
	private Service service;
	
	public ThreadA(Service service){
		this.service = service;
	}

	@Override
	public void run() {
		service.setUserNamePassword("A","aa");
	}
}
