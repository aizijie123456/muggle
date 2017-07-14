package org.com.thread.c3.t4;

public class P extends Thread {

	private MyStack stack ;
	
	public P(MyStack stack) {
		super();
		this.stack = stack;
	}

	@Override
	public void run() {
		while (true) {
			stack.push();
		}
	}

}
