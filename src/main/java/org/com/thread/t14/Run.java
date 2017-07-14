package org.com.thread.t14;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		PringString ps = new PringString();
		//ps.printStringMethid();
		new Thread(ps).start();
		Thread.sleep(5000);
		System.out.println("启动之后要停止运行  thread:"+Thread.currentThread().getName());
		ps.setContinuePrint(false);
	}

}
