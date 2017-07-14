package org.com.thread.t1;

public class ThreadIvk {

	public static void main(String[] args) {
		ThreadExt thread1 = new ThreadExt();
		thread1.setName("myThread");
		thread1.run();
		for(int i=0;i<10;i++){
			int time = (int)(Math.random()*1000);
			try {
				Thread.sleep(time);
				System.out.println("run-"+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
