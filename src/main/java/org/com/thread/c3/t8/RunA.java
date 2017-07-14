package org.com.thread.c3.t8;

public class RunA {

	public static void main(String[] args) throws InterruptedException {
		ThreadA ta = new ThreadA();
		System.out.println(" threadA " + ta.getState());
		Thread.sleep(1000);
		ta.start();
		Thread.sleep(1000);
		System.out.println(" threadA " + ta.getState());

	}

}
