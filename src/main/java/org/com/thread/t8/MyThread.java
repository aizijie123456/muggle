package org.com.thread.t8;

public class MyThread extends Thread {

	@Override
	public void run() {
		Service service = new Service();
		service.service1();
	}

}
