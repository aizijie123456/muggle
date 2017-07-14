package org.com.thread.t4;

public class Test {

	public static void main(String[] args) {
		MyThread thread = new MyThread();
		Thread a = new Thread(thread,"A");
		Thread b = new Thread(thread,"B");
		Thread c = new Thread(thread,"C");
		Thread d = new Thread(thread,"D");
		Thread e = new Thread(thread,"E");
		
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
		
	}
}
