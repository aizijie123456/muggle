package org.com.thread.c3.t4;

public class Run {

	public static void main(String[] args) {
		
		MyStack myStack = new MyStack();
		
		P p = new P(myStack);
		Thread tp = new Thread(p);

		
		C c1 = new C(myStack);
		Thread t1 = new Thread(c1);
		C c2 = new C(myStack);
		Thread t2 = new Thread(c2);
		C c3 = new C(myStack);
		Thread t3 = new Thread(c3);
		C c4 = new C(myStack);
		Thread t4 = new Thread(c4);
		C c5 = new C(myStack);
		Thread t5 = new Thread(c5);
		
		tp.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
	}
}
