package org.com.thread.c3.t2;

public class ThreadB extends Thread {

	private MyList list;

	public ThreadB(MyList list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		synchronized (list) {
			for (int i = 0; i < 200; i++) {
				list.add();
				if (list.size() == 15) {
					System.out.println("发出通知开始" + System.currentTimeMillis());
					list.notify();
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("添加了"+i+"元素");
			}

		}
	}

}
