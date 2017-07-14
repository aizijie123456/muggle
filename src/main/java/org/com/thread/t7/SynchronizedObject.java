package org.com.thread.t7;

public class SynchronizedObject {
	int i = 0;
	public void methodA() {
		System.out.println("执行方法A:" + Thread.currentThread().getName());
		synchronized (this) {
			try {
				Thread.sleep(5000);
				this.jisuan();
				System.out.println("A睡醒了结束:"+Thread.currentThread().getName()+"计算:"+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void methodB() {
		System.out.println("执行方法B:" + Thread.currentThread().getName());

		synchronized (this) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("B睡醒了结束"+Thread.currentThread().getName());
		}
	}
	
	private void jisuan(){
		i++;
	}
}
