package org.com.thread.t11;

public class ThreadA extends Thread {
	private Service service;
	
	public ThreadA(Service service){
		this.service = service;
	}

	@Override
	public void run() {
		Service.print("AAAAA");
	}
}
