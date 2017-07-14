package org.com.thread.t5;

public class CountOperation extends Thread {
	public CountOperation(){
		System.out.println("CountOperation - begin");
		System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
		System.out.println("this.getName()="+this.getName());
		System.out.println("CountOperation - end");
	}

	@Override
	public void run() {
		System.out.println("run-begin");
		System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
		System.out.println("this.getName()="+this.getName());
		System.out.println("run-end");
	}
	
}
