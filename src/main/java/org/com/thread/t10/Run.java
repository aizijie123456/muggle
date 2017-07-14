package org.com.thread.t10;

public class Run {

	public static void main(String[] args) {
		Service service = new Service();
		ThreadA a = new ThreadA(service);
		ThreadB b = new ThreadB(service);
		a.setName("A");
		b.setName("B");
		a.start();
		b.start();
	}

}
