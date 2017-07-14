package org.com.thread.t4;

public class MyThread1 extends Thread {
	
	private int count = 5;
	public MyThread1(String name){
		this.setName(name);
	}
	@Override
	public void run() {
		super.run();
		while(count > 0){
			count --;
			System.out.println("Thread-"+Thread.currentThread().getName()+"计算:"+count);
		}
	}
	
	
}
