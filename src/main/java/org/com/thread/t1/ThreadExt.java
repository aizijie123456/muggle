package org.com.thread.t1;

public class ThreadExt extends Thread {

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			int time = (int)(Math.random()*1000);
			try {
				Thread.sleep(time);
				System.out.println("run1-"+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}
