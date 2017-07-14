package org.com.thread.c3.t2;

public class Test {

	public static void main(String[] args) {
		MyList list = new MyList();
		ThreadA a = new ThreadA(list);
		ThreadB b = new ThreadB(list);
		a.start();
		b.start();
	}

}
