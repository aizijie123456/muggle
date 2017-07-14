package org.com.thread.t11;

public class ThreadB extends Thread {
	private Service service;
	
	public ThreadB(Service service){
		this.service = service;
	}

	@Override
	public void run() {
		Service.print("AAAAA");
	}
}
