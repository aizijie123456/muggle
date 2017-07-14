package org.com.thread.t6;

public class MyThread2 extends Thread {
	private SynchronizedObject object;
	public MyThread2(SynchronizedObject object){
		this.object=object;
	}
	@Override
	public void run() {
		this.object.printString("b", "bb");
	}
	
}
