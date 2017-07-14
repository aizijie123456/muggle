package org.com.thread.t6;

public class InterruptThread extends Thread {

	@Override
	public void run() {
		for(int i=0;i<50000;i++){
			System.out.println("i="+i);
		}
	}
	
}
