package org.com.thread.c3.t1;

public class ThreadB extends Thread {
	private MyList list;

	public ThreadB(MyList list) {
		this.list = list;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(500);
				if (list.getSize() == 5) {
					System.out.println("====5了,线程要退出了");
					throw new InterruptedException();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
