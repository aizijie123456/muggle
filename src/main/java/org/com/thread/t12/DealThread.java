package org.com.thread.t12;

public class DealThread implements Runnable {

	private String userName;
	public Object lock1 = new Object();
	public Object lock2 = new Object();

	public void setFlag(String userName) {
		this.userName = userName;
	}

	@Override
	public void run() {
		if (userName.equals("a")) {
			synchronized (lock1) {
				try {
					System.out.println("thread:" + Thread.currentThread().getId() + "|userName = " + userName);
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("thread:" + Thread.currentThread().getId() + "|按 lock1->lock2 代码顺序执行了");
				}
			}
		}

		if (userName.equals("b")) {
			synchronized (lock2) {
				try {
					System.out.println("thread:" + Thread.currentThread().getId() + "|userName = " + userName);
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock1) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("thread:" + Thread.currentThread().getId() + "|按 lock2->lock1 代码顺序执行了");
				}
			}

		}
	}
}
