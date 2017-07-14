package org.com.thread.c3.t2;

public class ThreadA extends Thread {

	private MyList list;
	
	public ThreadA(MyList list) {
		super();
		this.list = list;
	}


	@Override
	public void run() {
		synchronized (list) {
			if(list.size() != 5){
				System.out.println("等待开始" + System.currentTimeMillis());
				try {
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("等待结束" + System.currentTimeMillis());
			}
		}
	}

}
