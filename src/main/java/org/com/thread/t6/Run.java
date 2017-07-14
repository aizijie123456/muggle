package org.com.thread.t6;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		SynchronizedObject obejct = new SynchronizedObject();
		MyThread2 thread = new MyThread2(obejct);
		thread.start();
		Thread.sleep(500);
		thread.stop();
		System.out.println("结果:"+obejct.getUsername()+"|"+obejct.getPassword());
	}

}
