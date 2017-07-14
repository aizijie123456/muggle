package org.com.thread.c3.t1;

public class Test {

	public static void main(String[] args) {
		MyList service = new MyList();
		ThreadA ta = new ThreadA(service);
		ThreadB tb = new ThreadB(service);
		ta.setName("a");
		ta.start();
		
		
		tb.setName("b");
		tb.start();
		
	}

}
