package org.com.thread.t11;

public class Run {

	public static void main(String[] args) {
		Service service = new Service();
		ThreadA a = new ThreadA(service);
		a.setName("A Thread");
		ThreadB b = new ThreadB(service);
		b.setName("B Thread");
		a.start();
		b.start();
	}

}
