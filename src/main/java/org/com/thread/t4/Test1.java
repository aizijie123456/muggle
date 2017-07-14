package org.com.thread.t4;

public class Test1 {

	public static void main(String[] args) {
		Thread a = new MyThread1("A");
		Thread b = new MyThread1("B");
		Thread c = new MyThread1("C");
		a.start();
		b.start();
		c.start();
	}

}
