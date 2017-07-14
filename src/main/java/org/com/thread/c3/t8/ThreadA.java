package org.com.thread.c3.t8;

public class ThreadA extends Thread {

	public ThreadA(){
		System.out.println(Thread.currentThread().getName()+"  " + Thread.currentThread().getState());
	}
	
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"  " + Thread.currentThread().getState());
	}

}
