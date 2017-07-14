package org.com.thread.c3.t6;

public class Run {

	public static void main(String[] args) throws InterruptedException {

		ThreadA a = new ThreadA();
		a.start();
		a.join(2000);
		System.out.println("ThreadMain:"+System.currentTimeMillis());
	}

}
