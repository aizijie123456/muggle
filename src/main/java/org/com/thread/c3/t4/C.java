package org.com.thread.c3.t4;

public class C extends Thread {

	private MyStack stack ;
	
	public C(MyStack stack) {
		super();
		this.stack = stack;
	}

	@Override
	public void run() {
		while (true) {
			stack.pop();
		}
	}

}
