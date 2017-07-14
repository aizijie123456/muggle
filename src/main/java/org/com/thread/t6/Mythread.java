package org.com.thread.t6;

public class Mythread extends Thread {

	@Override
	public void run() {
		super.run();
		try {
			for (int i = 0; i < 500000; i++) {
				if (Thread.interrupted()) {
					System.out.println("线程已经标记为停止状态，循环退出");
					throw new Exception();
				} else {
					System.out.println("i=" + i);
				}
			}
			System.out.println("我在for下面");
		} catch (Exception e) {
			System.out.println("进入 catch");
		}
	}
}