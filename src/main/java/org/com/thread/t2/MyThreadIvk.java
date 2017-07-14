package org.com.thread.t2;

public class MyThreadIvk {

	public static void main(String[] args) {
		MyThread t1 = new MyThread(1);
		t1.start();
		MyThread t2 = new MyThread(2);
		t2.start();
		MyThread t3 = new MyThread(3);
		t3.start();
		MyThread t4 = new MyThread(4);
		t4.start();
		MyThread t5 = new MyThread(5);
		t5.start();
		MyThread t6 = new MyThread(6);
		t6.start();
		MyThread t7 = new MyThread(7);
		t7.start();
		MyThread t8 = new MyThread(8);
		t8.start();
		MyThread t9 = new MyThread(9);
		t9.start();
		MyThread t10 = new MyThread(10);
		t10.start();
	}

}
