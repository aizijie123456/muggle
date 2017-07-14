package org.com.thread.t16;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		
		RunThread runThread = new RunThread();
		runThread.start();
		runThread.sleep(1000);
		runThread.setRunning(false);
		System.out.println("线程已经赋值 false");
		
	}

}
