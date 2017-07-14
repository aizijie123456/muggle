package org.com.thread.c3.t3;

public class P {
	private String lock;

	public P(String lock) {
		this.lock = lock;
	}

	public void setValue() {
		try {
			synchronized (lock) {
				if (!ValueObject.value.equals("")) {
					System.out.println("生产者:"+Thread.currentThread().getName()+" waiting .*.*.*");
					lock.wait();
				}
				System.out.println("生产者:"+Thread.currentThread().getName()+"runnable");
				String value = System.currentTimeMillis()+"_"+System.nanoTime();
				ValueObject.value = value;
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
